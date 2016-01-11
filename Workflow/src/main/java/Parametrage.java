import java.util.ArrayList;
import java.util.ListIterator;

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
	private String nomScript;
	private String cheminScript;

	/**
	 * Description of the property parametres.
	 */
	private ArrayList<String> parametres;

	/**
	 * Description of the property interpreteur.
	 */
	private String[] interpreteur;

	/**
	 * Description of the property options.
	 */
	private ArrayList<String> options;

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
	public Parametrage(String newinterpreteur, String newScriptName, String newScriptPath, ArrayList<String> newparam, ArrayList<String> newoptions) {

		interpreteur = stringToTabString(newinterpreteur);
		nomScript=newScriptName;
		cheminScript=newScriptPath;
		parametres = newparam;
		options = newoptions;
	}

	// Start of user code (user defined methods for Parametrage)

	// End of user code

	/**
	 * Returns script name.
	 * @return script name
	 */
	public String getNomScript() {
		return this.nomScript;
	}

	/**
	 * Sets a value to attribute parametres. 
	 * @param newParametres 
	 */
	public void setNomScript(String newScriptName) {
	    this.nomScript = newScriptName;
	}

	/**
	 * Returns script path.
	 * @return script path
	 */
	public String getCheminScript() {
		return this.cheminScript;
	}

	/**
	 * Sets a value to attribute parametres. 
	 * @param newParametres 
	 */
	public void setScriptPath(String newScriptPath) {
	    this.cheminScript = newScriptPath;
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
	public String[] getInterpreteur() {
		return this.interpreteur;
	}

	/**
	 * Sets a value to attribute Interpreteur. 
	 * @param newInterpreteur 
	 */
	public void setInterpreteur(String[] newInterpreteur) {
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

	public static String[] stringToTabString(String s){
		String[] temp= new String[1];
		temp[0]=s;
		return temp;

	}

	public String[] getAllParameters(){
		String[] allParameters = new String[getOptions().size() + getParametres().size() + getInterpreteur().length];
		allParameters = assemble(getInterpreteur(), assemble(convertArrayListToTableauString(getParametres()), convertArrayListToTableauString(getOptions())));
		return allParameters;
	}

	public static String[] convertArrayListToTableauString(ArrayList<String> array1){
		String[] commandResult = new String[array1.size()];

		ListIterator<String> ite = array1.listIterator();
		int i=0;
		while (ite.hasNext())
		{
			commandResult[i] = ite.next();
			ite.next();
			i++;
		}

		return commandResult;
	}

	public static String[] assemble(String[] strings1, String[] strings2)
	{
		String[] commandResult;
		commandResult = new String[strings1.length + strings2.length];
		int j = 0;
		for (int i = 0; i < strings1.length; i++)
		{
			commandResult[i] = strings1[i];
			j++;
		}
		for (int i = 0; i < strings2.length; i++)
		{
			commandResult[i + j] = strings2[i];
		}
		return commandResult;
	}


}