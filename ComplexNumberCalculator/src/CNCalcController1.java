import components.complexnumber.ComplexNumber;
import components.complexnumber.ComplexNumber1;

/**
 * Controller class.
 *
 * @author Vyyom Kelkar
 */
public final class CNCalcController1 implements CNCalcController {

    /**
     * Model object.
     */
    private final CNCalcModel model;

    /**
     * View object.
     */
    private final CNCalcView view;

    /**
     * Useful constants.
     */
    private static final ComplexNumber ZERO = new ComplexNumber1(0, 0);

    /**
     * Useful constants.
     */
    private static final int INT_LIMIT = Integer.MAX_VALUE;

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(CNCalcModel model,
            CNCalcView view) {

        view.updateBottomDisplay(model.bottom());
        view.updateTopDisplay(model.top());
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public CNCalcController1(CNCalcModel model, CNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        if (bottom.equals(ZERO)) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.copyFrom(bottom);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        ComplexNumber temp = top.newInstance();
        temp.transferFrom(top);
        bottom.add(temp);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.subtract(bottom);
        bottom.transferFrom(top);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        ComplexNumber temp = top.newInstance();
        temp.transferFrom(top);
        bottom.multiply(temp);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        ComplexNumber temp = new ComplexNumber2(top.divide(bottom));
        bottom.transferFrom(top);
        top.transferFrom(temp);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.power(bottom.toInt());
        bottom.transferFrom(top);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processRootEvent() {

        /*
         * Get aliases to top and bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.root(bottom.toInt());
        bottom.transferFrom(top);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        /*
         * Get aliases to bottom from model
         */
        ComplexNumber top = this.model.top();
        ComplexNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiplyBy10(digit);
        if (bottom.compareTo(top) > 0) {
            this.view.updateSubtractAllowed(false);
        } else {
            this.view.updateSubtractAllowed(true);
        }
        if (bottom.isZero()) {
            this.view.updateDivideAllowed(false);
        } else {
            this.view.updateDivideAllowed(true);
        }
        if (bottom.compareTo(TWO) < 0) {
            this.view.updateRootAllowed(false);
        } else {
            this.view.updateRootAllowed(true);
        }
        if (bottom.compareTo(this.INT_LIMIT) > 0) {
            this.view.updatePowerAllowed(false);
        } else {
            this.view.updatePowerAllowed(true);
        }
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processConjugateEvent() {
        // TODO Auto-generated method stub

    }

}
