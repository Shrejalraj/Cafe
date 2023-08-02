package CafeApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CafeBillingApplication {
	  protected static Map<String, MenuItem> menuItems = new HashMap<>();
	    protected static Map<String, Integer> customerOrder = new HashMap<>();

	    public static void main(String[] args) {
	        initializeMenu();
	        displayMenu();
	        takeOrder();
	        CalculateBill calculatebill = new CalculateBill(menuItems, customerOrder);
	        double totalBill = calculatebill.calculateBill();
	        System.out.println("Total Bill: $" + totalBill);
	    }

	    private static void initializeMenu() {
	        menuItems.put("Tea", new MenuItem("Tea", 2.5));
	        menuItems.put("Cheese Pasta", new MenuItem("Cheese Pasta", 5.8));
	        menuItems.put("Sandwich", new MenuItem("Sandwich", 4.0));
	        menuItems.put("Coffee", new MenuItem("Coffee", 2.2));
	        menuItems.put("Brownie", new MenuItem("Brownie", 5.2));
	        
	    }

	    private static void displayMenu() {
	        System.out.println("Menu:");
	        for (MenuItem item : menuItems.values()) {
	            System.out.println(item.getName() + " - $" + item.getPrice());
	        }
	    }

	    private static void takeOrder() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the items and quantities you want to order (e.g., Coffee 2, Tea 1):");
	      String input= sc.nextLine();
	        String[] items = input.split(", ");
	        for (String item : items) {
	            String[] parts = item.split(" ");
	            if (parts.length != 2) {
	                System.out.println("Invalid input format for item: " + item);
	                continue;
	            }

	            String itemName = parts[0];
	            int quantity;
	            try {
	                quantity = Integer.parseInt(parts[1]);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid quantity for item: " + itemName);
	                continue;
	            }

	            if (menuItems.containsKey(itemName)) {
	                // Add the item and its quantity to the customerOrder 
	                customerOrder.put(itemName, quantity);
	            } else {
	                System.out.println("Invalid item: " + itemName);
	            }
	        }
	    }

	  
	    }
