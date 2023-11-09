package api.reqres;

public class UpdatedUserInfo extends UserUpdate {
    private String updatedAt;

    public UpdatedUserInfo(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public UpdatedUserInfo() {
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
