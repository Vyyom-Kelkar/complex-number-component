package components.complexnumber;

import components.standard.Standard;

/**
 * Complex Number kernel component with primary methods.
 *
 * @author Vyyom Kelkar
 *
 * @mathsubtypes
 *
 *               <pre>
 * COMPLEX is (
 *   real_part: real,
 *   imaginary_part: real
 *  )
 *               </pre>
 *
 * @mathmodel type ComplexNumberKernel is modeled by COMPLEX
 * @initially
 *
 *            <pre>
 * ():
 *  ensures
 *   this = (0.0,0.0)
 *
 * (double i, double j):
 *  ensures
 *      this = (i, j)
 *
 * (ComplexNumber n):
 *  ensures
 *   this = n
 *            </pre>
 */
public interface ComplexNumberKernel extends Standard<ComplexNumber> {

    /**
     * Gets real part of the complex number {@code this}.
     *
     * @return the real part of complex number {@code this}
     *
     * @ensures realPart = this.real_part
     */
    double realPart();

    /**
     * Gets imaginary part of the complex number {@code this}.
     *
     * @return the imaginary part of complex number {@code this}
     *
     * @ensures imaginaryPart = this.imaginary_part
     */
    double imaginaryPart();

    /**
     * Sets real part of the complex number {@code this}.
     *
     * @param x
     *            the double to set as the real part of {@code this}
     * @updates this.real_part
     *
     * @ensures this.real_part = x
     */
    void setRealPart(double x);

    /**
     * Sets imaginary part of the complex number {@code this}.
     *
     * @param x
     *            the double to set as the imaginary part of {@code this}
     * @updates this.imaginary_part
     *
     * @ensures this.imaginary_part = x
     */
    void setImaginaryPart(double x);

}
