package com.nsp.j2ee.liferay.demo.springmvc.portlet.reciever;

import javax.portlet.*;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class IpcClientRecieverPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcClientRecieverPortletController.class);

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Session Reciever Portlet : default render invoked###########");
		PortletSession portletSession = request.getPortletSession();
		employee = (Employee) portletSession.getAttribute("empinfo",PortletSession.APPLICATION_SCOPE);
		return "reciever";
	}
}