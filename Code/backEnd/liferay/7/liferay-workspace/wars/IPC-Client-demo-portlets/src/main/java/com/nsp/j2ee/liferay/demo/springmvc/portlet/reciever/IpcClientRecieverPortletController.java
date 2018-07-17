package com.nsp.j2ee.liferay.demo.springmvc.portlet.reciever;

import javax.portlet.*;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class IpcClientRecieverPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcClientRecieverPortletController.class);

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############IPC Client Reciever Portlet : default render invoked###########");
		return "reciever";
	}

	@ResourceMapping("submitFormViaAjaxUrl")
	public void submitFormViaAjaxUrl(ResourceRequest request, ResourceResponse response, @ModelAttribute(value = "employee") Employee employee) throws IOException {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("employee", employee);
		_log.info("#############Client Reciever Portlet : Calling submitFormViaAjaxUrl " + employee + " ##########");
		response.getWriter().write(json.toString());
	}
}