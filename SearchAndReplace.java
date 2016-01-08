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

public class SearchAndReplace
{

	public static void main(String[] args)
	{
		String dataFileIn = args[0];	//Paramètres d'entrée
		String replaceFile = args[1];
		String dataFileOut = args[2];

		// String dataFileIn = "PreTraitement.java";
		// String replaceFile = "PreTraitement.xml";
		// String dataFileOut = "PreTraitement_post.java";

		StringBuilder sb = new StringBuilder(); //Permet de constuire des strings

		try
		{
			InputStream ips = new FileInputStream(dataFileIn);	//Designe un fichier à lire
			InputStreamReader ipsr = new InputStreamReader(ips);  //Permet de lire le fichier
			BufferedReader br = new BufferedReader(ipsr);	//Créer un buffer
			String ligne;
			while ((ligne = br.readLine()) != null)	//Lecture intégrale du fichier
			{
				sb.append(ligne);	//Insert un string dans le string builder et le concatène
				sb.append("\n");
			}
			br.close();	//Fermeture du fichier
		}
		catch (Exception e)	//Exception
		{
			System.out.println(e.toString());	//On affiche l'exception
		}

		String out = sb.toString();	//On affiche le string généré par le string builder
		HashMap<String, String> dict = new HashMap<>();	//Création d'un HashMap ("Dictionnary")
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder;
		final Document document;
		final Element racine;
		try
		{
			builder = factory.newDocumentBuilder();
			document = builder.parse(new File(replaceFile));	
			racine = document.getDocumentElement();	

			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) //Récupère les valeur du XML, pour le mettre dans le dictionnary
			{
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					final Element value = (Element) racineNoeuds.item(i);
					String key = "\\{" + value.getAttribute("name") + "\\}";
					dict.put(key, value.getTextContent());
				}
			}
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		for (Map.Entry<String, String> entry : dict.entrySet())	//On lit le dictionnary
		{
			out = out.replaceAll(entry.getKey(), entry.getValue());	//On met tout dans un string
		}

		try
		{
			FileWriter fw = new FileWriter(dataFileOut);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
			fichierSortie.println(out);	//On écrit le string dans un fichier
			fichierSortie.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
