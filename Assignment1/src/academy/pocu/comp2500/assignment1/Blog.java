package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Blog {
    private final UUID blogId = UUID.randomUUID();
    private User user;
    private List<Post> posts;


    public Blog(User user) {
        this.user = user;
        this.posts = new ArrayList<>();
    }

    public void addPost(User user, String title, String body) {
        Post post = new Post(user, title, body);
        this.posts.add(post);
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        // instanceof Check and actual value check
        return o instanceof Blog && ((Blog) o).blogId.equals(this.blogId);
    }

    @Override
    public int hashCode() {
        return this.blogId.hashCode();
    }

}
