package BudgetTracker.lambda;

import BudgetTracker.Activities.Request.GetBudgetRequest;
import BudgetTracker.Activities.Results.GetBudgetResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetBudgetLambda extends LambdaActivityRunner<GetBudgetRequest, GetBudgetResult>
    implements RequestHandler<LambdaRequest<GetBudgetRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetBudgetRequest> input, Context context){
        return super.runActivity(
            () -> input.fromPath(path -> GetBudgetRequest.builder().withBudgetId(path.get("budgetId")).build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetBudgetActivity().handleRequest(request)

        );
    }
}
