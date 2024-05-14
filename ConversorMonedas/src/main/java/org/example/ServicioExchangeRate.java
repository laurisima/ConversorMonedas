package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServicioExchangeRate {
    public String llamarAPI(String url) throws Exception {
        URL apiUrl = new URL(url);
        HttpURLConnection conexion = (HttpURLConnection) apiUrl.openConnection();
        conexion.setRequestMethod("GET");

        // Leer la respuesta de la API
        BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            respuesta.append(linea);
        }
        lector.close();

        return respuesta.toString();
    }


}
