<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'student.label', default: 'Student')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>

    <body>
        <h2>Index</h2>
        <p>
            <g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
        </p>
        <table class="table">
            <thead>
                <tr>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${students}" var="student" status="i">
                    <tr>
                        <td>${student.lastName}</td>
                        <td>${student.firstName}</td>
                        <td>${student.email}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </body>
</html>