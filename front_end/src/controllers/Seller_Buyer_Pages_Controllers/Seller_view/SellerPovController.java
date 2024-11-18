package controllers.Seller_Buyer_Pages_Controllers.Seller_view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import controllers.Book; // Book 클래스 import
import controllers.Main;

public class SellerPovController extends Application {

    private HBox listedBooksRow; // Listed Books Row for dynamic book addition and deletion

    @Override
    public void start(Stage primaryStage) {
        // Main layout with red background
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #800000;");
        root.setPadding(new Insets(20)); // Padding around the layout

        // Create Home button (Right Top)
        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 14px;");
        homeButton.setOnAction(e -> Main.getInstance().showMainPage(primaryStage)); // Navigate to main pageze: 40px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Create a new HBox for title and Home button
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT); // Title starts on the left
        topBar.setSpacing(20);

        // Add a spacer to push the Home button to the right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); // Make the spacer grow to push the button

        // Add the title, spacer, and Home button to the HBox
        topBar.getChildren().addAll(spacer, homeButton);

        // Add the topBar to the BorderPane
        root.setTop(topBar);

        // Seller Info Section (Right)
        VBox sellerInfo = new VBox(20);
        sellerInfo.setAlignment(Pos.TOP_CENTER);
        sellerInfo.setPadding(new Insets(20));
        ImageView sellerImage = createImageView("file:/C:/Users/frank/Desktop/Bookstore_project/front_end/Images/seller.png", 300, 300);
        Label sellerName = new Label("@JUNSONG\nJun Song");
        sellerName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: white;");
        Label rating = new Label("⭐ ⭐ ⭐ ⭐ ⭐  5.0");
        rating.setStyle("-fx-font-size: 30px; -fx-text-fill: yellow;");

        Button editInfoButton = new Button("EDIT INFO");
        editInfoButton.setStyle("-fx-background-color: yellow; -fx-font-size: 20px; -fx-text-fill: black;");
        editInfoButton.setOnAction(event -> showEditPopup(sellerName));

        sellerInfo.getChildren().addAll(sellerImage, rating, sellerName, editInfoButton);

