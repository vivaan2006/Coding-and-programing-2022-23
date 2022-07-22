import java.util.HashMap;

public class IDandPasswords {
    public HashMap<String, String> loginInfo = new HashMap<String, String>();

    public IDandPasswords() {
        loginInfo.put("adharsh.ramakrishnan", "1234");
        loginInfo.put("vivaan.rajesh", "1234");
        loginInfo.put("akash.chandra", "1234");
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }

}
