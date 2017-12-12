public class Solicitud {
    private int id_solicitud;
    private Vivienda ViviendaSolicitada; // Vivienda que ha solicitado el cliente
	private Tsolicitud tipo;
	Cliente cliente;
	
	public Solicitud(int id_solicitud, Vivienda ViviendaSolicitada){
		this.id_solicitud = id_solicitud;
		this.ViviendaSolicitada = ViviendaSolicitada;
		tipo = Tsolicitud.PENDIENTE ;
		
	}
	public Cliente getCliente(){
		return cliente;
	}

	public int getId_solicitud(){
		return id_solicitud;
		
	}
	public Vivienda getVivienda(){
		return ViviendaSolicitada;
		
	}
	public Tsolicitud getTSolicitud(){
		return tipo;
		
	}
	public void setTSolicitud(Tsolicitud tipo){
		this.tipo = tipo;	
	}

        public String toString(){
            return "id solicitud : " + id_solicitud + " ;  vivienda solicitada -> " + ViviendaSolicitada;
            
        }
}
