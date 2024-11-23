import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Address {
    private String userName;
    private String street;
    private String firstLine;
    private String secondLine;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    private String addressFile;

    public Address(String userName) {
        this.addressFile = getAddressFilePath();
        this.userName = userName;
    }

    private String getAddressFilePath() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "back_end" + File.separator + "database" + File.separator + "address.txt";
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

    public boolean addressExists() {
        try (BufferedReader reader = new BufferedReader(new FileReader(addressFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("userName:\"" + userName + "\"")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerAddress(String userName, String street, String firstLine, String secondLine, String zipCode, String city, String state, String country) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(addressFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("userName:\"" + userName + "\"")) {
                    line = String.format(
                        "userName:\"%s\",street:\"%s\",firstLine:\"%s\",secondLine:\"%s\",zipCode:\"%s\",city:\"%s\",state:\"%s\",country:\"%s\"",
                        userName, street, firstLine, secondLine, zipCode, city, state, country
                    );
                    updated = true;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (!updated) {
            String newEntry = String.format(
                "userName:\"%s\",street:\"%s\",firstLine:\"%s\",secondLine:\"%s\",zipCode:\"%s\",city:\"%s\",state:\"%s\",country:\"%s\"",
                userName, street, firstLine, secondLine, zipCode, city, state, country
            );
            lines.add(newEntry);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(addressFile))) {
            for (String entry : lines) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        this.userName = userName;
        this.street = street;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;

        return true;
    }

    public String getUserName() {
        return userName;
    }

    public String getStreet() {
        return street;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
