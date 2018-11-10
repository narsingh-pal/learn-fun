<#include "${full_templates_path}/top_public_navigation_m.ftl" /> 
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                <i class="glyphicon glyphicon-align-left"></i>
                <span>My Dashboard</span>
            </button>
        </div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		    <ul class="nav navbar-nav navbar-right">
		   		 <@getAllPages layouts=publicLayouts depth=0 /> 
		    </ul>
		</div>
	</div>
</nav>

