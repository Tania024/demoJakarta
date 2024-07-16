package ec.edu.ups.demoJakarta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_DETALLEFACTURA")
public class DetalleFactura {
	@Id
	@Column(name = "det_id")
	private int id;
	
	@Column(name = "det_cantidad")
	private int cantidad;
	
	@Column(name = "det_precio")
	private Double precio;
	
	@ManyToOne
	private Producto producto;
	
	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
