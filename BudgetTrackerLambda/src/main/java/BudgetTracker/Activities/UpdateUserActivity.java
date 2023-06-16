package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.UpdateUserRequest;
import BudgetTracker.Activities.Results.UpdateUserResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.UserDao;
import BudgetTracker.dynamodb.models.User;
import BudgetTracker.models.UserModel;

public class UpdateUserActivity {
    private final UserDao userDao;

    @Inject
    public UpdateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    public UpdateUserResult handleRequest(final UpdateUserRequest updateUserRequest) {

        User user = userDao.getUser(updateUserRequest.getUserId());

        user.setBudgetId(updateUserRequest.getBudgetId());


        user = userDao.saveUser(user);

        UserModel userModel = new ModelConverter().toUserModel(user);

        return UpdateUserResult.builder()
            .withUserModel(userModel)
            .build();

    }
}
