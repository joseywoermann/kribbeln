public class Spieler {

    private int     punktestand = 0;
    private int     platzierung = 0;
    private int     augenzahl   = 0;
    private String  aufgabenstellung;
    private String  ergebnis;           // Gewonnen / Verloren

    private Spieler gegner;
    private Aufgabe aufgabe;
    private Wuerfel wuerfel;


    /**
     * Constructor for objects of class Spieler
     */
    public Spieler(/*Aufgabe pAufgabe, Wuerfel pWuerfel*/) {
        //this.aufgabe = pAufgabe;
        //this.wuerfel = pWuerfel;

        this.aufgabe = new Aufgabe();
        this.wuerfel = new Wuerfel();
        tutorial();
    }

    /**
     * Gegner kann nicht im Konstruktor festgelegt werden, deshalb hier.
     * @param pGegner
     */
    public void gegnerFestlegen(Spieler pGegner) {
        this.gegner = pGegner;
    }

    /**
     * Aufgabe "aussuchen" und starten (Start-Methode)
     */
    public void aufgabeStarten() {
        // Würfel vom letzten Mal zurücksetzen
        wuerfel.reset();

        this.aufgabenstellung = aufgabe.zufallsAufgabeAussuchen();
        System.out.println("Deine Aufgabe: " + this.aufgabenstellung + " und versuche dabei, eine möglichst hohe Auganzahl zu erreichen.");
        leereZeile(2);
        // Wait for 1 second
        wait(1);
        this.aufgabeDurchfuehren();
    }

    /**
     * Hauptmethode für Spieler
     */
    public void aufgabeDurchfuehren() {

        // Augenzahlen
        this.augenzahl = wuerfel.augenZahlWuerfeln();
        System.out.println("Augenzahl: " + this.augenzahl);

        // Farben & deren Anzahl
        wuerfel.farbenWuerfeln();
        System.out.println("Anzahl der " + aufgabe.getBenoetigteFarbe() + "en Würfe: " + this.getFarbWuerfe());

        // Spieler fragen, ob er nochmal würfeln will, oder den Zug beenden will
        wait(1);
        System.out.println("Möchtest du nochmal würfel, um dein Ergebnis zu verbessern? Dies kann dein Ergebnis aber auch verschlechtern, wenn du dann deine Aufgabe nichtmehr erfüllen kannst.\nWenn du nochmal würfeln willst, führe die Methode \"nochmalWuerfeln()\" aus, wenn nicht, führe \"zugBeenden()\" aus");
        leereZeile(2);
    }

    /**
     * Wenn aufgerufen, soll nochmal gewürfelt werden
     */
    public void nochmalWuerfeln() {
        // Augenzahlen
        int augenzahlTMP = wuerfel.augenZahlWuerfeln();
        this.augenzahl = this.augenzahl + augenzahlTMP;

        // Farben & deren Anzahl
        wuerfel.farbenWuerfeln();
        wait(1);

        // ausgeben, was gerade gewürfelt wurde
        System.out.println("Augenzahl: " + augenzahlTMP);
        System.out.println("Anzahl der " + aufgabe.getBenoetigteFarbe() + "en Würfe: " + this.getFarbWuerfe());
        leereZeile(2);
    }

    // Auswerten
    public void zugBeenden() {
        // Ergebnisse zur Kopntrolle an Aufgabe weitergeben
        this.ergebnisseWeiterleiten(this.augenzahl);
    }

    /**
     * Ergebnisse an die Aufgabe für die Auswertung weiterleiten
     * @param pAugenzahl
     */
    public void ergebnisseWeiterleiten(int pAugenzahl) {
        // Anzahl der jeweils gewürfelten Farben "nachschauen""
        int blau      = wuerfel.getBlau();
        int gelb      = wuerfel.getGelb();
        int gruen     = wuerfel.getGruen();
        int rot       = wuerfel.getRot();
        int weiss     = wuerfel.getWeiss();
        int schwarz   = wuerfel.getSchwarz();

        // Auswerten lassen
        aufgabe.aufgabeAuswerten(pAugenzahl, blau, gelb, gruen, rot, weiss, schwarz);

        // TODO: Hier muss noch ausgewertet werden, wer gewonnen hat
    }

    /**
     * Prüfen, welcher Spieler mehr Punkte hat, und die Platzierungen anpassen
     */
    public void platzierungBerechnen() {
        if (gegner.getPunktestand() < this.punktestand) {
            this.setPlatzierung(1);
            gegner.setPlatzierung(2);

        } else if (gegner.getPunktestand() == this.punktestand) {
            this.setPlatzierung(1); // Beide haben gleich viele Punkte, unentscheiden
            gegner.setPlatzierung(1);

        } else {
            this.setPlatzierung(2); // Dieser Spieler hat weniger Punkte, hat verloren
            gegner.setPlatzierung(1);
        }
    }

    /**
     * Den Punktestand dieses Spielers ausgeben
     * @return Punktestand
     */
    public int getPunktestand() {
        return this.punktestand;
    }

    /**
     * Die Platzierung für eine Spieler festlegen.
     * @param Platzierung
     */
    public void setPlatzierung(int pPlatzierung) {
        if (pPlatzierung == 1 || pPlatzierung == 2) { // Input überprüfen, da es nur 2 Spieler gibt, kann es nur 1 oder 2 sein
            this.platzierung = pPlatzierung;
        }
    }

    /**
     * Eine Anleitung (WIP)
     */
    public void tutorial() {
        System.out.println("Anleitung");
        System.out.println("1. Bitte führe gegnerFestlegen() aus, um einen Gegner festzulegen.");
        System.out.println("2. Führe aufgabeStarten() aus, um deine Aufgabe zu starten.");
        leereZeile(2);
    }

    /**
     * Gibt die Anzahl der aktuell benötigten Würfe aus
     */
    public int getFarbWuerfe() {
        int farbenGeworfen = 0;

        switch (aufgabe.getBenoetigteFarbe()) {
            case "blau":
                farbenGeworfen = wuerfel.getBlau();
                break;
            case "gelb":
                farbenGeworfen = wuerfel.getGelb();
                break;
            case "grün":
                farbenGeworfen = wuerfel.getGruen();
                break;
            case "rot":
                farbenGeworfen = wuerfel.getRot();
                break;
            case "weiß":
                farbenGeworfen = wuerfel.getWeiss();
                break;
            case "schwarz":
                farbenGeworfen = wuerfel.getSchwarz();
                break;
            default:
                break;
        }
        return farbenGeworfen;
    }

    /**
     * Macht eine leere Zeile
     * @param pSeconds Wie viele leere Zeilen willst du?
     */
    public void leereZeile(int pAnzahl) {
        for (int i = 0; i < pAnzahl; i++) {
            System.out.println("");
        }
    }

    /**
     * Pausiert das Programm
     * @param pSeconds Wie viele Sekunden lang soll pausiert werden?
     */
    public void wait(int pSeconds) {
        try {
            Thread.sleep(pSeconds * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Würefel und Aufgabe sichtbar machen
    public Wuerfel getWuerfel() {
        return this.wuerfel;
    }
    public Aufgabe getAufgabe() {
        return this.aufgabe;
    }
}
