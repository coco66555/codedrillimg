import java.util.LinkedList;
import java.util.List;

public class Customer extends Service{
    List<String> firstCustomerList = new LinkedList<String>();
    Customer(){
        super();
    }

    @Override
    public int searchSelfNum() {
        return searchNum;
    }

    @Override
    public void logIn(List<List<String>> CustomerMessage) {
        super.logIn(Attribute.CustomerMessage);
    }

    @Override
    public void rewriteKey(List<List<String>> CustomerMessage) {
        super.rewriteKey(Attribute.CustomerMessage);
    }

    @Override
    public void registration(List<List<String>> CustomerMessage) {
        super.registration(Attribute.CustomerMessage);
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
    public void showLogPlatform(List<List<String>> CustomerMessage) {
        super.showLogPlatform(Attribute.CustomerMessage);
    }

    @Override
    public void showServicePlatform() {
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.密码管理");
            System.out.println("2.购票");
            System.out.println("3.查看个人信息");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:showManageKeyPlatform();break;
                case 2:showBuyTicketPlatform();break;
                case 3:showCheckSelfMessagePlatform();break;
                case 0:signOut();backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }

    @Override
    public void showManageKeyPlatform() {
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.修改密码");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:rewriteKey(Attribute.CustomerMessage);break;
                case 0:backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }

    public void showBuyTicketPlatform(){

    }

    public void showCheckSelfMessagePlatform(){
        System.out.println("您的信息如下：");
        checkSelfMessage();
    }

    public void checkSelfMessage(){
        System.out.println("账号："+Attribute.CustomerMessage.get(super.searchNum).get(0));
        System.out.println("密码："+"********");
        System.out.println("序号："+Attribute.CustomerMessage.get(super.searchNum).get(2));
        System.out.println("用户等级："+Attribute.CustomerMessage.get(super.searchNum).get(3));
        System.out.println("注册时间："+Attribute.CustomerMessage.get(super.searchNum).get(4));
        System.out.println("消费金额："+Attribute.CustomerMessage.get(super.searchNum).get(5));
        System.out.println("消费次数："+Attribute.CustomerMessage.get(super.searchNum).get(6));
        System.out.println("注册手机号："+Attribute.CustomerMessage.get(super.searchNum).get(7));
        System.out.println("注册邮箱："+Attribute.CustomerMessage.get(super.searchNum).get(8));
    }
    public void firstCustomer(String accountName,String accountKey){
        firstCustomerList.add(accountName);
        firstCustomerList.add(accountKey);
        firstCustomerList.add("1");
        firstCustomerList.add("铜牌用户");
        firstCustomerList.add("2022-2-2");
        firstCustomerList.add("0");
        firstCustomerList.add("0");
        firstCustomerList.add("phoneNum");
        firstCustomerList.add("e-mail");
        Attribute.CustomerMessage.add(firstCustomerList);
    }
}
