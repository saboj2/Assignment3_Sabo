package jeffreysabocsc415.csc415_sabo_individualproject;

/**
 * Created by jman5 on 11/10/2017.
 */

public class Bathroom extends Vertex {

    //Bathroom variables
    private String floor;
    private Review ratings[];

    //Bathroom methods
    private String get_floor()
    {
        return this.floor;
    }

    private void set_floor(String floor)
    {
        this.floor = floor;
        return;
    }

    private void leave_review()
    {

    }

    private Review[] get_ratings()
    {
        return this.ratings;
    }

    private void set_ratings(Review name)
    {
        return;
    }
}
