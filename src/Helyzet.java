import java.util.Objects;
import java.util.Scanner;

public class Helyzet {

    public static void helyzet() {
        System.out.println("Jelenlegi aranyad: "+Hos.sajat.getPenz()+"\nJelenlegi egységeid: \n   Földműves: "+((Egysegek.egysegeim[0]==null)?  "0": Egysegek.egysegeim[0].getMennyi())+"\n   Íjász: "+((Egysegek.egysegeim[1]==null)?  "0": Egysegek.egysegeim[1].getMennyi())
                +"\n   Griff: "+((Egysegek.egysegeim[2]==null)?  "0": Egysegek.egysegeim[2].getMennyi())+"\n   Cerberus: "+((Egysegek.egysegeim[3]==null)?  "0": Egysegek.egysegeim[3].getMennyi())+"\n   Törpe: "+((Egysegek.egysegeim[4]==null)?  "0": Egysegek.egysegeim[4].getMennyi())
        +"\nJelenlegi varázslataid: "+
                "\n   Villámcsapás: "+(SajatHos.sajat.isVillamcsapas()? "van":"nincs")+
                "\n   Tűzlabda: "+(SajatHos.sajat.isTuzlabda()? "van":"nincs")+
                "\n   Feltámasztás: "+(SajatHos.sajat.isFeltamasztas()? "van":"nincs")+
                        "\n   Gyorsítás: "+(SajatHos.sajat.isLassitas()? "van":"nincs")+
                        "\n   Lassítás: "+(SajatHos.sajat.isGyorsitas()? "van":"nincs")+
                "\nTulajdonságaid:"+
                "\n   Támadás: "+Hos.sajat.getTamadas()+
                "\n   Védekezés: "+Hos.sajat.getVedekezes()+
                "\n   Varázserő: "+Hos.sajat.getVarazsero()+
                "\n   Tudás: "+Hos.sajat.getTudas()+
                "\n   Morál: "+Hos.sajat.getMoral()+
                "\n   Szerencse: "+Hos.sajat.getSzerencse()
                +"\nFőmenübe lépéshez írd be: kilepek"

        );
        String nev = null;
        while(!Objects.equals(nev, "kilepek")){
            Scanner beolvas= new Scanner(System.in);
            nev=beolvas.nextLine();
            if (nev.equals("kilepek")){
                System.out.println("""
                -----------------------------------------------------
                Ez a menü, választanod kell egy számot, vagy szót:\s
                1: Tulajdonságok
                2: Egységek
                3. Varázslatok vétele
                4: Csata indítása
                5: Jelenlegi helyzeted
                kilepek: Főmenübe lépés
                -----------------------------------------------------""");
                break;
            }
            else {
                System.out.println("Rossz inputot adtál meg!");

            }
        }

    }
}
