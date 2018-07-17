package com.nsp.j2ee.liferay.demo.springmvc.portlet.sender;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nsp.j2ee.liferay.demo.springmvc.portlet.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;

@Controller
@RequestMapping("VIEW")
public class IpcClientSenderPortletController {
    private static Log _log = LogFactoryUtil.getLog(IpcClientSenderPortletController.class);

    @RenderMapping
    public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Client  Sender Portlet : default render invoked###########");
        return "sender";
    }
}