package PrimeraUnidad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AgendaCSV {
    private String currentPath;
    private String fileName;
    private String path;
    
    public AgendaCSV(){
        this.currentPath = "C:\\Temporal\\";
        this.fileName = "contactos.csv";
        this.path = this.currentPath + this.fileName;
    }
    /** 
     * Carga los contactos almacenados de la aplicación.
     */
    public static ArrayList<Contacto> obtenerContactos(){
        String[] datos = null;
        String line = "";
        ArrayList<Contacto> contactosAgenda = new ArrayList<Contacto>();
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Temporal\\contactos.csv"));
            // Ignoro la linea de titulo
            lector.readLine();
            System.out.println("Test");

            // Leo todos los contactos que se tengan registrados.
            while((line = lector.readLine()) != null){
                datos = line.split(",");
                TipoTelefono tipoTelefono;
                if(datos[3] == "Fijo"){
                    tipoTelefono = TipoTelefono.FIJO;
                }
                else{
                    tipoTelefono = TipoTelefono.CELULAR;
                }


                Contacto contacto = new Contacto(datos[0], datos[1], datos[2], tipoTelefono, datos[4], datos[5]);
                
                contactosAgenda.add(contacto);
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo encontrar el archivo correspondiente :c");
        } catch (IOException e){
            System.out.println("Error al leer el archivo.");
        }
        return contactosAgenda;
    }
    
    public static void agregarContacto(String[] contacto){
        // Almaceno el contacto en el archivo .csv
        FileWriter escritor = null;
        PrintWriter pw = null;
        try{
            escritor = new FileWriter("C:\\Temporal\\contactos.csv", true);
            pw = new PrintWriter(escritor);
            pw.println(contacto[0]+","+contacto[1]+","+contacto[2]+","+contacto[3]+","+contacto[4]+","+contacto[5]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != escritor)
              escritor.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
