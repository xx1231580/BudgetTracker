package BudgetTracker.models;

import java.util.Objects;

public class BudgetModel {


    private final String budgetId;

    private final String monthlyIncome;

    private final String serializedExpenses;

    private BudgetModel(String budgetId , String monthlyIncome, String serializedExpenses) {
        this.budgetId = budgetId;
        this.monthlyIncome = monthlyIncome;
        this.serializedExpenses = serializedExpenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BudgetModel that = (BudgetModel) o;
        return Objects.equals(budgetId, that.budgetId) &&
            Objects.equals(monthlyIncome, that.monthlyIncome) &&
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

        public BudgetModel build() {
            return new BudgetModel(this.budgetId, this.monthlyIncome, this.serializedExpenses);
        }
    }

}
