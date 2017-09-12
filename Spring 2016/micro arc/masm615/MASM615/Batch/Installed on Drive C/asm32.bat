REM  make32.bat -  Batch file for assembling/linking 32-bit Assembly programs
REM  Revised: 11/15/01

@echo off
cls

REM The following three lines can be customized for your system:
REM ********************************************BEGIN customize
SET PATH=c:\Masm615\binr;c:\Masm615\bin
SET INCLUDE=c:\Masm615\INCLUDE
SET LIB=c:\Masm615\LIB
REM ********************************************END customize

ML -Zi -c -Fl -coff %1.asm

if errorLevel 1 goto terminate

dir %1.*

:terminate
pause