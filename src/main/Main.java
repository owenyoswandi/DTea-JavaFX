package main;

import java.util.ArrayList;

import account.Account;
import item.Item;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;

public class Main extends Application{
	public static ArrayList<Account> accounts = new ArrayList<>();
	public static ArrayList<Item> items = new ArrayList<>();
	Scene scene;
	
	public static final DataFormat ITEM_NAME = new DataFormat("application/x-item-name");
    public static final DataFormat ITEM_PRICE = new DataFormat("application/x-item-price");
	
	public static void main(String[] args) {
		launch(args);
	}

	private void add() {
		accounts.add(new Account("a", "a", "a")); //this is a testing account
		items.add(new Item("Lemon Tea", 20000, 10, "A refreshing infusion of black tea subtly "
				+ "brightened by the zesty essence of fresh lemons, offering a tangy and invigorating flavor profile"));
		items.add(new Item("Black Tea", 10000, 20, "A robust and full-bodied brew, characterized by its deep, "
				+ "malty notes and a bold, satisfying taste that makes it a classic choice for tea enthusiasts"));
		items.add(new Item("Apple Tea", 25000, 20, "A delightful infusion blending the sweetness of ripe apples "
				+ "with the comforting warmth of tea, creating a fruity and aromatic beverage that evokes the essence "
				+ "of a crisp autumn day"));
		items.add(new Item("Honey Tea", 30000, 20, "A soothing concoction that combines the natural "
				+ "sweetness of honey with the mellow tones of tea, resulting in a "
				+ "comforting and mildly sweetened drink that is perfect for relaxation"));
		items.add(new Item("Milk Tea", 35000, 0, "A rich and creamy fusion of tea and milk, "
				+ "offering a harmonious balance of bold tea flavors and the velvety smoothness of milk, "
				+ "creating a comforting and indulgent beverage enjoyed worldwide"));
	}
	
	public void start(Stage primaryStage) throws Exception {
		add();
		new Login(primaryStage);
	}
}