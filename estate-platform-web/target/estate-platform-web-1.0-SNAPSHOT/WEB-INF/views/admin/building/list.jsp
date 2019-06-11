<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formURL" value="/admin/building/list"/>
<c:url var="buildingUrl" value="/api/admin/building"/>
<c:url var="loadUser" value="/api/admin/user"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách tòa nhà</title>
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
                    <a href="<c:url value='/admin/home'/>">Trang chủ</a>
                </li>
                <li class="active">Danh sách tòa nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                </div>
            </div>
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
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form action="${formURL}" modelAttribute="model" id="formSubmit" method="get">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="widget-box table-filter">
                                    <div class="widget-header">
                                        <h4 class="widget-title">Tìm kiếm</h4>
                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <div class="form-horizontal">

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                    <label>Tên tòa nhà</label>
                                                        <div class="fg-line">
                                                            <form:input path="buildingName" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Diện tích sàn</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="buildingArea" class="form-control input-sm" value="${model.buildingArea}" />
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                    <label>Quận hiện có</label>
                                                        <div class="fg-line">
                                                            <form:select path="district">
                                                                <form:option value="" label="-- Chọn quận --"/>
                                                                <form:options items="${districts.values()}" />
                                                            </form:select>
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-4">
                                                        <label>Phường</label>
                                                        <div class="fg-line">
                                                            <form:input path="ward" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Đường</label>
                                                        <div class="fg-line">
                                                            <form:input path="street" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Số tầng hầm</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="basementNumber" class="form-control input-sm" value="${model.basementNumber}" />
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-4">
                                                        <label>Hướng</label>
                                                        <div class="fg-line">
                                                            <form:input path="direction" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Hạng</label>
                                                        <div class="fg-line">
                                                            <form:input path="level" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label>Diện tích từ</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="areaFrom" class="form-control input-sm" value="${model.areaFrom}" />
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-3">
                                                        <label>Diện tích đến</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="areaTo" class="form-control input-sm" value="${model.areaTo}" />
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Giá thuê từ</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="costFrom" class="form-control input-sm" value="${model.costFrom}" />
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Giá thuê đến</label>
                                                        <div class="fg-line">
                                                            <input type="number" name="costTo" class="form-control input-sm" value="${model.costTo}" />
                                                        </div>
                                                    </div>

                                                </div>


                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Tên quản lý</label>
                                                        <div class="fg-line">
                                                            <form:input path="managerName" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-4">
                                                        <label>Điện thoại quản lý</label>
                                                        <div class="fg-line">
                                                            <form:input path="managerPhoneNumber" cssClass="form-control input-sm"/>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Chọn nhân viên phụ trách</label>
                                                        <div class="fg-line">
                                                            <form:select path="staffName">
                                                                <form:option value="" label="-- Chọn nhân viên phụ trách --"/>
                                                                <form:options items="${staff}" />
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <div class="fg-line">
                                                            <form:checkboxes path="typeArrays" items="${types}"/>
                                                        </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <button type="button" class="btn btn-sm btn-success" id="btnSearch">
                                                            Tìm kiếm
                                                            <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <security:authorize ifAnyGranted="ADMIN">
                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip" title="Thêm tòa nhà mới" href='<c:url value="/admin/building/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa tòa nhà">
                                                    <span>
                                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
                                            </security:authorize>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" value="" id="checkAll"/></th>
                                            <th>Ngày</th>
                                            <th>Tên tòa nhà</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lý</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T Sàn</th>
                                            <th>D.T Trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí MG</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"/></td>
                                                <td>${item.createdDate}</td>
                                                <td>${item.buildingName}</td>
                                                <td>${item.street},${item.ward},${item.district}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.managerPhoneNumber}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.descriptionArea}</td>
                                                <td>${item.rentCost}</td>
                                                <td>${item.serviceCost}</td>
                                                <td>${item.brokerageFees}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin/building/edit">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật tòa nhà" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="btn btn-sm btn-primary"
                                                       title="Giao toà nhà"  id="btnAssignBuilding" buildingId="${item.id}">
                                                       <i class="fa fa-tasks" aria-hidden="true"></i>
                                                    </a>
                                                    <c:if test="${item.priority == false}">
                                                        <a class="btn btn-sm btn-primary"
                                                           id="updatePriority" action="insert"
                                                           buildingId="${item.id}"
                                                           title="Thêm vào danh sách ưu tiên" >
                                                            <i class="fa fa-plus" aria-hidden="true"></i>
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${item.priority == true}">
                                                        <a class="btn btn-sm btn-primary"
                                                           id="updatePriority" action="remove"
                                                           buildingId="${item.id}"
                                                           title="Xoá khỏi danh sách ưu tiên" >
                                                            <i class="fa fa-minus" aria-hidden="true"></i>
                                                        </a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <ul id="pagination-demo" class="pagination">
                                    </ul>
                                    <input type="hidden" name="page" id="page" value="${model.page}" />
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="assignBuildingModal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên giao Sản phẩm</h4>
            </div>
            <div class="modal-body">
                <table class="table" id="userAssignTable">
                    <thead>
                    <tr>
                        <th class="text-center">
                            Chọn nhân viên
                        </th>
                        <th class="text-center">
                            Tên nhân viên
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <div id="fieldHidden">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnAssignBuildingForUser">Giao tòa nhà</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var totalPages = ${model.totalPages};
    var visiblePages = ${model.maxPageItems};
    var startPage = ${model.page};
    $(document).ready(function () {
        $('#btnSearch').click(function () {
            $('#page').val(1);
            $('#formSubmit').submit();
        });


        $('#btnDelete').click(function (e) {
                e.preventDefault();
                var data = {};
                var data = $('body td input[type=checkbox]:checked').map(function () {
                    return $(this).val();
                }).get();
                if (data[0] == "") {
                    data.splice(0, 1);
                }
                showAlertBeforeDelete(data);
            });

        $('#btnAssignBuildingForUser').click(function (e) {
            e.preventDefault();
            var buildingId = $('#fieldHidden').find('#buildingId').val();
            var userArrays = $('#userAssignTable').find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            assignUser(userArrays, buildingId);
        });

    });

    $(function () {
        var obj = $('#pagination-demo').twbsPagination({
            totalPages: totalPages,
            visiblePages: visiblePages,
            startPage: startPage,
            onPageClick: function (event, page) {
                if (page != startPage) {
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });

    });


    function showAlertBeforeDelete(data) {
        swal({
            title: "Xác nhận xóa",
            text: "Bạn có chắc chắn xóa những dòng đã chọn",
            type: "warning",
            showCancelButton: true,
            confirmButtonText: "Xác nhận",
            cancelButtonText: "Hủy bỏ",
            confirmButtonClass: "btn btn-success",
            cancelButtonClass: "btn btn-danger"
        }).then(function (isConfirm) {
            if (isConfirm) {
                deleteBuilding(data);
            }
        });
    }

    //xoa toa nha
    function deleteBuilding(data) {
        $.ajax({
            url: '${buildingUrl}',
            type: 'DELETE',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=delete_success'/>";
            },
            error: function (result) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
            },
        });
    }



    function openModalAssignBuilding() {
        $('#assignBuildingModal').modal();
    }



    function loadUserAssignForBuilding(buildingId) {
        var buildingIdHidden = '<input type="hidden" name="buildingId" value=' + buildingId + ' id="buildingId"></input>';
        $('#fieldHidden').html(buildingIdHidden);
        $.ajax({
            url: '${loadUser}?buildingId=' + buildingId,
            type: 'GET',
            dataType: 'json',
            success: function (result) {
                var row = '';
                $.each(result, function (index, user) {
                    row += '<tr>';
                    row += '<td class="text-center"><input type="checkbox" name="checkList" value=' + user.id + ' id="checkbox_' + user.id + '" class="check-box-element" ' + user.checked + '/></td>';
                    row += '<td class="text-center">' + user.fullName + '</td>';
                    row += '</tr>';
                });
                $('#userAssignTable tbody').html(row);
            },
            error: function (res) {
                console.log(res);
            }
        });
    }

    function assignUser(users, buildingId) {
        $.ajax({
            url: '${buildingUrl}/' + buildingId + '/users',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(users),
            success: function (res) {
                window.location.href = "<c:url value='/admin/building/list?message=assign_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
                console.log(res);
            }
        });
    }

    function updatePriority(buildingId, action) {
        $.ajax({
            url: '${buildingUrl}/' + buildingId + '/priority?action=' + action,
            type: 'POST',
            success: function (res) {

                if(action == "remove"){
                    window.location.href = "<c:url value='/admin/building/list?message=priority_success_remove'/>";
                }
                if(action == "insert"){
                    window.location.href = "<c:url value='/admin/building/list?message=priority_success_add'/>";
                }

            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/building/list?message=error_system'/>";
                console.log(res);
            }
        });
    }

    $(function () {
        $(document).on("click", "a#btnAssignBuilding", function (e) {
            e.preventDefault();
            openModalAssignBuilding();
            loadUserAssignForBuilding($(this).attr('buildingId'));
        });
    });
    $(function () {
        $(document).on("click", "a#updatePriority", function (e) {
            e.preventDefault();
            var buildingId = $(this).attr('buildingId');
            var action = $(this).attr('action');
            updatePriority(buildingId, action);
        });
    });

</script>
</body>
</html>
