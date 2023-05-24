public class Foldmuves extends Egysegek {
    private int mennyi;

    public int getMennyi() {
        return mennyi;
    }

    public void setMennyi(int mennyi) {
        this.mennyi = mennyi;
    }

    public Foldmuves(String nev, int tamadoereje, int eletero, int sebesseg, int kezdemenyezes, int ar, int mennyi,int sor,int oszlop) {
        super("Földműves", 0, 0, 4, 8, 2, 0,0,0, false,0 );
    }
}
