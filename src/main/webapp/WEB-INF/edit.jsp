<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Language</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5 d-flex justify-content-center">
        <div class="card shadow-sm" style="width: 50%;">
            <div class="card-body">
                <form action="<c:url value='${accion}' />" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" name="name" value="${language.name}" />
                    </div>

                    <div class="form-group">
                        <label for="creator">Creator:</label>
                        <input type="text" class="form-control" name="creator" value="${language.creator}" />
                    </div>

                    <div class="form-group">
                        <label for="currentVersion">Version:</label>
                        <input type="text" class="form-control" name="currentVersion" value="${language.currentVersion}">
                    </div>

                    <div class="d-flex justify-content-between">
                        <input type="submit" class="btn btn-primary" value="Guardar" />
                        <a href="<c:url value='/languages/eliminar/${language.id}' />" class="btn btn-danger">Eliminar</a>
                        <a href="<c:url value='/languages' />" class="btn btn-secondary">Dashboard</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
