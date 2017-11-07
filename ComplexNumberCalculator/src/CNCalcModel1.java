import components.complexnumber.ComplexNumber;
import components.complexnumber.ComplexNumber1;

/**
 * Model class.
 *
 * @author Vyyom Kelkar
 */
public final class CNCalcModel1 implements CNCalcModel {

    /**
     * Model variables.
     */
    private final ComplexNumber top, bottom;

    /**
     * Default constructor.
     */
    public CNCalcModel1() {
        this.top = new ComplexNumber1();
        this.bottom = new ComplexNumber1();
    }

    @Override
    public ComplexNumber top() {
        return this.top;
    }

    @Override
    public ComplexNumber bottom() {
        return this.bottom;
    }

}
