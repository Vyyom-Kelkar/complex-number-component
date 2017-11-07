import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import components.complexnumber.ComplexNumber;

/**
 * View class.
 *
 * @author Vyyom Kelkar
 */
@SuppressWarnings("serial")
public final class CNCalcView1 extends JFrame implements CNCalcView {

    /**
     * Controller object registered with this view to observe user-interaction
     * events.
     */
    private CNCalcController controller;

    /**
     * State of user interaction: last event "seen".
     */
    private static enum State {
        /**
         * Last event was clear, enter, another operator, digit entry, display
         * form, or part of complex number entry resp.
         */
        SAW_CLEAR, SAW_ENTER, SAW_OTHER_OP, SAW_DIGIT, SAW_FORM, SAW_PART
    }

    /**
     * State variable to keep track of which event happened last; needed to
     * prepare for digit to be added to bottom operand.
     */
    private State currentState;

    /**
     * Text areas.
     */
    private final JTextArea tTop, tBottom;

    /**
     * Operator and related buttons.
     */
    private final JButton bClear, bEnter, bAdd, bSubtract, bMultiply, bDivide,
            bPower, bConjugate, bMagnitude, bAngle, bNegate;

    /**
     * Toggle button to allow switching the input part or form of the complex
     * number.
     */
    private final JToggleButton bSwitchPart, bRectangular, bPolar;

    /**
     * Digit entry buttons.
     */
    private final JButton[] bDigits = new JButton[10];

    /**
     * Useful constants.
     */
    private static final int TEXT_AREA_HEIGHT = 5, TEXT_AREA_WIDTH = 30,
            DIGIT_BUTTONS = 10, MAIN_BUTTON_PANEL_GRID_ROWS = 4,
            MAIN_BUTTON_PANEL_GRID_COLUMNS = 4, SIDE_BUTTON_PANEL_GRID_ROWS = 4,
            SIDE_BUTTON_PANEL_GRID_COLUMNS = 2, CALC_GRID_ROWS = 3,
            CALC_GRID_COLUMNS = 1;

