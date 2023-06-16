package BudgetTracker.lambda;


import BudgetTracker.Activities.Request.DeleteExpenseRequest;
import BudgetTracker.Activities.Results.DeleteExpenseResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class DeleteExpenseLambda extends LambdaActivityRunner<DeleteExpenseRequest, DeleteExpenseResult>
    implements RequestHandler<AuthenticatedLambdaRequest<DeleteExpenseRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteExpenseRequest> input, Context context) {
        return super.runActivity(
            () -> {
                DeleteExpenseRequest unauthenticatedRequest = input.fromBody(DeleteExpenseRequest.class);
                return input.fromUserClaims(claims ->
                    DeleteExpenseRequest.builder()
                        .withExpenseId(unauthenticatedRequest.getExpenseId())
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withExpenseName(unauthenticatedRequest.getExpenseName())
                        .withExpenseValue(unauthenticatedRequest.getExpenseValue())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideDeleteExpenseActivity().handleRequest(request)
        );
    }
}
