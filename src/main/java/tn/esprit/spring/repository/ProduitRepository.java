package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> , CrudRepository<Produit, Long>{
	
	
	

	@Query("SELECT c FROM Produit c WHERE c.idProduit= :idd")
	List<Produit> retrieveAllProduitsbyid(@Param("idd") Long idd);

	
}
