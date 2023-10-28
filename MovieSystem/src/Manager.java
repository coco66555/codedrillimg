import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Service{
    List<String> firstManagerList = new LinkedList<String>();
    List<String> firstMovie = new LinkedList<String>();
    List<String> firstMovieSchedule = new LinkedList<String>();
    List<String> firstMovieSchedule1 = new LinkedList<String>();
    Scanner reader = new Scanner(System.in);
    Manager(){
        super();
    }

    @Override
    public int searchSelfNum() {
        return searchNum;
    }

    @Override
    public void logIn(List<List<String>> ManagerMessage) {
        super.logIn(Attribute.ManagerMessage);
    }

    @Override
    public void rewriteKey(List<List<String>> ManagerMessage) {
        super.rewriteKey(Attribute.ManagerMessage);
    }

    @Override
    public void registration(List<List<String>> ManagerMessage) {
        super.registration(Attribute.ManagerMessage);
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
    public void showLogPlatform(List<List<String>> ManagerMessage) {
        super.showLogPlatform(Attribute.ManagerMessage);
    }

    @Override
    public void showServicePlatform() {
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.密码管理");
            System.out.println("2.影片管理");
            System.out.println("3.排片管理");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:showManageKeyPlatform();break;
                case 2:showManageMoviePlatform();break;
                case 3:showLayoutMoviePlatform();break;
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
                case 1:rewriteKey(Attribute.ManagerMessage);break;
                case 0:backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }

    public void showManageMoviePlatform(){
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.列出影片信息");
            System.out.println("2.添加即将上映的影片信息");
            System.out.println("3.修改影片信息");
            System.out.println("4.删除影片信息");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:checkMovieMessage();break;
                case 2:addMovieMessage();break;
                case 3:reviseMovieMessage();break;
                case 4:deleteMovieMessage();break;
                case 0:backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }

    public void firstMovie(String MovieName,String MovieDirector,String MovieActors,String MovieType,String MoviePlot,String MovieTime){
        firstMovie.add(MovieName);
        firstMovie.add(MovieDirector);
        firstMovie.add(MovieActors);
        firstMovie.add(MovieType);
        firstMovie.add(MoviePlot);
        firstMovie.add(MovieTime);
        Attribute.MovieMessage.add(firstMovie);
    }

    public void firstMovieSchedule(String MovieName,String MovieScenes,String MovieStartTime,String Ticket){
        firstMovieSchedule.add(MovieName);
        firstMovieSchedule.add(MovieScenes);
        firstMovieSchedule.add(MovieStartTime);
        firstMovieSchedule.add(Ticket);
        firstMovieSchedule1.add(MovieName);
        firstMovieSchedule1.add(MovieScenes);
        firstMovieSchedule1.add(MovieStartTime);
        firstMovieSchedule1.add(Ticket);
        Attribute.CinemaNO_1.add(firstMovieSchedule);
        Attribute.CinemaNO_2.add(firstMovieSchedule1);
    }
    public void checkMovieMessage(){
        for(int i=0;i<Attribute.MovieMessage.size();i++){
            System.out.println("片名："+Attribute.MovieMessage.get(i).get(0));
            System.out.println("导演："+Attribute.MovieMessage.get(i).get(1));
            System.out.println("主演："+Attribute.MovieMessage.get(i).get(2));
            System.out.println("类型："+Attribute.MovieMessage.get(i).get(3));
            System.out.println("剧情介绍："+Attribute.MovieMessage.get(i).get(4));
            System.out.println("时长："+Attribute.MovieMessage.get(i).get(5));
            System.out.println("----------------------------------------------");
        }
    }

    public void addMovieMessage(){
        int backNum=1;
        String NewMovieName,NewMovieDirector,NewMovieActors,NewMovieType,NewMoviePlot,NewMovieTime;
        List<String> newMovie = new LinkedList<String>();
        while(!(backNum==0)){
            System.out.println("请输入您要添加的影片名称：");
            NewMovieName=reader.next();
            for(int i=0;i<Attribute.MovieMessage.size();i++){
                if(NewMovieName.equals(Attribute.MovieMessage.get(i).get(0))){
                    System.out.println("已有该影片");
                    break;
                }
                if(i==Attribute.MovieMessage.size()-1){
                    newMovie.add(NewMovieName);
                    System.out.println("请输入您要添加影片的导演：");
                    NewMovieDirector=reader.next();
                    newMovie.add(NewMovieDirector);
                    System.out.println("请输入您要添加影片的主演：");
                    NewMovieActors=reader.next();
                    newMovie.add(NewMovieActors);
                    System.out.println("请输入您要添加影片的类型：");
                    NewMovieType=reader.next();
                    newMovie.add(NewMovieType);
                    System.out.println("请输入您要添加影片的剧情简介：");
                    NewMoviePlot=reader.next();
                    newMovie.add(NewMoviePlot);
                    System.out.println("请输入您要添加影片的时长：");
                    NewMovieTime=reader.next();
                    newMovie.add(NewMovieTime);
                    backNum=0;
                    List<String> addCinema = new LinkedList<>();
                    List<String> addCinema1 = new LinkedList<>();
                    addCinema.add(NewMovieName);
                    addCinema1.add(NewMovieName);
                    Attribute.CinemaNO_1.add(addCinema);
                    Attribute.CinemaNO_2.add(addCinema1);
                    }
                }
        }
        Attribute.MovieMessage.add(newMovie);
    }

    public void reviseMovieMessage(){
        int chooseNum=0,backNum=1;
        String revisedMovie,revisedMessage;
        while(!(backNum==0)){
            System.out.println("请输入您要修改的电影：");
            revisedMovie=reader.next();
            for(int i=0;i<Attribute.MovieMessage.size();i++){
                if(revisedMovie.equals(Attribute.MovieMessage.get(i).get(0))){
                    System.out.println("请选择要修改的信息：");
                    System.out.println("1.片名");
                    System.out.println("2.导演");
                    System.out.println("3.主演");
                    System.out.println("4.类型");
                    System.out.println("5.剧情简介");
                    System.out.println("6.时长");
                    System.out.println("0.退出");
                    chooseNum=reader.nextInt();
                    System.out.println("请输入修改后的内容：");
                    switch (chooseNum){
                        case 1:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(0,revisedMessage);break;
                        case 2:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(1,revisedMessage);break;
                        case 3:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(2,revisedMessage);break;
                        case 4:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(3,revisedMessage);break;
                        case 5:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(4,revisedMessage);break;
                        case 6:revisedMessage=reader.next();Attribute.MovieMessage.get(i).set(5,revisedMessage);break;
                        case 0:backNum=0;
                            break;
                        default:System.out.println("输入错误");
                    }
                    System.out.println("修改成功");
                    backNum=0;
                    break;
                }if(i==Attribute.MovieMessage.size()-1){
                    System.out.println("未找到该影片");
                }
            }
        }
    }

    public void deleteMovieMessage(){
        String deletedMovie;
        int backNum=1;
        int chooseNum=0;
        while (!(backNum==0)){
            System.out.println("请输入要删除的影片名称：");
            deletedMovie=reader.next();
            for(int i=0;i<Attribute.MovieMessage.size();i++){
                if(deletedMovie.equals(Attribute.MovieMessage.get(i).get(0))){
                    System.out.println("确认要删除吗？");
                    System.out.println("确认请输入1，返回请输入0");
                    chooseNum=reader.nextInt();
                    if(chooseNum==1){
                        Attribute.MovieMessage.remove(i);
                        System.out.println("删除成功");
                        backNum=0;
                    }else{
                        backNum=0;
                    }
                    break;
                }
                if(i==Attribute.MovieMessage.size()-1){
                    System.out.println("未找到该影片");
                }
            }
        }
    }

    public void showLayoutMoviePlatform(){
        int chooseNum=0,backNum=1;
        while(!(backNum==0)){
            System.out.println("请选择您要使用的功能：");
            System.out.println("1.列出场次信息");
            System.out.println("2.增加场次信息");
            System.out.println("3.修改场次信息");
            System.out.println("4.删除场次信息");
            System.out.println("0.退出");
            chooseNum=reader.nextInt();
            switch (chooseNum){
                case 1:checkMovieScheduleMessage();break;
                case 2:addMovieScheduleMessage();break;
                case 3:reviseMovieScheduleMessage();break;
                case 4:deleteMovieScheduleMessage();break;
                case 0:backNum=0;
                    break;
                default:System.out.println("输入错误");
            }
        }
    }
    public void checkMovieScheduleMessage(){
        String searchMovie;
        int backNum=1;
        while (!(backNum==0)){
            System.out.println("请选择您要查看的电影名称：");
            searchMovie=reader.next();
            for(int i=0;i<Attribute.MovieMessage.size();i++){
                if(searchMovie.equals(Attribute.MovieMessage.get(i).get(0))){
                    if(Attribute.CinemaNO_1.get(i).size()==1&&Attribute.CinemaNO_2.get(i).size()==1){
                        System.out.println("请先排片");
                        backNum=0;
                        break;
                    }
                    if(searchMovie.equals(Attribute.CinemaNO_1.get(i).get(0))){
                        if(Attribute.CinemaNO_1.get(i).size()==1){
                            System.out.println("场馆1未拍片");
                            backNum=0;
                            break;
                        }
                        System.out.println("放映厅1：");
                        for(int j=1;j<=Attribute.CinemaNO_1.get(i).size()/3;j++){
                            System.out.println("场次："+Attribute.CinemaNO_1.get(i).get(3*j-2));
                            System.out.println("时间："+Attribute.CinemaNO_1.get(i).get(3*j-1));
                            System.out.println("票价："+Attribute.CinemaNO_1.get(i).get(3*j));
                        }
                    }
                    if(searchMovie.equals(Attribute.CinemaNO_2.get(i).get(0))){
                        if(Attribute.CinemaNO_2.get(i).size()==1){
                            System.out.println("场馆2未排片");
                            backNum=0;
                            break;
                        }
                        System.out.println("放映厅2：");
                        for(int k=1;k<=(Attribute.CinemaNO_2.get(i).size()-1)/3;k++){
                            System.out.println("场次："+Attribute.CinemaNO_2.get(i).get(3*k-2));
                            System.out.println("时间："+Attribute.CinemaNO_2.get(i).get(3*k-1));
                            System.out.println("票价："+Attribute.CinemaNO_2.get(i).get(3*k));
                        }
                    }
                    backNum=0;
                    break;
                }
                if(i==Attribute.MovieMessage.size()-1){
                    System.out.println("暂无此电影");
                }
            }
        }
    }

    public void addMovieScheduleMessage(){
        String searchName;
        System.out.println("请输入您要排片的电影名称：");
        searchName=reader.next();
        for(int i=0;i<Attribute.MovieMessage.size();i++){
            if(searchName.equals(Attribute.MovieMessage.get(i).get(0))){
                int chooseNum=0,backNum=1;
                while(!(backNum==0)){
                    System.out.println("请输入添加场馆：");
                    System.out.println("1.场馆一");
                    System.out.println("2.场馆二");
                    System.out.println("0.退出");
                    chooseNum=reader.nextInt();
                    switch (chooseNum){
                        case 1:
                            addMovieCountMessage(Attribute.CinemaNO_1,i);
                            break;
                        case 2:
                            addMovieCountMessage(Attribute.CinemaNO_2,i);
                            break;
                        case 0:backNum=0;break;
                        default:System.out.println("输入错误");
                    }
                }
                System.out.println("排片成功");
                break;
            }
            if(i==Attribute.MovieMessage.size()-1)
                System.out.println("未找到该电影");
        }
    }

    public void addMovieCountMessage(List<List<String>> addMovieCountMessage,int i){
        String cinemaCount;
        String cinemaTime;
        String cinemaTicket;
        System.out.println("请输入要添加的场次：");
        cinemaCount=reader.next();
        System.out.println("请输入要添加的时间：");
        cinemaTime=reader.next();
        System.out.println("请输入要添加的票价：");
        cinemaTicket=reader.next();
        addMovieCountMessage.get(i).add(cinemaCount);
        addMovieCountMessage.get(i).add(cinemaTime);
        addMovieCountMessage.get(i).add(cinemaTicket);
    }

    public void reviseMovieScheduleMessage(){
        int chooseNum=0,backNum=1;
        String deleteMovie;
        System.out.println("请输入电影名称：");
        deleteMovie=reader.next();
        for(int i=0;i<Attribute.MovieMessage.size();i++){
            int stopNum=1;
            if(deleteMovie.equals(Attribute.MovieMessage.get(i).get(0))){
                if(Attribute.CinemaNO_1.get(i).size()==1&&Attribute.CinemaNO_2.get(i).size()==1){
                    System.out.println("请先排片");
                    break;
                }
                while(!(backNum==0)){
                    stopNum=0;
                    System.out.println("请输入修改场次的场馆：");
                    System.out.println("1.场馆一");
                    System.out.println("2.场馆二");
                    System.out.println("0.退出");
                    chooseNum=reader.nextInt();
                    switch (chooseNum){
                        case 1:reviseMovieCountMessage(Attribute.CinemaNO_1,i,chooseNum);break;
                        case 2:reviseMovieCountMessage(Attribute.CinemaNO_2,i,chooseNum);break;
                        case 0:backNum=0;stopNum=0;break;
                        default :System.out.println("输入错误");
                    }
                    }
                }
            if(stopNum==0){
                System.out.println("退出中");
                break;
            }
            if(i==Attribute.MovieMessage.size()-1)
                System.out.println("未找到该电影");
            }
    }

    public void reviseMovieCountMessage(List<List<String>> reviseMovieCountMessage,int i,int chooseNum){
        System.out.println("请输入要修改的场次：");
        String deleteCount;
        deleteCount=reader.next();
        for(int j=1;j<reviseMovieCountMessage.get(i).size();j=j+3){
            int backNum1=1;
            if(deleteCount.equals(reviseMovieCountMessage.get(i).get(j))){
                while(!(backNum1==0)){
                    if(reviseMovieCountMessage.get(i).size()==1){
                        System.out.println("场馆未排片");
                        break;
                    }
                    System.out.println("请输入要修改的信息：");
                    System.out.println("1.场次");
                    System.out.println("2.时间");
                    System.out.println("3.票价");
                    System.out.println("0.退出");
                    chooseNum=reader.nextInt();
                    switch (chooseNum){
                        case 1:String reviseCount;
                            System.out.println("请输入修改后场次：");
                            reviseCount=reader.next();
                            reviseMovieCountMessage.get(i).set(j,reviseCount);break;
                        case 2:String reviseTime;
                            System.out.println("请输入修改后时间：");
                            reviseTime=reader.next();
                            reviseMovieCountMessage.get(i).set(j+1,reviseTime);break;
                        case 3:String reviseTicket;
                            System.out.println("请输入修改后票价：");
                            reviseTicket=reader.next();
                            reviseMovieCountMessage.get(i).set(j+2,reviseTicket);break;
                        case 0:backNum1=0;break;
                        default:System.out.println("输入错误");
                    }
                }
            }
            if(backNum1==0){
                break;
            }
            if(j==Attribute.CinemaNO_1.get(i).size()-1)
                System.out.println("暂无该场次");
        }
    }

    public void deleteMovieScheduleMessage(){
        int chooseNum=0,backNum=1;
        String deleteMovie;
        System.out.println("请输入电影名称：");
        deleteMovie=reader.next();
        for(int i=0;i<Attribute.MovieMessage.size();i++){
            int stopNum=1;
            if(deleteMovie.equals(Attribute.MovieMessage.get(i).get(0))){
                if(Attribute.CinemaNO_1.get(i).size()==1&&Attribute.CinemaNO_2.get(i).size()==1){
                    System.out.println("请先排片");
                    break;
                }
                while(!(backNum==0)){
                    stopNum=0;
                    System.out.println("请输入删除场次的场馆：");
                    System.out.println("1.场馆一");
                    System.out.println("2.场馆二");
                    System.out.println("0.退出");
                    chooseNum=reader.nextInt();
                    switch (chooseNum){
                        case 1:
                            deleteMovieCountMessage(Attribute.CinemaNO_1,i,backNum);
                                break;
                        case 2:
                            deleteMovieCountMessage(Attribute.CinemaNO_2,i,backNum);
                            break;
                        case 0:backNum=0;
                    }
                }
            }
            if(stopNum==0){
                break;
            }
            if(i==Attribute.MovieMessage.size()-1)
                System.out.println("未找到该电影");
        }
    }

    public void deleteMovieCountMessage(List<List<String>> deleteMovieCountMessage,int i,int backNum){
        if(deleteMovieCountMessage.get(i).size()==1){
            System.out.println("场馆未排片");
            backNum=0;
            return;
        }
        System.out.println("请输入要删除的场次：");
        String deleteCount = reader.next();
        for(int j=1;j<deleteMovieCountMessage.get(i).size();j=j+3){
            if(deleteCount.equals(deleteMovieCountMessage.get(i).get(j))){
                deleteMovieCountMessage.get(i).remove(j);
                deleteMovieCountMessage.get(i).remove(j);
                deleteMovieCountMessage.get(i).remove(j);
                System.out.println("删除成功");
                break;
            }
            if(j==deleteMovieCountMessage.get(i).size()-1)
                System.out.println("暂无该电影");
        }
    }
    public void firstManager(String accountName,String accountKey){
        firstManagerList.add(accountName);
        firstManagerList.add(accountKey);
        firstManagerList.add("0");
        Attribute.ManagerMessage.add(firstManagerList);
    }
}
