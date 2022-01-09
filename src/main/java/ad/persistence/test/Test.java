package ad.persistence.test;

import ad.persistence.domain.Tramite;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Date date = new Date();
        Tramite tramite = new Tramite();
        tramite.setFechaTramite(new Timestamp(date.getTime()));
        tramite.setTipoTramite("Credito");

        session.save(tramite);

        session.getTransaction().commit();
        session.close();
    }
}
