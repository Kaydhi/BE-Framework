import java.util.ArrayList;
import java.util.List;

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
	public String script;
	
	/**
	 * Description of the property parametres.
	 */
	public ArrayList<String> parametres;
	
	/**
	 * Description of the property interpreteur.
	 */
	public String interpreteur;
	
	/**
	 * Description of the property options.
	 */
	public ArrayList<String> options;
	
	// Start of user code (user defined attributes for Parametrage)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Parametrage() {
		parametres = new ArrayList<String>();
		options = new ArrayList<String>();
	}
	
	/**
	 * Overloaded constructor.
	 */
	public Parametrage(String newinterpreteur, String newscript, ArrayList<String> newparam, ArrayList<String> newoptions) {
		interpreteur = newinterpreteur;
		script = newscript;
		parametres = newparam;
		options = newoptions;
	}
	
	// Start of user code (user defined methods for Parametrage)
	
	// End of user code
	/**
	 * Returns script.
	 * @return script
	 */
	public String getScript() {
		return this.script;
	}
	
	/**
	 * Sets a value to attribute parametres. 
	 * @param newParametres 
	 */
	public void setScript(String newScript) {
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
	 * Returns interpreteur.
	 * @return interpreteur 
	 */
	public String getInterpreteur() {
		return this.interpreteur;
	}
	
	/**
	 * Sets a value to attribute Interpreteur. 
	 * @param newInterpreteur 
	 */
	public void setInterpreteur(String newInterpreteur) {
	    this.interpreteur = newInterpreteur;
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
