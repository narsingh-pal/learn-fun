Setup simple tomcat cluster
**1. Download Apache Web Server for windows**
You can obtain a binary package from numerous binary distributions available on the Internet.

		Popular options for deploying Apache httpd, and, optionally, PHP and MySQL, on Microsoft Windows, include:

		-   [ApacheHaus](http://www.apachehaus.com/cgi-bin/download.plx)
		-   [Apache Lounge](http://www.apachelounge.com/download/)
		-   [BitNami WAMP Stack](http://bitnami.com/stack/wamp)
		-   [WampServer](http://www.wampserver.com/)
		-   [XAMPP](http://www.apachefriends.org/en/xampp.html)
**3. Apache web server configuration**

 - a. Basic configuration
		Apache for Windows contains the ability to load modules at runtime, without recompiling the server. If Apache is compiled normally, it will install a number of optional modules in the `\Apache2.4\modules` directory. To activate these or other modules, the `[LoadModule](https://httpd.apache.org/docs/2.4/mod/mod_so.html#loadmodule)` directive must be used. 
 - For example, to activate the mod_jk module, use the following

			LoadModule jk_module modules/mod_jk.so
b. Cluster configuration
4. Tomcat cluster nodes configuration
