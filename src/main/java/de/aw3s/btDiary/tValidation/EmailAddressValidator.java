package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.reflection.Reflactor;
import de.aw3s.btDiary.validation.Validator;
import de.aw3s.btDiary.validation.Violation;
import org.apache.commons.validator.EmailValidator;

public class EmailAddressValidator<T> implements Validator<T>{
    @Override
    public Violation<T> validate(T o, String propertyName) {
        EmailValidator v = EmailValidator.getInstance();
        String emailAddress = getProperty(o, propertyName);
        if(!v.isValid(emailAddress)){
            return new ConstraintViolation<T>(o, propertyName, ConstraintViolationType.NON_VALID_EMAIL_ADDRESS);
        }
        return null;
    }

    private String getProperty(T o, String propertyName) {
        return new Reflactor().getProperty(o, propertyName);
    }
}
