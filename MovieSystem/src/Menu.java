import java.util.Scanner;

public class Menu {
    Administrator administrator = new Administrator();
    Manager manager = new Manager();
    Reception reception = new Reception();
    Customer customer = new Customer();
    Scanner reader = new Scanner(System.in);
    public void startMenu(){
        int chooseNum=0,backNum=1;
        String inputAccountName;
        String inputAccountKey;

        administrator.firstAdministrator("10086","10086");
        manager.firstManager("10086","10086");
        reception.firstReception("10086","10086");
        customer.firstCustomer("10086","10086");
        manager.firstMovie("流浪地球2", "郭帆","吴京 刘德华 李雪健 沙溢 宁理 王智 朱颜曼滋 安地 王若熹 佟丽娅 伟大力 张衣 天使 克拉拉 叶展飞 倪腾 胡先煦 ","科幻 / 冒险 / 灾难","太阳即将毁灭，人类在地球表面建造出巨大的推进器，寻找新的家园。然而宇宙之路危机四伏，为了拯救地球，流浪地球时代的年轻人再次挺身而出，展开争分夺秒的生死之战。","173分钟");
        manager.firstMovieSchedule("流浪地球2","场次1","10；00——13：00","45元");
        while(!(backNum==0)) {
            System.out.println("欢迎使用电影管理系统");
            System.out.println("请选择身份");
            System.out.println("1.管理员");
            System.out.println("2.经理");
            System.out.println("3.前台");
            System.out.println("4.客户");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum) {
                case 1:administrator.showPlatform();
                   break;
                case 2:manager.showPlatform();
                   break;
                case 3:reception.showPlatform();
                   break;
                case 4:customer.showPlatform();
                   break;
                case 0:backMenu();backNum=0;break;
                default:System.out.println("输入错误");
            }
        }
    }
    public void backMenu(){
        System.out.println("退出成功");
        System.out.println("感谢使用");
    }
}
