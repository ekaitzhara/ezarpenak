package ehu.isad.controller.model;

public class Ezarpena {

    private Integer userId;
    private String key;
    private String value;

    public Ezarpena(Integer userId, String key, String value) {
        this.userId = userId;
        this.key = key;
        this.value = value;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }



    @Override
    public String toString() {
        return "Ezarpena{" +
                "userId=" + userId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '\n';
    }
}
