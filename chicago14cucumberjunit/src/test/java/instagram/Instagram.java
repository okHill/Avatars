package instagram;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Instagram {

    List<InstagramUser> users;
    String username = "cbt1";
    String password = "Cbt2020";
    String token = "123";


    public Instagram() {
        
        users = new ArrayList<>();
    }

    public String login (String username, String password) {

        if (username.equals(this.username) && password.equals(this.password)) {

            Random random = new Random();
            String token = random.nextInt(100000) + "dh";
            this.token = token;
            return token;
        }
        System.out.println("Login Failed!");
        return "";
    }

    public void seeAllUsers(String secretKey) {

        if (this.token.equals(secretKey)) {

            int counter = 1;

            for (InstagramUser u : users) {

                System.out.println("User " + counter);
                System.out.println("Name: " + u.name);
                System.out.println("Usermane: " + u.username);
                System.out.println("Age: " + u.age);
                System.out.println();
                counter++;

            }
        }
        else {
            System.out.println("Invalid API key! Try again");
        }

    }

    public void addUser(InstagramUser user) {

        boolean found = false;

        for(InstagramUser u : users) {

            if (u.username.equalsIgnoreCase(user.username)) {

                System.out.println("Username already exists");
                found = true;
                break;

            }

        }
        if (!found) {

            System.out.println("User added successfully");
            users.add(user);
        }
    }

    public void addPost(String username, Post instaPost) {

        for (InstagramUser u : users) {

            if (u.username.equalsIgnoreCase(username)) {

                u.posts.add(instaPost);
                return;
            }
        }


    }

    public void deleteUser(String username) {

        for (InstagramUser u : users) {

            if (u.username.equalsIgnoreCase(username)) {

                System.out.println("username " + username + " is removed");
            }
        }

        System.out.println("username " + username + " not found");

    }


    public void updateUserInfo(String username, String newName, int newAge) {

        for (InstagramUser u : users) {

            if (u.username.equalsIgnoreCase(username)) {

                u.name = newName;
                u.age = newAge;

                System.out.println("Info updated");
                return;
            }
        }

        System.out.println("username " + username + " not found");
    }

}
