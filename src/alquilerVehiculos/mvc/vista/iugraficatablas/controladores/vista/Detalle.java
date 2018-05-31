/**
 * 
 */
package alquilerVehiculos.mvc.vista.iugraficatablas.controladores.vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author crosanom
 *
 */
public class Detalle {
	
	@ FXML
	private Button btCerrar;
	
	@FXML
	
	private void cerrarDetalle() {
		
		Stage escenario = (Stage) btCerrar.getScene().getWindow();
		escenario.close();
		
		
	}
	
	
	
	
	
	
	
	

}
