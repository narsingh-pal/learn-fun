package com.nsp.j2ee.liferay.demo.springmvc.portlet.sender;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.*;
import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class IpcClientSenderPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcClientSenderPortletController.class);

    @RenderMapping
    public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Client  Sender Portlet : default render invoked###########");
        return "sender";
    }

    @RenderMapping(params = "action=showEmployeeDetails")
    public String showEmployeeDetails(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Client Sender Portlet : Calling showEmployeeDetails###########");
        return "senderEmployeeDetails";
    }

    @ActionMapping(value = "handleEmployee")
    public void getEmployeeData(@ModelAttribute("employee") Employee employee,
                                ActionRequest actionRequest, ActionResponse actionResponse, Model model) {
        _log.info("#############Client Sender Portlet : Calling getEmployeeData##########");
        actionResponse.setRenderParameter("action", "showEmployeeDetails");
        PortletSession portletSession = actionRequest.getPortletSession();
        portletSession.setAttribute("empinfo", employee, PortletSession.APPLICATION_SCOPE);
    }

    @ModelAttribute(value = "employee")
    public Employee getEmployeeCommandObject() {
        Employee employeeJsonObj = new Employee();
        return employeeJsonObj;
    }


    @ResourceMapping("submitFormViaAjaxUrl")
    public void submitFormViaAjaxUrl(ResourceRequest request, ResourceResponse response, @ModelAttribute(value = "employee") Employee employeeJsonObj) throws IOException {
//        _log.info("#############Client Sender Portlet :NAME::::: "+ name + " ##########" );
        Employee employee = new Employee();
        String employeeData = ParamUtil.getString(request, "employeeData");
        String name = ParamUtil.getString(request, "name");
        String email = ParamUtil.getString(request, "email");
        _log.info("Name : " + name);
        _log.info("Email : " + email);

        employee.setName(name);
        employee.setEmail(email);
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("employee", employeeJsonObj);

        _log.info("#############Client Sender Portlet : Calling submitFormViaAjaxUrl " + employee + " ##########");
        //response.getWriter().println(employeeJsonObj);
        response.getWriter().write(json.toString());
        //return employee;
    }
}