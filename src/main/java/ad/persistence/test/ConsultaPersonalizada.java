package ad.persistence.test;

import ad.persistence.domain.Tramit;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ConsultaPersonalizada {
    public static void main(String[] args) {
        System.out.println("Consulta personalizada");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        Query<Tramit> query = session.createQuery("from Tramit where tipoTramite = :tipoTram");
        query.setParameter("tipoTram", "Credito"); //Tipo de tramite

        List<Tramit> tramites = query.getResultList();
        tramites.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
