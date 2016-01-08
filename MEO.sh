
# Version Linux - Script shell
# Parametres :
# param 1 : Calculs/Output.txt
# param 2 : PreTraitement/results/Output*
# param 3 : Nombre d'appel de l'étape 3 (ici, 5)


# ETAPE 1
javac ./SearchAndReplace.java
mkdir PreTraitement
java ./SearchAndReplace PreTraitement.java Pretraitement.xml PreTraitement/PreTraitement.java


# ETAPE 2
cd ./PreTraitement
javac PreTraitement.java


# ETAPE 3 : Nombre de boucle à paramétrer
java  ./PreTraitement Output1.out
java  ./PreTraitement Output2.out
java  ./PreTraitement Output3.out
java  ./PreTraitement Output4.out
java  ./PreTraitement Output5.out


# ETAPE 4
cd ..
mkdir Calculs
# Pour simuler un appel shell avec des arguments
cat PreTraitement/results/Output* > Calculs/Output.txt

# ETAPE 5
mkdir PostTraitement
java ./SearchAndReplace PostTraitement.java PostTraitement.xml PostTraitement/PostTraitement.java
javac PostTraitement/PostTraitement.java
java ./PostTraitement/PostTraitement Calculs/Output.txt
