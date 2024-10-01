package main;

import account.Account;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Register {

	Label regisLabel, emailLabel, passwordLabel, nameLabel, confirmLabel;
	TextField emailTextField, nameTextField;
	PasswordField passwordField,confirmField;
	Button regisButton;
	Hyperlink textLink;
	
	VBox emailBox, nameBox, passwordBox, confirmBox, boxes,  vbox;
	GridPane gp;
	BorderPane bp;
	Scene scene;
	Stage stage;
	
	public void init() {
		regisLabel = new Label("Register");
		emailLabel = new Label("Email");
		nameLabel = new Label("Name");
		passwordLabel = new Label("Password"); 
		confirmLabel = new Label("Confirm Password");
		
		emailTextField = new TextField();
		nameTextField = new TextField();
        passwordField = new PasswordField();
        confirmField = new PasswordField();
        
        emailBox = new VBox(emailLabel, emailTextField);
        nameBox = new VBox(nameLabel, nameTextField);
        passwordBox = new VBox(passwordLabel, passwordField);
        confirmBox = new VBox(confirmLabel, confirmField);
        boxes = new VBox(emailBox, nameBox, passwordBox, confirmBox);
        
        regisButton = new Button("Register");
        
        textLink = new Hyperlink("Already a Member? Login");
        
        gp = new GridPane();
        bp = new BorderPane();
        scene = new Scene(bp, 600, 600);
        
        vbox = new VBox();
        vbox.getChildren().addAll(regisLabel, boxes, regisButton, textLink);
        gp.getChildren().add(vbox);
        
        regisButton.setOnAction(e->{
        	String email = emailTextField.getText();
        	String name = nameTextField.getText();
        	String confpass = confirmField.getText();
        	String pw = passwordField.getText();
        	
        	if(email.equals("admin") && pw.equals("admin123")) {
        		new Admin(stage);
            }
        	else if(validation(email, name, pw, confpass)) {
        		Main.accounts.add(new Account(email, pw, name));
        		new Login(stage);
        	}
        });
        
        textLink.setOnAction(e->{
        	new Login(stage);
        });

	}
	
	public void layout() {
		bp.setCenter(gp);
		
		emailBox.setAlignment(Pos.TOP_LEFT);
		nameBox.setAlignment(Pos.TOP_LEFT);
        passwordBox.setAlignment(Pos.TOP_LEFT);
        confirmBox.setAlignment(Pos.TOP_LEFT);
        
        gp.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        
        boxes.setSpacing(10);
        vbox.setSpacing(25);
	}
	
	public void css() {
		emailTextField.setPrefWidth(200);
		emailTextField.setPrefHeight(35);
		
		nameTextField.setPrefWidth(200);
		nameTextField.setPrefHeight(35);
		
		passwordField.setPrefWidth(200);
		passwordField.setPrefHeight(35);
		
		confirmField.setPrefWidth(200);
		confirmField.setPrefHeight(35);
		
		regisLabel.setStyle("-fx-font-size: 24px;");
		regisButton.setPrefWidth(200);
        regisButton.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white; -fx-font-size: 16px;");
        
        GridPane.setFillWidth(regisButton, true);
        
        textLink.setStyle("-fx-font-color: DARKTURQUOISE;");
	}
	
	public void showAlert(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	public boolean validation(String email, String name, String pw, String confpass) {
		int count = 0;
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i) == '@') {
				count++;
			}
		}
		
		for(int i = 0; i < Main.accounts.size(); i++) {
			if(email.equals(Main.accounts.get(i).getEmail())) {
				showAlert("Error", "Email already registered");
				return false;
			}
		}
		
		if(email.isEmpty() || !email.endsWith(".com") || !email.contains("@") || count > 1) {
			showAlert("Error", "Invalid email");
			return false;
		}
		else if(name.isEmpty()) {
			showAlert("Error", "Name must be filled");
			return false;
		}

		else if(pw.isEmpty()) {
			showAlert("Error", "Invalid password");
			return false;
		}
		
		else if(confpass.isEmpty()) {
			showAlert("Error", "Confirm Password must be filled");
			return false;
		}
		
		else if(!pw.equals(confpass)) {
			showAlert("Error", "Password does not match");
			return false;
		}
		return true;
	}
	
	public Register(Stage stage) {
		init();
		layout();
		css();
		this.stage = stage;
		stage.setTitle("DTea Application");
		stage.setScene(scene);
		stage.show();
	}
}
