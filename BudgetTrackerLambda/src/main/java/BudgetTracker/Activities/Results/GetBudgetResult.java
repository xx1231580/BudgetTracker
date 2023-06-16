package BudgetTracker.Activities.Results;

import BudgetTracker.models.BudgetModel;

public class GetBudgetResult {
    private final BudgetModel budgetModel;


    private GetBudgetResult(BudgetModel budgetModel){
        this.budgetModel = budgetModel;
    }

    public BudgetModel getBudget(){
        return budgetModel;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private BudgetModel budgetModel;

        public Builder withBudgetModel(BudgetModel budgetModel){
           this.budgetModel = budgetModel;
            return this;
        }

        public GetBudgetResult build(){
            return new GetBudgetResult(budgetModel);
        }
    }
}
