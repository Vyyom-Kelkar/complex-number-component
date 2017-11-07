import components.complexnumber.ComplexNumber;

/**
 * Model interface.
 *
 * The Complex Number Calculator model consists of the top and bottom operands
 * (which have only getter methods).
 *
 * @author Vyyom Kelkar
 *
 * @mathmodel
 *
 *            <pre>
 * type CNCalcModel is modeled by
 *   (top: COMPLEX,
 *    bottom: COMPLEX)
 *            </pre>
 *
 * @initially
 *
 *            <pre>
 * ():
 *  ensures
 *   this = (0, 0)
 *            </pre>
 */
public interface CNCalcModel {

    /**
     * Reports top operand.
     *
     * @return this.top
     * @aliases reference returned by {@code top}
     * @ensures top = this.top
     */
    ComplexNumber top();

    /**
     * Reports bottom operand.
     *
     * @return this.bottom
     * @aliases reference returned by {@code bottom}
     * @ensures bottom = this.bottom
     */
    ComplexNumber bottom();
}
