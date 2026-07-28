package controller;

import exceptions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.DevilFruitCreateView;
import view.MainView;

public class DevilFruitCreateController implements ActionListener {
    MainView mainview;
    DevilFruitCreateView devilFruitCreateView;
    DevilFruitDatabase devilFruitDatabase;

    public DevilFruitCreateController(MainView mainview, DevilFruitCreateView devilFruitCreateView, DevilFruitDatabase devilFruitDatabase) {
        this.mainview = mainview;

        this.devilFruitCreateView = devilFruitCreateView;
        this.devilFruitDatabase = devilFruitDatabase;
        addActionListener();
    }

    public JPanel getFrame() {
        return devilFruitCreateView.setFrame();
    }

    public void addActionListener() {
        // Action buttons
        devilFruitCreateView.exitButton.addActionListener(this);
        devilFruitCreateView.submitButton.addActionListener(this);

        // Radio buttons para magpalit panels
        devilFruitCreateView.parameciaRadioButton.addActionListener(this);
        devilFruitCreateView.zoanRadioButton.addActionListener(this);
        devilFruitCreateView.logiaRadioButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == devilFruitCreateView.exitButton)
        {
            devilFruitCreateView.panel.setVisible(false);
            mainview.showPanel("DEVILFRUIT");
        }
        else if (e.getSource() == devilFruitCreateView.submitButton)
        {
            try {
                // Get Name and Ability
                String name = devilFruitCreateView.nameTextField.getText();
                String ability = devilFruitCreateView.abilityTextField.getText();

                if (name.isBlank())
                {
                    throw new EmptyInputException("Name cannot be empty");
                } else if (ability.isBlank())
                {
                    throw new EmptyInputException("Ability cannot be empty");
                }

                // Determine Category
                String category = "";
                if (devilFruitCreateView.parameciaRadioButton.isSelected()) category = "Paramecia";
                if (devilFruitCreateView.zoanRadioButton.isSelected()) category = "Zoan";
                if (devilFruitCreateView.logiaRadioButton.isSelected()) category = "Logia";

                // Instantiate using constructor
                DevilFruit newFruit = new DevilFruit(name, category, ability, null, new java.util.ArrayList<>());

                // Add to Database
                this.devilFruitDatabase.getAllDF().add(newFruit);
                System.out.println("Successfully added " + name + " to the Module 3 Database.");
                JOptionPane.showMessageDialog(devilFruitCreateView.panel, "Devil Fruit Created Successfully!");
                devilFruitCreateView.panel.setVisible(false);
                mainview.showPanel("DEVILFRUIT");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(devilFruitCreateView.panel, "Error: " + ex.getMessage(), "Creation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}