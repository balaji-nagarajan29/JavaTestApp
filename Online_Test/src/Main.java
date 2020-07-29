import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main extends JFrame implements ActionListener {

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton buttonNext, buttonBookmark;
    ButtonGroup bg;
    int count = 0, present = 0, a = 1, b = 1, now = 0;
    int[] m = new int[10];


    Main(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        buttonNext = new JButton("Next");
        buttonBookmark = new JButton("Bookmark");
        buttonNext.addActionListener(this);
        buttonBookmark.addActionListener(this);
        add(buttonNext);
        add(buttonBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 100, 20);
        radioButton[1].setBounds(50, 110, 100, 20);
        radioButton[2].setBounds(50, 140, 100, 20);
        radioButton[3].setBounds(50, 170, 100, 20);
        buttonNext.setBounds(100, 240, 100, 30);
        buttonBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNext) {
            if (check())
                count = count + 1;
            present++;
            set();
            if (present == 9) {
                buttonNext.setEnabled(false);
                buttonBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + a);
            bk.setBounds(480, 20 + 30 * a, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[a] = present;
            a++;
            present++;
            set();
            if (present == 9)
                buttonBookmark.setText("Result");
            setVisible(true);
        }
        for (int i = 0, y = 1; i < a; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = present;
                present = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                present = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            present++;
            JOptionPane.showMessageDialog(this, "correct answers= " + count);
            System.exit(0);
        }
    }


    void set() {
        radioButton[4].setSelected(true);
        if (present == 0) {
            label.setText("Que1:  Which of the following is not introduced with Java 8?");
            radioButton[0].setText("Stream API");
            radioButton[1].setText("Serialization");
            radioButton[2].setText("Spliterator");
            radioButton[3].setText("Lambda Expression");
        }
        if (present == 1) {
            label.setText("Que2: What is the purpose of BooleanSupplier function interface?");
            radioButton[0]
                    .setText("represents supplier of Boolean-valued results");
            radioButton[1].setText("returns Boolean-valued result");
            radioButton[2].setText("There is no such function interface");
            radioButton[3]
                    .setText("returns null if Boolean is passed as argument");
        }
        if (present == 2) {
            label.setText("Que3: What is the return type of lambda expression?");
            radioButton[0].setText("String");
            radioButton[1].setText("Object");
            radioButton[2].setText("void");
            radioButton[3].setText("Function");
        }
        if (present == 3) {
            label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
            radioButton[0].setText("for (String i : StringList)");
            radioButton[1].setText("foreach (String i : StringList)");
            radioButton[2].setText("StringList.forEach()");
            radioButton[3].setText("List.for()");
        }
        if (present == 4) {
            label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
            radioButton[0].setText(" Nashorn");
            radioButton[1].setText("V8");
            radioButton[2].setText("Inscript");
            radioButton[3].setText("Narcissus");
        }
        if (present == 5) {
            label.setText("Que6: How to read entire file in one line using java 8?");
            radioButton[0].setText("Files.readAllLines()");
            radioButton[1].setText("Files.read()");
            radioButton[2].setText("Files.readFile()");
            radioButton[3].setText("Files.lines()");
        }
        if (present == 6) {
            label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
            radioButton[0].setText("try catch finally");
            radioButton[1].setText("IOException");
            radioButton[2].setText("AutoCloseable");
            radioButton[3].setText("Streams");
        }
        if (present == 7) {
            label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
            radioButton[0].setText("Configuration");
            radioButton[1].setText("Criteria");
            radioButton[2].setText("SessionManagement");
            radioButton[3].setText("Session");
        }
        if (present == 8) {
            label.setText("Que9: SessionFactory is a thread-safe object.");
            radioButton[0].setText("true");
            radioButton[1].setText("false");
            radioButton[2].setText("don't know");
            radioButton[3].setText("false");
        }
        if (present == 9) {
            label.setText("Que10: Which of the following is not a state of object in Hibernate?");
            radioButton[0].setText("Attached()");
            radioButton[1].setText("Detached()");
            radioButton[2].setText("Persistent()");
            radioButton[3].setText("Transient()");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }


    boolean check() {
        if (present == 0)
            return (radioButton[1].isSelected());
        if (present == 1)
            return (radioButton[0].isSelected());
        if (present == 2)
            return (radioButton[3].isSelected());
        if (present == 3)
            return (radioButton[2].isSelected());
        if (present == 4)
            return (radioButton[0].isSelected());
        if (present == 5)
            return (radioButton[0].isSelected());
        if (present == 6)
            return (radioButton[1].isSelected());
        if (present == 7)
            return (radioButton[2].isSelected());
        if (present == 8)
            return (radioButton[0].isSelected());
        if (present == 9)
            return (radioButton[0].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new Main("Online Test App");
    }

}