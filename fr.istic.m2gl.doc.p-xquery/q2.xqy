<result> {
	let $produit := doc("produit.xml")/listeProduit/produit
	
	return count($produit[Couleur = 'vert'])
}
</result>