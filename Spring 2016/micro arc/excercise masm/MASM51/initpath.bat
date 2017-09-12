

IF "%1"=="" GOTO XDRIVE
SET PATH=%1:\masm51\bin;%1:\masm51;%1:\masm51\binr;
SET INCLUDE=%1:\masm51\include
SET LIB=%1:\masm51\lib
SET INIT=%1:\MASM51\INIT
SET HELPFILES=%1:\MASM51\HELP\*.HLP
GOTO END

:XDRIVE
SET PATH=x:\masm51\bin;x:\masm51;x:\masm51\binr;
SET INCLUDE=x:\masm51\include
SET LIB=x:\masm51\lib
SET INIT=x:\MASM51\INIT
SET HELPFILES=x:\MASM51\HELP\*.HLP
:END

