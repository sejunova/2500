package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Blog {
    private final UUID blogId = UUID.randomUUID();
    private User owner;
    private List<Post> posts;
    private Set<String> tagFilters;
    private Set<User> authorFilter;
    private SortingType sortingType;

    public Blog(User user) {
        this.owner = user;
        this.posts = new ArrayList<>();

        this.tagFilters = new HashSet<>();
        this.authorFilter = new HashSet<>();
        this.sortingType = SortingType.CREATED_DATE_TIME_DESC;
    }

    public Set<String> getTagFilters() {
        return this.tagFilters;
    }

    public void addTagFilter(String tag) {
        this.tagFilters.add(tag);
    }

    public Set<User> getAuthorFilter() {
        return this.authorFilter;
    }

    public void addAuthorFilter(User author) {
        this.authorFilter.clear();
        this.authorFilter.add(author);
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public User getOwner() {
        return owner;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public List<Post> getPosts() {
        return this.posts;
//        if (userOrNull == null) {
//            return this.posts;
//        }
//
//        User user = userOrNull;
//        Comparator<Post> postComparator;
//        switch (user.getSortingType()) {
//            case CREATED_DATE_TIME_ASC:
//                postComparator = (post1, post2) -> post1.getCreatedDateTime().compareTo(post2.getCreatedDateTime());
//                break;
//            case CREATED_DATE_TIME_DESC:
//                postComparator = (post1, post2) -> post2.getCreatedDateTime().compareTo(post1.getCreatedDateTime());
//                break;
//            case MODIFIED_DATE_TIME_ASC:
//                postComparator = (post1, post2) -> post1.getModifiedDateTime().compareTo(post2.getModifiedDateTime());
//                break;
//            case MODIFIED_DATE_TIME_DESC:
//                postComparator = (post1, post2) -> post2.getModifiedDateTime().compareTo(post1.getModifiedDateTime());
//                break;
//            case TITLE_ASC:
//                postComparator = (post1, post2) -> post1.getTitle().compareTo(post2.getTitle());
//                break;
//            default:
//                postComparator = (post1, post2) -> post2.getCreatedDateTime().compareTo(post1.getCreatedDateTime());
//                break;
//        }
//        Stream<Post> postStream = this.posts
//                .stream();
//        if (!user.getAuthorFilter().isEmpty()) {
//            postStream = postStream.filter(post -> user.getAuthorFilter().contains(post.getAuthor()));
//        }
//        if (!user.getTagFilters().isEmpty()) {
//            postStream = postStream.filter(post -> post.getTags().containsAll(user.getTagFilters()));
//        }
//        List<Post> posts = postStream
//                .sorted(postComparator)
//                .collect(Collectors.toList());
//        user.unsetFilters();
//        return posts;
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
