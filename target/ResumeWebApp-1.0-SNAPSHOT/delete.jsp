<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <form action="index" method="POST">
            Are you sure to delete?
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
            <input type="hidden" name="command" value="delete"/>
            <button class="btn btn-primary" type="submit">YES</button>
            <a href="index" class="btn btn-danger">NO</a>
        </form>
    </body>
</html>
