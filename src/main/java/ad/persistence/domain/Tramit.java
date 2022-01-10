package ad.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="tramit")
public class Tramit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTramit;

    private String tipoTramite;

    private Timestamp fechaTramite;

    @OneToOne(mappedBy = "tramit")
    private Pressupost pressupost;

    public Tramit(){}

    public Tramit(String tipoTramite, Timestamp fechaTramite) {
        this.tipoTramite = tipoTramite;
        this.fechaTramite = fechaTramite;
    }

    public int getIdTramit(){
        return idTramit;
    }

    public void setIdTramit(int idTramit){
        this.idTramit = idTramit;
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
