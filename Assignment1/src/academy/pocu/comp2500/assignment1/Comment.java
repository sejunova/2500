package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class Comment implements Comparable<Comment> {
    private UUID commentId;
    private User author;
    private Set<User> upvotedUsers;
    private Set<User> downvotedUsers;
    private String text;
    private List<Comment> subcomments;

    public Comment(UUID commentId, User author, String text) {
        this.commentId = commentId;
        this.upvotedUsers = new HashSet<>();
        this.downvotedUsers = new HashSet<>();
        this.author = author;
        this.text = text;
        this.subcomments = new ArrayList<>();
    }

    public UUID getCommentId() {
        return commentId;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addSubcomment(Comment comment) {
        this.subcomments.add(comment);
    }

    public List<Comment> getSubcomments() {
        return this.subcomments.stream().sorted().collect(Collectors.toList());
    }

    public Set<User> getUpvotedUsers() {
        return upvotedUsers;
    }

    public Set<User> getDownvotedUsers() {
        return downvotedUsers;
    }

    public void updateComment(User author, String text) {
        if (this.author.equals(author)) {
            this.text = text;
        }
    }


    public void upvoteByUser(User user) {
        if (this.downvotedUsers.contains(user)) {
            this.downvotedUsers.remove(user);
            this.upvotedUsers.add(user);
        } else this.upvotedUsers.add(user);
    }

    public void downvoteByUser(User user) {
        if (this.upvotedUsers.contains(user)) {
            this.upvotedUsers.remove(user);
            this.downvotedUsers.add(user);
        } else this.downvotedUsers.add(user);
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
        return o instanceof Comment && ((Comment) o).commentId.equals(this.commentId);
    }

    @Override
    public int hashCode() {
        return this.commentId.hashCode();
    }

    @Override
    public int compareTo(Comment other) {
        return (this.upvotedUsers.size() - this.downvotedUsers.size()) >= (other.upvotedUsers.size() - other.downvotedUsers.size()) ? -1 : 1;
    }

}
