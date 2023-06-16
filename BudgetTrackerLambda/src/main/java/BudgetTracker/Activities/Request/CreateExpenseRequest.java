package BudgetTracker.Activities.Request;

import java.util.Objects;

public class CreateExpenseRequest {
    private final String budgetId;

    private final String expenseId;

    private final String expenseValue;

    private final String expenseName;

    private CreateExpenseRequest(String budgetId, String expenseId, String expenseValue, String expenseName) {
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

    @Override
    public String toString() {
        return "CreateExpenseRequest{" +
            "budgetId='" + budgetId + '\'' +
            ", expenseId='" + expenseId + '\'' +
            ", expenseValue='" + expenseValue + '\'' +
            ", expenseName='" + expenseName + '\'' +
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
        CreateExpenseRequest that = (CreateExpenseRequest) o;
        return Objects.equals(budgetId, that.budgetId) && Objects.equals(expenseId, that.expenseId) &&
            Objects.equals(expenseValue, that.expenseValue) &&
            Objects.equals(expenseName, that.expenseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetId, expenseId, expenseValue, expenseName);
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
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

        public CreateExpenseRequest build() {
            return new CreateExpenseRequest(this.budgetId, this.expenseId, this.expenseValue, this.expenseName);
        }
    }
}
