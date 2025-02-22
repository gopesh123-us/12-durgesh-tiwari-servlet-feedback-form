<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta
  name="viewport"
  content="width=device-width, initial-scale=1"
>
<%@ include file="components/links.jsp"%>
<title>Feedback Form</title>
</head>
<body>
  <%@include file="header.jsp"%>
  <div class="content_container d-flex flex-column justify-content-center align-items-center">
  <div class="btn-div">
    <a
      class="btn btn-light btn-block"
      href="<%=application.getContextPath()%>/feedback.jsp"
    >Give us feedback</a>
    <a
      class="btn btn-warning btn-block"
      href="<%=application.getContextPath()%>/setCookie"
    >Set Cookie</a>
    <a
      class="btn btn-warning btn-block"
      href="<%=application.getContextPath()%>/getCookie"
    >Get Cookie Information</a>
    <a
      class="btn btn-warning btn-block"
      href="<%=application.getContextPath()%>/counter"
    >Counter servlet visits</a>
    <a
      class="btn btn-warning btn-block"
      href="<%=application.getContextPath()%>/configcontext"
    >Get App Name</a>
  </div>
  </div>
    
  <%@ include file="components/scripts.jsp"%>
</body>
</html>