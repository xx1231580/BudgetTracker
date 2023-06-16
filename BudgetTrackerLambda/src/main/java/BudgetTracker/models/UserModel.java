package BudgetTracker.models;

import java.util.Objects;

public class UserModel {
    public String userId;

    public String budgetId;

    private UserModel(String userId, String budgetId){
        this.userId = userId;
        this.budgetId = budgetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(userId, userModel.userId) && Objects.equals(budgetId, userModel.budgetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, budgetId);
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        public String userId;

        public String budgetId;

        public Builder withUserId(String userId){
            this.userId = userId;
            return this;
        }

        public Builder withBudgetId(String budgetId){
            this.budgetId = budgetId;
            return this;
        }

        public UserModel build(){
            return new UserModel(this.userId, this.budgetId);
        }
    }
}
