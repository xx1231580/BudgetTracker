package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.dynamodb.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BudgetTracker.Activities.Request.CreateBudgetRequest;
import BudgetTracker.Activities.Results.CreateBudgetResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.BudgetDao;
import BudgetTracker.dynamodb.models.Budget;
import BudgetTracker.models.BudgetModel;
import BudgetTracker.utils.BudgetTrackerUtils;

public class CreateBudgetActivity {
    private static final Logger log = LogManager.getLogger();
    private final BudgetDao budgetDao;


    @Inject
    public CreateBudgetActivity( BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }


    public CreateBudgetResult handleRequest(final CreateBudgetRequest createBudgetRequest) {
        log.info("Received CreateBudgetRequest {}", createBudgetRequest);
        Budget newBudget = new Budget();
        newBudget.setBudgetId(BudgetTrackerUtils.generateId());
        newBudget.setMonthlyIncome(createBudgetRequest.getMonthlyIncome());


        budgetDao.saveBudget(newBudget);


        BudgetModel budgetModel = new ModelConverter().toBudgetModel(newBudget);

        return CreateBudgetResult.builder()
            .withBudget(budgetModel)
            .build();

    }
}

