<#--
This file allows you to override and define new FreeMarker variables.
-->

<#------ Theme Settings -------------------------------------------------->

<#assign showBreadcrumbs = theme_display.getThemeSetting("show-breadcrumbs") />
<#assign loginPageTitle = theme_display.getThemeSetting("login-page-title") />
<#assign homePageTitle = theme_display.getThemeSetting("home-page-title") />
<#assign headerArticleId = theme_display.getThemeSetting("header-article-id") />
<#assign defaultSiteName = theme_display.getThemeSetting("site-name") />
<#assign fullNavigationEnabled = theme_display.getThemeSetting("full-navigation-enabled") />
<#assign homeCarousal = theme_display.getThemeSetting("home-carousal") />


<#------ Taglibs -------------------------------------------------->

<#assign liferay_ui=PortalJspTagLibs["/WEB-INF/tld/liferay-ui.tld"]>
<#assign aui=PortalJspTagLibs["/WEB-INF/tld/liferay-aui.tld"]>

<#------ Define services -------------------------------------------------->

<#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.service.LayoutLocalService") />
<#assign layoutService =  serviceLocator.findService("com.liferay.portal.service.LayoutService") />
<#assign groupLocalService =  serviceLocator.findService("com.liferay.portal.service.GroupLocalService") />
<#assign layoutSetLocalService = serviceLocator.findService("com.liferay.portal.service.LayoutSetLocalService") />
<#assign userGroupRoleLocalService = serviceLocator.findService("com.liferay.portal.service.UserGroupRoleLocalService") />

<#assign expandoValueLocalService = serviceLocator.findService("com.liferay.portlet.expando.service.ExpandoValueLocalService") />
<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.portlet.journal.service.JournalArticleLocalService") />


<#assign profileImageSrc = theme_display.getUser().getPortraitURL(theme_display) />


<#------ Define variables -------------------------------------------------->

<#assign portal_url_modified = "" />
<#assign modified_logo_tooltip = "" />

<#assign nav_css_class = "" />

<#assign url = request.getAttribute('CURRENT_URL')>
<#if url??>
	<#assign value = httpUtil.getParameter(url, "_58_struts_action", false) />
	<#if value?has_content>
		<#assign login_requested = true />
	<#else>
		<#assign login_requested = false /> 
	</#if>
</#if>



<#if groupLocalService??>
	<#assign group = groupLocalService.getGroup(company_id,defaultSiteName) />
	<#if group??>
		<#assign siteFriendlyUrl = group.getFriendlyURL() />
		<#assign privateLayoutsTemp = layoutService.getLayouts(group.groupId, true, 0) />
		<#assign publicLayoutsTemp = layoutService.getLayouts(group.groupId, false, 0) />
		<#assign privateLayouts=[]> 
		<#assign publicLayouts=[]> 
		
		<#list privateLayoutsTemp as privateLayout>
			<#if !privateLayout.isHidden()>
				<#assign privateLayouts = privateLayouts + [privateLayout] />
			</#if>
		</#list>
		
		
		<#list publicLayoutsTemp as publicLayout>
			<#if !publicLayout.isHidden()>
				<#assign publicLayouts = publicLayouts + [publicLayout] />
			</#if>
		</#list>
		
	</#if>
</#if>
<#assign currentPageName = themeDisplay.getLayout().getName(locale) />

<#------ Expando values -------------------------------------------------->





<#macro includeWCD group_id article_id>
	<#if article_id != "">
		<#local portlet_instance_suffix = "nsp" />
		<#local instance_id = "wcd" + article_id + portlet_instance_suffix />
		<#local instance_id = instance_id?substring(0, 12) />
		<#local portlet_id = "56_INSTANCE_" + instance_id />

		${freeMarkerPortletPreferences.reset()}

		${freeMarkerPortletPreferences.setValue("portletSetupShowBorders","false")}
		${freeMarkerPortletPreferences.setValue("groupId", group_id?c)}
		${freeMarkerPortletPreferences.setValue("articleId", article_id)}

		${theme.runtime(portlet_id, "", freeMarkerPortletPreferences)}
		${freeMarkerPortletPreferences.reset()}
	<#else>
		&nbsp;
	</#if>
</#macro>

<#macro includeWC webContentURLTitle>
	<#assign journalArticle = journalArticleLocalService.getArticleByUrlTitle(theme_display.getScopeGroupId(), webContentURLTitle)> 
	<#assign articleId = journalArticle.getArticleId()>
	<#assign templateId = journalArticle.getTemplateId()>
	<#assign journalArticleContent = journalContentUtil.getContent(theme_display.getScopeGroupId(), articleId,templateId,locale,theme_display)>
	${journalArticleContent}
</#macro>


