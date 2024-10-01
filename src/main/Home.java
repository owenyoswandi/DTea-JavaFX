package main;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Home {
	Label lbl;
	Button btn;
	Stage stage;
	Scene scene;
	GridPane gp;
	BorderPane bp;
	Media media;
	MediaPlayer mp;
	MediaView mv;
	File file;
	VBox vbox;
	public void init() {
		gp = new GridPane();
		bp = new BorderPane();
		lbl = new Label("Welcome to DTea!");
		btn = new Button("Continue");
		scene = new Scene(bp, 750, 450);
		
		file = new File("video.mp4");
		media = new Media(file.toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaView(mp);
		
	    mv.setPreserveRatio(true);
		mp.setAutoPlay(true);
		mp.setOnEndOfMedia(() -> mp.seek(mp.getStartTime()));
		 
		vbox = new VBox();
		vbox.getChildren().addAll(lbl, mv, btn);
		
		gp.getChildren().add(vbox);
		
		btn.setOnAction(e->{
			new Shop(stage);
		});
	}
	
	private void layout() {
		bp.setCenter(gp);
		
		gp.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		
		mv.setFitWidth(300);
	    mv.setPreserveRatio(true);
	    vbox.setSpacing(20);
	}
	
	public void css() {
		lbl.setStyle("-fx-font-size: 30px;");
		btn.setMaxWidth(mv.getFitWidth());
		btn.setPrefHeight(32);
        btn.setStyle("-fx-background-color: DARKTURQUOISE; -fx-text-fill: white; -fx-font-size: 16px;");
        
        GridPane.setFillWidth(btn, true);
	}
	
	public Home(Stage stage) {
		init();
		layout();
		css();
		this.stage = stage;
		stage.setTitle("DTea Application");
		stage.setScene(scene);
		stage.show();
	}
}
