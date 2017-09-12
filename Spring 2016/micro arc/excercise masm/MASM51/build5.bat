@echo off
REM Command-line options (unless otherwise noted, they are case-sensitive):
REM -C         Enforce case-sensitivity for all identifiers
REM -Zi         Include source code line information for debugging
REM -L  Generate a listing file (see page 88)
REM /CO   Generate CodeView debugging information (linker)
REM %1.asm      The name of the source file, passed on the command line

@echo on
echo Invoke Masm.EXE (the assembler):
\masm51\bin\Masm /C /Z /L /Zi %1.asm, %1.obj, %1.lst, %1.crf > %1.err
@echo off
if errorlevel 1 goto terminate

@echo on
\masm51\bin\LINK /co %1.obj,%1.exe,NUL,Irvine16+CNTSECHD; >> %1.err
rem cvpack %1.exe
@echo off
if errorlevel 1 goto terminate

@echo on
echo Display all files related to this program:
DIR %1.*

@echo off
:terminate


