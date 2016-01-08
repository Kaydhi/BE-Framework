package IHM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class FenetreParametrage extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static FenetreParametrage singleton;
	
	public static FenetreParametrage getInstance(){
		if (singleton==null){
			singleton=new FenetreParametrage();}
		return singleton;
		}
	
	
	JTextField text0=new JTextField("Paramètre 0 - Fichier MEO");
	JTextField text1=new JTextField("Paramètre 1 - Chemin de sortie");
	JTextField text2=new JTextField("Paramètre 2 - Chemin de sortie temporaire");
	JTextField text3=new JTextField("Paramètre 3 - Nombre d'appels");
	
	
	JButton boutonValider=new JButton("Valider");
	JButton boutonParcourir0=new JButton("Parcourir...");
	JButton boutonParcourir1=new JButton("Parcourir...");
	JButton boutonParcourir2=new JButton("Parcourir...");
	
	JCheckBox check1=new JCheckBox("Automatique");
	
	private File searchedFileParam0;
	private File searchedFileParam1;
	private File searchedFileParam2;
	

	private FenetreParametrage(){
		
		//Definition générale de la fenetre
		setTitle("Parametrage");
		setBounds(500,300,650,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); //rend impossible de redimensionner la fenetre
	
		//Definition des tailles max des zones de texte
		text1.setSize(600,50);
		text1.setMaximumSize(text1.getSize());
		text2.setSize(600,50);
		text2.setMaximumSize(text2.getSize());
		text3.setSize(600,50);
		text3.setMaximumSize(text3.getSize());
		text0.setSize(600,50);
		text0.setMaximumSize(text0.getSize());
		
		//Definition des layouts
		Box b0=Box.createHorizontalBox();
		b0.add(Box.createHorizontalStrut(20));
		b0.add(text0);
		b0.add(Box.createHorizontalStrut(10));
		b0.add(boutonParcourir0);
		b0.add(Box.createHorizontalStrut(20));
		
		Box b1=Box.createHorizontalBox();
		b1.add(Box.createHorizontalStrut(20));
		b1.add(text1);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(boutonParcourir1);
		b1.add(Box.createHorizontalStrut(20));
		
		Box b2=Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(20));
		b2.add(text2);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(boutonParcourir2);
		b2.add(Box.createHorizontalStrut(20));
		
		Box b3=Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(text3);
		b3.add(Box.createHorizontalStrut(20));
		
		Box b4=Box.createHorizontalBox();
		b4.add(Box.createHorizontalGlue());
		b4.add(boutonValider);
		b4.add(Box.createHorizontalStrut(80));
		b4.add(check1);
		b4.add(Box.createHorizontalGlue());
		
		Box b5=Box.createVerticalBox();
		b5.add(Box.createVerticalGlue());
		b5.add(b0);
		b5.add(Box.createVerticalStrut(30));
		b5.add(b1);
		b5.add(Box.createVerticalStrut(30));
		b5.add(b2);
		b5.add(Box.createVerticalStrut(30));
		b5.add(b3);
		b5.add(Box.createVerticalStrut(30));
		b5.add(b4);
		b5.add(Box.createVerticalGlue());
		
		Container c=getContentPane();
		c.add(b5);
		
		//ajout des écouteurs
		boutonValider.addActionListener(this);
		boutonParcourir1.addActionListener(this);
		boutonParcourir0.addActionListener(this);
		boutonParcourir2.addActionListener(this);
		check1.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent a){
		
		//action bouton valider
		if (a.getSource()==boutonValider)
		{
			
		}
		
		//action du bouton parcourir pour le parametre Chemin MEO
				if (a.getSource()==boutonParcourir0)
				{
					final JFileChooser myChoice = new JFileChooser();
					int returnVal = myChoice.showOpenDialog(getParent());

					if (returnVal == JFileChooser.APPROVE_OPTION){
						searchedFileParam0=myChoice.getSelectedFile();
						System.out.println("File returned: "+searchedFileParam0.getName());
						System.out.println("Path: "+searchedFileParam0.getAbsolutePath());
						text0.setText(searchedFileParam0.getAbsolutePath());		
					} else {
						System.out.println("Cancelled");
					}
				}
				
		//action du bouton parcourir pour le parametre Chemin de sortie
		if (a.getSource()==boutonParcourir1) {
			final JFileChooser myChoice = new JFileChooser();
			myChoice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int returnVal = myChoice.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION){
				searchedFileParam1=myChoice.getSelectedFile();
				System.out.println("File returned: "+searchedFileParam1.getName());
				System.out.println("Path: "+searchedFileParam1.getAbsolutePath());
				text1.setText(searchedFileParam1.getAbsolutePath());		
			} else {
				System.out.println("Cancelled");
			}
		}
	
		//action du bouton parcourir pour le parametre Chemin de sortie temporaire
				if (a.getSource()==boutonParcourir2)
				{
					final JFileChooser myChoice = new JFileChooser();
					myChoice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = myChoice.showOpenDialog(getParent());

					if (returnVal == JFileChooser.APPROVE_OPTION){
						searchedFileParam2=myChoice.getSelectedFile();
						System.out.println("File returned: "+searchedFileParam2.getName());
						System.out.println("Path: "+searchedFileParam2.getAbsolutePath());
						text2.setText(searchedFileParam2.getAbsolutePath());		
					} else {
						System.out.println("Cancelled");
					}
				}
		
		//action de la check box "automatique"
		if (a.getSource()==check1){
			System.out.println("Automatique : "+check1.isSelected());
		}
	}


public String getScriptName(){
	return searchedFileParam0.getName();
}

public String getScriptDirectory(){
	return searchedFileParam0.getParent();
}

public String getSearchedFileParam1(){
	return searchedFileParam1.getAbsolutePath();
}


public String getSearchedFileParam2(){
	return searchedFileParam2.getAbsolutePath();
}

public String getNumberOfCalculus()
{
	return text3.getText();
}

}
