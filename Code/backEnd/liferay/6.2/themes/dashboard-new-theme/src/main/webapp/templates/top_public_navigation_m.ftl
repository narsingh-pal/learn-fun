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
	<#assign mTempPageURL = siteFriendlyUrl + mLayout.getFriendlyURL() /> 
	<#if mPageName == currentPageName  && mHasChildren == "true" && mPageName!=loginPageTitle> <#--	- [ Current page and has children] -->
		<#if depth==1>
			<li class="active">
		<#else>
			<li class="active"> 
		</#if>
	<#elseif mPageName == currentPageName && mPageName!=loginPageTitle> <#--		- [ Current page and doesnot have children] -->
		<li class="active">			  
	<#elseif mHasChildren == "true" >  <#-- ##		- [Not Current page and Has children] -->
		<#if depth==1>
			<li>
		<#else>
			<li>
		</#if>
	<#elseif mPageName != loginPageTitle>  <#-- ###       - [Not Current page and doesnot have children] -->
		<li>						  
	</#if>
	
	<#if mLayout.getPrivateLayout() == true>
		  <#assign mPageURL = "/group"+ mTempPageURL /> 
	<#else>
		<#assign mPageURL = "/web"+ mTempPageURL /> 
	</#if>
	
	<#if (mPageName?lower_case == "home")>
		 <#if !(layout.isPublicLayout())>
		 	<a href="${mPageURL}"> <span><i class="icon-home"></i></span></a>
		 </#if> 
	<#else>	
		<a href="${mPageURL}"> ${mPageName}</a>	
	</#if>
	
	

</#macro>

<#macro getAllPages layouts depth>
	<#list layouts as layout>
		<#assign depthTemp =  depth +1 /> 
		<#assign mChildernLayouts = layout.getChildren()  /> 
			<#if depthTemp < 2>
				<#if layout.getChildren()?size != 0>
					<#assign hasChildren = "false"/>
					<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
					<@getAllPages layouts=mChildernLayouts depth=depthTemp /> 
					</li>
				<#else>
					<#assign hasChildren = "false"/>
					<@getAllPageHtml mLayout=layout mHasChildren=hasChildren depth=depthTemp /> 
				</#if>
			</#if>
	</#list>
</#macro>

