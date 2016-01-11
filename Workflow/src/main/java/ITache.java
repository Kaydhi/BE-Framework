import java.util.ArrayList;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ITache.
 * 
 * @author Max
 */
public interface ITache {
	/**
	 * Description of the method executer.
	 */
	public int executer();

	/**
	 * Description of the method getTacheSuivante.
	 */
	public ArrayList<ITache> getTachesSuivantes();

	/**
	 * setTachesSuivantes permet de d�finir les taches � executer en parall�le pour la prochaine �tape
	 * Cette fonction �crase tachesSuivantes
	 */
	public void setTachesSuivantes(ArrayList<ITache> tachesSuivantes);
	
	/**
	 * setTacheSuivante permet de d�finir la tache � executer pour la prochaine �tape
	 * Cette fonction �crase tachesSuivantes
	 */
	public void setTachesSuivantes(ITache tacheSuivante);
	
	/**
	 * addTacheSuivante permet d'ajouter des taches � executer en parall�le pour la prochaine �tape
	 */
	public void addTachesSuivantes(ArrayList<ITache> tachesSuivantes);
	
	/**
	 * addTacheSuivante permet d'ajouter une tache � executer pour la prochaine �tape
	 */
	public void addTachesSuivantes(ITache tacheSuivante);
}
