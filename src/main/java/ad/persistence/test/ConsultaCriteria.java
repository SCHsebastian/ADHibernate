package ad.persistence.test;

import ad.persistence.domain.Tramit;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConsultaCriteria {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tramit> criteria = builder.createQuery(Tramit.class);

        Root<Tramit> root = criteria.from(Tramit.class);

        criteria.select(root);

        List<Tramit> result = session.createQuery(criteria).getResultList();
        result.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
