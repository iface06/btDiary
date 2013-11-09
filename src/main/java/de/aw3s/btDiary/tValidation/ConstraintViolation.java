package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.validation.Violation;
import de.aw3s.btDiary.validation.ViolationType;

public class ConstraintViolation<T> implements Violation<T> {
    private T offender;
    private String propertyName;
    private ViolationType type;

    public ConstraintViolation(T offender, String propertyName, ViolationType type) {
        this.offender = offender;
        this.propertyName = propertyName;
        this.type = type;
    }

    @Override
    public T getOffender() {
        return this.offender;
    }

    @Override
    public String getPropertyName() {
        return this.propertyName;
    }

    @Override
    public ViolationType getType() {
        return this.type;
    }
}
