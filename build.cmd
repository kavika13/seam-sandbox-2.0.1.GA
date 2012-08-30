@ECHO OFF
CALL mvn clean install -Penv-dev %*
PAUSE
