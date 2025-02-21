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
    <a
      class="btn btn-light"
      href="<%=application.getContextPath()%>/feedback.jsp"
    >Give us feedback</a>
  </div>
  <%@ include file="components/scripts.jsp"%>
</body>
</html>