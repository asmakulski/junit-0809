package pl.codeleak.samples.unit_testing.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Registration form validation")
class RegistrationFormValidatorTest {

    private RegistrationFormValidator validator = new RegistrationFormValidator();

    @Test
    @DisplayName("Should have no errors when username and password is valid")
    void usernameAndPasswordIsValid() {

    }

    @Test
    @DisplayName("Should have 2 errors when username and password is invalid")
    void usernameAndPasswordIsInvalid() {

    }

    @Test
    @DisplayName("Should have 'username is invalid' error when username not according to pattern")
    void usernameIsInvalid() {

    }

    @Test
    @DisplayName("Should have 'passwords do not match' error when passwords do not match")
    void passwordsDoNotMatch() {

    }

    @Test
    @DisplayName("Should have 'password is invalid' error when password not according to pattern")
    void passwordIsInvalid() {

    }
}