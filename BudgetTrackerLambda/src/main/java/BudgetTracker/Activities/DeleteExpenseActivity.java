package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.CreateExpenseRequest;
import BudgetTracker.Activities.Request.DeleteExpenseRequest;
import BudgetTracker.Activities.Results.CreateExpenseResult;
import BudgetTracker.Activities.Results.DeleteExpenseResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.ExpenseDao;
import BudgetTracker.dynamodb.models.Expense;
import BudgetTracker.models.ExpenseModel;

public class DeleteExpenseActivity {
    private final ExpenseDao expenseDao;

    @Inject
    public DeleteExpenseActivity(ExpenseDao expenseDao) {this.expenseDao = expenseDao;}

    public DeleteExpenseResult handleRequest(final DeleteExpenseRequest DeleteExpenseRequest) {
        Expense expense = new Expense();
        expense.setExpenseId(DeleteExpenseRequest.getExpenseId());
        expense.setExpenseName(DeleteExpenseRequest.getExpenseName());
        expense.setBudgetId(DeleteExpenseRequest.getBudgetId());
        expense.setExpenseValue(DeleteExpenseRequest.getExpenseValue());

        expenseDao.deleteExpense(expense);

        ExpenseModel expenseModel = new ModelConverter().toExpenseModel(expense);

        return DeleteExpenseResult.builder()
            .withExpenseModel(expenseModel)
            .build();
    }
}
