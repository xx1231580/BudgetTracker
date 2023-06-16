package BudgetTracker.Activities.Request;

public class GetExpensesRequest {
    private final String budgetId;

    private GetExpensesRequest(String budgetId) {this.budgetId = budgetId; }

    public String getBudgetId() {
        return budgetId;
    }


        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String budgetId;

            public Builder withBudgetId(String budgetId) {
                this.budgetId = budgetId;
                return this;
            }

            public GetExpensesRequest build() {
                return new GetExpensesRequest(budgetId);
            }
        }
    }

