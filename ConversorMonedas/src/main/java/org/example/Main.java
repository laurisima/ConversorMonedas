package org.example;
import org.json.JSONObject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String tipoCambio ="";
        int num;
        ServicioExchangeRate servicio = new ServicioExchangeRate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenid@s al conversor de Lauramadora ñ.ñ");
        while (true) {
            System.out.println("***************************");
            System.out.println("\t      Menú  \t");
            System.out.println("***************************");
            System.out.println("1) Dólar >> Peso argentino");
            System.out.println("2) Peso argentino >> Dólar");
            System.out.println("3) Dólar >> Real brasileño");
            System.out.println("4) Real brasileño >> Dólar");
            System.out.println("5) Dólar >> Peso chileno");
            System.out.println("6) Peso chileno >> Dólar");
            System.out.println("7) Salir");
            System.out.println("***************************");
            System.out.print("Elija una opción válida: ");

            try {
                int option = scanner.nextInt();

                if (option < 1 || option > 7) {
                    System.out.println("Opción inválida. Por favor, elija una opción entre 1 y 7.");
                    continue;
                }

                switch (option) {
                    case 1:
                        tipoCambio="USD";
                        String url = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/"+tipoCambio;
                        try{
                            // Llamar a la API y obtener la respuesta JSON
                            String respuestaJson = servicio.llamarAPI(url);

                            // Procesar la respuesta JSON
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double usdToArs = conversionRates.getDouble("ARS");
                            System.out.println("Valor de cambio de USD a ARS: " + usdToArs);
                            try{

                                System.out.println("Ingrese el valor que desea covertir");
                                num =scanner.nextInt();
                                 double valorConversion = num*usdToArs;
                                System.out.println("El valor de la conversión es :" +valorConversion);

                            }catch (Exception e){
                                System.out.println("Porfavor ingrese un número válido");
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }

                        System.out.println("Dólar >> Peso argentino ");
                        break;
                    case 2:
                        tipoCambio="ARS";
                        String url2 = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/"+tipoCambio;
                        try{
                            String respuestaJson = servicio.llamarAPI(url2);
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double usdToArs = conversionRates.getDouble("USD");
                            System.out.println(" Valor de cambio de ARS a USD: " + usdToArs);
                            try{

                                System.out.println("Ingrese el valor que desea covertir");
                                num =scanner.nextInt();
                                double valorConversion = num*usdToArs;
                                System.out.println("El valor de la conversión es :" +valorConversion);

                            }catch (Exception e){
                                System.out.println("Porfavor ingrese un número válido");
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }

                        System.out.println("Dólar >> Peso argentino ");
                        break;
                    case 3:
                        tipoCambio = "USD";
                        String url3 = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/" + tipoCambio;
                        try {

                            String respuestaJson = servicio.llamarAPI(url3);
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double usdToBrl = conversionRates.getDouble("BRL");
                            System.out.println("Valor de cambio de USD a BRL: " + usdToBrl);
                            try {
                                System.out.println("Ingrese el valor que desea convertir");
                                num = scanner.nextInt();
                                double valorConversion = num * usdToBrl;
                                System.out.println("El valor de la conversión es :" + valorConversion);
                            } catch (Exception e) {
                                System.out.println("Por favor, ingrese un número válido");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Dólar >> Real brasileño ");
                        break;

                    case 4:
                        tipoCambio = "BRL";
                        String url4 = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/" + tipoCambio;
                        try {
                            String respuestaJson = servicio.llamarAPI(url4);
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double brlToUsd = conversionRates.getDouble("USD");
                            System.out.println("Valor de cambio de BRL a USD: " + brlToUsd);
                            try {
                                System.out.println("Ingrese el valor que desea convertir");
                                num = scanner.nextInt();
                                double valorConversion = num * brlToUsd;
                                System.out.println("El valor de la conversión es :" + valorConversion);
                            } catch (Exception e) {
                                System.out.println("Por favor, ingrese un número válido");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Real brasileño >> Dólar ");
                        break;
                    case 5:
                        tipoCambio = "USD";
                        String url5 = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/" + tipoCambio;
                        try {
                            String respuestaJson = servicio.llamarAPI(url5);
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double usdToClp = conversionRates.getDouble("CLP");
                            System.out.println("Valor de cambio de USD a CLP: " + usdToClp);
                            try {
                                System.out.println("Ingrese el valor que desea convertir");
                                num = scanner.nextInt();
                                double valorConversion = num * usdToClp;
                                System.out.println("El valor de la conversión es :" + valorConversion);
                            } catch (Exception e) {
                                System.out.println("Por favor, ingrese un número válido");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Dólar >> Peso chileno ");
                        break;
                    case 6:
                        tipoCambio = "CLP";
                        String url6 = "https://v6.exchangerate-api.com/v6/3ac6ab8c0de0eb17039f3adf/latest/" + tipoCambio;
                        try {
                            String respuestaJson = servicio.llamarAPI(url6);
                            JSONObject jsonObject = new JSONObject(respuestaJson);
                            String result = jsonObject.getString("result");
                            System.out.println("Result: " + result);

                            JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");
                            double usdToClp = conversionRates.getDouble("USD");
                            System.out.println("Valor de cambio de CLP a USD: " + usdToClp);
                            try {
                                System.out.println("Ingrese el valor que desea convertir");
                                num = scanner.nextInt();
                                double valorConversion = num * usdToClp;
                                System.out.println("El valor de la conversión es :" + valorConversion);
                            } catch (Exception e) {
                                System.out.println("Por favor, ingrese un número válido");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Peso chileno >> Dólar  ");
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.next();
            }
        }

    }


}
