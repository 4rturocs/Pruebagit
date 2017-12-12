public class Piso extends Vivienda{
	private Tpiso tipo;
	private boolean amueblado;
public Piso(String id, double mcuadrados,double precio, int antiguedad,boolean alq_venta,Tpiso tipo, boolean amueblado) {
		super(id, mcuadrados,precio,antiguedad, alq_venta);
		this.tipo = tipo;
		this.amueblado = amueblado;
	}
public Tpiso getTpiso() {
	return tipo;
}
public void setTpiso(Tpiso tipo){
	this.tipo = tipo;
}
public boolean getAmueblado() {
	return amueblado;
}
public void setAmueblado(boolean amueblado){
	this.amueblado = amueblado;
}
public String toString(){
	return "Id: " + id + "; Metros cuadrados: " + mcuadrados + "; Precio: " +  precio + "; Antigüedad: " + antiguedad + "; Alquiler o Venta: " + alq_venta + "(true: alquiler ; false = venta)"+"; Tipo: "+tipo+ " ;Amueblado: "+amueblado;
}


}
