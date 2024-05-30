@echo off
echo Compiling Java files...
javac -d out src\ChatServer.java src\ChatClient.java

echo Starting Chat Server...
start cmd /k "java -cp out ChatServer"

timeout /t 2 /nobreak >nul

echo Starting Chat Client 1...
start cmd /k "java -cp out ChatClient"

timeout /t 2 /nobreak >nul

echo Starting Chat Client 2...
start cmd /k "java -cp out ChatClient"

echo All processes started.
