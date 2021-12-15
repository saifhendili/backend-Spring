package tn.esprit.spring.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.FounisseurServiceImpl;


@Api(tags = "Fournisseur management")
@RestController 
@RequestMapping("/Fournisseur") 
public class FournisseurRestController {
	@Autowired 
	FounisseurServiceImpl fournisseurServ; 

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients 
	@ApiOperation(value = "Récupérer la liste des Fournisseurs")
	@GetMapping("/retrieve-all-Fournisseurs") 
	@ResponseBody 
	public List<Fournisseur> getFournisseurs() { 
	List<Fournisseur> listFournisseur = fournisseurServ.retrieveAllFournisseur();
	return listFournisseur; 
	} 

	// http://localhost:8089/SpringMVC/client/retrieve-client/8 
	@GetMapping("/retrieve-Fournisseur/{Fournisseur-id}") 
	@ResponseBody 
	public Fournisseur retrieveFournisseur(@PathVariable("Fournisseur-id") Long FournisseurId) { 
		return fournisseurServ.retrieveFournisseur(FournisseurId); 
	} 
	// http://localhost:8089/SpringMVC/client/add-client 
	@PostMapping("/add-fournisseur") 
	@ResponseBody 
	public Fournisseur addFournisseur(@RequestBody Fournisseur c)  
	{ 
		Fournisseur fournisseur = fournisseurServ.addFournisseurt(c);
	return fournisseur; 
	} 


	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}") 
	@ResponseBody 
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) { 
		fournisseurServ.deleteFournisseur(fournisseurId); 
	} 
	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-Fournisseur") 
	@ResponseBody 
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) { 
	return fournisseurServ.updateFournisseur(fournisseur); 
	} 

	@GetMapping("/retrieve-Fournisseur-produit/{Fournisseur-id}") 
	@ResponseBody 
	public List<Produit> retrieveFournisseurProduit(@PathVariable("Fournisseur-id") Long FournisseurId) { 
		return fournisseurServ.allProductFournisseur(FournisseurId); 
	} 
	
	
	@GetMapping("/nb-produit/{Fournisseur-id}") 
	@ResponseBody 
	public int chiffredaffairefournisseur(@PathVariable("Fournisseur-id") Long FournisseurId) { 
		return fournisseurServ.nbproduit(FournisseurId);
	} 
	
	@GetMapping("/GetIdByCategorie/{Categorie}") 
	@ResponseBody 
	public List<Fournisseur> getFournisseurById(@PathVariable("Categorie") CategorieProduit categorieProduit) { 
		return fournisseurServ.GetFournisseurByCategorie(categorieProduit);
	} 
	
	

	@GetMapping("/getChiffreDaffaure/{Fournisseur-id}") 
	@ResponseBody 
	public float ChiffreAffaireByFournisseur(@PathVariable("Fournisseur-id") Long FournisseurId) { 
		return fournisseurServ.ChiffreAffaireByFournisseur(FournisseurId);
	} 
	
	@GetMapping("/getChiffreDaffaureChaqueFournisseur") 
	@ResponseBody 
	public List<Map<String,Object>> ChiffreAffaireAllFournisseur() { 
		return fournisseurServ.chiffreDaffaireChaqueFournisseur();
	} 
	
	@PostMapping("/assignstockproduit/{produit-id}/{stock-id}")
	@ResponseBody
	@ApiOperation("assigns a stock to a produit")
	public void assignStockToProduit(@PathVariable("produit-id") Long produitId,@PathVariable("stock-id") Long stockId) {
		fournisseurServ.assignFournisseurToProduit(produitId, stockId);
	}
	
	@GetMapping("/ChiAffaireDateFournisseur/{fournisseur-id}") 
	@ResponseBody 
	public List<Map<String, Object>> ChiffreAffaireParDateFournisseur(@PathVariable("fournisseur-id") Long idFournisseur){
		return fournisseurServ.ChiffreAffaireParDateFournisseur(idFournisseur);
	}
	}
