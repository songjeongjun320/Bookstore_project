package controllers.Main_Pages_Controllers;

import controllers.Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainPageLayout extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Top Navigation Bar
        HBox topBar = new HBox(30);
        topBar.setPadding(new Insets(20));
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setStyle("-fx-background-color: #8b0000;");

        Label inboxLabel = new Label("Inbox");
        inboxLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");

        Label myAccountLabel = new Label("My account");
        myAccountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");

        topBar.getChildren().addAll(inboxLabel, myAccountLabel);

        // Fetch book data from files
        List<Book> books = getBooksFromImages("front_end/db");

        // GridPane for book sections
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(30); // Horizontal spacing between columns
        gridPane.setVgap(30); // Vertical spacing between rows
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #4a0f0f;"); // Darker inner background

        // Populate books into the grid
        int column = 0;
        int row = 0;
        for (Book book : books) {
            VBox bookSection = createBookSection(book);

            gridPane.add(bookSection, column, row); // Add book section to grid
            column++;

            // Move to the next row after 2 columns
            if (column == 2) {
                column = 0;
                row++;
            }
        }

        // ScrollPane for scrolling
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #4a0f0f;"); // Same dark inner background

        // Main Layout
        VBox mainLayout = new VBox(30, topBar, scrollPane);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setStyle("-fx-background-color: #8b0000;");

        // Scene and Stage
        Scene scene = new Scene(mainLayout, 1400, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Devil's Reads");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    /**
     * Creates a section for a book.
     */
    private VBox createBookSection(Book book) {
        ImageView bookImage = new ImageView(new Image("file:" + book.getImagePath()));
        bookImage.setFitWidth(150);
        bookImage.setFitHeight(200);

        VBox bookInfo = new VBox(10);
        bookInfo.setAlignment(Pos.CENTER_LEFT);
        bookInfo.setPadding(new Insets(20));
        bookInfo.setStyle("-fx-background-color: #d3d3d3; -fx-border-color: white; -fx-border-width: 2px;");
        bookInfo.getChildren().addAll(
                createLabel("Title: " + book.getTitle(), 18),
                createLabel("Author: " + book.getAuthor(), 18),
                createLabel("Seller: " + book.getSeller(), 18),
                createLabel("Condition: " + book.getCondition(), 18),
                createLabel("Date listed: " + book.getDate(), 18)
        );

        Button viewButton = new Button("VIEW BOOK");
        viewButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 16px;");
        viewButton.setPrefSize(150, 50);
        

        Button addToCartButton = new Button("ADD TO CART");
        addToCartButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 16px;");
        addToCartButton.setPrefSize(150, 50);

        VBox buttons = new VBox(20, viewButton, addToCartButton);
        buttons.setAlignment(Pos.CENTER);

        VBox bookSection = new VBox(20, bookImage, bookInfo, buttons);
        bookSection.setPadding(new Insets(20));
        bookSection.setAlignment(Pos.CENTER);
        bookSection.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ffcc00; -fx-border-width: 2px;");

        return bookSection;
    }

    /**
     * Reads books from image files in the specified folder.
     */
    private List<Book> getBooksFromImages(String folderPath) {
        List<Book> books = new ArrayList<>();
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder does not exist or is not valid: " + folderPath);
            return books;
        }

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".png")) {
                String fileName = file.getName().replace(".png", "");
                String[] parts = fileName.split("_");
                if (parts.length == 5) {
                    String title = parts[0].replace("_", " ");
                    String author = parts[1].replace("_", " ");
                    String seller = parts[2];
                    String condition = parts[3];
                    String date = parts[4];

                    books.add(new Book(title, author, seller, condition, date, file.getAbsolutePath()));
                } else {
                    System.out.println("Invalid file format: " + file.getName());
                }
            }
        }
        return books;
    }

    /**
     * Helper method to create labels with consistent styling.
     */
    private Label createLabel(String text, int fontSize) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: black;");
        return label;
    }

    /**
     * Inner class to hold book data.
     */
    static class Book {
        private final String title;
        private final String author;
        private final String seller;
        private final String condition;
        private final String date;
        private final String imagePath;

        public Book(String title, String author, String seller, String condition, String date, String imagePath) {
            this.title = title;
            this.author = author;
            this.seller = seller;
            this.condition = condition;
            this.date = date;
            this.imagePath = imagePath;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getSeller() {
            return seller;
        }

        public String getCondition() {
            return condition;
        }

        public String getDate() {
            return date;
        }

        public String getImagePath() {
            return imagePath;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}