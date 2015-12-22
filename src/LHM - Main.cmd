::-----------------------------------INFO----------------------------------------
:: [ LHM - Main ]
:: FILE:		LHM - Main.CMD
:: VERSION:		1.1
:: LAST UPDATE: 14/11/2015
:: URL:         HTTP://MHSEA.COM
:: Copyright	Soheil Emadiazar
::-------------------------------------------------------------------------------

ECHO OFF
SETLOCAL enabledelayedexpansion
TITLE [ RMI Main Menu ]-[ %TIME% ]
COLOR 0C	
MODE con:cols=75 lines=25
SET CC=0A
SET JDK_Version=1
SET PROJECTNAME=LHM-Appointment
CLS

::---------------------------RUN AS ADMIN----------------------------------------
::REM --> Check for permissions
::>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"
::
::REM --> If error flag set, we do not have admin.
::if '%errorlevel%' NEQ '0' (
::    echo Requesting administrative privileges...
::    goto UACPrompt
::) else ( goto gotAdmin )
::
:::UACPrompt
::    echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\RAA.vbs"
::    set params = %*:"=""
::    echo UAC.ShellExecute "cmd.exe", "/C %~s0 %params%", "", "runas", 1 >> "%temp%\RAA.vbs"
::
::    "%temp%\RAA.vbs"
::    del "%temp%\RAA.vbs"
::    exit /B
::
:::gotAdmin
::    pushd "%CD%"
::    CD /D "%~dp0"
::---------------------------RUN AS ADMIN----------------------------------------



::---------------------------JDK LOCATOR----------------------------------------
for /d %%i in ("%ProgramFiles%\Java\jdk%jdk_Version%*") do (set Located=%%i)
if "%Located%"=="" goto else
set JAVA_HOME=%Located%
goto MENU
:else

if "%JAVA_HOME%"=="" goto NoExistingJavaHome
goto MENU
:NoExistingJavaHome
 ECHO x=msgbox("Please install JDK before continue " ,16, "[ JDK NOT FOUND ]-[ %TIME% ]") > XMSG.vbs
 CSCRIPT XMSG.vbs >nul 2>&1
 DEL /q /s /f XMSG.vbs
goto EXIT
::---------------------------JDK LOCATOR----------------------------------------




::---------------------------------Main Menu-------------------------------------
:MENU
 CLS
 COLOR 0C
 ECHO.
 ECHO []____________________________[ LHM - Main ]___________________________[]
 ECHO.
 ECHO.
 ECHO   [1] - Start RMI Registry
 ECHO   [S] - Stop  RMI Registry
 ECHO   [2] - Start RMI Server
 ECHO   [3] - Start RMI Client
 ECHO   [Q] - Exit
 ECHO.
 ECHO.
 ECHO. 
 ECHO []_____________________________________________________________________[]
 
 SET M=nul
 SET /P M=[] Please Select a Command:
	IF %M%==1 GOTO STARTRMIREG
	IF %M%==S GOTO STOPRMIREG
	IF %M%==2 GOTO STARTRMISERV
	IF %M%==3 GOTO STARTRMICLNT
	IF %M%==0 GOTO EXIT	
	IF %M%==q GOTO EXIT
	IF %M%==Q GOTO EXIT
	IF %M%==EXIT GOTO EXIT
	IF %M%==exit GOTO EXIT
	IF %M%==quit GOTO EXIT 
	IF %M%==QUIT GOTO EXIT 
 ECHO.
 ECHO.
 CLS
 TITLE [ '%M%' is not valid ]
 ECHO.
 ECHO. 
 ECHO.
 ECHO.
 ECHO.
 ECHO.
 ECHO.
 ECHO                   -----------------------------------------
 ECHO                            [ '%M%' IS NOT VALID ]
 ping localhost -n 2 >Nul
 TITLE [ Please Try again ]
 ECHO.
 ECHO                            [ PLEASE TRY AGAIN ]
 ECHO                   -----------------------------------------
 ping localhost -n 3 >nul
 CLS
 GOTO MENU
::-------------------------------------------------------------------------------





:STARTRMIREG
ECHO OFF
CLS
COLOR 0C

start "[ RMI Registry ]-[ %TIME% ]"  /B "%JAVA_HOME%\bin\rmiregistry.exe"

GOTO MENU
 
 
:STOPRMIREG
ECHO OFF
CLS

TASKKILL /IM rmiregistry.exe /F

GOTO MENU
 
 
:STARTRMISERV
ECHO OFF
CLS

START /MIN "[ RMI Server ]-[ %TIME% ]" cmd "/T:%CC% && /K JAVA -Djava.rmi.server.codebase=file:%USERPROFILE%\Desktop\%PROJECTNAME%\build\classes\LHM\ -Djava.security.policy=file:%USERPROFILE%\Desktop\%PROJECTNAME%\build\classes\LHM.policy LHM.LHM_Server"

GOTO MENU

 
:STARTRMICLNT
ECHO OFF
CLS

START /MIN "[ RMI Client ]-[ %TIME% ]" cmd "/T:%CC% && /K JAVA -Djava.security.policy=file:%USERPROFILE%\Desktop\%PROJECTNAME%\build\classes\LHM.policy LHM.PatientForm"

GOTO MENU




 
::---------------------------------Exit------------------------------------------
:EXIT
ECHO OFF
CLS
TASKKILL /IM rmiregistry.exe /F
TASKKILL /IM java.exe /F
TASKKILL /IM cmd.exe /F
EXIT
::-------------------------------------------------------------------------------