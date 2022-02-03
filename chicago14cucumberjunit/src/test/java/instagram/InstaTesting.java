package instagram;

public class InstaTesting {

    public static void main(String[] args) {

        Instagram instagram = new Instagram();

        InstagramUser user1 = new InstagramUser("John Wick", "jwick", 45);

        instagram.addUser(user1);
        System.out.println();

        String userToken = instagram.login("cbt1", "Cbt20");

//        System.out.println(userToken);
        instagram.seeAllUsers(userToken);


    }
}
