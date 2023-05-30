package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items; //list of item in cart
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	//add a new product to cart
	public void add(Product p) {
		for(Product x: items) {
			if(p.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(p);
	}
	
	//remove a product from cart
	public void remove(int id) {
		for(Product x : items) {
			if(x.getId() == id) {
				items.remove(x);
				return;
			}
		}
	}
	
	//return total amount of cart
	public double getAmount() {
		double s = 0;
		for(Product x : items) {
			s += x.getPrice() * x.getNumber();
		}
		return Math.round(s * 100.0) / 100.0;
	}
	
	public int size() {
		int rs = 0;
		for(Product p : items) {
			//number of each Product
			int number = p.getNumber();
			rs += number;
		}
		
		return rs;
	}
	
	//return list of products in cart
	public List<Product> getItems(){
		return items;
	}
	
	
	//delete all
	public void deleteCart() {
		items.clear();
	}


	
	

}
