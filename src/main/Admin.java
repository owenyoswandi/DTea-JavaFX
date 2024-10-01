package main;

import java.io.File;

import item.Item;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin {

	Image lemon, black, apple, honey, milk, icon;
	ImageView lemonImage, blackImage, appleImage, honeyImage, milkImage;
	ImageView lemonImage2, blackImage2, appleImage2, honeyImage2, milkImage2;
	File fileLemon, fileBlack, fileApple, fileHoney, fileMilk, file;
	
	Scene scene;
	GridPane gp;
	BorderPane bp;
	ScrollPane sp;
	Stage stage;
	
	VBox vbox, box, lemonBox, blackBox, appleBox, honeyBox, milkBox, logBox;
	VBox lemonName, blackName, appleName, honeyName, milkName;
	VBox lemonPrice, blackPrice, applePrice, honeyPrice, milkPrice;
	VBox lemonStock, blackStock, appleStock, honeyStock, milkStock;
	VBox lemonDesc, blackDesc, appleDesc, honeyDesc, milkDesc;
	VBox lb, bb, ab, hb, mb;
	
	HBox lemonHBox, blackHBox, appleHBox, honeyHBox, milkHBox;
	HBox lemonChange, blackChange, appleChange, honeyChange, milkChange;
	
	Label manageLabel, lemonLabel, blackLabel, appleLabel, honeyLabel, milkLabel;
	Label nameLabel1, nameLabel2, nameLabel3, nameLabel4, nameLabel5;
	Label priceLabel1, priceLabel2, priceLabel3, priceLabel4, priceLabel5;
	Label stockLabel1, stockLabel2, stockLabel3, stockLabel4, stockLabel5;
	Label descLabel1, descLabel2, descLabel3, descLabel4, descLabel5;
	
	TextField nameL, nameB, nameA, nameH, nameM, priceL, priceB, priceA, priceH, priceM;
	TextArea descL, descB, descA, descH, descM;
	
	Spinner<Integer> lemonS, blackS, appleS, honeyS, milkS;
	
	Button logout, lemonSave, blackSave, appleSave, honeySave, milkSave;
	
	private void init() {
		gp = new GridPane();
		bp = new BorderPane();
		scene = new Scene(bp, 750, 450);
		sp = new ScrollPane();
		
		file = new File("logo.png");
		fileLemon = new File("lemon_tea.jpg");
		fileBlack = new File("black_tea.jpg");
		fileApple = new File("apple_tea.jpg");
		fileHoney = new File("honey_tea.jpg");
		fileMilk = new File("milk_tea.jpg");
		
		icon = new Image(file.toURI().toString());
		lemon = new Image(fileLemon.toURI().toString());
		black = new Image(fileBlack.toURI().toString());
		apple = new Image(fileApple.toURI().toString());
		honey = new Image(fileHoney.toURI().toString());
		milk = new Image(fileMilk.toURI().toString());
		
		lemonImage = new ImageView(lemon);
		blackImage = new ImageView(black);
		appleImage = new ImageView(apple);
		honeyImage = new ImageView(honey);
		milkImage = new ImageView(milk);
		
		lemonImage2 = new ImageView(lemon);
		blackImage2 = new ImageView(black);
		appleImage2 = new ImageView(apple);
		honeyImage2 = new ImageView(honey);
		milkImage2 = new ImageView(milk);
		
		manageLabel = new Label("Manage Items");
		lemonLabel = new Label(Main.items.get(0).getName());
		blackLabel = new Label(Main.items.get(1).getName());
		appleLabel = new Label(Main.items.get(2).getName());
		honeyLabel = new Label(Main.items.get(3).getName());
		milkLabel = new Label(Main.items.get(4).getName());
		
		//tea name boxes
		nameL = new TextField(Main.items.get(0).getName());
		nameB = new TextField(Main.items.get(1).getName());
		nameA = new TextField(Main.items.get(2).getName());
		nameH = new TextField(Main.items.get(3).getName());
		nameM = new TextField(Main.items.get(4).getName());
		
		nameLabel1 = new Label("Item Name");
		nameLabel2 = new Label("Item Name");
		nameLabel3 = new Label("Item Name");
		nameLabel4 = new Label("Item Name");
		nameLabel5 = new Label("Item Name");
		
		lemonName = new VBox(nameLabel1, nameL);
		blackName = new VBox(nameLabel2, nameB);
		appleName = new VBox(nameLabel3, nameA);
		honeyName = new VBox(nameLabel4, nameH);
		milkName = new VBox(nameLabel5, nameM);
		
		//tea price boxes
		priceL = new TextField(String.valueOf(Main.items.get(0).getPrice()));
		priceB = new TextField(String.valueOf(Main.items.get(1).getPrice()));
		priceA = new TextField(String.valueOf(Main.items.get(2).getPrice()));
		priceH = new TextField(String.valueOf(Main.items.get(3).getPrice()));
		priceM = new TextField(String.valueOf(Main.items.get(4).getPrice()));
		
		priceLabel1 = new Label("Item Price");
		priceLabel2 = new Label("Item Price");
		priceLabel3 = new Label("Item Price");
		priceLabel4 = new Label("Item Price");
		priceLabel5 = new Label("Item Price");
		
		lemonPrice = new VBox(priceLabel1, priceL);
		blackPrice = new VBox(priceLabel2, priceB);
		applePrice = new VBox(priceLabel3, priceA);
		honeyPrice = new VBox(priceLabel4, priceH);
		milkPrice = new VBox(priceLabel5, priceM);
		
		//tea stock boxes
		lemonS = new Spinner<>(0, 1000, Main.items.get(0).getStock());
		blackS = new Spinner<>(0, 1000, Main.items.get(1).getStock());
		appleS = new Spinner<>(0, 1000, Main.items.get(2).getStock());
		honeyS = new Spinner<>(0, 1000, Main.items.get(3).getStock());
		milkS = new Spinner<>(0, 1000, Main.items.get(4).getStock());
		
		stockLabel1 = new Label("Item Stock");
		stockLabel2 = new Label("Item Stock");
		stockLabel3 = new Label("Item Stock");
		stockLabel4 = new Label("Item Stock");
		stockLabel5 = new Label("Item Stock");
		
		lemonStock = new VBox(stockLabel1, lemonS);
		blackStock = new VBox(stockLabel2, blackS);
		appleStock = new VBox(stockLabel3, appleS);
		honeyStock = new VBox(stockLabel4, honeyS);
		milkStock = new VBox(stockLabel5, milkS);
		
		//upper section
		lemonChange = new HBox(lemonName, lemonPrice, lemonStock);
		blackChange = new HBox(blackName, blackPrice, blackStock);
		appleChange = new HBox(appleName, applePrice, appleStock);
		honeyChange = new HBox(honeyName, honeyPrice, honeyStock);
		milkChange = new HBox(milkName, milkPrice, milkStock);
		
		//tea descriptions boxes
		descL = new TextArea(Main.items.get(0).getDesc());
		descB = new TextArea(Main.items.get(1).getDesc());
		descA = new TextArea(Main.items.get(2).getDesc());
		descH = new TextArea(Main.items.get(3).getDesc());
		descM = new TextArea(Main.items.get(4).getDesc());
		
		descLabel1 = new Label("Description");
		descLabel2 = new Label("Description");
		descLabel3 = new Label("Description");
		descLabel4 = new Label("Description");
		descLabel5 = new Label("Description");
		
		lemonDesc =  new VBox(descLabel1, descL);
		blackDesc =  new VBox(descLabel2, descB);
		appleDesc =  new VBox(descLabel3, descA);
		honeyDesc =  new VBox(descLabel4, descH);
		milkDesc =  new VBox(descLabel5, descM);
		
		//tea save buttons
		lemonSave = new Button("Save Changes");
		blackSave = new Button("Save Changes");
		appleSave = new Button("Save Changes");
		honeySave = new Button("Save Changes");
		milkSave = new Button("Save Changes");
		
		lb = new VBox(lemonSave);
		bb = new VBox(blackSave);
		ab = new VBox(appleSave);
		hb = new VBox(honeySave);
		mb = new VBox(milkSave);
		
		//right side boxes
		lemonBox = new VBox(lemonLabel, lemonChange, lemonDesc, lb);
		blackBox = new VBox(blackLabel, blackChange, blackDesc, bb);
		appleBox = new VBox(appleLabel, appleChange, appleDesc, ab);
		honeyBox = new VBox(honeyLabel, honeyChange, honeyDesc, hb);
		milkBox = new VBox(milkLabel, milkChange, milkDesc, mb);
		
		//image & right combined
		lemonHBox = new HBox(lemonImage, lemonBox);
		blackHBox = new HBox(blackImage, blackBox);
		appleHBox = new HBox(appleImage, appleBox);
		honeyHBox = new HBox(honeyImage, honeyBox);
		milkHBox = new HBox(milkImage, milkBox);
		
		logout = new Button("Logout");
		logBox = new VBox(logout);
		
		vbox = new VBox();
		box = new VBox(10, manageLabel, sp, logBox);
		
		sp.setContent(vbox);
		vbox.getChildren().addAll(lemonHBox, blackHBox, appleHBox, honeyHBox, milkHBox);
		
		gp.getChildren().addAll(box);
		
		logout.setOnAction(e->{
			new Login(stage);
		});
		
		lemonImage.setOnMouseClicked(e -> {
		    Button zoomIn = new Button("Zoom In");
		    Button zoomOut = new Button("Zoom Out");
		    Button rLeft = new Button("Rotate Left");
		    Button rRight = new Button("Rotate Right");
	
		    HBox buttonBox = new HBox(zoomIn, zoomOut, rLeft, rRight);
		    buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		    buttonBox.setSpacing(10);

		    StackPane stackPane = new StackPane();
		    stackPane.getChildren().addAll(lemonImage2, buttonBox);
		    stackPane.setPadding(new Insets(10, 10, 10, 10));
		    StackPane.setAlignment(buttonBox, Pos.TOP_CENTER);

		    Scene sideScene = new Scene(stackPane, 450, 400);
		    lemonImage2.setFitWidth(250);
			lemonImage2.setPreserveRatio(true);
			
		    Stage sideStage = new Stage();
		    sideStage.setAlwaysOnTop(true);
		    sideStage.getIcons().add(icon);
		    sideStage.setScene(sideScene);
		    sideStage.setTitle("Image Preview");
		    sideStage.show();
		    
		    zoomIn.setOnAction(event -> {
		        lemonImage2.setFitWidth(lemonImage2.getFitWidth() * 1.2);
		    });

		    zoomOut.setOnAction(event -> {
		    	lemonImage2.setFitWidth(lemonImage2.getFitWidth() * 0.8);
		    });

		    rLeft.setOnAction(event -> {
		        lemonImage2.setRotate(lemonImage2.getRotate() - 90);
		    });

		    rRight.setOnAction(event -> {
		        lemonImage2.setRotate(lemonImage2.getRotate() + 90);
		    });
		});
		
		lemonSave.setOnAction(e->{
			String name = nameL.getText();
			String priceCheck = priceL.getText();
			int stock = lemonS.getValue();
			String desc = descL.getText();
			
			if(validation(name, priceCheck, stock, desc)) {
				float price = Float.parseFloat(priceCheck);
				Main.items.set(0, new Item(name, price, stock, desc));
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Updated");
				alert.setHeaderText(null);
				alert.setContentText("Item has been updated");
				alert.showAndWait();
				new Admin(stage);
			}
			else
			{
				new Admin(stage);
			}
		});
		
		blackImage.setOnMouseClicked(e -> {
		    Button zoomIn = new Button("Zoom In");
		    Button zoomOut = new Button("Zoom Out");
		    Button rLeft = new Button("Rotate Left");
		    Button rRight = new Button("Rotate Right");
	
		    HBox buttonBox = new HBox(zoomIn, zoomOut, rLeft, rRight);
		    buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		    buttonBox.setSpacing(10);

		    StackPane stackPane = new StackPane();
		    stackPane.getChildren().addAll(blackImage2, buttonBox);
		    stackPane.setPadding(new Insets(10, 10, 10, 10));
		    StackPane.setAlignment(buttonBox, Pos.TOP_CENTER);

		    Scene sideScene = new Scene(stackPane, 450, 400);
		    blackImage2.setFitWidth(250);
			blackImage2.setPreserveRatio(true);

		    Stage sideStage = new Stage();
		    sideStage.setAlwaysOnTop(true);
		    sideStage.getIcons().add(icon);
		    sideStage.setScene(sideScene);
		    sideStage.setTitle("Image Preview");
		    sideStage.show();
		    
		    zoomIn.setOnAction(event -> {
		        blackImage2.setFitWidth(blackImage2.getFitWidth() * 1.2);
		    });

		    zoomOut.setOnAction(event -> {
		    	blackImage2.setFitWidth(blackImage2.getFitWidth() * 0.8);
		    });

		    rLeft.setOnAction(event -> {
		        blackImage2.setRotate(blackImage2.getRotate() - 90);
		    });

		    rRight.setOnAction(event -> {
		        blackImage2.setRotate(blackImage2.getRotate() + 90);
		    });
		});
		
		blackSave.setOnAction(e->{
			String name = nameB.getText();
			String priceCheck = priceB.getText();
			int stock = blackS.getValue();
			String desc = descB.getText();
			
			if(validation(name, priceCheck, stock, desc)) {
				float price = Float.parseFloat(priceCheck);
				Main.items.set(1, new Item(name, price, stock, desc));
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Updated");
				alert.setHeaderText(null);
				alert.setContentText("Item has been updated");
				alert.showAndWait();
				new Admin(stage);
			}
			else
			{
				new Admin(stage);
			}
		});
		
		appleImage.setOnMouseClicked(e -> {
		    Button zoomIn = new Button("Zoom In");
		    Button zoomOut = new Button("Zoom Out");
		    Button rLeft = new Button("Rotate Left");
		    Button rRight = new Button("Rotate Right");
	
		    HBox buttonBox = new HBox(zoomIn, zoomOut, rLeft, rRight);
		    buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		    buttonBox.setSpacing(10);

		    StackPane stackPane = new StackPane();
		    stackPane.getChildren().addAll(appleImage2, buttonBox);
		    stackPane.setPadding(new Insets(10, 10, 10, 10));
		    StackPane.setAlignment(buttonBox, Pos.TOP_CENTER);

		    Scene sideScene = new Scene(stackPane, 450, 400);
		    appleImage2.setFitWidth(250);
			appleImage2.setPreserveRatio(true);

		    Stage sideStage = new Stage();
		    sideStage.setAlwaysOnTop(true);
		    sideStage.getIcons().add(icon);
		    sideStage.setScene(sideScene);
		    sideStage.setTitle("Image Preview");
		    sideStage.show();
		    
		    zoomIn.setOnAction(event -> {
		        appleImage2.setFitWidth(appleImage2.getFitWidth() * 1.2);
		    });

		    zoomOut.setOnAction(event -> {
		    	appleImage2.setFitWidth(appleImage2.getFitWidth() * 0.8);
		    });

		    rLeft.setOnAction(event -> {
		        appleImage2.setRotate(appleImage2.getRotate() - 90);
		    });

		    rRight.setOnAction(event -> {
		        appleImage2.setRotate(appleImage2.getRotate() + 90);
		    });
		});
		
		appleSave.setOnAction(e->{
			String name = nameA.getText();
			String priceCheck = priceA.getText();
			int stock = appleS.getValue();
			String desc = descA.getText();
			
			if(validation(name, priceCheck, stock, desc)) {
				float price = Float.parseFloat(priceCheck);
				Main.items.set(2, new Item(name, price, stock, desc));
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Updated");
				alert.setHeaderText(null);
				alert.setContentText("Item has been updated");
				alert.showAndWait();
				new Admin(stage);
			}
			else
			{
				new Admin(stage);
			}
		});
		
		honeyImage.setOnMouseClicked(e -> {
		    Button zoomIn = new Button("Zoom In");
		    Button zoomOut = new Button("Zoom Out");
		    Button rLeft = new Button("Rotate Left");
		    Button rRight = new Button("Rotate Right");
	
		    HBox buttonBox = new HBox(zoomIn, zoomOut, rLeft, rRight);
		    buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		    buttonBox.setSpacing(10);

		    StackPane stackPane = new StackPane();
		    stackPane.getChildren().addAll(honeyImage2, buttonBox);
		    stackPane.setPadding(new Insets(10, 10, 10, 10));
		    StackPane.setAlignment(buttonBox, Pos.TOP_CENTER);

		    Scene sideScene = new Scene(stackPane, 450, 400);
		    honeyImage2.setFitWidth(250);
			honeyImage2.setPreserveRatio(true);

		    Stage sideStage = new Stage();
		    sideStage.setAlwaysOnTop(true);
		    sideStage.getIcons().add(icon);
		    sideStage.setScene(sideScene);
		    sideStage.setTitle("Image Preview");
		    sideStage.show();
		    
		    zoomIn.setOnAction(event -> {
		        honeyImage2.setFitWidth(honeyImage2.getFitWidth() * 1.2);
		    });

		    zoomOut.setOnAction(event -> {
		    	honeyImage2.setFitWidth(honeyImage2.getFitWidth() * 0.8);
		    });

		    rLeft.setOnAction(event -> {
		        honeyImage2.setRotate(honeyImage2.getRotate() - 90);
		    });

		    rRight.setOnAction(event -> {
		        honeyImage2.setRotate(honeyImage2.getRotate() + 90);
		    });
		});
		
		honeySave.setOnAction(e->{
			String name = nameH.getText();
			String priceCheck = priceH.getText();
			int stock = honeyS.getValue();
			String desc = descH.getText();
			
			if(validation(name, priceCheck, stock, desc)) {
				float price = Float.parseFloat(priceCheck);
				Main.items.set(3, new Item(name, price, stock, desc));
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Updated");
				alert.setHeaderText(null);
				alert.setContentText("Item has been updated");
				alert.showAndWait();
				new Admin(stage);
			}
			else
			{
				new Admin(stage);
			}
		});
		
		milkImage.setOnMouseClicked(e -> {
		    Button zoomIn = new Button("Zoom In");
		    Button zoomOut = new Button("Zoom Out");
		    Button rLeft = new Button("Rotate Left");
		    Button rRight = new Button("Rotate Right");
	
		    HBox buttonBox = new HBox(zoomIn, zoomOut, rLeft, rRight);
		    buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		    buttonBox.setSpacing(10);

		    StackPane stackPane = new StackPane();
		    stackPane.getChildren().addAll(milkImage2, buttonBox);
		    stackPane.setPadding(new Insets(10, 10, 10, 10));
		    StackPane.setAlignment(buttonBox, Pos.TOP_CENTER);

		    Scene sideScene = new Scene(stackPane, 450, 400);
		    milkImage2.setFitWidth(250);
			milkImage2.setPreserveRatio(true);

		    Stage sideStage = new Stage();
		    sideStage.setAlwaysOnTop(true);
		    sideStage.getIcons().add(icon);
		    sideStage.setScene(sideScene);
		    sideStage.setTitle("Image Preview");
		    sideStage.show();
		    
		    zoomIn.setOnAction(event -> {
		        milkImage2.setFitWidth(milkImage2.getFitWidth() * 1.2);
		    });

		    zoomOut.setOnAction(event -> {
		    	milkImage2.setFitWidth(milkImage2.getFitWidth() * 0.8);
		    });

		    rLeft.setOnAction(event -> {
		        milkImage2.setRotate(milkImage2.getRotate() - 90);
		    });

		    rRight.setOnAction(event -> {
		        milkImage2.setRotate(milkImage2.getRotate() + 90);
		    });
		});
		
		milkSave.setOnAction(e->{
			String name = nameM.getText();
			String priceCheck = priceM.getText();
			int stock = milkS.getValue();
			String desc = descM.getText();
			
			if(validation(name, priceCheck, stock, desc)) {
				float price = Float.parseFloat(priceCheck);
				Main.items.set(4, new Item(name, price, stock, desc));
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Updated");
				alert.setHeaderText(null);
				alert.setContentText("Item has been updated");
				alert.showAndWait();
				new Admin(stage);
			}
			else
			{
				new Admin(stage);
			}
		});
	}
	
	private void layout() {
		bp.setCenter(gp);
		
		gp.setAlignment(Pos.CENTER);
		box.setAlignment(Pos.CENTER);
		logBox.setAlignment(Pos.CENTER_RIGHT);
		
		lb.setAlignment(Pos.BOTTOM_RIGHT);
		bb.setAlignment(Pos.BOTTOM_RIGHT);
		ab.setAlignment(Pos.BOTTOM_RIGHT);
		hb.setAlignment(Pos.BOTTOM_RIGHT);
		mb.setAlignment(Pos.BOTTOM_RIGHT);
		
		vbox.setPrefWidth(725);
		sp.setFitToWidth(true);
		
		lemonImage.setFitWidth(200);
		lemonImage.setPreserveRatio(true);
		blackImage.setFitWidth(200);
		blackImage.setPreserveRatio(true);
		appleImage.setFitWidth(200);
		appleImage.setPreserveRatio(true);
		honeyImage.setFitWidth(200);
		honeyImage.setPreserveRatio(true);
		milkImage.setFitWidth(200);
		milkImage.setPreserveRatio(true);
		
		descL.setWrapText(true);
		descB.setWrapText(true);
		descA.setWrapText(true);
		descH.setWrapText(true);
		descM.setWrapText(true);
		
		descL.setPrefRowCount(3);
		descB.setPrefRowCount(3);
		descA.setPrefRowCount(3);
		descH.setPrefRowCount(3);
		descM.setPrefRowCount(3);
		
		descL.setPrefHeight(60);
		descB.setPrefHeight(60);
		descA.setPrefHeight(60);
		descH.setPrefHeight(60);
		descM.setPrefHeight(60);
		
		lemonHBox.setSpacing(10);
		blackHBox.setSpacing(10);
		appleHBox.setSpacing(10);
		honeyHBox.setSpacing(10);
		milkHBox.setSpacing(10);
		
		lemonBox.setSpacing(10);
		blackBox.setSpacing(10);
		appleBox.setSpacing(10);
		honeyBox.setSpacing(10);
		milkBox.setSpacing(10);
		
		lemonChange.setSpacing(10);
		blackChange.setSpacing(10);
		appleChange.setSpacing(10);
		honeyChange.setSpacing(10);
		milkChange.setSpacing(10);
		vbox.setSpacing(20);
		
		vbox.setPadding(new Insets(10, 10, 10, 10));
		box.setPadding(new Insets(10, 0, 10, 0));
	}
	
	private void css() {
		manageLabel.setStyle("-fx-font-size: 24px;");
		lemonLabel.setStyle("-fx-font-size: 20px;");
		blackLabel.setStyle("-fx-font-size: 20px;");
		appleLabel.setStyle("-fx-font-size: 20px;");
		honeyLabel.setStyle("-fx-font-size: 20px;");
		milkLabel.setStyle("-fx-font-size: 20px;");
		
		logout.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		lemonSave.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		blackSave.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		appleSave.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		honeySave.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		milkSave.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
	}
	
	public void showAlert(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public boolean validation(String name, String priceCheck, int stock, String desc) {
		try {
			Float.parseFloat(priceCheck);
		} catch (NumberFormatException e) {
			showAlert("Error", "Price must be numeric");
			return false;
		}
		
		float price = Float.parseFloat(priceCheck);
		
		if(name.isEmpty()) {
			showAlert("Error", "Name must not be empty");
			return false;
		}
		else if(price < 10000)
		{
			showAlert("Error", "Price too low [>=10000]");
			return false;
		}
		else if(stock < 1)
		{
			showAlert("Error", "Stock too low [>=1]");
			return false;
		}
		else if(desc.length() < 10)
		{
			showAlert("Error", "Description too short [>=10]");
			return false;
		}
		return true;
	}
	
	public Admin(Stage stage) {
		init();
		layout();
		css();
		this.stage = stage;
		stage.setTitle("DTea Application");
		stage.setScene(scene);
		stage.show();
	}
}