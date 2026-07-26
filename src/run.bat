@echo off

echo Deleting all .class files...
for /r %%f in (*.class) do del /f /q "%%f"

echo Compiling
javac Driver.java

echo Executing
java Driver

echo Deleting all .class files...
for /r %%f in (*.class) do del /f /q "%%f"