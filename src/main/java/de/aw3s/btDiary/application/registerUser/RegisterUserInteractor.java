package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.application.interactor.Interactor;


public class RegisterUserInteractor implements Interactor<RegisterUserResponse, RegisterUserRequest, RegisterUserDao> {

    @Override
    public RegisterUserResponse apply(RegisterUserRequest registerUserRequest) {
        return new RegisterUserResponse();
    }

    @Override
    public void setDao(RegisterUserDao registerUserDao) {

    }
}
