import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HibernateConnection hConnection = HibernateConnection.getInstance();
        Session session = hConnection.getSession();

        String sql = "SELECT * FROM Courses";
        Query query = session.createSQLQuery(sql).addEntity(Course.class);
        List<Course> courseList = query.list();

        for(Course course : courseList) {
            System.out.println("Название курса: " + course.getName() + ", количество студентов: " + course.getStudentsCount() + ".\n");
        }

        hConnection.closeSessionFactory();
    }
}
