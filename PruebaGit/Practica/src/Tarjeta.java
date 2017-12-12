public class Tarjeta {
	private long num_tarjeta; // Número de la tarjeta de crédito
    private String titular; // Titular de la tarjeta de crédito
    private String entidad; // Entidad bancaria
    private Fecha fecha_caducidad; // Fecha en la que caduca la tarjeta de crédito
    private int cod_verificacion; // Código de verificación de la tarjeta de crédito
    
    public Tarjeta(long num_tarjeta, String titular, String entidad, Fecha fecha_caducidad, int cod_verificacion){ // Constructor
        this.num_tarjeta = num_tarjeta;
        this.titular = titular;
        this.entidad = entidad;
        this.fecha_caducidad = fecha_caducidad;
        this.cod_verificacion = cod_verificacion;
    }
    public long getNumTarjeta(){ // Método que devuelve el número de la tarjeta de crédito
        return num_tarjeta;
    }
    public String getTitular(){ // Método que devuelve el titular de la tarjeta de crédito
        return titular;
    }
    public String getEntidad(){ // Método que devuelve la entidad de la tarjeta de crédito
        return entidad;
    }
    public Fecha getFechaCaducidad(){ // Método que devuelve la fecha de caducidad de la tarjeta de crédito
        return fecha_caducidad;
    }
    public int getCodVerificacion(){ // Método que devuelve el código de verificación de la tarjeta de crédito
        return cod_verificacion;
    }
    public String toString(){ // Método que devuelve un String con un resumen de los datos de la tarjeta de crédito
        return "Número de tarjeta: " + num_tarjeta + "; Titular: " + titular + "; Entidad: " + entidad 
                + "; Fecha de caducidad: " + fecha_caducidad.getFecha() + "; Código de verificación: " + cod_verificacion;
    }
            
}
