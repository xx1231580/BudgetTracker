package BudgetTracker.Activities.Results;


import BudgetTracker.models.UserModel;

public class UpdateUserResult {
    private final UserModel userModel;

    private UpdateUserResult(UserModel userModel) {this.userModel = userModel;}

    public UserModel getUserModel() {return userModel;}

    public static UpdateUserResult.Builder builder() {return new Builder();}


    public static class Builder {
        private UserModel userModel;

        public Builder withUserModel(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public UpdateUserResult build() {
            return new UpdateUserResult(userModel);
        }
    }
}
