package main;

import java.io.File;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Shop {
	ObservableList<String> cartItems = FXCollections.observableArrayList();

	Image lemon, black, apple, honey, milk, icon;
	ImageView lemonImage, blackImage, appleImage, honeyImage, milkImage;
	ImageView lemonImage2, blackImage2, appleImage2, honeyImage2, milkImage2;
	
	Media media;
	MediaPlayer musicPlayer;
	MediaView mv;
	
	File fileLemon, fileBlack, fileApple, fileHoney, fileMilk, musicFile, file;
	
	DataFormat itemNameFormat = Main.ITEM_NAME;
    DataFormat itemPriceFormat = Main.ITEM_PRICE;
	
	Scene scene;
	GridPane gp;
	BorderPane bp;
	ScrollPane sp;
	Stage stage;
	
	Label teaLabel, cartLabel, lemonLabel, blackLabel, appleLabel, honeyLabel, milkLabel;
	Label lemonPricelbl, blackPricelbl, applePricelbl, honeyPricelbl, milkPricelbl;
	Label lemonStocklbl, blackStocklbl, appleStocklbl, honeyStocklbl, milkStocklbl;
	Label lemonDesclbl, blackDesclbl, appleDesclbl, honeyDesclbl, milkDesclbl;
	
	Button logout, purchase;
	
	VBox vbox, box, temp, allBox, purchaseBox, logBox, vboxfill, lemonBox, blackBox, appleBox, honeyBox, milkBox;
	VBox lemonInfo, blackInfo, appleInfo, honeyInfo, milkInfo;
	HBox buyBox, combBox1, combBox2, combBox3;
	
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
		
		temp = new VBox();
		
		//tea name
		teaLabel = new Label("Enjoy our tea");
		lemonLabel = new Label(Main.items.get(0).getName());
		blackLabel = new Label(Main.items.get(1).getName());
		appleLabel = new Label(Main.items.get(2).getName());
		honeyLabel = new Label(Main.items.get(3).getName());
		milkLabel = new Label(Main.items.get(4).getName());
		
		//tea price
		lemonPricelbl = new Label("Price: Rp " + String.format("%.2f", Main.items.get(0).getPrice()));
		blackPricelbl = new Label("Price: Rp " + String.format("%.2f", Main.items.get(1).getPrice()));
		applePricelbl = new Label("Price: Rp " + String.format("%.2f", Main.items.get(2).getPrice()));
		honeyPricelbl = new Label("Price: Rp " + String.format("%.2f", Main.items.get(3).getPrice()));
		milkPricelbl = new Label("Price: Rp " + String.format("%.2f", Main.items.get(4).getPrice()));
		
		//tea stock
		lemonStocklbl = new Label("Stock: " + Main.items.get(0).getStock());
		blackStocklbl = new Label("Stock: " + Main.items.get(1).getStock());
		appleStocklbl = new Label("Stock: " + Main.items.get(2).getStock());
		honeyStocklbl = new Label("Stock: " + Main.items.get(3).getStock());
		milkStocklbl = new Label("Stock: " + Main.items.get(4).getStock());
		
		//tea descriptions
		lemonDesclbl = new Label(Main.items.get(0).getDesc());
		blackDesclbl = new Label(Main.items.get(1).getDesc());
		appleDesclbl = new Label(Main.items.get(2).getDesc());
		honeyDesclbl = new Label(Main.items.get(3).getDesc());
		milkDesclbl = new Label(Main.items.get(4).getDesc());
		
		lemonInfo = new VBox(lemonPricelbl, lemonStocklbl);
		blackInfo = new VBox(blackPricelbl, blackStocklbl);
		appleInfo = new VBox(applePricelbl, appleStocklbl);
		honeyInfo = new VBox(honeyPricelbl, honeyStocklbl);
		milkInfo = new VBox(milkPricelbl, milkStocklbl);
		
		lemonBox = new VBox(lemonImage, lemonLabel, lemonInfo, lemonDesclbl);
		blackBox = new VBox(blackImage, blackLabel, blackInfo, blackDesclbl);
		appleBox = new VBox(appleImage, appleLabel, appleInfo, appleDesclbl);
		honeyBox = new VBox(honeyImage, honeyLabel, honeyInfo, honeyDesclbl);
		milkBox = new VBox(milkImage, milkLabel, milkInfo, milkDesclbl);
		
		combBox1 = new HBox(lemonBox, blackBox);
		combBox2 = new HBox(appleBox, honeyBox);
		combBox3 = new HBox(milkBox, temp);
		
		vbox = new VBox(combBox1, combBox2, combBox3);
		
		logout = new Button("Logout");
		logBox = new VBox(logout);
		
		cartLabel = new Label("Your Cart");
		purchase = new Button("Purchase");
		purchaseBox = new VBox(purchase);
		vboxfill = new VBox();
		box = new VBox(cartLabel, vboxfill, purchaseBox);
		
		sp.setContent(vbox);
		
		buyBox = new HBox(sp, box);
		allBox = new VBox(10, teaLabel, buyBox, logBox);
		
		gp.getChildren().add(allBox);
		
		lemonImage.setOnDragDetected(e -> {
			if (Main.items.get(0).getStock() > 0 && !cartItems.contains(Main.items.get(0).getName())) {
		        Dragboard db = lemonImage.startDragAndDrop(TransferMode.COPY);
		        ClipboardContent content = new ClipboardContent();

		        content.putImage(lemonImage.getImage());
		        content.put(itemNameFormat, Main.items.get(0).getName());
		        content.put(itemPriceFormat, "Price: Rp " + String.format("%.2f", Main.items.get(0).getPrice()));

		        db.setContent(content);
		    }
			else if(Main.items.get(0).getStock() == 0){
				showAlert("Error", "Item is empty");
			}
			else {
				showAlert("Error", "Item is already in the cart");
			}
			e.consume();
	    });
		
		blackImage.setOnDragDetected(e -> {
			if (Main.items.get(1).getStock() > 0 && !cartItems.contains(Main.items.get(1).getName())) {
		        Dragboard db = blackImage.startDragAndDrop(TransferMode.COPY);
		        ClipboardContent content = new ClipboardContent();

		        content.putImage(blackImage.getImage());
		        content.put(itemNameFormat, Main.items.get(1).getName());
		        content.put(itemPriceFormat, "Price: Rp " + String.format("%.2f", Main.items.get(1).getPrice()));

		        db.setContent(content);
		    }
			else if(Main.items.get(1).getStock() == 0){
				showAlert("Error", "Item is empty");
			}
			else {
				showAlert("Error", "Item is already in the cart");
			}
			e.consume();
	    });
		
		appleImage.setOnDragDetected(e -> {
			if (Main.items.get(2).getStock() > 0 && !cartItems.contains(Main.items.get(2).getName())) {
		        Dragboard db = appleImage.startDragAndDrop(TransferMode.COPY);
		        ClipboardContent content = new ClipboardContent();

		        content.putImage(appleImage.getImage());
		        content.put(itemNameFormat, Main.items.get(2).getName());
		        content.put(itemPriceFormat, "Price: Rp " + String.format("%.2f", Main.items.get(2).getPrice()));

		        db.setContent(content);
		    }
			else if(Main.items.get(2).getStock() == 0){
				showAlert("Error", "Item is empty");
			}
			else {
				showAlert("Error", "Item is already in the cart");
			}
			e.consume();
	    });
		
		honeyImage.setOnDragDetected(e -> {
			if (Main.items.get(3).getStock() > 0 && !cartItems.contains(Main.items.get(3).getName())) {
		        Dragboard db = honeyImage.startDragAndDrop(TransferMode.COPY);
		        ClipboardContent content = new ClipboardContent();

		        content.putImage(honeyImage.getImage());
		        content.put(itemNameFormat, Main.items.get(3).getName());
		        content.put(itemPriceFormat, "Price: Rp " + String.format("%.2f", Main.items.get(3).getPrice()));

		        db.setContent(content);
		    }
			else if(Main.items.get(3).getStock() == 0){
				showAlert("Error", "Item is empty");
			}
			else {
				showAlert("Error", "Item is already in the cart");
			}
			e.consume();
	    });
		
		milkImage.setOnDragDetected(e -> {
			if (Main.items.get(4).getStock() > 0 && !cartItems.contains(Main.items.get(4).getName())) {
		        Dragboard db = milkImage.startDragAndDrop(TransferMode.COPY);
		        ClipboardContent content = new ClipboardContent();

		        content.putImage(milkImage.getImage());
		        content.put(itemNameFormat, Main.items.get(4).getName());
		        content.put(itemPriceFormat, "Price: Rp " + String.format("%.2f", Main.items.get(4).getPrice()));

		        db.setContent(content);
		    }
			else if(Main.items.get(4).getStock() == 0){
				showAlert("Error", "Item is empty");
			}
			else {
				showAlert("Error", "Item is already in the cart");
			}
			e.consume();
	    });
		
		box.setOnDragOver(e -> {
			if (e.getGestureSource() != box && e.getDragboard().hasImage()) {
				e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
			e.consume();
		});

		box.setOnDragDropped(e -> {
		    Dragboard db = e.getDragboard();
		    boolean success = false;
		    if (db.hasImage()
		        && db.hasContent(itemNameFormat)
		        && db.hasContent(itemPriceFormat)) {

		        String itemName = (String) db.getContent(itemNameFormat);
		        String itemPrice = (String) db.getContent(itemPriceFormat);

		        int itemIndex = -1;
		        for (int i = 0; i < Main.items.size(); i++) {
		            if (Main.items.get(i).getName().equals(itemName)) {
		                itemIndex = i;
		                break;
		            }
		        }
		        
		        if (itemIndex != -1 && Main.items.get(itemIndex).getStock() > 0 && !cartItems.contains(itemName)) {
		            Image image = db.getImage();

		            ImageView imageView = new ImageView(image);
		            imageView.setFitWidth(40);
		            imageView.setPreserveRatio(true);

		            Label nameLabel = new Label(itemName);
		            Label priceLabel = new Label(itemPrice);

		            VBox vbox = new VBox(nameLabel, priceLabel);
		            HBox hbox = new HBox(imageView, vbox);
		            
		            hbox.setSpacing(10);
		            nameLabel.setStyle("-fx-font-size: 15px;");
		            vboxfill.getChildren().addAll(hbox);
		            cartItems.add(itemName);

		            Main.items.get(itemIndex).setStock(Main.items.get(itemIndex).getStock() - 1);
		            success = true;
		            updateStockLabel(itemIndex);
		        }
		    }
		    e.setDropCompleted(success);
		    e.consume();
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
		
		purchase.setOnAction(e->{
			new Shop(stage);
		});
		
		logout.setOnAction(e->{
			restoreItemStock();
			musicPlaying.stop();
			new Login(stage);
		});
	}
	
	private void updateStockLabel(int itemIndex) {
	    Platform.runLater(() -> {
	        switch (itemIndex) {
	            case 0:
	                lemonStocklbl.setText("Stock: " + Main.items.get(itemIndex).getStock());
	                break;
	            case 1:
	                blackStocklbl.setText("Stock: " + Main.items.get(itemIndex).getStock());
	                break;
	            case 2:
	                appleStocklbl.setText("Stock: " + Main.items.get(itemIndex).getStock());
	                break;
	            case 3:
	                honeyStocklbl.setText("Stock: " + Main.items.get(itemIndex).getStock());
	                break;
	            case 4:
	                milkStocklbl.setText("Stock: " + Main.items.get(itemIndex).getStock());
	                break;
	            default:
	                break;
	        }
	    });
	}
	
	private void layout() {
		bp.setCenter(gp);
		gp.setAlignment(Pos.CENTER);
		allBox.setAlignment(Pos.CENTER);
		logBox.setAlignment(Pos.BOTTOM_RIGHT);
		buyBox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		box.setAlignment(Pos.CENTER);
		purchaseBox.setAlignment(Pos.BOTTOM_CENTER);
		
		sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		buyBox.setPrefWidth(725);
		vbox.setPrefWidth(450);
		vboxfill.setPrefHeight(400);
		purchase.setPrefWidth(300);
		sp.setPrefWidth(450);
		box.setPrefWidth(250);
		
		buyBox.setSpacing(10);
		vbox.setSpacing(10);
		vboxfill.setSpacing(10);
		
		combBox1.setSpacing(15);
		combBox2.setSpacing(15);
		combBox3.setSpacing(15);
		
		lemonBox.setPrefWidth(100);
		blackBox.setPrefWidth(100);
		appleBox.setPrefWidth(100);
		honeyBox.setPrefWidth(100);
		milkBox.setPrefWidth(100);
		
		lemonDesclbl.setWrapText(true);
		blackDesclbl.setWrapText(true);
		appleDesclbl.setWrapText(true);
		honeyDesclbl.setWrapText(true);
		milkDesclbl.setWrapText(true);
		
		lemonImage.setFitWidth(175);
		lemonImage.setPreserveRatio(true);
		blackImage.setFitWidth(175);
		blackImage.setPreserveRatio(true);
		appleImage.setFitWidth(175);
		appleImage.setPreserveRatio(true);
		honeyImage.setFitWidth(175);
		honeyImage.setPreserveRatio(true);
		milkImage.setFitWidth(175);
		milkImage.setPreserveRatio(true);
		
		allBox.setPadding(new Insets(10, 10, 10, 10));
		lemonBox.setPadding(new Insets(10, 10, 10, 10));
		blackBox.setPadding(new Insets(10, 10, 10, 10));
		appleBox.setPadding(new Insets(10, 10, 10, 10));
		honeyBox.setPadding(new Insets(10, 10, 10, 10));
		milkBox.setPadding(new Insets(10, 10, 10, 10));
		
		combBox1.setPadding(new Insets(10, 15, 0, 15));
		combBox2.setPadding(new Insets(10, 15, 0, 15));
		combBox3.setPadding(new Insets(10, 15, 0, 15));
		
		box.setPadding(new Insets(10, 10, 10, 10));
	}
	
	private void css() {
		teaLabel.setStyle("-fx-font-size: 24px;");
		lemonLabel.setStyle("-fx-font-size: 20px;");
		blackLabel.setStyle("-fx-font-size: 20px;");
		appleLabel.setStyle("-fx-font-size: 20px;");
		honeyLabel.setStyle("-fx-font-size: 20px;");
		milkLabel.setStyle("-fx-font-size: 20px;");
		cartLabel.setStyle("-fx-font-size: 20px;");
		
		box.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		lemonBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		blackBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		appleBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		honeyBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		milkBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-style: solid;");
		
		logout.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white;");
		purchase.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white; -fx-font-size: 14px;");
	}
	
	public void showAlert(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public void checkMethod() {
		if(musicPlaying.Playing())
			musicPlaying.initializeMediaPlayer();
    }
	
	private void restoreItemStock() {
		boolean state = false;
	    for (String itemName : cartItems) {
	        for (int i = 0; i < Main.items.size(); i++) {
	            if (Main.items.get(i).getName().equals(itemName)) {
	                Main.items.get(i).setStock(Main.items.get(i).getStock() + 1);
	                state = true;
	                break;
	            }
	        }
	    }
	    if(state) {
	    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Restored Item");
			alert.setHeaderText(null);
			alert.setContentText("Items that are not purchased have been restocked");
			alert.showAndWait();
	    }
	}
	
	public Shop(Stage stage) {
		init();
		layout();
		css();
		checkMethod();
		this.stage = stage;
		stage.setTitle("DTea Application");
		stage.setScene(scene);
		stage.show();
	}
}
