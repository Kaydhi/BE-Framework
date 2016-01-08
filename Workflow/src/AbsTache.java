/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of AbsTache.
 * 
 * @author Max
 */
public class AbsTache implements ITache {
	/**
	 * Description of the property workflows.
	 */
	public ArrayList<Workflow> workflows = new ArrayList<Workflow>();

	/**
	 * Description of the property iParametres.
	 */
	public ArrayList<IParametre> iParametres = new ArrayList<IParametre>();

	/**
	 * Description of the property iTaches.
	 */
	public ArrayList<ITache> iTaches = new ArrayList<ITache>();

	// Start of user code (user defined attributes for AbsTache)

	// End of user code

	/**
	 * The constructor.
	 */
	public AbsTache() {
		// Start of user code constructor for AbsTache)
		super();
		// End of user code
	}

	/**
	 * Description of the method executer.
	 */
	public void executer() {
		// Start of user code for method executer
		// End of user code
	}

	/**
	 * Description of the method getTacheSuivante.
	 */
	public void getTacheSuivante() {
		// Start of user code for method getTacheSuivante
		// End of user code
	}

	/**
	 * Description of the method setTacheSuivante.
	 */
	public void setTacheSuivante() {
		// Start of user code for method setTacheSuivante
		// End of user code
	}

	// Start of user code (user defined methods for AbsTache)

	// End of user code
	/**
	 * Returns workflows.
	 * @return workflows 
	 */
	public ArrayList<Workflow> getWorkflows() {
		return this.workflows;
	}

	/**
	 * Returns iParametres.
	 * @return iParametres 
	 */
	public ArrayList<IParametre> getIParametres() {
		return this.iParametres;
	}

	/**
	 * Returns iTaches.
	 * @return iTaches 
	 */
	public ArrayList<ITache> getITaches() {
		return this.iTaches;
	}

}
