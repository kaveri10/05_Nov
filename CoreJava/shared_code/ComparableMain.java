

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class OrderTitleComparator implements Comparator<Order> {

	@Override
	public int compare(Order order1, Order order2) {
		if (order1.title.compareTo(order2.title) > 0) {
			return 1;
		}
		else if (order1.title.compareTo(order2.title) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}

class OrderPriceComparator implements Comparator<Order> {

	@Override
	public int compare(Order order1, Order order2) {
		if (order1.price > order2.price) {
			return 1;
		}
		else if (order1.price < order2.price) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}

class Order implements Comparable<Order> {

	String title;
	double price;
	
	public Order(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public int compareTo(Order order) {
		if (this.price > order.price) {
			return -1;
		}
		else if (this.price < order.price) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return title + " - " + price;
	}
}
public class ComparableMain {

	public static void main(String[] args) {
		Order order1 = new Order("Chair purchase", 13000);
		Order order2 = new Order("Table purchase", 15000);
		Order order3 = new Order("Furniture Sale", 12000);
		
		if(order1.compareTo(order2) > 0) {
			System.out.println("order 1 is more expensive than order 2");
		}
		else if(order1.compareTo(order2) < 0) {
			System.out.println("order 2 is more expensive than order 1");
		}
		else {
			System.out.println("order 1 & order 2 are equal in cost");
		}

		List<Order> list = new ArrayList<Order>();
		list.add(order1);
		list.add(order2);
		list.add(order3);
		
		//Collections.sort(list); //internally calls Comparable.compareTo()
		Collections.sort(list, new OrderTitleComparator()); //internally calls Comparator.compare()
		for(Order order: list) {
			System.out.println(order);
		}
	}

}
