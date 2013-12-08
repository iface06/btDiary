package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.validation.Violation;
import org.junit.Test;

import static de.aw3s.btDiary.tValidation.ViolationAssert.assertViolation;
import static org.junit.Assert.assertNull;

public class IsNotBlankValidatorTest {

    @Test
    public void testIsNotBlank() {


        IsNotBlankValidator validator = new IsNotBlankValidator();
        MockEntity entity = new MockEntity();
        entity.setName("Max Mustermann");
        Violation violation = validator.validate(entity, "name");

        assertNull(violation);
    }

    @Test
    public void testIsBlank() {


        IsNotBlankValidator validator = new IsNotBlankValidator();
        MockEntity entity = new MockEntity();
        Violation violation = validator.validate(entity, "name");


        assertViolation(violation, entity, "name", ConstraintViolationType.BLANK);
    }
}
