package BudgetTracker.Activities.Results;

import BudgetTracker.models.BudgetModel;

public class DeleteBudgetResult {
    private final BudgetModel budget;

    private DeleteBudgetResult(BudgetModel budget) {
        this.budget = budget;
    }

    public BudgetModel getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "DeleteBudgetResult{" +
            "budget=" + budget +
            '}';
    }

    public static Builder builder() {return new Builder();}

    public static class Builder {
        private BudgetModel budget;

        public Builder withBudget(BudgetModel budget) {
            this.budget = budget;
            return this;
        }

        public DeleteBudgetResult build() {
            return new DeleteBudgetResult(budget);
        }
    }
}
