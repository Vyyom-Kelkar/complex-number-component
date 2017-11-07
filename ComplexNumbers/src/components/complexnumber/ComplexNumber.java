package components.complexnumber;

/**
 * {@code ComplexNumberKernel} enhanced with secondary methods.
 *
 * @author Vyyom Kelkar
 *
 * @mathdefinitions
 *
 *                  <pre>
 * CONJUGATE(c : COMPLEX)
 * is (c.real_part, - c.imaginary_part)
 *
 * PLUS(
 *  x : COMPLEX,
 *  y : COMPLEX
 * ): COMPLEX
 * is ((x.real_part + y.real_part), (x.imaginary_part + y.imaginary_part))
 *
 * MINUS(
 *  x : COMPLEX,
 *  y : COMPLEX
 * ): COMPLEX
 * is ((x.real_part - y.real_part), (x.imaginary_part - y.imaginary_part))
 *
 * MULTIPLY(
 *  x : COMPLEX,
 *  y : COMPLEX
 * ): COMPLEX
 * is (((x.real_part * y.real_part) - (x.imaginary_part * y.imaginary_part)),
 *     ((x.imaginary_part * y.real_part) + (x.real_part * y.imaginary_part)))
 *
 * DIVIDE(
 *  x : COMPLEX,
 *  y : COMPLEX
 * ): COMPLEX satisfies
 * if y = 0
 *  then DIVIDE (x, y) = 0
 * else if y.imaginary_part = 0 & y.real_part =\= 0
 *  then DIVIDE (x, y) = ((x.real_part / y.real_part),(x.imaginary_part / y.real_part))
 * else DIVDE (x, y) = (MULTIPLY(x, CONJUGATE (y)).real_part /
 *                  ((x.real_part * x.real_part) + (y.real_part * y.real_part)),
 *                  MULTIPLY(x, CONJUGATE (y)).imaginary_part /
 *                  ((x.real_part * x.real_part) + (y.real_part * y.real_part))
 *
 * POWER(
 *  x : COMPLEX,
 *  p : integer
 * ): COMPLEX satisfies
 * if p = 0
 *  then POWER (x, p) = 1
 * else POWER (x, p) = MULTIPLY (POWER(x, p-1), x)
 * constraint p >= 0
 *
 * MAGNITUDE( c : COMPLEX ): real
 * is sqrt ((c.real_part * c.real_part) + (c.imaginary_part * c.imaginary_part))
 *
 * ANGLE( c : COMPLEX ): real
 * [is the angle between the positive real axis and the ray from the origin,
 *  to c in the complex plane.]
 *                  </pre>
 */
public interface ComplexNumber extends ComplexNumberKernel {

    /**
     * Adds {@code x} to {@code this}.
     *
     * @param x
     *            the complex number to add
     * @updates this
     * @ensures this = PLUS (this, x)
     */
    void add(ComplexNumber x);

    /**
     * Subtracts {@code x} from {@code this}.
     *
     * @param x
     *            {@code ComplexNumber} to subtract
     * @updates this
     * @ensures this = MINUS (this, x)
     */
    void subtract(ComplexNumber x);

    /**
     * Multiplies {@code this} by {@code x}.
     *
     * @param x
     *            the complex number to multiply by
     * @updates this
     * @ensures this = MULTIPLY (this, x)
     */
    void multiply(ComplexNumber x);

    /**
     * Divides {@code this} by {@code x}.
     *
     * @param x
     *            {@code ComplexNumber} to divide by
     * @updates this
     * @requires x /= (0,0)
     * @ensures this = DIVIDE (this, x)
     */
    void divide(ComplexNumber x);

    /**
     * Returns the conjugate of {@code this}.
     *
     * @return the conjugate of {@code this}
     * @ensures conjugate = CONJUGATE(this)
     */
    ComplexNumber conjugate();

    /**
     * Copies {@code x} to {@code this}.
     *
     * @param x
     *            {@code ComplexNumber} to copy
     * @replaces this
     * @ensures this = x
     */
    void copyFrom(ComplexNumber x);

    /**
     * Raises {@code this} to the power {@code p}.
     *
     * @param p
     *            power to raise to
     * @updates this
     * @requires p >= 0
     * @ensures this = POWER (this, p)
     */
    void power(int p);

    /**
     * Returns the magnitude of {@code this}.
     *
     * @return magnitude of {@code this}
     *
     * @ensures magnitude = MAGNITUDE (this)
     */
    double magnitude();

    /**
     * Returns the angle of the complex number {@code n} in radians.
     *
     * @return x the angle of the complex number
     *
     * @ensures angle = ANGLE (this)
     */
    double angle();

    /**
     * Returns the polar notation of complex number {@code x}.
     *
     * @return s the string containing the polar notation of x.
     * @ensures toPolarForm = TO_STRING(MAGNITUDE(x)) * "(cos(" *
     *          TO_STRING(angle(x)) * ")+ i*sin(" * TO_STRING(angle(x))* "))"
     */
    String toPolarForm();

    /**
     * Returns the rectangular notation of complex number {@code x}.
     *
     * @return s the string containing the rectangular notation of x.
     * @ensures toRectangularForm = TO_STRING(x.real_part) * " + i(" *
     *          TO_STRING(x.imaginary_part) * ")"
     */
    String toRectangularForm();

}
