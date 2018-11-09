<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />
<div class="" id="topHeader">
    <header id="banner" role="banner">
        <div id="heading">
            <h1 class="site-title">
                <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                    <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
                </a>
				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
                    </span>
				</#if>
            </h1>
        </div>

		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
    </header>
</div>
<div class="jumbotron container-fluid">
    <div style="clear:both;">
        Curabitur a felis in nunc fringilla tristique. Vivamus euismod mauris. Aenean massa. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis.

        Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Mauris turpis nunc, blandit et, volutpat molestie, porta ut, ligula. Proin magna. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor.

        Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Aliquam lobortis. Ut tincidunt tincidunt erat. Nulla porta dolor.

        Quisque id mi. Nunc nonummy metus. Nullam quis ante. Vivamus aliquet elit ac nisl.
    </div>
    <br/>
    <div style="clear:both;">
        Curabitur a felis in nunc fringilla tristique. Vivamus euismod mauris. Aenean massa. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis.

        Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Mauris turpis nunc, blandit et, volutpat molestie, porta ut, ligula. Proin magna. Suspendisse faucibus, nunc et pellentesque egestas, lacus ante convallis tellus, vitae iaculis lacus elit id tortor.

        Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Aliquam lobortis. Ut tincidunt tincidunt erat. Nulla porta dolor.

        Quisque id mi. Nunc nonummy metus. Nullam quis ante. Vivamus aliquet elit ac nisl.
    </div>
<div class="container-fluid" id="wrapper">


	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<nav id="breadcrumbs">
			<@liferay.breadcrumbs />
		</nav>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>


</div>

<div class="container-fluid" id="bottomFooter">
    <footer id="footer" role="contentinfo">
        <p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
        </p>
    </footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
    <#--<script type="text/javascript" src="${javascript_folder}/config.js"></script>-->
<!-- endinject -->

</body>

</html>