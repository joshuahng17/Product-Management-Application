package cogent.infotech.controller;

import cogent.infotech.dao.ProductDAOImpl;
import java.sql.Date;

public class ProductController {

	ProductDAOImpl dao = new ProductDAOImpl();
	
	public void add(int pid, String pname, String pcat, Date manufacture_date, int price, Date expiry_date) {
		dao.addProduct(pid, pname, pcat, manufacture_date, price, expiry_date);
	}
	
	public void delete(int pid) {
		dao.deleteProductById(pid);
	}
	
	public void delete(String pcat) {
		dao.deleteProductByCat(pcat);
	}
	
	public void findCheap(String pcat) {
		dao.findCheapestProductInCat(pcat);
	}
	
	public void find(String pcat) {
		dao.findProductByCat(pcat);
	}
	
	public void find(int pid) {
		dao.findProductById(pid);
	}
	
	public void update(String pname, int newPrice) {
		dao.updateProduct(pname, newPrice);
	}
	
	public void findExpired() {
		dao.findExpiredProducts();
	}
}
