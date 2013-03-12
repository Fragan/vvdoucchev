<result> {
for $fournisseur in doc("fournisseur.xml")/listeFournisseur/fournisseur,
	$mf1 in doc("maFourniture.xml")/listeFourniture/fourniture
where
	$mf1/F = $fournisseur/F and
	$mf1/P = "p2"
return
	for $mf2 in doc("maFourniture.xml")/listeFourniture/fourniture
	where
		$mf2/F = $fournisseur/F and
		$mf2/P = "p4"
	return
		$fournisseur/F
} </result>