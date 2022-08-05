import java.util.HashMap;

public class IDnPassword {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDnPassword() {

        loginInfo.put("Jumpei", "Daniela");
        loginInfo.put("Allan", "pizza");
        loginInfo.put("Sam", "online");
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

}
