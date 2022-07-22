public class FrameViewer {
    public static void main(String[] args) {
        IDandPasswords ids = new IDandPasswords();
        LoginScreen login = new LoginScreen(ids.getLoginInfo());
    }
}
