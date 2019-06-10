package cz.speedygonzales.refactoringfowler.step001;

class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie,
                  int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double getCharge() {
        return movie.getCharge(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public Movie getMovie() {
        return movie;
    }
}
