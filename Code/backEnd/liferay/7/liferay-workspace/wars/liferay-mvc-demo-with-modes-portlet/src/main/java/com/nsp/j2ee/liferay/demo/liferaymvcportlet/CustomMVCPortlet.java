package com.nsp.j2ee.liferay.demo.liferaymvcportlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.*;
import java.io.IOException;

public class CustomMVCPortlet extends MVCPortlet {
    private static Log _log = LogFactoryUtil.getLog(CustomMVCPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {
        _log.warn("Do VIEW called");
        PortletPreferences portletPreferences = renderRequest.getPreferences();
        String background = portletPreferences.getValue("background", "");
        _log.warn("background : " + background);
        super.doView(renderRequest, renderResponse);
    }

    public void savePreferences(ActionRequest actionRequest,
                                  ActionResponse actionResponse) throws ReadOnlyException, IOException, ValidatorException, PortletModeException {
        _log.warn("Do savePreferenses called");
        String background = ParamUtil.getString(actionRequest,"bgColor");
        PortletPreferences portletPreferences = actionRequest.getPreferences();
        _log.warn(" OLD background : " + portletPreferences.getValue("background",""));
        portletPreferences.setValue("background",background);
        portletPreferences.store();
        _log.warn(" NEW background : " + portletPreferences.getValue("background",""));
        actionResponse.setPortletMode(PortletMode.VIEW);
    }

    @Override
    public void doEdit(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        _log.warn("Do doEdit called");
        PortletPreferences portletPreferences = renderRequest.getPreferences();
        String background = portletPreferences.getValue("background", "");
        _log.warn("background : " + background);
        if (portletPreferences == null) {
            super.doEdit(renderRequest, renderResponse);
        }
        else {
            include(editTemplate, renderRequest, renderResponse);
        }
    }
}
