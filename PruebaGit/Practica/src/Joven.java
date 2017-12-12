
public class Joven extends Cliente {
	private int Ncarnet;

public Joven(String dni,String nombre,String apellidos,Tarjeta tarjeta,Fecha Fnacimiento, String email, long telefono,int Ncarnet) {
			super(dni,nombre,apellidos,tarjeta,Fnacimiento,email,telefono);
			this.Ncarnet = Ncarnet;
	}
public int getNCarnet() {
	return Ncarnet;
}
public double descuento(){
	double descuento = 0.20;
	if(EsHabitual()){
            descuento += 0.05;
}
    return descuento;
}
public void setNCarnet(int Ncarnet){
	this.Ncarnet = Ncarnet;
}
public String toString(){
	return " dni :" + dni + "nombre :" + nombre + " Apellidos : " + apellidos + " tarjeta : " +tarjeta.getNumTarjeta() + " Email : " + email+ " Fecha de nacimiento : " + Fnacimiento.getFecha() + " Telefono : " + telefono + " Número de Carnet: "+Ncarnet ;
}
}