@ECHO OFF

REM delete the old bin directory to wipe out stale .class files, then recreate it
if exist data\tasks.txt del data\tasks.txt
if exist ..\bin rmdir /s /q ..\bin
mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM compile the code into the bin folder
javac -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\jeff\*.java ..\src\main\java\jeff\assets\*.java ..\src\main\java\jeff\exceptions\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program using the fully qualified class name (jeff.Jeff)
java -classpath ..\bin jeff.Jeff < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT