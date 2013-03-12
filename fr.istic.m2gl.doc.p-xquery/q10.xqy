declare function local:fournisseurParProduit($codep as xs:string) {
	for $fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur,
		$maFourniture in doc("maFourniture.xml")/listeFourniture/fourniture
	
	where 
		$maFourniture/F = $fournisseur/F and
		$maFourniture/P = $codep
	
	return $fournisseur
};

<result> {
for $origine in distinct-values( doc("produit.xml")/listeProduit/produit/Origine)
return
	<origine ville="{$origine}">
	{
	for	$produit in doc("produit.xml")/listeProduit/produit
	where
		$origine = $produit/Origine
	return
		<produit>
		<nom>{$produit/Nom_p/text()}</nom>
		{
		for $fournisseur in local:fournisseurParProduit($produit/P)
		return 
			<fournisseur>{$fournisseur/Nom/text()}</fournisseur>
		}
		</produit>
	}
	</origine>
} </result>