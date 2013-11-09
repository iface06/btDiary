package de.aw3s.btDiary.validation;

public interface Violation<T> {

    public String getPropertyName();
    public T getOffender();
    public ViolationType getType();

}
