https://www.javacodegeeks.com/2012/06/apache-http-server-with-tomcat-on-ssl.html
# Apache HTTP server with Tomcat on SSL

**Introduction**

I recently needed to simulate our production deployment environment in my local machine. Our production applications are running on Apache HTTP server. We deploy application on multiple tomcat instances and also different Tomcats for different URL name spaces. Apache HTTP server is responsible as front door for all these. Apache HTTP server connects to the tomcat with mod_jk over mod_ssl. When Apache HTTP server receives a request, it checks for the requests and forward to the tomcat accordingly. This configuration is important for security and clustering.

This tutorial contains following sections.

1.  Installing and configuring Apache HTTP server.
2.  Installing and configuring Apache tomcat.
3.  Installing and configuring mod_jk.
4.  Configuring mod_ssl.
5.  Testing the environment.

**Installing and configuring Apache HTTP server.**

Run the following command to download Apache HTTP server 2.2.22

`wget http:``//mirrors.gigenet.com/apache//httpd/httpd-2.2.22.tar.bz2`
`wget http:``//www.apache.org/dist/httpd/httpd-2.2.22.tar.bz2.md5`
`md5sum -c httpd-``2.2``.``22``.tar.bz2.md5`

After executing above command, httpd-2.2.22.tar.bz2 archive will be downloaded to your “Downloads” folder. To extract the zipped archive file, run the following command from /Downloads folder.
`cd /home/semika/Downloads`
`tar -xjvf httpd-``2.2``.``22``.tar.bz2`

Above command will extract the zipped archive file into httpd-2.2.22 folder under Downloads folder. Now, you should decide where you are going to install Apache HTTP server. I am going to install it to /home/semika/httpd-2.2.22 folder. You have to create the folder there. Navigate to your user folder and execute the following command to create new folder.
`cd /home/semika`
`mkdir httpd-``2.2``.``22`

To install Apache to your particular platform, we need to compile the source distribution that we have already downloaded. If you see carefully inside the extracted folder under Downloads/httpd-2.2.22, you can see there is a  _configure_  script. We can compile the source distribution with that script and it will create necessary stuff to install Apache HTTP server.

When compiling Apache, various options can be specified that are suited to our local environment. For the complete reference of options provided, see here.

Since, we need mod_ssl to be configured with Apache compilation, we need to install OpenSSL development bundle. Otherwise, compilation will raise an exception. To install OpenSSL development libraries, run the following command.
`sudo apt-get install openssl libssl-dev`

Sometime, You might need to run the following command as well, if you encounter an error while apache compilation.
`sudo apt-get install zlib1g-dev`
`sudo apt-get install libxml2-dev`

To compile Apache source distribution, execute the following commands.
`cd /home/semika/Downloads/httpd-``2.2``.``22`
`./configure --prefix=/home/semika/httpd-``2.2``.``22`  `--enable-mods-shared=all --enable-log_config=``static`  `--enable-access=``static`  `--enable-mime=``static`  `--enable-setenvif=``static`  `--enable-dir=``static`  `-enable-ssl=yes`

**–prefix**  : You can specify the installation directory  
**–enable-mods-shared**  : Setting this to ‘all’ will enable to install all the shared modules.  
**–enable-ssl**  : Since we are going to configure Apache HTTP server with mod_ssl, this has been set to ‘yes’ to compile Apache with mod_ssl. By default this option is disabled.

For other options specified in the configuration command, please look into full options reference documentation. After successfully running the above command, execute the following commands. Before execute the following command, just have look on your specified installation directory, ie:  **_/home/semika/httpd-2.2.22_**, you can see that it is still empty.
`make`
`make install`

Now, you can see Apache HTTP server has been installed under  **_/home/semika/httpd-2.2.22._**  Look for modules folder, you can see the list of modules installed. Confirm, whether it has installed  **mod_ssl.so**. Now, you can start the Apache HTTP server.
`cd /home/semika/httpd-``2.2``.``22``/bin`
`sudo ./apachectl start`

If you see bellow line when executing the above command,

“**httpd: Could not reliably determine the server’s fully qualified domain name, using 127.0.1.1 for ServerName**”

edit your  **_/httpd-2.2.22/conf/httpd.conf_**  file as follows. Look for ”  **ServerName**” property in  **httpd.conf**  file. You will see following line there.
`#ServerName www.example.com:``80`

Uncomment this line and modify it as follows.
`ServerName localhost`

Again start the Apache HTTP server. If you did not change the default port which Apache server is running, check the following URL to check whether server is started or not. The default Apache HTTP server running port is 80.

