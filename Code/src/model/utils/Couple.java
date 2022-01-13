package model.utils;

/**
 * classe representant une paire d'integer
 */
public class Couple {
    /**
     * premier integer
     */
    public int first;
    /**
     * second integer
     */
    public int second;

    /**
     * constructeur par defaut (0,0)
     */
    public Couple() {
        this.first = 0;
        this.second = 0;
    }

    /**
     * constructeur prenant n'importe que des int
     *
     * @param first  premier integer
     * @param second second integer
     */
    public Couple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * constructeur prenant n'importe quel type numerique
     *
     * @param first  premier integer
     * @param second second integer
     */
    public Couple(Number first, Number second) {
        this.first = first.intValue();
        this.second = second.intValue();
    }

    /**
     * constructeur de copie
     *
     * @param couple couple a partir duquel faire la copie
     */
    public Couple(Couple couple) {
        first = couple.first;
        second = couple.second;
    }
}
