package BudgetTracker.Activities.Results;

import BudgetTracker.models.BudgetModel;

public class UpdateBudgetResult {
    private final BudgetModel budgetModel;

    private UpdateBudgetResult(BudgetModel budgetModel) {
        this.budgetModel = budgetModel;
    }

    public BudgetModel getBudgetModel() {
        return budgetModel;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private BudgetModel budgetModel;

        public Builder withBudget(BudgetModel budgetModel) {
           this.budgetModel = budgetModel;
            return this;
        }

        public UpdateBudgetResult build() {
            return new UpdateBudgetResult(budgetModel);
        }
    }
}
