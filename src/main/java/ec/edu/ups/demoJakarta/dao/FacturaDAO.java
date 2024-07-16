package ec.edu.ups.demoJakarta.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoJakarta.model.Cliente;
import ec.edu.ups.demoJakarta.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO implements Serializable{
	@PersistenceContext
    private EntityManager em;

    public void insert(Factura factura) {
        em.persist(factura);
    }

    public void update(Factura factura) {
        em.merge(factura);
    }

    public void remove(int fac_id) {
    	Factura factura = em.find(Factura.class, fac_id);
        em.remove(factura);
    }

    public Factura read(int fac_id) {
        return em.find(Factura.class, fac_id);
    }
    
    public List<Factura> getAll() {
    	String jpql = "SELECT f FROM Factura f"; // solo importa el nombre de la entidades/ de la clase. Si importa mayusculas y minusculas
		Query query = em.createQuery(jpql, Factura.class);  
		return query.getResultList();  //devuelve la lista de clientes
        
    }
	
}
