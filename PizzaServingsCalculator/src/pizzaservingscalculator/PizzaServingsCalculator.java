/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaservingscalculator;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 *
 * @author Leo45
 */
public class PizzaServingsCalculator extends JFrame {
    private final JPanel pizzaJPanel;
    private final JButton button;
    private final JLabel labelOne,labelTwo,result;
    private final JTextField textField;
    
    public PizzaServingsCalculator(){
        super("Pizza Servings Calculator");
        pizzaJPanel = new JPanel();
        setContentPane(pizzaJPanel);
        pizzaJPanel.setLayout(new GridLayout(4,1,0,2));
        //First red label
        labelOne = new JLabel("Pizza Servings Calculator",SwingConstants.CENTER);
        labelOne.setForeground(Color.RED);
        labelOne.setFont(new Font("Serif",Font.BOLD,28));
        //Request and input
        JPanel line2 = new JPanel();
        pizzaJPanel.add(line2);
        labelTwo = new JLabel("Enter the size of the pizza in inches:",SwingConstants.CENTER);
        textField = new JTextField();
        textField.setColumns(5);
        //Button
        button = new JButton("Calculate Servings");
        button.setPreferredSize(new Dimension(10, 60));
        button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                double size = Double.parseDouble(textField.getText());
                                //get serving from input and formula
                                double servings = Math.pow((size / 8.0), 2);
                                result.setText(String.format("A %.0f inch pizza will serve %.2f people", size, servings));
                        }
                });
        //Result
        result = new JLabel();
        result.setHorizontalAlignment(SwingConstants.CENTER);
        //Add everything to the GUI
        pizzaJPanel.add(labelOne);
        pizzaJPanel.add(line2);
        line2.add(labelTwo);
        line2.add(textField);
        pizzaJPanel.add(button);
        pizzaJPanel.add(result);
        this.setSize(350,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        PizzaServingsCalculator calc = new PizzaServingsCalculator();
    }
    
}
