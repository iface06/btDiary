package de.aw3s.btDiary.validation;

public interface Validator<T> {

    Violation<T> validate(T o, String propertyName);

}
