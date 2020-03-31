<%--
  Created by IntelliJ IDEA.
  User: dream
  Date: 2020/3/29
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>版权方管理</title>
    <%@ include file="../../common/jsp/header.jsp"%>
</head>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <form id="searchForm" action="../copyright/create.do">
            <div class="col-sm-12">
                <!-- ------------按钮组 start------------ -->
                <div class="col-sm-3">
                版权名:<input class="form-control" type="text" name="copyrightName">
                </div>
                <div class="col-sm-3">
                公司名:<input class="form-control" type="text" name="companyName">
                </div>
                <div class="col-sm-3">
                备注名:<input class="form-control" type="text" name="remarksName">
                </div>
                <div class="col-sm-3">
                    &nbsp;
                    <div>
                        <button type="submit" class="btn btn-primary" data-toggle="modal" >
                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
                        </button>
                    </div>
                </div>

                <div class="col-sm-8">
                <h4>版权列表</h4>
                </div>
                <!-- ------------按钮组 end------------ -->
                <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
                <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
                <table class="table table-striped table-bordered table-hover table-condensed">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="checkall"/></th>
                        <th>序号</th>
                        <th>版权</th>
                        <th>公司</th>
                        <th>备注名 &nbsp;</th>
                        <th>未到位（合计：X）</th>
                        <th>初审（合计：X）</th>
                        <th>入库审核（合计：X）</th>
                        <th>入库未上线（合计：X）</th>
                        <th>上线（合计：X）</th>
                        <th>版权过期（合计：X）</th>
                        <th>初审删除（合计：X）</th>
                        <th>入库审核删除（合计：X）</th>
                        <th>驳回（合计：X）</th>
                        <th>即将过期（合计：X）</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="vs"></c:set>
                    <c:forEach var="e" items="${page.list }" varStatus="v">
                        <tr>
                            <td><input type="checkbox" name="ids" value="${e.copyrightId}"/></td>
                            <td></td>
                            <td>${e.copyrightName }</td>
                            <td>${e.companyName }</td>
                            <td>${e.remarksName }</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="test/view.do">
                                <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
                                </button>
                                <button type="button" class="btn btn-file" data-toggle="modal" name="copyright/create.jsp">客户管理</button>
                                <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="copyright/delete.do">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
                                </button>
                                <button type="button" class="btn btn-file" data-toggle="modal" name="copyright/create.jsp">书单管理</button>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="page">${page}</div>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=path%>view/dictionary/js/test.js"></script>
</html>
