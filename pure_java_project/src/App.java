public class App {
    public static void main(String[] args) throws Exception {
        CellPhone phone = new CellPhone();
        Tune normalTune = new Tune();
        Tune obnoxiousTune = new ObnoxiousTune();

        System.out.print("Normal tune: ");
        phone.ring(normalTune); // In ra: Tune.play()

        System.out.print("Obnoxious tune: ");
        phone.ring(obnoxiousTune); // In ra: ObnoxiousTune.play()
    }
}
