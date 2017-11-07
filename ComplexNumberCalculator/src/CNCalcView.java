import java.awt.event.ActionListener;

import components.complexnumber.ComplexNumber;

/**
 * View interface.
 *
 * @author Vyyom Kelkar
 */
public interface CNCalcView extends ActionListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     *
     * @param controller
     *            controller to register
     */
    void registerObserver(CNCalcController controller);

    /**
     * Updates top operand display based on ComplexNumber provided as argument.
     *
     * @param complexnumber
     *            new value of top operand display
     */
    void updateTopDisplay(ComplexNumber complexnumber);

    /**
     * Updates bottom operand display based on ComplexNumber provided as
     * argument.
     *
     * @param complexnumber
     *            new value of bottom operand display
     */
    void updateBottomDisplay(ComplexNumber complexnumber);

    /**
     * Updates display of whether divide operation is allowed.
     *
     * @param allowed
     *            true iff divide is allowed
     */
    void updateDivideAllowed(boolean allowed);

    /**
     * Updates display of whether magnitude operation is allowed.
     *
     * @param allowed
     *            true iff power is allowed
     */
    void updateMagnitudeAllowed(boolean allowed);

    /**
     * Updates display of whether angle operation is allowed.
     *
     * @param allowed
     *            true iff power is allowed
     */
    void updateAngleAllowed(boolean allowed);

    /**
     * Updates display of whether negation is allowed.
     *
     * @param allowed
     *            true iff negation is allowed.
     *
     */
    void updateNegationAllowed(boolean allowed);

}
