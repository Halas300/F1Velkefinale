package Prikazy;
import HlavniTridy.Hra;
import PridaneVeci.NPC;
import PridaneVeci.Veci;

public class PrikazProzkoumej implements Prikaz {
    @Override
    public String getNazev() {
        return "prozkoumej";
    }
    @Override
    public void proved(String[] parametry) {
        System.out.println("Místnost: " + Hra.aktualniLokace.getNazev());
        System.out.println("Popis:    " + Hra.aktualniLokace.getPopis());

        if (Hra.aktualniLokace.veciVMistnosti.isEmpty()) {
            System.out.println("Předměty: Nejsou tady");
        } else {
            System.out.print("Předměty: ");
            for (String idVeci : Hra.aktualniLokace.veciVMistnosti) {
                Veci v = Hra.data.NajdiVec(idVeci);
                if (v != null) {
                    System.out.print(v.getNazev());
                }
                System.out.println();
            }
        }

        System.out.print("Postavy:  ");
        boolean nekdoTuJe = false;
        for (NPC postava : Hra.data.NPC) {
            if (postava.getDomovskaLokace().equals(Hra.aktualniLokace.getId())) {
                System.out.print(postava.getJmeno() + " (" + postava.getRole() + "), ");
                nekdoTuJe = true;
            }
        }
        if (!nekdoTuJe) {
            System.out.print("Nikdo tu není.");
        }
    }
}
