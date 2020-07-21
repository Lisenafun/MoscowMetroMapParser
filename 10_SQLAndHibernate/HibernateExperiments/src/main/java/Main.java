import data.entity.Course;
import data.entity.LinkedPurchaseList;
import data.entity.PurchaseList;
import data.entity.Student;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HibernateConnection hConnection = HibernateConnection.getInstance();
        Session session = hConnection.getSession();

        String hqlPurchase = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseList = session.createQuery(hqlPurchase).getResultList();

        session.beginTransaction();
        for(PurchaseList purchase : purchaseList) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Course> courseQuery = builder.createQuery(Course.class);
            Root<Course> courseRoot = courseQuery.from(Course.class);
            courseQuery.select(courseRoot).where(builder.equal(courseRoot.get("name"), purchase.getCourseName()));
            Course course = session.createQuery(courseQuery).getSingleResult();

            CriteriaQuery<Student> studentQuery = builder.createQuery(Student.class);
            Root<Student> studentRoot = studentQuery.from(Student.class);
            studentQuery.select(studentRoot).where(builder.equal(studentRoot.get("name"), purchase.getStudentName()));
            Student student = session.createQuery(studentQuery).getSingleResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(new LinkedPurchaseList.Key(course.getId(), student.getId()));
            linkedPurchaseList.setCourseId(course.getId());
            linkedPurchaseList.setStudentId(student.getId());
            session.save(linkedPurchaseList);
        }
        session.getTransaction().commit();
        session.close();
        hConnection.closeSessionFactory();
    }
}
