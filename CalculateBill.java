package CafeApplication;

import java.util.Map;

public class CalculateBill  {
	  private Map<String, MenuItem> menuItems;
	    private Map<String, Integer> customerOrder;

	    public  CalculateBill(Map<String, MenuItem> menuItems, Map<String, Integer> customerOrder) {
	        this.menuItems = menuItems;
	        this.customerOrder = customerOrder;
	    }

	    public double calculateBill() {
	        double totalBill = 0.0;

	        for (String item : customerOrder.keySet()) {
	            int quantity = customerOrder.get(item);
	            double price = menuItems.get(item).getPrice();
	            totalBill += price * quantity;
	        }

	        // Apply discounts, taxes, or service charges if needed
	        // Modify totalBill accordingly

	        return totalBill;
	    }
	}
