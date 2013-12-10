package de.aw3s.btDiary.application.registerUser;

public class CreateUserByRegisterUserRequestFunction {

    public User apply(RegisterUserRequest request){
        User u = new User();

        u.setFirstName(request.getFirstName());
        u.setLastName(request.getLastName());
        u.setEmailAddress(request.getEmailAddress());
        u.setPassword(request.getPassword());

        return u;
    }



}
