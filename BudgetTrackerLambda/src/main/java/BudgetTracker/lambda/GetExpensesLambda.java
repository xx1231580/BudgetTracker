package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.GetExpensesRequest;
import BudgetTracker.Activities.Results.GetExpensesResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetExpensesLambda  extends LambdaActivityRunner<GetExpensesRequest, GetExpensesResult>
    implements RequestHandler<LambdaRequest<GetExpensesRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetExpensesRequest> input, Context context) {
        return super.runActivity(
            () -> input.fromPath(path ->
                GetExpensesRequest.builder()
                    .withBudgetId(path.get("budgetId"))
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetExpensesActivity().handleRequest(request)
        );
    }
}
