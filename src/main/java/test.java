
import com.ZhangZihao.model.Conn;

public class test {
    public static void main(String[] args){

//        UserDao a=new UserDao();
//        User x = new User("ZZH","zzh963852741","zzh@1124","boy","2001-5-24");
        Conn C = new Conn();
        Conn b = (Conn) C;

        System.out.println(b.getStatement());
        //UserTableInsert tt = new UserTableInsert(C);
        //tt.doInsert(x);
//        UserTableSelect ss = new UserTableSelect();
//        User y = new User("zzh","123456789");
//        ss.fillTable(y);
//        System.out.println(y);
    }








}
