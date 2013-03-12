declare function local:fournisseurParProduit($codep as xs:string) {
	for $fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur,
		$maFourniture in doc("maFourniture.xml")/listeFourniture/fourniture
	
	where 
		$maFourniture/F = $fournisseur/F and
		$maFourniture/P = $codep
	
	return $fournisseur
};

<result> {
local:fournisseurParProduit('p4')/Nom
} </result>