package Parametres;
import java.util.ArrayList;

/*******************************************************************************
 import java.util.ArrayList;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of IParametre.
 * 
 * @author Max
 */
public interface IParametre {

	public String getInterpreteur();
	public void setInterpreteur(String newInterpreteur);
	
	/**
	 * Description of the method getParametres.
	 */
	public String getNomScript();
	public String getCheminScript();

	/**
	 * Description of the method getParametres.
	 */
	public ArrayList<String> getParametres();

	/**
	 * Description of the method getOptions.
	 */
	public ArrayList<String> getOptions();
	
	/**
	 * Permet d'obtenir les options et les paramètres
	 * concaténés dans un même tableau de strings
	 * @return
	 */
	public String[] getOptionsAndParameters();
}