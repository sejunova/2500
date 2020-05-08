package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class Comment implements Comparable<Comment> {
    private final UUID commentId = UUID.randomUUID();
    private User author;
    private Set<User> upvotedUsers;
    private Set<User> downvotedUsers;
    private String text;
    private List<Comment> subComments;

    public Comment(User author, String text) {
        this.upvotedUsers = new HashSet<>();
        this.downvotedUsers = new HashSet<>();
        this.author = author;
        this.text = text;
        this.subComments = new ArrayList<>();
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

    public void addSubComment(Comment comment) {
        this.subComments.add(comment);
    }

    public List<Comment> getSubComments() {
        return this.subComments.stream().sorted().collect(Collectors.toList());
    }


    public void upvote(User user) {
        this.downvotedUsers.remove(user);
        this.upvotedUsers.add(user);
    }

    public void downvote(User user) {
        this.upvotedUsers.remove(user);
        this.downvotedUsers.add(user);
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
