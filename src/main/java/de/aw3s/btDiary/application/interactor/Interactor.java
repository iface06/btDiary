package de.aw3s.btDiary.application.interactor;

public interface Interactor<RESPONSE,REQUEST, DAO> {
    RESPONSE apply(REQUEST request);
    void setDao(DAO dao);
}
