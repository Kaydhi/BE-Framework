import java.util.Map;
import java.io.*;
public class Fibo {
	public static void main(String[] args){
		 
		String nomFichier="Fibo.txt";
		 
		 File entree = new File(nomFichier);
		if (!(entree.exists())){
			try{
			entree.createNewFile();		
			}catch(IOException i){i.printStackTrace();}
		}
		File sortie = new File("Sortie.txt");
		try{
			entree.createNewFile();		
			}catch(IOException i){i.printStackTrace();}
		 
		 try{
		 BufferedReader br = new BufferedReader(new FileReader(entree)) ;
		 BufferedWriter bw = new BufferedWriter(new FileWriter(sortie)) ;
		 String ligne="";
		 String tmp="";
		  
		 if (entree.exists()){
			 System.out.println("Fichier existant!");
		 }
		 
		 System.out.println(br.read());
		 while ((ligne = br.readLine()) != null){
			 tmp=ligne;
		     System.out.println("lign:"+ligne);
		     bw.write(ligne+" \n");
			 bw.flush();
		  }
		 
		 String sValeur[]=tmp.split(" ");
		 System.out.println(tmp);
		 if (sValeur[0].equals("")){
			 bw.write("0 1 \n");

		 }
		 else{
			 int val = Integer.parseInt(sValeur[0])+Integer.parseInt(sValeur[1]);
			 bw.write(sValeur[1]+" "+Integer.toString(val)+"\n");
			 bw.flush();
		 }
		 
		 br.close();
		 bw.close();
		 entree.delete();
		 sortie.renameTo(new File("Fibo.txt"));
		 }catch (FileNotFoundException e) {
		 }catch (IOException l){}
		 
	}
}
