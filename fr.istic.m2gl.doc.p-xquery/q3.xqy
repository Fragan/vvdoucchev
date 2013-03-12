declare function local:produitParCouleur($couleur) {
	for $produit in doc("produit.xml")
	/listeProduit/produit
	
	where $produit/Couleur = $couleur
	
	return $produit
};

<result> {
local:produitParCouleur('vert')/Nom_p
} </result>