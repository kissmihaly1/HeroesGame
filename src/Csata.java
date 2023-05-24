import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Csata {

    static Egysegek[][] mezok = new Egysegek[12][10];

    public static void csata() {
        //EGYSÉG LEHELYEZÉS


        System.out.println("Válassztanod kell az egységeidnek kezdőpontot.\nEhhez két számot kell megadnod. " +
                "Első az oszlop, második a sor.");
        for (int i = 0; i < Egysegek.egysegeim.length; i++) {
            int oszlop = 100;
            int sor = 100;
            String asd = "";
            if (Egysegek.egysegeim[i] != null) {
                System.out.println("Most " + Egysegek.egysegeim[i].getNeve() + "-nak/nek választasz helyet!");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Elsőnek az oszlop számát add meg: ((0,1))");
                while (!(oszlop <= 1 && oszlop >= 0)) {
                    asd = scanner.nextLine();
                    try {
                        oszlop = Integer.parseInt(asd);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    if (!(oszlop <= 1 && oszlop >= 0)) {
                        System.err.println("Nem jó az input tesómsz! Add meg újra. (0 vagy 1)");
                    }
                }
                System.out.println("Most a sor számát add meg: ((0-tól 9-ig))");
                while (!(sor <= 9 && sor >= 0)) {
                    asd = scanner.nextLine();
                    try {
                        sor = Integer.parseInt(asd);
                    } catch (Exception e) {
                        System.err.println("Baj van. Rossz az input....");
                    }
                    if (!(sor <= 9 && sor >= 0)) {

                        System.err.println("Nem jó az input tesómsz! Add meg újra. (0-tól 9-ig.)");
                    }
                }

                if (mezok[oszlop][sor] == null) {
                    mezok[oszlop][sor] = Egysegek.egysegeim[i];
                    mezok[oszlop][sor].setMennyi(Egysegek.egysegeim[i].getMennyi());
                    mezok[oszlop][sor].setOszlop(oszlop);
                    mezok[oszlop][sor].setSor(sor);


                } else {
                    System.out.println("Itt már van " + mezok[oszlop][sor].getNeve() + " egységed. Újra választanod kell.");
                    System.out.println();
                    i--;
                }
            }

        }

    }
    

    public static void palya() {
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "| ");

            for (int j = 0; j < 12; j++) {
                if (mezok[j][i] == null) {
                    System.out.print(" .. ");
                } else {
                    System.out.print(" " + mezok[j][i].getNeve() + " ");
                }
            }

            System.out.println();
        }
    }

    public static boolean criticalOwn() {
        Random random = new Random();
        int rand = 0;
        rand = random.nextInt(101);


        if (rand > Hos.sajat.getSzerencse() * 5) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean criticalEnemy() {
        Random random = new Random();
        int rand = 0;
        rand = random.nextInt(101);


        if (rand > Hos.ellenfel.getSzerencse() * 5) {
            return false;
        } else {
            return true;
        }
    }


    public static void csata2() {
        mezok[11][0] = EllenfelEgyseg.ellenfelEgysegei[0];
        mezok[11][1] = EllenfelEgyseg.ellenfelEgysegei[1];
        mezok[11][2] = EllenfelEgyseg.ellenfelEgysegei[2];
        mezok[11][3] = EllenfelEgyseg.ellenfelEgysegei[3];
        mezok[11][4] = EllenfelEgyseg.ellenfelEgysegei[4];
        mezok[11][4].setSor(4);
        mezok[11][3].setSor(3);
        mezok[11][2].setSor(2);
        mezok[11][1].setSor(1);
        mezok[11][0].setSor(0);

        mezok[11][4].setOszlop(11);
        mezok[11][3].setOszlop(11);
        mezok[11][2].setOszlop(11);
        mezok[11][1].setOszlop(11);
        mezok[11][0].setOszlop(11);


        EllenfelEgyseg.ellenfelEgysegei[0].setNeve("EF");
        EllenfelEgyseg.ellenfelEgysegei[1].setNeve("EI");
        EllenfelEgyseg.ellenfelEgysegei[2].setNeve("EG");
        EllenfelEgyseg.ellenfelEgysegei[3].setNeve("EC");
        EllenfelEgyseg.ellenfelEgysegei[4].setNeve("ET");
        if (Egysegek.egysegeim[0] != null) {
            Egysegek.egysegeim[0].setNeve("SF");
        }
        if (Egysegek.egysegeim[1] != null) {
            Egysegek.egysegeim[1].setNeve("SI");
        }
        if (Egysegek.egysegeim[2] != null) {
            Egysegek.egysegeim[2].setNeve("SG");
        }
        if (Egysegek.egysegeim[3] != null) {
            Egysegek.egysegeim[3].setNeve("SC");
        }
        if (Egysegek.egysegeim[4] != null) {
            Egysegek.egysegeim[4].setNeve("ST");
        }


        //CSATA


    }

    public static int vege() {
        int db = 0;
        int db2 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("S")) {
                    db++;
                }
                if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("E")) {
                    db2++;
                }
            }
        }
        if (db == 0 && db2 == 0) {
            return 2;
        } else if (db2 == 0) {
            return 1;
        } else if (db == 0) {
            return 0;
        } else {
            return -1;
        }

    }

    public static int villamSebzes() {
        int sebzes = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (mezok[j][i] != null && mezok[j][i].getNeve().equals("S")) {
                    sebzes = Hos.ellenfel.getVarazsero() * 30;
                }
            }
        }
        return sebzes;
    }

    public static int tuzlabdaSebzes() {
        int sebzes = 0;
        for (int l = 0; l < 10; l++) {
            for (int m = 0; m < 12; m++) {
                if (mezok[m][l] != null && mezok[m][l].getNeve().startsWith("S")) {
                    if (Ellenfel.ellenfel.getTudas() - 9 >= 0 && Ellenfel.ellenfel.isTuzlabda()) {
                        int sor = l;
                        int oszlop = m;
                        for (int t = sor - 1; t < sor + 2; t++) {
                            for (int z = oszlop - 1; z < oszlop + 2; z++) {
                                if ((z < 12 && z >= 0) && (t < 10 && t >= 0) && mezok[z][t] != null) {
                                    if (mezok[z][t].getNeve().startsWith("S")) {
                                        sebzes += Hos.ellenfel.getVarazsero() * 20;
                                    } else {
                                        sebzes -= Hos.ellenfel.getVarazsero() * 20;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return sebzes;
    }


    public static void feleleszt(int o) {
        Egysegek[] osszes = ellenoriz();
        int gyogyulsa = 0;
        String gyogy = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gyogy = scanner.nextLine();
            System.out.println("Kit szeretnél gyógytani? Csak saját egység. Pl: ST");
            if (Objects.equals(gyogy, "ST") || Objects.equals(gyogy, "SG") || Objects.equals(gyogy, "SF") || Objects.equals(gyogy, "SI") || Objects.equals(gyogy, "SC")) {

                break;
            } else {
                System.out.println("Nem jó érték, vagy nem a saját egységed.");
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (o < osszes.length && mezok[j][i] != null && gyogy.equals(mezok[j][i].getNeve())) {

                    if (mezok[j][i].getMax() >= mezok[j][i].getEletero() + Hos.sajat.getVarazsero() * 50) {
                        mezok[j][i].setEletero(mezok[j][i].getEletero() + Hos.sajat.getVarazsero() * 50);
                        gyogyulsa =Hos.sajat.getVarazsero() * 50;
                        System.out.println(mezok[j][i].getNeve() + " egységed gyógyult, " + gyogyulsa + " mértékben.");
                        Hos.sajat.setTudas(Hos.sajat.getTudas() - 6);
                    } else {
                        while (mezok[j][i].getMax() >= mezok[j][i].getEletero() && mezok[j][i].getEletero() + Hos.sajat.getVarazsero() * 50 >= gyogyulsa) {
                            mezok[j][i].setMennyi(mezok[j][i].getEletero() + gyogyulsa);

                        }
                        Hos.sajat.setTudas(Hos.sajat.getTudas() - 6);
                        System.out.println(mezok[j][i].getNeve() + " egységed gyógyult, " + gyogyulsa + " mértékben.");

                    }


                }
            }
        }
    }

    public static int hossza(int o) {
        Egysegek[] osszes = ellenoriz();
        int oszlop = 100;
        int sor = 100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (o < osszes.length && mezok[j][i] != null && osszes[o].getNeve().equals(mezok[j][i].getNeve())) {
                    oszlop = j;
                    sor = i;
                }
            }
        }
        int db = 0;
        for (int i = sor - 1; i < sor + 2; i++) {
            for (int j = oszlop - 1; j < oszlop + 2; j++) {
                if ((j < 12 && j >= 0) && (i < 10 && i >= 0)) {
                    if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("E")) {
                        db++;
                    }
                }
            }
        }
        return db;
    }
    public static int hossza2(int o) {
        Egysegek[] osszes = ellenoriz();
        int oszlop = 100;
        int sor = 100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (o < osszes.length && mezok[j][i] != null && osszes[o].getNeve().equals(mezok[j][i].getNeve())) {
                    oszlop = j;
                    sor = i;
                }
            }
        }
        int db = 0;
        for (int i = sor - 1; i < sor + 2; i++) {
            for (int j = oszlop - 1; j < oszlop + 2; j++) {
                if ((j < 12 && j >= 0) && (i < 10 && i >= 0)) {
                    if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("S")) {
                        db++;
                    }
                }
            }
        }
        return db;
    }



    public static boolean lassitas(int o) {
        boolean lassitva = false;
        Egysegek[] osszes = ellenoriz();
        String gyogy = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Kit szeretnél lassítani? pl: (ET)");
            gyogy = scanner.nextLine();
            if (Objects.equals(gyogy, "ET") || Objects.equals(gyogy, "EG") || Objects.equals(gyogy, "EF") || Objects.equals(gyogy, "EI") || Objects.equals(gyogy, "EC")) {

                break;
            } else {
                System.out.println("Nem jó érték, vagy nem az ellenfél egysége.");
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (o < osszes.length && mezok[j][i] != null && gyogy.equals(mezok[j][i].getNeve())) {
                    Hos.sajat.setTudas(Hos.sajat.getTudas() - 8);
                    mezok[j][i].setSebesseg(mezok[j][i].getSebesseg() - 1);

                    System.out.println(mezok[j][i].getNeve() + " egység lassítva lett, 1 értékkel. " + Hos.sajat.getTudas() + " manád maradt.");
                    lassitva = true;

                }
            }
        }
        if (!lassitva) {
            System.out.println("Ezt az egységet nem tudod lassítani.");
            return false;
        } else {
            return true;
        }


    }

    public static boolean gyorsitas(int o) {
        boolean gyorsitas = false;
        Egysegek[] osszes = ellenoriz();
        String gyogy = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gyogy = scanner.nextLine();
            if (Objects.equals(gyogy, "ST") || Objects.equals(gyogy, "SG") || Objects.equals(gyogy, "SF") || Objects.equals(gyogy, "SI") || Objects.equals(gyogy, "SC")) {

                break;
            } else {
                System.out.println("Nem jó érték, vagy nem a saját egységed.");
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (o < osszes.length && mezok[j][i] != null && gyogy.equals(mezok[j][i].getNeve())) {
                    Hos.sajat.setTudas(Hos.sajat.getTudas() - 8);
                    mezok[j][i].setSebesseg(mezok[j][i].getSebesseg() + 1);
                    System.out.println(mezok[j][i].getNeve() + " egység gyorsítva, 1 értékkel. " + Hos.sajat.getTudas() + " manád maradt.");
                    gyorsitas = true;

                }
            }
        }
        if (!gyorsitas) {
            System.out.println("Ezt az egységet nem tudod lassítani.");
            return false;
        } else {
            return true;
        }
    }




    public static boolean ijaszTamad(int o){
//Ha Et-t adok meg támadási inputnak, ET helyett

        Egysegek[] osszes = ellenoriz();

        int oszlop=100;
        int sor=100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(mezok[j][i]!=null&&osszes[o].getNeve().equals(mezok[j][i].getNeve())){
                    oszlop=j;
                    sor=i;
                }
            }
        }
        int db =0;
        for (int i = sor-1; i < sor+2; i++) {
            for (int j = oszlop-1; j < oszlop+2; j++) {
                if ((j<12&&j>=0)&&(i<10&&i>=0)) {
                    if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("E")) {
                        db++;
                    }
                }
            }
        }
        if (db==0){
            return true;
        }
        else {
            return false;
        }
    }

    static int enemyOszlop=0;
    static int enemySor=0;

    public static Egysegek[] tamadhat(int o){
        tamadoero();
        Egysegek[] osszes = ellenoriz();
        int oszlop=100;
        int sor=100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(mezok[j][i]!=null&&osszes[o].getNeve().equals(mezok[j][i].getNeve())){
                    oszlop=j;
                    sor=i;
                }
            }
        }
        int db =0;
        for (int i = sor-1; i < sor+2; i++) {
            for (int j = oszlop-1; j < oszlop+2; j++) {
                if ((j<12&&j>=0)&&(i<10&&i>=0)) {
                    if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("E")) {
                        db++;
                    }
                }
            }
        }
        int a =0;
        Egysegek[] osszes2= new Egysegek[db];
            for (int i = sor -1; i < sor + 2; i++) {
                for (int j = oszlop - 1; j < oszlop + 2; j++) {
                    if ((j<12&&j>=0)&&(i<10&&i>=0)) {
                    if (mezok[j][i] != null&&mezok[j][i].getNeve().startsWith("E")) {
                        osszes2[a] = mezok[j][i];
                        a++;
                    }
                    }
                }
            }
            return osszes2;
    }

    public static boolean meghalt() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (mezok[j][i]!=null&&mezok[j][i].getEletero()<=0){
                    System.out.println("A(z) "+ mezok[j][i].getNeve()+" egység meghalt.");
                    mezok[j][i]=null;

                    return true;
                }
            }
        }
    return false;
    }

    public static Egysegek[] ellenoriz(){

        int db =0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (mezok[j][i]!=null){
                    db++;
                }
            }
        }
        Egysegek[] osszes = new Egysegek[db];
        Egysegek[] segito = new Egysegek[db];
        int db5 =0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (mezok[j][i]!=null){
                    osszes[db5]=mezok[j][i];
                    db5++;
                }
            }
        }


        for (int i = osszes.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (osszes[j+1].getKezdemenyezes() > osszes[j].getKezdemenyezes()) {
                    segito[0] = osszes[j];
                    osszes[j] = osszes[j + 1];
                    osszes[j + 1] = segito[0];
                }
            }
        }
    return osszes;

    }
    public static void mennyi(){
        Egysegek[] osszes=ellenoriz();
        for (int i = 0; i < osszes.length; i++) {
            if (osszes[i].getEletero()>0){
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 12; k++) {
                        if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())) {
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals("EF") || osszes[i].getNeve().equals("SF")) {
                                mezok[k][j].setMennyi((mezok[k][j].getEletero() / 3));
                                if (mezok[k][j].getEletero()%3==0){}
                                else {
                                    mezok[k][j].setMennyi(mezok[k][j].getMennyi()+1);
                                }

                            }
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals("EI") || osszes[i].getNeve().equals("SI")) {
                                mezok[k][j].setMennyi((mezok[k][j].getEletero() / 7));
                                if (mezok[k][j].getEletero()%7==0){}
                                else {
                                    mezok[k][j].setMennyi(mezok[k][j].getMennyi()+1);
                                }
                            }
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals("EG") || osszes[i].getNeve().equals("SG")) {
                                mezok[k][j].setMennyi((mezok[k][j].getEletero() / 30));
                                if (mezok[k][j].getEletero()%30==0){}
                                else {
                                    mezok[k][j].setMennyi(mezok[k][j].getMennyi()+1);
                                }
                            }
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals("EC") || osszes[i].getNeve().equals("SC")) {
                                mezok[k][j].setMennyi((mezok[k][j].getEletero() / 20));
                                if (mezok[k][j].getEletero()%20==0){}
                                else {
                                    mezok[k][j].setMennyi(mezok[k][j].getMennyi()+1);
                                }
                            }
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals("ET") || osszes[i].getNeve().equals("ST")) {
                                mezok[k][j].setMennyi((mezok[k][j].getEletero() / 10));
                                if (mezok[k][j].getEletero()%10==0){}
                                else {
                                    mezok[k][j].setMennyi(mezok[k][j].getMennyi()+1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Egysegek[] ellenfelTamad(int o) {
        tamadoero();
        Egysegek[] osszes = ellenoriz();
        int oszlop=100;
        int sor=100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(mezok[j][i]!=null&&osszes[o].getNeve().equals(mezok[j][i].getNeve())){
                    oszlop=j;
                    sor=i;
                }
            }
        }
        int db =0;
        for (int i = sor-1; i < sor+2; i++) {
            for (int j = oszlop-1; j < oszlop+2; j++) {
                if ((j<12&&j>=0)&&(i<10&&i>=0)) {
                    if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("S")) {
                        db++;
                    }
                }
            }
        }
        int a =0;
        Egysegek[] osszes2= new Egysegek[db];
        for (int i = sor -1; i < sor + 2; i++) {
            for (int j = oszlop - 1; j < oszlop + 2; j++) {
                if ((j<12&&j>=0)&&(i<10&&i>=0)) {
                    if (mezok[j][i] != null&&mezok[j][i].getNeve().startsWith("S")) {
                        osszes2[a] = mezok[j][i];
                        a++;
                    }
                }
            }
        }
        return osszes2;
    }

    public static void tamadoero() {
        Egysegek[] osszes = ellenoriz();
        mennyi();
        for (int i = 0; i < osszes.length; i++) {
                if (osszes[i].getNeve().equals("EF")||osszes[i].getNeve().equals("SF")){
                    osszes[i].setTamadoereje(osszes[i].getEletero()/3);
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 12; k++) {
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())){
                                mezok[k][j].setTamadoereje(((mezok[k][j].getMennyi())));
                            }
                        }
                    }
                }
                if (osszes[i].getNeve().equals("EI")||osszes[i].getNeve().equals("SI")) {
                        int tamadas=0;
                        osszes[i].setTamadoereje((osszes[i].getEletero() / 7) * Ijasz.tamadas());
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())){
                                    for (int l = 0; l < mezok[k][j].getMennyi(); l++) {
                                        tamadas+=Ijasz.tamadas();

                                    }    mezok[k][j].setTamadoereje(tamadas);

                                }
                            }
                        }
                }
                if (osszes[i].getNeve().equals("EG")||osszes[i].getNeve().equals("SG")) {
                    int tamadas=0;
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {

                                if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())){
                                    for (int l = 0; l < mezok[k][j].getMennyi(); l++) {
                                        tamadas+=Griff.tamadas();

                                    }
                                    mezok[k][j].setTamadoereje(tamadas);
                                }
                            }
                        }
                }
                if (osszes[i].getNeve().equals("EC")||osszes[i].getNeve().equals("SC")) {
                    for (int j = 0; j < 10; j++) {
                        int tamadas = 0;
                        for (int k = 0; k < 12; k++) {

                            if (mezok[k][j] != null && osszes[i].getNeve().equals(mezok[k][j].getNeve())) {
                                for (int l = 0; l < mezok[k][j].getMennyi(); l++) {
                                    tamadas += Cerberus.tamadas();

                                }
                                mezok[k][j].setTamadoereje(tamadas);
                            }
                        }
                    }
                }

                if (osszes[i].getNeve().equals("ET")||osszes[i].getNeve().equals("ST")) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 12; k++) {
                            if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())){
                                mezok[k][j].setTamadoereje(mezok[k][j].getMennyi()*10);
                            }
                        }
                    }
                }
            }

        }


    public static void hosTulajdonsagok() {
//tudas
        Hos.sajat.setTudas(Hos.sajat.getTudas()*10);
        //moral

        Egysegek[] osszes=ellenoriz();
        for (int i = 0; i < osszes.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 12; k++) {
                    if (mezok[k][j]!=null&&osszes[i].getNeve().equals(mezok[k][j].getNeve())){
                        if (mezok[k][j].getNeve().startsWith("E")){
                            mezok[k][j].setKezdemenyezes(mezok[k][j].getKezdemenyezes()+Hos.ellenfel.getMoral());
                        }
                        if (mezok[k][j].getNeve().startsWith("S")){
                            mezok[k][j].setKezdemenyezes(mezok[k][j].getKezdemenyezes()+Hos.sajat.getMoral());

                        }

                    }
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k <5; k++) {


                    if (Egysegek.egysegeim[k]!=null&&mezok[j][i] != null && Egysegek.egysegeim[k].getNeve().equals(mezok[j][i].getNeve())){
                        mezok[j][i].setKezdemenyezes(mezok[j][i].getKezdemenyezes() + Hos.sajat.getMoral());
                    }
                }
            }

        }
        for (int a = 0; a < 5; a++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 12; j++) {
                    if (Egysegek.ellenfelEgysegei[a]!=null&&mezok[j][i] != null && Egysegek.ellenfelEgysegei[a].getNeve().equals(mezok[j][i].getNeve())) {
                        mezok[j][i].setKezdemenyezes(mezok[j][i].getKezdemenyezes() + Hos.ellenfel.getMoral());

                    }
                }

            }
        }

    }

    public static void megtekintes() {
        String nev="Okea";
        while(nev!="Oke"){
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------------------------------------------");
            System.out.println("Szeretnéd megtekinteni az ellenfeled? (igen/nem)");
            nev= scanner.nextLine();
            if (nev.equals("igen")){
                System.out.println("-----------------------------------------------------");
                System.out.println(      "Tulajdonságai:"+          "\n     Támadás: "+Hos.ellenfel.getTamadas()+
                        "\n     Védekezés: "+Hos.ellenfel.getVedekezes()+
                        "\n     Varázserő: "+Hos.ellenfel.getVarazsero()+
                        "\n     Tudás: "+Hos.ellenfel.getTudas()+
                        "\n     Morál: "+Hos.ellenfel.getMoral()+
                        "\n     Szerencse: "+Hos.ellenfel.getSzerencse()
                +     "\nVarázslatai:"+           "\n      Villámcsapás: "+(SajatHos.ellenfel.isVillamcsapas()? "van":"nincs")+
                                "\n     Tűzlabda: "+(SajatHos.ellenfel.isTuzlabda()? "van":"nincs")+
                                "\n     Feltámasztás: "+(SajatHos.ellenfel.isFeltamasztas()? "van":"nincs")+
                                "\n     Lassítás: "+(SajatHos.ellenfel.isLassitas()? "van":"nincs" +
                                "\n     Gyorsítás: "+(SajatHos.ellenfel.isGyorsitas()? "van":"nincs"))
                        );

                System.out.println("-----------------------------------------------------");
                System.out.println("Ha végeztél a megtekintéssel, írj be valamit.");
                nev= scanner.nextLine();
                nev="Oke";
                System.out.println("-----------------------------------------------------");
            }
            else if(nev.equals("nem")){
                nev="Oke";
            }

        }


    }


    public static boolean enemyOkos(int o) {
        Egysegek[] osszes=ellenoriz();
        Egysegek[] seged = new Egysegek[1];
        int oszlop=0;
        int sor=0;
        if (o<osszes.length) {
            seged[0] = osszes[o];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 12; j++) {
                    if (mezok[j][i] != null && osszes[o].getNeve().equals(mezok[j][i].getNeve())) {
                        oszlop = j;
                        sor = i;

                    }


                }
            }
            int sebesseg = osszes[o].getSebesseg();
            int sor1 = -12;
            int sor2 = 12;
            if (sor - seged[0].getSebesseg() / 2 >= 0) {
                sor1 = sor - seged[0].getSebesseg() / 2;
            } else {
                sor1 = 0;
            }
            if (sor + seged[0].getSebesseg() / 2 < 10) {
                sor2 = sor + seged[0].getSebesseg();
            } else {
                sor2 = 9;
            }

            int oszlop1 = -12;
            int oszlop2 = 12;
            if (oszlop - seged[0].getSebesseg() / 2 >= 0) {
                oszlop1 = oszlop - seged[0].getSebesseg() / 2;
            } else {
                oszlop1 = 0;
            }
            if (oszlop + seged[0].getSebesseg() / 2 < 12) {
                oszlop2 = sor + seged[0].getSebesseg();
            } else {
                oszlop2 = 11;
            }


            for (int i = sor1; i <= sor2; i++) {
                for (int j = oszlop1; j <= oszlop2; j++) {
                    if ((j < 12 && j >= 0) && (i < 10 && i >= 0)) {
                        if (mezok[j][i] != null && mezok[j][i].getNeve().startsWith("S")) {
                            if (mezok[j][i + 1] == null && i + 1 < 10) {
                                seged[0] = mezok[oszlop][sor];
                                mezok[oszlop][sor] = null;
                                mezok[j][i + 1] = seged[0];
                                enemyOszlop = j;
                                enemySor = i + 1;
                                System.out.println("Az ellenfél "+mezok[j][i+1].getNeve()+ " egysége ide lépett: "+enemyOszlop+". oszlop," +enemySor +". sor.");

                                return true;
                            } else if (mezok[j][i - 1] == null && i - 1 >= 0) {
                                seged[0] = mezok[oszlop][sor];
                                mezok[oszlop][sor] = null;
                                mezok[j][i - 1] = seged[0];
                                enemyOszlop = j;
                                enemySor = i - 1;
                                System.out.println("Az ellenfél "+mezok[j][i-1].getNeve()+ " egysége ide lépett: "+enemyOszlop+". oszlop," +enemySor +". sor.");

                                return true;
                            } else if (mezok[j + 1][i] == null && j + 1 <= 11) {
                                seged[0] = mezok[oszlop][sor];
                                mezok[oszlop][sor] = null;
                                mezok[j + 1][i] = seged[0];
                                enemyOszlop = j + 1;
                                System.out.println("Az ellenfél "+mezok[j+1][i].getNeve()+ "egysége ide lépett: "+enemyOszlop+". oszlop," +enemySor +". sor.");

                                enemySor = i;
                                return true;
                            } else if (mezok[j - 1][i] == null && j - 1 >= 0) {
                                seged[0] = mezok[oszlop][sor];
                                mezok[oszlop][sor] = null;
                                mezok[j - 1][i] = seged[0];
                                enemyOszlop = j - 1;
                                enemySor = i;
                                System.out.println("Az ellenfél "+mezok[j-1][i].getNeve()+ "egysége ide lépett: "+enemyOszlop+". oszlop," +enemySor +". sor.");
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;





    }



    public static void harc() {
        Ellenfel.ellenfel.setTudas(Ellenfel.ellenfel.getTudas()*10);
        int obetu2=0;
        boolean allas=false;
        boolean elleenfelHose=false;
        boolean ijasz=false;
        boolean vege=false;
        boolean aitamad=false;
        tamadoero();
        int k =0;
        boolean kamulepes=false;
        int szamos=0;
        Scanner scanner = new Scanner(System.in);
        boolean hos=false;
        String nev="Jozsi";
        hosTulajdonsagok();
        int kor=1;
        boolean tamadottEllenfel=false;
        boolean obetu=false;
        boolean ellenfel = false;
        while(vege()==-1||vege()==0||vege()==1||vege()==2){
            tamadoero();
            Egysegek[] osszes=ellenoriz();
            elleenfelHose=false;
            for (int o = 0; o < osszes.length; o++) {
                tamadottEllenfel=false;
                if (obetu){
                    o=obetu2;
                    obetu=false;
                }
                if (allas){
                    o=obetu2;
                    allas=false;
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (o < osszes.length) {
                            tamadoero();
                            if (mezok[j][i] != null && osszes[o].getNeve().equals(mezok[j][i].getNeve()) && mezok[j][i].getNeve().startsWith("S")) {
                                palya();
                                System.out.println("-----------------------------------------------------");
                                System.out.println(kor+". kör. Egységek sorrendje: ");

                                for (int l = 0; l < osszes.length; l++) {
                                    if (l==osszes.length-1){
                                        System.out.println(osszes[l].getNeve()+".");
                                    }
                                    else {
                                        System.out.print(osszes[l].getNeve()+", ");

                                    }
                                }
                                System.out.println("-----------------------------------------------------");

                                System.out.println("Ez az egységed jön: " + mezok[j][i].getNeve() + ". Életereje: " + mezok[j][i].getEletero() + ". Támadóereje: " + mezok[j][i].getTamadoereje());
                                System.out.println("Válassz mit csináljon: lepes, tamadas, varakozas, hos, allas");
                                nev = scanner.nextLine();
                                if (nev.equals("tamadas")){
                                        Egysegek[] tamadhato = new Egysegek[hossza(o)];
                                        tamadoero();
                                        if (!mezok[j][i].getNeve().equals("SI")) {
                                            for (int l = 0; l < 10; l++) {
                                                for (int m = 0; m < 12; m++) {
                                                    for (int n = 0; n < hossza(o); n++) {
                                                        if (mezok[m][l] != null && tamadhat(o)[n].getNeve().equals(mezok[m][l].getNeve())) {
                                                            System.out.println("Ezt az egységet támadhatod, írd be a nevét: " + mezok[m][l].getNeve());
                                                            tamadhato[n] = tamadhat(o)[n];

                                                        }
                                                    }
                                                }
                                            }
                                            if (tamadhato.length > 0) {
                                                nev = scanner.nextLine();
                                            } else {
                                                System.err.println("Nem tudsz senkit sem támadni!");
                                                obetu = true;
                                                kamulepes=true;


                                            }
                                            for (int m = 0; m < tamadhato.length; m++) {
                                                if (tamadhato[m] != null && nev.equals(tamadhato[m].getNeve())) {

                                                    for (int n = 0; n < 10; n++) {
                                                        for (int p = 0; p < 12; p++) {
                                                            if (mezok[p][n] != null && Objects.equals(tamadhato[m].getNeve(), mezok[p][n].getNeve())) {
                                                                if (mezok[p][n].getEletero() > 0) {


                                                                    if (criticalOwn()) {
                                                                        System.out.println("Kritikus csapást mértél a(z) " + mezok[p][n].getNeve() + " egységre, " + (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2 + " sebzést okoztál.");
                                                                        mezok[p][n].setEletero(mezok[p][n].getEletero() - (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2);
                                                                    }
                                                                    else {
                                                                        System.out.println("Megtámadtad a(z) " + tamadhato[m].getNeve() + " egységet, " + ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100) + " sebzést okoztál.");
                                                                        mezok[p][n].setEletero(mezok[p][n].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100));
                                                                    }
                                                                    if (mezok[j][i].getNeve().equals("SC")&&mezok[p][n]!=null){
                                                                        mezok[p][n].setEletero(mezok[p][n].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) - Hos.ellenfel.getVedekezes() * 5 / 100));
                                                                        System.out.println("Cerberus egységed kétszer tud támadni! Ismét megtámadta az ellenfeled " +((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100)+" sebzést okozva.");
                                                                    }
                                                                    if (meghalt()) {
                                                                        osszes = ellenoriz();


                                                                        if (vege() == 1 || vege() == 0) {
                                                                            o = osszes.length;
                                                                            vege=true;
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (mezok[p][n]!=null&&(!mezok[p][n].isVissza()||mezok[p][n].getNeve().equals("EG"))) {
                                                                        System.out.println("Az ellenfél egysége visszatámadott "+ (((mezok[p][n].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))/2 + " értékkel.");
                                                                        mezok[p][n].setVissza(true);
                                                                        mezok[j][i].setEletero(mezok[j][i].getEletero() - (((mezok[p][n].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))/2);

                                                                    }
                                                                    if (meghalt()) {
                                                                        osszes = ellenoriz();


                                                                        if (vege() == 1 || vege() == 0) {
                                                                            o = osszes.length;
                                                                            vege=true;
                                                                            break;
                                                                        }
                                                                    }


                                                                }
                                                                if (meghalt()) {
                                                                    osszes = ellenoriz();


                                                                    if (vege() == 1 || vege() == 0) {
                                                                        o = osszes.length;
                                                                        vege=true;
                                                                        break;
                                                                    }
                                                                }


                                                            }
                                                        }
                                                    }
                                                }

                                            }



                                        }
                                        else {
                                            if (ijaszTamad(o)) {
                                                    System.out.println("Az íjászoddal bárkit támadhatsz, mert nincs körülötte senki. Válassz egy egységet. (Pl: ET)");
                                                    nev = scanner.nextLine();
                                                    for (int l = 0; l < 10; l++) {
                                                        for (int m = 0; m < 12; m++) {
                                                            if (mezok[m][l] != null && mezok[m][l].getNeve().equals(nev) && nev.startsWith("E") && (mezok[m][l].getNeve().endsWith("T") || mezok[m][l].getNeve().endsWith("F") || mezok[m][l].getNeve().endsWith("I") || mezok[m][l].getNeve().endsWith("G") || mezok[m][l].getNeve().endsWith("C"))) {
                                                                if (criticalOwn()) {
                                                                    System.out.println("Kritikus csapást mértél a(z) " + mezok[m][l].getNeve() + " egységre, " + (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2 + " sebzést okoztál.");
                                                                    mezok[m][l].setEletero(mezok[m][l].getEletero() - (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2);
                                                                }
                                                                else {
                                                                    mezok[m][l].setEletero(mezok[m][l].getEletero() - (mezok[j][i].getTamadoereje() * ((1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100));
                                                                    System.out.println("Megtámadtad a(z) " + mezok[m][l].getNeve() + " egységet, " + ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100) + " sebzést okoztál.");
                                                                }
                                                                ijasz = true;
                                                                if (meghalt()) {
                                                                    osszes = ellenoriz();


                                                                    if (vege() == 1 || vege() == 0) {
                                                                        o = osszes.length;
                                                                        vege = true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (!ijasz) {
                                                        System.err.println("Ilyen egységet nem tudsz támadni.");
                                                        obetu = true;
                                                    }
                                            }
                                            else {

                                                for (int l = 0; l < 10; l++) {
                                                    for (int m = 0; m < 12; m++) {
                                                        for (int n = 0; n < hossza(o); n++) {
                                                            if (mezok[m][l] != null && tamadhat(o)[n].getNeve().equals(mezok[m][l].getNeve())) {
                                                                System.out.println("Vannak az íjászod közelében. Ezt az egységet támadhatod, írd be a nevét: " + mezok[m][l].getNeve());
                                                                tamadhato[n] = tamadhat(o)[n];
                                                            }
                                                        }
                                                    }
                                                }
                                                nev = scanner.nextLine();
                                                boolean ijasztamadott2132=false;
                                                for (int m = 0; m < tamadhato.length; m++) {
                                                    if (tamadhato[m] != null && nev.equals(tamadhato[m].getNeve())) {
                                                        for (int n = 0; n < 10; n++) {
                                                            for (int p = 0; p < 12; p++) {
                                                                if (mezok[p][n] != null && Objects.equals(tamadhato[m].getNeve(), mezok[p][n].getNeve())) {
                                                                    if (mezok[p][n].getEletero() > 0) {

                                                                        if (criticalOwn()) {
                                                                            System.out.println("Kritikus csapást mértél a(z) " + mezok[p][n].getNeve() + " egységet, " + (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2 + " sebzést okoztál.");
                                                                            mezok[p][n].setEletero(mezok[p][n].getEletero() - (((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))*2);
                                                                        }
                                                                        else {
                                                                            System.out.println("Megtámadtad a(z) " + tamadhato[m].getNeve() + " egységet, " + ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100) + " sebzést okoztál.");
                                                                            mezok[p][n].setEletero(mezok[p][n].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100));
                                                                        }
                                                                        if (meghalt()) {
                                                                            osszes = ellenoriz();


                                                                            if (vege() == 1 || vege() == 0) {
                                                                                o = osszes.length;
                                                                                vege=true;
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (mezok[p][n]!=null&&(!mezok[p][n].isVissza()||mezok[p][n].getNeve().equals("EG"))) {
                                                                            System.out.println("Az ellenfél egysége visszatámadott "+ (((mezok[p][n].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))/2 + " értékkel.");
                                                                            mezok[p][n].setVissza(true);
                                                                            mezok[j][i].setEletero(mezok[j][i].getEletero() - (((mezok[p][n].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100-Hos.ellenfel.getVedekezes() * 5)/100))/2);

                                                                        }
                                                                        ijasztamadott2132=true;
                                                                    }
                                                                    if (meghalt()) {
                                                                        osszes = ellenoriz();


                                                                        if (vege() == 1 || vege() == 0) {
                                                                            o = osszes.length;
                                                                            vege=true;
                                                                            break;
                                                                        }
                                                                    }


                                                                }
                                                                else if (n==11&&p==9&&!ijasztamadott2132) {
                                                                    System.err.println("Rossz az input!");
                                                                    ijasztamadott2132=false;
                                                                    obetu=true;

                                                                }
                                                            }
                                                        }
                                                    }
                                                }

                                            }


                                    }


                                    //INNEN
                                }
                                else if (nev.equals("lepes")) {
                                    nev = "asd";

                                    int db5 = 0;
                                    if (kamulepes){
                                        db5=szamos;
                                        kamulepes=false;
                                    }
                                    System.out.println("Jelenlegi helyzete: " + j + ". oszlop " + i + ". sor");
                                    System.out.println("Add meg, hogy merre lépjen. (2,4,6,8, ennyi)");
                                    while (mezok[j][i]!=null&&mezok[j][i].getSebesseg() > db5) {
                                        nev = scanner.nextLine();
                                        switch (nev) {
                                            case "8" -> {
                                                while (true) {
                                                    if (i - 1 >= 0 && mezok[j][i - 1] == null) {
                                                        mezok[j][i - 1] = mezok[j][i];
                                                        mezok[j][i] = null;
                                                        db5++;
                                                        i = i - 1;
                                                        System.out.println("Léptél. Jelenlegi pozíciód: " + j + ". oszlop " + i + ". sor. Ennyi lépésed maradt: "+(mezok[j][i].getSebesseg()-db5));
                                                        break;
                                                    } else {
                                                        System.err.println("Érvénytelen lépés! (Másik egység, vagy pálya széle)");
                                                        System.out.println("Új értéket kell megadnod: ");
                                                        break;
                                                    }
                                                }
                                            }
                                            case "6" -> {
                                                while (true) {
                                                    if (j + 1 < 12 && mezok[j + 1][i] == null) {
                                                        mezok[j + 1][i] = mezok[j][i];
                                                        mezok[j][i] = null;
                                                        db5++;
                                                        j = j + 1;
                                                        System.out.println("Léptél. Jelenlegi pozíciód: " + j + ". oszlop " + i + ". sor. Ennyi lépésed maradt: "+(mezok[j][i].getSebesseg()-db5));
                                                        break;
                                                    } else {
                                                        System.err.println("Érvénytelen lépés! (Másik egység, vagy pálya széle)");
                                                        System.out.println("Új értéket kell megadnod: ");
                                                        break;
                                                    }
                                                }
                                            }
                                            case "4" -> {
                                                while (true) {
                                                    if (j - 1 >= 0 && mezok[j - 1][i] == null) {
                                                        mezok[j - 1][i] = mezok[j][i];
                                                        mezok[j][i] = null;
                                                        db5++;
                                                        j = j - 1;
                                                        System.out.println("Léptél. Jelenlegi pozíciód: " + j + ". oszlop " + i + ". sor. Ennyi lépésed maradt: "+(mezok[j][i].getSebesseg()-db5));
                                                        break;

                                                    } else {
                                                        System.err.println("Érvénytelen lépés! (Másik egység, vagy pálya széle)");
                                                        System.out.println("Új értéket kell megadnod: ");
                                                        break;
                                                    }
                                                }
                                            }
                                            case "2" -> {
                                                while (true) {
                                                    if (i + 1 <= 9 && mezok[j][i + 1] == null) {
                                                        mezok[j][i + 1] = mezok[j][i];
                                                        mezok[j][i] = null;
                                                        db5++;
                                                        i = i + 1;
                                                        System.out.println("Léptél. Jelenlegi pozíciód: " + j + ". oszlop " + i + ". sor. Ennyi lépésed maradt: "+(mezok[j][i].getSebesseg()-db5));
                                                        break;

                                                    } else {
                                                        System.err.println("Érvénytelen lépés! (Másik egység, vagy pálya széle)");
                                                        System.out.println("Új értéket kell megadnod: ");
                                                        break;
                                                    }
                                                }
                                            }
                                            case "ennyi" -> {
                                                db5 = mezok[j][i].getSebesseg();
                                            }

                                            default -> System.err.println("Érvénytelen lépés!!");

                                        }
                                    }
                                } else if (nev.equals("varakozas")) {
                                } else if (nev.equals("hos")) {
                                    if (!hos) {
                                        System.out.println("A hősöd jön. Válassz, mit csináljon: tamadas, varazslas");
                                        nev = scanner.nextLine();
                                        if (nev.equals("tamadas")) {
                                            System.out.println("Kit szeretnél megtámadni? (egység neve, pl.: ET)");
                                            nev = scanner.nextLine();
                                            boolean volt =false;
                                            while (true) {
                                                for (int l = 0; l < 10; l++) {
                                                    for (int m = 0; m < 12; m++) {
                                                        if (mezok[m][l] != null && mezok[m][l].getNeve().equals(nev)) {
                                                            if (mezok[m][l].getNeve().startsWith("E")&&(mezok[m][l].getNeve().endsWith("T")||mezok[m][l].getNeve().endsWith("F")||mezok[m][l].getNeve().endsWith("I")||mezok[m][l].getNeve().endsWith("G")||mezok[m][l].getNeve().endsWith("C"))) {
                                                                mezok[m][l].setEletero(mezok[m][l].getEletero() - Hos.sajat.getTamadas() * 10);
                                                                System.out.println(mezok[m][l].getNeve() + " életereje csökkent " + Hos.sajat.getTamadas() * 10 + " értékkel.");
                                                                hos = true;
                                                                if (meghalt()) {
                                                                    osszes = ellenoriz();

                                                                    if (vege() == 1 || vege() == 0) {
                                                                        o = osszes.length;
                                                                        vege=true;
                                                                        break;
                                                                    }
                                                                }
                                                                volt=true;
                                                                obetu = true;
                                                                break;

                                                            } else if (mezok[m][l] != null && mezok[m][l].getNeve().startsWith("S")) {

                                                                System.err.println("Saját egységet nem tudsz támadni. Ugyanaz az egységed jön.");
                                                                obetu = true;
                                                                break;
                                                            }

                                                        }
                                                        else if (m==11&&l==9&&!volt){
                                                                    obetu=true;
                                                                System.err.println("Hibás input tesómsz, újra ugyanaz az egységed jön.");

                                                        }
                                                        if (obetu){
                                                            break;
                                                        }

                                                    }
                                                }
                                                break;
                                            }
                                        } else if (nev.equals("varazslas")) {
                                            System.out.println("Melyik varázslás? villamcsapas, tuzlabda, feltamasztas, lassitas, gyorsitas");
                                            nev = scanner.nextLine();
                                            boolean varazsolt = false;
                                            if (nev.equals("villamcsapas")) {
                                                if (Hos.sajat.isVillamcsapas()) {

                                                    System.out.println("Kit szeretnél támadni vele? (pl.: ET)");
                                                    nev = scanner.nextLine();
                                                    for (int l = 0; l < 10; l++) {
                                                        for (int m = 0; m < 12; m++) {
                                                            if (mezok[m][l] != null && mezok[m][l].getNeve().equals(nev) && nev.startsWith("E")) {
                                                                varazsolt = true;
                                                                if (Hos.sajat.getTudas() - 5 >= 0) {
                                                                    Hos.sajat.setTudas(Hos.sajat.getTudas() - 5);
                                                                    mezok[m][l].setEletero(mezok[m][l].getEletero() - (Hos.sajat.getVarazsero() * 30));
                                                                    System.out.println(mezok[m][l].getNeve() + " egység " + Hos.sajat.getVarazsero() * 30 + " sebzést szenvedett el.");
                                                                    System.out.println("Hősödnek " + Hos.sajat.getTudas() + " manája maradt.");
                                                                    obetu = true;
                                                                    hos = true;
                                                                } else {
                                                                    System.err.println("Nincs elég manád a varázslásra! Ugyanaz az egységed következik.");
                                                                    obetu = true;
                                                                }
                                                                if (meghalt()) {
                                                                    osszes = ellenoriz();


                                                                    if (vege() == 1 || vege() == 0) {
                                                                        o = osszes.length;
                                                                        vege=true;
                                                                        break;
                                                                    }

                                                                }
                                                                if (obetu){
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (!varazsolt) {
                                                        System.err.println("Nincs ilyen egység, vagy saját egységet próbáltál megtámadni!");
                                                        obetu = true;
                                                    }
                                                }
                                                else {
                                                    System.err.println("Nem rendelkezel ezzel a varázslattal! Ugyanaz az egységed következik.");
                                                    obetu=true;
                                                }
                                                if (obetu){
                                                    break;
                                                }
                                            } else if (nev.equals("tuzlabda")) {
                                                if (Hos.sajat.isTuzlabda()) {
                                                    if (Hos.sajat.getTudas() - 9 >= 0) {
                                                        Hos.sajat.setTudas(Hos.sajat.getTudas() - 9);
                                                        System.out.println("Hova szeretnéd varázsolni?");
                                                        int oszlop = 100;
                                                        int sor = 100;
                                                        varazsolt = true;

                                                        String asd = "";

                                                        System.out.println("Elsőnek az oszlop számát add meg: ((0-11))");
                                                        while (!(oszlop <= 11 && oszlop >= 0)) {
                                                            asd = scanner.nextLine();
                                                            try {
                                                                oszlop = Integer.parseInt(asd);
                                                            } catch (Exception e) {
                                                                System.err.println("Baj van. Rossz az input....");
                                                            }
                                                            if (!(oszlop <= 11 && oszlop >= 0)) {
                                                                System.err.println("Nem jó az input tesómsz! Add meg újra. (0-11)");
                                                            }
                                                        }
                                                        System.out.println("Most a sor számát add meg: ((0-tól 9-ig))");
                                                        while (!(sor <= 9 && sor >= 0)) {
                                                            asd = scanner.nextLine();
                                                            try {
                                                                sor = Integer.parseInt(asd);
                                                            } catch (Exception e) {
                                                                System.err.println("Baj van. Rossz az input....");
                                                            }
                                                            if (!(sor <= 9 && sor >= 0)) {

                                                                System.err.println("Nem jó az input tesómsz! Add meg újra. (0-tól 9-ig.)");
                                                            }
                                                        }
                                                        for (int l = sor - 1; l < sor + 2; l++) {
                                                            for (int m = oszlop - 1; m < oszlop + 2; m++) {
                                                                if ((m < 12 && m >= 0) && (l < 10 && l >= 0) && mezok[m][l] != null) {
                                                                    System.out.println("Sebzést okoztál " + mezok[m][l].getNeve() + " egységnek, " + Hos.sajat.getVarazsero() * 20 + "értékben.");
                                                                    mezok[m][l].setEletero(mezok[m][l].getEletero() - (Hos.sajat.getVarazsero() * 20));
                                                                    obetu = true;
                                                                    hos = true;
                                                                    if (meghalt()) {
                                                                        osszes = ellenoriz();


                                                                        if (vege() == 1 || vege() == 0) {
                                                                            o = osszes.length;
                                                                            vege=true;
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }

                                                    } else {
                                                        System.err.println("Nincs elég manád a varázslásra! Ugyanaz az egységed következik.");

                                                        obetu = true;
                                                    }
                                                }
                                                else {
                                                    System.err.println("Nem rendelkezel ezzel a varázslattal! Ugyanaz az egységed következik.");
                                                    obetu=true;
                                                }

                                                if (obetu){
                                                    break;
                                                }

                                            }
                                            else if (nev.equals("feltamasztas")) {
                                                    feleleszt(o);
                                                    obetu=true;
                                                hos = true;
                                                if (obetu){
                                                    break;
                                                }
                                            }
                                            else if (nev.equals("lassitas")) {

                                                boolean lassitva = false;
                                                String gyogy = null;

                                                while (true) {
                                                    System.out.println("Kit szeretnél lassítani? pl: (ET)");
                                                    gyogy = scanner.nextLine();
                                                    if (Objects.equals(gyogy, "ET") || Objects.equals(gyogy, "EG") || Objects.equals(gyogy, "EF") || Objects.equals(gyogy, "EI") || Objects.equals(gyogy, "EC")) {

                                                        break;
                                                    } else {
                                                        System.out.println("Nem jó érték, vagy nem az ellenfél egysége.");
                                                    }
                                                }
                                                for (int q = 0; q< 10; q++) {
                                                    for (int w = 0; w < 12; w++) {
                                                        if (o < osszes.length && mezok[w][q] != null && mezok[w][q].getNeve().equals(gyogy)) {
                                                            lassitva = true;

                                                            Hos.sajat.setTudas(Hos.sajat.getTudas() - 8);
                                                            mezok[w][q].setSebesseg(mezok[w][q].getSebesseg() - 1);

                                                            System.out.println(mezok[w][q].getNeve() + " egység lassítva lett, 1 értékkel. " + Hos.sajat.getTudas() + " manád maradt.");
                                                            hos = true;
                                                            obetu=true;
                                                        }

                                                    }
                                                }
                                                if (!lassitva) {
                                                    System.out.println("Ezt az egységet nem tudod lassítani.");
                                                }
                                                obetu=true;

                                                if (obetu){
                                                    break;
                                                }
                                            }




                                            else if (nev.equals("gyorsitas")){
                                                boolean gyorsitas=false;
                                                String gyogy = null;
                                                System.out.println("Kit szeretnél gyorsítani? pl:(ST)");
                                                while (true) {
                                                    gyogy = scanner.nextLine();
                                                    if (Objects.equals(gyogy, "ST") || Objects.equals(gyogy, "SG") || Objects.equals(gyogy, "SF") || Objects.equals(gyogy, "SI") || Objects.equals(gyogy, "SC")) {

                                                        break;
                                                    } else {
                                                        System.out.println("Nem jó érték, vagy nem a saját egységed.");
                                                    }
                                                }
                                                for (int w = 0; w < 10; w++) {
                                                    for (int q = 0; q < 12; q++) {
                                                        if (o < osszes.length && mezok[q][w] != null && mezok[q][w].getNeve().equals(gyogy)) {
                                                            gyorsitas = true;
                                                            Hos.sajat.setTudas(Hos.sajat.getTudas() - 8);
                                                            mezok[q][w].setSebesseg(mezok[q][w].getSebesseg() + 1);
                                                            System.out.println(mezok[q][w].getNeve() + " egység gyorsítva, 1 értékkel. " + Hos.sajat.getTudas() + " manád maradt.");
                                                            hos = true;
                                                        }
                                                    }
                                                }
                                                if (!gyorsitas) {
                                                    System.out.println("Ezt az egységet nem tudod gyorsítani.");

                                                }

                                                obetu=true;
                                                if (obetu){
                                                    break;
                                                }
                                            }
                                            else {
                                                System.err.println("Érvénytelen input! Ugyanaz az egységed következik!");
                                                obetu = true;
                                            }

                                        } else {
                                            System.err.println("Érvénytelen input.");
                                            obetu = true;
                                        }
                                    } else {
                                        System.err.println("A hősöd lépett már ebben a körben!! Ugyanaz az egységed jön újra.");
                                        obetu = true;
                                    }
                                }
                                else if (nev.equals("allas")) {
                                    tamadoero();
                                    System.out.println("-----------------------------------------------------");
                                    System.out.println("Jelenleg így állnak az egységek:\n");

                                    System.out.println("Saját egységek:");

                                    for (int l = 0; l < 10; l++) {
                                        for (int m = 0; m < 12; m++) {
                                            if (mezok[m][l]!=null&&mezok[m][l].getNeve().startsWith("S")) {
                                                System.out.println("        "+mezok[m][l].getNeve() + ":: életerő: " + mezok[m][l].getEletero() + ". Támadóerő: " + mezok[m][l].getTamadoereje());

                                            }

                                        }
                                    }
                                    System.out.println("Ellenséges egységek:");
                                    for (int l = 0; l < 10; l++) {
                                        for (int m = 0; m < 12; m++) {
                                            if (mezok[m][l]!=null&&mezok[m][l].getNeve().startsWith("E")) {

                                                System.out.println("        "+mezok[m][l].getNeve() + ":: életerő: " + mezok[m][l].getEletero() + ". Támadóerő: " + mezok[m][l].getTamadoereje());

                                            }
                                        }
                                    }
                                    allas=true;
                                    obetu = true;
                                }
                                else {
                                    System.err.println("Érvénytelen input!");
                                    obetu = true;
                                }
                                if (allas){
                                    break;
                                }
                            }
                            //ELLENFÉL LÉPÉSEI, ÚJRAÍRNI
                            else if (mezok[j][i] != null &&!allas&& osszes[o].getNeve().equals(mezok[j][i].getNeve()) && mezok[j][i].getNeve().startsWith("E")&&!obetu) {
                                //bajos

                                    if (!elleenfelHose){
                                        for (int l = 0; l < 10; l++) {
                                            for (int m = 0; m < 12; m++) {
                                                if (!allas&&mezok[m][l]!=null&&mezok[m][l].getNeve().startsWith("S")){
                                                    if (villamSebzes()<=tuzlabdaSebzes()&&Ellenfel.ellenfel.getTudas()-9>=0&&Ellenfel.ellenfel.isTuzlabda()&&!elleenfelHose){
                                                        System.out.println("Az ellenfél hőse tűzlabda képességet használt. A középpontja: "+m+". oszlop "+l+". sor.");
                                                        int sor= l;
                                                        int oszlop=m;
                                                        for (int t = sor - 1; t < sor + 2; t++) {
                                                            for (int z = oszlop - 1; z < oszlop + 2; z++) {
                                                                if ((z < 12 && z >= 0) && (t < 10 && t >= 0) && mezok[z][t] != null) {
                                                                    System.out.println("A varázslat sebzést okozott " + mezok[z][t].getNeve() + " egységnek, " + Hos.ellenfel.getVarazsero() * 20 + " értékben.");
                                                                    mezok[z][t].setEletero(mezok[z][t].getEletero() - (Hos.ellenfel.getVarazsero() * 20));
                                                                    if (meghalt()) {
                                                                        osszes = ellenoriz();


                                                                        if (vege() == 1 || vege() == 0) {
                                                                            o = osszes.length;
                                                                            vege=true;
                                                                            break;
                                                                        }
                                                                    }
                                                                    elleenfelHose=true;
                                                                    break;
                                                                }
                                                                if(elleenfelHose){
                                                                    break;
                                                                }

                                                            }
                                                            if (elleenfelHose){
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    else if (!elleenfelHose&&Ellenfel.ellenfel.getTudas()-5>0&&Ellenfel.ellenfel.getVarazsero()*20<Hos.ellenfel.getTamadas()*10){
                                                        mezok[m][l].setEletero(mezok[m][l].getEletero()-Hos.ellenfel.getTamadas()*10);
                                                        System.out.println("Az ellenfél hőse megtámadta "+mezok[m][l].getNeve()+" egységedet, és "+Hos.ellenfel.getTamadas()*10+" sebzést okozott.");
                                                        elleenfelHose=true;
                                                        if (meghalt()) {
                                                            osszes = ellenoriz();


                                                            if (vege() == 1 || vege() == 0) {
                                                                o = osszes.length;
                                                                vege=true;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    if (elleenfelHose){
                                                        break;
                                                    }
                                                    else if (Ellenfel.ellenfel.getTudas()-5>=0&&Ellenfel.ellenfel.isVillamcsapas()&&!elleenfelHose)
                                                    {
                                                        System.out.println("Az ellenfél hőse villámcsapás képességet használt "+ mezok[m][l].getNeve() +" egységedre."+"("+Ellenfel.ellenfel.getVarazsero()*20+" sebzés)");
                                                        mezok[m][l].setEletero(mezok[m][l].getEletero()-(Ellenfel.ellenfel.getVarazsero()*20));
                                                        elleenfelHose=true;
                                                        if (meghalt()) {
                                                            osszes = ellenoriz();


                                                            if (vege() == 1 || vege() == 0) {
                                                                o = osszes.length;
                                                                vege=true;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }

                                                }
                                            }
                                        }

                                    }



                                    //j - 2 > 0 && mezok[j - 2][i] == null
                                if(mezok[j][i].getNeve().equals("EI")&&!allas){
                                    boolean tamadott=false;
                                    for (int n = 0; n < 10; n++) {
                                        for (int p = 0; p < 12; p++) {
                                            if (mezok[p][n]!=null&&mezok[p][n].getNeve().startsWith("S")){
                                                tamadott=true;

                                                if (criticalEnemy()) {
                                                    System.out.println("Az ellenfél íjásza kritikus csapást mért az " + mezok[p][n].getNeve() + " egységedre, " + (((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100-Hos.sajat.getVedekezes() * 5)/100))*2 + " sebzést okozott.");
                                                    mezok[p][n].setEletero(mezok[p][n].getEletero() - (((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100-Hos.sajat.getVedekezes() * 5)/100))*2);
                                                }
                                                else {
                                                    mezok[p][n].setEletero(mezok[p][n].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100));
                                                    System.out.println("Az ellenfél íjásza távolsági támadást hajtott végre, " + mezok[p][n].getNeve() + " egységen, " + ((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100) + " értékben.");
                                                }
                                                if (meghalt()) {
                                                    osszes = ellenoriz();


                                                    if (vege() == 1 || vege() == 0) {
                                                        o = osszes.length;
                                                        vege=true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (tamadott){
                                                break;
                                            }
                                        }
                                        if (tamadott){
                                            break;
                                        }
                                    }
                                break;
                                }
                                Egysegek[] tamadhato = new Egysegek[hossza2(o)];
                                if (tamadhato.length>0) {

                                    for (int l = 0; l < 10; l++) {
                                        for (int m = 0; m < 12; m++) {
                                            if (tamadhato.length > 0) {

                                                if (!tamadottEllenfel && !allas && o < osszes.length && ellenfelTamad(o).length > 0 && mezok[m][l] != null && mezok[m][l].getNeve().equals(ellenfelTamad(o)[0].getNeve())) {
                                                    if (mezok[m][l].getEletero() > 0) {
                                                        if (criticalEnemy()) {
                                                            System.out.println(mezok[j][i].getNeve() + " kritikus csapást mért az " + mezok[m][l].getNeve() + " egységedre, " + (((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100)) * 2 + " sebzést okozott.");
                                                            mezok[m][l].setEletero(mezok[m][l].getEletero() - (((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100)) * 2);
                                                            tamadottEllenfel = true;
                                                        } else {
                                                            mezok[m][l].setEletero(mezok[m][l].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100));
                                                            tamadottEllenfel = true;
                                                            System.out.println("Megtámadott az ellenfél " + mezok[j][i].getNeve() + " egysége. " + ((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100) + " sebzést okozott " + mezok[m][l].getNeve() + " egységedre, így " + mezok[m][l].getEletero() + " életereje maradt.");
                                                            if (mezok[j][i].getNeve().equals("EC") && mezok[m][l] != null) {
                                                                mezok[m][l].setEletero(mezok[m][l].getEletero() - ((mezok[j][i].getTamadoereje() * (1 + Hos.ellenfel.getTamadas() / 10)) * (100 - Hos.sajat.getVedekezes() * 5) / 100));
                                                                System.out.println("Az ellenfél Cerberus egysége kétszer tud támadni! Ismét megtámadta az " + mezok[m][l].getNeve() + " egységed," + ((mezok[j][i].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100) + " sebzést okozva.");
                                                            }


                                                        }
                                                        if (meghalt()) {
                                                            osszes = ellenoriz();


                                                            if (vege() == 1 || vege() == 0) {
                                                                o = osszes.length;
                                                                vege = true;
                                                                break;
                                                            }
                                                        }
                                                        if (mezok[m][l] != null && (!mezok[m][l].isVissza() || mezok[m][l].getNeve().equals("SG"))) {
                                                            System.out.println("Az egységed visszatámadott " + (((mezok[m][l].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100)) / 2 + " értékkel.");
                                                            mezok[m][l].setVissza(true);
                                                            mezok[j][i].setEletero(mezok[j][i].getEletero() - (((mezok[m][l].getTamadoereje() * (1 + Hos.sajat.getTamadas() / 10)) * (100 - Hos.ellenfel.getVedekezes() * 5) / 100)) / 2);

                                                        }


                                                        ellenfel = true;


                                                        if (meghalt()) {
                                                            osszes = ellenoriz();


                                                            if (vege() == 1 || vege() == 0) {
                                                                o = osszes.length;
                                                                vege = true;
                                                                break;
                                                            }
                                                        }
                                                        break;

                                                    }
                                                    if (meghalt()) {
                                                        osszes = ellenoriz();


                                                        if (vege() == 1 || vege() == 0 && !vege) {
                                                            o = osszes.length;
                                                            vege = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                                else if (!vege&&!ellenfel&&enemyOkos(o)) {



                                } else if (mezok[j][i].getNeve().startsWith("E") && (j - 2 >= 0 && i + 1 < 10) && !obetu && !vege && mezok[j - 2][i + 1] == null && !ellenfel) {
                                    mezok[j - 2][i + 1] = mezok[j][i];
                                    mezok[j][i] = null;
                                    int oszlop = j - 2;
                                    int sor = i + 1;
                                    System.out.println("Az ellenfél " + mezok[j - 2][i + 1].getNeve() + " egysége lépett. " + oszlop + ". oszlop " + i + ". sor.");
                                    ellenfel = true;
                                    break;
                                } else if (mezok[j][i].getNeve().startsWith("E") && (j - 2 >= 0) && !obetu && !vege && mezok[j - 2][i] == null && !ellenfel) {
                                    mezok[j - 2][i] = mezok[j][i];
                                    mezok[j][i] = null;
                                    int oszlop = j - 2;
                                    int sor = i;
                                    System.out.println("Az ellenfél " + mezok[j - 2][i].getNeve() + " egysége lépett. " + oszlop + ". oszlop " + i + ". sor.");
                                    ellenfel = true;
                                    break;
                                } else if (mezok[j][i].getNeve().startsWith("E") && (j + 3 < 12) && !obetu && !vege && mezok[j + 3][i] == null && !ellenfel) {
                                    mezok[j + 2][i] = mezok[j][i];
                                    mezok[j][i] = null;
                                    int oszlop = j + 2;
                                    int sor = i;
                                    System.out.println("Az ellenfél " + mezok[j + 2][i].getNeve() + " egysége lépett. " + oszlop + ". oszlop " + i + ". sor.");
                                    ellenfel = true;
                                    break;
                                } else {
                                    System.out.println("Az ellenfél " + mezok[j][i].getNeve() + " egysége várakozott.");
                                }

                                k++;

                            }
                            if (ellenfel) {
                                ellenfel=false;
                                break;
                            }
                            if (obetu||allas){
                                obetu2=o;
                            }
                            if (vege){
                                break;
                            }
                        }
                    }
                    }

                if (vege){
                    break;
                }
                }
            if (!obetu) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (!vege && mezok[j][i] != null && (mezok[j][i].getNeve().equals("ST") || mezok[j][i].getNeve().equals("ET"))) {
                            mezok[j][i].setEletero(mezok[j][i].getEletero() + 10);
                            System.out.println(mezok[j][i].getNeve() + " egység hívott még pajtásokat! Életereje nőtt. Jelenlegi: " + mezok[j][i].getEletero());
                            mennyi();
                        }
                    }
                }
            }
            for (int i = 0; i < osszes.length; i++) {
                osszes[i].setVissza(false);
            }
            if (vege){
                break;
            }
            osszes=ellenoriz();

            hos=false;
            ijasz=false;
            kor++;
            allas=false;
            }


            }


    public static void vegeVan() {


        if (vege() == 1) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Az ellenfél összes egysége meghalt. Gratulálok, nyertél!");
            System.out.println("--------------------------------------------------------");
        }
        if (vege()==0){
            System.out.println("-----------------------------------------------------");
            System.out.println("Az összes egységed meghalt. Sajnos vesztettél!");
            System.out.println("-----------------------------------------------------");

        }
        if (vege()==2){
            System.out.println("-----------------------------------------------------");
            System.out.println("Mindkét fél egységei meghaltak. Döntetlen! :O");
            System.out.println("-----------------------------------------------------");
        }
    }
    
}





