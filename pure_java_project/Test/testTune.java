public class testTune {
    public static void runTest() {
        CellPhone noiseMaker = new CellPhone();
        Tune t1 = new Tune();
        Tune t2 = new ObnoxiousTune();

        noiseMaker.ring(t1);
        noiseMaker.ring((Tune)t2);
    }
}
