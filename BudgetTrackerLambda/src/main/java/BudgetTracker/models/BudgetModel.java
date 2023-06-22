package BudgetTracker.models;

import java.util.Objects;

public class BudgetModel {


    private final String budgetId;

    private final String monthlyIncome;


    private BudgetModel(String budgetId , String monthlyIncome) {
        this.budgetId = budgetId;
        this.monthlyIncome = monthlyIncome;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
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
            Objects.equals(monthlyIncome, that.monthlyIncome);}

    @Override
    public int hashCode() {
        return Objects.hash(budgetId);
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        private String budgetId;

        private String monthlyIncome;

        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
            return this;
        }

        public Builder withMonthlyIncome(String monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }


        public BudgetModel build() {
            return new BudgetModel(this.budgetId, this.monthlyIncome);
        }
    }

}
