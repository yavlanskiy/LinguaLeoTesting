package utils;

public class TestData {
    private String userName;
    private String userEmail;
    private String userPass;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public TestData setRandomUser() {
        this.setUserName(String.format("%s %s",
                StringHelper.generateRandomString(4, 10),
                StringHelper.generateRandomString(4, 10)));
        this.setUserEmail(StringHelper.generateRandomEmail());
        setUserPass("123456qwerty");
        return this;
    }


}
