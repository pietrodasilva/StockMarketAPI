import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private StockMarket stockMarket;

    public ClientHandler(Socket socket, StockMarket stockMarket) {
        this.socket = socket;
        this.stockMarket = stockMarket;
    }

    @Override
    public void run() {
        long customerID = 0;
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            try {
                customerID = stockMarket.getUniqueID();
                System.out.println("New connection; customer ID " + customerID);
                stockMarket.createTrader(customerID);
                writer.println("SUCCESS");

                while (true) {
                    String line  = scanner.nextLine();
                    String[] substrings = line.split(" ");
                    switch (substrings[0].toLowerCase()) {
                        case "unique_id":
                            writer.println(customerID);
                            break;

                        case "num_of_traders":
                            writer.println(stockMarket.getNumOfCustomers());
                            break;

                        case "stock_holder":
                            writer.println();

                        case "transfer":
                            int fromTrader = Integer.parseInt(substrings[1]);
                            int toTrader = Integer.parseInt(substrings[2]);
                            int amount = Integer.parseInt(substrings[3]);
                            //stockMarket.transfer(customerID, fromTrader, toTrader, amount);
                            writer.println("SUCCESS");
                            break;

                        default:
                            throw new Exception("Unknown command: " + substrings[0]);
                 }
                }
            } catch (Exception e) {
                writer.println("ERROR " + e.getMessage());
                socket.close();
            }
        } catch (Exception e) {
        } finally {
            stockMarket.assignStock(customerID);
            System.out.println("Trader ID " + customerID + " disconnected.");
        }
    }
}
