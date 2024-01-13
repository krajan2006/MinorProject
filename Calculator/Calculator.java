package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener 
{

    double number, answer;
    int calculation;

    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");
    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton bDot = new JButton(".");
    JButton bClear = new JButton("C");
    JButton bDelete = new JButton("DEL");
    JButton bEqual = new JButton("=");
    JButton bMultiply = new JButton("x");
    JButton bDivision = new JButton("/");
    JButton bPlus = new JButton("+");
    JButton bMinus = new JButton("-");
    JButton bSquare = new JButton("x\u00B2");
    JButton bReciprocal = new JButton("1/x");
    JButton bSqrt = new JButton("\u221A");

    // Colors for the GUI
    Color red = new Color(239, 71, 111);
    Color bodycolor = new Color(255, 255, 255);
    Color green = new Color(6, 255, 160);
    Color buttoncolor = new Color(150, 159, 176);

    // All required Method for calculater
    Calculator() {
        prepareGUI();
        addComponents();
        addActionEvent();
    }

    // Method to prepare the GUI
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(300, 490);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(bodycolor);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method to add all the components like the numbers and symbols of all the
    // operations to the GUI
    public void addComponents() 
    {
        //label area
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.black);
        frame.add(label);
        //text area 
        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        //radio on button
        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(bodycolor);
        onRadioButton.setForeground(Color.black);
        frame.add(onRadioButton);
        //radio off button
        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setSelected(false);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(bodycolor);
        offRadioButton.setForeground(Color.black);
        frame.add(offRadioButton);
        //adding radio on-off to button group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);
        //button 7
        b7.setBounds(10, 230, 60, 40);
        b7.setFont(new Font("Arial", Font.BOLD, 20));
        b7.setBackground(buttoncolor);
        b7.setForeground(Color.white);
        frame.add(b7);
        //button 8
        b8.setBounds(80, 230, 60, 40);
        b8.setFont(new Font("Arial", Font.BOLD, 20));
        b8.setBackground(buttoncolor);
        b8.setForeground(Color.white);
        frame.add(b8);
        //button 9
        b9.setBounds(150, 230, 60, 40);
        b9.setFont(new Font("Arial", Font.BOLD, 20));
        b9.setBackground(buttoncolor);
        b9.setForeground(Color.white);
        frame.add(b9);
        //button 4
        b4.setBounds(10, 290, 60, 40);
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b4.setBackground(buttoncolor);
        b4.setForeground(Color.white);
        frame.add(b4);
        //button 5
        b5.setBounds(80, 290, 60, 40);
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setBackground(buttoncolor);
        b5.setForeground(Color.white);
        frame.add(b5);
        //button 6
        b6.setBounds(150, 290, 60, 40);
        b6.setFont(new Font("Arial", Font.BOLD, 20));
        b6.setBackground(buttoncolor);
        b6.setForeground(Color.white);
        frame.add(b6);
        //button 1
        b1.setBounds(10, 350, 60, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBackground(buttoncolor);
        b1.setForeground(Color.white);
        frame.add(b1);
        //button 2
        b2.setBounds(80, 350, 60, 40);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBackground(buttoncolor);
        b2.setForeground(Color.white);
        frame.add(b2);
        //button 3
        b3.setBounds(150, 350, 60, 40);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setBackground(buttoncolor);
        b3.setForeground(Color.white);
        frame.add(b3);
        //button Dot
        bDot.setBounds(150, 410, 60, 40);
        bDot.setFont(new Font("Arial", Font.BOLD, 20));
        bDot.setBackground(buttoncolor);
        bDot.setForeground(Color.white);
        frame.add(bDot);
        //button 0
        b0.setBounds(10, 410, 130, 40);
        b0.setFont(new Font("Arial", Font.BOLD, 20));
        b0.setBackground(buttoncolor);
        b0.setForeground(Color.white);
        frame.add(b0);
        //button Equal
        bEqual.setBounds(220, 350, 60, 100);
        bEqual.setFont(new Font("Arial", Font.BOLD, 20));
        bEqual.setBackground(green);
        frame.add(bEqual);
        //button Equal
        bDivision.setBounds(220, 110, 60, 40);
        bDivision.setFont(new Font("Arial", Font.BOLD, 20));
        bDivision.setBackground(buttoncolor);
        frame.add(bDivision);
        //button Square Rooot 
        bSqrt.setBounds(10, 170, 60, 40);
        bSqrt.setFont(new Font("Arial", Font.BOLD, 18));
        bSqrt.setBackground(buttoncolor);
        frame.add(bSqrt);
        //button Multiply
        bMultiply.setBounds(220, 230, 60, 40);
        bMultiply.setFont(new Font("Arial", Font.BOLD, 20));
        bMultiply.setBackground(buttoncolor);
        frame.add(bMultiply);
        //button Minus
        bMinus.setBounds(220, 170, 60, 40);
        bMinus.setFont(new Font("Arial", Font.BOLD, 20));
        bMinus.setBackground(buttoncolor);
        frame.add(bMinus);
        //button Plus
        bPlus.setBounds(220, 290, 60, 40);
        bPlus.setFont(new Font("Arial", Font.BOLD, 20));
        bPlus.setBackground(buttoncolor);
        frame.add(bPlus);
        //button Square
        bSquare.setBounds(80, 170, 60, 40);
        bSquare.setFont(new Font("Arial", Font.BOLD, 20));
        bSquare.setBackground(buttoncolor);
        frame.add(bSquare);
        //button reciprocal
        bReciprocal.setBounds(150, 170, 60, 40);
        bReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        bReciprocal.setBackground(buttoncolor);
        frame.add(bReciprocal);
        //button delete
        bDelete.setBounds(150, 110, 60, 40);
        bDelete.setFont(new Font("Arial", Font.BOLD, 12));
        bDelete.setBackground(red);
        bDelete.setForeground(Color.white);
        frame.add(bDelete);
        //button clear
        bClear.setBounds(80, 110, 60, 40);
        bClear.setFont(new Font("Arial", Font.BOLD, 12));
        bClear.setBackground(red);
        bClear.setForeground(Color.white);
        frame.add(bClear);

    }

    // Method to add all the action listeners to the buttons
    public void addActionEvent() 
    {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        bClear.addActionListener(this);
        bDelete.addActionListener(this);
        bDivision.addActionListener(this);
        bSqrt.addActionListener(this);
        bSquare.addActionListener(this);
        bReciprocal.addActionListener(this);
        bMinus.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bMultiply.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        bPlus.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bEqual.addActionListener(this);
        b0.addActionListener(this);
        bDot.addActionListener(this);
    }

    // Method to add all the key listeners to the buttons and the frame
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();

        // If the on radio button is selected, the calculator is enabled
        if (source == onRadioButton) 
        {
            enable();
        }
        // If the off radio button is selected, the calculator is disabled
        else if (source == offRadioButton) 
        {
            disable();
        }
        // If the clear button is pressed, the text field is cleared
        else if (source == bClear) 
        {
            label.setText("");
            textField.setText("");
        }
        // If the delete button is pressed, the last character is deleted
        else if (source == bDelete) 
        {
            int length = textField.getText().length(); // Get the length of the text field
            int number = length - 1; // Get the number of characters to delete

            if (length > 0) 
            { // If the length is greater than 0, delete the last character
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());

            }
            if (textField.getText().endsWith("")) 
            { // If the text field is empty, set the label to 0
                label.setText("");
            }
        } 
        else if (source == b0) 
        { // If the zero button is pressed, add a zero to the text field
            if (textField.getText().equals("0")) 
            { // If the text field is 0, do nothing
                return;
            } 
            else 
            { // If the text field is not empty, add a zero to the text field
                textField.setText(textField.getText() + "0");
            }
        }
        // If the one button is pressed, add a one to the text field and so on for all
        // the other buttons
        else if (source == b1) 
        {
            textField.setText(textField.getText() + "1");
        } else if (source == b2) 
        {
            textField.setText(textField.getText() + "2");
        } else if (source == b3) 
        {
            textField.setText(textField.getText() + "3");
        } else if (source == b4) 
        {
            textField.setText(textField.getText() + "4");
        } else if (source == b5) 
        {
            textField.setText(textField.getText() + "5");
        } else if (source == b6) 
        {
            textField.setText(textField.getText() + "6");
        } else if (source == b7) 
        {
            textField.setText(textField.getText() + "7");
        } else if (source == b8) 
        {
            textField.setText(textField.getText() + "8");
        } else if (source == b9) 
        {
            textField.setText(textField.getText() + "9");
        } else if (source == bDot) 
        {
            if (textField.getText().contains(".")) 
            { // If the text field contains a dot, do nothing
                return;
            } 
            else 
            {
                textField.setText(textField.getText() + "."); // If the text field does not contain a dot, add a dot
            }

        }
        // If the plus button is pressed, add a plus to the text field and so on for all
        // the buttons
        else if (source == bPlus) 
        {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "+");
            calculation = 1;
        } 
        else if (source == bMinus) 
        {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "-");
            calculation = 2;
        } 
        else if (source == bMultiply) 
        {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "X");
            calculation = 3;
        } 
        else if (source == bDivision) 
        {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "/");
            calculation = 4;
        } 
        else if (source == bSqrt) 
        {
            number = Double.parseDouble(textField.getText());
            Double sqrt = Math.sqrt(number);
            textField.setText(Double.toString(sqrt));

        } 
        else if (source == bSquare) 
        {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            double square = Math.pow(number, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) 
            {
                textField.setText(string.replace(".0", ""));
            } 
            else 
            {
                textField.setText(string);
            }
            label.setText("(sqr)" + str);
        } 
        else if (source == bReciprocal) 
        {
            number = Double.parseDouble(textField.getText());
            double reciprocal = 1 / number;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) 
            {
                textField.setText(string.replace(".0", ""));
            } 
            else 
            {
                textField.setText(string);
            }
        } 
        else if (source == bEqual) 
        {
            switch (calculation) 
            {
                case 1:
                    answer = number + Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case 2:
                    answer = number - Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case 3:
                    answer = number * Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;
                case 4:
                    answer = number / Double.parseDouble(textField.getText());
                    if (Double.toString(answer).endsWith(".0")) {
                        textField.setText(Double.toString(answer).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(answer));
                    }
                    label.setText("");
                    break;

            }
        }

    }

    // method to enable the calculator
    public void enable() 
    {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(true);
        textField.setEnabled(true);
        label.setEnabled(true);
        bClear.setEnabled(true);
        bDelete.setEnabled(true);
        bDivision.setEnabled(true);
        bSqrt.setEnabled(true);
        bSquare.setEnabled(true);
        bReciprocal.setEnabled(true);
        bMinus.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        bMultiply.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        bPlus.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        bEqual.setEnabled(true);
        b0.setEnabled(true);
        bDot.setEnabled(true);

    }

    // method to disable the calculator
    public void disable() 
    {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setText("");
        label.setText(" ");
        bClear.setEnabled(false);
        bDelete.setEnabled(false);
        bDivision.setEnabled(false);
        bSqrt.setEnabled(false);
        bSquare.setEnabled(false);
        bReciprocal.setEnabled(false);
        bMinus.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        bMultiply.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        bPlus.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        bEqual.setEnabled(false);
        b0.setEnabled(false);
        bDot.setEnabled(false);
    }

    public static void main(String[] args) 
    {
        new Calculator(); // create a new Calculator object
    }
}