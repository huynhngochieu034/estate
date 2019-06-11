<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/building"/>
<html>
<head>
    <title>Chỉnh sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form id="formSubmit" modelAttribute="model">

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên tòa nhà:</label>
                            <div class="col-sm-9">
                                <form:input path="buildingName" cssClass="form-control" id="buildingName"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Quận</label>
                            <div class="col-sm-9">
                                <form:select path="district">
                                    <form:option value="" label="-- Chọn quận --"/>
                                    <form:options items="${districts.values()}" />
                                </form:select>
                            </div>
                        </div>

                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phường:</label>
                            <div class="col-sm-9">
                                <form:input path="ward" cssClass="form-control" id="ward"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Đường:</label>
                            <div class="col-sm-9">
                                <form:input path="street" cssClass="form-control" id="street"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Số tầng hầm:</label>
                            <div class="col-sm-9">
                                <form:input path="basementNumber" cssClass="form-control" id="basementNumber"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích sàn:</label>
                            <div class="col-sm-9">
                                <form:input path="buildingArea" cssClass="form-control" id="buildingArea"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hướng:</label>
                            <div class="col-sm-9">
                                <form:input path="direction" cssClass="form-control" id="direction"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hạng:</label>
                            <div class="col-sm-9">
                                <form:input path="level" cssClass="form-control" id="level"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Diện tích thuê:</label>
                            <div class="col-sm-9">
                                <form:input path="rentArea" cssClass="form-control" id="rentArea"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả diện tích:</label>
                            <div class="col-sm-9">
                                <form:textarea path="descriptionArea" id="descriptionArea" cssStyle="width: 820px;height: 150px"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Giá thuê:</label>
                            <div class="col-sm-9">
                                <form:input path="rentCost" cssClass="form-control" id="rentCost"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả giá:</label>
                            <div class="col-sm-9">
                                <form:input path="descriptionCost" cssClass="form-control" id="descriptionCost"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí dịch vụ:</label>
                            <div class="col-sm-9">
                                <form:input path="serviceCost" cssClass="form-control" id="serviceCost"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <%--<div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí ô tô:</label>
                            <div class="col-sm-9">
                                <form:input path="carCost" cssClass="form-control" id="carCost"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí mô tô:</label>
                            <div class="col-sm-9">
                                <form:input path="motorbikeCost" cssClass="form-control" id="motorbikeCost"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí ngoài giờ:</label>
                            <div class="col-sm-9">
                                <form:input path="overtimeCost" cssClass="form-control" id="overtimeCost"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiền điện:</label>
                            <div class="col-sm-9">
                                    <form:input path="electricityCost" cssClass="form-control" id="electricityCost"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Đặt cọc:</label>
                            <div class="col-sm-9">
                                <form:input path="deposit" cssClass="form-control" id="deposit"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thanh toán:</label>
                            <div class="col-sm-9">
                                <form:input path="pay" cssClass="form-control" id="pay"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thời gian thuê:</label>
                            <div class="col-sm-9">
                                <form:input path="rentTime" cssClass="form-control" id="rentTime"/>
                            </div>
                        </div>
                        </br>
                        </br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thời gian trang trí:</label>
                            <div class="col-sm-9">
                                <form:input path="decorateTime" cssClass="form-control" id="decorateTime"/>
                            </div>
                        </div>
                        </br>
                        </br>--%>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên quản lý:</label>
                            <div class="col-sm-9">
                                <form:input path="managerName" cssClass="form-control" id="managerName"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Số điện thoại quản lý:</label>
                            <div class="col-sm-9">
                                <form:input path="managerPhoneNumber" cssClass="form-control" id="managerPhoneNumber"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phí môi giới:</label>
                            <div class="col-sm-9">
                                <form:input path="brokerageFees" cssClass="form-control" id="brokerageFees"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Loại tòa nhà:</label>
                            <div class="col-sm-9">
                                <table>
                                    <td><form:checkboxes path="typeArrays" items="${types}" element="li" id="checkbox"/></td>
                                </table>
                            </div>
                        </div>
                        </br>
                        </br>
                        </br>
                        </br>


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Ghi chú:</label>
                            <div class="col-sm-9">
                                <form:textarea path="note" id="note" cssStyle="width: 821px;height: 197px"/>

                            </div>
                        </div>
                        </br>
                        </br>
                     <%--   <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Link tòa nhà:</label>
                            <div class="col-sm-9">
                                <form:input path="link" cssClass="form-control" id="link"/>
                            </div>
                        </div>
                        </br>
                        </br>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Bản đồ:</label>
                            <div class="col-sm-9">
                                <form:input path="location" cssClass="form-control" id="location"/>
                            </div>
                        </div>
                        </br>
                        </br>--%>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình đại diện:</label>
                            <div class="col-sm-9">
                                <input type="file" name="file" id="uploadImage"/>
                            </div>
                        </div>
                        </br>
                        </br>


                        <div class="form-group">
                            <div class="row">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button"  class="btn btn-white btn-warning btn-bold" value="Cập nhật tòa nhà" id="btnAddOrUpdateBuilding"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới tòa nhà" id="btnAddOrUpdateBuilding"/>
                                </c:if>
                            </div>
                            </div>
                        </div>
                        <form:hidden path="id" id="buildingId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var base64 ="";
    var imageName="";
    $(document).ready(function () {
        $('#uploadImage').change(function (e) {
            var reader = new FileReader();
            var file = $(this)[0].files[0];
            reader.onload = function (e) {
                base64 =  e.target.result;
                imageName = file.name;
                console.log("ra di base64:"+base64);
                console.log("ra di image:"+imageName);
            };
            reader.readAsDataURL(file);
        })

        $('#btnAddOrUpdateBuilding').click(function (e) {
            e.preventDefault();
            var data = {};
            var typeArray = [];
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i,v) {
                if(v.name == "typeArrays"){
                    typeArray.push(v.value);
                }
                else{
                    data[""+v.name+""] = v.value;
                }

            });
            if(base64 != ''){
                data["base64"] = base64;
                data["imageName"] = imageName;
            }
            data["typeArrays"] = typeArray;
            var buildingId = $('#buildingId').val();
            if (buildingId == "") {
                addBuilding(data);
            } else {
                updateBuilding(data);
            }
        });


    });
    function addBuilding(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=insert_success'/>";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/>";
            }
        });
    }
    function updateBuilding(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(result) {
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=update_success'/>";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/building/edit?id="+result.id+"&message=error_system'/>";
            }
        });
    }

    $("#rentArea").keypress(function (evt) {
        if ((evt.keyCode < 48 || evt.keyCode > 57)) {
            if (evt.keyCode !== 44)
                evt.preventDefault();
        }
    });


</script>
</body>
</html>
