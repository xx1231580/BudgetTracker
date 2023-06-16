package BudgetTracker.Activities.Request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class UpdateUserRequest {
    public final String userId;

    public final String budgetId;

    private UpdateUserRequest(String userId, String budgetId) {
        this.userId = userId;
        this.budgetId = budgetId;
    }

    public String getUserId() {return this.userId;}

    public String getBudgetId() {return this.budgetId;}

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        public String userId;

        public String budgetId;

        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
            return this;
        }

        public Builder withUserId(String userId) {
           this.userId = userId;
            return this;
        }

        public UpdateUserRequest build() {
            return new UpdateUserRequest(this.userId, this.budgetId);
        }
    }

}
