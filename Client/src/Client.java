import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements AutoCloseable{

    final int port = 8888;

    private final Scanner readInputStream;
    private final PrintWriter writeOutputStream;

    public Client() throws Exception {
        Socket serverSocket = new Socket("localhost", port);
        readInputStream = new Scanner(serverSocket.getInputStream());
        writeOutputStream = new PrintWriter(serverSocket.getOutputStream(), true);

        String line = readInputStream.nextLine();
        if (line.trim().compareToIgnoreCase("success") != 0)
            throw new Exception(line);
    }

    public long getUniqueID() {
        writeOutputStream.println("UNIQUE_ID");
        String line = readInputStream.nextLine();
        return Long.parseLong(line.trim());
    }

    public int numOfTraders() {
        writeOutputStream.println("NUM_OF_TRADERS");
        String line = readInputStream.nextLine();
        return Integer.parseInt(line.trim());
    }

    public long getTraderStockHolder() {
        writeOutputStream.println("STOCK_HOLDER");
        String line = readInputStream.nextLine();
        return Long.parseLong(line.trim());
    }

    public void transferStock(int fromAccount,
                              int toAccount,
                              int stockAmount) throws Exception {
        writeOutputStream.println("TRANSFER " +
                fromAccount +
                " " +
                toAccount +
                " " +
                stockAmount);

        String line = readInputStream.nextLine();
        if (line.trim().compareToIgnoreCase("success") != 0)
            throw new Exception(line);
    }

    @Override
    public void close() throws Exception {

    }
}
