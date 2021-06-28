import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class StockMarket {
    private final Map<Long, Customer> trader = new TreeMap<>();
    private AtomicLong uniqueID = new AtomicLong();
    private int availableStock;

    public StockMarket (int availableStock) {
        this.availableStock = availableStock;
    }

    public void createTrader(long customerID) {
        int initialStock = 0;
        if (trader.size() == 0) {
            initialStock = availableStock;
            availableStock = 0;
        }
        Customer customer = new Customer(customerID, initialStock);
        trader.put(customerID, customer);
        System.out.println("New trader: ID "+ customer.getCustomerID() + " has entered the stock market.");
    }

    public long getUniqueID() {
        return uniqueID.getAndIncrement();
    }

    public Customer getCustomer(long id) {
        return trader.get(id);
    }

    public int getNumOfCustomers() {
        return trader.size();
    }

    //public long getStockHolderID() { }

    public void assignStock(long id) {
        Customer customer = trader.get(id);
        trader.remove(id);
        if (customer.getStock() > 0) {
            if (trader.size() > 0) {
                Customer stockHolder = trader.entrySet().iterator().next().getValue();
                stockHolder.setStock(1);
                System.out.println("Trader who holds stock: ID "+ stockHolder.getCustomerID());
            } else {
                availableStock = customer.getStock();
                System.out.println("No traders available. Stock assigned back to server.");

            }
        }
    }
/*
    public void transfer(long customerID, long fromTrader, long toTrader, int amount) throws Exception {
        synchronized (trader) { }
    }
 */
}
