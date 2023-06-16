package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.DeleteBudgetRequest;
import BudgetTracker.Activities.Results.DeleteBudgetResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.BudgetDao;
import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.models.BudgetModel;
import BudgetTracker.utils.BudgetTrackerUtils;

public class DeleteBudgetActivity {
    private final BudgetDao budgetDao;


    @Inject
    public DeleteBudgetActivity( BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }


    public DeleteBudgetResult handleRequest(final DeleteBudgetRequest deleteBudgetRequest) {

        Budget budget = new Budget();
        budget.setBudgetId(deleteBudgetRequest.getBudgetId());
        budget.setMonthlyIncome(deleteBudgetRequest.getMonthlyIncome());
        budget.setSerializedExpenses(deleteBudgetRequest.getSerializedExpenses());

        budgetDao.deleteBudget(budget);

        BudgetModel budgetModel = new ModelConverter().toBudgetModel(budget);

        return DeleteBudgetResult.builder()
            .withBudget(budgetModel)
            .build();

    }
}
