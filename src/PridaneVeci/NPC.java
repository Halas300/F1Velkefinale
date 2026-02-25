package PridaneVeci;

public class NPC {
    private String id;
    private String jmeno;
    private String role;
    private String domovskaLokace;
    private String poznamky;

    public String getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getRole() {
        return role;
    }

    public String getDomovskaLokace() {
        return domovskaLokace;
    }

    public String getPoznamky() {
        return poznamky;
    }

    public NPC(String id, String jmeno, String role, String domovskaLokace, String poznamky) {
        this.id = id;
        this.jmeno = jmeno;
        this.role = role;
        this.domovskaLokace = domovskaLokace;
        this.poznamky = poznamky;
    }
}
