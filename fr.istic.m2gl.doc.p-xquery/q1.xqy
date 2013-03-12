<result> {
	for $produit in doc("produit.xml")
	/listeProduit/produit
	
	where $produit/Couleur = "vert"
	
	return $produit/Nom_p
}
</result>