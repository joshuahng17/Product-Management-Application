package cogent.infotech.model;

import java.sql.Date;

public class Product {

	int pid;
	String pname;
	String pcat;
	Date manufacture_date;
	int price;
	Date expiry_date;
	
	public Product(int pid, String pname, String pcat, Date manufacture_date, int price, Date expiry_date) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcat = pcat;
		this.manufacture_date = manufacture_date;
		this.price = price;
		this.expiry_date = expiry_date;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	public Date getManufacture_date() {
		return manufacture_date;
	}
	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	@Override
	public String toString() {
		return "product id " + this.pid + ", product name " + this.pname + ", product category" + this.pcat + ", product manufacture date " + this.manufacture_date
				+ ", product price " + this.price + ", product expiration date " + expiry_date;
	}
	
	
}
