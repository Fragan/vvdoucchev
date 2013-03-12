<result> {
for $produit in doc("produit.xml")/listeProduit/produit
return
	<produit nom="{$produit/Nom_p}">
	{
	for $maFourniture in doc("maFourniture.xml")/listeFourniture/fourniture,
		$fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur
	where
		$maFourniture/P = $produit/P and
		$maFourniture/F = $fournisseur/F
	return
		$fournisseur/Nom
	}
	</produit>
} </result>