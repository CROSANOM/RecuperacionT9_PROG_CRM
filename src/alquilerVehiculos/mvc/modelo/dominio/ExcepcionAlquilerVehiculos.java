
package alquilerVehiculos.mvc.modelo.dominio;

/**
 * @author crosanom
 *
 */

public class ExcepcionAlquilerVehiculos extends RuntimeException {

	// crean los atributos
	private static final long serialVersionUID = 1;
	
	// constructor de excepción que llama a la clase padre con super
	public ExcepcionAlquilerVehiculos(String message) {
		super(message);
	}

}
