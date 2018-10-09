if exist "%CATALINA_HOME%/jre1.6.0_20/win" (
	if not "%JAVA_HOME%" == "" (
		set JAVA_HOME=
	)

	set "JRE_HOME=%CATALINA_HOME%/jre1.6.0_20/win"
)
SET "JAVA_HOME=C:/Program Files/Java/jdk1.8.0_131"
set "CATALINA_OPTS=%CATALINA_OPTS% -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false -Duser.timezone=GMT -Xmx8g -XX:MaxPermSize=2g"
set "CATALINA_OPTS=%CATALINA_OPTS% -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=18205"