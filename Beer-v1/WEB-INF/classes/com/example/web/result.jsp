<%@ page import="java.util.*" %>

<html>
<body>
  <h1 align="center">Beer Recommendations JSP</h1>
  <p>

  <%
    List styles = (List)request.getAttribute("styles");
    for(Object element: styles){
      out.print("<br>try: " + (String) element);
    }
  %>

</body>
</html>