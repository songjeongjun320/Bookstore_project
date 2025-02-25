package controllers.Main_Pages_Controllers;

import controllers.Account_Pages_Controllers.UserProfileView;
import controllers.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainPageLayout extends Application {

    private List<Book> allBooks; // To store all books
    private GridPane gridPane;  // To dynamically update book sections
    private TextField searchField; // For search functionality
    private List<CheckBox> categoryCheckBoxes; // Category filter checkboxes

    @Override
    public void start(Stage primaryStage) {
        // Top Navigation Bar
        HBox topBar = new HBox(30);
        topBar.setPadding(new Insets(20));
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setStyle("-fx-background-color: #8b0000;");

        // Add My Account Button
        Label myAccountLabel = new Label("My Account");
        myAccountLabel.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-weight: bold;");
        myAccountLabel.setOnMouseClicked(e -> {
            UserProfileView userProfileView = new UserProfileView(primaryStage);
            userProfileView.show();
        });

        topBar.getChildren().addAll(myAccountLabel);

        // Fetch book data from files
        allBooks = getBooksFromImages("front_end/db");

        // Search Field
        searchField = new TextField();
        searchField.setPromptText("Search by title...");
        searchField.setPrefWidth(300);
        searchField.setStyle("-fx-font-size: 16px;");

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        searchButton.setOnAction(e -> updateBooks());

        HBox searchBox = new HBox(10, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setPadding(new Insets(20));

        // Category Checkboxes
        String[] categories = {"SCIENCE", "BUSINESS", "INVESTMENT", "POLITICS", "PHILOSOPHY", "SPORTS"};
        categoryCheckBoxes = new ArrayList<>();

        for (String category : categories) {
            CheckBox checkBox = new CheckBox(category);
            checkBox.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");
            categoryCheckBoxes.add(checkBox);
        }

        Button filterButton = new Button("Filter");
        filterButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold;");
        filterButton.setOnAction(e -> updateBooks());

        // Use HBox for horizontal alignment
        HBox categoryBox = new HBox(15); // Horizontal spacing between checkboxes
        categoryBox.getChildren().addAll(categoryCheckBoxes);
        categoryBox.getChildren().add(filterButton);
        categoryBox.setAlignment(Pos.CENTER_LEFT);
        categoryBox.setPadding(new Insets(20));

        // GridPane for book sections
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(30); // Horizontal spacing between columns
        gridPane.setVgap(30); // Vertical spacing between rows
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #4a0f0f;"); // Darker inner background

        // Populate initial books
        updateBooks();

        // ScrollPane for scrolling
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #4a0f0f;"); // Same dark inner background

        // Main Layout
        VBox mainLayout = new VBox(20, topBar, searchBox, categoryBox, scrollPane);
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
     * Updates the gridPane with filtered books based on search and selected categories.
     */
    private void updateBooks() {
        String searchText = searchField.getText().toLowerCase();

        List<String> selectedCategories = categoryCheckBoxes.stream()
                .filter(CheckBox::isSelected)
                .map(CheckBox::getText)
                .collect(Collectors.toList());

        List<Book> filteredBooks = allBooks.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(searchText)) // Filter by search
                .filter(book -> selectedCategories.isEmpty() || selectedCategories.contains(book.getCategory())) // Filter by category
                .collect(Collectors.toList());

        // Clear and repopulate gridPane
        gridPane.getChildren().clear();

        int column = 0;
        int row = 0;
        for (Book book : filteredBooks) {
            VBox bookSection = createBookSection(book);

            gridPane.add(bookSection, column, row); // Add book section to grid
            column++;

            // Move to the next row after 2 columns
            if (column == 2) {
                column = 0;
                row++;
            }
        }
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
                createLabel("Date listed: " + book.getDate(), 18),
                createLabel("Category: " + book.getCategory(), 18),
                createLabel("Price: " + book.getPrice(), 18)
        );

        Button addButton = new Button("Add Cart");
        addButton.setStyle("-fx-background-color: #ffcc00; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 16px;");
        addButton.setPrefSize(150, 50);
        Stage newstage = new Stage();
        addButton.setOnAction(e -> {
            Main.getInstance().showBuyingPage(newstage);  // Call Main to switch to Recovery page
        });

        VBox buttons = new VBox(20, addButton);
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
            if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {
                String fileName = file.getName().replace(".png", "");
                String[] parts = fileName.split("_");
                if (parts.length >= 6) { // Ensure 6 fields in the file name
                    String title = parts[0].replace("_", " ");
                    String author = parts[1].replace("_", " ");
                    String seller = parts[2];
                    String condition = parts[3];
                    String date = parts[4];
                    String category = parts[5];
                    String price = parts[6];

                    books.add(new Book(title, author, seller, condition, date, category, price, file.getAbsolutePath()));
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
        private final String category;
        private final String imagePath;
        private final String price;

        public Book(String title, String author, String seller, String condition, String date, String category, String price, String imagePath) {
            this.title = title;
            this.author = author;
            this.seller = seller;
            this.condition = condition;
            this.date = date;
            this.category = category;
            this.price = price;
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

        public String getCategory() {
            return category;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
