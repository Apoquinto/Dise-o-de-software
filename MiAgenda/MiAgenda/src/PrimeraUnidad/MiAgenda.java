/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraUnidad;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Cristian Riffo Huez
 */
public class MiAgenda {

    //clase para poder acceder a la agenda desde cualquier formulario
    //ArrayList fue la forma que encontre de tener un arreglo dinamico
    private static ArrayList<Contacto> agenda = new ArrayList<Contacto>();

    public MiAgenda() {
        MiAgenda.agenda = AgendaCSV.obtenerContactos();
    }
    
    public static void nuevoContacto(String [] datos){
        TipoTelefono tipoTelefono;
        if(datos[3] == "Fijo"){
            tipoTelefono = TipoTelefono.FIJO;
        }
        else{
            tipoTelefono = TipoTelefono.CELULAR;
        }
        Contacto contacto = new Contacto(datos[0], datos[1], datos[2], tipoTelefono, datos[4], datos[5]);
        AgendaCSV.agregarContacto(datos);
        agregarContacto(contacto);
    }

    public static void agregarContacto(Contacto contacto){
        agenda.add(contacto);
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
