public class App {
    public static void main(String[] args) throws Exception {
    	BangunRuang a = new BangunRuang("nama");
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");
        Balok balok = new Balok("balok");
        
        a.setName("Bangun Ruang");

        balok.inputNilai();
        balok.luasPermukaan();
        balok.volume();
       
        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}
