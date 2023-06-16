package BudgetTracker.Activities.Results;

import BudgetTracker.models.UserModel;


public class GetUserResult {
    private final UserModel userModel;


    private GetUserResult(UserModel userModel){
        this.userModel = userModel;
    }

    public UserModel getUserModel(){
        return userModel;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private UserModel userModel;

        public GetUserResult.Builder withUserModel(UserModel userModel){
            this.userModel = userModel;
            return this;
        }

        public GetUserResult build(){
            return new GetUserResult(userModel);
        }
    }
}
