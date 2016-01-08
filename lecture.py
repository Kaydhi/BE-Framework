import os
import sys
currentFile = "Plop"
fileName = sys.argv[1]
with open(fileName,"r") as fichier:
            contenu = fichier.read()
            contenu = contenu.split("\n")
            for ligne in contenu:
                a = ligne.split("=")
                if currentFile in a[0]:
                    file.write(a[1])
                else:
                    print ("new file")
                    currentFile = a[0][0]
                    file = open(currentFile +".txt", "w")
                    file.write(a[1])
                    
