package com.nsp.j2ee.liferay.leave.application.list;

import com.nsp.j2ee.liferay.leave.constants.LeavePanelCategoryKeys;
import com.nsp.j2ee.liferay.leave.constants.LeavePortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.application.list.constants.PanelCategoryKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author napa0817
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=9900",
		"panel.category.key=" + LeavePanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class LeavePanelApp extends BasePanelApp {
    static final private Logger logger = LoggerFactory.getLogger(LeavePanelApp.class);

    @Activate
    public void activate(){
        logger.info("Leave Panel : ACTIVATED");
    }
	@Override
	public String getPortletId() {
		return LeavePortletKeys.Leave;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LeavePortletKeys.Leave + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		// make sure the above portlet mentioned in the target is non-instantiable portlet
		super.setPortlet(portlet);
	}




}