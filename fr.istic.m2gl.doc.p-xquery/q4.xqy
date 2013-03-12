declare function local:produitParCouleur($couleur) {
	for $produit in doc("produit.xml")
	/listeProduit/produit
	
	where $produit/Couleur = $couleur
	
	return $produit
};

<result> {
for $produit in local:produitParCouleur('vert')
where
	$produit/Origine = "Riec"
return
	count($produit)
} </result>