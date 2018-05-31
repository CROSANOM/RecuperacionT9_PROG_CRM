package alquilerVehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;// instanciar la clase Fecha y acceder a sus metodos

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 * Clase Gestiona Clientes y Vehiculos necesario alquiler
 * 
 * @author crosanom
 *
 */
// implentar serializable _

public class Alquiler implements Serializable {
	// atributos de la clase Alquiler.

	private Cliente cliente;
	private Vehiculo vehiculo;

	private boolean alquilerAbierto;
	private Date fecha;
	private int dias;

	private final int MS_DIA = 1000 * 60 * 60 * 24; // Calculo de los milisegundos por dia.
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy"); // incialiazación del objeto
	private final double PRECIO_DIA = 30.0; // se incializa segun informacion dada

	// Constructores con set VehiculoDisponible.
	/**
	 * @param cliente
	 * @param vehiculo
	 */

	public Alquiler(Cliente cliente, Vehiculo vehiculo) {

		setCliente(cliente);
		setVehiculo(vehiculo);
		fecha = new Date();
		dias = 0;
		vehiculo.setDisponible(false);

	}

	private void setCliente(Cliente cliente) {

		if (cliente != null) {

			this.cliente = cliente;
		} else {
			throw new ExcepcionAlquilerVehiculos("Necesitas un cliente para poder abrir alquiler");
		}

	}

	private void setVehiculo(Vehiculo vehiculo) {

		if (vehiculo != null) {

			this.vehiculo = vehiculo;
		} else {

			throw new ExcepcionAlquilerVehiculos("Necesitas un Vehiculo para poder abrir alquiler");
		}

	}

	// constructor copia
	/**
	 * @param alquiler
	 */
	public Alquiler(Alquiler alquiler) {

		vehiculo = alquiler.getVehiculo();
		cliente = alquiler.getCliente();
		dias = alquiler.getDias();
		fecha = alquiler.getFecha();

	}

	// getters

	/**
	 * @return cliente
	 */
	public Cliente getCliente() {
		return new Cliente(cliente);
	}

	/**
	 * @return vehiculo
	 */

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return int numero dias
	 */
	public int getDias() {
		return dias;
	}

	// Calculo de dias.
	/**
	 * @param fechaFin
	 * @param fechaInicio
	 * @return int dias
	 */
	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime(); // ojo getTime devuelve los milisegundos
		long dias = milisegundos / MS_DIA;
		return (int) dias + 1; // ( int) casting pasamos long a int
	}

	/**
	 * @return precioDia segun TipoVehiculo ( ligadura dinamica )
	 */
	public double getPrecio() { // obtener el precioDia segun regla de negocio
		return PRECIO_DIA * dias + vehiculo.getPrecioEspecifico();
	}

	/**
	 * metodos alquiler cerrar-GetPrecio-obtenerEstadoAlquiler cerrar alquiler
	 * (difDias) y poner vehiculo pasa a estar disponible
	 */
	public void cerrar() {
		Date fechaActual = new Date();
		dias = difDias(fechaActual, fecha);
		alquilerAbierto = false;
		vehiculo.setDisponible(true);
	}

	/**
	 * obtenerEstadoAlquiler ( devuelve el estado )
	 * 
	 * @return estado del Alquiler
	 */
	public String obtenerEstadoAlquiler() {
		String estado = alquilerAbierto ? "Abierto" : "Cerrado";
		return estado;
	}

	

	@Override
	public String toString() {

		return String.format("*ALQUILER:\nFecha: %s Dias: %d Precio: %.2f \nCLIENTE: %s \n%s", FORMATO_FECHA.format( getFecha()), dias,
				getPrecio(), getCliente(), getVehiculo());

	}

	public boolean equals (Object otro) {
		if (otro == null || !(otro instanceof Alquiler)) {
			return false;
		}
		if(otro == this) {
			return true;
		}
		return vehiculo.getMatricula().equals(((Alquiler) otro).getVehiculo().getMatricula());
	}
	
	
	
	
	public int HashCode() {
		return vehiculo.getMatricula().hashCode();
	}



	public boolean isFinalizado() {
		return false;
	}

}
