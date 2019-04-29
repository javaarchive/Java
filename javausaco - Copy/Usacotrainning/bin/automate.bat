cd C:\Users\raymo\Documents\main\javausaco\Usacotrainning\src
@echo off
echo Running test, starting compile
javac barn1.java
echo Normal run starting
"C:\Program Files\Java\jdk-10.0.2\bin\java.exe" barn1
echo Time run starting
powershell -Command "Measure-Command {"C:\Program Files\Java\jdk-10.0.2\bin\java.exe" barn1}"
echo done
pause