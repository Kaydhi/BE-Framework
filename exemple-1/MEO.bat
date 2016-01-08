
REM Parametres :
REM     param 1 : Calculs\Output.txt
REM 	param 2 : PreTraitement\results\Output*
REM		param 3 : Nombre d'appel de l'étape 3 (ici, 5)


REM ETAPE 1
javac SearchAndReplace.java
md PreTraitement
java -cp . SearchAndReplace PreTraitement.java Pretraitement.xml PreTraitement/PreTraitement.java


REM ETAPE 2
cd PreTraitement
javac PreTraitement.java


REM ETAPE 3 : Nombre de boucle à paramétrer
java -cp . PreTraitement Output1.out
java -cp . PreTraitement Output2.out
java -cp . PreTraitement Output3.out
java -cp . PreTraitement Output4.out
java -cp . PreTraitement Output5.out


REM ETAPE 4
cd ..
md Calculs
REM Pour simuler un appel shell avec des arguments
call cat.bat PreTraitement\results\Output* Calculs\Output.txt

REM ETAPE 5
md PostTraitement
java -cp . SearchAndReplace PostTraitement.java PostTraitement.xml PostTraitement/PostTraitement.java
javac PostTraitement\PostTraitement.java
java -cp PostTraitement\ PostTraitement Calculs\Output.txt
