package academy.pocu.comp2500.assignment1;

public final class PostTagFilter implements IPostFilter {
    private String tag;

    public PostTagFilter(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean apply(Post post) {
        return post.getTags().contains(this.tag);
    }
}