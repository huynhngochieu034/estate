package com.estate.utils;

import java.util.Map;

public class QueryUtils {

    public static Object[] buildQuery(Map<String, Object> properties) {
        StringBuilder query = new StringBuilder();
        if (properties != null && properties.size() > 0) {
            String[] keys = new String[properties.size()];
            Object[] values = new Object[properties.size()];
            int i = 0;
            for (Map.Entry item: properties.entrySet()) {
                keys[i] = (String) item.getKey();
                values[i] = item.getValue();
                i++;
            }
            for (int i1 = 0; i1 < keys.length; i1++) {
                if (values[i1] instanceof String) {
                    query.append(" AND LOWER("+keys[i1]+") LIKE '%' || :"+keys[i1]+" || '%' ");
                } else if (values[i1] instanceof Integer) {
                    query.append(" AND "+keys[i1]+" =:"+keys[i1]+" ");
                }
            }
            return new Object[]{query, keys, values};
        }
        return new Object[]{query};
    }
}
