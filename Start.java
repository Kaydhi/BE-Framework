import IHM.FenetreParametrage;

public class Start {					

	static String [] scriptToLaunch;
	static String [] parameters;
	
	public static void initializeParameters(){
		
		FenetreParametrage fp=FenetreParametrage.getInstance();
		
		scriptToLaunch = new String[] {
				fp.getScriptName(),
				fp.getScriptDirectory()	
		};
		
		parameters = new String [] {
				fp.getSearchedFileParam1(),
				fp.getSearchedFileParam2(),
				fp.getNumberOfCalculus()
		};
			
	}
	
	public static String[] getScriptToLaunch(){
		return scriptToLaunch;
	}
	
	public static String[] getParameters(){
		return parameters;
	}
}
