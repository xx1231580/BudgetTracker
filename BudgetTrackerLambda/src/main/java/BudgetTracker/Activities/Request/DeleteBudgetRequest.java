package BudgetTracker.Activities.Request;

import java.util.Objects;

import BudgetTracker.Activities.Request.CreateBudgetRequest;

public class DeleteBudgetRequest {
    private final String budgetId;

    private final String monthlyIncome;

    private DeleteBudgetRequest(String budgetId , String monthlyIncome) {
        this.budgetId = budgetId;
        this.monthlyIncome = monthlyIncome;

    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }



    @Override
    public String toString() {
        return "CreateBudgetRequest{" +
            "budgetId='" + budgetId + '\'' +
            ", monthlyIncome='" + monthlyIncome + '\'' +
            ", serializedExpenses='" + '\'' +
            '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(budgetId);
    }

    public static Builder builder() {return new Builder();}


    public static class Builder {
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



        public DeleteBudgetRequest build() {
            return new DeleteBudgetRequest(this.budgetId, this.monthlyIncome);
        }
    }
}
