<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Languages</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5" style="width: 50%;">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Creator</th>
                    <th>Version</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${languages}" var="language">
                    <tr>
                        <td><a href="<c:url value='/languages/${language.id}' />"><c:out value="${language.name}" /></a></td>
                        <td><c:out value="${language.creator}" /></td>
                        <td><c:out value="${language.currentVersion}" /></td>
                        <td>
                            <a href="<c:url value='/languages/editar/${language.id}' />" class="btn btn-primary">Editar</a>
                            <a href="<c:url value='/languages/eliminar/${language.id}' />" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="<c:url value='/languages' />" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" name="name" value="${language.name}" class="form-control">
            </div>
            <div class="mb-3">
                <label for="creator" class="form-label">Creator:</label>
                <input type="text" name="creator" value="${language.creator}" class="form-control">
            </div>
            <div class="mb-3">
                <label for="currentVersion" class="form-label">Version:</label>
                <input type="text" name="currentVersion" value="${language.currentVersion}" class="form-control">
            </div>
            <input type="submit" value="Guardar" class="btn btn-primary">
        </form>
    </div>
</body>
</html>
