<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>${user_data.fullName}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <link rel="stylesheet" href="/css/demo.css">
            </head>

            <body>
                <div class="container mt-3">
                    <h1>User detail</h1>
                    <hr />
                    <div class="card" style="width: 18rem;">
                        <img src="https://yt3.googleusercontent.com/8eGqQZxpSdVKFel6OBsW5orqJ1mC_2h_sPKbR4al6eqOM2rV-2ahi6FhEWT-L9PmWjgfhsJhSeY=s900-c-k-c0x00ffffff-no-rj"
                            class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${user_data.fullName}</h5>
                            <p class="card-text">${user_data.address}</p>
                            <a href="/admin/user" class="btn btn-primary">back to UserPage</a>
                        </div>
                    </div>
                </div>


            </body>

            </html>