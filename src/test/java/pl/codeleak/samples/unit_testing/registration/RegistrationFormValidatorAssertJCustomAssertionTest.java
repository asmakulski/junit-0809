package pl.codeleak.samples.unit_testing.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static pl.codeleak.samples.unit_testing.registration.ValidationResultAssertion.assertThat;

@DisplayName("Registration form validation")
class RegistrationFormValidatorAssertJCustomAssertionTest {

    private RegistrationFormValidator validator = new RegistrationFormValidator();

    @Test
    @DisplayName("Should have no errors when username and password is valid")
    void usernameAndPasswordIsValid() {
        // arrange
        RegistrationForm form = new RegistrationForm("unit.testing.101", "testingIsG00d#", "testingIsG00d#");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertThat(result)
            .hasNoErrors();
    }

    @Test
    @DisplayName("Should have 2 errors when username and password is invalid")
    void usernameAndPasswordIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("x", "x", "x");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertThat(result)
            .hasErrors()
            .hasErrorCount(2)
            .hasErrorMessages("username is invalid", "password is invalid");
    }

    @Test
    @DisplayName("Should have 'username is invalid' error when username not according to pattern")
    void usernameIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("john", "HelloWorld!1", "HelloWorld!1");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertThat(result)
            .hasErrors()
            .hasErrorCount(1)
            .hasErrorMessages("username is invalid");
    }

    @Test
    @DisplayName("Should have 'passwords do not match' error when passwords do not match")
    void passwordsDoNotMatch() {
        // arrange
        RegistrationForm form = new RegistrationForm("john.smith", "pwd1", "pwd2");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertThat(result)
            .hasErrors()
            .hasErrorCount(1)
            .hasErrorMessages("passwords do not match");
    }

    @Test
    @DisplayName("Should have 'password is invalid' error when password not according to pattern")
    void passwordIsInvalid() {
        // arrange
        RegistrationForm form = new RegistrationForm("john.smith", "pwd", "pwd");
        // act
        ValidationResult result = validator.validate(form);
        // assert
        assertThat(result)
            .hasErrors()
            .hasErrorCount(1)
            .hasErrorMessages("password is invalid");
    }
}