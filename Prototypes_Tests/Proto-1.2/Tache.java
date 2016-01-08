import java.io.*;

public class Tache
{
	private LangageTache Langage; // Langage du programme de calcul Ã  executer
	private String[]  scriptToLaunch; 	//Nom et chemin vers le script à executer
	private int position = 0; // Position dans l'ordre d'exÃ©cution du Workflow
	private String[] parameters;	//Paramètres de la tâche
	private boolean automaticExecution; //Si la tâche s'execute automatiquement
	
	public void setLangage(LangageTache input)
	{
		Langage = input;
	}

	public LangageTache getLangage()
	{
		return Langage;
	}

	public void setScriptToLaunch(String[] script)
	{
		scriptToLaunch = script;
	}
	
	public String[] getScriptToLaunch()
	{
		return scriptToLaunch;
	}

	public void setParameters(String[] param)
	{
		parameters = param;
	}
	
	public String[] getParameters()
	{
		return parameters;
	}
	
	protected void setPosition(int input)
	{
		position = input;
	}

	protected int getPosition()
	{
		return position;
	}
	
	public boolean getAutomaticExecution()
	{
		return automaticExecution;
	}

	Tache()
	{
	}
	
	Tache(String[]  _scriptToLaunch, String[] _parameters, boolean _automaticExecution)
	{
		scriptToLaunch = _scriptToLaunch;
		parameters = _parameters;
		automaticExecution = _automaticExecution;
	}

	public void LaunchTache()
	{
		String[] command;
		// OS Detection
		if (isWindows())
		{
			command = new String[]
			{
					"CMD", "/C", getScriptToLaunch()[0]
			}; // Si le type à lancer le .sh au lieu du .bat, ca ne marchera pas
		}
		else
		{
			command = new String[]
			{
					"/bin/sh", getScriptToLaunch()[0]
			};
		}

		command = assemble(command, getParameters());
		ProcessBuilder p = new ProcessBuilder(command);
		p.directory(new File(getScriptToLaunch()[1]));
		try
		{
			Process p2 = p.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					p2.getInputStream()));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					p2.getErrorStream()));
			String line;
			System.out.println("Output of running " + command + " is: ");
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			while ((line = br2.readLine()) != null)
			{
				System.out.println(line);
			}
			p2.destroy();
		}
		catch (IOException e)
		{

		}
	}

	public boolean isWindows()
	{
		return (Workflow.getInstance().getOS().indexOf("win") >= 0);
	}

	public boolean isUnix()
	{
		return (Workflow.getInstance().getOS().indexOf("nix") >= 0 || Workflow.getInstance().getOS().indexOf("nux") >= 0 || Workflow.getInstance().getOS().indexOf("aix") > 0);
	}

	public static String[] assemble(String[] command, String[] parameters)
	{
		String[] commandResult;
		commandResult = new String[command.length + parameters.length];
		int j = 0;
		for (int i = 0; i < command.length; i++)
		{
			commandResult[i] = command[i];
			j++;
		}
		for (int i = 0; i < parameters.length; i++)
		{
			commandResult[i + j] = parameters[i];
		}
		return commandResult;
	}
	
	public static Tache createTacheDefined()
	{
		FenetreParametrage fp=FenetreParametrage.getInstance();
			
		 String[] _scriptToLaunch = new String[] {
				fp.getScriptName(),
				fp.getScriptDirectory()	
		}; 
			
		String[] _parameters = new String [] {
				fp.getSearchedFileParam1(),
				fp.getSearchedFileParam2(),
				fp.getNumberOfCalculus()
		};
		
		Tache tache = new Tache(_scriptToLaunch, _parameters, fp.getAutomatic());
		return tache;
	}
}
