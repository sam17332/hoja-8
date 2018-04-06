import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Rodrigo Samayoa
 * @author Marcos Gutierrez
 * @since 05 abril 2018
 * Main
 */

public class Main 
{
	public static void main(String[] args)
    {
		 //Pacientes m = new Pacientes(nombre, sintoma, codigo//);
		 /*Relacionamos las clases con un vector*/
		 VectorHeap<Pacientes> vector  = new VectorHeap<Pacientes>();
		 
         try{
        	 /*Abrimos el archivo*/
        	 File texto = new File(System.getProperty("user.dir")+"\\"+"Pacientes .txt");
        	 /*Lectura de archivo*/
        	 FileReader leer = new FileReader(texto);
        	 /*Lectura del Archivo*/
             BufferedReader buff = new BufferedReader(leer);
             String linea;
             while((linea = buff.readLine()) != null) {
            	 String[] linea2 = linea.split(", ");
          	   	 String nombre = linea2[0];
          	     String sintoma = linea2[1];
          	     String codigo = linea2[2];
          	     //System.out.println(codigo);
          	     /*agregamos los datos al vector*/
          	     vector.add(new Pacientes(nombre,sintoma,codigo));
             }
             /*cerramos el codigo*/
             buff.close(); 
         }catch(IOException e){
        	 /*manda un error*/
        	 System.out.println("Ocurrio un error " + e.getMessage());
         }
         /*imprimimos los datos*/
         System.out.println("El orden para atender el paciente es: " + "\n" + "NOMBRE" + "\n" + "SINTOMA" + "\n" + "CODIGO");
         while(!vector.isEmpty()) {
        	 System.out.println(vector.remove().toString());
         }
    }
}
