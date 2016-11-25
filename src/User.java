/**
 * Created by Administrator on 2016/11/25.
 */
public class User {
    public static final int NOUSERNAME = 0;
    public static final int WRONGPWD = 1;
    public static final int LOGINSUCCESS = 2;

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUsername() {
        //判断username是否存在
        return true;
    }

    public boolean checkPassword(String username, String password) {
        //判断用户登录密码是否正确
        return true;
    }

    public int checkLogin() {
        if (checkUsername()) {
            if (checkPassword(this.username, this.password)) {
                return LOGINSUCCESS;
            } else {
                return WRONGPWD;
            }
        }
        return NOUSERNAME;
    }
}