package ad.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="tramit")
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTramite;


    private String tipoTramite;

    private Timestamp fechaTramite;

    public Tramite(){}

    public int getIdTramite(){
        return idTramite;
    }

    public void setIdTramite(int idTramite){
        this.idTramite = idTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Timestamp getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Timestamp fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

}
