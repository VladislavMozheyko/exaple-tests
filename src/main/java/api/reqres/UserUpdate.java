package api.reqres;

public class UserUpdate {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public UserUpdate(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UserUpdate() {
    }
}
