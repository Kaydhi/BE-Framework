package Tache;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;

import ConstructScript.ConstructScript;
import Parametres.IParametre;
import Parametres.Parametrage;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/


/**
 * Description of AbsTache.
 * 
 * @author Max
 */
public abstract class AbsTache implements ITache {
	/**
	 * Parameters
	 */
	protected IParametre iParametres;

	/**
	 * Taches
	 */
	protected ArrayList<ITache> iTachesSuivantes;
	
	/**
	 * Script automatiquement généré qui est associé à la tâche
	 */
	protected ConstructScript script;
			
	/**
	 * The constructor.
	 */
	public AbsTache() {
	}

	public AbsTache(ArrayList<ITache> _iTaches, IParametre _iParametres) {
		iParametres = _iParametres;
		iTachesSuivantes = _iTaches;
		script = new ConstructScript(iParametres);
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
		script.ConstructAndLaunchScript();
	}
	
	public void jumpToNextTaches()
	{
		if (iTachesSuivantes.size() == 0)
			fin(); //Ici il faut définir 
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
