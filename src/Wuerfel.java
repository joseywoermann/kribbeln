public class Wuerfel {

    private String[] farben = {
        "blau",   // 0
        "gelb",   // 1
        "grün",   // 2
        "rot",    // 3
        "weiß",   // 4
        "schwarz" // 5
    };

    private int zahl        = 0;

    // Anzahl der geworfenen Zahlen
    private int blaus       = 0;
    private int gelbs       = 0;
    private int gruens      = 0;
    private int rots        = 0;
    private int weisss      = 0;
    private int schwarzs    = 0;


    /**
     * Constructor for objects of class Wuerfel
     */
    public Wuerfel() {
        // Nichts
    }

    /**
     * Setzt alle Werte des Würfels zurück
     */
    public void reset() {
        this.zahl       = 0;
        this.blaus      = 0;
        this.gelbs      = 0;
        this.gruens     = 0;
        this.rots       = 0;
        this.weisss     = 0;
        this.schwarzs   = 0;
    }

    /**
     * Würfel 9 mal würfeln
     * @param pZahl
     * @return int
     */
    public int augenZahlWuerfeln() {
        for (int i = 0; i < 9; i++) {
            this.zahl = this.zahl + this.zufallsAugenzahlGenerieren();
        }
        return this.zahl;
    }


    /**
     * Hauptmethode für Farben; Daten in Integern speichern
     * 9 Farben würfeln & zurodnen
     * @param pZahl
     */
    public void farbenWuerfeln() {
        for (int i = 0; i < 9; i++) { // 9mal würfeln
            String farbe = this.zufallsFarbeGenerieren();

            switch (farbe) {
                case "blau":
                    this.blaus++;
                    break;
                case "gelb":
                    this.gelbs++;
                    break;
                case "grün":
                    this.gruens++;
                    break;
                case "rot":
                    this.rots++;
                    break;
                case "weiß":
                    this.weisss++;
                    break;
                case "schwarz":
                    this.schwarzs++;
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * Zufällige Farbe generieren
     * @return String
     */
    public String zufallsFarbeGenerieren() {
        int zahl = zufallsZahl(0, 5);
        String farbe = farben[zahl];
        return farbe;
    }

    /**
     * Zufällige Zahl generieren
     * @return
     */
    public int zufallsAugenzahlGenerieren() {
        int zahl = zufallsZahl(1, 6);
        return zahl;
    }

    /**
     * Eine zufällige ganze Zahl zwischen 2 Zahlen generieren.
     * @param pUnteresLimit Die niedrigste möglich Zahl.
     * @param pOberesLimit Die höchste möglich Zahl.
     */
    public int zufallsZahl(int pUnteresLimit, int pOberesLimit) {
        int zahl = (int)Math.round(Math.random() * (pOberesLimit - pUnteresLimit));
        return zahl;
    }


    // get-Methoden

    /**
     * Die Anzahl der blauen Seiten ausgeben
     * @return
     */
    public int getBlau() {
        return this.blaus;
    }

    /**
     * Die Anzahl der gelben Seiten ausgeben
     * @return
     */
    public int getGelb() {
        return this.gelbs;
    }

    /**
     * Die Anzahl der grünen Seiten ausgeben
     * @return
     */
    public int getGruen() {
        return this.gruens;
    }

    /**
     * Die Anzahl der roten Seiten ausgeben
     * @return
     */
    public int getRot() {
        return this.rots;
    }

    /**
     * Die Anzahl der weißen Seiten ausgeben
     * @return
     */
    public int getWeiss() {
        return this.weisss;
    }

    /**
     * Die Anzahl der schwarzen Seiten ausgeben
     * @return
     */
    public int getSchwarz() {
        return this.schwarzs;
    }

}
