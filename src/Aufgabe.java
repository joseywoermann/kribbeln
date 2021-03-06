public class Aufgabe {

    private String[] aufgabe;

    /**
     * Eine Aufgabe ist ein Array, in dem die Position eines Elements
     * bestimmt, wie es interpretiert werden soll
     * <welche farbe> <anzahl> <gleich / unterschiedlich> <Aufgabenstellung als Satz>
     */
    private String[][] aufgaben = {
        {
            "rot",                  // Farbe
            "eins",                 // Anzahl
            "gleich",               // Brauchen wir das überhaupt? (Eigentlich nur, wenn wir "Bereiche" implementieren würden, also zum Beispiel "1 bis 3 mal rot")
            "Würfele einmal rot."   // Aufgabenstellung
        },
        {
            "blau",
            "drei",
            "gleich",
            "Würfele dreimal blau"
        },
        {
            "grün",
            "acht",
            "gleich",
            "Würfele achtmal grün"
        },
        {
            "schwarz",
            "0",
            "gleich",
            "Würfele kein schwarz"
        }/*,
        {   // prinzipiell möglich, aber komplizierter zu implementieren
            "egal",
            "zwei",
            "gleich",
            "Würfele mindestens zweimal die gleiche Farbe."
        }*/
    };

    /**
     * Constructor for objects of class Aufgabe
     */
    public Aufgabe() {
        // Nix
    }


    /**
     * Zufällige Aufgabe ausgeben
     */
    public String zufallsAufgabeAussuchen() {
        int zahl = (int)Math.round(Math.random() * (1 - 0));
        String aufgabenstellung = aufgaben[zahl][3];
        this.aufgabe = aufgaben[zahl];

        return aufgabenstellung;
    }

    /**
     * Auswerten, ob der Spieler die Aufgabe erfüllt hat
     * @param pAugenzahl int
     */
    public void aufgabeAuswerten(int pAugenzahl, int pBlau, int pGelb, int pGruen, int pRot, int pWeiss, int pSchwarz) {

        System.out.println("Ergebnis wird ausgewertet...");
        leereZeile(2);
        wait(1);

        int wuerfeDerBenoetigtenFarbe = 100000000; // Irgendeine sehr große Zahl, damit es einfacher ist herauszufinden, dass etwas schiefgelaufen ist.
        switch (getBenoetigteFarbe()) {
            case "blau":
                wuerfeDerBenoetigtenFarbe = pBlau;
                break;
            case "gelb":
                wuerfeDerBenoetigtenFarbe = pGelb;
                break;
            case "grün":
                wuerfeDerBenoetigtenFarbe = pGruen;
                break;
            case "rot":
                wuerfeDerBenoetigtenFarbe = pRot;
                break;
            case "weiß":
                wuerfeDerBenoetigtenFarbe = pWeiss;
                break;
            case "schwarz":
                wuerfeDerBenoetigtenFarbe = pSchwarz;
                break;
            default:
                break;
        }

        //System.out.println(zahlZuString(wuerfeDerBenoetigtenFarbe));

        if (wuerfeDerBenoetigtenFarbe == stringZuZahl(this.aufgabe[1])) {
            System.out.println("Du hast deine Aufgabe erfolgreich erfüllt.\nDu hattest " + wuerfeDerBenoetigtenFarbe + " " + getBenoetigteFarbe() + "e Felder.\nDie Augenzahl beträgt " + pAugenzahl + ".");
        } else {
            System.out.println("Du hast deine Aufgabe nicht erfüllt!\nDu hattest " + wuerfeDerBenoetigtenFarbe + " " + getBenoetigteFarbe() + "e Felder.\nDie Augenzahl beträgt " + pAugenzahl + ".");
        }
        leereZeile(2);
    }


    /**
     * Zahl zu String, da im Array nur Strings sind
     * @return String, weil Java statisch ist.
     */
    public String zahlZuString(int pZahl) {
        String zahlAlsText = null;
        switch (pZahl) {
            case 1:
                zahlAlsText = "eins";
                break;
            case 2:
                zahlAlsText = "zwei";
                break;
            case 3:
                zahlAlsText = "drei";
                break;
            case 4:
                zahlAlsText = "vier";
                break;
            case 5:
                zahlAlsText = "fünf";
                break;
            case 6:
                zahlAlsText = "sechs";
                break;
            default:
                break;
        }
        return zahlAlsText;
    }

    /**
     * String zu Zahl Konverter,
     * @return Zahl, weil Java statisch ist.
     */
    public int stringZuZahl(String pString) {
        int textAlsZahl = 100000000; // Irgendeine sehr große Zahl, damit es einfacher ist herauszufinden, dass etwas schiefgelaufen ist.
      switch (pString) {
        case "eins":
          textAlsZahl = 1;
          break;
        case "zwei":
          textAlsZahl = 2;
          break;
        case "drei":
          textAlsZahl = 3;
          break;
        case "vier":
          textAlsZahl = 4;
          break;
        case "fünf":
          textAlsZahl = 5;
          break;
        case "sechs":
          textAlsZahl = 6;
          break;
        default:
          break;
      }
      return textAlsZahl;
    }

    /**
     * Aktuell benötigte farbe ausgeben
     */
    public String getBenoetigteFarbe() {
        String farbe = this.aufgabe[0];
        return farbe;
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

    /**
     * Macht eine leere Zeile
     * @param pSeconds Wie viele leere Zeilen willst du?
     */
    public void leereZeile(int pAnzahl) {
        for (int i = 0; i < pAnzahl; i++) {
            System.out.println("");
        }
    }
}
