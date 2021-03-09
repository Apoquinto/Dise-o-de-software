package PrimeraUnidad;

public class Contacto {

    private String nombre;
    private String apellido;
    private String genero;
    private TipoTelefono tipoTelefono;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String apellido, String genero, TipoTelefono tipoTelefono, String telefono, String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.tipoTelefono = tipoTelefono;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono){
        this.tipoTelefono = tipoTelefono;
    }
 
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getGenero(){
        return genero;
    }

    public TipoTelefono getTipoTelefono(){
        return tipoTelefono;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getCorreo(){
        return correo;
    }

    // Transforma los datos de la clase en un String dinámico.
    public String[] obtenerDatos(){
        String[] datos = {getNombre(), getApellido(), getApellido(), getTipoTelefono().toString(), getTelefono(), getCorreo()};
        return datos;
    }
}