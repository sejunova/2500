package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Blog {
    private final UUID blogId = UUID.randomUUID();
    private User owner;
    private List<Post> posts;


    public Blog(User user) {
        this.owner = user;
        this.posts = new ArrayList<>();
    }

    public User getOwner() {
        return owner;
    }

    public void addPost(Post post) {
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
