package article.model;

public class Member {
    private int id;
    private String userId;
    private String userPw;
    private String userName;
    private String regDate;
    public Member(int id, String userId, String userPw, String userName, String regDate) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
