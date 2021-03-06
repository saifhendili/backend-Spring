package tn.esprit.spring.entity;
import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Produit")
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idproduit")
	private Long idProduit; // Clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	
	@JsonIgnore
	


	@OneToMany(cascade = CascadeType.ALL, mappedBy="Totheparentdetailfacture")
	
	private Set<detailFacture> detailFacture;
	
	
	@OneToOne(cascade = CascadeType.ALL) 
	private DetailProduit Detailproduit;  //w yeblokiha min 8adi bi jsonignore
	

	
	
	
	@ManyToOne

	private Stock stockproduit; 
	
	@ManyToOne
	
    private Rayon rayonproduit; 
	
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Fournisseur> fournisseur;

	
	 
}