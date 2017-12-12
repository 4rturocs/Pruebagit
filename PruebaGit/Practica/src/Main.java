	import java.io.*;
	import java.util.Scanner;
	import java.util.ArrayList;

	public class Main {
	        static Scanner leer = new Scanner(System.in);
		public static void main(String[]args) throws IOException{
	        boolean seguir = true;
	        int opc;
	        Vivienda vivienda = null; 
	        ArrayList<Vivienda> viviendas;
	        Cliente cliente = null;
	        ArrayList<Cliente> clientes;
	        Solicitud solicitud = null;
	        String dni = null, idVivienda=null;
	        int id_solicitud = 0, x=0, tiempo = 0, id = 1;
	        double precio_final = 0, descuento=0;
	        viviendas = leerViviendas("D:\\3ºAño\\Programación\\Practicas\\Viviendas.txt"); // lectura de viviendas
	        clientes = leerClientes("D:\\3ºAño\\Programación\\Practicas\\Clientes.txt", "D:\\3ºAño\\Programación\\Practicas\\Tarjetas.txt"); // lectura de los clientes
	        Inmobiliaria inmobiliaria = new Inmobiliaria(id,viviendas, clientes); // creación de la inmobiliaria
	        leerSolicitudes("D:\\3ºAño\\Programación\\Practicas\\Solicitudes.txt", inmobiliaria); // lectura de las solicitudes
			do{
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("| Bienvenido. Escoja la opción deseada indicando su número:                                    |");
	            System.out.println("| 1: Consultar viviendas en alquiler o venta                                                   |"); 
	            System.out.println("| 2: Realizar una solicitud de alquiler o venta                                                |");
	            System.out.println("| 3: Consultar sus solicitudes realizadas                                                      |");
	            System.out.println("| 4: Consultar si es un cliente habitual                                                       |"); 
	            System.out.println("| 5: Consultar si se le realiza algún tipo de descuento                                        |"); 
	            System.out.println("| 6: Consultar el número de solicitudes de una vivienda determinada                            |"); 
	            System.out.println("| 7: Listar los clientes registrados por DNI                                                   |"); 
	            System.out.println("| 8: Listar los clientes registrados por orden alfabético                                      |"); 
	            System.out.println("| 9: Listar los 10 viviendas mas solicitados del sistema                                       |"); 
	            System.out.println("| 10: Listar los 3 viviendas con más ingresos                                                  |");
	            System.out.println("| 11: Listar alfabéticamente los menores de X años, indicando si tienen o no carnet joven      |");
	            System.out.println("| 12: listar alfabéticamente los clientes a los que se les debe retirar el carnet joven        |");
	            System.out.println("| 13: listarViviendas0Solicitudes()                                                            |");
	            System.out.println("| 14: salir                                                                                    |");
	            System.out.println("------------------------------------------------------------------------------------------------");
	            opc = comprobarOpcion(); // leemos la opcion
			switch(opc){
	                    case 1:
	                    Opt1(inmobiliaria);
	                    
	                    break;
	            	    case 2:
		                Opt2(inmobiliaria,dni,cliente,idVivienda,id_solicitud,vivienda,tiempo,solicitud,precio_final);
	                    
	                    break;
	                    case 3:
	                    Opt3(dni,cliente,inmobiliaria);
	                    
	                    break;
	                    case 4:
	                    Opt4(dni,cliente,inmobiliaria);
	                  
	                    break;
	                    case 5:
	                    Opt5(dni,cliente,inmobiliaria,descuento);
	                   
	                    break;
	                   
	                    case 6:
	                    Opt6(inmobiliaria,vivienda,idVivienda);
	                    
	                    break;
	                    case 7:
	                    Opt7(inmobiliaria);
	                    
	                    break;
	                    case 8:
	                    Opt8(inmobiliaria);
	                    
	                    break;
	                    case 9:
	                    Opt9(inmobiliaria);
	                    
	                    break;
	                    case 10:
	                    Opt10(inmobiliaria);
	                    
	                    break;
	                    case 11:
	                    Opt11(inmobiliaria, x);
	                    
	                    break;      
	                    case 12:
	                    Opt12(inmobiliaria);
	                    
	                    break;
	                    case 13:
		                inmobiliaria.listarViviendas0Solicitudes();	
	                    
	                    break;  
	                    case 14:
	                    seguir = false; // Ponemos la variable de seguir a false para apagar el sistema
	                    break;
	            } 
			}while(seguir);
		}
		
		  public static ArrayList<Vivienda> leerViviendas (String fichero_viviendas) throws IOException{
			ArrayList<Vivienda> viviendas = new ArrayList <Vivienda>();
			Vivienda vivienda;
	               try{
	            	File f=new File(fichero_viviendas);
	                Scanner nombre_f = new Scanner (f);    
	                while (nombre_f.hasNext()){
	                char tipo_=nombre_f.next().charAt(0);
	                Tpiso tipo = null;
	                if(tipo_=='a'){ 
	                tipo= Tpiso.APARTAMENTO;
	                }
	                else if(tipo_=='e'){
	            	tipo=Tpiso.ESTUDIO;
	                }
	                else if(tipo_=='p'){
	            	tipo=Tpiso.PISO;
	                }
	                String id=nombre_f.next();
	                double mcuadrados=nombre_f.nextDouble();
	                double precio=nombre_f.nextDouble();
	                int antiguedad=nombre_f.nextInt();
	                String alq_venta1= nombre_f.next();
	                boolean alq_venta;
	                alq_venta = alq_venta1.equals("alquiler"); //Venta = False
	                if (tipo_=='c'){ //PROBAR CON EQUALS
		        double distancia=nombre_f.nextDouble();
		        boolean piscina=nombre_f.nextBoolean();
		        vivienda = new Chalet(id,mcuadrados, precio, antiguedad, alq_venta, distancia, piscina);
	                }
	                else {
		        boolean amueblado=nombre_f.nextBoolean();

		        vivienda = new Piso(id,mcuadrados,precio,antiguedad,alq_venta,tipo,amueblado);
	                }
	                viviendas.add(vivienda);
	                }
		    nombre_f.close();
	               }catch(Exception ex){
	            	   ex.printStackTrace();
		    			
		    		}
	           
		    return viviendas;
		  }
		  public static ArrayList<Cliente>  leerClientes (String fichero_clientes,String fichero_tarjetas)throws IOException{
	        ArrayList<Cliente> clientes = new ArrayList <Cliente>();
	        Cliente cliente;
	        Tarjeta tarjeta;
	        try{
	        File f=new File(fichero_clientes);
		    Scanner nombre_f = new Scanner (f);
		    while (nombre_f.hasNext()){
		    String dni=nombre_f.next();
	        String nombre=nombre_f.next();
		    String apellidos=nombre_f.next();
		    long Ntarjeta= nombre_f.nextLong();
		    tarjeta = leerTarjetas(fichero_tarjetas,Ntarjeta);
		    String Fecha=nombre_f.next();
	            String dia1 = Fecha.substring(0, 2); // cogemos de la fecha los caracteres que representan el día
	            int dia = Integer.parseInt(dia1); 
	            String mes1 = Fecha.substring(3, 5); // cogemos de la fecha los caracteres que representan el mes
	            int mes = Integer.parseInt(mes1);
	            String anio1 = Fecha.substring(6, 10); // cogemos de la fecha los caracteres que representan el año
	            int anio = Integer.parseInt(anio1);
	            Fecha Fnacimiento = new Fecha(dia, mes, anio);
		      long telefono = nombre_f.nextLong();
		        String email = nombre_f.next();
		      if (nombre_f.hasNextInt()){
		        int Ncarnet=nombre_f.nextInt();
		        cliente = new Joven(dni,nombre,apellidos,tarjeta,Fnacimiento,email,telefono,Ncarnet);
		      }
		      else {
		    	cliente = new Cliente(dni,nombre,apellidos,tarjeta,Fnacimiento,email,telefono);
		      }
			    clientes.add(cliente);
		    }
	            
		    nombre_f.close();
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        return clientes;
	          }
		  public static Tarjeta leerTarjetas(String fichero_tarjetas, long Ntarjeta)throws IOException{
			  Tarjeta tarjeta = null;
	            try{
			  File f=new File(fichero_tarjetas);
			  Scanner nombre_f = new Scanner (f);
			  boolean seguir = true;
			  	while(nombre_f.hasNext() && seguir){ 
				  long Numtarjeta = nombre_f.nextLong();// si es el mismo esos serán los datos de la tarjeta del cliente
		          if(Ntarjeta == Numtarjeta){
		          seguir = false;  // en este for primero lee el nº de la tarjeta y lo compara con el nº de tarjeta pasado como parámetro,
		          
		          String titular = nombre_f.next();
		          String entidad = nombre_f.next();
		          String Fnacimiento=nombre_f.next();
		          String dia1 = Fnacimiento.substring(0, 2); // cogemos de la fecha los caracteres que representan el día
		          int dia = Integer.parseInt(dia1); 
		          String mes1 = Fnacimiento.substring(3, 5); // cogemos de la fecha los caracteres que representan el mes
		          int mes = Integer.parseInt(mes1);
		          String anio1 = Fnacimiento.substring(6, 10); // cogemos de la fecha los caracteres que representan el año
		          int anio = Integer.parseInt(anio1);
		          Fecha fecha = new Fecha(dia, mes, anio);
		  		  int cod_verificacion = nombre_f.nextInt();
		  		  tarjeta = new Tarjeta(Numtarjeta,titular,entidad,fecha,cod_verificacion);   
		                }
	                else{
	                    nombre_f.nextLine();
	                }
			  	}
			  	nombre_f.close();
	            }catch(Exception ex){
	            	ex.printStackTrace();
	            }
	          	return tarjeta;	

			  }

		  public static  void leerSolicitudes(String fichero_solicitudes,Inmobiliaria i)throws IOException{
		    Solicitud solicitud;
		    Vivienda vivienda;
		    Cliente cliente;
		    try{
	            File f=new File(fichero_solicitudes);
	            Scanner nombre_f = new Scanner (f);
		    for(;nombre_f.hasNextLine();){   
	            String dni = nombre_f.next(); // lectura de los datos
	            String id_vivienda = nombre_f.next();
	            if (nombre_f.hasNextInt()){
		            int tiempo = nombre_f.nextInt();
		            vivienda = i.BuscarVivienda(id_vivienda); // búsqueda a través del concesionario el vehículo solicitado
		            cliente = i.BuscarCliente(dni);
		            int id = cliente.getNumSolicitudes();
			        solicitud = new SolicitudAlq(id,vivienda,tiempo);
			        i.realizar_solicitud(solicitud, cliente);
			      }else{
			    	  	cliente = i.BuscarCliente(dni);
			            int id = cliente.getNumSolicitudes();
			            vivienda = i.BuscarVivienda(id_vivienda); // búsqueda a través del concesionario el vehículo solicitado
			            cliente = i.BuscarCliente(dni); // búsqueda a través del concesionario del cliente que ha solicitado el alquiler
			            solicitud = new Solicitud(id,vivienda); 
			            i.realizar_solicitud(solicitud, cliente);
			      }				  
			  }
			nombre_f.close();
		    }catch(Exception ex){
		    	ex.printStackTrace();
		    }
	          
		  }
	        public static int comprobarOpcion(){ // Método que comprueba que se introduzca una opción válida
	        int opcion = 0;
	        String op;
	        do{
	            try{
	                System.out.println("Introduzca la opción deseada");
	                op = leer.next(); // lee la opcion
	                opcion = comprobarNumero(op); // comprueba si es un número
	                
	                if(opcion < 1 || opcion > 16){
	                    throw new Excepcion("El número debe ser una de las opciones válidas de la lista"); // lanzamos la excepción
	                }
	            }catch(Excepcion e){ // capturamos la excepción
	                System.out.println(e.getMessage());
	            }
	        }while(opcion < 1 || opcion > 14); // se realizará mientras no sea una opción válida
	        
	        return opcion;
	    }
	        public static int comprobarNumero(String num){ // Método que comprueba si el String pasado como parámetro es un entero
	        int numero = 0;

	        try{
	            for(int i = 0; i < num.length(); i++){
	                if(Character.isDigit(num.charAt(i)) == false){
	                    throw new Excepcion("No se ha introducido un número");
	                }
	            }
	            numero = Integer.parseInt(num); // Pasamos el string a int
	        }catch(Excepcion e){
	            System.out.println(e.getMessage());
	        }
	   
	        return numero;
	    }
	        public static String comprobarDNI(){ // Método que comprueba si el DNI introducido es válido
	        String DNI = "";
	        boolean seguir;
	        
	        do{
	            seguir = false;
	            try{
	                System.out.println("Introduzca su DNI: ");
	                DNI = leer.next(); // introducción del dni
	                
	                if(DNI.length() > 9 || DNI.length() < 9){
	                    seguir = true;
	                    throw new Excepcion("DNI no válido: debe poseer 8 dígitos y una letra"); // lanzamos la excepcíón
	                }
	                else{
	                    for(int i = 0; i < 8; i++){
	                        if(DNI.charAt(i) < 0 && DNI.charAt(i) > 9){
	                            seguir = true;
	                            throw new Excepcion("DNI no válido: debe poseer 8 dígitos y una letra"); // lanzamos la excepcíón
	                        }
	                    }
	                    if(!Character.isLetter(DNI.charAt(8))){
	                        seguir = true;
	                        throw new Excepcion("DNI no válido: debe poseer 8 dígitos y una letra"); // lanzamos la excepcíón
	                    }
	                }
	            }catch(Excepcion e){
	                System.out.println(e.getMessage());
	            }
	        }while(seguir);
	        
	        return DNI;
	    }
	        public static Cliente leerDatosCliente(String dni,Inmobiliaria i){ // Método que lee los datos de un nuevo cliente y lo añade en la lista de clientes
	            Scanner leer = new Scanner(System.in);
	            Cliente cliente_nuevo;
	            boolean seguir = true;
	            System.out.println("Introduzca su nombre");
	            String nombre = leer.next();
	            System.out.println("Introduzca sus apellidos");
	            String apellidos = leer.next();
	            System.out.println("Introduzca su número de teléfono");
	            long telefono = leer.nextLong();
	            System.out.println("Introduzca su número de tarjeta");
	            long num_tarjeta = leer.nextLong();
	            System.out.println("Introduzca el nombre del titular de la tarjeta");
	            String titular = leer.next();
	            System.out.println("Introduzca la entidad de la tarjeta");
	            String entidad = leer.next();
	            System.out.println("Introduzca el día de la fecha de caducidad de la tarjeta");
	            int dia_caducidad_tarjeta = comprobarNumero();
	            System.out.println("Introduzca el mes de la fecha de caducidad de la tarjeta");
	            int mes_caducidad_tarjeta = comprobarNumero();
	            System.out.println("Introduzca el año de la fecha de caducidad de la tarjeta");
	            int anio_caducidad_tarjeta = comprobarNumero();
	            Fecha caducidad_tarjeta = new Fecha(dia_caducidad_tarjeta, mes_caducidad_tarjeta, anio_caducidad_tarjeta);
	            System.out.println("Introduzca el código de verificación de la tarjeta");
	            int cod_verificacion = comprobarNumero();
	            Tarjeta tarjeta = new Tarjeta(num_tarjeta, titular, entidad, caducidad_tarjeta, cod_verificacion);
	            System.out.println("Introduzca el día de su nacimiento");
	            int dia_nacimiento = comprobarNumero();
	            System.out.println("Introduzca el mes de su nacimiento");
	            int mes_nacimiento = comprobarNumero();
	            System.out.println("Introduzca el año de su nacmiento");
	            int anio_nacimiento = comprobarNumero();
	            Fecha Fnacimiento = new Fecha(dia_nacimiento,mes_nacimiento,anio_nacimiento);
	            System.out.println("Introduzca su correo electronico");
	            String correo = leer.next();
	            if(i.CalcularEdad(Fnacimiento)<=25){
	                int Ncarnet = 12;
	                System.out.println("Su número de carnet joven es: " + Ncarnet);
	                Ncarnet++;
	                cliente_nuevo = new Joven(dni,nombre,apellidos,tarjeta,Fnacimiento,correo,telefono,Ncarnet);
	                
	            }else{
	                cliente_nuevo = new Cliente(dni,nombre,apellidos,tarjeta,Fnacimiento,correo,telefono);
	            }
	            i.insertarCliente(cliente_nuevo);
	            return cliente_nuevo;
	        }
	        public static int comprobarNumero(){ // método para comprobar que se ha introducido un número
	            int numero = 0;
	            String num;
	            boolean seguir = false;
	            Scanner leer = new Scanner(System.in);

	            do{
	                try{
	                    seguir = false;
	                    num = leer.next();
	                    for(int i = 0; i < num.length(); i++){
	                        if(Character.isDigit(num.charAt(i)) == false){
	                            seguir = true;
	                            throw new Excepcion("No se ha introducido un número");
	                        }
	                    }
	                    numero = Integer.parseInt(num);
	                }catch(Excepcion e){
	                    System.out.println(e.getMessage());
	                }
	            }while(seguir);
	            
	       
	            return numero;
	        }
	        public static void Opt1(Inmobiliaria inmobiliaria){
                System.out.println("Estos son las viviendas disponibles: ");
                inmobiliaria.listarViviendas();
	        }
	        public static void Opt2(Inmobiliaria inmobiliaria,String dni,Cliente cliente,String idVivienda, int id_solicitud,Vivienda vivienda,int tiempo, Solicitud solicitud,double precio_final){
	        	System.out.println("¿Desea realizar una solicitud de compra o de alquiler? Introduzca (c) para compra o (a) para alquiler ");
	        	String n = leer.next();
	        	while(!n.equals("c") && !n.equals("a")){
	        		System.out.println("Error! Introduzca (c) para compra o (a) para alquiler ");
	        		n = leer.next();
	        	}
	        	if(n.equals("c")){
	        	System.out.println("Estos son las viviendas disponibles: ");
                inmobiliaria.listarViviendasCompra();
                System.out.println("Para poder realizar la solicitud indique los siguientes datos: ");
                dni = comprobarDNI(); // Introducción del dni
                cliente = inmobiliaria.BuscarCliente(dni); // Búsqueda del cliente en el sistema
                if(cliente == null){ // Si el dni introducido no está registrado
                    System.out.println("Cliente nuevo (no existe en la base de datos el DNI introducido)");
                    System.out.println("A continuación debe de introducir sus datos para registrarse safistactoriamente");
                    cliente = leerDatosCliente(dni,inmobiliaria); // Leemos los datos del cliente
                }
                System.out.println("Creación de la solicitud:");
                System.out.println("Introduzca el id de la vivienda que desea: ");
                idVivienda = leer.next(); 
                id_solicitud = cliente.getNumSolicitudes() +1;
                vivienda = inmobiliaria.BuscarVivienda(idVivienda);
            	while(vivienda == null || vivienda.getAlqVenta()==true){
                	System.out.println("Datos incorrectos: La vivienda no existe");
	                System.out.println("Estos son las viviendas disponibles: ");
	                inmobiliaria.listarViviendasCompra();
	                System.out.println("Introduzca el id de la vivienda que desea: ");
	                idVivienda = leer.next();
                    vivienda = inmobiliaria.BuscarVivienda(idVivienda);
            	}
            	solicitud = new Solicitud(id_solicitud, vivienda); // Creación de la solicitud
                inmobiliaria.realizar_solicitud(solicitud, cliente); // Añadimos la solicitud al cliente
                precio_final = inmobiliaria.calcularPrecioSolicitud(solicitud, cliente); // Cálculo del precio
                System.out.println("Solicitud realizada. El precio de compra de la vivienda será de: " + precio_final + " €");
	        	}else{
            		System.out.println("Estos son las viviendas disponibles: ");
                    inmobiliaria.listarViviendasAlquiler();
                    System.out.println("Para poder realizar la solicitud indique los siguientes datos: ");
                    dni = comprobarDNI(); // Introducción del dni
                    cliente = inmobiliaria.BuscarCliente(dni); // Búsqueda del cliente en el sistema
                    if(cliente == null){ // Si el dni introducido no está registrado
                        System.out.println("Cliente nuevo (no existe en la base de datos el DNI introducido)");
                        System.out.println("A continuación debe de introducir sus datos para registrarse safistactoriamente");
                        cliente = leerDatosCliente(dni,inmobiliaria); // Leemos los datos del cliente
                    }
                    System.out.println("Creación de la solicitud:");
                    System.out.println("Introduzca el id de la vivienda que desea: ");
                    idVivienda = leer.next(); 
                    id_solicitud = cliente.getNumSolicitudes() +1;
                    vivienda = inmobiliaria.BuscarVivienda(idVivienda);
                	while(vivienda == null || vivienda.getAlqVenta()==false){
                    	System.out.println("Datos incorrectos: La vivienda no existe");
    	                System.out.println("Estos son las viviendas disponibles: ");
    	                inmobiliaria.listarViviendasCompra();
    	                System.out.println("Introduzca el id de la vivienda que desea: ");
    	                idVivienda = leer.next();
                        vivienda = inmobiliaria.BuscarVivienda(idVivienda);
                        
            	}
                    System.out.println("Introduzca el número de meses que desea la vivienda: ");
                    tiempo = leer.nextInt();
                	solicitud = new SolicitudAlq(id_solicitud, vivienda,tiempo); // Creación de la solicitud
                    inmobiliaria.realizar_solicitud(solicitud, cliente); // Añadimos la solicitud al cliente
                    precio_final = inmobiliaria.calcularPrecioSolicitudAlq(solicitud,tiempo,cliente); // Cálculo del precio
                    System.out.println("Solicitud realizada. El precio del alquiler total de la vivienda será de: " + precio_final + " €"+ " durante estos " + tiempo + " meses");
                    }

                		
                	}
   
                	
	        
	        public static void Opt3(String dni, Cliente cliente,Inmobiliaria inmobiliaria){
	        dni=comprobarDNI(); // Lectura del DNI
            cliente = inmobiliaria.BuscarCliente(dni);
            if(cliente != null){
            inmobiliaria.imprimirSolicitudesCliente(cliente); // Muestra las solicitudes del cliente con sus datos y estado
            }
            else{
            System.out.println("No existe un cliente con el DNI introducido");
            }
	        }
	        public static void Opt4(String dni, Cliente cliente,Inmobiliaria inmobiliaria){
	        	dni=comprobarDNI(); // Lectura del DNI
                cliente = inmobiliaria.BuscarCliente(dni);
                if(cliente != null){ 
                    if(cliente.EsHabitual()) {
                        System.out.println("Es un cliente habitual");
                    }else System.out.println("No es un cliente habitual");
                }
                else
                    System.out.println("No existe un cliente con el DNI introducido");
	        }
	        public static void Opt5(String dni, Cliente cliente, Inmobiliaria inmobiliaria, double descuento){
	        	 dni=comprobarDNI();
                 cliente = inmobiliaria.BuscarCliente(dni);
                 if(cliente != null){
                     if(cliente.EsJoven()) {
                         descuento = 0.20;
                         if(cliente.EsHabitual()){
                             descuento += 0.05;
                         }  
                     System.out.println("Tiene un descuento del " + descuento + "%");
                     System.out.println("");

                     }else if(cliente.EsHabitual()){
                         descuento = 0.10;
                     System.out.println("Tiene un descuento del " + descuento + "%");
                     System.out.println("");

                 }if(cliente.EsJoven() != true && cliente.EsHabitual() != true){
                     System.out.println("No tiene descuento");
                     System.out.println("");
                 }
                         
                 }
                 else
                     System.out.println("Error al introducir los datos del dni del cliente o el id de la vivienda");   
	        }
	        public static void Opt6(Inmobiliaria inmobiliaria, Vivienda vivienda, String idVivienda){	
            System.out.println("Lista de viviendas de la inmobiliaria: ");
            inmobiliaria.listarViviendas(); 
            System.out.println("Introduzca el id de la vivienda de la que desee consultar las solicitudes: ");
            idVivienda = leer.next(); 
            vivienda = inmobiliaria.BuscarVivienda(idVivienda);
            if(vivienda != null){
                System.out.println("El número de solicitudes de la vivienda indicada es: " );
                inmobiliaria.getSolicitudesVivienda(vivienda); // Impresión del nº de solicitudes del vehículo
            }
            else{
                System.out.println("No existe en el sistema un vivienda con el id introducido");
            }
	        }
	        public static void Opt7(Inmobiliaria inmobiliaria){
                System.out.println("Lista de clientes ordenados por DNI: ");
                inmobiliaria.ordenarClientesDNI(); // Muestra los clientes ordenados por DNI
	        }
	        public static void Opt8(Inmobiliaria inmobiliaria){
                System.out.println("Lista de clientes ordenados por orden alfabético: ");
                inmobiliaria.ordenarClientesPorNombre(); // Muestra los clientes ordenados por orden alfabético
	        }
	        public static void Opt9(Inmobiliaria inmobiliaria){
            System.out.println("Lista de las 10 viviendas más solicitadas: ");
            inmobiliaria.imprimir10ViviendasMasSolicitadas(); 
	        }
	        public static void Opt10(Inmobiliaria inmobiliaria){
            System.out.println("Lista de las 3 viviendas con más ingresos: ");
            inmobiliaria.imprimir3ViviendasConMasGanancias();
	        }
	        public static void Opt11(Inmobiliaria inmobiliaria, int x){
            System.out.println("Introduzca la edad a partir de la cual desea la lista de cliente ordenados alfabeticamente");
            x = leer.nextInt();
            System.out.println("Lista de clientes ordenados por orden alfabético menores de " +x+ " años : ");
            inmobiliaria.ordenarClientesPorNombreMenoresX(x);
	        }
	        public static void Opt12(Inmobiliaria inmobiliaria){
            System.out.println("Lista de clientes ordenados por orden alfabético que se les tiene que retirar el carnet : ");
            inmobiliaria.ordenarClientesPorNombreRetirarCarnet();
	        }
	}		
