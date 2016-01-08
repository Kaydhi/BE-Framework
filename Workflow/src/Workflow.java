/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Workflow.
 * 
 * @author Max
 */
public class Workflow implements ITache {
	/**
	 * Description of the property OS.
	 */
	public Object OS = ;
	
	/**
	 * Description of the property iTaches.
	 */
	public ArrayList<ITache> iTaches = new ArrayList<ITache>();
	
	// Start of user code (user defined attributes for Workflow)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Workflow() {
		// Start of user code constructor for Workflow)
		super();
		// End of user code
	}
	
	/**
	 * Description of the method ajouterTache.
	 */
	public void ajouterTache() {
		// Start of user code for method ajouterTache
		// End of user code
	}
	 
	/**
	 * Description of the method supprimerTache.
	 * @param tache 
	 */
	public void supprimerTache(AbsTache tache) {
		// Start of user code for method supprimerTache
		// End of user code
	}
	 
	/**
	 * Description of the method modifierTache.
	 */
	public void modifierTache() {
		// Start of user code for method modifierTache
		// End of user code
	}
	 
	// Start of user code (user defined methods for Workflow)
	
	// End of user code
	/**
	 * Returns OS.
	 * @return OS 
	 */
	public Object getOS() {
		return this.OS;
	}
	
	/**
	 * Sets a value to attribute OS. 
	 * @param newOS 
	 */
	public void setOS(Object newOS) {
	    this.OS = newOS;
	}

	/**
	 * Returns iTaches.
	 * @return iTaches 
	 */
	public ArrayList<ITache> getITaches() {
		return this.iTaches;
	}



}
