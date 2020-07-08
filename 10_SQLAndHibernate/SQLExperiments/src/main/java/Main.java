import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            SQLConnection sqlConnection = new SQLConnection();
            Statement statement = sqlConnection.getConnection();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM Courses");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
