package com.nsp.j2ee.liferay.demo.springmvc.portlet.reciever;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


@Controller
@RequestMapping("VIEW")
public class IpcPrpRecieverPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcPrpRecieverPortletController.class);

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Reciever Portlet : default render invoked###########");
        String name= ParamUtil.getString(request,"name",null);
		String email= ParamUtil.getString(request,"email",null);
		employee.setEmail(email);
		employee.setName(name);
		return "reciever";
	}
}