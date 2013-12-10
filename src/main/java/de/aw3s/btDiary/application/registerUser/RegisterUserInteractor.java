package de.aw3s.btDiary.application.registerUser;

import de.aw3s.btDiary.application.interactor.Interactor;
import de.aw3s.btDiary.validation.Violation;

import java.util.List;


public class RegisterUserInteractor implements Interactor<RegisterUserResponse, RegisterUserRequest, RegisterUserDao> {

    RegisterUserDao dao;
    RegisterUserResponse response = new RegisterUserResponse();
    CreateUserByRegisterUserRequestFunction createUserFunction = new CreateUserByRegisterUserRequestFunction();
    UserRegistrationValidator validator = new UserRegistrationValidator();
    private List<? extends Violation<RegisterUserRequest>> violations;

    @Override
    public RegisterUserResponse apply(RegisterUserRequest registerUserRequest) {

        validator.setDao(dao);
        violations = validator.validate(registerUserRequest);

        if(violations.isEmpty()){
            User newUser = createUserFunction.apply(registerUserRequest);
            dao.store(newUser);
            //Willkommensmail senden
            success();
        }else {
             failure();
        }
        return response;
    }

    private void success() {
        response.setSuccess(true);
    }

    private void failure() {
        response.setSuccess(false);
        response.setViolations(violations);
    }

    @Override
    public void setDao(RegisterUserDao registerUserDao) {
        dao = registerUserDao;
    }

}