http://localhost/

With the above URL, if you see a page with “It works”, you are done with Apache HTTP server.

Further, if you want to change the default port, you can edit the httpd.conf file as follows. Look for “Listen” property and change it as you wish.

I have set it to 7000. So my Apache HTTP server is running on 7000. I have to access the following URL to get “It works” page.

http://localhost:7000/

To stop Apache HTTP server,execute the following command.
`cd /home/semika/httpd-``2.2``.``22``/bin`
`sudo ./apachectl stop`

**Installing and configuring Apache tomcat.**

Installing and configuring Apache tomcat is not a big thing, if you are involving with this kind of advance configuration. For the completeness of the tutorial, I will explain that a little. I am using Apache Tomcat 7.0.25. You can download it from Apache web site and extract it to some where in you local machine. After that, you have to set the environment variable as follows.
`export CATALINA_HOME=/home/semika/apache-tomcat-``7.0``.``25`
`export PATH=$CATALINA_HOME/bin:$PATH`

You can start the tomcat with following command.
`cd home/semika/apache-tomcat-``7.0``.``25``/bin`
`./startup.sh`

If you want to see tomcat’s console out put, execute the following commands before starting the tomcat.
`cd home/semika/apache-tomcat-``7.0``.``25``/logs/`
`tail -f catalina.out`

After successfully starting the tomcat, try the following URL

**http://localhost:8080/**

By default, tomcat will run on port 8080. Now our Apache HTTP server is running on port 7000 and tomcat is on 8080.

Further, to configure Tomcat with Apache HTTP server, we need to create  **workers.properties**  file under**home/semika/apache-tomcat-7.0.25/conf/.**

**_workers.properties_**

`# Define` `1`  `real worker named ajp13`
`worker.list=ajp13`
`# Set properties` `for`  `worker named ajp13 to use ajp13 protocol,`
`# and run on port` `8009`
`worker.ajp13.type=ajp13`
`worker.ajp13.host=localhost`
`worker.ajp13.port=``8009`
`worker.ajp13.lbfactor=``50`
`worker.ajp13.cachesize=``10`
`worker.ajp13.cache_timeout=``600`
`worker.ajp13.socket_keepalive=``1`
`worker.ajp13.socket_timeout=``300`

Apache HTTP server will connect to Tomcat through port 8009. If you see  **server.xml**  file under Tomcat’s  **conf**  folder, you can see following connector declaration there.
`<Connector port=``"8009"`  `protocol=``"AJP/1.3"`  `redirectPort=``"8443"`  `/>`

**Installing and configuring mod_jk**

If you look into  **httpd-2.2.22/modules**  folder, you can see  **mod_jk.so**  has been installed. The mod_jk is a connector for Apache HTTP server to connect to Apache Tomcat. To configure, you have to load mod_jk.so module to Apache HTTP server.

Edit  **/httpd-2.2.22/conf/httpd.conf**  file as follows. You need to add these properties.

`# Load mod_jk module`
`# Update` `this`  `path to match your modules location`
`LoadModule jk_module modules/mod_jk.so`
`# Where to find workers.properties`
`# Update` `this`  `path to match your conf directory location`
`JkWorkersFile /home/semika/apache-tomcat7.0.25/conf/workers.properties`
`# Where to put jk logs`
`# Update` `this`  `path to match your logs directory location`
`JkLogFile /home/semika/apache-tomcat-7.0.25/logs/mod_jk.log`
`# Set the jk log level [debug/error/info]`
`JkLogLevel info`
`# Select the log format`
`JkLogStampFormat` `"[%a %b %d %H:%M:%S %Y]"`
`# JkOptions indicate to send SSL KEY SIZE,`
`JkOptions +ForwardKeySize +ForwardURICompat -ForwardDirectories`
`# JkRequestLogFormat set the request format`
`JkRequestLogFormat` `"%w %V %T"`
`# Send everything` `for`  `context /rainyDay to worker ajp13`
`JkMount /rainyDay ajp13`
`JkMount /rainyDay/* ajp13`

I guess most of the properties defined above are clear for you. What is ‘JkMount’ and ‘/rainyDay’. The ‘rainyDay’ is one of my application deployed on Apache Tomcat. It says that ”  **_Forward all the request to the Apache Tomcat that are coming with /rainyDay namespace”_**.

With that, we have finished the configuration of mod_jk.

Now, We will test the environment. Try the following URL’s.

**http://localhost:8080/rainyDay**

