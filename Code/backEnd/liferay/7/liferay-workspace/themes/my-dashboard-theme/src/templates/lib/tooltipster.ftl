<div class="container-fluid">
    <div id="demo-html" data-tooltip-content="#demo-html-content">
        Hover
    </div>

    <img class="demo-image" src="${images_folder}/spiderman.png"  title="This is my image's tooltip message!" />

    <div class="demo-span" title="This is my span's tooltip message!">
        Some text
    </div>

    <div class="demo-span-click" data-tooltip-content="#tooltip_content">
        This span has a tooltip with HTML when you click it!
    </div>

    <#--tooltip templates. these should be hidden by default-->
    <div class="tooltip_templates">
        <div id="demo-html-content">
            <img src="${images_folder}/green_suburb.jpg" width="50" height="50" />
            <p style="text-align:left;">
                <strong>Lorem ipsum dolor sit amet</strong><br />
                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu.
            </p>
        </div>
        <span id="demo-position-content">I'm the most accurate tooltip ever! Let me fit to your layout the way you want to. I'm great to create menus too :)</span>
        <span id="tooltip_content">
            <img src="${images_folder}/spiderman.png" /> <strong>This is the content of my tooltip!</strong>
        </span>
    </div>
</div>