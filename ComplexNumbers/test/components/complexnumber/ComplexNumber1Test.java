package components.complexnumber;

/**
 * Customized JUnit text fixture for {@code ComplexNumber1}.
 *
 * @author Vyyom
 *
 */
public class ComplexNumber1Test extends ComplexNumberTest {

    @Override
    protected final ComplexNumber constructorTest() {
        return new ComplexNumber1();
    }

    @Override
    protected final ComplexNumber constructorTest(double i, double j) {
        return new ComplexNumber1(i, j);
    }

    @Override
    protected final ComplexNumber constructorTest(ComplexNumber c) {
        return new ComplexNumber1(c);
    }

    @Override
    protected final ComplexNumber constructorRef() {
        return new ComplexNumber1();
    }

    @Override
    protected final ComplexNumber constructorRef(double i, double j) {
        return new ComplexNumber1(i, j);
    }

    @Override
    protected final ComplexNumber constructorRef(ComplexNumber c) {
        return new ComplexNumber1(c);
    }

}
