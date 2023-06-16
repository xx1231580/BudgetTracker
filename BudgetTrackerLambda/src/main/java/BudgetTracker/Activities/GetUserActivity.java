package BudgetTracker.Activities;

import javax.inject.Inject;

import BudgetTracker.Activities.Request.GetUserRequest;
import BudgetTracker.Activities.Results.GetUserResult;
import BudgetTracker.converters.ModelConverter;
import BudgetTracker.dynamodb.UserDao;
import BudgetTracker.dynamodb.models.User;
import BudgetTracker.models.UserModel;


public class GetUserActivity {
    private final UserDao userDao;

    @Inject
    public GetUserActivity(UserDao userDao) {this.userDao = userDao;}

    public GetUserResult handleRequest(final GetUserRequest getUserRequest){

        String requestedId = getUserRequest.getUserId();

        User user = userDao.getUser(requestedId);
        UserModel userModel = new ModelConverter().toUserModel(user);

        return GetUserResult.builder().withUserModel(userModel).build();
    }
}
