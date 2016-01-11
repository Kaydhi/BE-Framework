import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/


/**
 * Description of AbsTache.
 * 
 * @author Max
 */
public abstract class AbsTache implements ITache {
	protected IParametre iParametres;
	protected ArrayList<ITache> iTachesSuivantes;

	/**
	 * The constructor.
	 */
	public AbsTache() {
	}

	public AbsTache(ArrayList<ITache> _iTaches, IParametre _iParametres) {
		iParametres = _iParametres;
		iTachesSuivantes = _iTaches;
	}

	/**
	 * Returns iParametres.
	 * @return iParametres 
	 */
	public IParametre getIParametres() {
		return iParametres;
	}

	/**
	 * Returns iTaches.
	 * @return iTaches 
	 */
	public ArrayList<ITache> getTachesSuivantes() {
		return iTachesSuivantes;
	}
	
	public void setTachesSuivantes(ArrayList<ITache> tachesSuivantes)
	{
		iTachesSuivantes = tachesSuivantes;
	}
	
	public void setTachesSuivantes(ITache tacheSuivante)
	{
		iTachesSuivantes.clear();
		iTachesSuivantes.add(tacheSuivante);
	}

	public void addTachesSuivantes(ArrayList<ITache> tachesSuivantes)
	{
		iTachesSuivantes.addAll(tachesSuivantes);
	}
	
	public void addTachesSuivantes(ITache tacheSuivante)
	{
		iTachesSuivantes.add(tacheSuivante);
	}
	
	/**
	 * Execute the script and jumps to the next Taches 
	 */
	public int executer() {
		launchTache();
		jumpToNextTaches();
		return 0;
	}
	
	public void launchTache()
	{
		String[] command;
		// OS Detection
		if (isWindows())
		{
			command = new String []
			{
					"CMD", "/C", iParametres.getNomScript()
			};
		}
		else
		{
			command = new String[]
			{
					"/bin/sh", iParametres.getNomScript()
			};
		}

		command = Parametrage.assemble(command, iParametres.getAllParameters());
		ProcessBuilder p = new ProcessBuilder(command);
		p.directory(new File(iParametres.getCheminScript()));
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
	
	public void jumpToNextTaches()
	{
		if (iTachesSuivantes.size() == 0) {
			//Ici il faut définir la fin du programme
		}
		else
		{
			ListIterator<ITache> ite = iTachesSuivantes.listIterator();
			while (ite.hasNext())
			{
				ite.next().executer();
			}
		}
	}
	
	public boolean isWindows()
	{
		return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);
	}

	public boolean isUnix()
	{
		return (System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0 || System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0 || System.getProperty("os.name").toLowerCase().indexOf("aix") > 0);
	}
}	
