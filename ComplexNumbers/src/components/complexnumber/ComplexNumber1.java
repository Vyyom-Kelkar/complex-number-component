package components.complexnumber;

/**
 * {@code ComplexNumber} represented as a a tuple {@code double, @code double}
 * with implementations of primary methods.
 */
public class ComplexNumber1 extends ComplexNumberSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of real part of {@code this}.
     */
    private double real;

    /**
     * Representation of imaginary part of {@code this}.
     */
    private double imaginary;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.real = 0;
        this.imaginary = 0;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public ComplexNumber1() {
        this.createNewRep();
    }

    /**
     * Constructor from ({@code double}, {@code double}).
     *
     * @param i
     *            {@code double} to initialize real part from
     * @param j
     *            {@code double} to initialize imaginary part from
     */
    public ComplexNumber1(double i, double j) {
        this.real = i;
        this.imaginary = j;
    }

    /**
     * Constructor from {@code ComplexNumber}.
     *
     * @param c
     *            {@code ComplexNumber} to initialize from
     */
    public ComplexNumber1(ComplexNumber c) {
        this.real = c.realPart();
        this.imaginary = c.imaginaryPart();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final ComplexNumber newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(ComplexNumber source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof ComplexNumber1 : ""
                + "Violation of: source is of dynamic type ComplexNumber1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        ComplexNumber1 localSource = (ComplexNumber1) source;
        this.real = localSource.real;
        this.imaginary = localSource.imaginary;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final double realPart() {
        return this.real;
    }

    @Override
    public final double imaginaryPart() {
        return this.imaginary;
    }

    @Override
    public final void setRealPart(double x) {
        this.real = x;
    }

    @Override
    public final void setImaginaryPart(double x) {
        this.imaginary = x;
    }

}
