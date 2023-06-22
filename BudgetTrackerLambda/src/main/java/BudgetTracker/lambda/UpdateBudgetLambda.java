package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.UpdateBudgetRequest;
import BudgetTracker.Activities.Results.UpdateBudgetResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class UpdateBudgetLambda  extends LambdaActivityRunner<UpdateBudgetRequest, UpdateBudgetResult>
    implements RequestHandler<AuthenticatedLambdaRequest<UpdateBudgetRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<UpdateBudgetRequest> input, Context context) {
        return super.runActivity(
            () -> {
                UpdateBudgetRequest unauthenticatedRequest = input.fromBody(UpdateBudgetRequest.class);
                return input.fromUserClaims(claims ->
                    UpdateBudgetRequest.builder()
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withMonthlyIncome(unauthenticatedRequest.getMonthlyIncome())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideUpdateBudgetActivity().handleRequest(request)
        );
    }
}
