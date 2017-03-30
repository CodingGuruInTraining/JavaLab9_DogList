package com.mark;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hl4350hb on 3/29/2017.
 */
public class DogGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField dogNameTextField;
    private JTextField dogAgeTextField;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JList<Dog> dogJList;
    private JButton deleteDogButton;

    DefaultListModel<Dog> dogListModel;

    protected DogGUI() {
        super("List of Dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        dogListModel = new DefaultListModel<>();
        dogJList.setModel(dogListModel);

        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dogName = dogNameTextField.getText();
                double dogAge;

                try {
                    dogAge = Double.parseDouble(dogAgeTextField.getText());
                    if (dogAge < 0) {
                        JOptionPane.showMessageDialog(DogGUI.this, "Enter a positive number for age");
                        return;
                    }
                }
                catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DogGUI.this, "Enter a number for age");
                    return;
                }
                boolean isPuppy = puppyCheckBox.isSelected();

                Dog newDog = new Dog(dogName, dogAge, isPuppy);
                dogListModel.addElement(newDog);
            }
        });

        deleteDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dog toDelete = dogJList.getSelectedValue();
                dogListModel.removeElement(toDelete);
            }
        });
    }
}
