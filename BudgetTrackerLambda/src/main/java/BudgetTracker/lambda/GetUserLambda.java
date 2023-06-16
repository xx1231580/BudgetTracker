package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.GetUserRequest;
import BudgetTracker.Activities.Results.GetUserResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetUserLambda extends LambdaActivityRunner<GetUserRequest, GetUserResult>
    implements RequestHandler<LambdaRequest<GetUserRequest>, LambdaResponse> {

@Override
public LambdaResponse handleRequest(LambdaRequest<GetUserRequest> input, Context context){
    return super.runActivity(
    () -> input.fromPath(path -> GetUserRequest.builder().withUserId(path.get("userId")).build()),
    (request, serviceComponent) ->
    serviceComponent.provideGetUserActivity().handleRequest(request)

    );
    }
}
