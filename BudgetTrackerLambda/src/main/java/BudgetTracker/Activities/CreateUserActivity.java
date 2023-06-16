package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.CreateUserRequest;
import BudgetTracker.Activities.Results.CreateUserResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.UserDao;
import BudgetTracker.dynamodb.models.User;
import BudgetTracker.models.UserModel;

public class CreateUserActivity {
    private final UserDao userDao;

    @Inject
    CreateUserActivity(UserDao userDao) {this.userDao = userDao;}

    public CreateUserResult handleRequest(final CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUserId(createUserRequest.getUserId());
        user.setBudgetId(createUserRequest.getBudgetId());

        this.userDao.saveUser(user);

        UserModel userModel = new ModelConverter().toUserModel(user);

        return CreateUserResult.builder()
            .withUserModel(userModel)
            .build();
    }

}
