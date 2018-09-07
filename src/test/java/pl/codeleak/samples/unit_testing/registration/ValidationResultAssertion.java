package pl.codeleak.samples.unit_testing.registration;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

class ValidationResultAssertion extends AbstractAssert<ValidationResultAssertion, ValidationResult> {

    private ValidationResultAssertion(ValidationResult actual, Class<?> selfType) {
        super(actual, selfType);
    }

    static ValidationResultAssertion assertThat(ValidationResult actual) {
        return new ValidationResultAssertion(actual, ValidationResultAssertion.class);
    }

    ValidationResultAssertion hasNoErrors() {
        isNotNull();
        if (actual.hasErrors()) {
            failWithMessage("Expected to have no errors");
        }
        return this;
    }

    ValidationResultAssertion hasErrors() {
        isNotNull();
        if (!actual.hasErrors()) {
            failWithMessage("Expected to have errors");
        }
        return this;
    }

    ValidationResultAssertion hasErrorCount(int count) {
        isNotNull();
        if (actual.getAllErrors().size() != count) {
            failWithMessage("Expected to have <%d> error(s)", count);
        }
        return this;
    }

    ValidationResultAssertion hasErrorMessages(String... errorMessage) {
        isNotNull();
        Assertions.assertThat(actual.getAllErrors()).contains(errorMessage);
        return this;
    }
}
