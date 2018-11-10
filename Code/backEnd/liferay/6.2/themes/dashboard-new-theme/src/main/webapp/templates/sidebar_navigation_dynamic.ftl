<#include "${full_templates_path}/sidebar_navigation_m.ftl" /> 
<nav id="sidebar">
                <div class="sidebar-header">
                    <a href="${site_default_url}">
                    	<img id="profilePicture" alt="${user_first_name} ${user_last_name}" src="${profileImageSrc}" class="img-responsive" />
                    </a>
                     <h3 id="sideBarBrandName"> Company</h3> 
                    <#-- <strong>RJ</strong> -->
                    <strong><img alt="${logo_description}" src="${site_logo}" class="img-responsive" />  </strong>
                </div>
                <ul class="list-unstyled components" id="sidebarprivatepages">
                     <@getAllPages layouts=privateLayouts depth=0 /> 
                </ul>
</nav>