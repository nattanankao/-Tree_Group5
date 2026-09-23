@echo off
if exist out rmdir /s /q out
mkdir out
javac -encoding UTF-8 -d out src\heapalgorithmgroup5\*.java
if errorlevel 1 (
    echo Compile failed.
    exit /b 1
)
echo Compile successful.
