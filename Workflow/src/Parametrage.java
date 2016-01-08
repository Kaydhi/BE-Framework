/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Parametrage.
 * 
 * @author Max
 */
public class Parametrage implements IParametre {
	/**
	 * Description of the property script.
	 */
	public ArrayList<String> script = ;
	
	/**
	 * Description of the property parametres.
	 */
	public ArrayList<String> parametres = ;
	
	/**
	 * Description of the property Interpreteur.
	 */
	public ArrayList<String> Interpreteur = ;
	
	/**
	 * Description of the property options.
	 */
	public ArrayList<String> options = ;
	
	// Start of user code (user defined attributes for Parametrage)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Parametrage() {
		// Start of user code constructor for Parametrage)
		super();
		// End of user code
	}
	
	// Start of user code (user defined methods for Parametrage)
	
	// End of user code
	/**
	 * Returns script.
	 * @return script 
	 */
	public ArrayList<String> getScript() {
		return this.script;
	}
	
	/**
	 * Sets a value to attribute script. 
	 * @param newScript 
	 */
	public void setScript(ArrayList<String> newScript) {
	    this.script = newScript;
	}

	
	/**
	 * Returns parametres.
	 * @return parametres 
	 */
	public ArrayList<String> getParametres() {
		return this.parametres;
	}
	
	/**
	 * Sets a value to attribute parametres. 
	 * @param newParametres 
	 */
	public void setParametres(ArrayList<String> newParametres) {
	    this.parametres = newParametres;
	}

	/**
	 * Returns Interpreteur.
	 * @return Interpreteur 
	 */
	public ArrayList<String> getInterpreteur() {
		return this.Interpreteur;
	}
	
	/**
	 * Sets a value to attribute Interpreteur. 
	 * @param newInterpreteur 
	 */
	public void setInterpreteur(ArrayList<String> newInterpreteur) {
	    this.Interpreteur = newInterpreteur;
	}

	/**
	 * Returns options.
	 * @return options 
	 */
	public ArrayList<String> getOptions() {
		return this.options;
	}
	
	/**
	 * Sets a value to attribute options. 
	 * @param newOptions 
	 */
	public void setOptions(ArrayList<String> newOptions) {
	    this.options = newOptions;
	}



}
