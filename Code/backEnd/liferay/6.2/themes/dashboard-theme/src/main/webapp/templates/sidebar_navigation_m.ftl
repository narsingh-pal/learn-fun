<#------ Macros -------------------------------------------------->

<#-- get full page based on the URL of current site and layout type public|private-->
<#macro getPageUrl mSiteFriendlyUrl mmlayout>
	<#assign mmTempPageURL = mSiteFriendlyUrl + mmLayout.getFriendlyURL() />
	<#if mmLayout.getPrivateLayout() == "true">
		<#assign mmPageURL = "/group" + mmTempPageURL />
	<#else>
		<#assign mmPageURL = "/group" + mmTempPageURL />
	</#if>>
	${mmPageURL}
</#macro>


<#-- Get html markup of all pages -->
<#macro getAllPageHtml mLayout mHasChildren depth>
	<#assign mPageName = mLayout.getName(locale) /> 
	<#assign mPageId = mPageName?replace(" ", "-") /> 
	<#assign mPageId = mPageId?replace("&", "1") /> 
	<#assign mTempPageURL = siteFriendlyUrl + mLayout.getFriendlyURL() /> 
	<#assign glyphiconClass = mLayout.getExpandoBridge().getAttribute("pageclass")>
	
	<#if mLayout.getPrivateLayout() == true>
		  <#assign mPageURL = "/group"+ mTempPageURL /> 
	<#else>
		<#assign mPageURL = "/web"+ mTempPageURL /> 
	</#if>
	
	<#if mPageName == currentPageName  && mHasChildren == "true"> <#--	- [ Current page and has children] -->
			<li class="active">
	<#elseif mPageName == currentPageName> <#--		- [ Current page and doesnot have children] -->
			<li class="active">			  
	<#elseif mHasChildren == "true" >  <#-- ##		- [Not Current page and Has children] -->
			<li>
	<#elseif mPageName != loginPageTitle>  <#-- ###       - [Not Current page and doesnot have children] -->
			<li>						  
	</#if>
	
	<#if mHasChildren == "true">
		<a href="#${mPageId}"  data-toggle="collapse" aria-expanded="false"> 
			<#if depth==1>
					<i class="${glyphiconClass}"></i>	
			</#if>	
			${mPageName} 
		</a>
	<#else>
		<a href="${mPageURL}" > 
			<#if depth==1>
					<i class="${glyphiconClass}"></i>	
			</#if>
			${mPageName} 
		</a>
	</#if>
</#macro>

<#macro getAllPages layouts depth>
	<#list layouts as layout>
		<#assign depthTemp =  depth +1 /> 
		<#assign mChildernLayouts = layout.getChildren()  /> 
		<#if depthTemp < 4>
			<#if layout.getChildren()?size != 0>
				<#assign hasChildren = "true"/>
				<#assign pageName = layout.getName(locale) /> 
				<#assign pageId = pageName?replace(" ", "-") />
				<#assign pageId = pageId?replace("&", "1") /> 
				<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
				<ul class="collapse list-unstyled" id="${pageId}">
				<@getAllPages layouts=mChildernLayouts depth=depthTemp /> 
				</li>
				</ul>
			<#else>
				<#assign hasChildren = "false"/>
				<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
			</#if>
		</#if>
	</#list>
</#macro>

