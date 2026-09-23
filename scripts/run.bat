@echo off
if not exist out (
    call scripts\compile.bat
    if errorlevel 1 exit /b 1
)
java -cp out heapalgorithmgroup5.Main
