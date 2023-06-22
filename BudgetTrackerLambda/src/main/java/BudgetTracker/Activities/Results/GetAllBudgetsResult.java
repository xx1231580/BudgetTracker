package BudgetTracker.Activities.Results;

import java.util.ArrayList;
import java.util.List;

import BudgetTracker.models.BudgetModel;

public class GetAllBudgetsResult {
    private final List<BudgetModel> budgetModels;

    private GetAllBudgetsResult(List<BudgetModel> budgetModels) {
        this.budgetModels =budgetModels;
    }

    public List<BudgetModel> getBudgetList() {
        return new ArrayList<>(budgetModels);
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<BudgetModel> budgetList;

        public Builder withBudgetList(List<BudgetModel> budgetList) {
            this.budgetList = budgetList;
            return this;
        }

        public GetAllBudgetsResult build() {
            return new GetAllBudgetsResult(budgetList);
        }
    }
}
