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

    public List<Budget> getAllBudgets() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        return mapper.scan(Budget.class, scanExpression);
    }
}
