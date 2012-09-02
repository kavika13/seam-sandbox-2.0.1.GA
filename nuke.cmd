@ECHO OFF
SETLOCAL
SET AREYOUSURE=N

ECHO You are about to wipe out all unstaged files in this repository

SET /P AREYOUSURE=Are you sure ('Y'es/'D'ry run/[N]o)?
IF /I "%AREYOUSURE:~0,1%"=="D" GOTO :DryRun
IF /I "%AREYOUSURE%" NEQ "Y" GOTO :Nothing

:Main
git clean -xdf
GOTO :EOF

:DryRun
git clean -xdn
GOTO :EOF

:Nothing
ECHO.Command aborted.  Doing nothing
GOTO :EOF
