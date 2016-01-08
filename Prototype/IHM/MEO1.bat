@echo off
REM Exemple de parametres :
REM   param 1 : Calculs\Outputs.txt
REM 	param 2 : Output
REM		param 3 : 5

IF [%1]==[/?] GOTO :help

echo %* |find "/?" > nul
IF errorlevel 1 GOTO :main

:help

ECHO Execute le calcul MEO avec parametrage.
ECHO.
ECHO MEO.bat [output_path] [temp_finename] [loops]
ECHO.
ECHO   [output_path]
ECHO       Specifie le chemin relatif du fichier de resultats
ECHO   [temp_finename]
ECHO       Specifie le nom des fichiers resultat temporaires
ECHO   [loops]
ECHO       Specifie le nombre d'iterations a effectuer
ECHO.
ECHO Exemple de commande : MOE.bat Calculs\Outputs.txt Output 5

GOTO :end

:main
@echo on
REM ETAPE 1
javac SearchAndReplace.java
md PreTraitement
java -cp . SearchAndReplace PreTraitement.java Pretraitement.xml PreTraitement/PreTraitement.java

REM ETAPE 2
cd PreTraitement
javac PreTraitement.java

REM ETAPE 3 : Boucle d'executions
FOR /L %%G IN (1,1,%3) DO java -cp . PreTraitement %2%%%G.out

REM ETAPE 4
cd ..
md "%~dp1"
call cat.bat PreTraitement\results\%2* %1

REM ETAPE 5
md PostTraitement
java -cp . SearchAndReplace PostTraitement.java PostTraitement.xml PostTraitement/PostTraitement.java
javac PostTraitement\PostTraitement.java
java -cp PostTraitement\ PostTraitement %1

:end
