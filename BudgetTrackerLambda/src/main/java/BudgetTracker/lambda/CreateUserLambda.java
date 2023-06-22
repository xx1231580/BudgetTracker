package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.CreateUserRequest;
import BudgetTracker.Activities.Results.CreateUserResult;
import BudgetTracker.utils.BudgetTrackerUtils;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateUserLambda extends LambdaActivityRunner<CreateUserRequest, CreateUserResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateUserRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateUserRequest> input, Context context) {
        return super.runActivity(
            () -> {
                CreateUserRequest unauthenticatedRequest = input.fromBody(CreateUserRequest.class);
                return input.fromUserClaims(claims ->
                    CreateUserRequest.builder()
                        .withUserId(claims.get("email"))
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideCreateUserActivity().handleRequest(request)
        );
    } 
}
