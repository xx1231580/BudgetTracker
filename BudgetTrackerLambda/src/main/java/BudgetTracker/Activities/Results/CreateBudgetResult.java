package BudgetTracker.Activities.Results;


import BudgetTracker.models.BudgetModel;

public class CreateBudgetResult {
    private final BudgetModel budget;

    private CreateBudgetResult(BudgetModel budget) {
        this.budget = budget;
    }

    public BudgetModel getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "CreateBudgetResult{" +
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

        public CreateBudgetResult build() {
            return new CreateBudgetResult(budget);
        }
    }
}
