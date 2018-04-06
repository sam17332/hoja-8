import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rodrigo Samayoa
 * @since 05 abril 2018
 * Main
 */

public class Main 
{
	public static void main(String[] args)
    {
		 Pacientes m = new Pacientes();
		 File texto = new File(System.getProperty("user.dir")+"\\"+"Pacientes.txt");
         try{
               FileReader leer = new FileReader(texto);
               BufferedReader buff = new BufferedReader(leer);
               String linea;
               while((linea = buff.readLine()) != null)
               {
               }
         }catch(IOException e){
     
         }
	
    }
}
