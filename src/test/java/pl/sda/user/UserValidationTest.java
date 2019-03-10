package pl.sda.user;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.sda.User;
import pl.sda.UserValidation;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class UserValidationTest {

private UserValidation userValidation;

    @Before
    public void setUp() throws Exception {
        this.userValidation = new UserValidation();
    }


    @Test
    @Parameters({"xx,false","xxx, true","xxxx, true"})
    public void EmailValidTest(String email, boolean value) {
        assertThat(userValidation.validEmail(email)).isEqualTo(value);
    }

    @Test
    @Parameters({"xx, false", "xxxxxxxx, true", "xxxxxxxxxx, true"})
    public void PasswordValidTest (String password, boolean value) {
        assertThat(userValidation.validPassword(password)).isEqualTo(value);
    }

    @Test
    @Parameters(method = "UserValidationTest")
    public void UserValidTest(User user, boolean value) {
        assertEquals(value, userValidation.validUser(user));
    }




}
