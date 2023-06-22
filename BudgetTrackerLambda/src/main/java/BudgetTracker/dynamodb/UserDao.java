package BudgetTracker.dynamodb;

import javax.inject.Inject;

import BudgetTracker.dynamodb.models.User;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class UserDao {
    private final DynamoDBMapper mapper;

    @Inject
    public UserDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public User getUser(String userId){
        User user = mapper.load(User.class, userId);

        return user;
    }

    public User saveUser(User user) {
        if(mapper.load(User.class, user) == null) {
            mapper.save(user);
            return user;
        }

        return user;
    }

    public void deleteUser(User user) {
        mapper.delete(user);
    }

}
