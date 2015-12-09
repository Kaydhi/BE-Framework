@echo off
REM Parametres :
REM     param 1 : Calculs\Output.txt
REM 	param 2 : PreTraitement\results\Output*
REM		param 3 : Nombre d'appel de l'Ã©tape 3 (ici, 5)

IF [%1]==[/?] GOTO :help

echo %* |find "/?" > nul
IF errorlevel 1 GOTO :main

:help

ECHO Execute le calcul MEO avec parametrage.
ECHO.
ECHO MEO.bat [output_path] [temp_output] [loops]
ECHO.
ECHO   [output_path]
ECHO       Specifie le chemin relatif du fichier de resultats
ECHO   [temp_output*]
ECHO       Specifie le chemin relatif des fichiers de sortie, finissant par * pour identifier le numero d'iteration
ECHO   [loops]
ECHO       Specifie le nombre d'iterations a effectuer
ECHO.

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


REM ETAPE 3 : Nombre de boucle Ã  paramÃ©trer
FOR /L %%G IN (1,1,%3) DO java -cp . PreTraitement Output%%G.out

REM ETAPE 4
cd ..
md Calculs
REM Pour simuler un appel shell avec des arguments
call cat.bat %2 %1

REM ETAPE 5
md PostTraitement
java -cp . SearchAndReplace PostTraitement.java PostTraitement.xml PostTraitement/PostTraitement.java
javac PostTraitement\PostTraitement.java
java -cp PostTraitement\ PostTraitement %1

:end
