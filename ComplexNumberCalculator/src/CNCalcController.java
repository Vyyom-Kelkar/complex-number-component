/**
 * Controller interface.
 *
 * @author Vyyom Kelkar
 *
 * @mathmodel
 *
 *            <pre>
 * type CNCalcController is modeled by
 *   (model: CNCalcModel,
 *    view: CNCalcView)
 *            </pre>
 *
 * @initially
 *
 *            <pre>
 * (CNCalcModel model, CNCalcView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 *            </pre>
 */
public interface CNCalcController {

    /**
     * Processes event to clear bottom operand.
     *
     * @updates this.model.bottom, this.view
     * @ensures
     *
     *          <pre>
     * this.model.bottom = 0  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processClearEvent();

    /**
     * Processes event to enter bottom operand to top.
     *
     * @updates this.model.top, this.view
     * @ensures
     *
     *          <pre>
     * this.model.top = this.model.bottom  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processEnterEvent();

    /**
     * Processes event to do an add operation.
     *
     * @updates this.model, this.view
     * @ensures
     *
     *          <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top + #this.model.bottom  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processAddEvent();

    /**
     * Processes event to do a subtract operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom <= this.model.top
     * @ensures
     *
     *          <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top - #this.model.bottom  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processSubtractEvent();

    /**
     * Processes event to do a multiply operation.
     *
     * @updates this.model, this.view
     * @ensures
     *
     *          <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top * #this.model.bottom  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processMultiplyEvent();

    /**
     * Processes event to do a divide operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom > 0
     * @ensures
     *
     *          <pre>
     * #this.model.top =
     *   this.model.bottom * #this.model.bottom + this.model.top  and
     * 0 <= this.model.top < #this.model.bottom  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processDivideEvent();

    /**
     * Processes event to do a power operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom <= INT_LIMIT
     * @ensures
     *
     *          <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top ^ (#this.model.bottom)  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processPowerEvent();

    /**
     * Processes event to add a new (low-order) digit to the bottom operand.
     *
     * @param digit
     *            the low-order digit to be added
     *
     * @updates this.model.bottom, this.view
     * @requires 0 <= digit < 10
     * @ensures
     *
     *          <pre>
     * this.model.bottom = #this.model.bottom * 10 + digit  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processAddNewDigitEvent(int digit);

    /**
     * Processes event to do a conjugate operation.
     *
     * @updates this.model, this.view
     * @ensures
     *
     *          <pre>
     * this.model.bottom = CONJUGATE(#this.model.bottom)  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processConjugateEvent();

    /**
     * Processes event to negate the next digit (low-order).
     *
     * @updates this.model, this.view
     * @ensures
     *
     *          <pre>
     * this.model.bottom = CONJUGATE(#this.model.bottom)  and
     * [this.view has been updated to match this.model]
     *          </pre>
     */
    void processNegateEvent();

}
