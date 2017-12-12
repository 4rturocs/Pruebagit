import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
public class Inmobiliaria {

		private int id;
	    private ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // lista de clientes del sistema
	    private ArrayList<Vivienda> viviendas = new ArrayList<Vivienda>(); // lista de viviendas del sistema
	    private int n_solicitudes = 1;
	    
	    
	    public Inmobiliaria(int id,ArrayList<Vivienda> viviendas, ArrayList<Cliente> clientes){ // Constructor
	        this.id = id;
	    	this.clientes = clientes;
	        this.viviendas = viviendas;
	        
	        }
	    public ArrayList<Vivienda> getViviendas(){ // Método que devuelve un array con las viviendas de la inmobiliaria
	        return viviendas;
	    }
	    
	    public ArrayList<Cliente> getClientes(){ // Método que devuelve un array con los clientes registrados en la inmobiliaria
	        return clientes;
	    }
	    public void listarViviendas(){ // Método que imprime todas las viviendas de la inmobiliaria
	        for(int i = 0; i < viviendas.size(); i++){
	            System.out.println(viviendas.get(i).toString()); //get(i) es un metodo que utilizamos en los arraylist para que nos devuelva la posicion del arraylist en el que se encuentra
	        }
	    }
	    public void listarViviendasCompra(){ // Método que imprime todas las viviendas de la inmobiliaria
	        for(int i = 0; i < viviendas.size(); i++){
	        	if(viviendas.get(i).getAlqVenta()==false){
	            System.out.println(viviendas.get(i).toString()); //get(i) es un metodo que utilizamos en los arraylist para que nos devuelva la posicion del arraylist en el que se encuentra
	        	}
	        	}
	    }
	    public void listarViviendasAlquiler(){ // Método que imprime todas las viviendas de la inmobiliaria
	        for(int i = 0; i < viviendas.size(); i++){
	        	if(viviendas.get(i).getAlqVenta()){
	            System.out.println(viviendas.get(i).toString()); //get(i) es un metodo que utilizamos en los arraylist para que nos devuelva la posicion del arraylist en el que se encuentra
	        	}
	        	}
	    }
	    public void listarViviendas0Solicitudes(){
	        for(int i = 0; i < viviendas.size(); i++){
	        	if(viviendas.get(i).getNumSolicitudes() == 0){
	            System.out.println(viviendas.get(i).toString()); //get(i) es un metodo que utilizamos en los arraylist para que nos devuelva la posicion del arraylist en el que se encuentra
	        	}
	        }    
	    }
	    public void listarClientes(){ 
	        for(int i = 0; i < clientes.size(); i++){
	            System.out.println(clientes.get(i).toString()); //get(i) es un metodo que utilizamos en los arraylist para que nos devuelva la posicion del arraylist en el que se encuentra
	        }
	    }
	    public int getNumSolicitudes(){ // Método que devuelve el nº de solicitudes realizadas
	        return n_solicitudes;
	    }
	    public int getSolicitudesVivienda(Vivienda v){ // Método que devuelve el nº de solicitudes de una vivienda determinada
	        return v.getNumSolicitudes();
	    }
	    public Vivienda BuscarVivienda(String id){ //Método que busca una vivienda en el sistema pasándole su matrícula
	        Vivienda v = null;
	        boolean seguir = true;
	        for(int i = 0; i < viviendas.size() && seguir; i++){ // Se recorren todos las viviendas hasta que hay una coindidencia en el dni
				if(viviendas.get(i).getId().equals(id)){ // Si coincide el dni devuelve la vivienda
	                v = viviendas.get(i);
	                seguir = false;
	            }
	        }
	        return v;
	    }
	    public Cliente BuscarCliente(String dni){ // Método que busca un cliente en el sistema pasándole su dni
	        Cliente c = null;
	        boolean seguir = true;
	        for(int i = 0; i < clientes.size() && seguir; i++){ // Se recorren todos los clientes hasta que hay una coindidencia en el dni
	            if(clientes.get(i).getDni().equals(dni)){ // Si coincide el dni se devuelve ese cliente
	                c = clientes.get(i);
	                seguir = false;
	            }
                    
	        }
	        
	        return c;
}   
 
