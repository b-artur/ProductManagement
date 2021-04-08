/*-----------------------------------------------------------------------------
 - This code is created on educational purposes and for sure is strongly      -
 - protected and something else about something else                          -
 - Copyright (c) Artur Bakhmanov 2021.                                        -
 -----------------------------------------------------------------------------*/

package labs.pm.data;

public class Review {
    private Rating rating;
    private String comments;

    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public Rating getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
