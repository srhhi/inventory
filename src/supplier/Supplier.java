package supplier;

public class Supplier {
	// Data members of Supplier
	int supplier_id;
	String supplier_name;
	String supplier_city;
	String supplier_phone;
	
	// Default constructor, getters and setters of Supplier
	public Supplier() {
		super();
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_city() {
		return supplier_city;
	}

	public void setSupplier_city(String supplier_city) {
		this.supplier_city = supplier_city;
	}

	public String getSupplier_phone() {
		return supplier_phone;
	}

	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
}
