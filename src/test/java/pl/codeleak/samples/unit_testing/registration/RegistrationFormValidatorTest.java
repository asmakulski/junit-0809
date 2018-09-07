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
        // arrange
        RegistrationForm form = new RegistrationForm("unit.testing.101", "testingIsG00d#", "testingIsG00d#");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertFalse(result.hasErrors());
        assertEquals(0, result.getAllErrors().size());
    }

    @Test
    @DisplayName("Should have 2 errors when username and password is invalid")
    void usernameAndPasswordIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("x", "x", "x");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertTrue(result.hasErrors());
        assertEquals(2, result.getAllErrors().size());
        assertTrue(result.getAllErrors().contains("password is invalid"));
        assertTrue(result.getAllErrors().contains("username is invalid"));
    }

    @Test
    @DisplayName("Should have 'username is invalid' error when username not according to pattern")
    void usernameIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("john", "HelloWorld!1", "HelloWorld!1");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertTrue(result.hasErrors());
        assertEquals(1, result.getAllErrors().size());
        assertEquals("username is invalid", result.getAllErrors().get(0));
    }

    @Test
    @DisplayName("Should have 'passwords do not match' error when passwords do not match")
    void passwordsDoNotMatch() {
        // arrange
        RegistrationForm form = new RegistrationForm("john.smith", "pwd1", "pwd2");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertTrue(result.hasErrors());
        assertEquals(1, result.getAllErrors().size());
        assertEquals("passwords do not match", result.getAllErrors().get(0));
    }

    @Test
    @DisplayName("Should have 'password is invalid' error when password not according to pattern")
    void passwordIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("john.smith", "pwd", "pwd");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertTrue(result.hasErrors());
        assertEquals(1, result.getAllErrors().size());
        assertEquals("password is invalid", result.getAllErrors().get(0));
    }
}