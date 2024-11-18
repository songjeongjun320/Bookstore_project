package controllers;


import javafx.scene.image.Image;

public class Book {
    private String title;       // 책 제목
    private String author;      // 작가 이름
    private Image coverImage;   // 책 커버 이미지

    // 생성자
    public Book(String title, String author, String imagePath) {
        this.title = title;
        this.author = author;
        this.coverImage = new Image(imagePath); // 이미지 경로를 받아서 Image 객체 생성
    }

    // Getter와 Setter 메서드
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Image getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String imagePath) {
        this.coverImage = new Image(imagePath); // 새로운 이미지 경로 설정
    }
}
