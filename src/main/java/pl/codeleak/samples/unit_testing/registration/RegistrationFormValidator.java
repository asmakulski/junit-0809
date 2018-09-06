package pl.codeleak.samples.unit_testing.registration;

import java.util.ArrayList;
import java.util.List;

class RegistrationFormValidator {

    /**
     * Registration form validation rules:
     *
     * <ul>
     * <li>Username must be 8 to 20 characters in length, it can only contain alphanumeric characters,</li>
     * numbers, underscore (_) and dot (.) and it cannot start with underscore and dot
     * <li>Passwords must match</li>
     * <li>Password must contain at least 8 characters, 1 number, 1 upper case letter, 1 lower case letter,
     * at least 1 special character and must not contain any spaces</li>
     * </ul>
     */
    ValidationResult validate(RegistrationForm form) {

        if (form == null) {
            throw new IllegalArgumentException("argument cannot be null");
        }

        List<String> validationErrors = new ArrayList<>();

        if (form.getUsername() == null || !form.getUsername().matches("^[a-zA-Z0-9_.]{8,20}$")) {
            validationErrors.add("username is invalid");
        }

        if (!passwordsMatch(form)) {
            validationErrors.add("passwords do not match");
        } else if (form.getPassword() == null || !form.getPassword().matches("^(?=.*[0-9]).{8,}$")) {
            validationErrors.add("password is invalid");
        }

        return new ValidationResult(validationErrors);
    }

    private boolean passwordsMatch(RegistrationForm form) {
        String password = form.getPassword();
        String confirmedPassword = form.getConfirmedPassword();

        if (bothAreNull(password, confirmedPassword)) {
            return true;
        }

        if (atLeastOneIsNull(password, confirmedPassword)) {
            return false;
        }

        return confirmedPassword.equals(password);
    }

    private boolean atLeastOneIsNull(String arg1, String arg2) {
        return arg1 == null || arg2 == null;
    }

    private boolean bothAreNull(String arg1, String arg2) {
        return arg1 == null && arg2 == null;
    }
}
