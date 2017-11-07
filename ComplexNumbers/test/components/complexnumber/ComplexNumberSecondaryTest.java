package components.complexnumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit fixture for {@code ComplexNumber}'s non-kernel methods.
 *
 * @author Vyyom
 *
 */
public class ComplexNumberSecondaryTest {

    /*
     * Tests for common methods (from Object).
     */

    /**
     * Test hash code for 2 equal complex numbers.
     */
    @Test
    public final void testHashCodeBothEqual() {
        ComplexNumber c1 = new ComplexNumber1(1, 1);
        ComplexNumber c2 = new ComplexNumber1(1.0, 1.0);

        assertEquals(c1.hashCode(), c2.hashCode());
    }

    /**
     * Test hash code for 2 unequal complex numbers.
     */
    @Test
    public final void testHashCodeBothUnEqual() {
        ComplexNumber c1 = new ComplexNumber1(1.0 / 5.0, 1.0 / 5.0);
        ComplexNumber c2 = new ComplexNumber1(-123, -3313.0);

        assertNotEquals(c2.hashCode(), c1.hashCode());
    }

    /**
     * Test equals implementation for equal complex numbers.
     */
    @Test
    public final void testEqualsObjectEqual() {
        ComplexNumber c1 = new ComplexNumber1(1.0, 5.0);
        ComplexNumber c2 = new ComplexNumber1(1, 5);
        boolean b = false;

        b = c1.equals(c2);

        assertTrue(b);
    }

    /**
     * Test equals implementation for unequal complex numbers.
     */
    @Test
    public final void testEqualsObjectUnEqual() {
        ComplexNumber c1 = new ComplexNumber1(1.0, 5.0);
        ComplexNumber c2 = new ComplexNumber1(2, 5);
        boolean b = true;

        b = c1.equals(c2);

        assertFalse(b);
    }

    /**
     * Test to string implementation for complex number = (0,0).
     */
    @Test
    public final void testToString00() {
        String cActual = "";
        ComplexNumber c = new ComplexNumber1();
        String cExpected = "(0.0, 0.0)";
        boolean b = false;

        cActual = c.toString();
        b = cActual.equals(cExpected);

        assertTrue(b);
    }

    /**
     * Test to string implementation for non-trivial complex number.
     */
    @Test
    public final void testToStringNonTrivial() {
        String cActual = "";
        ComplexNumber c = new ComplexNumber1(-12.995, 23.11091);
        String cExpected = "(-12.995, 23.11091)";
        boolean b = false;

        cActual = c.toString();
        b = cActual.equals(cExpected);

        assertTrue(b);
    }

    /*
     * Tests for non-kernel methods.
     */

    /**
     * Test for adding 2 complex numbers.
     */
    @Test
    public final void testAdd() {
        ComplexNumber c1 = new ComplexNumber1();
        ComplexNumber c2 = new ComplexNumber1(2, 3);
        ComplexNumber c1Expected = new ComplexNumber1(c2);
        ComplexNumber c2Expected = new ComplexNumber1(c2);

        c1.add(c2);

        assertEquals(c1, c1Expected);
        assertEquals(c2, c2Expected);
    }

    /**
     * Test subtraction of 2 complex numbers.
     */
    @Test
    public final void testSubtract() {
        ComplexNumber c1 = new ComplexNumber1(2, 3);
        ComplexNumber c2 = new ComplexNumber1();
        ComplexNumber c1Expected = new ComplexNumber1(c1);
        ComplexNumber c2Expected = new ComplexNumber1(c2);

        c1.subtract(c2);

        assertEquals(c1, c1Expected);
        assertEquals(c2, c2Expected);
    }

    /**
     * Test multiplication of 2 complex numbers.
     */
    @Test
    public final void testMultiply() {
        ComplexNumber c1 = new ComplexNumber1();
        ComplexNumber c2 = new ComplexNumber1(2, 3);
        ComplexNumber c1Expected = new ComplexNumber1(c1);
        ComplexNumber c2Expected = new ComplexNumber1(c2);

        c1.multiply(c2);

        assertEquals(c1, c1Expected);
        assertEquals(c2, c2Expected);
    }

    /**
     * Test division of 2 complex numbers.
     */
    @Test
    public final void testDivide() {
        ComplexNumber c1 = new ComplexNumber1(1, 3);
        ComplexNumber c2 = new ComplexNumber1(2, 3);
        ComplexNumber c1Expected = new ComplexNumber1(-2.2, 1.4);
        ComplexNumber c2Expected = new ComplexNumber1(c2);

        c1.divide(c2);

        assertEquals(c1, c1Expected);
        assertEquals(c2, c2Expected);
    }

    /**
     * Test the conjugate of a complex number.
     */
    @Test
    public final void testConjugate() {
        ComplexNumber c1 = new ComplexNumber1(0, 1);
        ComplexNumber xExpected = new ComplexNumber1(0, -1);

        ComplexNumber x = c1.conjugate();

        assertEquals(x, xExpected);
    }

    /**
     * Test copying of one complex number to another.
     */
    @Test
    public final void testCopyFrom() {
        ComplexNumber c1 = new ComplexNumber1(0, 1);
        ComplexNumber x = new ComplexNumber1();
        ComplexNumber xExpected = new ComplexNumber1(0, 1);

        x.copyFrom(c1);

        assertEquals(x, xExpected);
    }

    /**
     * Test raising of a complex number to a non-zero integral power.
     */
    @Test
    public final void testPower() {

    }

    /**
     * Test the magnitude of a complex number.
     */
    @Test
    public final void testMagnitude() {

    }

    /**
     * Test the angle of a complex number.
     */
    @Test
    public final void testAngle() {

    }

    /**
     * Test the polar form representation of a complex number.
     */
    @Test
    public final void testToPolarForm() {

    }

    /**
     * Test the rectangular (Cartesian) form representation of a complex number.
     */
    @Test
    public final void testToRectangularForm() {

    }

}
