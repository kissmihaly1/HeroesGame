public class Van {
    public static void main() {
        int db = 0;
        while(Egysegek.egysegeim.length==db){}

        for (int i = 0; i < Egysegek.egysegeim.length; i++) {
            if (Egysegek.egysegeim[i] == null) {
                db++;
            }
        }
        if (Egysegek.egysegeim.length == db&&Hos.sajat.getPenz()<2) {
            System.out.println("Okos vagy testvérem, nem maradt pénzed egységre.................. kapsz EGY db íjászt, hogy gyorsan kikapj");
            Egysegek.egysegeim[1] = Egysegek.ijasz;
            Egysegek.egysegeim[1].setTamadoereje(Ijasz.tamadas());
            Egysegek.egysegeim[1].setEletero(7);
            Egysegek.egysegeim[1].setMennyi(1);
        }
        else if (Egysegek.egysegeim.length == db){
            System.err.println("Nem választottál egy egységet sem. Lécci válassz, visszatérsz a főmenübe.");
            Menu.main();
        }
    }
}
