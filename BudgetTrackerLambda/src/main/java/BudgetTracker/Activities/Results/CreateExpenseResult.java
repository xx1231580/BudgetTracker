package BudgetTracker.Activities.Results;

import BudgetTracker.models.ExpenseModel;

public class CreateExpenseResult {
    private final ExpenseModel expenseModel;

    private CreateExpenseResult(ExpenseModel expenseModel) {this.expenseModel = expenseModel;}

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

        public CreateExpenseResult build() {return new CreateExpenseResult(this.expenseModel);}
    }
}
