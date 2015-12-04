/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moccsh;

import java.util.concurrent.TimeUnit;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author bgarnier
 */
public class Calcul {
    
    public static void main(String[] args)
    {
        Calcul a = new Calcul();
        a.afficherDebut();
        a.faireOperation();
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e) {
            System.out.println("Problème durant l'exécution");
        }
        a.creationFichier();
        a.afficherFin();
    }
    
    // Répertoire de départ
    String initialPath;
    // Répertoire de l'étape précédente
    String modelPath;
    //répertoire d'écriture
    String resultPath;
    // Valeur initial du traitement
    int initialValue;
    // Nom du fichier résultats
    String resultFileName;
    // Nom du fichier du modele à traiter
    String modelInFileName;
    
    
    public Calcul(){
        // initialisation des varibles
        //#>
        commentToken = {CommentKey}
        //#<
    }
    public void creationFichier(){
        DataOutputStream  fos;
        try{
            String FileName = resultPath + resultFileName;
            fos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(FileName))));
            
            fos.writeInt(initialValue);
            fos.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    public void afficherDebut(){
        System.out.println("Réalisation du calcul du fichier : ");
        System.out.println(initialPath + modelPath + "\\" + modelInFileName);
        System.out.println("La valeur de traitement est " + initialValue);
    }
    
    public void afficherFin(){
        System.out.println("Ecriture des résultats dans le dossier : ");
        System.out.println(resultPath + "\\" );
    }
}
