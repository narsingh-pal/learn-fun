package com.nsp.j2ee.liferay.demo.springmvc.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class SpringMvcDemoPortletViewController {
	private static Log _log = LogFactoryUtil.getLog(SpringMvcDemoPortletViewController.class);

	@RenderMapping
	public String defaultView(RenderRequest request, RenderResponse response) {
		_log.info("Spring Render invoked");
		return "view";
	}
    @RenderMapping(params = "action=renderMethod1")
    public String view(RenderRequest request, RenderResponse response) {
        _log.info("Spring Render1 invoked");
        return "view2";
    }

    @ActionMapping(params = { "action=actionMethod1" })
	public void actionMethod1(ActionRequest request, ActionResponse response){
		_log.info("Spring Action method1 invoked");
        response.setRenderParameter("action","renderMethod1");
	}

    @ActionMapping("actionMethod2")
    public void actionMethod2(ActionRequest request, ActionResponse response){
        _log.info("Spring Action2 method invoked");
        response.setRenderParameter("action","renderMethod1");
    }
}