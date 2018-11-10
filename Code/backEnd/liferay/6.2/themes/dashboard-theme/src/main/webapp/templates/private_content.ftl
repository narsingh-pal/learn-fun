   	
	            <!-- Page Content Holder -->
	            <div id="content">
	            	<#if privateLayouts?has_content>
	        			<#include "${full_templates_path}/top_public_navigation.ftl" /> 
	        		</#if>
	                 <nav id="breadcrumbs"><@liferay.breadcrumbs /></nav> 
					<#if selectable>
						${theme.include(content_include)}
					<#else>
						${portletDisplay.recycle()}
						${portletDisplay.setTitle(the_title)}
						${theme.wrapPortlet("portlet.ftl", content_include)}
					</#if>
	            </div>