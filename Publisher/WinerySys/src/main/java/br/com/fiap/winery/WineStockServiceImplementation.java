package br.com.fiap.winery;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {

    @Override
    public String getMenu() {
        return "===== Menu de Vinhos =====\n"
             + "1. Cabernet Sauvignon - Tinto encorpado\n"
             + "2. Merlot - Tinto macio e frutado\n"
             + "3. Pinot Noir - Tinto leve e elegante\n"
             + "4. Chardonnay - Branco seco e frutado\n"
             + "5. Sauvignon Blanc - Branco refrescante\n"
             + "6. Malbec - Tinto intenso e especiado\n"
             + "7. Syrah - Tinto robusto e picante\n"
             + "8. Riesling - Branco aromático\n"
             + "==========================";
    }

    @Override
    public String placeOrder(String name, int quantity) {
        return "Pedido confirmado! Vinho: " + name + ", Quantidade: " + quantity;
    }
}
