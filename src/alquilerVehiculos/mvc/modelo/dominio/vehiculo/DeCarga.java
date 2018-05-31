
package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

public class DeCarga extends Vehiculo {  //  hereda de Vehiculo

	// atributo

	double precioEspecificoDeCarga =getDatosTecnicosVehiculo().getPma();

	// constructor:

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicos
	 */
	public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
		super(matricula, marca, modelo, datosTecnicos);

	}
// constructor Copia 
	
	public DeCarga(Vehiculo vehiculo) {
		super(vehiculo);
	}

	// metodos 
	public TipoVehiculo getTipoVehiculo() {

		return TipoVehiculo.DECARGA;
	}

	public double getPrecioEspecifico() {

		// calcular precio especifico de vehiculo  De carga: 

		return precioEspecificoDeCarga / getFACTOR_PMA()+( getFACTOR_NUMERO_PLAZAS()/ getDatosTecnicosVehiculo().getNumeroPlazas());
	}

	
}
