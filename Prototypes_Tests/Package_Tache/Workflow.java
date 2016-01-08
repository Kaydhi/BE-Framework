package gestionTache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Workflow {
	private Tache[] listeTache;
	private int nbTaches = 0;

	public void ajouterTache(Tache Ajout, int pos) {
		if (pos > nbTaches) {
			/*
			 * si on ajoute une taĉhe avec une position plus haute que celles
			 * qui existent, on l'ajoute en dernière position
			 */
			listeTache[nbTaches] = Ajout;
			nbTaches++;
			Ajout.setPosition(nbTaches);
		} else {
			for (int i = 0; i < nbTaches; i++) { // si on ajoute une tâche au
													// milieu, on décale les
													// autre tâches
				if (listeTache[i].getPosition() >= pos) {
					listeTache[i].setPosition(listeTache[i].getPosition() + 1);
				}
			}
			listeTache[nbTaches] = Ajout;
			nbTaches++;
			Ajout.setPosition(pos);
		}
	}

	public void changerPos(Tache Task, int pos) {
		if ((Task.getPosition() != 0) && (Arrays.asList(listeTache).contains(Task))) {
			int posIni = Task.getPosition();
			if (posIni > pos) {
				for (int i = 0; i < nbTaches; i++) {
					if (listeTache[i].getPosition() >= pos) {
						listeTache[i].setPosition(listeTache[i].getPosition() + 1);
					}
				}
				Task.setPosition(pos);
			} else if (posIni < pos) {
				for (int i = 0; i < nbTaches; i++) {
					if ((listeTache[i].getPosition() <= pos) && (listeTache[i].getPosition() > pos)) {
						listeTache[i].setPosition(listeTache[i].getPosition() - 1);
					}
				}
				Task.setPosition(pos);
			} else {
				System.out.println("Tâche déja à sa position ! ");
			}
		} else {
			System.out.println("Tâche non présente dans le WorkFlow ! ");
		}
	}

	public void executerTache() {
		for (int i = 1; i < nbTaches + 1; i++) {
			Tache tacheCourante= listeTache[i];
			String compil="";
			String command[];
			if(tacheCourante.getOS()==SystemeExploitation.LINUX){
				compil="/bin/bash";
				 command = new String[3];
				 command[1] = compil;
				 command[2] = tacheCourante.getCheminScript();
				 command[3] = "Argument";
					
			}else{
				compil = "CMD";
				command= new String[4];
				command[1] = compil;
				command[2] = "/C";
				command[3] = tacheCourante.getCheminScript();
				command[4] = "Argument";
			}
			System.out.println( command.toString());
			ProcessBuilder p = new ProcessBuilder(command);
			for (int j=1; j<=tacheCourante.getNbAppels();j++){
				try {
					Process p2 = p.start();
					BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
					String line;
	
					System.out.println("Output of running " + command + " is: ");
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
				p2.destroy();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
