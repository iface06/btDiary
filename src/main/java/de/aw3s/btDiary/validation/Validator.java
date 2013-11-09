package de.aw3s.btDiary.validation;

public interface Validator<T> {

    public Violation<T> validate(T o, String propertyName);

}
