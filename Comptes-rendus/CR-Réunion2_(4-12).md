# CR réunion 4-12

Objectifs :  

Paramétres à prendre en compte:  
- Chemin de destination des fichiers de sortie 
- Nombre de calculs à effectuer  

Application Java, qui à travers un workflow, execute une succession de tâches.

Définit une tâche :  
-script(.bat/.sh)  
-Ensemble de fichiers ressources(Workflow des ressources)  
-Langage(Variables d'environnement)  
-Nb d'appels  
-Chemin de sortie  
-Résultats et nature de la sortie  

Paramétrage du MEO à effectuer  


Faire un système permettant de contruire n'importe quelle tache;

Questions à poser :  
-Compatibilité entre les entrées/sorties des boites ?  
-Que faut-il paramétrer sur les tâches ?  
-Qu'est produit par altran (au niveau du script) ?  
-Que fait l'opérateur ?  
-Que faut t-il cacher à l'opérateur?  
-Quels paramètres à implémenter dans les tâches?  
-Structure arborescente de workflow? Choix pour les tâches?  

Programme JAVA simple à réaliser : 

-IHM : -Paramètres : Champs de texte + légende (3)  
	- Case lancement automatique ? Prochaine tâche à exécuter (chemin vers la tache suivante)

-Programme : Insertion des paramètres ( Paramétrage du MEO) à travers l'IHM  
	     Lancement  
	     L'enchainement automatique(ou non) d'une deuxième tache ; gestion d'un workflow avec une liste ;  