/**
 * 
 */
package alquilerVehiculos.mvc.vista.iugraficatablas.controladores.vista;

import java.text.SimpleDateFormat;

import alquilerVehiculos.mvc.modelo.dao.Clientes;
import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.Alquiler;
import alquilerVehiculos.mvc.modelo.dominio.vehiculo.TipoVehiculo;
import alquilerVehiculos.mvc.vista.iugraficatablas.IUGTablas;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;




/**
 * @author crosanom
 *
 */
public class ControladorTablaAlquilerCliente {

	@FXML
	private TableView<Alquiler> tvAlquilerCliente;

	@FXML
	private TextField tfNombre, tfDni;

	@FXML

	private TableColumn<Alquiler, String> tcMatricula, tcModelo, tcMarca,tcFecha;
	@FXML
	private TableColumn<Alquiler, Integer> tcDias;

	@FXML
	private TableColumn<Alquiler, TipoVehiculo> tcTipo;

	
	
	
	private Clientes cliente;
    private Alquiler alquiler;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      
//    public void setCliente (Clientes cliente){
//        this.cliente = cliente;
//        mostrarDatosClientes();
//        mostrarDatosAlquiler(cliente);
//    }

    @FXML
    private void initialize() {
        tcMarca.setCellValueFactory(alquiler -> new ReadOnlyStringWrapper(alquiler.getValue().getVehiculo().getMarca()));
        tcMarca.setResizable(false);
        tcModelo.setCellValueFactory(alquiler -> new ReadOnlyStringWrapper(alquiler.getValue().getVehiculo().getModelo()));
        tcModelo.setResizable(false);
        tcMatricula.setCellValueFactory(alquiler -> new ReadOnlyStringWrapper(alquiler.getValue().getVehiculo().getMatricula()));
        tcMatricula.setResizable(false);
        tcTipo.setCellValueFactory(alquiler -> new ReadOnlyObjectWrapper<>(alquiler.getValue().getVehiculo().getTipoVehiculo()));
        tcTipo.setResizable(false);
        tcFecha.setCellValueFactory(alquiler -> new ReadOnlyStringWrapper(FORMATO_FECHA.format(alquiler.getValue().getFecha())));
        tcFecha.setResizable(false);
        tcDias.setCellValueFactory(new PropertyValueFactory<Alquiler, Integer>("dias"));
        tcDias.setResizable(false);

    }

    private void mostrarDatosAlquiler(Clientes cliente) {
     
//    	  tvAlquilerCliente.setItems(FXCollections.observableArrayList(IUGTablas.controladorMVC.obtenerAlquileresCliente(cliente.getDni())));
//       
//        
//    }
//    
//    private void mostrarDatosCliente(){
//            if (cliente != null) {
//           tfNombre.setText(cliente.getDni());
//            tfDni.setText(cliente.setDni());
//           
//        }
//        
    }

    

	
	
	
	
}	
	
	
	
	
	






