

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Vacations List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Vacations</g:link></span>
        </div>
        <div class="body">
            <h1>Vacations List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="begining" title="Begining" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="end" title="End" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${vacationsInstanceList}" status="i" var="vacationsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${vacationsInstance.id}">${fieldValue(bean:vacationsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:vacationsInstance, field:'begining')}</td>
                        
                            <td>${fieldValue(bean:vacationsInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:vacationsInstance, field:'end')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${vacationsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
