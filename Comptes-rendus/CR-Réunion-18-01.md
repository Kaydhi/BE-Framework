# Compte-rendu 18 janvier

Génération automatique de scripts  
 
•	Facile à mettre en oeuvre  
•	Pratique si on veut livrer des batchs executables aux clients  
=> SOLUTION RETENUE  

Pour assurer la portabilité du Workflow entre les OS, Altran prévoit de faire une version (un Workflow) par OS.

Traitement des options : 2 possibilités  
•	saisie brute (avec le - ou le / comme sur invite de commande)  
•	allégée (sans le caractère d'option)  
=> SAISIE BRUTE  

Interface graphique avec RCP  
•	2 perspectives envisagées : Création & Execution
•	Partage des fonctionnalités dans 2 plug-ins séparés -> permet de bloquer la création de scénario pour les clients  
•	Possibilité d'enchaînement sans IHM souhaitable !!!  

Stockage du Workflow dans un modèle XML ou JSON  
=> BESOIN DE VALIDER LE MODÈLE AUPRÈS D’ALTRAN
