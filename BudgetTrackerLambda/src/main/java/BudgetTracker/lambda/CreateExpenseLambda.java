package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.CreateExpenseRequest;
import BudgetTracker.Activities.Results.CreateExpenseResult;
import BudgetTracker.utils.BudgetTrackerUtils;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateExpenseLambda  extends LambdaActivityRunner<CreateExpenseRequest, CreateExpenseResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateExpenseRequest>, LambdaResponse> {
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateExpenseRequest> input, Context context) {
        return super.runActivity(
            () -> {
                CreateExpenseRequest unauthenticatedRequest = input.fromBody(CreateExpenseRequest.class);
                return input.fromUserClaims(claims ->
                    CreateExpenseRequest.builder()
                        .withExpenseId(BudgetTrackerUtils.generateId())
                        .withBudgetId(unauthenticatedRequest.getBudgetId())
                        .withExpenseName(unauthenticatedRequest.getExpenseName())
                        .withExpenseValue(unauthenticatedRequest.getExpenseValue())
                        .build());
            },
            (request, serviceComponent) ->
                serviceComponent.provideCreateExpenseActivity().handleRequest(request)
        );
    }
}
