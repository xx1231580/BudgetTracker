package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.UpdateUserRequest;
import BudgetTracker.Activities.Results.UpdateUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateUserLambda extends LambdaActivityRunner<UpdateUserRequest, UpdateUserResult>
    implements RequestHandler<AuthenticatedLambdaRequest<UpdateUserRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateUserRequest> input, Context context) {
        return super.runActivity(
            () -> {
                UpdateUserRequest unauthenticatedRequest = input.fromBody(UpdateUserRequest.class);
                return input.fromUserClaims(claims ->
                    UpdateUserRequest.builder()
                        .withUserId(unauthenticatedRequest.getUserId())
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideUpdateUserActivity().handleRequest(request)
        );
    }
}
