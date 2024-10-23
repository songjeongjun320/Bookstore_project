package src.backend;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class Prototype extends Application
{
	//Currently set to local until I figure out a good solution to not leak my IP address
	static final String dbURL = "jdbc:postgresql://localhost:5432/postgres";
	static final String user = "postgres";
	static final String pass = "J@mescube70";
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception
	{
		Connection conn = DriverManager.getConnection(dbURL, user, pass);
		Statement stmt = conn.createStatement();
		PasswordField passField = new PasswordField();
		TextField usernameField = new TextField();
		Label d = new Label();
		
		GridPane grid = new GridPane();
		grid.add(usernameField, 1,1);
		grid.add(passField, 1,2);
		Scene scene = new Scene(grid, 220, 220);
		window.setResizable(false);
		window.setTitle("Prototype");
		window.setScene(scene);
		window.show();
		
		try
		{  
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
			
			while(rs.next())
			{
				String username = rs.getString("username");
				String password = rs.getString("password");
				d.setText(d.getText() + username + " " + password + "\n");
			}
			
			GridPane grid2  = new GridPane();
			grid2.add(d, 0, 0);
	        Scene scene2 = new Scene(grid2, 630, 400);
	        Stage stage = new Stage();
	        stage.setTitle("Database");
	        stage.setScene(scene2);
	        stage.show();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		passField.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) 
			{
				try
				{
					stmt.executeUpdate(
							"INSERT INTO users (username, password) " +
							"VALUES ('" + usernameField.getText() + "', '" + passField.getText() + "');");
					ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
					
					d.setText("");
					while(rs.next())
					{
						String username = rs.getString("username");
						String password = rs.getString("password");
						d.setText(d.getText() + username + " " + password + "\n");
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		});
	}
}
