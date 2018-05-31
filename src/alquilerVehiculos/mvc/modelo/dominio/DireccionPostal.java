package alquilerVehiculos.mvc.modelo.dominio;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase gestiona la direccion postal de clientes, actua como atributo de
 * la clase Cliente.
 * 
 * @author crosanom
 *
 */
public class DireccionPostal implements Serializable {

	/**
	 * atributos
	 */
	private static final long serialVersionUID = 1L;
	private String calle;
	private String localidad;
	private String codigoPostal;

	// Crear un constructor DireccionPostal

	/**
	 * @param calle
	 * @param localidad
	 * @param codigoPostal
	 */
	public DireccionPostal(String calle, String localidad, String codigoPostal) {

		setCalle(calle);
		setCodigoPostal(codigoPostal);
		setLocalidad(localidad);

	}

	// constructor copia

	/**
	 * @param direccionPostal
	 */
	public DireccionPostal(DireccionPostal direccionPostal) {

		calle = direccionPostal.getCalle();
		localidad = direccionPostal.getLocalidad();
		codigoPostal = direccionPostal.getCodigoPostal();
	}

	// metodo setCodigoPostal(compruebaCodigoPostal)

	/**
	 * @param codigoPostal
	 */
	private void setCodigoPostal(String codigoPostal) {
		if (compruebaCodigoPostal(codigoPostal))
			this.codigoPostal = codigoPostal;
		else
			throw new ExcepcionAlquilerVehiculos("Codigo Postal no válido");
	}

	/**
	 * @param codigoPostal
	 * @return
	 */
	private boolean compruebaCodigoPostal(String codigoPostal) {

		boolean codigoPostalValidado = false;
		Pattern cpPatron = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}\n" + "\n" + "$");
		Matcher emparejador = cpPatron.matcher((codigoPostal));
		codigoPostalValidado = emparejador.matches(); // se guarda el resultado del método emparejador.matches en una

		return codigoPostalValidado;

	}

	
	// metodos  validar calle no puede estar vacia
	
	/**
	 * @param calle
	 *            
	 */

	private void setCalle(String calle) {
		if (calle != null && !calle.equals(""))
			this.calle = calle;
		else
			throw new ExcepcionAlquilerVehiculos("La calle no es valida");
	}

	
	// metodo que valida localidad, no puede estar vacia 
	/**
	 * @param localidad
	 */
	private void setLocalidad(String localidad) {
		if (localidad != null && !localidad.equals(""))
			this.localidad = localidad;
		else
			throw new ExcepcionAlquilerVehiculos("Localidad no valida");
	}

	/**
	 * @return the calle
	 */
	public String getCalle() {

		return calle;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
@Override
public String toString() {
	
	// MEJORA EL MODO DE REPRESENTAR LA DIRECCION DEL CLIENTE
	
	return String.format("Direccion: %s localidad: %s, Código Postal : %s", calle, localidad, codigoPostal) ;
	

}

}
