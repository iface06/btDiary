package de.aw3s.btDiary.validation;

public interface Violation<T> {

    String getPropertyName();
    T getOffender();
    ViolationType getType();

}
