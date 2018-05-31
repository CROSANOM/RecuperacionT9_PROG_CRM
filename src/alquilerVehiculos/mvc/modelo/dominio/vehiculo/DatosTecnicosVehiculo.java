package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

public class DatosTecnicosVehiculo implements Serializable {

	// atributos

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cilindrada;
	private int numeroPlazas;
	private int pma;

	// Constructor 3 parametros acceso a atrib con set

	/**
	 * @param cilindrada
	 * @param numerosPlazas
	 * @param pma
	 */
	public DatosTecnicosVehiculo(int cilindrada, int numerosPlazas, int pma) {

		setCilindrada(cilindrada);
		setNumerosPlazas(numerosPlazas);
		setPma(pma);
	}

	// Constructor Copia

	/**
	 * @param datosTecnicos
	 */
	public DatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {

		cilindrada = datosTecnicos.getCilindrada();
		numeroPlazas = datosTecnicos.getNumeroPlazas();
		pma = datosTecnicos.getCilindrada();
	}

	// setter

	/**
	 * @param cilindrada
	 *            valida cilindrada > 0
	 */
	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else

			throw new ExcepcionAlquilerVehiculos("La cilindrada tienes que ser mayor que cero.");
	}

	/**
	 * @param numeroPlazas
	 *            valida numeroPlazas > que cero
	 */
	private void setNumerosPlazas(int numeroPlazas) {
		if (numeroPlazas > 0)
			this.numeroPlazas = numeroPlazas;
		else
			throw new ExcepcionAlquilerVehiculos("El numero de plazas tiene que ser superior a cero");
	}

	/**
	 * @param pma
	 *            valida PMA >0
	 */
	private void setPma(int pma) {
		if (pma > 0)
			this.pma = pma;
		else
			throw new ExcepcionAlquilerVehiculos("pma tiene que ser mayor a cero");
	}

	// getters

	/**
	 * @return cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @return numerosPlazas
	 */
	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	/**
	 * @return pma
	 */
	public int getPma() {
		return pma;
	}

	
	//  MODIFICA REPRESENTACION DE DATOS T�CNICOS 
	@Override

	public String toString() {

		return String.format("DATOS T�CNICOS : \nCilindrada:  %d Num Plazas: %d  PMA : %d", cilindrada, numeroPlazas,
				pma);

	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#toString()
	// */
	// @Override
	// public String toString() {
	// return "DatosTecnicosVehiculo [cilindrada=" + cilindrada + ", numerosPlazas="
	// + numeroPlazas + ", pma=" + pma
	// + "]";
	// }

}
