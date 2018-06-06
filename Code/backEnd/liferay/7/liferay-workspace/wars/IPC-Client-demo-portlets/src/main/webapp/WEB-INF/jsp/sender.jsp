<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:actionURL var="submitFormURL" name="handleEmployee"/>
<portlet:resourceURL id="submitFormViaAjaxUrl" var="submitFormViaAjaxUrl"/>
<p>
    <b><liferay-ui:message key="ipc.prp.sender.caption"/></b>
</p>
<%--<form:form name="employeeForm" method="post" modelAttribute="employee" action="${submitFormViaAjaxUrl}">--%>
<form:form name="employeeForm" id="employeeForm" method="post" modelAttribute="employee" action="${submitFormViaAjaxUrl}">
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
<!-- Result Container -->
<div id="resultContainer" style="display: none;">
    <hr/>
    <h4 style="color: green;">JSON Response From Server</h4>
    <pre style="color: green;">
    <code></code>
   </pre>
</div>
<script>
   $(document).ready(function() {
        /*  Submit form using Ajax */
          $("#employeeForm").submit(function(e){
            debugger;
              var form = this;
              // for stopping the default action of element
              e.preventDefault();
              var formData = {}
              $.each(this, function(i, v){
                  var input = $(v);
                  // populate form data as key-value pairs
                  // with the name of input as key and its value as value
                  if(input.attr("type")!="submit")
                    formData[input.attr("name")] = input.val();
              });

            // Fire Liferay event
            /*Liferay.fire('employeeSubmitEvent', {
                name: "Test Name"
            });*/

            $.ajax({
                contentType : 'application/json; charset=utf-8',
                url : $("#employeeForm").attr("action"),
                // data: {employeeData : JSON.stringify(formData) },
                // data: formData,
                data : {
                  name: $('[name="name"]').val(), email: $('[name="email"]').val()
          },
                type: $("#employeeForm").attr("method"), // method attribute of form
                dataType : 'json',
                success: function (res) {
                    debugger;
                    //Set response
                    $('#resultContainer pre code').text(JSON.stringify(res));
                    $('#resultContainer').show();
                },
                error : function(){
                    console.log("Error occured");
                }
            });
        });
    });

</script>