package academy.pocu.comp2500.assignment1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class User {
    private static Set<String> userIds = new HashSet<>();
    private String userId;
    private CompositePostFilter compositePostFilter;
    private Comparator<Post> sortingType;

    public User(String userId) {
        if (userIds.contains(userId)) {
            return;
        }

        this.userId = userId;
        this.compositePostFilter = new CompositePostFilter();
        this.sortingType = new SortByCreatedDateTimeOrderDesc();
        userIds.add(userId);
    }

    public String getUserId() {
        return this.userId;
    }

    public Set<String> getUserIds() {
        return userIds;
    }

    public void setSortingType(Comparator<Post> postComparator) {
        this.sortingType = postComparator;
    }

    public Blog createBlog() {
        return new Blog(this);
    }

    public void addPost(Blog blog, String title, String body) {
        Post post = new Post(this, title, body);
        blog.addPost(post);
    }

    public void addTag(Post post, String tag) {
        if (this == post.getAuthor()) {
            post.addTag(tag);
        }
    }

    public void updateTitle(Post post, String title) {
        if (this.equals(post.getAuthor())) {
            post.setTitle(title);
        }
    }

    public void updateBody(Post post, String body) {
        if (this.equals(post.getAuthor())) {
            post.setBody(body);
        }
    }

    public List<Post> getPosts(Blog blog) {
        List<Post> posts = blog.getPosts()
                .stream()
                .filter(post -> this.compositePostFilter.apply(post))
                .sorted(this.sortingType)
                .collect(Collectors.toList());
        this.compositePostFilter.clear();
        this.sortingType = new SortByCreatedDateTimeOrderDesc();
        return posts;
    }

    public void addTagFilter(String tag) {
        IPostFilter tagFilter = new PostTagFilter(tag);
        this.compositePostFilter.addFilter(tagFilter);
    }

    public void addAuthorFilter(User author) {
        IPostFilter tagFilter = new PostAuthorFilter(author);
        this.compositePostFilter.addFilter(tagFilter);
    }

    public void addComment(Post post, String text) {
        Comment comment = new Comment(this, text);
        post.addComment(comment);
    }

    public void updateComment(Comment comment, String text) {
        if (this.equals(comment.getAuthor())) {
            comment.setText(text);
        }
    }

    public void addSubcomment(Comment comment, String text) {
        Comment subcomment = new Comment(this, text);
        comment.addSubcomment(subcomment);
    }

    public void upvoteComment(Comment comment) {
        comment.upvote(this);
    }

    public void downvoteComment(Comment comment) {
        comment.downvote(this);
    }

    public List<Comment> getComments(Post post) {
        return post.getComments();
    }

    public List<Comment> getSubcomments(Comment comment) {
        return comment.getSubcomments();
    }

    public void addReaction(Post post, Reaction reaction) {
        post.addReaction(this, reaction);
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
