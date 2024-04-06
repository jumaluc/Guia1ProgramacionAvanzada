import java.util.*;
public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Clientes[] clientes = new Clientes[10];
		Prepagas [] prepagas= new Prepagas[15]; //SON 15
		Sucursales [] sucursales = new Sucursales[10];
		Tratamientos tratamientos[] = new Tratamientos[10];
		Particulares.setCantidadClientesParticulares(0);

		int arranque = 1;
		int menu=1;
while (true) {
	
	if(arranque>=3) {
	System.out.println();
	System.out.println("<<Ingrese 1 para registrar las sucursales, las prepagas y los tratamientos junto con el valor adicional de Salud (OBLIGATORIO) :  ");
	System.out.println("<<Ingrese 2 para registrar los clientes y sus tratamientos  (OBLIGATORIO):  ");
	System.out.println("<<Ingrese 3 para modificar algun tratamiento de un cliente :  ");
	System.out.println("<<Ingrese 4 para mostrar datos de clientes con prepara cuyo valor total supere el tope de reintegro :  ");
	System.out.println("<<Ingrese 5 para indicar el nombre del tratamiento de tipo corporal que no haya sido utilizado en los ultimos 3 meses :  ");
	System.out.println("<<Ingrese 6 para mostrar la cantidad de clientes que se atendieron en Bueno Aires :  ");
	System.out.println("<<Ingrese 7 para indicar la cantidad de clientes particulares que se atienden :  ");
	System.out.println("<<Ingrese 8 para mostrar el nombre de los cliente que hayan ingresado hace moenos de 30 dia y paguen con debito:  ");
	System.out.println("<<Ingrese 9 para mostrar la cantidad de cliente con prepagas o particulares de cada sucursal:  ");
	System.out.println("<<Ingrese 10 para mostrara la cantidad de cliente cuya edad supere un numero al azar de 2 digitos y tenga algun tratamiento con consulta medica extra :  ");
	System.out.println("<<Ingrese 11 para finalizar:  ");
	System.out.print("(1/11): ");
	menu = validarInt();
	if(menu==11) {
		System.out.println("-¡¡Programa finalizado!!-");
		break;
	}
	
	}
	else {
		menu=arranque;
	}
	
switch(menu) {
case 1 :
		//INGRESO SUCURSALES
		System.out.println("Ingresar las 5 sucursales: ");
		for(int i=0 ; i<sucursales.length; i++) {
			sucursales[i]=new Sucursales();
			System.out.printf("-SUCURSAL %d- ",i+1);
			System.out.println();
			sucursales[i].setIdSucursal(i);
			System.out.print("Nombre: ");
			String aNombre= validarString();
			while(true) {
				if(repeticionSucursales(sucursales, aNombre)) {
					sucursales[i].setNombre(aNombre);
					break;
				}
				else {
					System.out.print("Los nombres no pueden repetirse. Ingrese nuevamente: ");
					aNombre= validarString();
				}
			}
			System.out.print("Localidad: ");
			sucursales[i].setLocalidad(validarString());
			System.out.print("Provincia: ");
			sucursales[i].setProvincia(validarString());
		}
		//INGRESO PREPAGAS
		System.out.println("Ingresar las 15 prepagas: ");
		for(int i=0 ; i<prepagas.length ; i++) {
			prepagas[i]=new Prepagas();
			System.out.printf("-PREPAGA %d-",i+1);
			System.out.println();
			prepagas[i].setIdPrepaga(i);
			System.out.print("Nombre de la prepaga: ");
			String prepagaNombre = validarString();
			while(true) {
				if(repeticionPrepagas(prepagas, prepagaNombre)) {
					prepagas[i].setNombre(prepagaNombre);
					break;
				}
				else {
					System.out.print("Los nombres no pueden repetirse. Ingrese nuevamente: ");
					prepagaNombre= validarString();
				}
			}
			String planes [] = new String[prepagas[i].getPlan().length];
			for(int j=0 ; j<planes.length; j++) {
				System.out.printf("Plan %d: ",j);
				String aNombre = validarString();
				while(true) {
					if(repeticionPlanes(planes, aNombre)) {
						planes[i]=aNombre;
						break;
					}
					else {
						System.out.print("Los planes no pueden repetirse. Ingrese nuevamente: ");
						aNombre= validarString();
					}
				}
			}
			prepagas[i].setPlan(planes);
			
			System.out.print("Tope de Reintegro: ");
			prepagas[i].setTopeReintegro(validarDouble());
		}
		//INGRESO TRATAMIENTOS
		System.out.println("Ingresar los 10 tratamientos: ");
		for(int i=0 ; i<tratamientos.length ; i++) {
			tratamientos[i] = new Tratamientos();
			System.out.printf("-TRATAMIENTO %d-", i+1);
			System.out.println();
			tratamientos[i].setIdTratamientos(i);
			System.out.print("Nombre: ");
			String aNombre= validarString();
			while(true) {
				if(repeticionTratamientos(tratamientos, aNombre)) {
					tratamientos[i].setNombre(aNombre);
					break;
				}
				else {
					System.out.print("Los tratamientos no pueden repetirse. Ingrese nuevamente: ");
					aNombre= validarString();
				}
			}
			System.out.print("Precio: ");
			tratamientos[i].setPrecio(validarDouble());
			while(true) {
				System.out.print("Es inyectable? (si/no): ");
				String a= validarString().toLowerCase();
				if(a.equals("si")) {
					tratamientos[i].setInyectable(true);
					break;
				}
				else if(a.equals("no")) {
					tratamientos[i].setInyectable(false);
					break;
				}
				else {
					System.out.println("si o no: ");
				}
			}
			System.out.print("Maximo de sesiones: ");
			tratamientos[i].setMaximoSesiones(validarInt());
			System.out.print("Tipo de tratamiento. 'f' para faciales, 'c' para corporales, 's' para salud: ");
			while (true) {
				char letraTratamiento = Character.toLowerCase(validarChar());
				if(letraTratamiento=='f' || letraTratamiento=='c' || letraTratamiento=='s') {
					tratamientos[i].setTipoTratamiento(letraTratamiento);
					break;
				}
				else {
					System.out.println("'f'/'c'/'s': ");
				}
			}
		}
		System.out.println();
		//INGRESO DE VALOR ADICIONAL DE TRATAMIENTO DE SALUD
		System.out.print("Ingrese el valor adicional de las sesiones de los  tratamientos de salud: ");
		Salud.setValorAdicional(validarDouble());
		arranque++;
		break; // SWITCH
		
case 2:  //PUNTO C - INGRESAR CLIENTES Y SUS TRATAMIENTOS MOSTRANDO POR PANTALLA EL PRECIO A ABONAR CON 3 DECIMALES
		
		//INGRESAR CLIENTES
		for(int i=0 ; i<clientes.length; i++) {
		
			System.out.printf("-Cliente %d de %d: ",i+1, clientes.length);
			System.out.println();
			System.out.print("DNI: ");
			int aDNI = validarInt();
			while(true) {
				if(repeticionDNI(clientes, aDNI)) {
					break;
				}
				else {
					System.out.print("Los DNI no pueden repetirse. Ingrese nuevamente: ");
					aDNI= validarInt();
				}
			}
			System.out.print("Nombre: ");
			String nombreCliente = validarString();
			
			System.out.print("Objetivo de la consulta: ");
			String objetivo = validarString();
			
			System.out.println("Fecha De Nacimiento");
			Calendar fechaNacimiento = pedirFechaNacimiento();
			
			Calendar fechaInicio = Calendar.getInstance();
			int cantidadSucursales =0;
			while(true) {
				System.out.print("Cantidad de sucursales en las que se va a atender: ");
				cantidadSucursales = validarInt();
				if(cantidadSucursales<=sucursales.length) {
					break;
				}
				else {
					System.out.println("La cantidad debe ser menor a "+ sucursales.length);
				}
				
			}
			Sucursales sucursalesAtendidas [] = new Sucursales[cantidadSucursales];
			for(int j=0; j<cantidadSucursales ; j++) {
				
				System.out.print("Nombre de la sucursal: ");
				String aNombre = validarString();
				int k=0;
				while (k==0) {
		
					for(Sucursales s : sucursales) {
						if(aNombre.equals(s.getNombre())) {
							if(sucursalesAtendidas[0]==null) {
								sucursalesAtendidas[j]= new Sucursales();
								sucursalesAtendidas[j]=s;
								k=1;
								break;
							}
							else {
								int l=0;
								for(Sucursales a : sucursalesAtendidas) {
									if(a.getNombre().equals(aNombre)) {
										System.out.print("ERROR. Esa sucursal ya esta ingresada. Ingrese nuevamente: ");
										aNombre = validarString();
										l=1;
										break;
									}
								}
								if(l==0) {
									sucursalesAtendidas[j]=new Sucursales();
									sucursalesAtendidas[j]=s;
									break;
								}
								
							}
						}
						else {
							System.out.print("ERROR. Ingrese una sucursal ingresada en el sistema: ");
							aNombre = validarString();
						}}}}
			
			///PREGUNTAR FORMA DE PAGO
			System.out.print("Forma de pago. Efecto  'e', Debito 'd', Credito 'c': ");
			char formaPago;
			while (true) {
				formaPago = Character.toLowerCase(validarChar());
				if(formaPago=='e' || formaPago=='d' || formaPago=='c') {
					break;
				}
				else {
					System.out.println("'e'/'d'/'c': ");
				}
			}
			//VER SI TIENE LAS PREPAGAS
			
			while(true) {
				System.out.print("El cliente cuenta con algunas de las prepagas?(si/no): ");
				String a= validarString().toLowerCase();
				if(a.equals("si")) {
					System.out.print("Con cual prepaga cuenta?: ");
					String aNombrePrepaga = validarString();
					int k=0;
					while(k==0) {
						for(Prepagas p : prepagas) {
							if(p.getNombre().equals(aNombrePrepaga)) {
								k=1;
								System.out.println("Numero de afiliado: ");
								String afiliado=validarString();
								clientes[i] = new ConPrepagas(nombreCliente, aDNI, objetivo, fechaNacimiento, fechaInicio, sucursalesAtendidas, formaPago, p, afiliado);
								System.out.println("EL COSTO TOTAL DEL CLIENTES ES DE: " + String.format("%.3f", clientes[i].calcularCosto()));
								break;

							}
						}
						if(k==0) {
						System.out.print("Con cual prepaga cuenta?: ");
						aNombrePrepaga = validarString();}
					}
				}
				else if(a.equals("no")) {
					double descuento=0;
					while (true) {
						System.out.print("Descuento de 0  a 80%: : ");
						descuento = validarDouble();
						if(descuento <= 80 || descuento > 0) {
							break;
						}
					}
					Particulares.setCantidadClientesParticulares(Particulares.getCantidadClientesParticulares()+1);
					clientes[i] = new Particulares(nombreCliente, aDNI, objetivo, fechaNacimiento, fechaInicio, sucursalesAtendidas, formaPago, descuento);
					System.out.println("EL COSTO TOTAL DEL CLIENTES ES DE: " + String.format("%.3f", clientes[i].calcularCosto()));
				}
				else {
					System.out.println("si o no: ");
				}
				break;
			}
			//TRATAMIENTOS
			int cantidadTratamientos=0;
			while(true) {
			System.out.printf("<<Cantidad de Tratamientos que el cliente va a tener (maximo %d): ", tratamientos.length);
			cantidadTratamientos = validarInt();
			if(cantidadTratamientos <= tratamientos.length) {break;}
			else { System.out.printf("ERROR. Maximo %d", tratamientos.length);}
			}
		
			for(int j=0; j<cantidadTratamientos ; j++) {
				
				System.out.print("Nombre del tratamiento: ");
				String aNombre = validarString();
				
					for(Tratamientos t : tratamientos) {
						int k=0;
						while(k==0) {
						if(aNombre.equals(t.getNombre())) {
							
							
							k=1;
							if(j==0 && clientes[i].getTratamientosP()[j]==null) {
								if(t.getTipoTratamiento()=='s') {
									clientes[i].createTratamientosP(t, true, j);
									while(true) {
										System.out.print("Necita una consulta medica extra? (si/no): ");
											String a= validarString().toLowerCase();
											if(a.equals("si")) {
												((Salud)clientes[i].getTratamientosP()[j]).setConsultaClinica(true);
												break;
											}
											else if(a.equals("no")) {
												((Salud)clientes[i].getTratamientosP()[j]).setConsultaClinica(false);
												break;
											}
											else {
												System.out.print("si o no: ");
											}
										}
									}
							
								else{
									clientes[i].createTratamientosP(t, false, j);
									break;}
							}
							//VER QUE NO SE REPITA 
							else {
								int l=0;
								for(int aA = 0 ; aA < clientes[i].getTratamientosP().length ; aA ++) {
									if(clientes[i].getTratamientosP()[aA] != null && clientes[i].getTratamientosP()[aA].getTratamientos() != null) {
										if(clientes[i].getTratamientosP()[aA].getTratamientos().getNombre().equals(aNombre)) {
											System.out.print("ERROR. Ese tratamiento ya esta ingresado. Ingrese nuevamente: ");
											aNombre = validarString();
											l=1;
											k=0;
											break;
										}
									}
								}
								if(l==0) {
									if(t.getTipoTratamiento()=='s') {
										clientes[i].createTratamientosP(t, true, j);

										while(true) {
											System.out.print("Necita una consulta medica extra? (si/no): ");
												String a= validarString().toLowerCase();
												if(a.equals("si")) {
													((Salud)clientes[i].getTratamientosP()[j]).setConsultaClinica(true);
													break;
												}
												else if(a.equals("no")) {
													((Salud)clientes[i].getTratamientosP()[j]).setConsultaClinica(false);
													break;
												}
												else {
													System.out.println("si o no: ");
												}
											}
										}
									else {
										clientes[i].createTratamientosP(t, false, j);

										break;
									}
								}
							}

								
							
						}
						else {
							System.out.print("ERROR. Ingrese el nombre de un tratamiento ingresado en el sistema: ");
							aNombre = validarString();
						}
						}
					
				}
				

				while(true) {
					System.out.printf("Cantidad de sesiones que va a requerir (no mayor a %d): ", clientes[i].getTratamientosP()[j].getTratamientos().getMaximoSesiones());
					int cantidadSesiones = validarInt();
					if(cantidadSesiones < clientes[i].getTratamientosP()[j].getTratamientos().getMaximoSesiones()) {clientes[i].setTratamientosPCantidadSesiones(cantidadSesiones, j);break;}
					else { System.out.println("ERROR");}
					}
			
			}
				
				}
		arranque++;
		break;
		
case 3:  //LOS TRATAMIENTOS ASIGNADOS A CADA CLIENTE PUEDEN SER MODIFICABLES JUNTO CON SUS CANTIDAD DE SESIONES
	System.out.print("Ingrese el nombre de un cliente para realizar sus modificaciones: ");
	String nombre = validarString();
	int a=0;
	int pos=0;
	while (a==0) {
		for(int i=0 ; i<clientes.length ; i++) {
			if(clientes[i].getNombre().equals(nombre)) {
				pos=i;
				a=1;
				break;
			}
		}
		if(a==0) {
			System.out.print("Ingrese un nombre valido: ");
			nombre = validarString();
		}
	}
	System.out.print("Ahora elija el nombre del tratamiento personal de ese cliente para modificar: ");
	String tratamientoP = validarString();
	int posT=0;
	int b=0;
	while (b==0) {
		for(int i=0 ; i<clientes[pos].getTratamientosP().length ; i++) {
			if(clientes[pos].getTratamientosP()[i].getTratamientos().getNombre().equals(tratamientoP)) {
				posT=i;
				b=1;
				break;
			}
		}
		if(b==0) {
			System.out.print("Ingrese un nombre valido: ");
			nombre=validarString();
		}
	}
	System.out.print("Quieres reemplazar este tratamiento por otro?: ");
	String respuesta = validarString().toLowerCase();
	boolean respuestaB = false;
	while(true) {
		if(respuesta.equals("si")) {
			respuestaB=true;
			break;
		}
		else if(respuesta.equals("no")) {
			break;
		}
		else {
			System.out.print("si/no: ");
			respuesta = validarString().toLowerCase();			
		}
	}
	if(respuestaB) {
		System.out.print("Por cual tratamiento lo queres reemplazar? Ingrese el nombre del nuevo tratamiento asignado: ");
		String nombreTratamiento = validarString();
		boolean m = false;
		for(int i = 0 ; i<tratamientos.length ; i++) {
			if(!clientes[pos].getTratamientosP()[posT].getTratamientos().getNombre().equals(nombreTratamiento)) {
			if(tratamientos[i].getNombre().equals(nombreTratamiento)) {
				clientes[pos].setTratamientosP(tratamientos[i], posT); 
				m = true;
			}
			}
		}
		if(!m) {
			System.out.println("Ingrese un tratamiento existente y distinto al que queres cambiar: ");
			nombreTratamiento = validarString();
			
		}
	}
	System.out.println("Ingrese la nueva cantidad de sesiones que va a tener: ");
	int cantS= validarInt();
	while(true) {
		if(cantS<=clientes[pos].getTratamientosP()[posT].getTratamientos().getMaximoSesiones()) {
			break;
		}
		else {
			System.out.println("La cantidad debe ser menor o igual a: "+clientes[pos].getTratamientosP()[posT].getTratamientos().getMaximoSesiones());
			cantS= validarInt();
		}
	}
	clientes[pos].setTratamientosPCantidadSesiones(cantS, posT);
	//NUEVOS COSTOS
	if(clientes[pos] instanceof ConPrepagas) {
		System.out.println("El nuevo costo es: "+((ConPrepagas)clientes[pos]).
				calcularCosto());
	}
	else if(clientes[pos] instanceof Particulares) {
		System.out.println("El nuevo costo es: "+((Particulares)clientes[pos]).calcularCosto());
	}
	else {System.out.println("error");}
	
	break;
case 4: // MOSTRAR POR PANTALLA CLIENTES CON PREPAGA.DNI, NOMBRE, NACIMIENTO, FORMA DE PAGO, NOMBRE PREPAGA Y COSTO TOTAL, TOPE REINTEGRO, Y VALOR ABONADO
	////////////////////////////////////////////////////////////////////////////////////
	for(Clientes c : clientes) {
		if(c instanceof ConPrepagas) {
			((ConPrepagas) c).supereTopeReintegro();
		}
	}
	break;
case 5: 
	////////////////////////////////////////////////////////////////////////////////////
	String tratamientosCorporales[]= new String[tratamientos.length];
	for (int i = 0; i < tratamientos.length; i++) {
		if(tratamientos[i].getTipoTratamiento()=='c' && tratamientos[i].getInyectable()) {
			tratamientosCorporales[i]=tratamientos[i].getNombre();
		}
	}
	Calendar fechaHoymenos3 = Calendar.getInstance();
	fechaHoymenos3.add(Calendar.MONTH, -3);

	for(Clientes c : clientes) {
		 for(TratamientosPersonales t : c.getTratamientosP()) {
		        for (int i = 0; i < tratamientosCorporales.length; i++) {
		            if (tratamientosCorporales[i] != null) {
		            	 if(t.getTratamientos().getNombre().equals(tratamientosCorporales[i]) && c.getFechaInicio().after(fechaHoymenos3)) {
		                tratamientosCorporales[i] = null;
		            }
		            }
		        }
		 }
	}
	for(String tra : tratamientosCorporales) {
		if(tra!=null) {
			System.out.println("Nombre del tratamiento Corporal que no ha sido utilizado en los ultimos 3 meses: "+tra);
		}
	}
	break;
case 6:
	////////////////////////////////////////////////////////////////////////////////////

	int cantBuenosAires=0;
	for(Clientes c : clientes) {
		int cantSucursales=c.getSucursales().length;
		for(Sucursales s : c.getSucursales()) {
			cantSucursales -= (s.getProvincia().equals("Buenos Aires")) ? 1 : 0;
		}
		cantBuenosAires += (cantSucursales==0) ? 1 : 0;
	}
	System.out.println("La cantida de clientes que solo se atienen en Buenos Aires es de: "+cantBuenosAires);
	break;
case 7: 
	////////////////////////////////////////////////////////////////////////////////////////
	System.out.println("La cantidad de clientes particualares que se atienden en el centro es de: "+Particulares.getCantidadClientesParticulares());
	break;
	
case 8: //MOSTRAR NOMBRE DE LOS CLIENTES QUE HAYAN INGRESADO HACE 30 DIAS Y ABONEN CON DEBITO. MAS EL TRATAMIENTO CUYO VALOR SUPERE AL PARAMETRO DE LA APLICACION
	/////////////////////////////////////////////////////////////////////////////////////////
	double argumento = Double.parseDouble(args[0]);
	Calendar fechaHace1Mes = Calendar.getInstance();
	fechaHace1Mes.add(Calendar.MONTH, -1);
	for(Clientes c : clientes) {
		if (c.getFechaInicio().after(fechaHace1Mes) && c.getFormaPago()=='d'){
			System.out.println("Nombre del Cliente: "+c.getNombre());
			if(c instanceof ConPrepagas) {
				System.out.println("Prepaga: "+((ConPrepagas)c).getPrepaga().getNombre());
				System.out.println("Numero Afiliado: "+((ConPrepagas)c).getNumeroAfiliado());
			}
			else if(c instanceof Particulares) {
				System.out.println("Descuento: "+((Particulares)c).getDescuento()+"%");
			}
			for(TratamientosPersonales t : c.getTratamientosP()) {
				if(t.getTratamientos().getPrecio()<argumento) {
					System.out.println("Nombre del tratamiento: "+t.getTratamientos().getNombre());
					System.out.println("Cantidad de sesiones: "+t.getCantidadSesiones());
					if( t instanceof Salud) {
						if(((Salud)t).getConsultaClinica()) {
							System.out.println("Se necesita consulta extra. Con un valor de: "+Salud.getValorAdicional());
						}
					}
				}
			}
			
		}
	}
	break;
	
case 9: // POR CADA SUCURSAL MOSTRAR CANTIDAD DE CLIENTES CON PREPAGA Y LA CANTIDAD DE CLIENTES SIN ELLA QUE SE ATIENEN AHI.  INCLUIR EL PORCENTAJE CORRESPONDIENTE EN CADA CASO
	/////////////////////////////////////////////////////////////////////////////////////////
	int cantidadPrepagas=0;
	int cantidadParticulares=Particulares.getCantidadClientesParticulares();

	for(Clientes c : clientes) {
		cantidadPrepagas += (c instanceof ConPrepagas) ? 1 : 0;
	}
	for(Sucursales s : sucursales) {
		

		int cantSucursalesPrepagas=0;
		int cantSucursalesParticulares=0;
		for(Clientes c : clientes) {
			
			for(Sucursales sC : c.getSucursales()) {
				if(sC.getNombre().equals(s.getNombre())) {
					
					cantSucursalesPrepagas += (c instanceof ConPrepagas) ? 1 : 0;
					cantSucursalesParticulares += (c instanceof Particulares) ? 1 : 0;

				}
			}
		}
		double promedioPrepagas = (double)cantSucursalesPrepagas /(double)cantidadPrepagas;
		double promedioParticulares = (double)cantSucursalesParticulares /(double)cantidadParticulares;
		System.out.println("El promedio de Clientes con Prepagas en la sucursal "+s.getNombre()+ "es de: "+promedioPrepagas);
		System.out.println("El promedio de Clientes con Particulares en  la sucursal "+s.getNombre()+ "es de: "+promedioParticulares);

		
	}
	break;

	
case 10: //GENERAR N AL AZAR DE 2 DIGITOS, INDICAR CANTIDAD DE CLIENTES QUE SUPERAN ESE NUMERO Y QUE TENGAN ALGUN TRATAMIENTO DE SALUD QUE REQUIERA CONSULTA EXTRA
	/////////////////////////////////////////////////////////////////////////////////////////
	Random random = new Random();
	int numeroAzar = random.nextInt(90) + 10;
	int cantSupera=0;
	Calendar fechaHoy= Calendar.getInstance();
	for(Clientes c : clientes) {
		int edad = fechaHoy.get(Calendar.YEAR)-c.getFechaNacimiento().get(Calendar.YEAR);
        if (fechaHoy.get(Calendar.MONTH) < c.getFechaNacimiento().get(Calendar.MONTH) || (fechaHoy.get(Calendar.MONTH) == c.getFechaNacimiento().get(Calendar.MONTH) && fechaHoy.get(Calendar.DATE) < c.getFechaNacimiento().get(Calendar.DATE))) {
                edad=edad-1;
            }
        if(edad>numeroAzar) {
        	for(TratamientosPersonales t : c.getTratamientosP()) {
        		if(t instanceof Salud) {
        			if(((Salud)t).getConsultaClinica()) {
        			cantSupera++;
        			break;
        			}
        		}
        	}
        }
	}
	System.out.println("La cantidad de clientes es de: "+cantSupera);
	break;
			}//while
				
				}//switch
			
		}//main



	
	
	
	public static String validarString() {
		Scanner scanner = new Scanner(System.in);
		String string;
		while (true) {
			string=scanner.nextLine();
			if(string.equals("")) {
				System.out.print("Error, el texto no debe estar vacio. Ingrese nuevamente: ");
			}
			else {break;}
		}
		return string;
	}
	public static double validarDouble() {
		Scanner scanner = new Scanner(System.in);
		double num;
		while(true) {
			if(scanner.hasNextDouble()) {
				num=scanner.nextDouble();
				if(num<=0) {
					System.out.println("Error numero no valido. Ingrese nuevamente: ");
					scanner.nextLine();
				}
				else {break;}
				
			}
			else {	
			 System.out.println("Error numuero no valido. Ingrese nuevamente: ");
			 scanner.nextLine();
			}

		}
		return num;
	}
	public static int validarInt() {
		Scanner scanner = new Scanner(System.in);
		int num;
		while(true) {
			if(scanner.hasNextInt()) {
				num=scanner.nextInt();
				if(num<=0) {
					System.out.println("Error numero no valido. Ingrese nuevamente: ");
					scanner.nextLine();
				}
				else {break;}
				
			}
			else {	
			 System.out.println("Error numuero no valido. Ingrese nuevamente: ");
			 scanner.nextLine();
}
		}
		return num;
	}
	public static char validarChar() {
		Scanner scanner = new Scanner(System.in);
		char c;
		while(true) {
			String string=scanner.nextLine();
			if(string.length()==1) {
				c=string.charAt(0);
				break;
			}
			else {
				System.out.println("Error, ingrese una letra: ");
			}
		}
		return c;
	}
	public static  boolean repeticionSucursales(Sucursales [] sucursales, String nombre) {
		for(int i=0; i< sucursales.length ; i++) {
			if(sucursales[i]!=null && sucursales[i].getNombre()!=null) {
				if(sucursales[i].getNombre().equals(nombre)) {
				return false;
				}
		}
		}
		return true;
	}
	public static boolean repeticionPrepagas(Prepagas [] prepagas, String p) {
		for(int i=0; i< prepagas.length ; i++) {
			if(prepagas[i]!=null && prepagas[i].getNombre()!=null) {
			if(prepagas[i].getNombre().equals(p)) {
				return false;
			}
			}
		}
		return true;
	}
	public static boolean repeticionPlanes(String [] planes, String aNombre) {
		for(int i=0; i< planes.length ; i++) {
			if(planes[i]!=null) {
			if(planes[i].equals(aNombre)) {
				return false;
			}
			}
		}
		return true;
	}
	public static boolean repeticionTratamientos(Tratamientos [] tratamientos, String aNombre) {
		for(int i=0; i< tratamientos.length ; i++) {
			if(tratamientos[i]!=null && tratamientos[i].getNombre()!=null) {
			if(tratamientos[i].getNombre().equals(aNombre)) {
				return false;
			}
		}
		}
		return true;
	}
	public static boolean repeticionDNI(Clientes []clientes, int aDNI) {
		for(int i=0; i< clientes.length ; i++) {
			if(clientes[i]!=null && clientes[i].getNumeroDocumento()!=0) {
			if(clientes[i].getNumeroDocumento()==aDNI) {
				return false;
			}
		}
		}
		return true;
	}
	public static Calendar pedirFechaNacimiento() {
		Scanner scanner = new Scanner(System.in);
		Calendar fecha = Calendar.getInstance();
		System.out.print("Dia: ");
		int dia=validarInt();
		while (true) {
			if(dia>31 || dia<1) {
				System.out.print("Ingrese dia correcto. Dia: ");
				dia=validarInt();
			}
			else if(dia<=31 || dia>0) {
				break;
			}
		}
		System.out.print("Mes: ");
		int mes=validarInt();
		while (true) {
			if(mes>12 || mes<1) {
				System.out.print("Ingrese mes correcto. Mes: ");
				mes=validarInt();
			}
			else if(mes<=12 || mes>0) {
				break;
			}
		}
		System.out.print("Año: ");
		int año=validarInt();;
		while (true) {
			if(año>2024) {
				System.out.print("Ingrese año correcto. Año: ");
				año=validarInt();
			}
			else if(año<=2024) {
				break;
			}
		}
		fecha.set(año, mes-1, dia);
		return fecha;
		
	}
	
		
	}


