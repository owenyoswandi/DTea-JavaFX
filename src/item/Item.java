package item;

public class Item {
	private String name;
	private float price;
	private int stock;
	private String desc;
	
	public Item(String name, float price, int stock, String desc) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
