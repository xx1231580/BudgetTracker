package BudgetTracker.Activities.Request;

import java.util.Objects;



public class CreateBudgetRequest {

    private final String budgetId;

    private final String monthlyIncome;

    private final String serializedExpenses;

    private CreateBudgetRequest(String budgetId , String monthlyIncome, String serializedExpenses) {
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

    @Override
    public String toString() {
        return "CreateBudgetRequest{" +
            "budgetId='" + budgetId + '\'' +
            ", monthlyIncome='" + monthlyIncome + '\'' +
            ", serializedExpenses='" + serializedExpenses + '\'' +
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
        CreateBudgetRequest that = (CreateBudgetRequest) o;
        return Objects.equals(budgetId, that.budgetId) &&
            Objects.equals(serializedExpenses, that.serializedExpenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetId, serializedExpenses);
    }

    public static Builder builder() {return new Builder();}


    public static class Builder {
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

        public Builder withExpenses(String serializedExpenses) {
            this.serializedExpenses = serializedExpenses;
            return this;
        }

        public CreateBudgetRequest build() {
            return new CreateBudgetRequest(this.budgetId, this.monthlyIncome, this.serializedExpenses);
        }
    }
}
