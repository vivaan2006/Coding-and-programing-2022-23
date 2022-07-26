import java.util.HashMap;

public class IDandPasswordsStudent {
    public HashMap<String, String> loginInfo = new HashMap<String, String>();

    public IDandPasswordsStudent() {
        loginInfo.put("adharsh.ramakrishnan", "1234");
        loginInfo.put("vivaan.rajesh", "1234");

    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }

}
