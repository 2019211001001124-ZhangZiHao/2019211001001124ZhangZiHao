
import com.ZhangZihao.homework.week3.Conn;

public class test {
    public static void main(String[] args){
        Conn x=new Conn();
        System.out.println("StatementState:"+x.getStatement());
        x.close();
    }
}
