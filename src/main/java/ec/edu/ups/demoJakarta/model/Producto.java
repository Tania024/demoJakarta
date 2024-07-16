package ec.edu.ups.demoJakarta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="TBL_PRODUCTO")
public class Producto {
	@Id
	@Column(name = "pro_id")
	private int id;

	@Column(name="pro_precio")
	private Double precio;
	
	@Column(name="pro_stock")
	private int stock;

	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
