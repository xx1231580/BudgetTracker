package BudgetTracker.Activities.Request;

public class GetBudgetRequest {

    private final String budgetId;

    private GetBudgetRequest(String budgetId){
        this.budgetId = budgetId;
    }

    public String getBudgetId(){
        return budgetId;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String budgetId;

        public Builder withBudgetId(String budgetId) {
            this.budgetId = budgetId;
            return this;
        }

        public GetBudgetRequest build(){
            return new GetBudgetRequest(this.budgetId);
        }
    }
}
