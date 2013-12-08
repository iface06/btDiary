package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.validation.Violation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViolationAssert {

    public static void assertViolation(Violation violation, Object o, String propertyName, ConstraintViolationType type){
        assertNotNull(violation);
        assertEquals(type, violation.getType());
        assertEquals(o, violation.getOffender());
        assertEquals(propertyName, violation.getPropertyName());
    }
}
