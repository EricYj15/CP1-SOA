package br.com.fiap.winery;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class ApplicationClient1 {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8085/WineStockService?wsdl");

        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");

        Service service = Service.create(url, qName);

        WineStockService wineStockService = service.getPort(WineStockService.class);

        String menu = wineStockService.getMenu();
        System.out.println(menu);
    }
}
