package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.UpdateExpenseRequest;
import BudgetTracker.Activities.Results.UpdateExpenseResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.ExpenseDao;
import BudgetTracker.dynamodb.models.Expense;
import BudgetTracker.models.ExpenseModel;


public class UpdateExpenseActivity {
    private final ExpenseDao expenseDao;

    @Inject
    public UpdateExpenseActivity(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public UpdateExpenseResult handleRequest(final UpdateExpenseRequest updateExpenseRequest) {

        Expense expense = expenseDao.getExpense(updateExpenseRequest.getBudgetId(),
            updateExpenseRequest.getExpenseId());

        expense.setExpenseName(updateExpenseRequest.getExpenseName());
        expense.setExpenseValue(updateExpenseRequest.getExpenseValue());


        expense = expenseDao.saveExpense(expense);

        ExpenseModel expenseModel = new ModelConverter().toExpenseModel(expense);

        return UpdateExpenseResult.builder()
            .withExpenseModel(expenseModel)
            .build();

    }
}
