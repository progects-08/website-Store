

@echo off
rem Производит сборку проекта. Аналогичное действие может выполняться непосредственно в Idea.
rem call mvn eclipse: eclipse
call mvn clean install

cd..

pause