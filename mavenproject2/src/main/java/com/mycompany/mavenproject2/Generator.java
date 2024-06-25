package com.mycompany.mavenproject2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Generator {
    private String url;

    public Generator() {
        this.url = "http://localhost:5000/generate";
    }

    public float gerarNumeroNormal(int distance) throws IOException {

        URL url = new URL(this.url+"/"+String.valueOf(distance));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();
            float v = Float.parseFloat(response);
            return -1*(v-4.0f);
        }else{
            System.out.println("Não foi possível conectar ao servidor.");
        }
        
        connection.disconnect();
        return -1.0f;
    }
}
