package edu.siglo21.app.Controller;


import edu.siglo21.app.App;
import edu.siglo21.app.Model.Articulo;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;



public class principalController implements Initializable {
    private double x = 0;
    private double y = 0;

    private ArrayList<Articulo> tablaArticulos = new ArrayList<>();

    private ObservableList<Articulo> datosArticulos = FXCollections.observableArrayList();

    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    public void agregarArticulo(Articulo articulo){
        this.tablaArticulos.add(articulo);
    }

    public int contarArticulos(){
        if (this.tablaArticulos.isEmpty()){
            return 0;
        } else {
            return this.tablaArticulos.size();
        }
    }

    @FXML
    private PieChart pieChartCategorias;

    @FXML
    private TextField alertaTextField;

    @FXML
    private TextField codigoBuscarTextField;

    @FXML
    private TextField nombreBuscarTextField;

    @FXML
    private TextField descripcionBuscarTextField;
    @FXML
    private TextField cantidadTextField;


    @FXML
    private ChoiceBox<?> categoriaChoiceBox;


    @FXML
    private TextField codigoTextField;

    @FXML
    private Button crearArticuloMenu;

    @FXML
    private TextField descripcionTextField;

    @FXML
    private Button eliminarArticuloMenu;

    @FXML
    private DatePicker ingresoDate;

    @FXML
    private ChoiceBox<?> marcaChoiceBox;

    @FXML
    private Button minimizar;

    @FXML
    private Button modificarArticuloMenu;

    @FXML
    private TextField nombreTextField;

    @FXML
    private ChoiceBox<?> proveedorChoiceBox;

    @FXML
    private Button reporteArticuloMenu;

    @FXML
    private Button buscarArticuloMenu;
    @FXML
    private VBox reportesVbox;

    @FXML
    private VBox crearArticuloVbox;

    @FXML
    private VBox buscarArticuloVbox;

    @FXML
    private BarChart<?, ?> barChartProveedores;

    @FXML
    private CategoryAxis ejeX;

    @FXML
    private NumberAxis ejeY;

    @FXML
    private Button salir;

    @FXML
    private Button grabarCrearArticulo;

    @FXML
    private ChoiceBox<?> unidadChoiceBox;

    @FXML
    private DatePicker vencimientoDate;
    @FXML
    private AnchorPane principalVista;

    @FXML
    private Label cantidadArticulos;

    @FXML
    private Label diarioLabel;

    @FXML
    private Label promedioLabel;

    @FXML
    private TableView<Articulo> articuloTableView = new TableView<>();

    @FXML
    private TableColumn<Articulo, Number> idArticuloColumna= new TableColumn<>("ID");

    @FXML
    private TableColumn<Articulo, String> codigoArticuloColumna = new TableColumn<>("Codigo");

    @FXML
    private TableColumn<Articulo, String> nombreArticuloColumna = new TableColumn<>("Nombre");

    @FXML
    private TableColumn<Articulo, String> descripcionArticuloColumna = new TableColumn<>("Descripción");

    @FXML
    private TableColumn<Articulo, String> categoriaArticuloColumna = new TableColumn<>("Categoria");

    @FXML
    private TableColumn<Articulo, String> marcaArticuloColumna = new TableColumn<>("Marca");

    @FXML
    private TableColumn<Articulo, String> unidadMedidaArticuloColumna = new TableColumn<>("Unidad de medida");

    @FXML
    private  TableColumn<Articulo, Date> fechaIngresoArticuloColumna = new TableColumn<>("Fecha de ingreso");

    @FXML
    private TableColumn<Articulo, Date> fechaVencimientoArticuloColumna = new TableColumn<>("Fecha de vencimiento");

    @FXML
    private TableColumn<Articulo, Number> cantidadArticuloColumna = new TableColumn<>("Cantidad ");

    @FXML
    private TableColumn<Articulo, Number> alertaArticuloColumna = new TableColumn<>("Stock Minimo");

