package fstm.projet.view;

import com.toedter.calendar.JDateChooser;
import fstm.projet.controller.Diagnostic_CTR;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author noureddine
 */
public class FRCreerCom extends JFrame {

    private final JTextField textField;
    private final JTextField textField_1;
    private final JTextField textField_2;
    private final JTextField textField_3;
    private final JRadioButton rdbtnNewRadioButton_1;
    private final JRadioButton rdbtnNewRadioButton;
    private final JDateChooser dateChooser;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FRCreerCom frame = new FRCreerCom();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public FRCreerCom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nom");
        lblNewLabel.setBounds(23, 31, 45, 13);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(173, 28, 149, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Prenom");
        lblNewLabel_1.setBounds(23, 65, 45, 13);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(173, 62, 149, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Sexe");
        lblNewLabel_2.setBounds(23, 103, 45, 13);
        contentPane.add(lblNewLabel_2);

        rdbtnNewRadioButton = new JRadioButton("Femme");
        rdbtnNewRadioButton.setBounds(175, 99, 85, 21);
        contentPane.add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("Homme");
        rdbtnNewRadioButton_1.setBounds(262, 99, 103, 21);
        contentPane.add(rdbtnNewRadioButton_1);

        JLabel lblDateDeNaissance = new JLabel("Date de naissance");
        lblDateDeNaissance.setBounds(23, 138, 103, 13);
        contentPane.add(lblDateDeNaissance);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(168, 138, 154, 19);
        contentPane.add(dateChooser);

        JLabel lblNewLabel_3 = new JLabel("Email");
        lblNewLabel_3.setBounds(23, 170, 45, 13);
        contentPane.add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(168, 167, 154, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Password");
        lblNewLabel_4.setBounds(23, 199, 45, 13);
        contentPane.add(lblNewLabel_4);

        textField_3 = new JTextField();
        textField_3.setBounds(168, 196, 154, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("Ajouter");
        btnNewButton.addActionListener(e -> {
            Calendar date;
            Boolean sexe = null;
            String nomString = textField.getText();
            String preString = textField_1.getText();
            if (rdbtnNewRadioButton.isSelected()) {
                sexe = true;
            }
            if (rdbtnNewRadioButton_1.isSelected()) {
                sexe = false;
            }
            date = dateChooser.getCalendar();
            String emailString = textField_2.getText();
            String passString = textField_3.getText();

            try {
                Diagnostic_CTR.insertClient(nomString, preString, sexe, date, emailString, passString);
            } catch (ClassNotFoundException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            new Authen().setVisible(true);


        });
        btnNewButton.setBounds(137, 232, 85, 21);
        contentPane.add(btnNewButton);
    }
}
