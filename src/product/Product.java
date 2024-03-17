package product;
import java.util.Date;

public class Product {
	// Data members of Product
	int product_id;
	String serial_number;
	String product_name;
	String category;
	float unit_price;
	Date date_receive;
	
	// Default constructor, getters and setters of Product
	public Product() {
		super();
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	public Date getDate_receive() {
		return date_receive;
	}

	public void setDate_receive(Date date_receive) {
		this.date_receive = date_receive;
	}
}