    /**
     * Default constructor.
     */
    public CNCalcView1() {
        // Create the JFrame being extended

        /*
         * Call the JFrame (superclass) constructor with a String parameter to
         * name the window in its title bar
         */
        super("Complex Number Calculator");

        /*
         * Set up initial state of GUI to behave like last event was "Clear";
         * currentState is not a GUI widget per se, but is needed to process
         * digit button events appropriately
         */
        this.currentState = State.SAW_CLEAR;

        // Set up the GUI widgets --------------------------------------------

        /*
         * Create widgets
         */

        // Set up the GUI widgets --------------------------------------------

        /*
         * Text areas should wrap lines, and should be read-only; they cannot be
         * edited because allowing keyboard entry would require checking whether
         * entries are digits, which we don't want to have to do
         */
        this.tTop = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tTop.setEditable(false);
        this.tTop.setLineWrap(true);
        this.tTop.setText("");
        this.tBottom = new JTextArea("", TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
        this.tBottom.setEditable(false);
        this.tBottom.setLineWrap(true);
        this.tBottom.setText("");

        /*
         * Initially, the following buttons should be disabled: divide (divisor
         * must not be 0) and root (root must be at least 2) -- hint: see the
         * JButton method setEnabled
         */
        boolean b = false;
        this.bRectangular = new JToggleButton("Rectangular", false);
        this.bPolar = new JToggleButton("Polar", false);
        this.bMagnitude = new JButton("Magnitude");
        this.bAngle = new JButton("Angle");
        this.bClear = new JButton("Clear");
        this.bEnter = new JButton("Enter");
        this.bSwitchPart = new JToggleButton("Switch Part", false);
        this.bNegate = new JButton("(-)");
        this.bConjugate = new JButton("Conjugate");
        this.bAdd = new JButton("+");
        this.bSubtract = new JButton("-");
        this.bMultiply = new JButton("*");
        this.bDivide = new JButton("/");
        this.bPower = new JButton("Power");
        this.bDigits[0] = new JButton("0");
        this.bDigits[1] = new JButton("1");
        this.bDigits[2] = new JButton("2");
        this.bDigits[3] = new JButton("3");
        this.bDigits[4] = new JButton("4");
        this.bDigits[5] = new JButton("5");
        this.bDigits[6] = new JButton("6");
        this.bDigits[7] = new JButton("7");
        this.bDigits[8] = new JButton("8");
        this.bDigits[9] = new JButton("9");
        this.bDivide.setEnabled(b);
        this.bMagnitude.setEnabled(b);
        this.bAngle.setEnabled(b);

        /*
         * Create scroll panes for the text areas in case number is long enough
         * to require scrolling
         */
        JScrollPane inputTextScrollPane = new JScrollPane(this.tBottom);
        JScrollPane outputTextScrollPane = new JScrollPane(this.tTop);

        /*
         * Create main button panel
         */
        JPanel buttonPanel = new JPanel(new GridLayout(
                MAIN_BUTTON_PANEL_GRID_ROWS, MAIN_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the main button panel, from left to right and top
         * to bottom
         */
        buttonPanel.add(this.bDigits[7]);
        buttonPanel.add(this.bDigits[8]);
        buttonPanel.add(this.bDigits[9]);
        buttonPanel.add(this.bAdd);
        buttonPanel.add(this.bDigits[4]);
        buttonPanel.add(this.bDigits[5]);
        buttonPanel.add(this.bDigits[6]);
        buttonPanel.add(this.bSubtract);
        buttonPanel.add(this.bDigits[1]);
        buttonPanel.add(this.bDigits[2]);
        buttonPanel.add(this.bDigits[3]);
        buttonPanel.add(this.bMultiply);
        buttonPanel.add(this.bDigits[0]);
        buttonPanel.add(this.bConjugate);
        buttonPanel.add(this.bPower);
        buttonPanel.add(this.bDivide);

        /*
         * Create side button panels
         */
        JPanel sideButtonPanel = new JPanel(new GridLayout(
                SIDE_BUTTON_PANEL_GRID_ROWS, SIDE_BUTTON_PANEL_GRID_COLUMNS));

        /*
         * Add the buttons to the side button panel, from left to right and top
         * to bottom
         */
        sideButtonPanel.add(this.bRectangular);
        sideButtonPanel.add(this.bPolar);
        sideButtonPanel.add(this.bSwitchPart);
        sideButtonPanel.add(this.bNegate);
        sideButtonPanel.add(this.bMagnitude);
        sideButtonPanel.add(this.bAngle);
        sideButtonPanel.add(this.bClear);
        sideButtonPanel.add(this.bEnter);

        ButtonGroup form = new ButtonGroup();
        form.add(this.bRectangular);
        form.add(this.bRectangular);

        /*
         * Create combined button panel organized using flow layout, which is
         * simple and does the right thing: sizes of nested panels are natural,
         * not necessarily equal as with grid layout
         */
        JPanel combinedButtonPanel = new JPanel(new FlowLayout());

        /*
         * Add the other two button panels to the combined button panel
         */
        combinedButtonPanel.add(buttonPanel);
        combinedButtonPanel.add(sideButtonPanel);

        /*
         * Organize main window
         */
        this.setLayout(new GridLayout(CALC_GRID_ROWS, CALC_GRID_COLUMNS));

        /*
         * Add scroll panes and button panel to main window, from left to right
         * and top to bottom
         */
        this.add(outputTextScrollPane);
        this.add(inputTextScrollPane);
        this.add(combinedButtonPanel);

        // Set up the observers ----------------------------------------------

        /*
         * Register this object as the observer for all GUI events
         */
        this.bClear.addActionListener(this);
        this.bEnter.addActionListener(this);
        this.bSwitchPart.addActionListener(this);
        this.bNegate.addActionListener(this);
        this.bAdd.addActionListener(this);
        this.bSubtract.addActionListener(this);
        this.bMultiply.addActionListener(this);
        this.bDivide.addActionListener(this);
        this.bPower.addActionListener(this);
        this.bConjugate.addActionListener(this);
        this.bDigits[0].addActionListener(this);
        this.bDigits[1].addActionListener(this);
        this.bDigits[2].addActionListener(this);
        this.bDigits[3].addActionListener(this);
        this.bDigits[4].addActionListener(this);
        this.bDigits[5].addActionListener(this);
        this.bDigits[6].addActionListener(this);
        this.bDigits[7].addActionListener(this);
        this.bDigits[8].addActionListener(this);
        this.bDigits[9].addActionListener(this);
        this.bRectangular.addActionListener(this);
        this.bPolar.addActionListener(this);
        this.bMagnitude.addActionListener(this);
        this.bAngle.addActionListener(this);

        // Set up the main application window --------------------------------

        /*
         * Make sure the main window is appropriately sized, exits this program
         * on close, and becomes visible to the user
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void registerObserver(CNCalcController controller) {
        this.controller = controller;
    }

    @Override
    public void updateTopDisplay(ComplexNumber n) {
        this.tTop.setText(n.toString());
    }

    @Override
    public void updateBottomDisplay(ComplexNumber n) {
        this.tBottom.setText(n.toString());
    }

    @Override
    public void updateDivideAllowed(boolean allowed) {
        this.bDivide.setEnabled(allowed);
    }

    @Override
    public void updateMagnitudeAllowed(boolean allowed) {
        this.bMagnitude.setEnabled(allowed);
    }

    @Override
    public void updateAngleAllowed(boolean allowed) {
        this.bAngle.setEnabled(allowed);
    }

    @Override
    public void updateNegationAllowed(boolean allowed) {
        this.bNegate.setEnabled(allowed);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.bClear) {
            this.controller.processClearEvent();
            this.currentState = State.SAW_CLEAR;
        } else if (source == this.bEnter) {
            this.controller.processEnterEvent();
            this.currentState = State.SAW_ENTER;
        } else if (source == this.bAdd) {
            this.controller.processAddEvent();
            this.currentState = State.SAW_OTHER_OP;
        } else if (source == this.bSubtract) {
            this.controller.processSubtractEvent();
            this.currentState = State.SAW_OTHER_OP;
        } else if (source == this.bMultiply) {
            this.controller.processMultiplyEvent();
            this.currentState = State.SAW_OTHER_OP;
        } else if (source == this.bDivide) {
            this.controller.processDivideEvent();
            this.currentState = State.SAW_OTHER_OP;
        } else if (source == this.bPower) {
            this.controller.processPowerEvent();
            this.currentState = State.SAW_OTHER_OP;
        } else {
            for (int i = 0; i < DIGIT_BUTTONS; i++) {
                if (source == this.bDigits[i]) {
                    switch (this.currentState) {
                        case SAW_ENTER:
                            this.controller.processClearEvent();
                            break;
                        case SAW_OTHER_OP:
                            this.controller.processEnterEvent();
                            this.controller.processClearEvent();
                            break;
                        default:
                            break;
                    }
                    this.controller.processAddNewDigitEvent(i);
                    this.currentState = State.SAW_DIGIT;
                    break;
                }
            }
        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

}
