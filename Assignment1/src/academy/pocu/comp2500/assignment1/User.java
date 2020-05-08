package academy.pocu.comp2500.assignment1;

import academy.pocu.comp2500.assignment1.filter.CompositePostFilter;
import academy.pocu.comp2500.assignment1.filter.IPostFilter;
import academy.pocu.comp2500.assignment1.filter.PostAuthorFilter;
import academy.pocu.comp2500.assignment1.filter.PostTagFilter;
import academy.pocu.comp2500.assignment1.sort.SortByCreatedDateTimeOrderDesc;

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
        // 동일한 유저아이디로 만들기 방지
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
        if (this == post.getAuthor()) {
            post.setTitle(title);
        }
    }

    public void updateBody(Post post, String body) {
        if (this == post.getAuthor()) {
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
        comment.setText(text);
    }

    public void addSubComment(Comment comment, String text) {
        Comment subComment = new Comment(this, text);
        comment.addSubComment(subComment);
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

    public List<Comment> getSubComments(Comment comment) {
        return comment.getSubComments();
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
