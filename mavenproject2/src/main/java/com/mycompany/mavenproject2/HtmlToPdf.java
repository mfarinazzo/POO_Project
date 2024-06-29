package com.mycompany.mavenproject2;

import com.itextpdf.html2pdf.HtmlConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HtmlToPdf {

// Nome do arquivo PDF a ser criado
    private static String dest = "Relatório.pdf";

    // CSS para estilizar o HTML
    private static String css = "@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');"
            + "body { font-family: 'Roboto', sans-serif; }"
            + "h1 { color: navy; text-align: center; }"
            + "p { font-size: 14px; }"
            + "table { width: 100%; border-collapse: collapse; margin-top: 20px; }"
            + "th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: left; }"
            + "th { background-color: #f2f2f2; }";

    // Conteúdo HTML com placeholders
    private static String htmlTemplate = "<html>"
            + "<head>"
            + "<title>Relatório do ICar</title>"
            + "<style>" + css + "</style>"
            + "</head>"
            + "<body>"
            + "<h1>Relatório do ICar</h1>"
            + "<table>"
            + "<tr><th>Parâmetro</th><th>Valor</th></tr>"
            + "<tr><td>RPM do Motor</td><td>{{rpm}}</td></tr>"
            + "<tr><td>Nível de Pressão do Óleo</td><td>{{oilPressure}}</td></tr>"
            + "<tr><td>Nível de Pressão dos Pneus</td><td>{{tirePressure}}</td></tr>"
            + "<tr><td>Temperatura do Óleo</td><td>{{oilTemp}}</td></tr>"
            + "<tr><td>Temperatura do Motor</td><td>{{engineTemp}}</td></tr>"
            + "<tr><td>Temperatura da água</td><td>{{waterTemp}}</td></tr>"
            + "<tr><td>Voltagem da bateria</td><td>{{batteryVoltage}}</td></tr>"
            + "<tr><td>Durabilidade dos sistemas de freios</td><td>{{brakes}}</td></tr>"
            + "<tr><td>Nível da água</td><td>{{levelWater}}</td></tr>"
            + "<tr><td>Nível do Óleo</td><td>{{levelOil}}</td></tr>"
            + "</table>"
            + "</body>"
            + "</html>";

    public HtmlToPdf() throws IOException {
    }
    
    private static String getUltimo(ArrayList<Float> array){
        /* 
         * Método para retornar o último valor de um ArrayList
         * Parâmetros:
         * - array: ArrayList de Float
         * Retorno: String
         */
        return array.get(array.size() - 1).toString();
    }

    public static void GeneratePDF(Monitor monitor) {
        /* 
         * Método para gerar um arquivo PDF a partir de um HTML
         * 
         * Parâmetros:
         * - monitor: objeto da classe Monitor com os dados a serem exibidos no PDF
         * Retorno: void
         * comentário: o objeto Monitor foi injetado como uma dependência aqui tanto para que a classe não
         * dependa de uma outra, quanto porque como monitor é estático, isto garante que não será alterado com relação ao monitor dos gráficos.
         */

        // Valores das variáveis, adicionar conforme surgirem variáveis
        Map<String, String> variables = new HashMap<>();
        variables.put("rpm", getUltimo(monitor.getRpm()) +" RPM");
        variables.put("oilPressure",getUltimo(monitor.getOilPressure()) + " PSI");
        variables.put("tirePressure", getUltimo(monitor.getTirePressure()) + " PSI");
        variables.put("oilTemp", getUltimo(monitor.getOilTemp()) + " °C");
        variables.put("engineTemp", getUltimo(monitor.getEngineTemp()) + " °C");
        variables.put("waterTemp", getUltimo(monitor.getWaterTemp()) + " °C");
        variables.put("batteryVoltage", getUltimo(monitor.getBatteryVoltage()) + " V");
        variables.put("brakes", getUltimo(monitor.getBrakes()) + " %");
        variables.put("levelWater",getUltimo(monitor.getLevelWater()) + " %");
        variables.put("levelOil", getUltimo(monitor.getLevelOil()) + " %");

        // Substitui os placeholders do html pelos valores reais
        String htmlContent = htmlTemplate;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            htmlContent = htmlContent.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        try {
            // Cria um novo arquivo PDF
            FileOutputStream pdfFile = new FileOutputStream(new File(dest));

            // Converte o HTML em PDF
            HtmlConverter.convertToPdf(htmlContent, pdfFile);

            System.out.println("PDF criado com sucesso!");
        } catch (FileNotFoundException e) {
        }
    }
}