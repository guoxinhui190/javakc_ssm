<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!--针对响应式布局设置的缩放比-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>
    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/bootstrap.min.js?v=3.3.5"></script>
    <script type="text/javascript" src="<%=path%>static/js/bootstrapValidator.min.js?v=0.5.3"></script>
    <script type="text/javascript" src="<%=path%>static/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/plugins/layer/layer.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/tool.js"></script>
    <!--添加自定义样式-->
    <style type="text/css">
        [class*="col-"]{
            padding-top: 15px;
            padding-bottom:15px ;
        }
        body{
            background-color: #A6EF88;
        }
        table{
            background-color: #DFF0D8;
        }
    </style>
    <script>
        // $(function () {
        //     $.ajax({
        //         url:path+'bookIn/queryName.do',
        //         dataType:'json',
        //         type:'POST',
        //         success:function (data) {
        //             var html = "";
        //             // ##循环data，得到用户数据
        //             $.each(data,function (i,item) {
        //                 html+="<option value='"+item.copyrightid+"'>"+item.copyrightName+"</option>";
        //             });
        //
        //             $('#').append(html);
        //         }
        //     })
        // })
    </script>
</head>
<body>
<div class="container">
    <form action="" id="searchIf">
<div class="container">
    <div class="col-md-3">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="cpId">CP书籍ID:</span>
            <input type="text" class="form-control" value="${bookInEntity.cpId}" name="cpId" aria-describedby="cpId">
        </div>
    </div>
    <div class="col-md-3">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="tarotId">塔读书籍ID:</span>
            <input type="text" class="form-control" value="${bookInEntity.tarotId}" name="tarotId" aria-describedby="tarotId">
        </div>
    </div>
    <div class="col-md-2">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="bookname">书名:</span>
            <input type="text" class="form-control" value="${bookInEntity.bookname}" name="bookname" aria-describedby="bookname">
        </div>
    </div>
    <div class="col-md-2">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="author">作者:</span>
            <input type="text" class="form-control" value="${bookInEntity.author}" name="author" aria-describedby="author">
        </div>
    </div>
    <div class="col-md-2">
        <div class="dropdown    ">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                展示条数:
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="#">10</a></li>
                <li><a href="#">20</a></li>
                <li><a href="#">50</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="col-md-3">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="copyrightName">版权：</span>
            <select class="form-control" id="copyrightid" value="${bookInEntity.copyrightid}" name="copyrightid" aria-describedby="copyrightName">
                <option value="0">请选择</option>
            </select>
        </div>
     </div>
    <div class="col-md-3">
        <div class="input-group">
          <div class="input-group-btn">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                书单名<span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
            </ul>
          </div><!-- /btn-group -->
        <input type="text" class="form-control" disabled>
       </div><!-- /input-group -->
    </div>
    <div class="col-md-2">
        <div class="input-group">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    批次<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                </ul>
            </div><!-- /btn-group -->
            <input type="text" class="form-control" disabled>
        </div><!-- /input-group -->
    </div>
    <div class="col-md-2">
        <div class="input-group">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    分类<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                </ul>
            </div><!-- /btn-group -->
            <input type="text" class="form-control" disabled>
        </div><!-- /input-group -->
    </div>
    <div class="col-md-2">
        <button class="btn btn-success" type="submit">查---------询</button>
    </div>
