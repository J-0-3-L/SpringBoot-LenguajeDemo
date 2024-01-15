<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Detalles del Idioma</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <c:if test="${not empty language}">
                    <div class="card mt-5">
                        <div class="card-body">
                            <p><strong>Nombre:</strong> ${language.name}</p>
                            <p><strong>Creador:</strong> ${language.creator}</p>
                            <p><strong>Version:</strong> ${language.currentVersion}</p>
                            <a href="<c:url value='/languages/editar/${language.id}' />" class="btn btn-primary">Editar</a>
                            <a href="<c:url value='/languages/eliminar/${language.id}' />" class="btn btn-danger">Eliminar</a>
                        </div>
                    </div>
                </c:if>
                <c:if test="${empty language}">
                    <p class="mt-5">El idioma no existe o no se encontró.</p>
                </c:if>
                <p class="mt-3"><a href="<c:url value='/languages' />" class="btn btn-secondary">Dashboard</a></p>
            </div>
        </div>
    </div>
</body>
</html>
