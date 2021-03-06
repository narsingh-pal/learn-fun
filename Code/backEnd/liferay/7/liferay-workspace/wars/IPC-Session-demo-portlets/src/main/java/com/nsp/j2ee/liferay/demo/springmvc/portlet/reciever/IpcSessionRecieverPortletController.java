package com.nsp.j2ee.liferay.demo.springmvc.portlet.reciever;

import javax.portlet.*;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class IpcSessionRecieverPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcSessionRecieverPortletController.class);

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Session Reciever Portlet : default render invoked###########");
		PortletSession portletSession = request.getPortletSession();
		employee = (Employee) portletSession.getAttribute("empinfo",PortletSession.APPLICATION_SCOPE);
		return "reciever";
	}
}