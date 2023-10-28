import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Administrator extends Service{
    List<String> firstAdministratorList = new LinkedList<String>();
    Scanner reader = new Scanner(System.in);
    Administrator(){
        super();
    }

    @Override
    public int searchSelfNum() {
        return searchNum;
    }

    @Override
    public void logIn(List<List<String>> AdministratorMessage) {
        super.logIn(Attribute.AdministratorMessage);

        /*int backNum=1;
        while (!(backNum==0)){
            System.out.println("请输入账号");
            accountName=reader.next();
            System.out.println("请输入密码");
            accountKey=reader.next();
            for(int i=0;i<Attribute.AdministratorMessage.size();i++){
                if(accountName.equals(Attribute.AdministratorMessage.get(i).get(0))){
                    if(accountKey.equals(Attribute.AdministratorMessage.get(i).get(1))){
                        System.out.println("登陆成功");
                        searchNum=i;
                        backNum=0;
                        break;
                    }
                }
                if(i==Attribute.AdministratorMessage.size()-1){
                    System.out.println("账号或密码错误");
                }
            }
        }*/

    }

    @Override
    public void rewriteKey(List<List<String>> AdministratorMessage) {
        super.rewriteKey(Attribute.AdministratorMessage);
        /*int backNum=1;
        String OldKey,NewKey,RepeatedKey;
        while (!(backNum==0)){
            System.out.println("请输入原来的密码：");
            OldKey=reader.next();
            if(OldKey.equals(Attribute.AdministratorMessage.get(searchNum).get(1))){
                while(!(backNum==0)){
                    System.out.println("请输入新密码：");
                    NewKey=reader.next();
                    System.out.println("请确认您的密码：");
                    RepeatedKey=reader.next();
                    if(NewKey.equals(RepeatedKey)){
                        System.out.println("修改成功");
                        backNum=0;
                        Attribute.AdministratorMessage.get(searchNum).set(1,NewKey);
                    }else{
                        System.out.println("两次输入的密码不一致，请重新输入");
                    }
                }
            }else{
                System.out.println("您输入的密码错误");
            }
        }*/
    }

    @Override
    public void registration(List<List<String>> AdministratorMessage) {
        super.registration(Attribute.AdministratorMessage);
        /*List<String> newMessage = new LinkedList<String>();
        String confirmAccountKey;
        int backNum=1;
        while (!(backNum==0)) {
            System.out.println("请输入您要注册的账号：");
            accountName = reader.next();
            for (int i = 0; i < Attribute.AdministratorMessage.size(); i++) {
                if (accountName.equals(Attribute.AdministratorMessage.get(i).get(0))) {
                    System.out.println("该账号已被注册");
                    break;
                }
                if(i==Attribute.AdministratorMessage.size()-1){
                    backNum=0;
                    newMessage.add(accountName);
                }
            }
        }
        while (!(backNum==1)){
            System.out.println("请输入您的密码：");
            accountKey = reader.next();
            System.out.println("请确认您的密码：");
            confirmAccountKey = reader.next();
            if (accountKey.equals(confirmAccountKey)) {
                System.out.println("注册成功");
                backNum = 1;
                newMessage.add(accountKey);
            }
            else{
                System.out.println("您输入的密码不一致");
            }
        }
        Attribute.AdministratorMessage.add(newMessage);*/
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
    public void showLogPlatform(List<List<String>> AdministratorMessage) {
        super.showLogPlatform(Attribute.AdministratorMessage);
        /*int chooseNum=0,backNum=1;
        while(!(backNum==0)) {
            System.out.println("请选择登录方式：");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum) {
                case 1:logIn(Attribute.AdministratorMessage);
                    showServicePlatform();
                    break;
                case 2:registration(Attribute.AdministratorMessage);
                    break;
                case 0:backNum=0;
            }
        }*/
    }

    @Override
    public void showServicePlatform() {
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.密码管理");
            System.out.println("2.用户管理");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:showManageKeyPlatform();break;
                case 2:showManageCustomerPlatform();break;
                case 0:signOut();backNum=0;break;
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
            System.out.println("2.重置用户密码");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:rewriteKey(Attribute.AdministratorMessage);break;
                case 2:reSetKey();break;
                case 0:backNum=0;break;
                default:System.out.println("输入错误");
            }
        }
    }

    public void reSetKey(){
        int backNum=1;
        String sequenceNum="0",NewKey;
        while (!(backNum==0)){
            System.out.println("请输入要重置的顾客序号");
            sequenceNum=reader.next();
            for(int i=0;i<Attribute.CustomerMessage.size();i++){
                if(sequenceNum.equals(Attribute.CustomerMessage.get(i).get(2))){
                    System.out.println("请输入新密码");
                    NewKey=reader.next();
                    Attribute.CustomerMessage.get(i).set(1,NewKey);
                    System.out.println("重置成功");
                    backNum=0;
                    break;
                }if(i==Attribute.CustomerMessage.size()-1){
                    System.out.println("未找到该顾客");
                }
            }
        }
    }

    public void showManageCustomerPlatform(){
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.查看用户");
            System.out.println("2.添加用户");
            System.out.println("3.删除用户");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:checkCustomer();break;
                case 2:addCustomer(Attribute.CustomerMessage);break;
                case 3:deleteCustomer();break;
                case 0:backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }

    public void checkCustomer(){
        System.out.println("账号    密码    序号    用户级别    用户注册时间    用户累计消费金额    用户累计消费次数    用户手机号    用户邮箱");
        for(int i=0;i<Attribute.CustomerMessage.size();i++){
            for(int j=0;j<Attribute.CustomerMessage.get(i).size();j++){
                if(j==1){
                    System.out.print("********    ");
                    continue;
                }
                System.out.print(Attribute.CustomerMessage.get(i).get(j)+"    ");
            }
            System.out.println("\n");
        }
    }

    public void addCustomer(List<List<String>> registrationAccount){
        super.registration(registrationAccount);
    }

    public void deleteCustomer(){
        String deleteNum;
        System.out.println("请输入您要删除的序号");
        deleteNum=reader.next();
        for(int i=0;i<Attribute.CustomerMessage.size();i++){
            if(deleteNum.equals(Attribute.CustomerMessage.get(i).get(2))){
                Attribute.CustomerMessage.remove(i);
                for(int j=i;j<Attribute.CustomerMessage.size();j++){
                    Attribute.CustomerMessage.get(j).set(2,String.valueOf(j+1));
                }
                break;
            }
            if(i==Attribute.CustomerMessage.size()-1){
                System.out.println("没有该用户");
                break;
            }
        }
    }
    public void firstAdministrator(String accountName,String accountKey){
        firstAdministratorList.add(accountName);
        firstAdministratorList.add(accountKey);
        firstAdministratorList.add("0");
        Attribute.AdministratorMessage.add(firstAdministratorList);
    }
}
