/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerVehiculos.mvc.vista.iugraficatablas.controladores.vista;

import alquilerVehiculos.mvc.modelo.dominio.Cliente;
import alquilerVehiculos.mvc.modelo.dominio.DireccionPostal;
import alquilerVehiculos.mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import alquilerVehiculos.mvc.vista.iugraficatablas.IUGTablas;
import alquilerVehiculos.mvc.vista.iugraficatablas.utilidades.Dialogos;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 *
 * @author Felipon
 */
public class ControladorPrincipal {
	
	private ObservableList<Cliente> clientes;
    
    @FXML
    private Button btCerrar,btDetalleCliente;
    @FXML
    private TableView<Cliente> tvClientes; 
    @FXML 
    private TableColumn<Cliente, String > tcNombre, tcNIF; 
    
    @FXML
    private TextField tfNombre,  tfNIF, tfDireccion, tfCodigoPostal, tfLocalidad;
    @FXML
    private RadioButton rbAnadirCliente;
    @FXML
    private HBox hbDatosCliente;
    
    @FXML
 private void initialize() throws IOException{
     
     crearTablaClientes();
     //crearFichaCliente();
     
      }
 
 
 
 
      private void crearTablaClientes() throws IOException {

        tcNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        tcNombre.setResizable(false);
        tcNIF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("dni"));
        tcNIF.setResizable(false);
        clientes = FXCollections.observableArrayList(IUGTablas.controladorMVC.obtenerClientes());
        tvClientes.setItems(clientes);
//        tvCliente.getSelectionModel().selectedItemProperty().addListener(
//               (ov, oldValue, newValue) -> accionesClientes(ov.getValue()));
    }
     
     
     

    
    
    @FXML
    private void cerrarAplicacion(){
        System.exit(0);
    }
    
    @FXML
    private void anadirCliente(){
       try{ 
        DireccionPostal direccionPostal = new DireccionPostal(tfDireccion.getText(), tfLocalidad.getText(), tfCodigoPostal.getText());
        Cliente cliente = new Cliente(tfNombre.getText(), tfNIF.getText(), direccionPostal);
        IUGTablas.controladorMVC.anadirCliente(cliente);
        Dialogos.mostrarDialogoAdvertencia("Aviso", "Operacion realizada");
        clientes.add(cliente);
        limpiarCamposCliente();
       }catch (ExcepcionAlquilerVehiculos e) {
                Dialogos.mostrarDialogoError("Error", e.getMessage());
           
       }
 
}
@FXML
private void rbAnadirClienteActivado(){
    hbDatosCliente.setDisable(false);
    rbAnadirCliente.setDisable(true);
    
}
        
        
    
    
    private void limpiarCamposCliente(){
        tfNombre.setText("");
        tfNIF.setText("");
        tfDireccion.setText("");
        tfCodigoPostal.setText("");
        tfLocalidad.setText("");
        hbDatosCliente.setDisable(true);
        rbAnadirCliente.setDisable(false);
        rbAnadirCliente.setSelected(false);
        rbAnadirCliente.requestFocus();
    }
    
    
    
    @FXML
    private void mostrarDetalleCliente() {
    	
    	
    }
}
