import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String pwd;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;

    private String usersFile;

    public User() {
        usersFile = getUsersFilePath();
    }

    public User(String userName) {
        this.usersFile = getUsersFilePath();
        if (loadUserFromFile(userName)) {
            this.userName = userName;
        } else {
            this.userName = "";
            this.pwd = "";
            this.email = "";
            this.phone = "";
            this.firstName = "";
            this.lastName = "";
        }
    }

    private String getUsersFilePath() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "back_end" + File.separator + "database" + File.separator + "usersFile.txt";
            File databaseDir = new File(currentDir + File.separator + "back_end" + File.separator + "database");
            if (!databaseDir.exists()) {
                databaseDir.mkdirs(); 
            }
            File usersFile = new File(filePath);
            if (!usersFile.exists()) {
                usersFile.createNewFile(); 
            }
    
            return filePath;
    
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean loadUserFromFile(String userName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("userName:" + userName)) {
                    parseLine(line);
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    private void parseLine(String line) {
        String[] dataParts = line.split(",");
        for (String part : dataParts) {
            if (part.contains("userName:")) {
                this.userName = part.split(":")[1].replace("\"", "").trim();
            } else if (part.contains("pwd:")) {
                this.pwd = part.split(":")[1].replace("\"", "").trim();
            } else if (part.contains("email:")) {
                this.email = part.split(":")[1].replace("\"", "").trim();
            } else if (part.contains("phone:")) {
                this.phone = part.split(":")[1].replace("\"", "").trim();
            } else if (part.contains("firstName:")) {
                this.firstName = part.split(":")[1].replace("\"", "").trim();
            } else if (part.contains("lastName:")) {
                this.lastName = part.split(":")[1].replace("\"", "").trim();
            }
        }
    }

    private boolean isDuplicateUser(String userName, String email, String phone) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("userName:" + userName) || line.contains("email:" + email) || line.contains("phone:" + phone)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    public boolean signUp(String userName, String pwd, String email, String phone, String firstName, String lastName) {
        if (userName.isEmpty() || pwd.isEmpty() || email.isEmpty() || phone.isEmpty() || firstName.isEmpty()) {
            return false; 
        }

        if (isDuplicateUser(userName, email, phone)) {
            return false; 
        }

        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;

        saveUser();

        return true;
    }

    public boolean login(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("userName:" + userName) && line.contains("pwd:" + password)) {
                    parseLine(line);
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; 
    }

    private void saveUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile, true))) {
            String record = String.format("userName:%s, pwd:%s, email:%s, phone:%s, firstName:%s, lastName:%s",
                    userName, pwd, email, phone, firstName, lastName);
            writer.write(record);
            writer.newLine(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUserName(String newUserName) {
        if (newUserName.isEmpty() || isDuplicateUser(newUserName, null, null)) {
            return false;  
        }
        this.userName = newUserName;
        return updateUserFile();
    }

    public boolean updateEmail(String newEmail) {
        if (newEmail.isEmpty() || isDuplicateUser(null, newEmail, null)) {
            return false;  
        }
        this.email = newEmail;
        return updateUserFile();
    }

    public boolean updatePhone(String newPhone) {
        if (newPhone.isEmpty() || isDuplicateUser(null, null, newPhone)) {
            return false;  
        }
        this.phone = newPhone;
        return updateUserFile();
    }

    public boolean updateFirstName(String newFirstName) {
        if (newFirstName.isEmpty()) {
            return false;
        }
        this.firstName = newFirstName;
        return updateUserFile();
    }

    public boolean updateLastName(String newLastName) {
        if (newLastName.isEmpty()) {
            return false;
        }
        this.lastName = newLastName;
        return updateUserFile();
    }

    private boolean updateUserFile() {
        List<String> lines = new ArrayList<>();
        boolean updated = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("userName:" + userName)) {
                    String updatedLine = String.format("userName:\"%s\", pwd:\"%s\", email:\"%s\", phone:\"%s\", firstName:\"%s\", lastName:\"%s\"",
                            userName, pwd, email, phone, firstName, lastName);
                    lines.add(updatedLine); 
                    updated = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            for (String newLine : lines) {
                writer.write(newLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return updated;  
    }

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /* 

    public void Report(String userName) {
        // Implement Report Functionality here
    }
    */
}
