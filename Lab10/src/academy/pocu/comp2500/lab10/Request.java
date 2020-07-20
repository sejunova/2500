package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.Objects;

public class Request {
    private String title;
    private User user;

    public Request(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(title, request.title) &&
                Objects.equals(user, request.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, user);
    }
}
