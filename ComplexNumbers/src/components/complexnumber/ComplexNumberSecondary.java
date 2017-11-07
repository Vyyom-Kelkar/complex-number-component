package components.complexnumber;

/**
 * Layered implementations for the secondary methods of {@code ComplexNumber}.
 *
 * @author Vyyom Kelkar
 */
public abstract class ComplexNumberSecondary implements ComplexNumber {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber c = (ComplexNumber) obj;
        if (this.realPart() != c.realPart()) {
            return false;
        }
        if (this.imaginaryPart() != c.imaginaryPart()) {
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        long real = Double.doubleToLongBits(this.realPart());
        long imaginary = Double.doubleToLongBits(this.imaginaryPart());
        return ((int) ((real * 5) + (imaginary * 7)));
    }

    @Override
    public final String toString() {
        double real = this.realPart();
        double imaginary = this.imaginaryPart();
        return ("(" + Double.toString(real) + ", " + Double.toString(imaginary)
                + ")");
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void add(ComplexNumber x) {
        double real = this.realPart() + x.realPart();
        double imaginary = this.imaginaryPart() + x.imaginaryPart();
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void subtract(ComplexNumber x) {
        double real = this.realPart() - x.realPart();
        double imaginary = this.imaginaryPart() - x.imaginaryPart();
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void multiply(ComplexNumber x) {
        double real = ((this.realPart() * x.realPart())
                - (this.imaginaryPart() * x.imaginaryPart()));
        double imaginary = ((this.imaginaryPart() * x.imaginaryPart())
                + (this.realPart() * x.realPart()));
        this.setRealPart(real);
        this.setImaginaryPart(imaginary);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void divide(ComplexNumber x) {
        assert x.realPart() != 0.0
                && x.imaginaryPart() != 0.0 : "Violation of: x is not 0";

        ComplexNumber a = x.conjugate();
        this.multiply(a);
        a.multiply(a);
        this.setRealPart(this.realPart() / a.realPart());
        this.setImaginaryPart(this.imaginaryPart() / a.realPart());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public ComplexNumber conjugate() {
        ComplexNumber c = this.newInstance();
        c.setRealPart(this.realPart());
        c.setImaginaryPart((-1) * this.imaginaryPart());
        return c;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void copyFrom(ComplexNumber x) {
        this.setRealPart(x.realPart());
        this.setImaginaryPart(x.imaginaryPart());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void power(int p) {
        assert p >= 0 : "Violation of: p is greater than or equal to 0";

        ComplexNumber temp = this.newInstance();
        temp.copyFrom(this);

        if (p == 0) {
            this.setRealPart(1);
            this.setImaginaryPart(0);
        } else {
            if (p % 2 == 0) {
                this.power(p / 2);
                this.multiply(temp);
            } else {
                this.power(p - 1);
                temp.multiply(this);
            }
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double magnitude() {
        return (Math.sqrt((this.realPart() * this.realPart())
                + (this.imaginaryPart() * this.imaginaryPart())));
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public double angle() {
        return Math.atan2(this.realPart(), this.imaginaryPart());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toPolarForm() {
        return (Double.toString(this.magnitude()) + "(cos("
                + Double.toString(this.angle()) + ")+ i*sin("
                + Double.toString(this.angle()) + "))");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toRectangularForm() {
        return (Double.toString(this.realPart()) + "+ i("
                + Double.toString(this.imaginaryPart()) + ")");
    }

}
