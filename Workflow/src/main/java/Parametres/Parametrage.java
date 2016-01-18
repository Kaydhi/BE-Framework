package Parametres;
import java.util.ArrayList;
import java.util.ListIterator;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Parametrage
 */
public class Parametrage implements IParametre {

	private String nomScript;
	private String cheminScript; //Chemin absolu à partir de l'endroit où est situé le WorkFlow
	private String interpreteur;
	
	/*Non utilisé
	/**
	 * Extension
	private String extension;
	 */
	
	/**
	 * Description of the property parametres.
	 */
	private ArrayList<String> parametres;

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
	public Parametrage(String newInterpreteur, String newScriptName, String newScriptPath, ArrayList<String> newparam, ArrayList<String> newoptions) {
		interpreteur=newInterpreteur;
		nomScript=newScriptName;
		cheminScript=newScriptPath;
		parametres = newparam;
		options = newoptions;
		/*extension = constructExtension(nomScript); non utilisé*/
	}

	/**
	 * Returns script name.
	 * @return script name
	 */
	public String getInterpreteur() {
		return interpreteur;
	}
	
	/**
	 * Sets a value to attribute interpreteur. 
	 * @param newParametres 
	 */
	public void setInterpreteur(String newInterpreteur) {
	    interpreteur = newInterpreteur;
	}
	
	/**
	 * Returns script name.
	 * @return script name
	 */
	public String getNomScript() {
		return nomScript;
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

	/*Non utilisé
	/**
	 * Returns interpreteur.
	 * @return interpreteur 
	public String getExtension() {
		return extension;
	}
	*/

	/**
	 * Returns options.
	 * @return options 
	 */
	public ArrayList<String> getOptions() {
		return this.options;
	}
	
	/*
	 Permet de connaitre l'extension du fichier à executer,
	 fonction non utilisée pour le moment
	/**
	 * Sets a value to attribute options. 
	 * @param newOptions 
	public String constructExtension(String _nomScript) 
	{
		String _extension = "";
		boolean recupererLettres = false;
		for (int i = 0 ; i < _nomScript.length() ;i++)
		{
			if (recupererLettres)
			{
				_extension += _nomScript.charAt(i);
			}
			if (_nomScript.charAt(i) == '.')
			{
				recupererLettres = true;
			}
		}
		return _extension;
	}*/

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

	public String[] getOptionsAndParameters(){
		String[] allParameters = new String[getOptions().size() + getParametres().size()];
		allParameters = assemble(convertArrayListToTableauString(getOptions()), convertArrayListToTableauString(getParametres()));
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