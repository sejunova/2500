package academy.pocu.comp2500.assignment1;

import java.util.HashSet;
import java.util.Set;

public final class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String nickname;

    public User(String userId, String firstName, String lastName, String nickname) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
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

    public Blog createBlog() {
        return new Blog(this);
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
