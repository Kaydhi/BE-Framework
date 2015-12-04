/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/


public class PreTraitement {
    public static void main(String[] args){
        PreTraitement a = new PreTraitement();
        a.afficherDebut();
        File dir = new File (a.resultPath);
        dir.mkdirs();
		File res = new File (a.initialPath);
        res.mkdirs();
		a.faireOperation(args[0]);
        try {
			TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e) {
            System.out.println("Problème durant l'exécution");
        }
        a.afficherFin();
    }
    // Répertoire de départ
    String initialPath;
    //répertoire d'écriture
    String resultPath;
    // Valeur initial du traitement
    int initialValue;
    // Nom du fichier du modele à traiter
    String modelInFileName;
    // nom du fichier du modele Pré-traiter
    String modelOutFileName;

    public PreTraitement(){
        // initialisation des varibles
        //#>
        initialPath = {RepertoireCommun};
        resultPath = initialPath + {DossierResultatPreTraitement};
        initialValue = {ValeurEntree};
        modelInFileName = {NomModel};
        modelOutFileName = modelInFileName + {ajoutNomModel};
       //#<
    }
    
    public void afficherDebut(){
        System.out.println("Réalisation de pré-traitement du fichier : ");
        System.out.println(initialPath + "/" + modelInFileName);
        System.out.println("La valeur de traitement est " + initialValue);
    }
    
    public void afficherFin(){
        System.out.println("Ecriture des résultats dans le fichier : ");
        System.out.println(resultPath + "/" + modelOutFileName);
    }
	
	public void faireOperation(String file) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(initialPath + "/" + file, "UTF-8");
			writer.println("//" + file);
            writer.println("1.2215");
            writer.println("5.115");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}
    

}

