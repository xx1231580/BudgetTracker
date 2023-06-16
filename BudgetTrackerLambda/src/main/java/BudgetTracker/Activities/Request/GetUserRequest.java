package BudgetTracker.Activities.Request;

public class GetUserRequest {
    private final String userId;

    private GetUserRequest(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }


    public static GetUserRequest.Builder builder(){
        return new GetUserRequest.Builder();
    }

    public static class Builder {
        private String userId;

        public GetUserRequest.Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public GetUserRequest build(){
            return new GetUserRequest(this.userId);
        }
    }
}
