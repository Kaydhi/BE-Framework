import java.util.ArrayList;
import java.util.ListIterator;

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
	 * Description of the method getInterpreteur.
	 */
	public String[] getInterpreteur();
	public void setInterpreteur(String[] newInterpreteur);



	public String[] getAllParameters();



}