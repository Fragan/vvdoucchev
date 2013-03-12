declare function local:produitParCouleur($couleur) {
	for $produit in doc("produit.xml")
	/listeProduit/produit
	
	where $produit/Couleur = $couleur
	
	return $produit
};

<result> {
for $fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur,
	$maFourniture in doc("maFourniture.xml")/listeFourniture/fourniture,
	$produit in local:produitParCouleur('vert')
where
	$maFourniture/F = $fournisseur/F and
	$maFourniture/P = $produit/P and
	$fournisseur/Nom = "Barnibus"
return
	$produit/Nom_p
} </result>