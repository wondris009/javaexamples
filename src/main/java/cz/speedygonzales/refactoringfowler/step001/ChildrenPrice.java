package cz.speedygonzales.refactoringfowler.step001;

class ChildrenPrice extends Price {

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
