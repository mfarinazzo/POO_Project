package com.mycompany.mavenproject2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.Alert;

public class PrimaryController {

    private Monitor globalMonitor;

    private int currentInteration = 23;

    private AI ai = new AI();

    @FXML
    private VBox geral;

    @FXML
    private VBox vbox_motor;

    @FXML
    private VBox temp;

    @FXML
    private VBox bateria;

    @FXML
    private VBox pressao;

    @FXML
    private VBox niveis;

    @FXML
    private VBox freios;

    @FXML
    private StackPane chartContainer;

    @FXML
    private StackPane chartContainerTemp;

    @FXML
    private StackPane chartContainerBat;

    @FXML
    private StackPane chartContainerPres;

    @FXML
    private StackPane chartContainerNiv;

    @FXML
    private StackPane chartContainerFreios;

    public StackPane getChartContainer() {
        return chartContainer;
    }

    @FXML
    public void initialize() throws IOException {
        assert geral != null : "fx:id=\"geral\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert vbox_motor != null : "fx:id=\"vbox_motor\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert temp != null : "fx:id=\"temp\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert bateria != null : "fx:id=\"bateria\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert pressao != null : "fx:id=\"pressao\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert niveis != null : "fx:id=\"niveis\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";
        assert freios != null : "fx:id=\"freios\" não foi injetado: verifique seu arquivo FXML 'Primary.fxml'.";

        setAllSections(0.0, true);
        geral.setOpacity(1.0);
        geral.setMouseTransparent(false);

        globalMonitor = new Monitor();

        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainer.getChildren().add(highchartsComponent.getView());

        
        ArrayList<Float> xData = globalMonitor.getEngineTemp();
        List<String> values = Arrays.asList(xData.get(12).toString(), xData.get(11).toString(), xData.get(10).toString(), xData.get(9).toString(), xData.get(8).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Grafico Motor",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Temperatura do motor em graus Celsius"
        );
    }

    private void setAllSections(double opacity, boolean bool) {
        vbox_motor.setOpacity(opacity);
        temp.setOpacity(opacity);
        bateria.setOpacity(opacity);
        pressao.setOpacity(opacity);
        niveis.setOpacity(opacity);
        freios.setOpacity(opacity);
        geral.setOpacity(opacity);
        vbox_motor.setMouseTransparent(bool);
        temp.setMouseTransparent(bool);
        bateria.setMouseTransparent(bool);
        pressao.setMouseTransparent(bool);
        niveis.setMouseTransparent(bool);
        freios.setMouseTransparent(bool);
        geral.setMouseTransparent(bool);
    }

    @FXML
    private void actionVoltar() throws IOException {

        setAllSections(0.0, true);
        geral.setOpacity(1.0);
        geral.setMouseTransparent(false);
        updateChart();
        
    }

    private void updateChart() throws IOException{
        // Atualizar o gráfico
        Monitor.updateBatteryVoltage(currentInteration, 1);
        Monitor.updateBrakes(currentInteration, 1);
        Monitor.updateEngineTemp(currentInteration, 1);
        Monitor.updateLevelWater(currentInteration, 1);
        Monitor.updateRpm(currentInteration, 1);
        Monitor.updateTirePressure(currentInteration, 1);

        //graça para ficar mais dinâmico os gráficos;
        if(currentInteration > 12){
            currentInteration--;
        }else if(currentInteration == 12){
            currentInteration = 23;
        }else{
            currentInteration++;
        }
        
    }