    @FXML
    private TableColumn<Articulo, String> proveedorArticuloColumna = new TableColumn<>("Proveedor");




    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }



    @FXML
    void logout(ActionEvent event) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación de salir");
        alerta.setHeaderText(null);
        alerta.setContentText("Estas seguro de salir?");
        Optional<ButtonType> opcion = alerta.showAndWait();

        if (opcion.get().equals(ButtonType.OK)){
            salir.getScene().getWindow().hide();

            Parent root = FXMLLoader.load(App.class.getResource("loginVista.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event2 )-> {
                x = event2.getSceneX();
                y = event2.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event2)->{
                stage.setX(event2.getScreenX() - x);
                stage.setY(event2.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene((scene));
            stage.show();
        }

    }


    @FXML
    void validarCrearArticulo(ActionEvent event) {

    }

    public ObservableList<Articulo> getDatosArticulos() {
        return datosArticulos;
    }
    @FXML
    void buscarArticuloButton(ActionEvent event){
        //primero verifico cual de los tres campos estan completos
        Articulo a = new Articulo();

        datosArticulos.clear();
        datosArticulos.addAll(a.getArticulo(codigoBuscarTextField.getText(),nombreBuscarTextField.getText(),descripcionBuscarTextField.getText()));

        articuloTableView.getItems().addAll(datosArticulos);

    }


    @FXML
    void grabarCrearArticulo(ActionEvent event) {

        //Manejo de nulos y validaciones
        if (ingresoDate.getValue() == null){
            ingresoDate.setValue(LocalDate.now());
        }
        if (vencimientoDate.getValue()==null){
            vencimientoDate.setValue(LocalDate.of(9999,12,31));
        }

        if(alertaTextField.getText().isBlank() ){
            alertaTextField.setText("0");
        }

        Articulo articulo = new Articulo(
                codigoTextField.getText(),
                nombreTextField.getText(),
                descripcionTextField.getText(),
                categoriaChoiceBox.getSelectionModel().getSelectedItem().toString(),
                marcaChoiceBox.getSelectionModel().getSelectedItem().toString(),
                unidadChoiceBox.getSelectionModel().getSelectedItem().toString(),
                Date.from(ingresoDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(vencimientoDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Integer.parseInt(cantidadTextField.getText()),
                Integer.parseInt(alertaTextField.getText()),
                proveedorChoiceBox.getSelectionModel().getSelectedItem().toString()
        );


        articulo.insertArticulo(articulo);

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación Crear Articulo");
        alerta.setHeaderText(null);
        //actualizarIndicadores();

        alerta.setContentText("Articulo creado con exito\n Con el numero " + articulo.getIdArticulo() +" \n Desea crear otro articulo ?");
        Optional<ButtonType> opcion = alerta.showAndWait();


        if (opcion.get().equals(ButtonType.OK)) {
            this.codigoTextField.clear();
            this.nombreTextField.clear();
            this.descripcionTextField.clear();
            this.categoriaChoiceBox.setValue(null);
            this.marcaChoiceBox.setValue(null);
            this.unidadChoiceBox.setValue(null);
            this.ingresoDate.setValue(null);
            this.vencimientoDate.setValue(null);
            this.cantidadTextField.clear();
            this.alertaTextField.clear();
            this.proveedorChoiceBox.setValue(null);
        } else {
            this.cancelarCrearArticulo(new ActionEvent());
        }

    }

    private void actualizarIndicadores() {
        //Actualizo el primer recuadro
        int cantidadMateriales=0;

        for (Articulo a : tablaArticulos ) {
            cantidadMateriales += a.getCantidad();
        }
        cantidadArticulos.setText(String.valueOf(cantidadMateriales));

        Calendar c = Calendar.getInstance();
        Date hoy = new Date();
        c.setTime(hoy);


        //Actualizo el segundo recuadro de diferenets articulos, voy a utilizar un sorted set que es la estructura que corresponde.
        Set<String> acumulador2 = new HashSet<String>();
        for (Articulo a :
             tablaArticulos) {
            acumulador2.add(a.getNombre());
        }
        diarioLabel.setText(String.valueOf(acumulador2.size()));


        //Actualizo el acumulador promedio de los últimos 30 días
        int acumulador3=0;
        int promedio = 0;


        c.add(Calendar.DATE, -30);


        for (Articulo a:
             tablaArticulos) {
            if (a.getFechaEntrada().compareTo(c.getTime())>0){
                promedio++;
                acumulador3+=a.getCantidad();
            }
        }
        promedioLabel.setText(String.valueOf(acumulador3/promedio));


        pieChartData.clear();
        // Pie chart data, voy a ir ingresando uno a uno las nuevas categorias.
        for (Articulo a:
             tablaArticulos) {
            pieChartData.add(new PieChart.Data(a.getCategoria(),(double)a.getCantidad()));
        }
        pieChartCategorias.setClockwise(true);
        pieChartCategorias.setData(pieChartData);
        pieChartCategorias.setLabelsVisible(true);




        ejeX.setLabel("Proveedor");
        ejeY.setLabel("Cantidad");

        barChartProveedores = new BarChart(ejeX,ejeY);

        XYChart.Series datos = new XYChart.Series();
        datos.setName("Proveedores");
        for (Articulo a:
             tablaArticulos) {
            datos.getData().add(new XYChart.Data(a.getCategoria(),a.getCantidad()));
        }

        barChartProveedores.getData().add(datos);

    }

    @FXML
    void minimizar(ActionEvent event){
        Stage stage = (Stage)principalVista.getScene().getWindow();
        stage.setIconified(true);

    }

    public void cambiarVista(ActionEvent event){
        if (event.getSource() == crearArticuloMenu){
            crearArticuloVbox.setVisible(true);
            buscarArticuloVbox.setVisible(false);
            reportesVbox.setVisible(false);
        }else if(event.getSource() == modificarArticuloMenu){
            crearArticuloVbox.setVisible(false);
            buscarArticuloVbox.setVisible(false);
            reportesVbox.setVisible(false);
        }else if(event.getSource() == eliminarArticuloMenu){
            crearArticuloVbox.setVisible(false);
            buscarArticuloVbox.setVisible(false);
            reportesVbox.setVisible(false);
        }else if(event.getSource() == buscarArticuloMenu){
            buscarArticuloVbox.setVisible(true);
            crearArticuloVbox.setVisible(false);
            reportesVbox.setVisible(false);
        }else if(event.getSource() == reporteArticuloMenu){
            crearArticuloVbox.setVisible(false);
            buscarArticuloVbox.setVisible(false);
            reportesVbox.setVisible(true);
        }

    }
    @FXML
    void cancelarCrearArticulo(ActionEvent event) {
        crearArticuloVbox.setVisible(false);
    }
    @FXML
    void cancelarBuscarArticulo(ActionEvent event) {
        buscarArticuloVbox.setVisible(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChoiceBox unidadDeMedidaChoiceBox = new ChoiceBox();
        ChoiceBox provChoiceBox = new ChoiceBox();
        ChoiceBox catChoiceBox = new ChoiceBox();
        ChoiceBox marChoiceBox = new ChoiceBox();

        unidadDeMedidaChoiceBox.getItems().addAll("Centímetro (cm)",
                "Metro (m)",
                "Pulgadas (in)",
                "Pies (ft)",
                "Gramos (g)",
                "Kilogramo (kg)",
                "Onzas (oz)",
                "Libras (lb)",
                "Mililitros (ml)",
                "Litro (l)",
                "Centímetros cúbicos",
                "Metros cúbicos",
                "Unidad (u)",
                "Docena (doc)",
                "Miles");
        unidadChoiceBox.setItems(unidadDeMedidaChoiceBox.getItems());

        provChoiceBox.getItems().addAll(
                "YPF Directo",
                "Grupo Darc",
                "Grupo Sur",
                "New Repuestos",
                "Casiro",
                "Grupo Tres Arroyos",
                "Grupo Scania",
                "Grupo Mega",
                "Grupo Lander",
                "Grupo Automotores");
        proveedorChoiceBox.setItems(provChoiceBox.getItems());

        catChoiceBox.getItems().addAll(
                "Filtros (filtro de aceite, filtro de aire, filtro de combustible, etc.).",
                "Sistema de frenos (pastillas de freno, discos de freno, cilindros de freno, etc.).",
                "Partes del motor (pistones, válvulas, correas, bombas de agua, etc.).",
                "Sistema de transmisión (embragues, cajas de cambios, ejes de transmisión, etc.).",
                "Partes eléctricas (baterías, alternadores, bujías, cables de encendido, etc.).",
                "Sistema de suspensión y dirección (amortiguadores, barras estabilizadoras, rótulas, etc.).",
                "Iluminación (faros delanteros, luces traseras, bombillas, etc.).",
                "Partes de la carrocería (parachoques, capó, puertas, espejos, etc.).",
                "Sistemas de refrigeración (radiadores, termostatos, bombas de agua, etc.).",
                "Accesorios y equipamiento interior (alfombrillas, volantes, sistemas de audio, etc.)."
        );

        categoriaChoiceBox.setItems(catChoiceBox.getItems());

        marChoiceBox.getItems().addAll(
                "AC Delco",
                "Motorcraft",
                "Monroe",
                "NGK",
                "Gates",
                "Mann-Filter",
                "SKF",
                "Akebono",
                "TRW",
                "Hella"
        );
        marcaChoiceBox.setItems(marChoiceBox.getItems());

        idArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getIdArticulo()));
        codigoArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCodigo()));
        nombreArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNombre()));
        descripcionArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDescripcion()));
        categoriaArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCategoria()));
        marcaArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getMarca()));
        unidadMedidaArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUnidadMedida()));
        fechaIngresoArticuloColumna.setCellValueFactory(cellData -> (ObservableValue<Date>) cellData.getValue().getFechaEntrada());
        fechaVencimientoArticuloColumna.setCellValueFactory(cellData -> (ObservableValue<Date>) cellData.getValue().getFechaVencimiento());
        cantidadArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getCantidad()));
        alertaArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getAlerta()));
        proveedorArticuloColumna.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getProveedor()));

        idArticuloColumna.setText("");
        codigoArticuloColumna.setText("");
        nombreArticuloColumna.setText("");
        descripcionArticuloColumna.setText("");
        categoriaArticuloColumna.setText("");
        marcaArticuloColumna.setText("");
        unidadMedidaArticuloColumna.setText("");
        fechaIngresoArticuloColumna.setText("");
        fechaVencimientoArticuloColumna.setText("");
        cantidadArticuloColumna.setText("");
        alertaArticuloColumna.setText("");
        proveedorArticuloColumna.setText("");

        if (articuloTableView != null) {
            articuloTableView.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> mostrarArticulo(newValue));
        }

        articuloTableView.getColumns().add(idArticuloColumna);
        articuloTableView.getColumns().add(codigoArticuloColumna);
        articuloTableView.getColumns().add(nombreArticuloColumna);
        articuloTableView.getColumns().add(descripcionArticuloColumna);
        articuloTableView.getColumns().add(categoriaArticuloColumna);
        articuloTableView.getColumns().add(marcaArticuloColumna);
        articuloTableView.getColumns().add(unidadMedidaArticuloColumna);
        articuloTableView.getColumns().add(fechaIngresoArticuloColumna);
        articuloTableView.getColumns().add(fechaVencimientoArticuloColumna);
        articuloTableView.getColumns().add(cantidadArticuloColumna);
        articuloTableView.getColumns().add(alertaArticuloColumna);
        articuloTableView.getColumns().add(proveedorArticuloColumna);

    }

    private void mostrarArticulo(Articulo art) {
        if (art != null){
            idArticuloColumna.setText(art.getIdArticulo().toString());
            codigoArticuloColumna.setText(art.getCodigo());
            nombreArticuloColumna.setText(art.getNombre());
            descripcionArticuloColumna.setText(art.getDescripcion());
            categoriaArticuloColumna.setText(art.getCategoria());
            marcaArticuloColumna.setText(art.getMarca());
            unidadMedidaArticuloColumna.setText(art.getUnidadMedida());
            fechaIngresoArticuloColumna.setText(art.getFechaEntrada().toString());
            fechaVencimientoArticuloColumna.setText(art.getFechaVencimiento().toString());
            cantidadArticuloColumna.setText(art.getCantidad().toString());
            alertaArticuloColumna.setText(art.getAlerta().toString());
            proveedorArticuloColumna.setText(art.getProveedor());
        } else {
            idArticuloColumna.setText("");
            codigoArticuloColumna.setText("");
            nombreArticuloColumna.setText("");
            descripcionArticuloColumna.setText("");
            categoriaArticuloColumna.setText("");
            marcaArticuloColumna.setText("");
            unidadMedidaArticuloColumna.setText("");
            fechaIngresoArticuloColumna.setText("");
            fechaVencimientoArticuloColumna.setText("");
            cantidadArticuloColumna.setText("");
            alertaArticuloColumna.setText("");
            proveedorArticuloColumna.setText("");
        }

    }


}
