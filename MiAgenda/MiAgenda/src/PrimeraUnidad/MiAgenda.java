/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraUnidad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Cristian Riffo Huez
 */
public class MiAgenda {

    //clase para poder acceder a la agenda desde cualquier formulario
    //ArrayList fue la forma que encontre de tener un arreglo dinamico
    public static ArrayList<Contacto> agenda = new ArrayList<Contacto>();

    public MiAgenda() {
    }
    
    public static void agregarContacto(Contacto contacto){
        agenda.add(contacto);
        System.out.println("Agregado contacto: " + contacto.getNombre());
    }

    public static Iterator<String []> cargarContactos(){
        ArrayList<String []> contactos = new ArrayList<String []>();
        Iterator<Contacto> it = agenda.iterator();
        while(it.hasNext()) {
            Contacto contactoAuxiliar = it.next();
            contactos.add(contactoAuxiliar.obtenerDatos());
        }
        Iterator<String []> iter =contactos.iterator();
        return iter;
    }
}
