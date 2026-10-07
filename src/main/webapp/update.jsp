<%@page import="com.mycompany.resumewebapp.student.entity.Student"%>
<%@page import="com.mycompany.resumewebapp.student.repo.StudentRepo"%>
<%@page import="com.mycompany.resumewebapp.util.ParamUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <link href="css/index.css" rel="stylesheet">
    </head>
    <body>
        <%
            final Integer id = ParamUtil.parseInt(request.getParameter("id"));
            StudentRepo repo = new StudentRepo();
            final Student foundStudent = repo.findById(id);
        %>
        <form class="container" action="index" method="POST">
            <div class="row col-5">
                <label for="name" class="form-label">name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="name" value="<%=foundStudent.getName()%>">
            </div>
            <div class="row col-5">
                <label for="surname" class="form-label">surname</label>
                <input type="text" class="form-control" name="surname" id="surname" placeholder="surname" value="<%=foundStudent.getSurname()%>">
            </div>
            <div class="row col-5">
                <label for="age" class="form-label">age</label>
                <input type="text" class="form-control" name="age" id="age" placeholder="age" value="<%=foundStudent.getAge()%>">
            </div>
            <div class="row col-5">
                <label for="email" class="form-label">email</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="email" value="<%=foundStudent.getEmail()%>">
            </div>
            <div class="row col-5">
                <label for="surname" class="form-label">university</label>
                <select class="form-select" name="university">
                    <option value="BDU" <%=foundStudent.getUniversity().equalsIgnoreCase("BDU") ? "selected" : ""%>>BDU</option>
                    <option value="AzTU" <%=foundStudent.getUniversity().equalsIgnoreCase("AzTU") ? "selected" : ""%>>AzTU</option>
                </select>
            </div>
            <input type="hidden" name="id" value="<%=foundStudent.getId()%>"/>
            <input type="hidden" name="command" value="update"/>
            <div class="row">
                <div class="col-3">
                    <button type="submit" class="btn btn-primary mb-3">Save</button>
                </div>
            </div>
        </form>
    </body>
</html>
