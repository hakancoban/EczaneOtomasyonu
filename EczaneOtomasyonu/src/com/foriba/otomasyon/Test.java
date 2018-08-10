package com.foriba.otomasyon;

import java.util.ArrayList;
import java.util.Scanner;
import entity.Admin;
import entity.Ilac;
import entity.Kullanici;
import entity.Musteri;
import repository.AdminRepository;
import repository.IlacRepository;
import repository.KullaniciRepository;
import repository.MusteriRepository;

public class Test {
	static ArrayList<Ilac> ilacListesi = new ArrayList<Ilac>();
	static Scanner scanner = new Scanner(System.in);
	static String musteriAd;
	static String musteriSoyad;
	static String adminAd;
	static String adminSoyad;
	static String adminSifre;
	static String kullaniciAd;
	static String kullaniciSoyad;
	static String kullaniciSifre;
	static int ilacFiyat;
	static long Id;
	static int serinogir;
	static int menu;
	static int giris;
	static int kayit;
	static boolean okey;
	static Ilac ilac = new Ilac();
	private static Admin admin = new Admin();
	private static Kullanici kullanici = new Kullanici();
	private static Musteri musteri = new Musteri();

	public static void main(String[] args) {
		System.out.println(
				"Giriþ Oluþturmadan Önce Kayýt Yapmalýsýnýz.Eðer Bir Kaydýnýz Varsa Giriþ Yapabilirsiniz." + "\n");
		while (true) {
			System.out.println("\t" + "Yeni Bir Kayýt Oluþturmak Ýçin 1'i Tuþlayýnýz.");
			System.out.println("\t" + "Admin Olarak Giriþ Yapmak Ýçin 2'yi Tuþlayýnýz.");
			System.out.println("\t" + "Kullanýcý Olarak Giriþ Yapmak Ýçin 3'ü Tuþlayýnýz.");
			System.out.println("\t" + "Müþteri Olarak Giriþ Yapmak Ýçin 4'ü Tuþlayýnýz.");
			System.out.println("\t" + "Sistemden Çýkmak Ýçin 5'i Tuþlayýnýz.");
			try {
giris = scanner.nextInt();
			} catch (Exception e) {
			}
			if (giris == 1) {
				System.out.println("Yeni bir Kimlik Oluþturun:" + "\n");
				System.out.println("Admin Kaydý Yapmak Ýçin 1'i Tuþlayýnýz.");
				System.out.println("Kullanýcý Kaydý Yapmak Ýçin 2'yi Tuþlayýnýz.");
				System.out.println("Müþteri Kaydý Yapmak Ýçin 3'ü Tuþlayýnýz.");
				try {
					kayit = scanner.nextInt();
				} catch (Exception e) {
				}
				if (kayit == 1) {
					System.out.print("Adýnýzý Giriniz: ");
					scanner.nextLine();
					adminAd = scanner.nextLine();
					System.out.print("Soyadýnýzý Giriniz: ");
					adminSoyad = scanner.nextLine();
					System.out.print("Þifrenizi Giriniz: ");
					adminSifre = scanner.nextLine();
					AdminRepository adminRepository = new AdminRepository();
					if (adminRepository.list().size() == 0) {
						admin.setAdminAd(adminAd);
						admin.setAdminSoyad(adminSoyad);
						admin.setAdminSifre(adminSifre);
						adminRepository.persist(admin);
						System.out.println("Kaydýnýz Oluþturulmuþtur.");
					} else {
						System.out.println("Birden Fazla Kayýt Yapamazsýnýz.");
					}
					adminRepository.close();
				} else if (kayit == 2) {
					System.out.print("Adýnýzý Giriniz: ");
					scanner.nextLine();
					kullaniciAd = scanner.nextLine();
					System.out.print("Soyadýnýzý Giriniz: ");
					kullaniciSoyad = scanner.nextLine();
					System.out.print("Þifrenizi Giriniz: ");
					kullaniciSifre = scanner.nextLine();
					KullaniciRepository kullaniciRepository = new KullaniciRepository();
					if (kullaniciRepository.list().size() == 0) {
					kullanici.setKullaniciAd(kullaniciAd);
					kullanici.setKullaniciSoyad(kullaniciSoyad);
					kullanici.setKullaniciSifre(kullaniciSifre);
					kullaniciRepository.persist(kullanici);
					System.out.println("Kaydýnýz Oluþturulmuþtur.");
					}
					kullaniciRepository.close();
				} else if (kayit == 3) {
					System.out.print("Adýnýzý Giriniz: ");
					scanner.nextLine();
					musteriAd = scanner.nextLine();
					System.out.print("Soyadýnýzý Giriniz: ");
					musteriSoyad = scanner.nextLine();
					System.out.print("\n");
					MusteriRepository musteriRepository = new MusteriRepository();
					if (musteriRepository.list().size() == 0) {
					musteri.setMusteriAd(musteriAd);
					musteri.setMusteriSoyad(musteriSoyad);
					musteriRepository.persist(musteri);
					System.out.println("Kaydýnýz Oluþturulmuþtur.");
					}
					musteriRepository.close();
				} 
			} else if (giris == 2) {
				System.out.println("Admin Olarak Giriþ Yapabilirsiniz." + "\n");
				System.out.print("Adýnýzý Giriniz: ");
				scanner.nextLine();
				adminAd = scanner.nextLine();
				System.out.print("Soyadýnýzý Giriniz: ");
				adminSoyad = scanner.nextLine();
				System.out.print("Þifrenizi Giriniz: ");
				adminSifre = scanner.nextLine();
				System.out.println();
				AdminRepository adminRepository = new AdminRepository();
				System.out.println();
				if (adminRepository.list().size() == 0) {
					System.out.println("Kaydýnýz Bulunamamaktadýr." + "\n");
				}
				if (adminAd.isEmpty() || adminSoyad.isEmpty() || adminSifre.isEmpty()) {
					System.out.println("Verilen Alanlar Boþ Býrakýlmýþtýr." + "\n");
				} else {
					try {
						if (adminAd.equals(adminRepository.list().get(0).getAdminAd())
								&& adminSoyad.equals(adminRepository.list().get(0).getAdminSoyad())
								&& adminSifre.equals(adminRepository.list().get(0).getAdminSifre())) {
							System.out.println("Giriþ Baþarýlý" + "\n");
							do {
								System.out.println("\t" + "Ýlaç Eklemek Ýçin 1'i Tuþlayýnýz.");
								System.out.println("\t" + "Ýlaç Çýkarmak Ýçin 2'yi Tuþlayýnýz.");
								System.out.println("\t" + "Ýlaçlarý Göstermek Ýçin 3'ü Tuþlayýnýz.");
								System.out.println("\t" + "Toplam Ýlaç Sayýsýný Öðrenmek Ýçin 4'ü Tuþlayýnýz.");
								System.out.println("\t" + "Çýkýþ Ýþlemi Ýçin 5'i Tuþlayýnýz.");
								System.out.println("\n");
								try {
									menu = scanner.nextInt();
								} catch (Exception e) {

								}

								if (menu == 1) {
									System.out.println(
											"Ýlaç Ekleme Bölümümüze Hoþgeldiniz.Ýlaçlarý Eklemeye Baþlayabilirsiniz:"
													+ "\n");
									System.out.println("Ýlacýn Adýný Giriniz: ");
									scanner.nextLine();
									String ilacAd = scanner.nextLine();
									System.out.println("Ýlacýn Açýklamasýný Giriniz: ");
									String ilacAciklama = scanner.nextLine();
									System.out.println("Ýlacýn Fiyatýný Giriniz: ");
									try {
										ilacFiyat = scanner.nextInt();
									} catch (Exception e) {
										System.out.println("Lütfen Karakter Ýçeren Fiyat Girmeyiniz." + "\n");
									}
									IlacRepository ilacRepository = new IlacRepository();
									ilac.setIlacAd(ilacAd);
									ilac.setIlacAciklama(ilacAciklama);
									ilac.setIlacFiyat(ilacFiyat);
									ilacRepository.persist(ilac);
									ilacRepository.close();
									System.out.println("\n");
								} else if (menu == 2) {
									System.out.println(
											"Ýlaç Çýkarma Bölümümüze Hoþgeldiniz.Ýlaçlarý Çýkarmaya Baþlayabilirsiniz:"
													+ "\n");
									IlacRepository ilacRepository = new IlacRepository();
									if (ilacRepository.list().size() == 0) {
										System.out.println("Depoda Ýlaç Bulunmamaktadýr.");
									} else {
										System.out.println("Kaldýrmak Ýstediðiniz Ýlacýn ID Numarasýný Giriniz: ");
										try {
											Id = scanner.nextInt();
										} catch (Exception e) {
											System.out.println("Lütfen Karakter Ýçeren Id Girmeyiniz." + "\n");
										}
										if (ilacRepository.find(Id) != null) {
											ilacRepository.remove(Id);
										} else {
											System.out.println("Depoda " + Id
													+ " Numaralý Id Bulunamadý.Lütfen Baþka Bir Id Giriniz.");
										}
										ilacRepository.close();
									}
								} else if (menu == 3) {
									System.out.println(
											"Ýlaç Görüntüleme Bölümümüze Hoþgeldiniz.Listenin En Güncel Halini Buradan Görebilirsiniz: "
													+ "\n");
									IlacRepository ilacRepository = new IlacRepository();
									if (ilacRepository.list().size() == 0) {
										System.out.println("Depoda Listelenecek Ýlaç Bulunmamaktadýr.");
									} else {
										System.out.println("Ýlaçlar Listeleniyor..." + "\n");
										for (Ilac ilac : ilacRepository.list()) {
											System.out.println("Ýlaç Adý: " + ilac.getIlacAd());
											System.out.println("Ýlaç Açýklamasý: " + ilac.getIlacAciklama());
											System.out.println("Ýlaç Id Numarasý: " + ilac.getIlacId());
											System.out.println("Ýlaç Fiyatý: " + ilac.getIlacFiyat() + "\n");
										}
										ilacRepository.close();
									}
								} else if (menu == 4) {
									int boyut = ilacListesi.size();
									System.out.println("Toplam Ýlac Sayýsý: " + boyut + "\n");
								} else if (menu == 5) {
									System.out.println("Ýlaç Ýþlemlerinden Çýkýþ Yapýldý." + "\n");
									break;
								} else {
									System.out.println(
											"Menüde Olmayan Farklý Bir Sayý Girdiðiniz Ýçin Üst Menüye Aktarýldýnýz."
													+ "\n");
									break;
								}
							} while (menu != 6);
						} else {
							System.out.println("Hatalý Giriþ Yaptýnýz." + "\n");
						}
					} catch (Exception e) {
					}
				}
			} else if (giris == 3) {
				System.out.println("Kullanýcý Olarak Giriþ Yapabilirsiniz." + "\n");
				System.out.print("Adýnýzý Giriniz: ");
				scanner.nextLine();
				kullaniciAd = scanner.nextLine();
				System.out.print("Soyadýnýzý Giriniz: ");
				kullaniciSoyad = scanner.nextLine();
				System.out.print("Þifrenizi Giriniz: ");
				kullaniciSifre = scanner.nextLine();
				KullaniciRepository kullaniciRepository = new KullaniciRepository();
				System.out.println();
				if (kullaniciAd.isEmpty() || kullaniciSoyad.isEmpty() || kullaniciSifre.isEmpty()) {
					System.out.println("Verilen Alanlar Boþ Býrakýlmýþtýr." + "\n");
				}
				else {
					System.out.println();
					for (Kullanici kullanici : kullaniciRepository.list()) {
						if(kullaniciAd.equals(kullanici.getKullaniciAd()) && kullaniciSoyad.equals(kullanici.getKullaniciSoyad())
								&& kullaniciSifre.equals(kullanici.getKullaniciSifre())) {
							 okey=true;
							System.out.println("Giriþ Baþarýlý." + "\n");
							IlacRepository ilacRepository = new IlacRepository();
							
							if (ilacRepository.list().size() == 0) {
								
								System.out.println("Stokta Ýlaç Bulunmamaktadýr." + "\n");
							} 
							else {
								System.out.println("Ýlaçlar Listeleniyor..." + "\n");
								
								for (Ilac ilac : ilacRepository.list()) {
									
									System.out.println("Ýlaç Adý: " + ilac.getIlacAd());
									System.out.println("Ýlaç Açýklamasý: " + ilac.getIlacAciklama());
									System.out.println("Ýlaç Serinosu: " + ilac.getIlacId());
									System.out.println("Ýlaç Fiyatý: " + ilac.getIlacFiyat() + "\n");
								
								}
							}
						}
					}
					if(!okey) {		
						System.out.println("Hatalý Giriþ Yaptýnýz." + "\n");     
					}
						
					
				}
			  } 
				else if (giris == 4) {
				System.out.println("Müþteri Olarak Giriþ Yapabilirsiniz." + "\n");
				System.out.print("Adýnýzý Giriniz: ");
				scanner.nextLine();
				musteriAd = scanner.nextLine();
				System.out.print("Soyadýnýzý Giriniz: ");
				musteriSoyad = scanner.nextLine();
				MusteriRepository musteriRepository = new MusteriRepository();
				System.out.println();
				if (musteriAd.isEmpty() || musteriSoyad.isEmpty()) {
					System.out.println("Verilen Alanlar Boþ Býrakýlmýþtýr." + "\n");
				} else {
					System.out.println();
					for (Musteri musteri : musteriRepository.list()) {
						if (musteriAd.equals(musteri.getMusteriAd()) && musteriSoyad.equals(musteri.getMusteriSoyad())) {
							okey=true;
							System.out.println("Giriþ Baþarýlý." + "\n");
							IlacRepository ilacRepository = new IlacRepository();
							if (ilacRepository.list().size() == 0) {
								System.out.println("Stokta Ýlaç Bulunmamaktadýr." + "\n");
							} else {
								System.out.println("Ýlaçlar Listeleniyor..." + "\n");
								for (Ilac ilac : ilacRepository.list()) {
									System.out.println("Ýlaç Adý: " + ilac.getIlacAd());
									System.out.println("Ýlaç Açýklamasý: " + ilac.getIlacAciklama());
									System.out.println("Ýlaç Serinosu: " + ilac.getIlacId());
									System.out.println("Ýlaç Fiyatý: " + ilac.getIlacFiyat() + "\n");
								}
								while (true) {
									System.out.println(
											"Yukarýdaki Ýlaçlardan Birini Veya Daha Fazlasýný Almak Ýstiyorsanýz 1'i Tuþlayýnýz.");
									System.out.println(
											"Yukarýdaki Ýlaçlardan Hiçbirini Almak Ýstemiyorsanýz 2'yi Tuþlayýnýz.");
									int satiskontrol = scanner.nextInt();
									if (satiskontrol == 1) {
										if (ilacListesi.size() == 0) {
											System.out.println("Stokta Ýlaç Bulunmamaktadýr." + "\n");
										} else {
											System.out.print("Ýlacýn Serinosunu Giriniz: " + "\n");
											try {
												serinogir = scanner.nextInt();
											} catch (Exception e) {
												System.out.println(
														"Serino'yu Karakter Olarak Giremezsiniz.Lütfen Tekrar Giriniz."
																+ "\n");
											}
											for (int i = 0; i < ilacListesi.size(); i++) {
												if (ilacListesi.get(i).getIlacId() == serinogir) {
													musteri.getMusteriIlacList().add(new Ilac());
													ilacListesi.remove(i);
												}
											}
											for (Ilac ilac : musteri.getMusteriIlacList()) {
												System.out.println("Ýlaç Adý: " + ilac.getIlacAd());
												System.out.println("Ýlaç Açýklamasý: " + ilac.getIlacAciklama());
												System.out.println("Ýlaç Serinosu: " + ilac.getIlacId());
												System.out.println("Ýlaç Fiyatý: " + ilac.getIlacFiyat() + "\n");
											}
										}
									} else if (satiskontrol == 2) {
										System.out.println("Ýlaç Alma Ýþleminden Çýktýnýz." + "\n");
										break;
									} else {
										System.out.println("Hatalý Bir Sayý Tuþladýnýz." + "\n");
									}
								}
							}
						}
						 if (!okey) {
								System.out.println("Hatalý Giriþ Yaptýnýz." + "\n");
							}
					}
				}
			} else if (giris == 5) {
				System.out.println("Sistemden Çýkýldý.");
				System.exit(0);
			} else {
				System.out.println("Hatalý Tuþlama Yaptýnýz.");
			}
		}
	}

	public static void ilacCikar(int ilacSeriNo) {
		for (int i = 0; i < ilacListesi.size(); i++) {
			if (ilacListesi.get(i).getIlacId() == ilacSeriNo) {
				ilacListesi.remove(i);
			}
		}
	}

	public static void ilacEkle(String ilacAdý, String ilacAciklama, int ilacSeriNo) {
		ilacListesi.add(new Ilac());
	}
}