package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
// --------------- LOGIN PAGE --------------- //
			GridPane loginPane = new GridPane();
			loginPane.setAlignment(Pos.CENTER);
			loginPane.setPadding(new Insets(10,10,10,10));
			loginPane.setVgap(10);
			loginPane.setHgap(10);
			
			Text textHeader = new Text("Halaman Login");
			textHeader.setFont(Font.font("System", FontWeight.NORMAL, 20));
			GridPane.setConstraints(textHeader, 0, 0, 2, 1);
			
			Label userLabel = new Label("Username:");
			GridPane.setConstraints(userLabel, 0, 1);
			TextField userInput = new TextField();
			userInput.setPromptText("ex: faiKeren123");
			GridPane.setConstraints(userInput, 1, 1);
			
			Label passwordLabel = new Label("Password :");
			GridPane.setConstraints(passwordLabel, 0, 2);
			PasswordField passwordInput = new PasswordField();
			GridPane.setConstraints(passwordInput, 1, 2);
			
			Button loginButton = new Button("Sign in");
	        HBox hbLoginBtn = new HBox(10);
	        hbLoginBtn.setAlignment(Pos.BOTTOM_RIGHT);
	        hbLoginBtn.getChildren().add(loginButton);
	        GridPane.setConstraints(hbLoginBtn, 1, 3);
	        
			Text messageText = new Text();
			messageText.setFill(Color.RED);
	        GridPane.setConstraints(messageText, 1, 4);
	        
	        Scene loginScene = new Scene(loginPane,400,400);
	        loginPane.getChildren().addAll(textHeader, userLabel, userInput, passwordLabel, passwordInput, hbLoginBtn, messageText);
// ------------------------------------------ //

// --------------- HOME PAGE ---------------- //
	        GridPane homePane = new GridPane();
			homePane.setAlignment(Pos.CENTER);
			homePane.setPadding(new Insets(10,10,10,10));
			homePane.setVgap(10);
			homePane.setHgap(10);
			
	        Text homeText = new Text();
	        homeText.setFont(Font.font("System", FontWeight.NORMAL, 20));
	        GridPane.setConstraints(homeText, 0, 0);
	        
	        Button logOutButton = new Button("Log out");
	        HBox hbLogOutbtn = new HBox(10);
	        hbLogOutbtn.setAlignment(Pos.BOTTOM_RIGHT);
	        hbLogOutbtn.getChildren().add(logOutButton);
	        GridPane.setConstraints(hbLogOutbtn, 0, 1);
	        
	        Scene homeScene = new Scene(homePane,400,400);
	        homePane.getChildren().addAll(homeText, hbLogOutbtn);
// ------------------------------------------ //
	        
// --------------- BUTTON ------------------- //
	        loginButton.setOnAction(e -> {
	            String username = userInput.getText();
	            String password = passwordInput.getText();

	            if ("user".equals(username) && "pass".equals(password)) {
	            	homeText.setText("halo " + userInput.getText());
	                primaryStage.setScene(homeScene);
	            } else {
	                messageText.setText("User atau Password salah");
	            }
	        });
	        
	        logOutButton.setOnAction(e -> {
	        	passwordInput.clear();
	        	primaryStage.setScene(loginScene);
	        });
// ------------------------------------------ //
	        
			loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(loginScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
