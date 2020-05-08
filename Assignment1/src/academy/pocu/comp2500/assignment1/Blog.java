package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void addPost(User author, String title, String body, String tag) {
        this.posts.add(new Post(author, title, body, tag));
    }

    public List<Post> getPosts(User user) {
       Comparator<Post> postComparator;
        switch (user.getSortingType()) {
            case CREATED_DATE_TIME_ASC:
                postComparator = (post1, post2) -> post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime());
                break;
            case CREATED_DATE_TIME_DESC:
                postComparator = (post1, post2) -> post2.getCreatedDateTime().compareTo(post1.getCreatedDateTime());
                break;
            case MODIFIED_DATE_TIME_ASC:
                postComparator = (post1, post2) -> post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime());
                break;
            case MODIFIED_DATE_TIME_DESC:
                postComparator = (post1, post2) -> post2.getModifiedDateTime().compareTo(post1.getModifiedDateTime());
                break;
            case TITLE_ASC:
                postComparator = (post1, post2) -> post1.getTitle().compareTo(post2.getTitle());
                break;
            default:
                throw new RuntimeException("sortingType is wrong");
        }
        Stream<Post> postStream = this.posts
                .stream();
        if (user.getAuthorFilter() != null) {
            postStream = postStream.filter(post -> post.getAuthor().equals(user.getAuthorFilter()));
        }
        if (user.getTagFilters().size() != 0) {
            postStream = postStream.filter(post -> post.getTags().containsAll(user.getTagFilters()));
        }
        List<Post> posts = postStream
                .sorted(postComparator)
                .collect(Collectors.toList());
        user.unSetFilters();
        return posts;
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
