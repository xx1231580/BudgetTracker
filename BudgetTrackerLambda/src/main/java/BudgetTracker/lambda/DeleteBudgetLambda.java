package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.DeleteBudgetRequest;
import BudgetTracker.Activities.Results.DeleteBudgetResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class DeleteBudgetLambda extends LambdaActivityRunner<DeleteBudgetRequest, DeleteBudgetResult>
    implements RequestHandler<AuthenticatedLambdaRequest<DeleteBudgetRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteBudgetRequest> input, Context context) {
        return super.runActivity(
            () -> {
                DeleteBudgetRequest unauthenticatedRequest = input.fromBody(DeleteBudgetRequest.class);
                return input.fromUserClaims(claims ->
                    DeleteBudgetRequest.builder()
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withExpenses(unauthenticatedRequest.getSerializedExpenses())
                        .withMonthlyIncome(unauthenticatedRequest.getMonthlyIncome())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideDeleteBudgetActivity().handleRequest(request)
        );
    }
}
