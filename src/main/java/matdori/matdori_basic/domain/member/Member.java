package matdori.matdori_basic.domain.member;

public class Member {
    private Long id;    //생성 시 할당됨
    private String loginId;
    private String nickName;
    private String password;

    public Member(String loginId, String nickName, String password) {
        this.loginId = loginId;
        this.nickName = nickName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member() {

    }
}
