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
    private Set<User> authorFilters;
    private SortingType sortingType;

    public Blog(User user) {
        this.owner = user;
        this.posts = new ArrayList<>();

        this.tagFilters = new HashSet<>();
        this.authorFilters = new HashSet<>();
        this.sortingType = SortingType.CREATED_DATE_TIME_DESC;
    }

    public Set<String> getTagFilters() {
        return this.tagFilters;
    }

    public void addTagFilter(String tag) {
        if (this.tagFilters.contains(tag)) {
            this.tagFilters.remove(tag);
        } else {
            this.tagFilters.add(tag);
        }
    }

    public Set<User> getAuthorFilters() {
        return this.authorFilters;
    }

    public void addAuthorFilter(User author) {
        if (this.authorFilters.contains(author)) {
            this.authorFilters.remove(author);
        } else {
            this.authorFilters.add(author);
        }
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
        Comparator<Post> postComparator;
        switch (this.sortingType) {
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
                postComparator = (post1, post2) -> post2.getCreatedDateTime().compareTo(post1.getCreatedDateTime());
                break;
        }

        Stream<Post> postStream = this.posts
                .stream();
        if (!this.authorFilters.isEmpty()) {
            postStream = postStream.filter(post -> this.filterByAuthor(this.authorFilters, post.getAuthor()));
        }
        if (!this.tagFilters.isEmpty()) {
            postStream = postStream.filter(post -> this.filterByTag(this.tagFilters, post.getTags()));
        }
        List<Post> posts = postStream
                .sorted(postComparator)
                .collect(Collectors.toList());

        // unset filter & sorting options
        this.tagFilters.clear();
        this.authorFilters.clear();
        this.sortingType = SortingType.CREATED_DATE_TIME_DESC;
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

    private boolean filterByTag(Set<String> tagFilters, Set<String> tags) {
        for (String tagFilter: tagFilters) {
            if (tags.contains(tagFilter)) {
                return true;
            }
        }
        return false;
    }

    private boolean filterByAuthor(Set<User> authorFilters, User author) {
        for (User authorFilter: authorFilters) {
            if (author.equals(authorFilter)) {
                return true;
            }
        }
        return false;
    }
}
