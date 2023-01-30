package cogent.infotech.dao;

import java.sql.Date;

interface ProductDAO {

	public void addProduct(int pid, String pname, String pcat, Date manufacture_date, int price, Date expiry_date);
	public void deleteProductById(int pid);
	public void deleteProductByCat(String pcat);
	public void findCheapestProductInCat(String pcat);
	public void findProductByCat(String pcat);
	public void findProductById(int pid);
	public void updateProduct(String pname, int newPrice);
	public void findExpiredProducts();
	
}
