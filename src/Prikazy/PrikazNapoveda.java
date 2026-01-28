package Prikazy;

public class PrikazNapoveda implements Prikaz {

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public void proved(String[] parametry) {
        System.out.println("--- NÁPOVĚDA ---");
        System.out.println("Tvým úkolem je připravit auto a porazit Maxe.");
        System.out.println("Příkazy, které můžeš použít:");
        System.out.println("- jdi [místnost]");
        System.out.println("- vezmi [věc]");
        System.out.println("- batoh (ukáže inventář)");
        System.out.println("- mluv [jméno]");
        System.out.println("- pouzij [věc]");
        System.out.println("- nastav [kridlo/pneu] [hodnota]");
        System.out.println("- konec");
        System.out.println("Při příkazu jdi stačí napsat první 3/4 písmena místnosti, kam chceš jít");
    }
}
