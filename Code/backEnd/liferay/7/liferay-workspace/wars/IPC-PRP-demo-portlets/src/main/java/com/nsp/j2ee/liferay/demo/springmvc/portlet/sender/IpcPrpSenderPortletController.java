package com.nsp.j2ee.liferay.demo.springmvc.portlet.sender;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


@Controller
@RequestMapping("VIEW")
public class IpcPrpSenderPortletController {
	private static Log _log = LogFactoryUtil.getLog(IpcPrpSenderPortletController.class);

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Sender Portlet : default render invoked###########");
		return "sender";
	}

	@RenderMapping(params = "action=showEmployeeDetails")
	public String showEmployeeDetails(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
		_log.info("##############Sender Portlet : Calling showEmployeeDetails###########");
		return "senderEmployeeDetails";
	}

	@ActionMapping(value = "handleEmployee")
	public void getEmployeeData( @ModelAttribute("employee") Employee employee,
			ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("#############Sender Portlet : Calling getEmployeeData##########" );
		actionResponse.setRenderParameter("action", "showEmployeeDetails");
        actionResponse.setRenderParameter("name", employee.getName());
        actionResponse.setRenderParameter("email", employee.getEmail());

	}
}