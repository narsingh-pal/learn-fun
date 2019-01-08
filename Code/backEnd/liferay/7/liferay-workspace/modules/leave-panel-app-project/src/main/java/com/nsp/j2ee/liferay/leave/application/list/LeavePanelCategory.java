package com.nsp.j2ee.liferay.leave.application.list;

import com.liferay.application.list.BaseJSPPanelCategory;
import com.nsp.j2ee.liferay.leave.constants.LeavePanelCategoryKeys;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author napa0817
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL,
		"panel.category.order:Integer=10000"
	},
	service = PanelCategory.class
)
public class LeavePanelCategory extends BasePanelCategory   {
    static final private Logger logger = LoggerFactory.getLogger(LeavePanelCategory.class);
    @Activate
    public void activate(){
        logger.info("Leave Panel Category: ACTIVATED");
    }

	@Override
	public String getKey() {
		return LeavePanelCategoryKeys.CONTROL_PANEL_CATEGORY;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "category.custom.label");
	}

    @Override
    public boolean include(
            HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setAttribute(LeavePanelCategoryKeys.CONTROL_PANEL_CATEGORY, this);

        return super.include(request, response);
    }

    /*@Override
    @Reference(
            target = "(osgi.web.symbolicname=com.nsp.j2ee.liferay.leave.panel.app)",
            unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {
        super.setServletContext(servletContext);
    }

    @Override
    public String getHeaderJspPath() {
        return "/leave_header.jsp";
    }

    @Override
    public String getJspPath() {
        return "/leave_body.jsp";
    }*/
}