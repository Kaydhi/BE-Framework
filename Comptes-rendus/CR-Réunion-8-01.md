# Compte-rendu 8 janvier

Examen du diagramme UML
•	Classe Etape : mauvaise idée !
•	Automate + taches suivantes = redondance d’information !
•	On peut rester sur l’idée d’un automate -> plus évolutif.
o	Une transition : executer()
o	1 état = 1 thread. La gestion d’exécutions parallèles est gérée par les threads !

Vision 2 étapes :
1.	Création d’un automate
2.	Exécution de l’automate crée

RCP -> 2 vues : une vue créateur & une vue exécution
