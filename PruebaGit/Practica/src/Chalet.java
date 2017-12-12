public class Chalet extends Vivienda{
	private boolean piscina;
	private double distancia;
public Chalet(String id, double mcuadrados,double precio, int antiguedad,boolean alq_venta,double distancia, boolean piscina){
		super(id, mcuadrados,precio,antiguedad, alq_venta);
		this.piscina = piscina;
		this.distancia = distancia;
	}
public boolean getPiscina() {
	return piscina;
}
public void setPiscina(boolean piscina){
	this.piscina = piscina;
}

public double getDistancia() {
	return distancia;
}
public void setDistancia(double distancia){
	this.distancia = distancia;
}
public String toString(){
	return "Id: " + id + "; Metros cuadrados: " + mcuadrados + "; Precio: " +  precio + "; Antigüedad: " + antiguedad + "; Alquiler o Venta: " + alq_venta + "(true: alquiler ; false = venta)"+ "; Piscina: "+piscina+"; distancia: "+ distancia;
}


}