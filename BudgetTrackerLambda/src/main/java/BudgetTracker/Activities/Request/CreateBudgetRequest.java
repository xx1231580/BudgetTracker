package BudgetTracker.Activities.Request;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateBudgetRequest.Builder.class)
public class CreateBudgetRequest {

    private final String monthlyIncome;




    private CreateBudgetRequest(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }


    public String getMonthlyIncome() {
        return monthlyIncome;
    }



    @Override
    public String toString() {
        return "CreateBudgetRequest{" +
            "monthlyIncome='" + monthlyIncome + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateBudgetRequest that = (CreateBudgetRequest) o;
        return Objects.equals(monthlyIncome, that.monthlyIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthlyIncome);
    }

    public static Builder builder() {return new Builder();}

    @JsonPOJOBuilder
    public static class Builder {

        private String monthlyIncome;



        public Builder withMonthlyIncome(String monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }



        public CreateBudgetRequest build() {
            return new CreateBudgetRequest(this.monthlyIncome);
        }
    }
}
