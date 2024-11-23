
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Listing {
    private String listingID;
    private String title;
    private String author;
    private String category;
    private String condition;
    private Date dateListed;
    private double priceListed;
    private String summary;
    private String lister;

    private String listingFile;

    public Listing(String title, String author, String category, String condition, double priceListed, String summary, String lister) {
        this.listingFile = getListingFilePath(); 
        this.listingID = generateListingID();
        this.title = title;
        this.author = author;
        this. category = category;
        this.condition = condition;
        this.priceListed = priceListed;
        this.summary = summary;
        this.dateListed = new Date();
        this.lister = lister;
    }

    private String getListingFilePath() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "back_end" + File.separator + "database" + File.separator + "listing.txt";
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

    private String generateRandomNumber() {
        Random rand = new Random();
        return (Integer.toString(1000 + rand.nextInt(90000)));
    }

    private String generateListingID() {
        try (BufferedReader reader = new BufferedReader(new FileReader(listingFile))) {
            String line;
            boolean flag = false;
            boolean secondFlag = false;
            String targetID = null;
            while (!flag) {
                String listingID = generateRandomNumber();
                while ((line = reader.readLine()) != null) {
                    if (line.contains("listingID:" + listingID)) {
                        secondFlag = true;
                    }
                }
                if (secondFlag) {
                    secondFlag = false;
                    continue;
                } else {
                    flag = true;
                    targetID = listingID;
                }
            }
            return targetID;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addListing() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(listingFile, true))) {
        String listingEntry = "listingID:" + listingID + "," + "title:" + title + "," + "author:" + author + "," + "category:" + category + "," + "condition:" + condition + "," + "priceListed:" + priceListed + "," + "dateListed:" + dateListed + "," + "summary:" + summary + "," + "lister:" + lister;
        writer.write(listingEntry);
        writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteListing(String targetListingID) {
        boolean listingDeleted = false;
        StringBuilder updatedContent = new StringBuilder();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(listingFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("listingID:" + targetListingID)) {
                    listingDeleted = true;
                    continue; 
                }
                updatedContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (listingDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(listingFile))) {
                writer.write(updatedContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        return listingDeleted;
    }

    public String getListingID() {
        return listingID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }

    public Date getDateListed() {
        return dateListed;
    }

    public double getPriceListed() {
        return priceListed;
    }

    public String getSummary() {
        return summary;
    }
    
}