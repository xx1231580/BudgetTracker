package BudgetTracker.Activities.Results;

import BudgetTracker.models.ExpenseModel;

public class DeleteExpenseResult {
    private final ExpenseModel expenseModel;

    private DeleteExpenseResult(ExpenseModel expenseModel) {this.expenseModel = expenseModel;}

    public ExpenseModel getExpenseModel() {
        return expenseModel;
    }

    @Override
    public String toString() {
        return "CreateExpenseResult{" +
            "expenseModel=" + expenseModel +
            '}';
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        private ExpenseModel expenseModel;

        public Builder withExpenseModel(ExpenseModel expenseModel) {
            this.expenseModel = expenseModel;
            return this;
        }

        public DeleteExpenseResult build() {return new DeleteExpenseResult(this.expenseModel);}
    }
}
