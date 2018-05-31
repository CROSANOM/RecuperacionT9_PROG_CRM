package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import javax.sound.midi.Soundbank;

public class Autobus extends Vehiculo {

	// atributo
	double precioEspecificoAutobus = getDatosTecnicosVehiculo().getCilindrada();

	/*
	 * constructor: public Vehiculo(String matricula, String marca, String modelo,
	 * DatosTecnicosVehiculo datosTecnicos)
	 */

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicos
	 */

	public Autobus(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);

	}

	// constructor Copia

	public Autobus(Vehiculo vehiculo) {
		super(vehiculo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getTipoVehiculo()
	 */
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.AUTOBUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * alquilerVehiculos.mvc.modelo.dominio.vehiculo.Vehiculo#getPrecioEspecifico()
	 */

	public double getPrecioEspecifico() {

		// calcular precio especifico autobus

		precioEspecificoAutobus = (getPrecioEspecifico() * FACTOR_CILINDRADA / 50) + 1 * FACTOR_NUMERO_PLAZAS;

		return precioEspecificoAutobus;
		
	
		
		
		
		
		
	}


}	