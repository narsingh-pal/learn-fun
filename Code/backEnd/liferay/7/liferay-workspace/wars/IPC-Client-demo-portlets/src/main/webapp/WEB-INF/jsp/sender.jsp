<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:resourceURL id="submitFormViaAjaxUrl" var="submitFormViaAjaxUrl"/>
<p>
    <b><liferay-ui:message key="ipc.client.demo.sender.caption"/></b>
</p>
<form:form name="employeeForm" id="employeeForm" method="post" modelAttribute="employee"
           action="${submitFormViaAjaxUrl}">
    <br/>
    <table>
        <tbody>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit Form">
            </td>

        </tr>
        </tbody>
    </table>
</form:form>

<script>
    $(document).ready(function () {
        /*  Submit form using Ajax */
        $("#employeeForm").submit(function (e) {
            var form = this;
            // for stopping the default action of element
            e.preventDefault();

            var dataObject = {
                'name': $('[name="name"]').val(),
                'email': $('[name="email"]').val()
            };
            // Fire Liferay event
            Liferay.fire('employeeSubmitEvent', dataObject);
        });
    });

</script>