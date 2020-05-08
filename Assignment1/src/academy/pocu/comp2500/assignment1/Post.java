package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class Post {
    private UUID postId;
    private User author;
    private String title;
    private String body;
    private final OffsetDateTime createdDateTime = OffsetDateTime.now();
    private OffsetDateTime modifiedDateTime;
    private Set<String> tags;
    private List<Comment> comments;
    private EnumMap<Reaction, Set<User>> reactions;

    public Post(UUID postId, User author, String title, String body) {
        this.postId = postId;
        this.author = author;
        this.title = title;
        this.body = body;
        this.modifiedDateTime = this.createdDateTime;
        this.comments = new ArrayList<>();
        this.reactions = new EnumMap<>(Reaction.class);
        this.tags = new HashSet<>();
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public User getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public void updateTitle(User author, String title) {
        if (this.author.equals(author)) {
            this.title = title;
        }
    }

    public String getBody() {
        return this.body;
    }

    public void updateBody(User author, String body) {
        if (this.author.equals(author)) {
            this.body = body;
        }
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public void addComment(User user, String text) {
        this.comments.add(new Comment(user, text));
    }

    public void addReaction(User user, Reaction reaction) {
        if (!this.reactions.containsKey(reaction)) {
            this.reactions.put(reaction, new HashSet<>());
            this.reactions.get(reaction).add(user);
            return;
        }
        if (this.reactions.get(reaction).contains(user)) {
            this.reactions.get(reaction).remove(user);
        } else {
            this.reactions.get(reaction).add(user);
        }
    }

    public int getReaction(Reaction reaction) {
        return this.reactions.get(reaction).size();
    }

    public void removeReaction(User user, Reaction reaction) {
        if (!this.reactions.containsKey(reaction)) {
            return;
        }
        this.reactions.get(reaction).remove(user);
    }

    public EnumMap<Reaction, Set<User>> getReactions() {
        return this.reactions;
    }

    public List<Comment> getComments() {
        return this.comments.stream().sorted().collect(Collectors.toList());
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
        return o instanceof Post && ((Post) o).postId.equals(this.postId);
    }

    @Override
    public int hashCode() {
        return this.postId.hashCode();
    }
}
