package ad.persistence.test;

import ad.persistence.domain.Tramit;
import ad.persistence.domain.Tramit_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsultasImbricadasWTF {
    public static void main(String[] args) {
        Session session = null;
        Transaction txn = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            txn = session.beginTransaction();
            // update
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Tramit> criteria = builder.createQuery(Tramit.class);

            Root<Tramit> root = criteria.from(Tramit.class);

            SimpleDateFormat sdf = new SimpleDateFormat();
            Date date = sdf.parse("01/01/2017");
            Timestamp timestamp = new Timestamp(date.getTime());


            criteria.select(root)
                    .where(builder
                            .like(root.get(Tramit_.tipoTramite), "%Proyecto%"))
                    .where(builder
                            .lessThan(root.get(Tramit_.fechaTramite), timestamp));

            List<Tramit> result = session.createQuery(criteria).getResultList();
            result.forEach(tramit -> System.out.println(tramit.getTipoTramite()));

            txn.commit();
        } catch (Exception e) {
            if (session != null) {
                txn.rollback();
            }
        } finally {
            session.close();
        }
    }
}
