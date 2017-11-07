/**
 * Complex Number Calculator application.
 *
 * @author Vyyom Kelkar
 *
 */
public final class ComplexNumberCalculator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ComplexNumberCalculator() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     *
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects;
         * controller needs to know about model and view, and view needs to know
         * about controller
         */
        CNCalcModel model = new CNCalcModel1();
        CNCalcView view = new CNCalcView1();
        CNCalcController controller = new CNCalcController1(model, view);

        view.registerObserver(controller);
    }
}
