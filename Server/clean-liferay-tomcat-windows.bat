REM put this file in liferay home i.e. in parallel to the tomcat folder
set liferayhome=%~dp0
set stateFolder="%liferayhome%osgi\state"
set tempFolder="%liferayhome%tomcat-8.0.32\temp"
set workFolder="%liferayhome%tomcat-8.0.32\work"
set logsFolder="%liferayhome%tomcat-8.0.32\logs"

CD /D %liferayhome%
echo cleaning Liferay7 server..........STARTED
echo deleting %stateFolder%
RMDIR /S /Q %stateFolder%
echo deleting %tempFolder%
RMDIR /S /Q %tempFolder%
echo deleting %workFolder%
RMDIR /S /Q %workFolder%
echo deleting %logsFolder%
RMDIR /S /Q %logsFolder%
echo cleaning Liferay7 server  ..........COMPLETED
pause