package BudgetTracker.lambda;



import BudgetTracker.Activities.Request.GetAllBudgetsRequest;
import BudgetTracker.Activities.Results.GetAllBudgetsResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetAllBudgetsLambda extends LambdaActivityRunner<GetAllBudgetsRequest, GetAllBudgetsResult>
    implements RequestHandler<LambdaRequest<GetAllBudgetsRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllBudgetsRequest> input, Context context) {
        log.info("handleRequest");
        return super.runActivity(
            () -> input.fromPath(path ->
                GetAllBudgetsRequest.builder()
                    .build()),
            (request, serviceComponent) ->
                serviceComponent.provideGetAllBudgetsActivity().handleRequest()
        );
    }
}
