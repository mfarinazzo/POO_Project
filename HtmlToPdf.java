package pedro.itext1;

import com.itextpdf.html2pdf.HtmlConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class HtmlToPdf {

// Nome do arquivo PDF a ser criado
        private static String dest = "Relatório.pdf";
        
       // CSS para estilizar o HTML
        private static String css = "@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');" +
                     "body { font-family: 'Roboto', sans-serif; }" +
                     "h1 { color: navy; text-align: center; }" +
                     "p { font-size: 14px; }" +
                     "table { width: 100%; border-collapse: collapse; margin-top: 20px; }" +
                     "th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: left; }" +
                     "th { background-color: #f2f2f2; }";

        // Conteúdo HTML com placeholders
        private static String htmlTemplate = "<html>" +
                              "<head>" +
                              "<title>Relatório do ICar</title>" +
                              "<style>" + css + "</style>" +
                              "</head>" +
                              "<body>" +
                              "<h1>Relatório do ICar</h1>" +
                              "<table>" +
                              "<tr><th>Parâmetro</th><th>Valor</th></tr>" +
                              "<tr><td>RPM do Motor</td><td>{{rpm}}</td></tr>" +
                              "<tr><td>Nível de Pressão do Óleo</td><td>{{oilPressure}}</td></tr>" +
                              "<tr><td>Nível de Pressão dos Pneus</td><td>{{tirePressure}}</td></tr>" +
                              "<tr><td>Temperatura do Óleo</td><td>{{oilTemp}}</td></tr>" +
                              "<tr><td>Temperatura do Motor</td><td>{{engineTemp}}</td></tr>" +
                              "<tr><td>Temperatura da água</td><td>{{waterTemp}}</td></tr>" +
                              "<tr><td>Voltagem da bateria</td><td>{{batteryVoltage}}</td></tr>" +
                              "<tr><td>Durabilidade dos sistemas de freios</td><td>{{brakes}}</td></tr>" +
                              "<tr><td>Nível da água</td><td>{{levelWater}}</td></tr>" +
                              "<tr><td>Nível do Óleo</td><td>{{levelOil}}</td></tr>" +
                              "</table>" +
                              "</body>" +
                              "</html>";
    
    public static void main(String[] args) {
        

        
        // Valores das variáveis, adicionar conforme surgirem variáveis
        Map<String, String> variables = new HashMap<>();
        variables.put("rpm", "3500 RPM");
        variables.put("oilPressure", "75 PSI");
        variables.put("tirePressure", "30 PSI");
        variables.put("oilTemp", "90 °C");
        variables.put("engineTemp", "90 °C");
        variables.put("waterTemp", "100 °C");
        variables.put("batteryVoltage", "12 V");
        variables.put("brakes", "50%");
        variables.put("levelWater", "50%");
        variables.put("levelOil", "50%");

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
        } catch (FileNotFoundException e) {}
    }
}
