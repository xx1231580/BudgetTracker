package BudgetTracker.Activities.Results;

import java.util.ArrayList;
import java.util.List;

import BudgetTracker.models.ExpenseModel;

public class GetExpensesResult {
    private final List<ExpenseModel> expenseModels;

    private GetExpensesResult(List<ExpenseModel> expenseModels) {
        this.expenseModels = expenseModels;
    }

    public List<ExpenseModel> getExpenseList() {
        return new ArrayList<>(expenseModels);
    }

    @Override
    public String toString() {
        return "GetExpensesResult{" +
            "expenseModels=" + expenseModels +
            '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<ExpenseModel> expenseList;

        public Builder withExpenseList(List<ExpenseModel> expenseList) {
            this.expenseList = new ArrayList<>(expenseList);
            return this;
        }

        public GetExpensesResult build() {
            return new GetExpensesResult(expenseList);
        }
    }


}
