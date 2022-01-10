package ad.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "pressupost")
public class Pressupost {
    @Id
    @Column(name = "idPressupost", nullable = false)
    private Integer id;

    @Column(name = "lugarPresupuesto", length = 100)
    private String lugarPresupuesto;

    @OneToOne
    @JoinColumn(name = "Tramit_idTramit", nullable = false)
    private Tramit tramitIdtramit;

    public Pressupost() {
    }

    public Pressupost(String s) {
        this.lugarPresupuesto = s;
    }

    public Tramit getTramitIdtramit() {
        return tramitIdtramit;
    }

    public void setTramitIdtramit(Tramit tramitIdtramit) {
        this.tramitIdtramit = tramitIdtramit;
    }

    public String getLugarPresupuesto() {
        return lugarPresupuesto;
    }

    public void setLugarPresupuesto(String lugarPresupuesto) {
        this.lugarPresupuesto = lugarPresupuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}