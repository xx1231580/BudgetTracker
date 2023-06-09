package BudgetTracker.dependancy;



import BudgetTracker.Activities.CreateBudgetActivity;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {
    CreateBudgetActivity provideCreateBudgetActivity();
}