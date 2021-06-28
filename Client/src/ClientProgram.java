public class ClientProgram {
    public static void main(String[] args) {

        try (Client client = new Client()) {
            System.out.println("Logged in successfully.");
            System.out.println("You've been assigned the Unique Trader ID: " + client.getUniqueID());
            //System.out.println("Your balance is: " + client.getTraderBalance());
            // *NEED TO DISPLAY INFO ABOUT ALL OTHER TRADERS IN THE MARKET
            // *NEED TO DISPLAY ID OF TRADER WITH THE STOCK CURRENTLY
            System.out.println("Number of active traders online: " + client.numOfTraders());
            //System.out.println("Trader ID for current stock holder: " + client.getTraderStockHolder());

            while (true) {
//                int[] accountNumbers = client.getAccountNumbers();
//                System.out.println("Your accounts:");
//                for (int account : accountNumbers)
//                    System.out.printf(" Account %5d: balance %10d GBP%n", account, client.getAccountBalance(account));
//
//                System.out.println("Enter the account number to transfer from or -1 to print the account list:");
//                int fromAccount = Integer.parseInt(in.nextLine());
//                if (fromAccount < 0)
//                    continue;
//
//                System.out.println("Enter the account number to transfer to (this could be someone else's account):");
//                int toAccount = Integer.parseInt(in.nextLine());
//
//                System.out.println("Enter the amount to be transferred:");
//                int stockAmount = Integer.parseInt(in.nextLine());
//
//                client.transferStock(fromAccount, toAccount, stockAmount);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
