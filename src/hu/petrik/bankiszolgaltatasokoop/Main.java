package hu.petrik.bankiszolgaltatasokoop;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Tulajdonos t = new Tulajdonos("Sárándiúr");
        MegtakaritasiSzamla msz1 = new MegtakaritasiSzamla (t);
        Szamla szamla = new MegtakaritasiSzamla(t);
        System.out.println(t.getNev());
        szamla.befizet(150000);
        System.out.println("Számla értékek: "+ szamla.aktualisEgyenleg);
        szamla.kivesz(10000);
        System.out.println("Számla értéke kivétel után: "+ szamla.aktualisEgyenleg);

        HitelSzamla hitelSzamla = new HitelSzamla(t,250);
        System.out.printf("Hitelkeret: %d\n", hitelSzamla.getHitelKeret());
        hitelSzamla.kivesz(110);
        System.out.printf("Hitelkeret kivétel után: %d\n", hitelSzamla.getHitelKeret());

        Kartya kartya = new Kartya(t,szamla,"4213514");
        System.out.printf("Kártyaszám: %s\n",kartya.getKartyaSzam());
        kartya.vasarlas(156);
        System.out.printf("Összeg vásárlás után: %d\n",szamla.aktualisEgyenleg);

        HitelSzamla szh1 = new HitelSzamla(new Tulajdonos("SBalint2002"),365);
        HitelSzamla szh2 = new HitelSzamla(new Tulajdonos("SBalint2002"),250);
        MegtakaritasiSzamla msz2 = new MegtakaritasiSzamla(new Tulajdonos("énxd"));
        MegtakaritasiSzamla msz3 = new MegtakaritasiSzamla(new Tulajdonos("énaaa"));
        MegtakaritasiSzamla msz4 = new MegtakaritasiSzamla(new Tulajdonos("SBalint2002"));
        MegtakaritasiSzamla msz5 = new MegtakaritasiSzamla(new Tulajdonos("SBalint2002"));
        msz4.befizet(2133);
        msz4.setKamat(345);
        msz4.kamatJovairas();
        msz5.befizet(1);
        msz5.setKamat(23);
        msz5.kamatJovairas();

        Bank bank = new Bank();
        System.out.println(bank.getLegnagyobbEgyenleguSzamla(new Tulajdonos("SBalint2002")));
    }
}
