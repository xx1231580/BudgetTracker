package BudgetTracker.models;

import java.util.Objects;

public class ExpenseModel {

    private final String budgetId;

    private final String expenseId;

    private final String expenseValue;

    private final String expenseName;

    private ExpenseModel(String budgetId, String expenseId, String expenseValue, String expenseName) {
        this.budgetId = budgetId;
        this.expenseId = expenseId;
        this.expenseValue = expenseValue;
        this.expenseName  = expenseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExpenseModel that = (ExpenseModel) o;
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

        public Builder withBudgetId(String budgetId){
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

        public ExpenseModel build() {
            return new ExpenseModel(this.budgetId, this.expenseId, this.expenseValue, this.expenseName);
        }
    }
}
