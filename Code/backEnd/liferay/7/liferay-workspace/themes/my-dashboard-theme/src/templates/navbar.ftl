<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <#list nav_items as nav_item>
                    <#assign
                    nav_item_attr_has_popup = ""
                    nav_item_attr_selected = ""
                    nav_item_css_class = ""
                    nav_item_css_active_class = ""
                    nav_item_css_dropdown_open_class = ""
                    nav_item_layout = nav_item.getLayout()
                    />

                    <#if nav_item.isSelected()>
                        <#assign
                        nav_item_attr_has_popup = "aria-haspopup='true'"
                        nav_item_attr_selected = "aria-selected='true'"
                        nav_item_css_class = "selected"
                        nav_item_css_active_class = "active"
                        nav_item_css_dropdown_open_class = "open"
                        />
                    </#if>
                     <#if nav_item.hasChildren()>
                         <#assign dropdownToggle = "dropdown-toggle" />
                         <#assign dropdownClass = "dropdown" />
                         <#assign dataToggle = "data-toggle='dropdown'" />
                     <#else>
                         <#assign dropdownToggle = "" />
                         <#assign dropdownClass = "" />
                         <#assign dataToggle = "" />

                     </#if>
                    <li ${nav_item_attr_selected} class="${nav_item_css_class } ${nav_item_css_active_class} ${dropdownClass}" id="layout_${nav_item.getLayoutId()}" role="presentation">
                        <a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup}
                           href="${nav_item.getURL()}" ${nav_item.getTarget()}
                           role="menuitem"
                           class="${dropdownToggle}"
                           ${dataToggle} aria-expanded="true">
                            <span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span>
                            <#if nav_item.hasChildren()>
                                <span class='caret'></span>
                            </#if>
                        </a>

                        <#if nav_item.hasChildren()>
                            <ul class="dropdown-menu" role="menu">
                                <#list nav_item.getChildren() as nav_child>
                                    <#assign
                                    nav_child_attr_selected = ""
                                    nav_child_css_class = ""
                                    />

                                    <#if nav_item.isSelected()>
                                        <#assign
                                        nav_child_attr_selected = "aria-selected='true'"
                                        nav_child_css_class = "selected dropdown open"
                                        />
                                    </#if>

                                    <li id="layout_${nav_child.getLayoutId()}" role="presentation">
                                        <a aria-labelledby="layout_${nav_child.getLayoutId()}"
                                           href="${nav_child.getURL()}" ${nav_child.getTarget()}
                                           role="menuitem">
                                            ${nav_child.getName()}
                                        </a>
                                    </li>
                                </#list>
                            </ul>
                        </#if>
                    </li>
                </#list>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                <#--<@liferay.search/>-->
            </form>

            <ul class="nav navbar-nav navbar-right">
                <li>

                    <#if !is_signed_in>
                        <a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
                    <#else>
                    <a href="/c/portal/logout">Logout</a>
                    </#if>

                </li>
            </ul>
        </div>
    </div>
</nav>