<#include "${full_templates_path}/top_public_navigation_m.ftl" /> 
<div class="container-fluid">
	<nav class="navbar navbar-inverse navbar-default" id="publicPages">
	        <div class="navbar-header">
	          <#--  <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
	                <i class="glyphicon glyphicon-align-justify"></i>
	                <span>My Dashboard</span>
	            </button>
	            -->
	             <button type="button" id="sidebarCollapse1" class="navbar-btn">
	                <span></span>
	                <span></span>
	                <span></span>
	            </button> 
	            
	        </div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
				 	<li id="greeting">
			   		 	<#include "${full_templates_path}/greeting.ftl" />
			   		</li>
			    </ul>
			    <ul class="nav navbar-nav navbar-right">
			   		 <@getAllPages layouts=publicLayouts depth=0 /> 
			   		 <#if is_signed_in>
					    <#include "${full_templates_path}/logout.ftl" />
					 <#else>
					 	  <#include "${full_templates_path}/login_popup.ftl" /> 
					 </#if>
			    </ul>
			</div>
	</nav>
</div>
