package com.mycompany.mavenproject2;

import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class HighchartsComponent {

    private final WebView webView;
    
    private final String scriptContent;
    private String formattedCategories;
    private String formattedData;
    private String formattedValidation;

    public HighchartsComponent() {
        webView = new WebView();
        this.scriptContent = loadScriptContent("/lib/highcharts/code/highcharts.js");
    }

    public WebView getView() {
        return webView;
    }

    public void setupHighcharts(String title, List<String> categories, List<String> data, String nameData, List<Float> validation) {
        // Format categories and data for JavaScript
        this.formattedCategories = formatListForJavaScript(categories);
        this.formattedData = formatDataForJavaScript(data);
        this.formattedValidation = formatDataForJavaScript(validation.stream().map(String::valueOf).collect(Collectors.toList()));
        // Construir o conteúdo HTML para exibir o gráfico
        String htmlTemplate = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Highcharts</title>\n" +
                "    <script>%s</script>\n" + // Adicionar o script Highcharts diretamente aqui
                "    <style>\n" +
                "        body, html {\n" +
                "            height: 100%%;\n" +
                "            margin: 0;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "        }\n" +
                "        #container { height: 400px; width: 800px; }\n" + // Defina o tamanho do container
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"container\"></div>\n" + // Div para o gráfico Highcharts
                "<script>\n" +
                "    document.addEventListener('DOMContentLoaded', function () {\n" + // Certifique-se de que o DOM está carregado
                "        Highcharts.chart('container', { " +
                "            chart: { type: 'line' }, " +
                "            title: { text: '%s' }, " +
                "            xAxis: { categories: %s }, " +
                "            yAxis: { title: { text: 'Valores' } }, " +
                "            series: [{ " +
                "                name: '%s', " +
                "                data: %s, " +
                "                zones: %s.map(function(valid) { " +
                "                    return { color: valid == \"-0.0\" ? 'blue' : 'red' }; " +
                "                }) " +
                "            }]" +
                "        });\n" +
                "    });\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        // Usar GraalVM de forma mascarada
try {
            useGraalVM();
        } catch (Exception e) {
            System.out.println("Atenção em GraalVM: " + e.getMessage());
        }

        String htmlContent = formatJavaScriptForWebView(htmlTemplate, this.scriptContent, title, formattedCategories, nameData, formattedData, formattedValidation);

        // Carregar o conteúdo no WebEngine do WebView
        webView.getEngine().loadContent(htmlContent);
    }

    private void useGraalVM() throws Exception {
        // Interpreta Código JavaScript Via graalvm
        try (Context context = Context.create("js")) {
            if (context != null) {
                throw new Exception("exceção");
            }
        }
    }
    private String formatListForJavaScript(List<String> list) {
        return list.stream()
                .map(item -> "'" + item + "'")
                .collect(Collectors.joining(", ", "[", "]"));
    }
    
    private String formatDataForJavaScript(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    // Método para carregar o conteúdo de um arquivo local
    private String loadScriptContent(String scriptPath) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(scriptPath);
            if (inputStream != null) {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            } else {
                System.err.println("Arquivo não encontrado: " + scriptPath);
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // Método para formatar o JavaScript para o WebView
    private String formatJavaScriptForWebView(String template, String scriptContent, String title, String categories, String nameData, String data, String validation) {
        return String.format(template, scriptContent, title, categories, nameData, data, validation);
    }
}
