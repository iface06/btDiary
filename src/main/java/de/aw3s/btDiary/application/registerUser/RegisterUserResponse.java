package de.aw3s.btDiary.application.registerUser;


import de.aw3s.btDiary.validation.Violation;

import java.util.ArrayList;
import java.util.List;

public class RegisterUserResponse {

    private boolean success = false;
    private List<? extends Violation<RegisterUserRequest>> violations = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<? extends Violation<RegisterUserRequest>> getViolations() {
        return violations;
    }

    public void setViolations(List<? extends Violation<RegisterUserRequest>> violations) {
        this.violations = violations;
    }
}
