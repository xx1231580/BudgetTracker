package BudgetTracker.lambda;


import BudgetTracker.Activities.Request.UpdateExpenseRequest;
import BudgetTracker.Activities.Results.UpdateExpenseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class UpdateExpenseLambda extends LambdaActivityRunner<UpdateExpenseRequest, UpdateExpenseResult>
    implements RequestHandler<AuthenticatedLambdaRequest<UpdateExpenseRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateExpenseRequest> input, Context context) {
        return super.runActivity(
            () -> {
                UpdateExpenseRequest unauthenticatedRequest = input.fromBody(UpdateExpenseRequest.class);
                return input.fromUserClaims(claims ->
                    UpdateExpenseRequest.builder()
                        .withExpenseId(unauthenticatedRequest.getExpenseId())
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withExpenseName(unauthenticatedRequest.getExpenseName())
                        .withExpenseValue(unauthenticatedRequest.getExpenseValue())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideUpdateExpenseActivity().handleRequest(request)
        );
    }
}
