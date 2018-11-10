<#if currentPageName?lower_case=="home">
	<#-- <#assign li_css_class = "class='active'" /> -->
	<#assign li_css_class = "" />
<#else>
	<#assign li_css_class = "" />
</#if>

<#if is_signed_in && permissionChecker.isOmniadmin()>
	<nav class="navbar navbar-default" role="navigation" id="publicNavBar">
<#else>
	<nav class="navbar navbar-fixed-top navbar-default" role="navigation" id="publicNavBar">
</#if>


    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>
     <#-- <a class="navbar-brand navbar-brand-centered1" href="${site_default_url}" id="brandImage"> -->
     <a class="navbar-brand navbar-brand-centered1" href="${site_default_url}" id="brandImage">
     	 <img alt="${logo_description}" src="${site_logo}" class="img-responsive" /> 
     </a> 
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="navbar-collapse-1">
    	<ul class="nav navbar-nav navbar-left">
	        <li ${li_css_class}><a href="${site_default_url}" id="homePublic"> <span><i class="icon-home"></i></span></a></li>
	        <#if is_signed_in>
	        	<li><img id="profilePicture1" alt="${user_first_name} ${user_last_name}" src="${profileImageSrc}" class="img-responsive" /></li>
	        	<li id="greetingPublic"><#include "${full_templates_path}/greeting.ftl" /> </li>
	        </#if>
	    </ul>
	    

	    <ul class="nav navbar-nav navbar-right">
	    	<#list nav_items as nav_item>
	    		<#assign currLayout = nav_item.getLayout()>
	    		<#assign ismmenabled = currLayout.getExpandoBridge().getAttribute("megamenu")>
	    		<#if nav_item.name == currentPageName && ismmenabled>
	    			 <#assign li_css_class = "class='active dropdown menu-large'" />
				<#elseif  nav_item.name == currentPageName && !ismmenabled>
					 <#assign li_css_class = "class='active'" />
				<#elseif  !(nav_item.name == currentPageName) && ismmenabled>
					<#assign li_css_class = "class='dropdown menu-large'" />
				<#else>
					<#assign li_css_class = "" />
				</#if>
		    	<li ${li_css_class}>
					<#if (nav_item.name?lower_case == "home")>
						<#-- <a href="${nav_item.getURL()}"> <span><i class="icon-home"></i></span></a> -->
					<#else>
						<#if ismmenabled>
							<#assign ptitle=nav_item.getName()>
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${ptitle}</a>	
							 <@includeWC webContentURLTitle=ptitle?lower_case /> 
						<#else>
							<a href="${nav_item.getURL()}"}>${nav_item.getName()}</a>
						</#if>
					</#if>
				</li>
			</#list>  
	     <#if is_signed_in>
		    <#include "${full_templates_path}/logout.ftl" />
		 <#else>
		 	  <#include "${full_templates_path}/login_popup.ftl" /> 
		 </#if>
		</ul>
    </div><!-- /.navbar-collapse -->
</nav>

