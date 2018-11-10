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
	<#assign mPageName = mLayout.getName() /> 
	<#assign mTempPageURL = siteFriendlyUrl + mLayout.getFriendlyURL() /> 
	<#if mPageName == currentPageName  && mHasChildren == "true" && !mPageName.contains(loginPageTitle)> <#--	- [ Current page and has children] -->
		<#if depth==1>
			<li class="active dropdown-menu">
		<#else>
			<li class="active dropdown-submenu"> 
		</#if>
	<#elseif mPageName == currentPageName && !mPageName.contains(loginPageTitle)> <#--		- [ Current page and doesnot have children] -->
		<li class="active">			  
	<#elseif mHasChildren == "true" >  <#-- ##		- [Not Current page and Has children] -->
		<#if depth==1>
			<li class="dropdown-menu">
		<#else>
			<li class="dropdown-submenu">
		</#if>
	<#elseif mPageName != loginPageTitle>  <#-- ###       - [Not Current page and doesnot have children] -->
		<li>						  
	</#if>
	
	
	<#if mLayout.getPrivateLayout() == true>
		  <#assign mPageURL = "/group"+ mTempPageURL /> 
	<#else>
		<#assign mPageURL = "/web"+ mTempPageURL /> 
	</#if>
	
	<#if mHasChildren == "true">
		<#if depth==1>
			<a href="${mPageURL}" data-target="${mPageURL}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> ${mPageName} <b class="caret"></b></a>	
		<#else>
			<a href="${mPageURL}" data-target="${mPageURL}" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"> ${mPageName} </a>	
		</#if>
	<#else>
		<#if mPageName==loginPageTitle && !is_signed_in>
			<#assign loginUrl = "<a data-target='.nav-collapse' href='" + mPageURL + "'><span>" + mPageName + "</span></a>" /> 
		<#elseif mPageName!=loginPageTitle || !is_signed_in>
			<a data-target=".nav-collapse" href="${mPageURL}" data-target="${mPageURL}"><span>${mPageName}</span></a>
			</li>
		</#if>
		
	</#if>
</#macro>

<#macro getAllPages layouts depth>
	<#list layouts as layout>
		<#assign depthTemp =  depth +1 /> 
		<#assign mChildernLayouts = layout.getChildren()  /> 
		
		
			<#if layout.getChildren()?size != 0>
				<#assign hasChildren = "true"/>
				<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
				<ul class="dropdown-menu">
				<@getAllPages layouts=mChildernLayouts depth=depthTemp /> 
				</li>
				</ul>
			<#else>
				<#assign hasChildren = "false"/>
				<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
			</#if>
		
		
		
	</#list>
</#macro>

