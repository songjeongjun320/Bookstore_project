# 📚 ASU Bookstore Web App

Welcome to the **ASU Bookstore Web App** project! This platform is designed to help **Arizona State University** students buy and sell textbooks with ease. The project highlights innovative solutions to challenges in book management and dynamic page navigation.

---

## 🛠 Project Overview

The **ASU Bookstore Web App** is a comprehensive platform that allows students to:

- Purchase textbooks conveniently.
- List and sell used textbooks with detailed information.
- Filter, search, and view books dynamically on a user-friendly interface.

---

## 🎯 Challenges and Solutions

### 1. **Branch Merging Conflicts**

- **Issue**: Merging changes from multiple branches resulted in conflicts, especially in the `src/controllers` folder.
- **Solution**:
  - Carefully resolved conflicts by reviewing changes manually.
  - Restored the latest stable version by resetting to the last functional commit.

### 2. **Dynamic Image-Based Metadata**

- **Issue**: Book data was initially inconsistent due to lack of structure in the database.
- **Solution**:
  - Implemented a naming convention for book images:  
    `Title_Author_Seller_Condition_Date_Category.png`.
  - Dynamically parsed metadata from image file names to populate the application.

### 3. **Page Navigation**

- **Issue**: Seamless navigation between pages was challenging, especially for book details.
- **Solution**:
  - Used `Main` as a **Singleton Controller** to manage navigation.
  - Dynamically created new `Stages` to load specific pages, such as the Book Detail Page.

### 4. **Filtering and Searching**

- **Issue**: Filtering books by category and searching by title required efficient UI and backend integration.
- **Solution**:
  - Added `CheckBox` components for category filters.
  - Implemented `TextField` for search functionality.
  - Integrated filtering and search to update the main book list dynamically.

### 5. **User-Friendly Interface**

- **Issue**: Creating a responsive and intuitive UI for both desktop and mobile.
- **Solution**:
  - Designed layouts using JavaFX components like `GridPane`, `VBox`, `HBox`, and `ScrollPane`.
  - Ensured books are displayed dynamically with clean transitions and responsive design.

---

## ✨ Key Features

### **📘 Dynamic Book Listings**

- Automatically loads books from the `db` folder, parsing metadata from file names.
- Displays book details (title, author, seller, condition, date, and category).

### **🔎 Search and Filter**

- **Search**: Allows users to search books by title.
- **Filter**: Enables filtering books by category (e.g., Science, Business, Philosophy).

### **📋 Book Detail Page**

- Detailed book view including image, metadata, and options to add to cart or buy.
- Opens dynamically in a new stage when a book is clicked.

### **📱 Responsive Design**

- Optimized for a seamless user experience on both desktop and mobile devices.

### **💳 Add to Cart and Purchase**

- Users can add books to a cart or directly proceed to purchase from the detail page.

---

## 🧑‍💻 Technical Implementation

### **Frontend**

- Built using **JavaFX** for rich, interactive components.
- Dynamic layouts created with `GridPane`, `VBox`, and `HBox`.

### **Backend**

- Managed navigation and business logic through a `Main` Singleton Controller.
- Extracted book details dynamically from image file names.

### **File-Based Data Storage**

- Eliminated the need for a traditional database by storing book metadata in file names.

### **Version Control**

- Resolved merge conflicts and reset to stable versions using Git.

---

## 🚀 How to Run the Project

**Clone the Repository**:

```bash
git clone https://github.com/songjeongjun320/Bookstore_project
And just run!
```

### 👥 Team Members

Meet the amazing team working on this project:

- **Abdirisaq Abdisalam** 🎓
- **Tumaini Donedison** 🎓
- **Rahul Patel** 🎓
- **Tuhina Singh** 🎓
- **Jun Song** 🎓

---

### ✨ Key Features

- **📘 Book Listings**: View available books with detailed information.
- **💳 Book Purchase**: Secure and easy-to-use purchase process.
- **📊 Seller Dashboard**: Manage listed and sold books effortlessly.
- **⭐️ Review & Report**: Leave reviews and report issues.
- **📱 Responsive Design**: Optimized for desktop and mobile devices.

---

### 🎨 Figma Design

Check out our design on **Figma**!  
🔗 [View Figma Design](https://www.figma.com/design/w4xP4b6ZEQeTfruRTu9mEO/ASU-Bookstore?node-id=101-6&t=e6Cpgx5YKiBr4RYT-1)

---

### 🧑‍💻 Tech Stack

We are using modern technologies to build this app:

- **Frontend**: JavaFX, JavaScript, CSS
- **Backend**: Node.js
- **Database**: PostgreSQL
- **Design**: Figma
- **Version Control**: GitHub, Jira

---

### 🤝 Contribution

We welcome contributions! Feel free to submit pull requests or open issues. All feedback and suggestions are appreciated.

---

### 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
