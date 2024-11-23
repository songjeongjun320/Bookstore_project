public class Tests {
    public static void main(String[] args) {

        User test = new User();

        test.signUp("Lamp", "light", "lampers@abcd.com", "3897483741", "John", "Cena");

        User user = new User();
        boolean loginSuccess = user.login("Lamp", "light");

        if (loginSuccess) {
            System.out.println("Login successful!");
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Login failed.");
        }      

    }
}
