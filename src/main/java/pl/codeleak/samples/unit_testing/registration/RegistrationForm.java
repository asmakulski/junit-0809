package pl.codeleak.samples.unit_testing.registration;

class RegistrationForm {

    private final String username;
    private final String password;
    private final String confirmedPassword;

    RegistrationForm(String username, String password, String confirmedPassword) {
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getConfirmedPassword() {
        return confirmedPassword;
    }
}
