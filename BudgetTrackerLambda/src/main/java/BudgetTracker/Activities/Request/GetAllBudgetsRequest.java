package BudgetTracker.Activities.Request;

public class GetAllBudgetsRequest {
    private GetAllBudgetsRequest() {}


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public GetAllBudgetsRequest build() {
            return new GetAllBudgetsRequest();
        }
    }
}

