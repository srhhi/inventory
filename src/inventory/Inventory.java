package inventory;
import java.util.Date;

public class Inventory {
	// Data members of Inventory
	int inv_id;
	String product_name;
	String supplier_name;
	int stock_in;
	int stock_out;
	int stock_balance;
	Date stock_date;
	String status;
	
	// Default constructor, getters and setters of Inventory
	public Inventory() {
		super();
	}

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public int getStock_in() {
		return stock_in;
	}

	public void setStock_in(int stock_in) {
		this.stock_in = stock_in;
	}

	public int getStock_out() {
		return stock_out;
	}

	public void setStock_out(int stock_out) {
		this.stock_out = stock_out;
	}

	public int getStock_balance() {
		return stock_balance;
	}

	public void setStock_balance(int stock_balance) {
		this.stock_balance = stock_balance;
	}

	public Date getStock_date() {
		return stock_date;
	}

	public void setStock_date(Date stock_date) {
		this.stock_date = stock_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}