package PrimeraUnidad;

public enum TipoTelefono {
    FIJO("Fijo"), 
    CELULAR("Celular");

    public final String brandName;
    
    TipoTelefono(String brandName){
        this.brandName = brandName;
    }

    /**
     * 
     * @return String
     */
    public String getBrandName(){
        return brandName;
    }
}
