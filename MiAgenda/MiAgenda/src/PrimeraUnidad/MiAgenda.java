/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeraUnidad;

import java.util.ArrayList;

/**
 *
 * @author Cristian Riffo Huez
 */
public class MiAgenda {

    //clase para poder acceder a la agenda desde cualquier formulario
    //ArrayList fue la forma que encontre de tener un arreglo dinamico
    public ArrayList<Contacto> agenda = new ArrayList<Contacto>();

    public MiAgenda() {
    }
    
    public void agregarContacto(Contacto contacto){
        agenda.add(contacto);
    }
}
