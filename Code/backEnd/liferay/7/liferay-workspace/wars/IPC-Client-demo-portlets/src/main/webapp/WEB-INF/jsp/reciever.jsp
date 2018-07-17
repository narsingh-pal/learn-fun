<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:resourceURL id="submitFormViaAjaxUrl" var="submitFormViaAjaxUrl"/>

<p>
    <b><liferay-ui:message key="ipc.client.demo.reciever.caption"/></b>
</p>
<%--<h1>Employee Details</h1>
Employee Name : <span id="empName"></span> <br/>
Employee email : <span id="empEmail"></span>--%>

<form:form name="recieverEmployeeForm" id="recieverEmployeeForm" method="post" modelAttribute="employee"
           action="${submitFormViaAjaxUrl}">
    <form:hidden path="name"></form:hidden>
    <form:hidden path="email"></form:hidden>
</form:form>

<div id="recieverResultContainer" style="display: none;">
    <hr/>
    <h4 style="color: green;">JSON Response From Server</h4>
    <pre style="color: green;">
    <code></code>
   </pre>
</div>

<script>
    $(document).ready(function () {
        var dataObject = {};
        Liferay.on('employeeSubmitEvent', function (event) {
            console.log("Event recieved");
            console.log("Details from event object are : Name : " + event.name + " ::: EmailId : " + event.email);
            /*document.getElementById("empName").innerText = event.name;
            document.getElementById("empEmail").innerText = event.email;*/

            document.getElementById("name").value = event.name;
            document.getElementById("email").value = event.email;
            dataObject = {
                'name': event.name,
                'email': event.email
            };

            console.log("Posting details via AJAX");
            $.ajax({
                url: $("#recieverEmployeeForm").attr("action"),
                data: dataObject,
                type: $("#recieverEmployeeForm").attr("method"), // method attribute of form
                dataType: 'json',
                success: function (res) {
                    console.log("Data recieved from server");
                    //Set response
                    $('#recieverResultContainer pre code').text(JSON.stringify(res));
                    $('#recieverResultContainer').show();
                },
                error: function () {
                    console.log("Error occured");
                }
            });
        });
    });
</script>