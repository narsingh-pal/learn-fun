package com.nsp.j2ee.liferay.leave.portlet;

import com.nsp.j2ee.liferay.leave.constants.LeavePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Leave Application",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-action=/leave/view",
		"javax.portlet.init-param.view-template=/leave/view.jsp",
		"javax.portlet.name=" + LeavePortletKeys.Leave,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LeavePortlet extends MVCPortlet {
}