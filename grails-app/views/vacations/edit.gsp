

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Vacations</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Vacations List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Vacations</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Vacations</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${vacationsInstance}">
            <div class="errors">
                <g:renderErrors bean="${vacationsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${vacationsInstance?.id}" />
                <input type="hidden" name="version" value="${vacationsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="begining">Begining:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vacationsInstance,field:'begining','errors')}">
                                    <g:datePicker name="begining" value="${vacationsInstance?.begining}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vacationsInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:vacationsInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="end">End:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:vacationsInstance,field:'end','errors')}">
                                    <g:datePicker name="end" value="${vacationsInstance?.end}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
