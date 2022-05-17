package app.domain;

public class User {
    private Long id;
    private String name;
    private String email;
    private String account;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccount() {
        return account;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(String account){
        this.account = account;
    }

}