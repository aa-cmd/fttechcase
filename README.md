Merhaba,

Proje aciklamalari burada yer almaktadir. 
Urun Id ve User Id leri ilk basta generated yaptim ancak daha sonra urun ve kullanici aramalarinda bu bilgilerin bilinmesi gerektigini dusundugum icin
kullanicinin bu bilgileri kayit yaparken girmesini ve bu id leri bilmesi gerektigini dusundum. 

Yoksa Id leri rahatlikla GeneratedType.ENTITY ya da GeneratedType.SEQUENCE yapabilirdim.

Asagida Enpoint aciklamalari yer almaktadir. Tablolara giris yaparken ProductRepositoryTes.java altinda yer alan "saveCommentWithUserAndProduct" metodu kullanilabilir.

	
1. Urune bagli yorumm gosteren endpoint asagidaki gibidir:

	getComments endpoint is:
		localhost:8080/getComments/{productName}

2. Belirli tarih araliginda belirli bir urune ait yorumlari gosteren endpoint asagidaki gibidir:

	getCommentsBtwDatesByProductId endpoint example is:
		localhost:8080/getCommentsBtwDatesByProductId/{productId}/{startDate}/{endDate}
		localhost:8080/getCommentsBtwDatesByProductId/55/2000-09-10T14:10:10/2004-09-10T10:10:10

3. Belirli bir kullaniciya ait yorumlari gosteren endpoint asagidaki gibidir:

	getCommentsByUserId endpoint is:
		localhost:8080/getCommentsByUserId/1

4. Bir kullanicinin belirli tarihler arasinda yapmis oldugu yorumlari gosteren endpoint asagidaki gibidir:
	
	getCommentsBtwDatesByUserId endpoint example is:
		localhost:8080/getCommentsBtwDatesByUserId/{productId}/{startDate}/{endDate}
		localhost:8080/getCommentsBtwDatesByUserId/55/2000-09-10T14:10:10/2004-09-10T10:10:10

5. Son kullanma tarihi gecmis urunleri gosteren endpoint asagidaki gibidir:
	localhost:8080/getExpiredProducts
	
6. Son kullanma tarihi gecmemis urunleri gosteren endpoint asagidaki gibidir:
	localhost:8080/getNonExpiredProducts
	
Tesekkurler.
	
	
