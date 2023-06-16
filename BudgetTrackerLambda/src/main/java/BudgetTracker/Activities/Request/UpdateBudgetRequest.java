package BudgetTracker.Activities.Request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class UpdateBudgetRequest {
    private final String budgetId;

    private final String monthlyIncome;

    private final String serializedExpenses;

    public UpdateBudgetRequest(String budgetId, String monthlyIncome, String serializedExpenses) {
       this.budgetId = budgetId;
       this.monthlyIncome = monthlyIncome;
       this.serializedExpenses = serializedExpenses;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getSerializedExpenses() {
        return serializedExpenses;
    }
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private String budgetId;

        private String monthlyIncome;

        private String serializedExpenses;


        public Builder withBudgetId(String budgetId) {
           this.budgetId = budgetId;
            return this;
        }

        public Builder withMonthlyIncome(String monthlyIncome) {
           this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder withSerializedExpenses(String serializedExpenses) {
            this.serializedExpenses = serializedExpenses;
            return this;
        }


        public UpdateBudgetRequest build() {
            return new UpdateBudgetRequest(this.budgetId, this.monthlyIncome, this.serializedExpenses);
        }
    }
}
