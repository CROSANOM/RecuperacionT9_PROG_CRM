package alquilerVehiculos.mvc.modelo.dominio.vehiculo;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author crosanom version3
 *
 */

// crear la clase abstract de vehiculo

public abstract class Vehiculo implements Serializable {

	/**
	 * anadir los atributos de Vehiculo
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String matricula, marca, modelo;
	private boolean disponible = true; // un coche disponible

	private DatosTecnicosVehiculo datosTecnicosVehiculos;

	protected final double FACTOR_CILINDRADA = 0;
	protected final double FACTOR_NUMERO_PLAZAS = 0;
	protected final double FACTOR_PMA = 0;

	// Constructor con parametros()

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param datosTecnicos
	 */
	public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {

		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setDatosTecnicosVehiculo(datosTecnicos);

	}

	// constructor copia

	/**
	 * @param vehiculo
	 */
	public Vehiculo(Vehiculo vehiculo) {

		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		datosTecnicosVehiculos = vehiculo.getDatosTecnicosVehiculo();

	}

	// Metodos Abstractos

	public abstract double getPrecioEspecifico();

	public abstract TipoVehiculo getTipoVehiculo();

	// Metodos de datosTecnicos

	/**
	 * @return factor_Cilindrada
	 */
	public double getFACTOR_CILINDRADA() {
		return FACTOR_CILINDRADA;
	}

	/**
	 * @return fACTOR_NUMERO_PLAZAS
	 */
	public double getFACTOR_NUMERO_PLAZAS() {
		return getFACTOR_NUMERO_PLAZAS();
	}

	/**
	 * @return fACTOR_PMA
	 */
	public double getFACTOR_PMA() {
		return FACTOR_PMA;
	}

	/**
	 * @return the datosTecnicos
	 */
	public DatosTecnicosVehiculo getDatosTecnicosVehiculo() {
		return datosTecnicosVehiculos;
	}

	/**
	 * @param datosTecnicos
	 */
	private void setDatosTecnicosVehiculo(DatosTecnicosVehiculo datosTecnicos) {
		this.datosTecnicosVehiculos = new DatosTecnicosVehiculo(datosTecnicos);

	}
	// set (disponibilidad,matricula,modelo,

	/**
	 * @param disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	// SetMatricula (comprobarMatricula)

	/**
	 * @param matricula
	 */

	private void setMatricula(String matricula) {

		// Comprobar Matricula
		boolean matriculaCorrecta = false;
		matriculaCorrecta = compruebaMatricula(matricula);

		if (matriculaCorrecta) {
			this.matricula = matricula; // inicializar matricula
		} else
			throw new ExcepcionAlquilerVehiculos("La matricula No es correcta"); // lanzar excepci�n
	}

	/**
	 * @param marca
	 * 
	 */
	private void setMarca(String marca) {

		if (marca != null && !marca.equals(""))
			this.marca = marca;
		else
			throw new ExcepcionAlquilerVehiculos("La marca no es valida");
	}

	/**
	 * @param modelo
	 * 
	 */
	private void setModelo(String modelo) {

		if (modelo != null && !modelo.equals(""))
			this.modelo = modelo;
		else
			throw new ExcepcionAlquilerVehiculos("El modelo no es valido");
	}

	// Metodo para comprobar matricula usando expresi�n regular
	/**
	 * @param matricula
	 * @return
	 */
	private boolean compruebaMatricula(String matricula) {
		boolean matriculaValida = false;

		Pattern matriculaPatron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = matriculaPatron.matcher((matricula));

		matriculaValida = emparejador.matches();

		if (matriculaValida) {
			System.out.println("La matricula  es correcta");
		} else {
			System.out.println("La matricula es incorrecta ");
		}

		return matriculaValida;

	}

	// metodos getters
	/**
	 * @return matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	@Override
	public int hashCode() {
		return matricula.hashCode();
	}
		
	/**
	 * @return marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @return modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @return disponibilidad
	 */
	public boolean getDisponible() {
		return disponible;
	}
	
	
	// FORMATEA LA SALIDA DE UN VEHICULO
	@ Override
	public String toString() {
		
		return String.format("* VEHICULO: Matricula:  %s Marca: %s Modelo %s: Disponible %s :", matricula,marca,modelo,disponible);
		
		
		
	}
	

}
