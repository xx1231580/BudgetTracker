package BudgetTracker.Activities;

import javax.inject.Inject;

import java.util.List;

import BudgetTracker.Activities.Request.GetExpensesRequest;
import BudgetTracker.Activities.Results.GetExpensesResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.ExpenseDao;
import BudgetTracker.dynamodb.models.Expense;
import BudgetTracker.models.ExpenseModel;

public class GetExpensesActivity {
    private final ExpenseDao expenseDao;

    @Inject
    public GetExpensesActivity(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public GetExpensesResult handleRequest(final GetExpensesRequest getExpensesRequest) {


        List<Expense> expenses = expenseDao.getAllExpensesForBudgetId(getExpensesRequest.getBudgetId());
        List<ExpenseModel> expenseModels = new ModelConverter().toListOfExpenseModels(expenses);

        return GetExpensesResult.builder()
            .withExpenseList(expenseModels)
            .build();
    }
}
