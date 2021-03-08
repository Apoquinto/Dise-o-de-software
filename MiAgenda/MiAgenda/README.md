<div align="center">
    <h1>MiAgenda</h1>
    <b>📗 Una aplicación para almacenar contactos. </b>

</div>

<div align = "center"> pct
    
![MiAgenda](/Images/LogoIcon.png)

</div>

## Código Fuente.
Si gusta de consultar todos los cambios, pueden ser consultados por los commits del repositorio de github: https://github.com/Apoquinto/Dise-o-de-software/commits/main
Ahora, pasaremos a hacer un repaso rápido del código.
1. El primer añadido es propiamente la clase ModuloDePersistencia.
En este caso, omiti los getters y setters para no saturar con código.
``` java
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
```
2. Cambio en el archivo Main para reemplazar el antiguo método manual para cargar archivos.
<div align = "center">
    
![Feature 2.2](/Images/Avance2_2.jpeg)

</div>

3. Ahora tenemos que considerar la función de agregar, para ello cambio en la función de guardado directa de la clase Agregar:
<div align = "center">
    
![Feature 2.2](/Images/Avance2_3.jpeg)

</div>

<div align = "center">
    
![Feature 2.2](/Images/Avance2_4.jpeg)

</div>

## Pruebas.
1. Archivo inicial:
<div align = "center">
    
![Feature 2.2](/Images/Test1.jpeg)

</div>

2. Carga del listado:
<div align = "center">
    
![Feature 2.2](/Images/Test2.jpeg)

</div>

3. Agregado de un contacto:
<div align = "center">
    
![Feature 2.2](/Images/Test3.jpeg)

</div>

4. Comprobación de persistencia de la información:
<div align = "center">
    
![Feature 2.2](/Images/Test4.jpeg)

</div>

## Desarrollo
Diagrama de bloques que muestra las ersponsabilidades de cada parte del programa.
<div align = "center">
    
![MiAgenda](/Images/Diagrama.png)

</div>