</div>
<div class="container">
    <div class="col-md-3">
            <div class="input-group input-group-sm">
            <span class="input-group-addon" id="serialization">连载：</span>
            <select class="form-control" value="${bookInEntity.serialization}" name="serialization" aria-describedby="serialization">
                <option value="0" selected>请选择</option>
                <option value="1"${bookInEntity.serialization == 1?"selected":""}>是</option>
                <option value="2"${bookInEntity.serialization == 2?"selected":""}>否</option>
            </select>
            </div>
    </div>
    <div class="col-md-3">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="state">状态：</span>
                <select class="form-control"  value="${bookInEntity.state}" name="state">
                    <option  value="0">请选择</option>
                    <option  value="1"${bookInEntity.state == 1?"selected":""}>未到位</option>
                    <option  value="2"${bookInEntity.state == 2?"selected":""}>到位</option>
                    <option  value="3"${bookInEntity.state == 3?"selected":""}>初审</option>
                    <option  value="4"${bookInEntity.state == 4?"selected":""}>入库审</option>
                    <option  value="5"${bookInEntity.state == 5?"selected":""}>上线</option>
                    <option  value="6"${bookInEntity.state == 6?"selected":""}>过期版权</option>
                    <option  value="7"${bookInEntity.state == 7?"selected":""}>初审删除</option>
                    <option  value="8"${bookInEntity.state == 8?"selected":""}>入库审删除</option>
                    <option  value="9"${bookInEntity.state == 9?"selected":""}>驳回</option>
                </select>
            </div>
    </div>
    <div class="col-md-2">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="ifOriginal">原创：</span>
                <select class="form-control" value="${bookInEntity.ifOriginal}" name="ifOriginal">
                    <option value="0">请选择</option>
                    <option value="1"${bookInEntity.ifOriginal == 1?"selected":""}>是</option>
                    <option value="2"${bookInEntity.ifOriginal == 2?"selected":""}>否</option>
                </select>
        </div><!-- /btn-group -->
    </div><!-- /input-group -->
    <div class="col-md-2">
        <div class="input-group input-group-sm">
            <span class="input-group-addon" id="ifCharge">全本收费：</span>
                <select class="form-control" value="${bookInEntity.ifCharge}" name="ifCharge">
                    <option value="0">请选择</option>
                    <option value="1"${bookInEntity.ifCharge == 1?"selected":""}>是</option>
                    <option value="2"${bookInEntity.ifCharge == 2?"selected":""}>否</option>
                </select>
        </div><!-- /btn-group -->
    </div><!-- /input-group -->
    <div class="col-md-2"><button class="btn btn-danger active" type="submit">批量删除</button></div>
</div>
    </form>
<div class="container">
<div class="table-responsive">
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr class="success">
            <th><input type="checkbox" id="checkall"/></th>
            <th>CP书籍ID</th>
            <th>塔读ID</th>
            <th>书名</th>
            <th>作者</th>
            <th>分类</th>
            <th>版权名</th>
            <th>书单名</th>
            <th>批次名</th>
            <th>连载</th>
            <th>字数</th>
            <th>状态</th>
            <th>全本收费</th>
            <th>全本价格</th>
            <th>原创</th>
            <th>出版社</th>
            <th>出版时间</th>
            <th>授权起始时间</th>
            <th>授权结束时间</th>
            <th>作者授权起始时间</th>
            <th>作者授权结束时间</th>
            <th>授权状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${page.list}" varStatus="v">
            <tr>
                <td><input type="checkbox" name="ids" value="${e.bookId}"/></td>
                <td>${e.cpId}</td>
                <td>${e.tarotId}</td>
                <td>${e.bookname}</td>
                <td>${e.author}</td>
                <td>${e.twoname}</td>
                <td>${e.copyrightName}</td>
                <td>${e.booklistName}</td>
                <td>${e.batchName}</td>
                <td>${e.serialization}</td>
                <td>${e.wordNumber}</td>
                <td>${e.state}</td>
                <td>${e.ifCharge}</td>
                <td>${e.price}</td>
                <td>${e.ifOriginal}</td>
                <td>${e.press}</td>
                <td><fmt:formatDate value="${e.publishingTime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td><fmt:formatDate value="${e.rightStartTime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td><fmt:formatDate value="${e.errorEndTime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td><fmt:formatDate value="${e.authorRightStartTime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td><fmt:formatDate value="${e.authorErrorEndTime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td>${e.authorizationStatus}</td>
                <td>${e.authorizationStatus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

<div class="container">
    <div class="col-md-4"></div>
    <div class="col-md-4 page">${page}</div>
    <div class="col-md-4"></div>
</div>

</div>
</body>
</html>