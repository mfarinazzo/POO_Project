package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AI {
    private String urlTeste;

    public AI() {
        this.urlTeste = "http://localhost:5000/predict";
    }
    public float testarValor(float val) throws IOException {

        float normalizedValue = val - 4.0f;
        URL url = new URL(this.urlTeste+"/"+String.valueOf(normalizedValue));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();
            return Float.parseFloat(response);
        }else{
            System.out.println("Não foi possível conectar ao servidor.");
        }
        
        connection.disconnect();
        return -1.0f;
    }
}
