#!/bin/bash
# REM Parametres :
# REM	param 1 : Calculs\Output.txt
# REM	param 2 : PreTraitement\results\Output*
# REM	param 3 : Nombre d'appel de l'étape 3 (ici, 5)
if  [ "$1" == "/?" ]; then
	echo "Execute le calcul MEO avec parametrage."
	echo ""
	echo "MEO.bat [output_path] [temp_finename] [loops]"
	echo ""
	echo "   [output_path]"
	echo "       Specifie le chemin relatif du fichier de resultats"
	echo "   [temp_finename]"
	echo "       Specifie le nom des fichiers resultat temporaires"
	echo "   [loops]"
	echo "       Specifie le nombre d'iterations a effectuer"
	echo ""
else
	# REM ETAPE 1
	javac SearchAndReplace.java
	mkdir PreTraitement
	java -cp . SearchAndReplace PreTraitement.java Pretraitement.xml PreTraitement/PreTraitement.java
	# REM ETAPE 2
	cd PreTraitement
	javac PreTraitement.java
	# REM ETAPE 3 : Boucle d'executions
	for ((i=1; i <= $3 ; i++))
	do
		java -cp . PreTraitement $2$i.out
	done
	# REM ETAPE 4
	cd ..
	MY_PATH=$(dirname "${1}")
	mkdir ${MY_PATH}
	# REM Pour simuler un appel shell avec des arguments
	cat PreTraitement/results/$2* > $1
	# REM ETAPE 5
	mkdir PostTraitement
	java -cp . SearchAndReplace PostTraitement.java PostTraitement.xml PostTraitement/PostTraitement.java
	javac PostTraitement/PostTraitement.java
	java -cp PostTraitement/ PostTraitement $1
fi
exit
