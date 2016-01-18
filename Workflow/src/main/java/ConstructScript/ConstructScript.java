package ConstructScript;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

import Parametres.*;

public class ConstructScript
{
	String extension;
	IParametre parametres;
	public ConstructScript (IParametre _parametres)
	{
		parametres = _parametres;
	}
	
	public void constructScript()
	{
		String extensionScript = "";
		String contenuScript = "";
		if (isWindows())
		{
			extensionScript = "bat";
			contenuScript = parametres.getInterpreteur() + " " + parametres.getNomScript() 
					+ "/" + parametres.getNomScript()+ " ";
			ArrayList<String> listeOptions = parametres.getOptions();
			ListIterator<String> ite = listeOptions.listIterator();
			while (ite.hasNext())
			{
				contenuScript = ite.next() + " ";
			}
			ArrayList<String> listeParametres = parametres.getParametres();
			ListIterator<String> ite2 = listeParametres.listIterator();
			while (ite2.hasNext())
			{
				contenuScript = ite2.next() + " ";
			}
		}
		else if (isUnix())
		{
			extensionScript = "sh";
		}
		else
		{
			System.out.println("Système d'exploitation non géré");
			//Générer une exception ici
		}
		//Transformer contenuScript en un tableau de bytes
		WriteScript(extensionScript, contenuScript);
	}
	
	public void WriteScript(String extensionScript, String texteScript)
	{
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(new File("Exe" + parametres.getNomScript() + "." + extensionScript));
			//On doit transformer le string en tableau de bytes
			byte[] bytesScript = texteScript.getBytes();
			fos.write(bytesScript);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if (fos != null)
			fos.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
	
	public void launchScript()
	{
		String[] command = {};
		if (isWindows())
		{
			command = new String[] {"CMD", "/C", "Exe" + parametres.getNomScript() + ".bat"};
		}
		else if (isUnix()) //Ne fonctionne qu'avec unix
		{
			command = new String[] {"/bin/sh", "Exe" + parametres.getNomScript() + ".sh"};
		}
		ProcessBuilder p = new ProcessBuilder(command);
		p.directory(new File(parametres.getCheminScript()));
		try
		{
			Process p2 = p.start();	//Lance le processus
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p2.getInputStream()));	//Permet de lire la console
			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					p2.getErrorStream()));	//Permet de lire les erreurs
			String line;
			System.out.println("Output of running " + command + " is: ");
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);	//Affiche les messages consoles
			}
			while ((line = br2.readLine()) != null)
			{
				System.out.println(line);	//Affiche les messages d'erreur
			}
			p2.destroy();	//Kill le processus
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void ConstructAndLaunchScript()
	{
		constructScript();
		launchScript();
	}
	
	public boolean isWindows()
	{
		return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);
	}
	
	public boolean isUnix()
	{
		return (System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0
				|| System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0 || System
				.getProperty("os.name").toLowerCase().indexOf("aix") > 0);
	}
}
