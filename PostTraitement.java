/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author bgarnier
 */
public class PostTraitement {
    
    public static void main(String[] args)
    {
        PostTraitement a = new PostTraitement(args[0]);
        a.afficherDebut();
		File dir = new File (a.outputFolder);
        dir.mkdirs();
        a.lectureFichier();
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            System.out.println("Problème durant l'exécution");
        }
        a.afficherFin();
    }
    
	// Caractères de commentaire
	String commentToken;
	
	//Fichier d'origine
	String filePathIn;
	
	//Répertoire de sortie
	String outputFolder;
	
	//Fichier post-traité
    String filePathOut;
    
	String finalResult;
	
    public PostTraitement(String in){
        // initialisation des varibles
        //#>
		commentToken = {CommentKey};
        filePathIn = in; 
		outputFolder = {OutputFolder}; 
		filePathOut = outputFolder + "/" + {OutputFileName};
        //#<
    }
    public void lectureFichier(){
		StringBuilder sb = new StringBuilder();
        try {
            InputStream ips = new FileInputStream(filePathIn);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            while ((ligne = br.readLine()) != null) {
				if(!ligne.startsWith(commentToken)) {
					sb.append(ligne);
					sb.append("\n");
				}
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		finalResult = sb.toString();
		try {
            FileWriter fw = new FileWriter(filePathOut);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter fichierSortie = new PrintWriter(bw);
            fichierSortie.println(finalResult);
            fichierSortie.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		
    }
    public void afficherDebut(){
        System.out.println("Réalisation de post-traitement du fichier : ");
        System.out.println(filePathOut);
        
    }
    
    public void afficherFin(){
    }
}
