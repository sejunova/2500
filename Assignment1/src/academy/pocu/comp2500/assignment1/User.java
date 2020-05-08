package academy.pocu.comp2500.assignment1;

public final class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String nickname;
    private CompositePostFilter compositePostFilter;
    private SortingType sortingType;

    public User(String userId, String firstName, String lastName, String nickname) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.compositePostFilter = new CompositePostFilter();
        this.sortingType = SortingType.CREATED_DATE_TIME_DESC;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getUserId() {
        return this.userId;
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public CompositePostFilter getCompositePostFilter() {
        return this.compositePostFilter;
    }

    public Blog createBlog() {
        return new Blog(this);
    }

    public void addTag(Post post, String tag) {
        if (this == post.getAuthor()) {
            post.addTag(tag);
        }
    }

    public void addTagFilter(String tag) {
        IPostFilter tagFilter = new PostTagFilter(tag);
        this.compositePostFilter.addFilter(tagFilter);
    }

    public void addAuthorFilter(User author) {
        IPostFilter tagFilter = new PostAuthorFilter(author);
        this.compositePostFilter.addFilter(tagFilter);
    }

    public void removeReaction(Post post, Reaction reaction) {
        post.removeReaction(this, reaction);
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
        return o instanceof User && ((User) o).userId.equals(this.userId);
    }

    @Override
    public int hashCode() {
        return this.userId.hashCode();
    }

    @Override
    public String toString() {
        return this.userId;
    }
}
