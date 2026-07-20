import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    String stockName;
    int quantity;
    double buyPrice;

    Portfolio(String stockName, int quantity, double buyPrice) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> market = new ArrayList<>();
        ArrayList<Portfolio> portfolio = new ArrayList<>();

        market.add(new Stock("TCS", 3500));
        market.add(new Stock("Infosys", 1600));
        market.add(new Stock("Reliance", 2900));
        market.add(new Stock("Wipro", 550));

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks");
                    for (Stock s : market) {
                        System.out.println(s.name + " - Rs." + s.price);
                    }
                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyName = sc.next();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    boolean found = false;

                    for (Stock s : market) {
                        if (s.name.equalsIgnoreCase(buyName)) {

                            portfolio.add(new Portfolio(s.name, qty, s.price));

                            System.out.println("Stock Purchased Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Stock Not Found!");

                    break;

                case 3:

                    System.out.print("Enter Stock Name to Sell: ");
                    String sellName = sc.next();

                    boolean sold = false;

                    for (int i = 0; i < portfolio.size(); i++) {

                        if (portfolio.get(i).stockName.equalsIgnoreCase(sellName)) {

                            portfolio.remove(i);
                            sold = true;
                            System.out.println("Stock Sold Successfully!");
                            break;
                        }
                    }

                    if (!sold)
                        System.out.println("Stock Not Available!");

                    break;

                case 4:

                    double total = 0;

                    System.out.println("\nYour Portfolio");

                    if (portfolio.size() == 0) {
                        System.out.println("No Stocks Purchased.");
                    } else {

                        for (Portfolio p : portfolio) {

                            double value = p.quantity * p.buyPrice;

                            total += value;

                            System.out.println(
                                    p.stockName + " | Qty: " + p.quantity +
                                            " | Price: Rs." + p.buyPrice +
                                            " | Value: Rs." + value);
                        }

                        System.out.println("---------------------------");
                        System.out.println("Total Portfolio Value = Rs." + total);
                    }

                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}