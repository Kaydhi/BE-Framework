import java.util.Arrays;

//faire un pattern singleton

public class Workflow {
	
	private static String OS = System.getProperty("os.name").toLowerCase();	//Specify the current OS
	private static Workflow singleton;
	private Tache[] listeTaches;
	private int nbTaches;

	public String getOS()
	{
		return OS;
	}
	
	private Workflow()
	{
		listeTaches = new Tache[0];
		nbTaches = 0;
	}
	
	public static Workflow getInstance()
	{
		if (singleton == null)
			singleton = new Workflow();
		return singleton;
	}
	
	public Tache[] getListeTaches()
	{
		return listeTaches;
	}
	
	public void ajouterTache(Tache Ajout, int pos) {
		if (pos > nbTaches) {
			/*
			 * si on ajoute une taÄ‰he avec une position plus haute que celles
			 * qui existent, on l'ajoute en derniÃ¨re position
			 */
			listeTaches[nbTaches] = Ajout;
			nbTaches++;
			Ajout.setPosition(nbTaches);
		} else {
			for (int i = 0; i < nbTaches; i++) { // si on ajoute une tÃ¢che au
													// milieu, on dÃ©cale les
													// autre tÃ¢ches
				if (listeTaches[i].getPosition() >= pos) {
					listeTaches[i].setPosition(listeTaches[i].getPosition() + 1);
				}
			}
			listeTaches[nbTaches] = Ajout;
			nbTaches++;
			Ajout.setPosition(pos);
		}
	}

	public void changerPos(Tache Task, int pos) {
		if ((Task.getPosition() != 0) && (Arrays.asList(listeTaches).contains(Task))) {
			int posIni = Task.getPosition();
			if (posIni > pos) {
				for (int i = 0; i < nbTaches; i++) {
					if (listeTaches[i].getPosition() >= pos) {
						listeTaches[i].setPosition(listeTaches[i].getPosition() + 1);
					}
				}
				Task.setPosition(pos);
			} else if (posIni < pos) {
				for (int i = 0; i < nbTaches; i++) {
					if ((listeTaches[i].getPosition() <= pos) && (listeTaches[i].getPosition() > pos)) {
						listeTaches[i].setPosition(listeTaches[i].getPosition() - 1);
					}
				}
				Task.setPosition(pos);
			} else {
				System.out.println("TÃ¢che dÃ©ja Ã  sa position ! ");
			}
		} else {
			System.out.println("TÃ¢che non prÃ©sente dans le WorkFlow ! ");
		}
	}

	public void executerTaches() {
		for (int i = 1; i < nbTaches + 1; i++) {
			if (listeTaches[i].getAutomaticExecution())
			listeTaches[i].LaunchTache();
			/* else
			 //Lancer IHM de "continuer l'execution"
				//Faire une pause ici jusqu'à ce que l'utilisateur appui sur un bouton "continuer Execution" */
		}
	}
}
