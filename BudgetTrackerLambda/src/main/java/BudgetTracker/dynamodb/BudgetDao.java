package BudgetTracker.dynamodb;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.dynamodb.models.User;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

@Singleton
public class BudgetDao {
    private final DynamoDBMapper mapper;

    @Inject
    public BudgetDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Budget getBudget(String budgetId){
        Budget budget = mapper.load(Budget.class, budgetId);

        return budget;
    }

    public Budget saveBudget(Budget budget) {
        mapper.save(budget);
        return budget;
    }

    public void deleteBudget(Budget budget){
        mapper.delete(budget);
    }

    public List<Budget> getAllBudgetsForUserId(String userId){
        if (userId == null) {
            throw new IllegalArgumentException("passed in userId is null");
        }

        List<Budget> budgetList = new ArrayList<>();

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":userId", new AttributeValue().withS(userId));

        DynamoDBQueryExpression<String> queryExpression = new DynamoDBQueryExpression<String>()
            .withKeyConditionExpression("userId = :userId")
            .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<String> budgetIdList = mapper.query(String.class, queryExpression);

        for(String budgetId : budgetIdList) {
            budgetList.add(mapper.load(Budget.class, budgetId));
        }

        return budgetList;
    }
}
