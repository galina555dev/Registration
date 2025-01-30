import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String nickname;
    private String password;
    private Date registrationDate;

    public User(String nickname, String password, Date registrationDate) {
        this.nickname = nickname;
        this.password = password;
        this.registrationDate = new Date();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
