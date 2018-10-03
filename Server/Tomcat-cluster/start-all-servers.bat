set currentDir=%~dp0
set tomcat1="%currentDir%tomcat-8081\bin"
set tomcat2="%currentDir%tomcat-8082\bin"
set tomcat3="%currentDir%tomcat-8083\bin"

:tomcat1
CD /D %tomcat1%
start /d . startup.bat
goto tomcat2

:tomcat2
CD /D %tomcat2%
start /d . startup.bat
goto tomcat3

:tomcat3
CD /D %tomcat3%
start /d . startup.bat
pause