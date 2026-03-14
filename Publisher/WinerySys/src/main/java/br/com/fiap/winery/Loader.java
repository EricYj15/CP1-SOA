package br.com.fiap.winery;

import jakarta.xml.ws.Endpoint;

public class Loader {

    public static void main(String[] args) {
        WineStockServiceImplementation wineStock = new WineStockServiceImplementation();
        Endpoint.publish("http://localhost:8085/WineStockService", wineStock);
        System.out.println("Serviço publicado! -> http://localhost:8085/WineStockService?wsdl");

        WineWarningServiceImplementation wineWarning = new WineWarningServiceImplementation();
        Endpoint.publish("http://localhost:8086/WineWarningService", wineWarning);
        System.out.println("Serviço publicado! -> http://localhost:8086/WineWarningService?wsdl");
    }
}
