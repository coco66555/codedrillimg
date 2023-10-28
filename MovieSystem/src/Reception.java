import java.util.LinkedList;
import java.util.List;

public class Reception extends Service{
    List<String> firstReceptionList = new LinkedList<String>();
    Reception(){
        super();
    }

    @Override
    public int searchSelfNum() {
        return searchNum;
    }

    @Override
    public void logIn(List<List<String>> ReceptionMessage) {
        super.logIn(Attribute.ReceptionMessage);
    }

    @Override
    public void rewriteKey(List<List<String>> ReceptionMessage) {
        super.rewriteKey(Attribute.ReceptionMessage);
   }

    @Override
    public void registration(List<List<String>> ReceptionMessage) {
        super.registration(Attribute.ReceptionMessage);
    }

    @Override
    public void signOut() {
        super.signOut();
    }

    @Override
    public void showPlatform() {
        super.showPlatform();
    }

    @Override
    public void showLogPlatform(List<List<String>> ReceptionMessage) {
        super.showLogPlatform(Attribute.ReceptionMessage);
    }

    @Override
    public void showServicePlatform() {

    }

    @Override
    public void showManageKeyPlatform() {

    }
    public void firstReception(String accountName,String accountKey){
        firstReceptionList.add(accountName);
        firstReceptionList.add(accountKey);
        firstReceptionList.add("0");
        Attribute.ReceptionMessage.add(firstReceptionList);
    }
}
