package fakeAPI;

import java.util.ArrayList;
import java.util.List;

public class InstagramUser {

    String name;
    String username;
    int age;
    List<Post> posts;
    int numOfPosts;

            // We need to initiate; List<Post> posts is not needed at the beginning,
            // so we don't include it as parameter

    public InstagramUser(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.posts = new ArrayList<>();
    }

   /* public InstagramUserMy(List<Post> posts) {
        this.posts = posts;
    }*/
}
