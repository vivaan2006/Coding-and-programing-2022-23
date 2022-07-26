import java.util.HashMap;

public class IDandPasswordsAdmin {
    public HashMap<String, String> loginInfo = new HashMap<String, String>();

    public IDandPasswordsAdmin() {
        loginInfo.put("adharsh.ramakrishnan", "1234");
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
