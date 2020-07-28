package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) throws IOException {
        Warehouse warehouse;
        while (true) {
            out.println("WAREHOUSE:");
            for (WarehouseType warehouseType : WarehouseType.values()) {
                out.println(String.format("%d. %s", warehouseType.ordinal() + 1, warehouseType));
            }
            String wareHouseChosen = in.readLine();
            if (wareHouseChosen.equals("exit")) {
                return;
            }
            if (WarehouseType.values().length == 0) {
                continue;
            }

            int wareHouseChosenNum;
            try {
                wareHouseChosenNum = Integer.parseInt(wareHouseChosen);
            } catch (NumberFormatException e) {
                continue;
            }
            if (1 <= wareHouseChosenNum && wareHouseChosenNum <= WarehouseType.values().length) {
                warehouse = new Warehouse(WarehouseType.values()[wareHouseChosenNum - 1]);
                break;
            }
        }

        User user = new User();
        SafeWallet wallet;
        try {
            wallet = new SafeWallet(user);
        } catch (IllegalAccessException e) {
            err.print("AUTH_ERROR");
            return;
        }

        while (true) {
            out.println(String.format("BALANCE: %d", wallet.getAmount()));
            ArrayList<Product> products = warehouse.getProducts();

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                int numSpaces = 20 - String.format("%d", product.getPrice()).length() - product.getName().length();
                out.println(String.format("%d. %s%" + numSpaces + "s%d", i + 1, product.getName(), " ", product.getPrice()));
            }

            String productChosenStr = in.readLine();
            if (productChosenStr.equals("exit")) {
                return;
            }
            if (products.size() == 0) {
                continue;
            }

            int productChosenNum;
            try {
                productChosenNum = Integer.parseInt(productChosenStr);
            } catch (NumberFormatException e) {
                continue;
            }

            if (1 <= productChosenNum && productChosenNum <= products.size()) {
                Product productChosen = products.get(productChosenNum - 1);
                try {
                    warehouse.removeProduct(productChosen.getId());
                } catch (ProductNotFoundException e) {
                    continue;
                }
            }
        }
    }
}
