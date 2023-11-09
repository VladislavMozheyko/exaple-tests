package api.reqres;

public class UnSuccessRegistration {
    private String error;

    public UnSuccessRegistration(String error) {
        this.error = error;
    }

    public UnSuccessRegistration() {
    }

    public String getError() {
        return error;
    }
}
