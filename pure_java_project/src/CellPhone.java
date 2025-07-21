class CellPhone {
    CellPhone() { /*...*/ }
    public void ring(Tune t) {
        t.play();
    }
}
class Tune {
    Tune() { /*...*/ }

    public void play() {
        System.out.println("Tune.play()");
    }
}
class ObnoxiousTune extends Tune {
    ObnoxiousTune() {
        super();
    }
    public void play() {
        System.out.println("ObnoxiousTune.play()");
    }
}
