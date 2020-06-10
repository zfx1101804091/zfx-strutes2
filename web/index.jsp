<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP '01.jsp' starting page</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" type="text/css" href="css/common.css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
  <script type="text/javascript">
    function savePerosnalInfo(){

      var file = $('#file').val();

      var options = {

        url : "${pageContext.request.contextPath}/file/savePersonalInfo.action",
        type : "post",
        dataType : "json",
        data: {"file":file},
        success : function(data){//回调函数
          
          if(data.code=200){//返回信息等于success则提示保存成功
            alert(" save success!");
            //保存成功之后关闭当前页面
            //window.close();
            //$("#abb").hide();
            //$(".layer-box").hide();
            //隐藏页面（这个页面是由父页面控制的，需要找到父页面的class）
            $(".layer-box" , parent.document).hide();
            //在实现关闭保存页面的同时发现右侧的滚动条消失了，然后添加了下面一句:删除隐藏标签
            $("body", parent.document).removeClass("overhide");
          }else{
            alert(" save failed!");
          }
        }
      };
      $("#saveForm").ajaxSubmit(options);

    }
  </script>
</head>

<body>
<form id="saveForm" name="form01" class="demoform">
  <input id="file" name="file" type="file" class="" value="请选择文件"/>
  <input type="button" class="btn baocun" value="上传" onclick="savePerosnalInfo();">
</form>
</body>
</html>
