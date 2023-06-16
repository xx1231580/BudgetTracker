package BudgetTracker.Activities.Results;

import BudgetTracker.models.UserModel;

public class CreateUserResult {
    private final UserModel userModel;

    private CreateUserResult(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "CreateUserResult{" +
            "userModel=" + userModel +
            '}';
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        private UserModel userModel;

        public Builder withUserModel(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public CreateUserResult build(){return new CreateUserResult(this.userModel);}
    }
}
