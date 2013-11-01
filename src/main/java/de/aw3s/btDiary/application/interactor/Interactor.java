package de.aw3s.btDiary.application.interactor;

public interface Interactor<RESPONSE,REQUEST, DAO>{
    public RESPONSE apply(REQUEST request);
    public void setDao(DAO dao);
}