	    public void realizar_solicitud(Solicitud solicitud, Cliente cliente){ // Método que inserta una nueva solicitud en un cliente
                cliente.aniadir_solicitud(solicitud);
               
	    }
	    public void imprimirSolicitudesCliente(Cliente c){ // Método que imprime un resumen de las solicitudes que un cliente determinado ha realizado
	        ArrayList<Solicitud> solicitudes;
	        solicitudes = c.getSolicitudes();	        
	        for(int i = 0; i < c.getNumSolicitudes(); i++){
	            System.out.println(solicitudes.get(i).toString());
	        }
	    }

	    
        public int CalcularEdad(Fecha fecha_nacimiento){
        Calendar c = Calendar.getInstance();
        int edad = (c.get(Calendar.YEAR) - fecha_nacimiento.getAnio() - 1) + (c.get(Calendar.MONTH) == fecha_nacimiento.getMes() ? (c.get(Calendar.DATE)>= fecha_nacimiento.getDia()? 1 : 0) : c.get(Calendar.MONTH) >= fecha_nacimiento.getMes() ? 1 : 0);
        return edad;
        }
        public double calcularPrecioSolicitud(Solicitud s, Cliente c){ // Método que calcula y devuelve el precio de un alquiler según su precio y el nº de días
        double precio_final= 0, descuento;
        descuento = c.descuento();
        precio_final = s.getVivienda().getPrecio()  * descuento;
        
        return precio_final;
    }
        public double calcularPrecioSolicitudAlq(Solicitud s,int tiempo, Cliente c){ // Método que calcula y devuelve el precio de un alquiler según su precio y el nº de días
        double precio_final = 0, descuento;
        if(c.EsJoven()==false){
            descuento = c.descuento();
            precio_final = (s.getVivienda().getPrecio()  + descuento)*tiempo;
        	if(c.EsHabitual()){
        descuento = c.descuento();
        precio_final = (s.getVivienda().getPrecio()  * descuento)*tiempo;
        	}
        }
        else{
        descuento = c.descuento();
        precio_final = (s.getVivienda().getPrecio()  * descuento)*tiempo;
    }
        return precio_final;
        }
        public void insertarCliente(Cliente cliente_nuevo){ // Método que inserta un cliente en el array de clientes
        clientes.add(cliente_nuevo);
        System.out.println("Cliente registrado safistactoriamente");
        }

        public void intercambiarComponentesCliente(int pos1, int pos2){ // Método que intercambia las posiciones de 2 clientes
        Cliente aux;                                             // para poder ordenar el array de clientes
        
        aux = clientes.get(pos1);
        clientes.add(pos1, clientes.get(pos2));
        clientes.remove(pos1 + 1);
        clientes.add(pos2, aux);
        clientes.remove(pos2 + 1);
    }
    public void ordenarClientesDNI(){ // Método que ordena los clientes por su DNI. Utiliza el método de la burbuja. Finalmente imprime el resultado de ordenarlos.
        for(int izda = 0; izda < clientes.size(); izda++){
            for(int i = clientes.size() - 1; i > izda; i--){
                if(clientes.get(i).getDni().compareTo(clientes.get(i-1).getDni()) < 0){
                    intercambiarComponentesCliente(i, i-1);
                }
            }
        }
        for(int i = 0; i < clientes.size(); i++){
                System.out.println(clientes.get(i).toString());
        }
    }
    
