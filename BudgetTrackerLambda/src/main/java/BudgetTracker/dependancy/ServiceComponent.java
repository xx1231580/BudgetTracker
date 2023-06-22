package BudgetTracker.dependancy;



import BudgetTracker.Activities.CreateBudgetActivity;
import BudgetTracker.Activities.CreateExpenseActivity;
import BudgetTracker.Activities.CreateUserActivity;
import BudgetTracker.Activities.DeleteBudgetActivity;
import BudgetTracker.Activities.DeleteExpenseActivity;
import BudgetTracker.Activities.GetAllBudgetsActivity;
import BudgetTracker.Activities.GetBudgetActivity;
import BudgetTracker.Activities.GetExpensesActivity;
import BudgetTracker.Activities.GetUserActivity;
import BudgetTracker.Activities.UpdateBudgetActivity;
import BudgetTracker.Activities.UpdateExpenseActivity;
import BudgetTracker.Activities.UpdateUserActivity;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {
    CreateBudgetActivity provideCreateBudgetActivity();
    DeleteBudgetActivity provideDeleteBudgetActivity();
    CreateExpenseActivity provideCreateExpenseActivity();
    DeleteExpenseActivity provideDeleteExpenseActivity();
    GetExpensesActivity provideGetExpensesActivity();
    CreateUserActivity provideCreateUserActivity();
    GetUserActivity provideGetUserActivity();
    GetBudgetActivity provideGetBudgetActivity();
    UpdateBudgetActivity provideUpdateBudgetActivity();
    UpdateExpenseActivity provideUpdateExpenseActivity();
    UpdateUserActivity provideUpdateUserActivity();
    GetAllBudgetsActivity provideGetAllBudgetsActivity();
}