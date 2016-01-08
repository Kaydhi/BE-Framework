import java.io.*;
import java.io.IOException;


//This file must be in the same folder than the MEO
public class main
{
	private static String OS = System.getProperty("os.name").toLowerCase();	//Specify the current OS
	
	public static void LaunchMEO()
	{
		FenetreParametrage.getInstance();	//Launch the IHM
		//Get the parameters defined by the user
		System.out.println(Start.getParameters());
		System.out.println(Start.getScriptToLaunch());
		String[] command;
		//OS Detection
		if (isWindows()) 
		{
			command = new String [] {"CMD", "/C", Start.getScriptToLaunch()[0]}; //Si le type à lancé le .sh au lieu du .bat, ca ne marchera pas
		}
		else
		{
			command = new String [] {"/bin/sh", Start.getScriptToLaunch()[0]};
		}

		command = assemble(command, Start.getParameters());
		ProcessBuilder p = new ProcessBuilder(command);
		p.directory(new File(Start.getScriptToLaunch()[1]));
		try
		{
			Process p2 = p.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getErrorStream()));
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
	
	public static boolean isWindows() 
	{
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isUnix() 
	{
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}
	
	public static String[] assemble(String[] command, String[] parameters)
	{
		String[] commandResult;
		commandResult = new String[command.length + parameters.length];
		int j = 0;
		for (int i = 0; i<command.length; i++)
		{
			commandResult[i] = command[i];
			j++;
		}
		for (int i=0; i<parameters.length; i++)
		{
			commandResult[i + j] = parameters[i];
		}
		return commandResult;
	}
}
