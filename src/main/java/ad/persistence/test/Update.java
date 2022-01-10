package ad.persistence.test;

import ad.persistence.domain.Tramit;
import ad.persistence.domain.Tramit_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Update {
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

            criteria.select(root)
                    .where(builder.equal(root.get(Tramit_.tipoTramite), "Aval"));

            Tramit tramit = session.createQuery(criteria).getSingleResult();
            tramit.setTipoTramite("Proyecto Software");

            session.update(tramit);

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
