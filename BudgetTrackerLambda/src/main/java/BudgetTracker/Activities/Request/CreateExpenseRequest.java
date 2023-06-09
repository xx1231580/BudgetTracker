package BudgetTracker.Activities.Request;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateExpenseRequest.Builder.class)
public class CreateExpenseRequest {
    private final String budgetId;

    private final String expenseValue;

    private final String expenseName;

    private CreateExpenseRequest(String budgetId, String expenseValue, String expenseName) {
        this.budgetId = budgetId;
        this.expenseValue = expenseValue;
        this.expenseName = expenseName;
    }

    public String getBudgetId() {
        return budgetId;
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
        return Objects.equals(budgetId, that.budgetId) &&
            Objects.equals(expenseValue, that.expenseValue) &&
            Objects.equals(expenseName, that.expenseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetId, expenseValue, expenseName);
    }

    public static Builder builder() {return new Builder();}

    @JsonPOJOBuilder
    public static class Builder {
        private String budgetId;

        private String expenseValue;

        private String expenseName;

        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
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
            return new CreateExpenseRequest(this.budgetId, this.expenseValue, this.expenseName);
        }
    }
}
