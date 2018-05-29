set castomcat="C:\learn-fun\Server\CAS-SSO\apache-tomcat-8.5.23\bin"
set liferaytomcat="C:\learn-fun\Server\liferay-ce-portal-7.0-ga6\tomcat-8.0.32\bin"
set apachedsService="apacheds-default"


:stop
sc stop %apachedsService%
TIMEOUT /T 5
sc query %apachedsService% | find /I "STATE" | find "STOPPED"
if errorlevel 1 goto :stop
goto :start


:start
net start | find /i %apachedsService%>nul && goto :start
echo Starting apache LDAP service
sc start %apachedsService%
echo service restarts @ %date% %time% >> checklog.txt
TIMEOUT /T 20
goto casserver

:casserver
CD /D %castomcat%
echo Starting CAS server
start /d . catalina.bat run
TIMEOUT /T 30
goto liferayServer

:liferayServer
CD /D %liferaytomcat%
echo Starting Liferay7 server
start /d . catalina.bat run

pause