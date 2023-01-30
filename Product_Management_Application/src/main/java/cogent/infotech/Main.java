package cogent.infotech;

import java.sql.Date;
import java.util.Scanner;

import cogent.infotech.controller.ProductController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		ProductController pc = new ProductController();
		do {
			System.out.println("1-Add Product");
			System.out.println("2-Delete Product ID");
			System.out.println("3-Delete Product Category");
			System.out.println("4-Find Cheapest Product");
			System.out.println("5-Find Product Catgeory");
			System.out.println("6-Find Product ID");
			System.out.println("7-Update Product");
			System.out.println("8-Find Expired Product");
			System.out.println("9-Exit");
			System.out.println("Please enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the product id");
				int pid = sc.nextInt();
				System.out.println("Enter the product name");
				String pname = sc.next();
				System.out.println("Enter the product category");
				String pcat = sc.next();
				System.out.println("Enter the manufacture date");
				Date manufacture_date = Date.valueOf(sc.next());
				System.out.println("Enter the price");
				int price = sc.nextInt();
				System.out.println("Enter the expiry date");
				Date expiry = Date.valueOf(sc.next());
				pc.add(pid, pname, pcat, manufacture_date, price, expiry);
				break;
			case 2:
				System.out.println("Enter the product id to be deleted");
				int deleteId = sc.nextInt();
				pc.delete(deleteId);
				break;
			case 3:
				System.out.println("Enter the product category to be deleted");
				String deleteCat = sc.next();
				pc.delete(deleteCat);
				break;
			case 4:
				System.out.println("Enter the product category");
				String cheap = sc.next();
				pc.findCheap(cheap);
				break;
			case 5:
				System.out.println("Enter the product category");
				String findCat = sc.next();
				pc.find(findCat);
				break;
			case 6:
				System.out.println("Enter the product id");
				int findId = sc.nextInt();
				pc.find(findId);
				break;
			case 7:
				System.out.println("Enter the product name to be updated");
				String name = sc.next();
				System.out.println("Enter the new price");
				int newPrice = sc.nextInt();
				pc.update(name, newPrice);
				break;
			case 8:
				pc.findExpired();
				break;
			case 9:
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while(choice != 9);
		sc.close();
	}
}
