package ad.persistence.pdf2;

import ad.persistence.domain.Pressupost;
import ad.persistence.domain.Tramit;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.sql.Timestamp;

public class OneToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            tx = session.beginTransaction();
            Date date = new Date(System.currentTimeMillis());

            Tramit tramit = new Tramit("Crédito", new Timestamp(date.getTime()));
            session.save(tramit);

            Pressupost pressupost = new Pressupost("Altabix - Elche");
            pressupost.setTramitIdtramit(tramit);
            session.save(pressupost);

            tx.commit();
        }catch (Exception e) {
            if (session != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
