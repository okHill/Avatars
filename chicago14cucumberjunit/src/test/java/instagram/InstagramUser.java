package instagram;

import java.util.List;

public class InstagramUser {

    String name;
    String username;
    int age;
    List<Post> posts;
    int numOfPosts;

    public InstagramUser(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
//        this.posts = new ArrayList<>();
//        this.numOfPosts = numOfPosts;

    }
}
