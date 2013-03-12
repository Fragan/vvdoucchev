declare function local:produitParCouleur($couleur) {
	for $produit in doc("produit.xml")
	/listeProduit/produit
	
	where $produit/Couleur = $couleur
	
	return $produit
};

<result> {
for $f in distinct-values(

	for $fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur,
		$maFourniture in doc("maFourniture.xml")/listeFourniture/fourniture,
		$produit in local:produitParCouleur('vert')
	where
		$maFourniture/F = $fournisseur/F and
		$maFourniture/P = $produit/P
	return
		$fournisseur/F
) return <F>{$f}</F>
} </result>