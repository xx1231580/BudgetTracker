package BudgetTracker.Activities.Results;

import BudgetTracker.models.ExpenseModel;

public class UpdateExpenseResult {
    private final ExpenseModel expenseModel;

    private UpdateExpenseResult(ExpenseModel expenseModel) {this.expenseModel = expenseModel;}

    public ExpenseModel getExpenseModel() {return expenseModel;}

    public static Builder builder() {return new Builder();}


    public static class Builder {
        private ExpenseModel expenseModel;

        public Builder withExpenseModel(ExpenseModel expenseModel) {
            this.expenseModel = expenseModel;
            return this;
        }

        public UpdateExpenseResult build() {
            return new UpdateExpenseResult(expenseModel);
        }
    }
}