    @FXML
    private void actionMotor() throws IOException {
        setAllSections(0.0, true);
        vbox_motor.setOpacity(1.0);
        vbox_motor.setMouseTransparent(false);
        
        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainer.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getRpm();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(12)/1500));
        DataValidation.add(this.ai.testarValor(xData.get(11)/1500));
        DataValidation.add(this.ai.testarValor(xData.get(10)/1500));
        DataValidation.add(this.ai.testarValor(xData.get(9))/1500);
        DataValidation.add(this.ai.testarValor(xData.get(8))/1500);
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(12).toString(), xData.get(11).toString(), xData.get(10).toString(), xData.get(9).toString(), xData.get(8).toString());
        
        
        
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Grafico Motor",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Números de rotação por minuto do motor."
        );
    }

    @FXML
    private void changeTemp() throws IOException {
        setAllSections(0.0, true);
        temp.setOpacity(1.0);
        temp.setMouseTransparent(false);
                
        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainerTemp.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getEngineTemp();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(12)/90));
        DataValidation.add(this.ai.testarValor(xData.get(11)/90));
        DataValidation.add(this.ai.testarValor(xData.get(10)/90));
        DataValidation.add(this.ai.testarValor(xData.get(9))/90);
        DataValidation.add(this.ai.testarValor(xData.get(13))/90);
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(12).toString(), xData.get(11).toString(), xData.get(10).toString(), xData.get(9).toString(), xData.get(13).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Grafico Temperatura Motor",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Temperatura do motor em graus Celsius"
        );
    }

    @FXML
    private void changeBat() throws IOException {
        setAllSections(0.0, true);
        bateria.setOpacity(1.0);
        bateria.setMouseTransparent(false);

        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainerBat.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getBatteryVoltage();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(12)/12));
        DataValidation.add(this.ai.testarValor(xData.get(11)/12));
        DataValidation.add(this.ai.testarValor(xData.get(10)/12));
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(11).toString(), xData.get(10).toString(), xData.get(11).toString(), xData.get(11).toString(), xData.get(12).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Voltagem da bateria do carro",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Valor da voltagem da bateria"
        );
    }

    @FXML
    private void changeNiv() throws IOException {
        setAllSections(0.0, true);
        niveis.setOpacity(1.0);
        niveis.setMouseTransparent(false);
                
        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainerNiv.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getLevelWater();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(11)/50));
        DataValidation.add(this.ai.testarValor(xData.get(10)/50));
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(10).toString(), xData.get(11).toString(), xData.get(11).toString(), xData.get(11).toString(), xData.get(10).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Nível de água do radiador",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Porcentágem de água no radiador"
        );
    }

    @FXML
    private void changePres() throws IOException {
        setAllSections(0.0, true);
        pressao.setOpacity(1.0);
        pressao.setMouseTransparent(false);
                
        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainerPres.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getTirePressure();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(12)/30));
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(12).toString(), xData.get(12).toString(), xData.get(12).toString(), xData.get(12).toString(), xData.get(12).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Grafico Pressão Pneus",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Pressão em Lbs"
        );
    }

    @FXML
    private void changeFreio() throws IOException {
        setAllSections(0.0, true);
        freios.setOpacity(1.0);
        freios.setMouseTransparent(false);
                
        HighchartsComponent highchartsComponent = new HighchartsComponent();
        chartContainerFreios.getChildren().add(highchartsComponent.getView());
        ArrayList<Float> xData = globalMonitor.getBrakes();
        ArrayList<Float> DataValidation = new ArrayList<>();
        DataValidation.add(this.ai.testarValor(xData.get(12)/50));
        DataValidation.add(this.ai.testarValor(xData.get(11)/50));
        DataValidation.add(this.ai.testarValor(xData.get(10)/50));
        DataValidation.add(this.ai.testarValor(xData.get(8))/50);
        System.out.println(DataValidation);
        List<String> values = Arrays.asList(xData.get(12).toString(), xData.get(11).toString(), xData.get(10).toString(), xData.get(8).toString(), xData.get(10).toString());
        // Configurar o gráfico com os parâmetros desejados
        highchartsComponent.setupHighcharts(
            "Grafico Freios",
            Arrays.asList("-4h", "-3h", "-2h", "-1h", "agora"),
            values,
            "Funcionamento dos freios em %"
        );
    }

    @FXML
    private void gerarPdf(){
        HtmlToPdf.GeneratePDF(globalMonitor);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("PDF Gerado");
        alert.setHeaderText(null);
        alert.setContentText("O PDF foi gerado com sucesso!");
        alert.showAndWait();
    }
}
