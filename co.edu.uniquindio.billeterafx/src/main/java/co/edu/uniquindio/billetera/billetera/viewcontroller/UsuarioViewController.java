package co.edu.uniquindio.billetera.billetera.viewcontroller;

import co.edu.uniquindio.billetera.billetera.controler.UsuarioController;
import co.edu.uniquindio.billetera.billetera.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.billetera.billetera.utils.BilleteraConstantes.*;

public class UsuarioViewController {

    UsuarioController usuarioController;
    ObservableList<UsuarioDto> listaUsuarios = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<UsuarioDto> tableUsuario;

    @FXML
    private TableColumn<UsuarioDto,String> tcApellido;

    @FXML
    private TableColumn<UsuarioDto,String> tcDireccion;

    @FXML
    private TableColumn<UsuarioDto,String> tcEmail;

    @FXML
    private TableColumn<UsuarioDto,String> tcIdUsuario;

    @FXML
    private TableColumn<UsuarioDto,String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuario.getItems().clear();
        tableUsuario.setItems(listaUsuarios);
        listenerSelection();
    }

    private void obtenerUsuarios() {listaUsuarios.addAll(usuarioController.obtenerUsuarios());}

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcIdUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idUsuario()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().email()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));

    }

    private void listenerSelection() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }


    private void agregarUsuario() {
        UsuarioDto usuarioDto= crearUsuarioDto();
        if (datosValidos(usuarioDto)){
            if (usuarioController.agregarUsuario(usuarioDto)){
                listaUsuarios.addAll(usuarioDto);
                limpiarCampos();
                mostrarMensaje(TITULO_USUARIO_CREADO,HEADER,USUARIO_CREADO, Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje(TITULO_USUARIO_NO_AGREGADO,HEADER,BODY_USUARIO_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje(TITULO_IMCOMPLETO,HEADER,CONTENIDO_IMCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtIdUsuario.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
    }

    private UsuarioDto crearUsuarioDto() {
        return new  UsuarioDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtIdUsuario.getText(),
                txtEmail.getText(),
                txtDireccion.getText());
    }

    private boolean datosValidos(UsuarioDto usuarioDto){
        if (usuarioDto.nombre().isEmpty() ||
                usuarioDto.apellido().isEmpty() ||
                usuarioDto.idUsuario().isEmpty() ||
                usuarioDto.email().isEmpty() ||
                usuarioDto.direccion().isEmpty()){
            return false;
        }else {
            return true;
        }
    }


    private void actualizarDatos() {
        UsuarioDto usuarioDtoActualizado=crearUsuarioDto();
        int index = listaUsuarios.indexOf(usuarioSeleccionado);
        if (index >= 0) {
            listaUsuarios.set(index, usuarioDtoActualizado);
            mostrarMensaje(TITULO_USUARIO_ACTUALIZADO,HEADER,USUARIO_ACTUALIZADO, Alert.AlertType.INFORMATION);
            tableUsuario.refresh(); // para que se vea en la tabla
        }
    }


    private void eliminarUsuario() {
        UsuarioDto usuarioSeleccionado = tableUsuario.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            listaUsuarios.remove(usuarioSeleccionado);
            mostrarMensaje(TITULO_USUARIO_ELIMINADO,HEADER,USUARIO_ELIMINADO, Alert.AlertType.INFORMATION);
            tableUsuario.getSelectionModel().clearSelection();
        }
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombre.setText(usuarioSeleccionado.nombre());
            txtApellido.setText(usuarioSeleccionado.apellido());
            txtIdUsuario.setText(usuarioSeleccionado.idUsuario());
            txtEmail.setText(usuarioSeleccionado.email());
            txtDireccion.setText(usuarioSeleccionado.direccion());
        }
    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert= new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    @FXML
    void onCrearUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void OnNuevoUsuario(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void onActualizarUsuario(ActionEvent event) {
        actualizarDatos();
    }

    @FXML
    void onEliminarUsuario(ActionEvent event) {
        eliminarUsuario();
    }



}

