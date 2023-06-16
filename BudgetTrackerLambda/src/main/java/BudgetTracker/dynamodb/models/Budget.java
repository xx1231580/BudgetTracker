package BudgetTracker.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "budget")
public class Budget {
    private String budgetId;

    private String monthlyIncome;

    private String serializedExpenses;

    @DynamoDBHashKey(attributeName = "budgetId")
    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    @DynamoDBAttribute(attributeName = "monthlyIncome")
    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    @DynamoDBAttribute(attributeName = "serializedExpenses")
    public String getSerializedExpenses() {
        return serializedExpenses;
    }

    public void setSerializedExpenses(String serializedExpenses) {
        this.serializedExpenses = serializedExpenses;
    }
}
