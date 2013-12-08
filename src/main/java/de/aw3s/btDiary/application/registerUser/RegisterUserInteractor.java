package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.application.interactor.Interactor;


public class RegisterUserInteractor implements Interactor<RegisterUserResponse, RegisterUserRequest, RegisterUserDao> {

    @Override
    public RegisterUserResponse apply(RegisterUserRequest registerUserRequest) {
        //validieren der Benutzerdaten
        //prüfen ob Benutzer bereits vorhanden ist
        //Passwort Hash erstellen
        //Benutzer speichern
        //Wenn erfolgreich Success-Flag setzen
        return new RegisterUserResponse();
    }

    @Override
    public void setDao(RegisterUserDao registerUserDao) {

    }
}