package BudgetTracker.Activities.Request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class UpdateExpenseRequest {
    private final String budgetId;

    private final String expenseId;

    private final String expenseValue;

    private final String expenseName;

    private UpdateExpenseRequest(String budgetId, String expenseId, String expenseValue, String expenseName) {
       this.budgetId = budgetId;
       this.expenseId = expenseId;
       this.expenseValue = expenseValue;
       this.expenseName = expenseName;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getExpenseValue() {
        return expenseValue;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private String budgetId;

        private String expenseId;

        private String expenseValue;

        private String expenseName;


        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
            return this;
        }

        public Builder withExpenseId(String expenseId) {
           this.expenseId = expenseId;
            return this;
        }

        public Builder withExpenseValue(String expenseValue) {
           this.expenseValue = expenseValue;
            return this;
        }

        public Builder withExpenseName(String expenseName) {
            this.expenseName = expenseName;
            return this;
        }


        public UpdateExpenseRequest build() {
            return new UpdateExpenseRequest(this.budgetId, this.expenseId, this.expenseValue, this.expenseName);
        }
    }
}
