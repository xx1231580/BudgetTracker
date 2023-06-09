package BudgetTracker.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class AuthenticatedLambdaRequest<T> extends LambdaRequest<T> {

    public T fromUserClaims(Function<Map<String, String>, T> converter) {
        try {
            return converter.apply(getClaims());
        } catch (Exception e) {
            throw new RuntimeException("Unable to get user information from request.", e);
        }
    }

    private Map<String, String> getClaims() throws JsonProcessingException {

        return System.getenv().get("AWS_SAM_LOCAL") == null ?
            (Map<String, String>) super.getRequestContext().getAuthorizer().get("claims") :
            getClaimsFromAuthHeader(super.getHeaders().get("Authorization"));
    }

    private Map<String, String> getClaimsFromAuthHeader(final String authorizationHeader)
        throws JsonProcessingException {
        String jwt = getJWTFromAuthHeader(authorizationHeader);
        return getClaimsFromJWT(jwt);
    }

    private String getJWTFromAuthHeader(final String authorizationHeader) {
        return authorizationHeader.split("\\s")[1];
    }

    private Map<String, String> getClaimsFromJWT(final String jwt) throws JsonProcessingException {
        Base64.Decoder decoder = Base64.getDecoder();

        String[] sections = jwt.split("\\.");
        String payload = new String(decoder.decode(sections[1]));

        return super.MAPPER.readValue(payload, new TypeReference<HashMap<String, String>>() {
        });
    }
}
