import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

/**
 * Description of Workflow.
 * 
 * @author Max
 */
public class Workflow extends AbsTache {
	/**
	 * Description of the property OS.
	 */

	public ArrayList<ITache> iTaches;

	/**
	 * Description of the property iTaches.
	 */
	public ArrayList<ITache> iTachesStart;

	/**
	 * The constructor.
	 */
	public Workflow() {
		iTaches=new ArrayList<ITache>();
	}

	public Workflow(ArrayList<ITache> iTacheStart){
		iTaches = new ArrayList<ITache>();
		iTaches = iTacheStart;
	}

	public void initialiserWorkflow()
	{
		//Lalalalalalalalala
	}
	
	/**
	 * Description of the method ajouterTache.
	 * @param myList : an ArrayList of ITache
	 * @param myTache: the ITache to add
	 */
	public void ajouterTache(ITache myTache) {
		iTaches.add(myTache);
	}

	public ArrayList<ITache> getiTachesStart()
	{
		return iTachesStart;
	}
	
	public void setiTachesStart(ArrayList<ITache> tachesStart)
	{
		iTachesStart = tachesStart;
	}
	
	 
	/**
	 * Returns iTaches.
	 * @return iTaches 
	 */
	public ArrayList<ITache> getITaches() {
		return iTaches;
	}

	@Override
	public int executer() {
		ListIterator<ITache> ite = iTachesStart.listIterator();
		while (ite.hasNext())
		{
			ite.next().executer();	
		}
		return 0;
	}
}