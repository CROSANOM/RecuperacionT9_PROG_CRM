
package alquilerVehiculos.mvc.modelo.dominio;// paquete 

/**
 *Clases que se importan    
 */
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Clase que gestiona los clientes
 */
/**
 * @author crosanom
 *
 */
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// atributos
	private String nombre;
	private String dni;
	private int identificador;
	private static int ultimoIdentificador = 0;
	private DireccionPostal direccionPostal;

	// constructores
	/*
	 * constructor con 3 parametros inicializa los atributos a traves de llamada
	 * metodos set
	 */

	/**
	 * @param nombre
	 * @param dni
	 * @param direccionPostal
	 */
	public Cliente(String nombre, String dni, DireccionPostal direccionPostal) {
		setNombre(nombre);
		setDni(dni);
		setDireccionPostal(direccionPostal);
		setIdentificador(); // asigna un id a cada cliente
	}

	// constructor copia

	/**
	 * @param cliente
	 */
	public Cliente(Cliente cliente) {
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		direccionPostal = cliente.getDireccionPostal();
		identificador = cliente.getIdentificador();
	}

	// getters

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @return the direccionPostal
	 */
	public DireccionPostal getDireccionPostal() {
		return direccionPostal;
	}

	// setter

	/**
	 * @param nombre
	 *            the nombre to set valida que no este vacio
	 */
	private void setNombre(String nombre) {
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		else
			throw new ExcepcionAlquilerVehiculos("El nombre no es válido");
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	private void setDni(String dni) {
		if (compruebaDni(dni))
			this.dni = dni;
		else
			throw new ExcepcionAlquilerVehiculos("El dni no es valido");
	}

	// compruebaDni
	/**
	 * @param dni
	 * @return boolean
	 */
	private boolean compruebaDni(String dni) {

		boolean dniValidado = false; // declara variable que contendra valor emparejador.matches
		Pattern dniPatron = Pattern.compile("[0-9A-Z][0-9]{7}[A-Z]");/* expresionRegular */
		Matcher emparejador = dniPatron.matcher(dni);
		dniValidado = emparejador.matches(); // se guarda el resultado del metodo emparejador.matches en una variable
		return dniValidado;

	}

	/**
	 * @param direccionPostal
	 *            the direccionPostal to set
	 */
	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	private void setIdentificador() {
		ultimoIdentificador++;
		identificador = ultimoIdentificador;
	}

	
	private void asignarNuevoIdentificador() {
		ultimoIdentificador++;
		identificador = ultimoIdentificador;
	}
	

	
	public static void aumentarUltimoIdentificador(int cantidad) {
		if(cantidad >= 0)
			ultimoIdentificador += cantidad;
		else
			throw new ExcepcionAlquilerVehiculos("Solo se puede aumentar el ultimo identificador");
		
	}
	
	@Override
	public boolean equals(Object otro) {
		if(otro == null || !(otro instanceof Cliente)) {
			return false;
		}
		
		if(otro == this) {
			return true;
		}
		
		return (dni.equals(((Cliente)otro).getDni()));
	}
	
	@Override
	public int hashCode() {
		return dni.hashCode();
	}
	
	
	
	// FORMATEO LA SALIDA DE REPRESENTACION DE UN CLIENTE 
	@Override
	public String toString() {
		
		return String.format("Identificador : %d Nombre: %s DNI: %s %s %n",identificador, nombre, dni,  direccionPostal);
		
		
	}



}
