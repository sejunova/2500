package academy.pocu.comp2500.assignment1;

public final class PostAuthorFilter implements IPostFilter {
    private User author;

    public PostAuthorFilter(User author) {
        this.author = author;
    }

    @Override
    public boolean apply(Post post) {
        return post.getAuthor().getUserId().equals(author.getUserId());
    }
}
