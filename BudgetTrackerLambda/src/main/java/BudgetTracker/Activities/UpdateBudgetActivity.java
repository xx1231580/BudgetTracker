package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.UpdateBudgetRequest;
import BudgetTracker.Activities.Results.UpdateBudgetResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.BudgetDao;
import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.models.BudgetModel;

public class UpdateBudgetActivity {


    private final BudgetDao budgetDao;

    @Inject
    public UpdateBudgetActivity(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    public UpdateBudgetResult handleRequest(final UpdateBudgetRequest updateBudgetRequest) {

        Budget budget = budgetDao.getBudget(updateBudgetRequest.getBudgetId());

        budget.setMonthlyIncome(updateBudgetRequest.getMonthlyIncome());

        if (updateBudgetRequest.getSerializedExpenses() != null &&
            updateBudgetRequest.getSerializedExpenses().equals("")) {
                budget.setSerializedExpenses(updateBudgetRequest.getSerializedExpenses());
        }

        budget = budgetDao.saveBudget(budget);

        BudgetModel budgetModel = new ModelConverter().toBudgetModel(budget);

        return UpdateBudgetResult.builder()
            .withBudget(budgetModel)
            .build();

    }
}
