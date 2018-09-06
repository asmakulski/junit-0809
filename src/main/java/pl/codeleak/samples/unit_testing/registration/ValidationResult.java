package pl.codeleak.samples.unit_testing.registration;

import java.util.Collections;
import java.util.List;

class ValidationResult {

    private final List<String> errors;

    ValidationResult(List<String> errors) {
        this.errors = errors;
    }

    boolean hasErrors() {
        return errors.size() > 0;
    }

    List<String> getAllErrors() {
        return Collections.unmodifiableList(errors);
    }
}
