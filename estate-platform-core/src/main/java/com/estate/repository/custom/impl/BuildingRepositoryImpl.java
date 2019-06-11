package com.estate.repository.custom.impl;


import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import com.estate.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building AS b");
        if(builder.getStaffId() != null){
            sql.append(" INNER JOIN staff_building AS sb ON sb.building_id = b.id");
        }
        sql.append(" WHERE 1=1 ");
        sql = buildQueryBuilding(sql, builder);
        if(builder.getStaffId() != null){
            sql.append(" AND sb.staff_id = "+builder.getStaffId()+"");
        }
        Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildQueryBuilding(StringBuilder sql, BuildingBuilder builder) {
        Field[] fields = BuildingBuilder.class.getDeclaredFields();
        for(Field field: fields){
            if(!field.getName().equals("staffName") && !field.getName().equals("typeArrays")&& !field.getName().startsWith("area") && !field.getName().startsWith("cost")){
                String fieldType = field.getType().getName();
                if (fieldType.equals("java.lang.String")) {
                    String value = getValue(field, String.class, builder);
                    if (StringUtils.isNotBlank(value)) {
                        sql.append(" AND LOWER(b." + field.getName() + ") LIKE '%" + value.toLowerCase() + "%'");
                    }
                } else if (fieldType.equals("java.lang.Integer")) {
                    Integer value = getValue(field, Integer.class, builder);
                    if (value != null) {
                        sql.append(" AND b." + field.getName() + " = " + value + "");
                    }
                }
            }
        }
        if (builder.getCostFrom() != null) {
            sql.append(" AND b.rentcost >= " + builder.getCostFrom() + "");
        }
        if (builder.getCostTo() != null) {
            sql.append(" AND b.rentcost <= " + builder.getCostTo() + "");
        }
        if(builder.getTypeArrays().length > 0){
            sql.append(" AND (b.type LIKE '%"+builder.getTypeArrays()[0]+"%'");
            Arrays.stream(builder.getTypeArrays()).filter(item -> !item.equals(builder.getTypeArrays()[0]))
                    .forEach(item -> sql.append(" OR b.type LIKE '%"+item+"%'"));
            sql.append(")");
        }
        if (builder.getAreaTo() != null && builder.getAreaFrom() != null) {
            sql.append(" AND EXISTS (SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) as area ");
            sql.append(" WHERE CAST(area as int) BETWEEN "+builder.getAreaFrom()+" and "+builder.getAreaTo()+") ");
        }
        else if (builder.getAreaFrom() != null && builder.getAreaTo() == null) {
            sql.append(" AND EXISTS (SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) as area ");
            sql.append(" WHERE CAST(area as int) >= "+builder.getAreaFrom()+") ");
        } else if (builder.getAreaFrom() == null && builder.getAreaTo() != null) {
            sql.append(" AND EXISTS (SELECT area FROM UNNEST(string_to_array(b.rentarea, ',')) as area ");
            sql.append(" WHERE CAST(area as int) <= "+builder.getAreaTo()+") ");
        }
        return sql;
    }

    private <T> T getValue(Field field, Class<T> type, BuildingBuilder builder) {
        Object result = null;
        Method getter = getGetter(field, builder);
        if (getter != null) {
            try {
                result = getter.invoke(builder);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {

            }
        }
        return type.cast(result);
    }

    private Method getGetter(Field field, BuildingBuilder builder) {
        String getterMethod = "get" + StringUtils.capitalize(field.getName());
        try {
            return builder.getClass().getMethod(getterMethod);
        } catch (NoSuchMethodException | SecurityException e) {
            return null;
        }
    }


    @Override
    public Long getTotalItems(BuildingBuilder builder) {
        /*//HQL
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM BuildingEntity");
        Query query = entityManager.createQuery(sql.toString());
        return (Long) query.getResultList().get(0);*/

        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM building AS b");
        if(builder.getStaffId() != null){
            sql.append(" INNER JOIN staff_building AS sb ON sb.building_id = b.id");
        }
        sql.append(" WHERE 1=1 ");
        sql = buildQueryBuilding(sql, builder);
        if(builder.getStaffId() != null){
            sql.append(" AND sb.staff_id = "+builder.getStaffId()+"");
        }
        Query query = entityManager.createNativeQuery(sql.toString());
        List<BigInteger> result = query.getResultList();
        return Long.parseLong(result.get(0).toString(), 10);
    }
}
