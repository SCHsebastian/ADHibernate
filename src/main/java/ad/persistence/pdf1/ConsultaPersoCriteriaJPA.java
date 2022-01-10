package ad.persistence.pdf1;

import ad.persistence.domain.Tramit;
import ad.persistence.domain.Tramit_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConsultaPersoCriteriaJPA {

        public static void main(String[] args) {
            // Base
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Tramit> criteria = builder.createQuery(Tramit.class);

            Root<Tramit> root = criteria.from(Tramit.class);

            // Construyendo la consulta
            criteria.select(root)
                    .where(builder.equal(root.get(Tramit_.tipoTramite), "Credito"));

            // Ejecutando la consulta

            List<Tramit> result = session.createQuery(criteria).getResultList();
            result.forEach(System.out::println);

            session.getTransaction().commit();
            session.close();
        }
}
