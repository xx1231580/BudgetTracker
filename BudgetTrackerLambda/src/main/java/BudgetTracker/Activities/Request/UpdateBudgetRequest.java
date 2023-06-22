package BudgetTracker.Activities.Request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class UpdateBudgetRequest {
    private final String budgetId;

    private final String monthlyIncome;



    public UpdateBudgetRequest(String budgetId, String monthlyIncome) {
       this.budgetId = budgetId;
       this.monthlyIncome = monthlyIncome;

    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private String budgetId;

        private String monthlyIncome;




        public Builder withBudgetId(String budgetId) {
           this.budgetId = budgetId;
            return this;
        }

        public Builder withMonthlyIncome(String monthlyIncome) {
           this.monthlyIncome = monthlyIncome;
            return this;
        }





        public UpdateBudgetRequest build() {
            return new UpdateBudgetRequest(this.budgetId, this.monthlyIncome);
        }
    }
}
