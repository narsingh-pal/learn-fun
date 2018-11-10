<!DOCTYPE html>

<#include init />
<#include "${full_templates_path}/show-variables.ftl" /> 
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="initial-scale=1.0, width=device-width" name="viewport" />
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
		${theme.include(top_head_include)}
		<!-- jQuery -->
	 	 <@liferay.js file_name="${javascript_folder}/jquery-2.2.4.js"/> 
	 	<#--<@liferay.js file_name="${javascript_folder}/jquery-1.11.3.min.js"/>-->
	 	<@liferay.js file_name="${javascript_folder}/canvasjs.min.js"/>
	    <!-- Bootstrap -->
	    <@liferay.js file_name="${javascript_folder}/bootstrap.js"/>
	    <@liferay.js file_name="${javascript_folder}/jquery.bootstrap-autohidingnavbar.js"/>
	    <@liferay.js file_name="${javascript_folder}/css3-animate-it.js"/>
	    <@liferay.js file_name="${javascript_folder}/jquery.dataTables.min.js"/>
	    
</head>

<body class="${css_class}">
${theme.include(body_top_include)}


<#include "${full_templates_path}/login_model.ftl" /> 

<#if is_signed_in && permissionChecker.isOmniadmin()>
	<@liferay.dockbar />
</#if>
 <#if layout.isPublicLayout()>
 	<#if ! login_requested>
 		<#include "${full_templates_path}/public_navigation_dynamic.ftl" />
 	</#if> 
 </#if>
 
 <#if currentPageName?lower_case==homePageTitle?lower_case>
  <#-- <#include "${full_templates_path}/hero_header.ftl" /> -->
  <#-- <@includeWCD group_id=group.groupId article_id="homecarousal" /> -->
  <#if ! login_requested>
  	<@includeWCD group_id=group.groupId article_id=homeCarousal />  
  </#if>
 </#if>
        <div class="wrapper">
       	 <#if layout.isPublicLayout()>
       	 	<#include "${full_templates_path}/public_content.ftl" />
       	 <#else>
       	 	<#if privateLayouts?has_content>
	        		<!-- Sidebar Holder -->
	            	<#include "${full_templates_path}/sidebar_navigation_dynamic.ftl" /> 
	        </#if>
	        <#include "${full_templates_path}/private_content.ftl" />
       	 </#if>
        </div>
        <#-- <#include "${full_templates_path}/footer.ftl" />-->
         <@includeWCD group_id=group.groupId article_id="footer" />  
${theme.include(body_bottom_include)}
${theme.include(bottom_include)}

</body>
</html>