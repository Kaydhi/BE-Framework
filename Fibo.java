import java.util.Map;
import java.io.*;
public class Fibo {
	public static void main(String[] args){
		 
		String nomFichier="Fibo.txt";
		 
		 File entree = new File(nomFichier);
		if (!(entree.exists())){
			try{
			entree.createNewFile();		
			}catch(IOException i){}
		}
		 
		 try{
		 BufferedReader br = new BufferedReader(new FileReader(entree)) ;
		 BufferedWriter bw = new BufferedWriter(new FileWriter(entree)) ;
		 String ligne="";
		 String tmp="";
		  
		 while ((ligne = br.readLine()) != null){
			 tmp=ligne;
		     bw.write(ligne+"\n");
			 bw.flush();
		  }
		 String sValeur[]=tmp.split(" ");
		 if (sValeur[0].equals("")){
			 bw.write("1 1");
		 }
		 else{
			 bw.write(sValeur[1]+Integer.toString(Integer.parseInt(sValeur[0]+Integer.parseInt(sValeur[1]))));
			 bw.flush();
		 }
		 br.close();
		 bw.close();
		 }catch (FileNotFoundException e) {
		 }catch (IOException l){}
		 
	}
}
