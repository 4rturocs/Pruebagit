import java.util.ArrayList;

public class Cliente {
protected String dni;
protected String nombre;
protected String apellidos;
protected Tarjeta tarjeta;
protected Fecha Fnacimiento;
protected long telefono;
protected String email;
protected ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();

public Cliente(String dni, String nombre, String apellidos, Tarjeta tarjeta, Fecha Fnacimiento, String email, long telefono) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.tarjeta = tarjeta;
	this.telefono = telefono;  
	this.Fnacimiento = Fnacimiento;
    this.email = email;
    this.telefono = telefono;

}

public String getDni(){
	return dni;
	 
}
public String getNombre(){
	return nombre;
	
}
public String getApellidos(){
    return apellidos;
}
public boolean EsJoven(){ // Método que devuelve un boolean indicando si el cliente que se le pasa como argumento es joven o no.
    return (this instanceof Joven);
	
}
public boolean EsHabitual(){
    return getNumSolicitudes() >= 3;
}
public Tarjeta getTarjeta(){
	return tarjeta;
	
}
public long getTelefono(){
	return telefono;
	
}
public String getEmail(){
	return email;
	
}
public Fecha getFNacimiento(){
	return Fnacimiento;
	

}
public int getNumSolicitudes(){ // Método que devuelve el nº de solicitudes
    return solicitudes.size();

}
public void aniadir_solicitud(Solicitud s){ // Método que añade una solicitud al array de solicitudes del cliente
    solicitudes.add(s);
}

public ArrayList<Solicitud> getSolicitudes(){ // // Método que devuelve las solicitudes del cliente
    return solicitudes;
}
public double descuento(){ // Método que devuelve el descuento que se le aplica a un cliente
    double descuento=0;
    if(EsHabitual()){
      descuento = 0.10;   
    
}
        return descuento;
    }
public String toString(){
    return " dni :" + dni + "nombre :" + nombre + " Apellidos : " + apellidos + " tarjeta : " +tarjeta.getNumTarjeta() + " Email : " + email+ " Fecha de nacimiento : " + Fnacimiento.getFecha() + " Telefono : " + telefono ;
}
}