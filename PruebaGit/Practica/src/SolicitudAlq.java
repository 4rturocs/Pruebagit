public class SolicitudAlq extends Solicitud {
	private int tiempo;
	private Tsolicitud tipo;
	public SolicitudAlq(int id_solicitud, Vivienda ViviendaSolicitada, int tiempo){
		super(id_solicitud,ViviendaSolicitada);
		this.tiempo = tiempo;
		tipo = Tsolicitud.PENDIENTE ;
		
	}
	public int getTiempo(){
		return tiempo;
	}
	public Tsolicitud getTipo(){
		return tipo;
	}
}
