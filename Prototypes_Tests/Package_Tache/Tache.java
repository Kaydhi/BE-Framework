package gestionTache;

import javax.swing.text.Position;

public class Tache {

private SystemeExploitation OS; //Langage d'exploitation qui execute le programme
private LangageTache Langage; //Langage du programme de calcul à executer
private int nb_Appels; //Nbre d'itérations du calcul à effectuer
private String chemin_Script; // Chemin vers le script batch ou bash
private int position=0; //Position dans l'ordre d'exécution du Workflow

public void setOS(SystemeExploitation input){
	OS = input; 
}
public SystemeExploitation getOS(){
	return OS;
}
public void setLangage(LangageTache input){
	Langage = input; 
}
public LangageTache getLangage(){
	return Langage;
}
public void setNbAppels(int input){
	nb_Appels=input;
}
public int getNbAppels(){
	return nb_Appels;
}
public void setCheminScript(String input){
	chemin_Script=input;
}
public String getCheminScript(){
	return chemin_Script;
}
protected void setPosition(int input){
	position=input;
}
protected int getPosition(){
	return position;
}

Tache(SystemeExploitation syst, LangageTache lang, int iterations, String path){
	OS = syst;
	Langage = lang;
	nb_Appels=iterations;
	chemin_Script=path;
}

}
