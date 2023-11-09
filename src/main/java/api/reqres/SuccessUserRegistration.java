package api.reqres;

public class SuccessUserRegistration {
    private Integer id;
    private String token;

    public SuccessUserRegistration() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public SuccessUserRegistration(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}
