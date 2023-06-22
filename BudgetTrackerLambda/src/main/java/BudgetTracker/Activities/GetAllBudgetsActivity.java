package BudgetTracker.Activities;

import javax.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

import BudgetTracker.Activities.Results.GetAllBudgetsResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.BudgetDao;
import BudgetTracker.models.BudgetModel;
import org.apache.logging.log4j.LogManager;

public class GetAllBudgetsActivity {

    public BudgetDao budgetDao;

    @Inject
    public GetAllBudgetsActivity(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    public GetAllBudgetsResult handleRequest() {

        ModelConverter modelConverter = new ModelConverter();

        List<BudgetModel> budgetModels = modelConverter.toListOfBudgetModels(budgetDao.getAllBudgets());

        return GetAllBudgetsResult.builder()
            .withBudgetList(budgetModels)
            .build();
    }
}

