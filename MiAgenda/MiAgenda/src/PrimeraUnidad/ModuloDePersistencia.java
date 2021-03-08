/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraUnidad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Roberto Llanes
 */
public class ModuloDePersistencia{
    
    private String currentPath;
    private String fileName;
    private String path;
    
    public ModuloDePersistencia(){
        this.currentPath = "C:\\Temporal\\";
        this.fileName = "contactos.csv";
        this.path = this.currentPath + this.fileName;
    }

    /** 
     * Carga los contactos almacenados de la aplicación.
     */
    public void obtenerContactos(){
        String[] contacto = null;
        String line = "";
        
        try {
            BufferedReader lector = new BufferedReader(new FileReader(this.path));
            // Ignoro la linea de titulo
            lector.readLine();
            // Leo todos los contactos que se tengan registrados.
            while((line = lector.readLine()) != null){
                 contacto = line.split(",");
                 MiAgenda.agenda.add(contacto);
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo encontrar el archivo correspondiente :c");
        } catch (IOException e){
            System.out.println("Error al leer el archivo.");
        }
    }
    
    public static void agregarContacto(String[] contacto){
        // Agrego el contacto a la información de la aplicación.
        MiAgenda.agenda.add(contacto);
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

    /** 
     * @return String
     */
    public String getCurrentPath() {
        return currentPath;
    }

    
    /** 
     * @param currentPath
     */
    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    
    /** 
     * @return String
     */
    public String getPath() {
        return path;
    }

    
    /** 
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    
    /** 
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    
    /** 
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
        
}