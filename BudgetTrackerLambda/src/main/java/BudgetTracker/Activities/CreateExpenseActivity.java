package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.CreateExpenseRequest;
import BudgetTracker.Activities.Results.CreateExpenseResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.ExpenseDao;
import BudgetTracker.dynamodb.models.Expense;
import BudgetTracker.models.ExpenseModel;

public class CreateExpenseActivity {
    private final ExpenseDao expenseDao;

    @Inject
    public CreateExpenseActivity(ExpenseDao expenseDao) {this.expenseDao = expenseDao;}

    public CreateExpenseResult handleRequest(final CreateExpenseRequest createExpenseRequest) {
        Expense expense = new Expense();
        expense.setExpenseId(createExpenseRequest.getExpenseId());
        expense.setExpenseName(createExpenseRequest.getExpenseName());
        expense.setBudgetId(createExpenseRequest.getBudgetId());
        expense.setExpenseValue(createExpenseRequest.getExpenseValue());

        expenseDao.saveExpense(expense);

        ExpenseModel expenseModel = new ModelConverter().toExpenseModel(expense);

        return CreateExpenseResult.builder()
            .withExpenseModel(expenseModel)
            .build();
    }
}
