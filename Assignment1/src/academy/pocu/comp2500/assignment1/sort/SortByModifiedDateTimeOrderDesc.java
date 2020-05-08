package academy.pocu.comp2500.assignment1.sort;

import academy.pocu.comp2500.assignment1.Post;

import java.util.Comparator;

public class SortByModifiedDateTimeOrderDesc implements Comparator<Post> {
    @Override
    public final int compare(Post post1, Post post2) {
        return post2.getModifiedDateTime().compareTo(post1.getModifiedDateTime());
    }
}
