

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Vacations</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Vacations List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Vacations</g:link></span>
        </div>
        <div class="body">
            <h1>Show Vacations</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:vacationsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Begining:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:vacationsInstance, field:'begining')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:vacationsInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">End:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:vacationsInstance, field:'end')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${vacationsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
