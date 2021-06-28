public class Customer {
    private final long customerID;
    private int stock;
    private boolean stockHolder;

    public Customer(long customerID, int stock) {
        this.customerID = customerID;
        this.stock = stock;
    }

    public long getCustomerID() { return customerID; }

    public void updateTrader() { }

    public int getStock() {
        return stock;
    }

    public void setStock(int setNewStock) {
        stock = setNewStock;
    }

    public void setStockHolder(boolean stockTradeHolder) {
        stockHolder = stockTradeHolder;
    }

}
