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
				"Giri� Olu�turmadan �nce Kay�t Yapmal�s�n�z.E�er Bir Kayd�n�z Varsa Giri� Yapabilirsiniz." + "\n");
		while (true) {
			System.out.println("\t" + "Yeni Bir Kay�t Olu�turmak ��in 1'i Tu�lay�n�z.");
			System.out.println("\t" + "Admin Olarak Giri� Yapmak ��in 2'yi Tu�lay�n�z.");
			System.out.println("\t" + "Kullan�c� Olarak Giri� Yapmak ��in 3'� Tu�lay�n�z.");
			System.out.println("\t" + "M��teri Olarak Giri� Yapmak ��in 4'� Tu�lay�n�z.");
			System.out.println("\t" + "Sistemden ��kmak ��in 5'i Tu�lay�n�z.");
			try {
giris = scanner.nextInt();
			} catch (Exception e) {
			}
			if (giris == 1) {
				System.out.println("Yeni bir Kimlik Olu�turun:" + "\n");
				System.out.println("Admin Kayd� Yapmak ��in 1'i Tu�lay�n�z.");
				System.out.println("Kullan�c� Kayd� Yapmak ��in 2'yi Tu�lay�n�z.");
				System.out.println("M��teri Kayd� Yapmak ��in 3'� Tu�lay�n�z.");
				try {
					kayit = scanner.nextInt();
				} catch (Exception e) {
				}
				if (kayit == 1) {
					System.out.print("Ad�n�z� Giriniz: ");
					scanner.nextLine();
					adminAd = scanner.nextLine();
					System.out.print("Soyad�n�z� Giriniz: ");
					adminSoyad = scanner.nextLine();
					System.out.print("�ifrenizi Giriniz: ");
					adminSifre = scanner.nextLine();
					AdminRepository adminRepository = new AdminRepository();
					if (adminRepository.list().size() == 0) {
						admin.setAdminAd(adminAd);
						admin.setAdminSoyad(adminSoyad);
						admin.setAdminSifre(adminSifre);
						adminRepository.persist(admin);
						System.out.println("Kayd�n�z Olu�turulmu�tur.");
					} else {
						System.out.println("Birden Fazla Kay�t Yapamazs�n�z.");
					}
					adminRepository.close();
				} else if (kayit == 2) {
					System.out.print("Ad�n�z� Giriniz: ");
					scanner.nextLine();
					kullaniciAd = scanner.nextLine();
					System.out.print("Soyad�n�z� Giriniz: ");
					kullaniciSoyad = scanner.nextLine();
					System.out.print("�ifrenizi Giriniz: ");
					kullaniciSifre = scanner.nextLine();
					KullaniciRepository kullaniciRepository = new KullaniciRepository();
					if (kullaniciRepository.list().size() == 0) {
					kullanici.setKullaniciAd(kullaniciAd);
					kullanici.setKullaniciSoyad(kullaniciSoyad);
					kullanici.setKullaniciSifre(kullaniciSifre);
					kullaniciRepository.persist(kullanici);
					System.out.println("Kayd�n�z Olu�turulmu�tur.");
					}
					kullaniciRepository.close();
				} else if (kayit == 3) {
					System.out.print("Ad�n�z� Giriniz: ");
					scanner.nextLine();
					musteriAd = scanner.nextLine();
					System.out.print("Soyad�n�z� Giriniz: ");
					musteriSoyad = scanner.nextLine();
					System.out.print("\n");
					MusteriRepository musteriRepository = new MusteriRepository();
					if (musteriRepository.list().size() == 0) {
					musteri.setMusteriAd(musteriAd);
					musteri.setMusteriSoyad(musteriSoyad);
					musteriRepository.persist(musteri);
					System.out.println("Kayd�n�z Olu�turulmu�tur.");
					}
					musteriRepository.close();
				} 
			} else if (giris == 2) {
				System.out.println("Admin Olarak Giri� Yapabilirsiniz." + "\n");
				System.out.print("Ad�n�z� Giriniz: ");
				scanner.nextLine();
				adminAd = scanner.nextLine();
				System.out.print("Soyad�n�z� Giriniz: ");
				adminSoyad = scanner.nextLine();
				System.out.print("�ifrenizi Giriniz: ");
				adminSifre = scanner.nextLine();
				System.out.println();
				AdminRepository adminRepository = new AdminRepository();
				System.out.println();
				if (adminRepository.list().size() == 0) {
					System.out.println("Kayd�n�z Bulunamamaktad�r." + "\n");
				}
				if (adminAd.isEmpty() || adminSoyad.isEmpty() || adminSifre.isEmpty()) {
					System.out.println("Verilen Alanlar Bo� B�rak�lm��t�r." + "\n");
				} else {
					try {
						if (adminAd.equals(adminRepository.list().get(0).getAdminAd())
								&& adminSoyad.equals(adminRepository.list().get(0).getAdminSoyad())
								&& adminSifre.equals(adminRepository.list().get(0).getAdminSifre())) {
							System.out.println("Giri� Ba�ar�l�" + "\n");
							do {
								System.out.println("\t" + "�la� Eklemek ��in 1'i Tu�lay�n�z.");
								System.out.println("\t" + "�la� ��karmak ��in 2'yi Tu�lay�n�z.");
								System.out.println("\t" + "�la�lar� G�stermek ��in 3'� Tu�lay�n�z.");
								System.out.println("\t" + "Toplam �la� Say�s�n� ��renmek ��in 4'� Tu�lay�n�z.");
								System.out.println("\t" + "��k�� ��lemi ��in 5'i Tu�lay�n�z.");
								System.out.println("\n");
								try {
									menu = scanner.nextInt();
								} catch (Exception e) {

								}

								if (menu == 1) {
									System.out.println(
											"�la� Ekleme B�l�m�m�ze Ho�geldiniz.�la�lar� Eklemeye Ba�layabilirsiniz:"
													+ "\n");
									System.out.println("�lac�n Ad�n� Giriniz: ");
									scanner.nextLine();
									String ilacAd = scanner.nextLine();
									System.out.println("�lac�n A��klamas�n� Giriniz: ");
									String ilacAciklama = scanner.nextLine();
									System.out.println("�lac�n Fiyat�n� Giriniz: ");
									try {
										ilacFiyat = scanner.nextInt();
									} catch (Exception e) {
										System.out.println("L�tfen Karakter ��eren Fiyat Girmeyiniz." + "\n");
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
											"�la� ��karma B�l�m�m�ze Ho�geldiniz.�la�lar� ��karmaya Ba�layabilirsiniz:"
													+ "\n");
									IlacRepository ilacRepository = new IlacRepository();
									if (ilacRepository.list().size() == 0) {
										System.out.println("Depoda �la� Bulunmamaktad�r.");
									} else {
										System.out.println("Kald�rmak �stedi�iniz �lac�n ID Numaras�n� Giriniz: ");
										try {
											Id = scanner.nextInt();
										} catch (Exception e) {
											System.out.println("L�tfen Karakter ��eren Id Girmeyiniz." + "\n");
										}
										if (ilacRepository.find(Id) != null) {
											ilacRepository.remove(Id);
										} else {
											System.out.println("Depoda " + Id
													+ " Numaral� Id Bulunamad�.L�tfen Ba�ka Bir Id Giriniz.");
										}
										ilacRepository.close();
									}
								} else if (menu == 3) {
									System.out.println(
											"�la� G�r�nt�leme B�l�m�m�ze Ho�geldiniz.Listenin En G�ncel Halini Buradan G�rebilirsiniz: "
													+ "\n");
									IlacRepository ilacRepository = new IlacRepository();
									if (ilacRepository.list().size() == 0) {
										System.out.println("Depoda Listelenecek �la� Bulunmamaktad�r.");
									} else {
										System.out.println("�la�lar Listeleniyor..." + "\n");
										for (Ilac ilac : ilacRepository.list()) {
											System.out.println("�la� Ad�: " + ilac.getIlacAd());
											System.out.println("�la� A��klamas�: " + ilac.getIlacAciklama());
											System.out.println("�la� Id Numaras�: " + ilac.getIlacId());
											System.out.println("�la� Fiyat�: " + ilac.getIlacFiyat() + "\n");
										}
										ilacRepository.close();
									}
								} else if (menu == 4) {
									int boyut = ilacListesi.size();
									System.out.println("Toplam �lac Say�s�: " + boyut + "\n");
								} else if (menu == 5) {
									System.out.println("�la� ��lemlerinden ��k�� Yap�ld�." + "\n");
									break;
								} else {
									System.out.println(
											"Men�de Olmayan Farkl� Bir Say� Girdi�iniz ��in �st Men�ye Aktar�ld�n�z."
													+ "\n");
									break;
								}
							} while (menu != 6);
						} else {
							System.out.println("Hatal� Giri� Yapt�n�z." + "\n");
						}
					} catch (Exception e) {
					}
				}
			} else if (giris == 3) {
				System.out.println("Kullan�c� Olarak Giri� Yapabilirsiniz." + "\n");
				System.out.print("Ad�n�z� Giriniz: ");
				scanner.nextLine();
				kullaniciAd = scanner.nextLine();
				System.out.print("Soyad�n�z� Giriniz: ");
				kullaniciSoyad = scanner.nextLine();
				System.out.print("�ifrenizi Giriniz: ");
				kullaniciSifre = scanner.nextLine();
				KullaniciRepository kullaniciRepository = new KullaniciRepository();
				System.out.println();
				if (kullaniciAd.isEmpty() || kullaniciSoyad.isEmpty() || kullaniciSifre.isEmpty()) {
					System.out.println("Verilen Alanlar Bo� B�rak�lm��t�r." + "\n");
				}
				else {
					System.out.println();
					for (Kullanici kullanici : kullaniciRepository.list()) {
						if(kullaniciAd.equals(kullanici.getKullaniciAd()) && kullaniciSoyad.equals(kullanici.getKullaniciSoyad())
								&& kullaniciSifre.equals(kullanici.getKullaniciSifre())) {
							 okey=true;
							System.out.println("Giri� Ba�ar�l�." + "\n");
							IlacRepository ilacRepository = new IlacRepository();
							
							if (ilacRepository.list().size() == 0) {
								
								System.out.println("Stokta �la� Bulunmamaktad�r." + "\n");
							} 
							else {
								System.out.println("�la�lar Listeleniyor..." + "\n");
								
								for (Ilac ilac : ilacRepository.list()) {
									
									System.out.println("�la� Ad�: " + ilac.getIlacAd());
									System.out.println("�la� A��klamas�: " + ilac.getIlacAciklama());
									System.out.println("�la� Serinosu: " + ilac.getIlacId());
									System.out.println("�la� Fiyat�: " + ilac.getIlacFiyat() + "\n");
								
								}
							}
						}
					}
					if(!okey) {		
						System.out.println("Hatal� Giri� Yapt�n�z." + "\n");     
					}
						
					
				}
			  } 
				else if (giris == 4) {
				System.out.println("M��teri Olarak Giri� Yapabilirsiniz." + "\n");
				System.out.print("Ad�n�z� Giriniz: ");
				scanner.nextLine();
				musteriAd = scanner.nextLine();
				System.out.print("Soyad�n�z� Giriniz: ");
				musteriSoyad = scanner.nextLine();
				MusteriRepository musteriRepository = new MusteriRepository();
				System.out.println();
				if (musteriAd.isEmpty() || musteriSoyad.isEmpty()) {
					System.out.println("Verilen Alanlar Bo� B�rak�lm��t�r." + "\n");
				} else {
					System.out.println();
					for (Musteri musteri : musteriRepository.list()) {
						if (musteriAd.equals(musteri.getMusteriAd()) && musteriSoyad.equals(musteri.getMusteriSoyad())) {
							okey=true;
							System.out.println("Giri� Ba�ar�l�." + "\n");
							IlacRepository ilacRepository = new IlacRepository();
							if (ilacRepository.list().size() == 0) {
								System.out.println("Stokta �la� Bulunmamaktad�r." + "\n");
							} else {
								System.out.println("�la�lar Listeleniyor..." + "\n");
								for (Ilac ilac : ilacRepository.list()) {
									System.out.println("�la� Ad�: " + ilac.getIlacAd());
									System.out.println("�la� A��klamas�: " + ilac.getIlacAciklama());
									System.out.println("�la� Serinosu: " + ilac.getIlacId());
									System.out.println("�la� Fiyat�: " + ilac.getIlacFiyat() + "\n");
								}
								while (true) {
									System.out.println(
											"Yukar�daki �la�lardan Birini Veya Daha Fazlas�n� Almak �stiyorsan�z 1'i Tu�lay�n�z.");
									System.out.println(
											"Yukar�daki �la�lardan Hi�birini Almak �stemiyorsan�z 2'yi Tu�lay�n�z.");
									int satiskontrol = scanner.nextInt();
									if (satiskontrol == 1) {
										if (ilacListesi.size() == 0) {
											System.out.println("Stokta �la� Bulunmamaktad�r." + "\n");
										} else {
											System.out.print("�lac�n Serinosunu Giriniz: " + "\n");
											try {
												serinogir = scanner.nextInt();
											} catch (Exception e) {
												System.out.println(
														"Serino'yu Karakter Olarak Giremezsiniz.L�tfen Tekrar Giriniz."
																+ "\n");
											}
											for (int i = 0; i < ilacListesi.size(); i++) {
												if (ilacListesi.get(i).getIlacId() == serinogir) {
													musteri.getMusteriIlacList().add(new Ilac());
													ilacListesi.remove(i);
												}
											}
											for (Ilac ilac : musteri.getMusteriIlacList()) {
												System.out.println("�la� Ad�: " + ilac.getIlacAd());
												System.out.println("�la� A��klamas�: " + ilac.getIlacAciklama());
												System.out.println("�la� Serinosu: " + ilac.getIlacId());
												System.out.println("�la� Fiyat�: " + ilac.getIlacFiyat() + "\n");
											}
										}
									} else if (satiskontrol == 2) {
										System.out.println("�la� Alma ��leminden ��kt�n�z." + "\n");
										break;
									} else {
										System.out.println("Hatal� Bir Say� Tu�lad�n�z." + "\n");
									}
								}
							}
						}
						 if (!okey) {
								System.out.println("Hatal� Giri� Yapt�n�z." + "\n");
							}
					}
				}
			} else if (giris == 5) {
				System.out.println("Sistemden ��k�ld�.");
				System.exit(0);
			} else {
				System.out.println("Hatal� Tu�lama Yapt�n�z.");
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

	public static void ilacEkle(String ilacAd�, String ilacAciklama, int ilacSeriNo) {
		ilacListesi.add(new Ilac());
	}
}