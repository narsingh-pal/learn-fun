package com.nsp.j2ee.liferay.demo.springmvc.portlet.ajax;

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
public class SpringAjaxPortletController {
    private static Log _log = LogFactoryUtil.getLog(SpringAjaxPortletController.class);

    @RenderMapping
    public String view(RenderRequest request, RenderResponse response, @ModelAttribute("employee") Employee employee) {
        _log.info("##############Spring Ajax Portlet : default render invoked###########");
        return "view";
    }

    @ResourceMapping("submitFormViaAjaxUrl")
    public void submitFormViaAjaxUrl(ResourceRequest request, ResourceResponse response, @ModelAttribute(value = "employee") Employee employee) throws IOException {
        _log.info("#############Ajax post Portlet : Calling submitFormViaAjaxUrl " + employee + " ##########");
//        String name = ParamUtil.getString(request, "name");
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("employee", employee);
        response.getWriter().write(json.toString());
    }
}