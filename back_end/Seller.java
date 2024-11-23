import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private double rating;
    private int numRaters;
    private ArrayList<String> listedIDcart;
    private String sellerFile;

    public Seller() {
        super();
        this.rating = 0.0;
        this.numRaters = 0;
        this.listedIDcart = new ArrayList<>();
        this.sellerFile = getSellerFilePath();
        loadValues();
    }

    public Seller(String userName) {
        super(userName);
        this.sellerFile = getSellerFilePath();
        loadValues();
    }

    private String getSellerFilePath() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "back_end" + File.separator + "database" + File.separator + "seller.txt";
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

    private void loadValues() {
        boolean userFound = false; 
    
        try (BufferedReader br = new BufferedReader(new FileReader(sellerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); 
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(getUserName())) {
                    this.rating = Double.parseDouble(parts[1]);
                    this.numRaters = Integer.parseInt(parts[2]);
                    this.listedIDcart = new ArrayList<>();
                    for (int i = 3; i < parts.length; i++) {
                        listedIDcart.add(parts[i]);
                    }
                    userFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (!userFound) {
            this.rating = 0.0;
            this.numRaters = 0;
            this.listedIDcart = new ArrayList<>();
        }
    }

    public void registerSeller() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sellerFile, true))) {
            String defaultEntry = getUserName() + ",0.0,0"; 
            bw.write(defaultEntry);
            bw.newLine(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateRating(double newRating) {
        double totalRating = (rating * numRaters) + newRating;
        numRaters++; 
        rating = totalRating / numRaters; 
        updateSellerRecord();
    }

    public void removeListingID(String userName, String listingID) {
        boolean sellerFound = false;
        StringBuilder updatedContent = new StringBuilder(); 
        try (BufferedReader br = new BufferedReader(new FileReader(sellerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(userName)) {
                    sellerFound = true;
                    List<String> listings = new ArrayList<>(List.of(parts));
                    listings.remove(listings.indexOf(listingID));
                    StringBuilder updatedLine = new StringBuilder();
                    updatedLine.append(parts[0]).append(","); 
                    updatedLine.append(parts[1]).append(","); 
                    updatedLine.append(parts[2]); 

                    for (int i = 3; i < listings.size(); i++) {
                        updatedLine.append(",").append(listings.get(i));
                    }
                    updatedContent.append(updatedLine.toString()).append("\n"); 
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sellerFile))) {
            bw.write(updatedContent.toString()); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addListingID(String userName, String listingID) {
        boolean sellerFound = false;
        StringBuilder updatedContent = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(sellerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[0].equalsIgnoreCase(userName)) {
                    sellerFound = true;
                    StringBuilder updatedLine = new StringBuilder();
                    updatedLine.append(parts[0]).append(",");
                    updatedLine.append(parts[1]).append(",");
                    updatedLine.append(parts[2]);             
    
                    for (int i = 3; i < parts.length; i++) {
                        updatedLine.append(",").append(parts[i]);
                    }
    
                    if (!listedIDcart.contains(listingID)) {
                        updatedLine.append(",").append(listingID);
                        listedIDcart.add(listingID); 
                    }
                    updatedContent.append(updatedLine.toString()).append("\n");
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!sellerFound) {
            StringBuilder newSeller = new StringBuilder();
            newSeller.append(userName).append(",0.0,0,").append(listingID).append("\n");
            updatedContent.append(newSeller.toString());
            listedIDcart.add(listingID); 
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sellerFile))) {
            bw.write(updatedContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void updateSellerRecord() {
        StringBuilder updatedContent = new StringBuilder();
        boolean sellerFound = false;
    
        try (BufferedReader br = new BufferedReader(new FileReader(sellerFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(getUserName())) {
                    sellerFound = true;
                    StringBuilder updatedLine = new StringBuilder();
                    updatedLine.append(getUserName()).append(","); 
                    updatedLine.append(rating).append(",");
                    updatedLine.append(numRaters); 
                    for (String listingID : listedIDcart) {
                        updatedLine.append(",").append(listingID);
                    }
                    updatedContent.append(updatedLine.toString()).append("\n"); 
                } else {
                    updatedContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sellerFile))) {
            bw.write(updatedContent.toString()); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public double getRating() {
        return rating;
    }
    
    public int getNumRaters() {
        return numRaters;
    }
    
    public ArrayList<String> getlistedIDcart() {
        return listedIDcart;
    }
}