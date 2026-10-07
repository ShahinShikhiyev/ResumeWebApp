<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <link href="css/index.css" rel="stylesheet">
    </head>
    <body>
        <form class="container" action="logout" method="POST">
                Are you sure to logout?
                <div class="row">
                    <div class="col-3">
                        <button type="submit" class="btn btn-primary mb-3">YES</button>
                        <button type="submit"><a href="login">NO</a></button>
                    </div>
                </div>
        </form>
    </body>
</html>
