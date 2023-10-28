import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//用户链表中所存储内容按顺序分别为账号、密码、序号、用户级别、用户注册时间、用户累计消费金额、用户累计消费次数、用户手机号、用户邮箱
//                           0     1    2      3         4           5               6           7       8
//电影链表中所存储内容按顺序分别为影片名称、导演、主演、类型、剧情介绍、时长
//                             0      1    2   3      4     5
//影院链表中所存储内容按顺序分别为影片名称、场次、时间、票价
//                             0      1   2    3
//                                   3n-1 3n-2 3n(n=1,2,3,......)
//                                    (   循环   )
public abstract class Service {
    List<List<String>> logInAccount = new LinkedList<>();
    String accountName;
    String accountKey;
    int searchNum=0;
    Scanner reader = new Scanner(System.in);
    Service(){
        this.accountName=".";
        this.accountKey=".";

    }
    public int searchSelfNum(){
        return searchNum;
    }
    public void logIn(List<List<String>> logInAccount){
        int backNum=1;
        while (!(backNum==0)){
            System.out.println("请输入账号");
            accountName=reader.next();
            System.out.println("请输入密码");
            accountKey=reader.next();
            for(int i=0;i<logInAccount.size();i++){
                if(accountName.equals(logInAccount.get(i).get(0))){
                    if(accountKey.equals(logInAccount.get(i).get(1))){
                        System.out.println("登陆成功");
                        searchNum=i;
                        backNum=0;
                        break;
                    }
                }
                if(i==logInAccount.size()-1){
                    System.out.println("账号或密码错误");
                }
            }
        }
    }
    public void rewriteKey(List<List<String>> logInAccount){
        int backNum=1;
        String OldKey,NewKey,RepeatedKey;
        while (!(backNum==0)){
            System.out.println("请输入原来的密码：");
            OldKey=reader.next();
            if(OldKey.equals(logInAccount.get(searchNum).get(1))){
                while(!(backNum==0)){
                    System.out.println("请输入新密码：");
                    NewKey=reader.next();
                    System.out.println("请确认您的密码：");
                    RepeatedKey=reader.next();
                    if(NewKey.equals(RepeatedKey)){
                        System.out.println("修改成功");
                        backNum=0;
                        logInAccount.get(searchNum).set(1,NewKey);
                    }else{
                        System.out.println("两次输入的密码不一致，请重新输入");
                    }
                }
            }else{
                System.out.println("您输入的密码错误");
            }
        }
    }
    public void registration(List<List<String>> registrationAccount){
        List<String> newMessage = new LinkedList<String>();
        String confirmAccountKey,registrationNum,registrationDate,registrationPhoneNum,registrationEmail;
        int backNum=1;
        while (!(backNum==0)) {
            System.out.println("请输入您要注册的账号：");
            accountName = reader.next();
            for (int i = 0; i < registrationAccount.size(); i++) {
                if (accountName.equals(registrationAccount.get(i).get(0))) {
                    System.out.println("该账号已被注册");
                    break;
                }
                if(i==registrationAccount.size()-1){
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
                newMessage.add(accountKey);
                registrationNum=String.valueOf(registrationAccount.size()+1);
                newMessage.add(registrationNum);
                newMessage.add("铜牌用户");
                System.out.println("请输入您的注册日期：");
                registrationDate=reader.next();
                newMessage.add(registrationDate);
                newMessage.add("0");
                newMessage.add("0");
                System.out.println("请输入您的注册手机号：");
                registrationPhoneNum=reader.next();
                newMessage.add(registrationPhoneNum);
                System.out.println("请输入您的注册邮箱：");
                registrationEmail=reader.next();
                newMessage.add(registrationEmail);
                System.out.println("注册成功");
                backNum = 1;
            }
            else{
                System.out.println("您输入的密码不一致");
            }
        }
        registrationAccount.add(newMessage);
    }
    public void signOut(){
        System.out.println("退出成功");
    }
    public void showPlatform(){
        showLogPlatform(logInAccount);
    }
    public void showLogPlatform(List<List<String>> logInAccount){
        int chooseNum=0,backNum=1;
        while(!(backNum==0)) {
            System.out.println("请选择登录方式：");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum) {
                case 1:logIn(logInAccount);
                    showServicePlatform();
                    break;
                case 2:registration(logInAccount);
                    break;
                case 0:backNum=0;break;
                default:System.out.println("输入错误");
            }
        }
    }
    public abstract void showServicePlatform();
    public abstract void showManageKeyPlatform();
}
