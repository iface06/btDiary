package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.validation.Violation;
import org.junit.Test;

import static de.aw3s.btDiary.tValidation.ViolationAssert.assertViolation;
import static org.junit.Assert.assertNull;

public class EmailAddressValidatorTest {

    @Test
    public void testEmailIsValid() {

        MockEntity e = new MockEntity();
        e.setName("info@aw3s.de");
        EmailAddressValidator<MockEntity> validator = new EmailAddressValidator<>();
        Violation v = validator.validate(e, "name");

        assertNull(v);
    }

    @Test
    public void testEmailIsNotValid() {

        MockEntity entity = new MockEntity();
        entity.setName("info--at--aw3s.de");
        EmailAddressValidator<MockEntity> validator = new EmailAddressValidator<>();
        Violation violation = validator.validate(entity, "name");

        assertViolation(violation, entity, "name", ConstraintViolationType.NON_VALID_EMAIL_ADDRESS);
    }
}