Nothing special about the above URL. Since I have deployed my ‘rainyDay’ application on Apache Tomcat, We can access the application even without configuring with Apache HTTP server using mod_jk.

Now, try the following URL.

**http://localhost:7000/rainyDay**

If you can access the application with above URL, our configuration is successful. We know that, We have not deployed the ‘rainyDay’ application on Apache HTTP server, but on Apache Tomcat and also Apache HTTP server is running on port 7000. We can still access the ‘rainyDay’ application deployed on Apache Tomcat via Apache HTTP server.

Now just try the following URL.

**https://localhost:7000/rainyDay**

With the above URL, you can not access the application since URL has  **https**  protocol. To access the application with**https://**, we need to configure  **SSL**  with Apache HTTP server.

**Configuring mod_ssl.**

To enable SSL on Apache HTTP server, again you have to edit  **httpd.conf**  file. Open this file and look for the following line.

`# Secure (SSL/TLS) connections`
`#Include conf/extra/httpd-ssl.conf`

Uncomment the above line and open it. That is under  **/httpd-2.2.22/conf/extra/httpd-ssl.conf**. Look for the following properties.

`SSLPassPhraseDialog builtin`
`SSLEngine on`
`SSLCertificateFile` `"/home/semika/httpd-2.2.22/conf/server.crt"`
`SSLCertificateKeyFile` `"/home/semika/httpd-2.2.22/conf/server.key"`

Uncomment, if some are already commented out. Next, we have to generate SSL certificate files,  **server.crt**  and**server.key.**  To generate these file, execute the following commands.
`cd /home/sermika/Downloads`
`openssl genrsa -des3 -out server.key` `1024`
`openssl req -``new`  `-key server.key -out server.csr`
`openssl x509 -req -days` `365`  `-in server.csr -signkey server.key -out server.crt`

When executing above commands, it will ask for some details and also a password and you have to provide those. Also, you have keep this password in mind, because it will be needed to provide when starting Apache HTTP server.

To know more about the  [configuring SSL with Apache HTTP server](http://httpd.apache.org/docs/2.0/ssl/ssl_faq.html), refer the this documentation. Now carefully look into /home/semika/Downloads folder. You can see the  **server.key**  and  **server.crt**  generated. You have to copy these two files into Apache HTTP server installation directory.

`cd /home/semika/Downloads`
`cp server.crt /home/semika/httpd-``2.2``.``22``/conf/server.crt`
`cp server.key /home/semika/httpd-``2.2``.``22``/conf/server.key`

Again open the  **httpd-ssl.conf**  file under  **/httpd-2.2.22/conf/extra**. You can see  **</VirtualHost>**  element and some properties are defined within that element. Like we did in mod_jk configuration, here also, we have to declare the required application context URL’s or any other URL’s that are needed to be secured with SSL. You have to add JkMount declaration as follows.

`</VirtualHost>`
`...........`
`...........`
`JkMount /rainyDay ajp13`
`JkMount /rainyDay/* ajp13`
`</VirtualHost>`

Now try the following URL’s

https://localhost:7000/

This should load the ”  **It works**” page. I used the port 7000, because I have change the Apache HTTP server default port. You are successfully configured mod_ssl.

Now try the following URL as well.

**https://localhost:7000/rainyDay**

You should be able to load the application.

**Testing the environment.**

There is no any order of starting Apache Tomcat and Apache HTTP server. After starting your servers, you can test your configuration with following URL’s.

**_http://localhost:8080/_**  
If you see, Tomcat’s home page, Tomcat configuration is successful.

**_http://localhost:8080/rainyDay_**  
If you can access the application, you application is successfully deployed on Apache Tomcat.

_**http://localhost:7000/**_  
If you see “It works” page, Apache HTTP server is successfully configured.

_**http://localhost:7000/rainyDay**_  
If it loads you application, mod_jk configuration with Apache HTTP server is successful.

_**https://localhost:7000/**_  
Again if you see “It works” page, mod_ssl configuration with Apache HTTP server is success.

_**https://localhost:7000/rainyDay**_  
Again if you can access the application, mod_ssl configuration with Apache HTTP server is success and Apache HTTP server properly handle all secure requests to ‘rainyDay’ application successfully.

**_Reference:_** [How to configure Apache HTTP server with Tomcat on SSL ?](http://semikas.blogspot.gr/2012/06/how-to-configure-apache-http-server.html) from our  [JCG partner](http://www.javacodegeeks.com/p/jcg.html)  Semika loku kaluge at the  [Code Box](http://semikas.blogspot.gr/) blog.
