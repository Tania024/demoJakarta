package ec.edu.ups.demoJakarta.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoJakarta.model.Cliente;
import ec.edu.ups.demoJakarta.model.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class DetalleFacturaDAO implements Serializable{
	@PersistenceContext
    private EntityManager em;

    public void insert(DetalleFactura detallefactura) {
        em.persist(detallefactura);
    }

    public void update(DetalleFactura detallefactura) {
        em.merge(detallefactura);
    }

    public void remove(int det_id) {
        DetalleFactura detallefactura = em.find(DetalleFactura.class, det_id);
        em.remove(detallefactura);
    }

    public DetalleFactura read(int det_id) {
        return em.find(DetalleFactura.class, det_id);
    }
    
    
    public List<DetalleFactura> getAll() {
    	String jpql = "SELECT d FROM DetalleFactura d"; // solo importa el nombre de la entidades/ de la clase. Si importa mayusculas y minusculas
		Query query = em.createQuery(jpql, DetalleFactura.class);  
		return query.getResultList();  //devuelve la lista de clientes
    }

    

}
