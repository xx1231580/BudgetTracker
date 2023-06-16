package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.GetBudgetRequest;
import BudgetTracker.Activities.Results.GetBudgetResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.BudgetDao;
import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.models.BudgetModel;

public class GetBudgetActivity {
    private final BudgetDao budgetDao;

    @Inject
    public GetBudgetActivity(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    public GetBudgetResult handleRequest(final GetBudgetRequest getBudgetRequest){

        String requestedId = getBudgetRequest.getBudgetId();

        Budget budget = budgetDao.getBudget(requestedId);
        BudgetModel budgetModel = new ModelConverter().toBudgetModel(budget);

        return GetBudgetResult.builder().withBudgetModel(budgetModel).build();
    }

}
