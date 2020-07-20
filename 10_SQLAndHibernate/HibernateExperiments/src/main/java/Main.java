import data.entity.PurchaseList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HibernateConnection hConnection = HibernateConnection.getInstance();
        Session session = hConnection.getSession();

//        String sql = "SELECT * FROM Courses";
//        Query query = session.createSQLQuery(sql).addEntity(data.entity.Course.class);
//        List<data.entity.Course> courseList = query.list();
//        for(data.entity.Course course : courseList) {
//            System.out.println("Название курса: " + course.getName() + ", количество студентов: " + course.getStudentsCount() + ".\n");
//            List<data.entity.Student> students = course.getStudents();
//            students.forEach(student -> System.out.println(student.getName()));
//        }

//        String sql = "SELECT * FROM Students";
//        Query query = session.createSQLQuery(sql).addEntity(data.entity.Student.class);
//        List<data.entity.Student> studentList = query.list();
//
//        for(data.entity.Student student: studentList){
//            List<data.entity.Course> courses = student.getCourses();
//            System.out.println("Имя студента: " + student.getName() + "\t\nСписок курсов:");
//            courses.forEach(course -> System.out.println(course.getName()));
//        }

//        String sql = "SELECT * FROM Subscriptions";
//        Query query = session.createSQLQuery(sql).addEntity(data.entity.Subscription.class);
//        List<data.entity.Subscription> subscriptions = query.list();
//        for(data.entity.Subscription subscription: subscriptions){
//            System.out.println(subscription.getCourse().getName() + " - " + subscription.getStudent().getName());
//        }

        String sql = "SELECT * FROM Purchaselist";
        Query query = session.createSQLQuery(sql).addEntity(PurchaseList.class);
        List<PurchaseList> purchaseLists = query.list();
        for(PurchaseList purchaseList: purchaseLists){
            System.out.println(purchaseList.getCourseName() + " - " + purchaseList.getStudentName() + " - " + purchaseList.getSubscriptionDate());
        }

        session.close();
        hConnection.closeSessionFactory();
    }
}