    public void ordenarClientesPorNombre(){ // Método que ordena los clientes por su nombre en orden alfabético. Utiliza el método de la burbuja. Finalmente imprime el resultado de ordenarlos.
        for(int izda = 0; izda < clientes.size(); izda++){
            for(int i = clientes.size() - 1; i > izda; i--){
                if(clientes.get(i).getApellidos().compareTo(clientes.get(i-1).getApellidos()) < 0){
                    intercambiarComponentesCliente(i, i-1);
                }
            }
        }
        
        for(int i = 0; i < clientes.size(); i++){
                System.out.println(clientes.get(i).toString());
            }
    }
        public void ordenarClientesPorNombreMenoresX(int x){ // Método que ordena los clientes por su nombre en orden alfabético. Utiliza el método de la burbuja. Finalmente imprime el resultado de ordenarlos.
        for(int izda = 0; izda < clientes.size(); izda++){
            for(int i = clientes.size() - 1; i > izda; i--){
                if((clientes.get(i).getApellidos().compareTo(clientes.get(i-1).getApellidos()) < 0)){
                    intercambiarComponentesCliente(i, i-1);
                }
            }
        }
        
        for(int i = 0; i < clientes.size(); i++){
        	if(clientes.get(i).EsJoven() && CalcularEdad(clientes.get(i).getFNacimiento())< x){
        		System.out.println(clientes.get(i).toString() + ", Tiene carnet");
        	}
        	if(clientes.get(i).EsJoven() == false && CalcularEdad(clientes.get(i).getFNacimiento())< x){
        		System.out.println(clientes.get(i).toString() + ", No tiene carnet");
        	}
            }
    }
        public void ordenarClientesPorNombreRetirarCarnet(){ // Método que ordena los clientes por su nombre en orden alfabético. Utiliza el método de la burbuja. Finalmente imprime el resultado de ordenarlos.
        for(int izda = 0; izda < clientes.size(); izda++){
            for(int i = clientes.size() - 1; i > izda; i--){
                if((clientes.get(i).getApellidos().compareTo(clientes.get(i-1).getApellidos()) < 0)){
                    intercambiarComponentesCliente(i, i-1);
                }
            }
        }
        
        for(int i = 0; i < clientes.size(); i++){
        	if(clientes.get(i).EsJoven() && CalcularEdad(clientes.get(i).getFNacimiento()) > 25){
                System.out.println(clientes.get(i).toString());
        	}
            }
    }
        public void imprimir10ViviendasMasSolicitadas(){ // Método que ordena las viviendas según el nº de solicitudes que poseen. Utiliza el método de la burbuja. Finalmente imprime los 10 viviendas más solicitados.
        for(int izda = 0; izda < viviendas.size(); izda++){
            for(int i = viviendas.size() - 1; i > izda; i--){
                if(viviendas.get(i).getNumSolicitudes() > viviendas.get(i-1).getNumSolicitudes() ){
                    intercambiarComponentesVivienda(i, i-1);
                }
            }
        }
        for(int i = 0; i < 10 && i < viviendas.size(); i++){
                System.out.println("Vivienda: " + viviendas.get(i).getId() + "; Nº de solicitudes: "
                        + viviendas.get(i).getNumSolicitudes());
            }
    }
    public void imprimir3ViviendasConMasGanancias(){ // Método que ordena los viviendas según sus ganancias de mayor a menos. Utiliza el método de la burbuja. Finalmente imprime los 3 viviendas con mas ganancias
        for(int izda = 0; izda < viviendas.size(); izda++){
            for(int i = viviendas.size() - 1; i > izda; i--){
                if(viviendas.get(i).getAlqVenta() && (viviendas.get(i).getGanancias() > viviendas.get(i-1).getGanancias())){
                    intercambiarComponentesVivienda(i, i-1);
                }
            }
        }
        for(int i = 0; i < 3 && i < viviendas.size(); i++){
                System.out.println("Id vivienda: " + viviendas.get(i).getId() + "; Ganancias: " + viviendas.get(i).getGanancias());
            }
    }
    
    public void intercambiarComponentesVivienda(int pos1, int pos2){ // Método que intercambia las posiciones de 2 viviendas
        Vivienda aux;                                             // para poder ordenar el array de viviendas
        
        aux = viviendas.get(pos1);
        viviendas.add(pos1, viviendas.get(pos2));
        viviendas.remove(pos1 + 1);
        viviendas.add(pos2, aux);
        viviendas.remove(pos2 + 1);
    }

        }

    	
    
    

