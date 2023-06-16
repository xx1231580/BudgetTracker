package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.CreateBudgetRequest;
import BudgetTracker.Activities.Results.CreateBudgetResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateBudgetLambda
        extends LambdaActivityRunner<CreateBudgetRequest, CreateBudgetResult>
        implements RequestHandler<AuthenticatedLambdaRequest<CreateBudgetRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateBudgetRequest> input, Context context) {
        return super.runActivity(
            () -> {
                CreateBudgetRequest unauthenticatedRequest = input.fromBody(CreateBudgetRequest.class);
                return input.fromUserClaims(claims ->
                    CreateBudgetRequest.builder()
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withExpenses(unauthenticatedRequest.getSerializedExpenses())
                        .withMonthlyIncome(unauthenticatedRequest.getMonthlyIncome())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideCreateBudgetActivity().handleRequest(request)
        );
    }
}
