/*
 * Main.java
 *
 * Created on 19 de diciembre de 2007, 3:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package PrimeraUnidad;

import javax.swing.UIManager;

/**
 *
 * @author Cristian Riffo Huez
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Look and Feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception anyException) {
        }
        
        // Iniciamos la carga de la información del modulo de persistencia.
        Contacto Juan = new Contacto("Juan", "Perez","Masculino",TipoTelefono.FIJO,"051233525", "JuanPerez@correo.com");
        Contacto Maria = new Contacto("Maria", "Gonzales","Femenino",TipoTelefono.CELULAR,"0981234567", "MariaGonzales@correo.com");
        MiAgenda.agregarContacto(Juan);
        MiAgenda.agregarContacto(Maria);
        
        //instanciamos listado
        new Listado().setVisible(true);
        //llenamos la lista con datos en MiAgenda
        Listado.mostrarContactos();
    }
}
