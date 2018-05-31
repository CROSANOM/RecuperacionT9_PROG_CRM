/**
 * 
 */
package alquilerVehiculos.mvc.vista.iugraficatablas.controladores.vista;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author crosanom
 *
 */
public class ControladorClientes {

	// atributos

	private Cliente cliente;

	// atributos de fxml

	@FXML
	private TextField tfNombre, tfDNI, tfLocalidad, tfCodigoPostal;

	@FXML
	private TextArea taCalle;

	// metodos

	@FXML
	private void Initializable() {
		System.out.println("hola mundo");
	}

	/**
	 * @deprecated Use {@link #setCliente(Cliente)} instead
	 */
	public void perroCliente(Cliente cliente) {
		setCliente(cliente);
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
		System.out.println(cliente);
		muestraFichaCliente();
	}

	private void muestraFichaCliente() {

		if (cliente != null) {

			tfNombre.setText(cliente.getNombre());
			tfDNI.setText(cliente.getDni());
			tfLocalidad.setText(cliente.getDireccionPostal().getLocalidad());
			taCalle.setText(cliente.getDireccionPostal().getCalle());
			tfCodigoPostal.setText(cliente.getDireccionPostal().getCodigoPostal());

		}

	}

}
