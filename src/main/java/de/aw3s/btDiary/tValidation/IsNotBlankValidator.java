package de.aw3s.btDiary.tValidation;

import de.aw3s.btDiary.reflection.Reflactor;
import de.aw3s.btDiary.validation.Validator;
import de.aw3s.btDiary.validation.Violation;
import org.apache.commons.lang3.StringUtils;

public class IsNotBlankValidator<T> implements Validator<T> {

    public Violation<T> validate(T o, String propertyName){
        String value = getProperty(o, propertyName);
        if(StringUtils.isBlank(value)){
            return new ConstraintViolation<T>(o, propertyName, ConstraintViolationType.BLANK);
        }
        return null;
    }

    private String getProperty(T o, String propertyName)  {
        return new Reflactor().getProperty(o, propertyName);
    }
}
