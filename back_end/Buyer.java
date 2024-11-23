import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Buyer extends User {
    private ArrayList<String> cart;
    private String buyerFile;

    public Buyer() {
        super();
        this.cart = new ArrayList<String>();
        this.buyerFile = getBuyerFilePath();
    }

    public Buyer(String userName) {
        super(userName);
        this.buyerFile = getBuyerFilePath();
        loadValues(userName);  
    }

    private String getBuyerFilePath() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "back_end" + File.separator + "database" + File.separator + "buyer.txt";
            File databaseDir = new File(currentDir + File.separator + "back_end" + File.separator + "database");
            if (!databaseDir.exists()) {
                databaseDir.mkdirs();
            }
            File addressFile = new File(filePath);
            if (!addressFile.exists()) {
                addressFile.createNewFile();
            }
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void loadValues(String userName) {
        BufferedReader reader = null;
        boolean userFound = false;

        try {
            File file = new File(buyerFile);
            reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");  
                if (data[0].equals(userName)) {  
                    this.cart.clear();  
                    for (int i = 1; i < data.length; i++) {
                        this.cart.add(data[i].trim());
                    }
                    userFound = true;
                    break;
                }
            }
            if (!userFound) {
                this.cart.clear();  
                saveNewUser(userName);  
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveNewUser(String userName) {
        BufferedWriter writer = null;
        try {
            File file = new File(buyerFile);
            writer = new BufferedWriter(new FileWriter(file, true));  
            String newUserRecord = userName + ",";  
            writer.write(newUserRecord);
            writer.newLine();  
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getCart() {
        return cart;
    }
}