        // Listed Books Section
        listedBooksRow = createBooksRow(
            List.of(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "file:C:/Users/frank/Desktop/Bookstore_project/front_end/Images/book1.png"),
                new Book("1984", "George Orwell", "file:C:/Users/frank/Desktop/Bookstore_project/front_end/Images/book2.png")
            )
        );

        VBox listedBooks = new VBox(20);
        listedBooks.setAlignment(Pos.TOP_LEFT);
        listedBooks.setPadding(new Insets(20));
        Label listedBooksTitle = new Label("Your Listed Books");
        listedBooksTitle.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white;");
        listedBooks.getChildren().addAll(listedBooksTitle, listedBooksRow);

        // Sold Books Section
        VBox soldBooks = createBooksSection(
            "Your Sold Books",
            List.of(
                new Book("Book 3", "Author 3", "file:C:/Users/frank/Desktop/Bookstore_project/front_end/Images/book3.png"),
                new Book("Book 4", "Author 4", "file:C:/Users/frank/Desktop/Bookstore_project/front_end/Images/book4.png")
            )
        );

        // Left Section
        VBox leftSection = new VBox(20, listedBooks, soldBooks);
        leftSection.setAlignment(Pos.TOP_LEFT);
        leftSection.setPadding(new Insets(10));

        // Bottom Buttons Section
        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(20));

        Button listBookButton = new Button("LIST A BOOK");
        Button deleteBookButton = new Button("DELETE A BOOK");

        listBookButton.setStyle("-fx-background-color: yellow; -fx-font-size: 16px; -fx-text-fill: black;");
        deleteBookButton.setStyle("-fx-background-color: yellow; -fx-font-size: 16px; -fx-text-fill: black;");

        // Add action to the "LIST A BOOK" button
        listBookButton.setOnAction(e -> {
            Stage popupStage = new Stage();
            popupStage.setTitle("Add New Book");

            VBox popupLayout = new VBox(10);
            popupLayout.setPadding(new Insets(20));
            popupLayout.setAlignment(Pos.CENTER);

            Label titleLabel = new Label("Enter Book Title:");
            TextField titleField = new TextField();
            titleField.setPromptText("Book Title");

            Label authorLabel = new Label("Enter Author Name:");
            TextField authorField = new TextField();
            authorField.setPromptText("Author Name");

            Label imageLabel = new Label("Enter Image Path:");
            TextField imagePathField = new TextField();
            imagePathField.setPromptText("Image Path (file:C:/...)");

            Button addButton = new Button("Add Book");
            addButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

            addButton.setOnAction(event -> {
                String titleText = titleField.getText().trim();
                String authorText = authorField.getText().trim();
                String imagePath = imagePathField.getText().trim();

                if (!titleText.isEmpty() && !authorText.isEmpty() && !imagePath.isEmpty()) {
                    // Add new book to the listedBooksRow
                    Book newBook = new Book(titleText, authorText, imagePath);
                    ImageView bookImageView = new ImageView(newBook.getCoverImage());
                    bookImageView.setFitWidth(160);
                    bookImageView.setFitHeight(200);
                    listedBooksRow.getChildren().add(bookImageView);

                    popupStage.close(); // Close the popup
                }
            });

            popupLayout.getChildren().addAll(titleLabel, titleField, authorLabel, authorField, imageLabel, imagePathField, addButton);
            Scene popupScene = new Scene(popupLayout, 400, 300);
            popupStage.setScene(popupScene);
            popupStage.show();
        });

        // Add action to the "DELETE A BOOK" button
        deleteBookButton.setOnAction(e -> {
            if (!listedBooksRow.getChildren().isEmpty()) {
                listedBooksRow.getChildren().remove(listedBooksRow.getChildren().size() - 1);
            }
        });

        buttons.getChildren().addAll(listBookButton, deleteBookButton);

        root.setLeft(leftSection);
        root.setRight(sellerInfo);
        root.setBottom(buttons);

        // Scene setup
        Scene scene = new Scene(root, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Seller Page View");
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    // Utility method to create an HBox from a list of books
    private HBox createBooksRow(List<Book> books) {
        HBox booksRow = new HBox(30); // 30 pixels of horizontal spacing
        booksRow.setAlignment(Pos.CENTER_LEFT);
        books.forEach(book -> {
            ImageView bookImageView = new ImageView(book.getCoverImage());
            bookImageView.setFitWidth(160);
            bookImageView.setFitHeight(200);
            booksRow.getChildren().add(bookImageView);
        });
        return booksRow;
    }

    // Utility method to create a VBox for a book section
    private VBox createBooksSection(String sectionTitle, List<Book> books) {
        VBox booksSection = new VBox(20);
        booksSection.setAlignment(Pos.TOP_LEFT);
        booksSection.setPadding(new Insets(20));

        Label title = new Label(sectionTitle);
        title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: white;");

        HBox booksRow = createBooksRow(books);
        booksSection.getChildren().addAll(title, booksRow);

        return booksSection;
    }

    // Helper method to create an ImageView
    private ImageView createImageView(String imagePath, double width, double height) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }

    // Helper method to show an edit popup
    private void showEditPopup(Label sellerName) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Edit Seller Name");

        VBox popupLayout = new VBox(10);
        popupLayout.setPadding(new Insets(20));
        popupLayout.setAlignment(Pos.CENTER);

        Label instructionLabel = new Label("Enter new name:");
        instructionLabel.setStyle("-fx-font-size: 18px;");
        TextField nameInputField = new TextField();
        nameInputField.setPromptText("New name...");

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: green; -fx-font-size: 16px; -fx-text-fill: white;");
        saveButton.setOnAction(e -> {
            String newName = nameInputField.getText().trim();
            if (!newName.isEmpty()) {
                sellerName.setText(newName);
                popupStage.close();
            }
        });

        popupLayout.getChildren().addAll(instructionLabel, nameInputField, saveButton);
        Scene popupScene = new Scene(popupLayout, 300, 200);
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
