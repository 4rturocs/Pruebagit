import java.util.ArrayList;

public class Vivienda {
protected String id;
protected double mcuadrados;
protected int antiguedad;
protected boolean alq_venta; //True == alquiler ; False == venta
protected double precio;
protected int NSolicitudes;
protected boolean disponible; 
protected double ganancias;
protected ArrayList<Solicitud> solicitudes;  //no 
public Vivienda(String id, double mcuadrados,double precio, int antiguedad,boolean alq_venta){
	this.id = id;
	this.mcuadrados = mcuadrados;
	this.antiguedad = antiguedad;
	this.precio = precio;
	this.alq_venta = alq_venta;
	this.NSolicitudes = 0;
}
public String getId(){
	return id;

}
public double getMCuadrados(){
	return mcuadrados;
	
}
public int getAntiguedad(){
	return antiguedad;
	
}
public boolean getAlqVenta(){
	return alq_venta;
	
}
public double getPrecio(){
    return precio;
    
}
public double getGanancias(){
    return ganancias;
    
}
public void sumarGanancias(double dinero){  // Método que suma las ganancias por la vivienda
    ganancias += dinero;
}
public boolean getDisponibilidad(){
    return disponible;
    
}
public void setDisponibilidad(boolean disponible){ // Método que permite modificar la disponibilidad de la vivienda
    this.disponible = disponible;  
}
public int getNumSolicitudes(){
	return NSolicitudes;
}
public void setNumSolicitudes(){
	this.NSolicitudes+=1;
}

    public String toString(){// Método que devuelve un String con los datos de la vivienda
        return "Id: " + id + "; Metros cuadrados: " + mcuadrados + "; Precio: " +  precio + "; Antigüedad: " + antiguedad + "; Alquiler o Venta: " + alq_venta + "(true: alquiler ; false = venta)";
    }
}
