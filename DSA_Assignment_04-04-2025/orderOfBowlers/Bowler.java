package orderOfBowlers;

/** class Bowler, used to store the id and remaing balls of a bowler */
public class Bowler {

    private int id;
    private int remaningBowls;

    public Bowler(int id, int remaningBowls) {
        this.id = id;
        this.remaningBowls = remaningBowls;
    }

    public void setRemaningBowls(int remaningBowls) {
        this.remaningBowls = remaningBowls;
    }

    // Getters of Bowler class
    public int getId() {
        return id;
    }

    public int getRemaningBowls() {
        return remaningBowls;
    }

}
