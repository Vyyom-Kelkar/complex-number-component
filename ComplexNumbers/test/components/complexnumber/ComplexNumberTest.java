package components.complexnumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit text fixture for {@code ComplexNumber}'s constructors and kernel
 * implementations.
 *
 * @author Vyyom Kelkar
 *
 */
public abstract class ComplexNumberTest {

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new complex number
     * @ensures constructorTest = (0,0)
     */
    protected abstract ComplexNumber constructorTest();

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            the {@code double} to set real part from
     * @param j
     *            the {@code double} to set imaginary part from
     * @return the new complex number
     * @ensures constructorTest = (0,0)
     */
    protected abstract ComplexNumber constructorTest(double i, double j);

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param c
     *            the {@code ComplexNumber} to initialize from
     * @return the new complex number
     * @ensures constructorTest = (c.real_part,c.imaginary_part)
     */
    protected abstract ComplexNumber constructorTest(ComplexNumber c);

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new complex number
     * @ensures constructorRef = (0,0)
     */
    protected abstract ComplexNumber constructorRef();

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            the {@code double} to set real part from
     * @param j
     *            the {@code double} to set imaginary part from
     * @return the new complex number
     * @ensures constructorRef = (0,0)
     */
    protected abstract ComplexNumber constructorRef(double i, double j);

    /**
     * Invokes the appropriate {@code ComplexNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param c
     *            the {@code ComplexNumber} to initialize from
     * @return the new complex number
     * @ensures constructorRef = (c.real_part,c.imaginary_part)
     */
    protected abstract ComplexNumber constructorRef(ComplexNumber c);

    /**
     * Creates and returns a {@code ComplexNumber} of the implementation under
     * test type with the given parts.
     *
     * @param real
     *            the {@code double} defining the real part of the
     *            {@code ComplexNumber}
     * @param imaginary
     *            the {@code double} defining the imaginary part of the
     *            {@code ComplexNumber}
     * @return the complete {@code ComplexNumber}
     * @ensures
     *
     *          <pre>
     * createFromArgsTest = (real, part)
     *          </pre>
     */
    private ComplexNumber createFromArgsTest(double real, double imaginary) {
        ComplexNumber c = this.constructorTest(real, imaginary);
        return c;
    }

    /*
     * Constructor tests.
     */

    /**
     * Test no-argument constructor.
     */
    @Test
    public final void testComplexNumber1() {
        ComplexNumber c = this.constructorTest();
        ComplexNumber cExpected = this.constructorRef();

        assertEquals(c, cExpected);
    }

    /**
     * Test constructor that takes 2 doubles as arguments.
     */
    @Test
    public final void testComplexNumber1DoubleDouble() {
        double i = 4.33;
        double j = -16.234;
        ComplexNumber c = this.constructorTest(i, j);
        ComplexNumber cExpected = this.constructorRef(i, j);

        assertEquals(c, cExpected);
    }

    /**
     * Test copy constructor.
     */
    @Test
    public final void testComplexNumber1ComplexNumber() {
        ComplexNumber x = this.createFromArgsTest(12, -12);
        ComplexNumber c = this.constructorTest(x);
        ComplexNumber cExpected = this.constructorRef(x);

        assertEquals(c, cExpected);
    }

    /*
     * Tests for kernel methods.
     */

    /**
     * Test getter for real part.
     */
    @Test
    public final void testRealPart() {
        double real = 143.992;
        double imaginary = 11.33;
        ComplexNumber c = this.constructorTest(real, imaginary);
        double r = 0;
        double rExpected = 143.992;

        r = c.realPart();

        assertEquals(r, rExpected, Math.pow(10, -6));
    }

    /**
     * Test getter for imaginary part.
     */
    @Test
    public final void testImaginaryPart() {
        double real = 143.992;
        double imaginary = 11.33;
        ComplexNumber c = this.constructorTest(real, imaginary);
        double i = 0;
        double iExpected = 11.33;

        i = c.imaginaryPart();

        assertEquals(i, iExpected, Math.pow(10, -6));
    }

    /**
     * Test setter for real part.
     */
    @Test
    public final void testSetRealPart() {
        double r = Double.MAX_VALUE;
        ComplexNumber c = this.constructorTest();

        c.setRealPart(r);
        double rExpected = c.realPart();

        assertEquals(r, rExpected, Math.pow(10, -6));
    }

    /**
     * Test setter for imaginary part.
     */
    @Test
    public final void testSetImaginaryPart() {
        double i = Double.MIN_VALUE;
        ComplexNumber c = this.constructorTest();

        c.setImaginaryPart(i);
        double iExpected = c.imaginaryPart();

        assertEquals(i, iExpected, Math.pow(10, -6));
    }

}
