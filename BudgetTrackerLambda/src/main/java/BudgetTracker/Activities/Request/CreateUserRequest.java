package BudgetTracker.Activities.Request;

import java.util.Objects;

public class CreateUserRequest {
    public String userId;

    public String budgetId;

    private CreateUserRequest(String userId, String budgetId) {
        this.userId = userId;
        this.budgetId = budgetId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBudgetId() {
        return budgetId;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
            "userId='" + userId + '\'' +
            ", budgetId='" + budgetId + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateUserRequest that = (CreateUserRequest) o;
        return Objects.equals(userId, that.userId) && Objects.equals(budgetId, that.budgetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, budgetId);
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        public String userId;

        public String budgetId;

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this.userId, this.budgetId);
        }
    }
}
