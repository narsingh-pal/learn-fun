	            <!-- Page Content Holder -->
	            <div id="content">
	            	<#if  !(currentPageName?lower_case == "home")>
	            		<nav id="breadcrumbs"><@liferay.breadcrumbs /></nav> 
	            	</#if>
					<#if selectable>
						${theme.include(content_include)}
					<#else>
						${portletDisplay.recycle()}
						${portletDisplay.setTitle(the_title)}
						${theme.wrapPortlet("portlet.ftl", content_include)}
					</#if>
	            </div>