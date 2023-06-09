package BudgetTracker.dynamodb;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.dynamodb.models.Expense;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class ExpenseDao {
    private final DynamoDBMapper mapper;

    @Inject
    public ExpenseDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Expense getExpense(String budgetId, String expenseId) {
       Expense expense = mapper.load(Expense.class, budgetId, expenseId);

       return expense;
    }

    public Expense saveExpense(Expense expense) {
        mapper.save(expense);
        return expense;
    }

    public void deleteExpense(Expense expense){
        mapper.delete(expense);
    }

    public List<Expense> getAllExpensesForBudgetId(String budgetId) {
        if (budgetId == null) {
            throw new IllegalArgumentException("passed in userId is null");
        }

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":budgetId", new AttributeValue().withS(budgetId));

        DynamoDBQueryExpression<Expense> queryExpression = new DynamoDBQueryExpression<Expense>()
            .withKeyConditionExpression("budgetId = :budgetId")
            .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Expense> expenseList = mapper.query(Expense.class, queryExpression);

        return expenseList;
    }


}
