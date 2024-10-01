package main;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Login {

	Image logo;
	File file;
	
	Label loginLabel, emailLabel, passwordLabel;
	TextField emailTextField;
	PasswordField passwordField;
	Button loginButton;
	Hyperlink textLink;
	
	VBox emailBox, passwordBox, vbox, boxes;
	GridPane gp;
	BorderPane bp;
	Scene scene;
	Stage stage;
	
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
        scene = new Scene(bp, 600, 600);
        file = new File("logo.png");
        logo = new Image(file.toURI().toString());
		
		loginLabel = new Label("Login");
		emailLabel = new Label("Email");
		passwordLabel = new Label("Password "); 
		
		emailTextField = new TextField();
        passwordField = new PasswordField();
        
        emailBox = new VBox(emailLabel, emailTextField);
        passwordBox = new VBox(passwordLabel, passwordField);
        boxes = new VBox(emailBox, passwordBox);
        
        loginButton = new Button("Login");
        
        textLink = new Hyperlink("Not a Member? Register");
        
        vbox = new VBox();
        vbox.getChildren().addAll(loginLabel, boxes, loginButton, textLink);
        
        gp.getChildren().add(vbox);
        
        loginButton.setOnAction(e->{
        	String email = emailTextField.getText();
        	String pw = passwordField.getText();
        	
        	if(email.equals("admin") && pw.equals("admin123")) {
        		new Admin(stage);
    		}
        	else if(validation(email, pw)) {
        		new Home(stage);
        	}
        });
        
        textLink.setOnAction(e->{
        	new Register(stage);
        });

	}
	
	public void layout() {
		bp.setCenter(gp);
		
		emailBox.setAlignment(Pos.TOP_LEFT);
        passwordBox.setAlignment(Pos.TOP_LEFT);
        
        gp.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        
        boxes.setSpacing(10);
        vbox.setSpacing(25);
	}
	
	public void css() {
		emailTextField.setPrefWidth(200);
		emailTextField.setPrefHeight(35);
		
		passwordField.setPrefWidth(200);
		passwordField.setPrefHeight(35);
		
		loginLabel.setStyle("-fx-font-size: 24px;");
		loginButton.setPrefWidth(200);
        loginButton.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white; -fx-font-size: 16px;");
        
        textLink.setStyle("-fx-font-color: DARKTURQUOISE;");
	}
	
	public boolean validation(String email, String pw) {
		for(int i = 0; i < Main.accounts.size(); i++) {
			if(email.equals(Main.accounts.get(i).getEmail()) && pw.equals(Main.accounts.get(i).getPw())) {
				return true;
			}
    	}
		showAlert("Error", "Email/Password Invalid");
		return false;
	}
	
	public void showAlert(String title, String msg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	public Login(Stage stage) {
		init();
		layout();
		css();
		this.stage = stage;
        stage.setScene(scene);
        stage.getIcons().add(logo);
        stage.setTitle("DTea Application");
        stage.show();
	}

}
