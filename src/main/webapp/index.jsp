<%@page import="com.mycompany.resumewebapp.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.resumewebapp.student.repo.StudentRepo"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ana sehife</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Students</h1>

<form class="container">
    <div class="row">
        <div class="col-auto">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control" id="name" placeholder="name">
        </div>
        <div class="col-auto">
            <label for="surname" class="form-label">surname</label>
            <input type="text" class="form-control" id="surname" placeholder="surname">
        </div>
        <div class="col-auto">
            <label for="age" class="form-label">age</label>
            <input type="text" class="form-control" id="age" placeholder="age">
        </div>
        <div class="col-auto">
            <label for="email" class="form-label">email</label>
            <input type="text" class="form-control" id="email" placeholder="email">
        </div>
        <div class="col-auto">
            <label for="surname" class="form-label">university</label>
            <select class="form-select" name="university">
                <option value="1">BDU</option>
                <option value="2">AzTU</option>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <button type="submit" class="btn btn-primary mb-3">Search</button>
        </div>
    </div>
</form>

<table class="table" style="background-color: #00fff9;width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        StudentRepo repo = new StudentRepo();
        final List<Student> list = repo.getList();
        
        for(int i=0;i<list.size();i++){
            Student student = list.get(i);
    %>
    <!--if(i%2==0) out.println("class=\"table-secondary\" "); -->
    <tr <%=(i%2==0? "class=\"table-secondary\"":"") %> >
       
        <td>
            <%=student.getId()%>
        </td>
        <td> 
            <%=student.getName()%> 
        </td>
        <td>
            <%=student.getSurname()%> 
        </td>
        <td>
            <%=student.getAge()%> 
        </td>
        <td>
            <%=student.getEmail()%> 
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
