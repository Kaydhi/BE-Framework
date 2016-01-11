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
	 * setTachesSuivantes permet de définir les taches à executer en parallèle pour la prochaine étape
	 * Cette fonction écrase tachesSuivantes
	 */
	public void setTachesSuivantes(ArrayList<ITache> tachesSuivantes);
	
	/**
	 * setTacheSuivante permet de définir la tache à executer pour la prochaine étape
	 * Cette fonction écrase tachesSuivantes
	 */
	public void setTachesSuivantes(ITache tacheSuivante);
	
	/**
	 * addTacheSuivante permet d'ajouter des taches à executer en parallèle pour la prochaine étape
	 */
	public void addTachesSuivantes(ArrayList<ITache> tachesSuivantes);
	
	/**
	 * addTacheSuivante permet d'ajouter une tache à executer pour la prochaine étape
	 */
	public void addTachesSuivantes(ITache tacheSuivante);
}
