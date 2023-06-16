package BudgetTracker.dynamodb.models;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "user_account")
public class User {
    public String userId;

    public String budgetId;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "budgetId")
    public String getBudgetId(){
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }
}
