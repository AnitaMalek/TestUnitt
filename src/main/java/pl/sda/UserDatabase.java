package pl.sda;

import java.util.HashSet;
import java.util.Set;

public class UserDatabase {

    private Set<User> users = new HashSet<>();

    //Symulacja autogeneracji rosnących identyfikatorów dla nowych użytkowników.
    private int id = 0;

    public User add(User user) {
        user.setId(++id);
        users.add(user);

        return user;
    }

    public boolean containsEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
