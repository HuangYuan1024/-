@echo off
@echo Mysql startup ...
rem start bin\mysqld.exe --no-defaults --port=3306
start bin\mysqld.exe --defaults-file="my.ini" --port=3306
exit