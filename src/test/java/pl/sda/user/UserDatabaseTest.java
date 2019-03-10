package pl.sda.user;

import org.junit.Before;
import org.junit.Test;
import pl.sda.User;
import pl.sda.UserDatabase;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDatabaseTest {

    private UserDatabase userDatabase;

    @Before
    public void setUp() throws Exception {
        this.userDatabase = new UserDatabase();
    }

    @Test
    public void UserAddTest() {
        for (int i = 0; i<=10; i++) {
            User uzytkownik = userDatabase.add(new User("xxx", "xxxsfbv"));
            assertThat(uzytkownik.getId()).isEqualTo(i+1);
        }
    }

    @Test
    public void TestContainsEmail() {
        userDatabase.add(new User("mmmmmmm", "rrrrrr"));
        assertThat(userDatabase.containsEmail("mmmmmmm")).isEqualTo(true);
        assertThat(userDatabase.containsEmail("mm")).isNotEqualTo(true);
    }



}

