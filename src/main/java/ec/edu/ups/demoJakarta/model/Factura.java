package ec.edu.ups.demoJakarta.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_FACTURA")
public class Factura {
	@Id
	@Column(name="fac_id")
	private int id;
	
	
	@Column(name="fac_fecha")
	private Date fecha;
	
	@ManyToOne
    private Cliente cliente;
	
	//@OneToMany(mappedBy = "factura")
    //private List<DetalleFactura> detalles;

	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
