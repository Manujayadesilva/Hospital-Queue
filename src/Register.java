import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

public class Register extends JFrame {
    private JLabel lblName;
    private JPanel panelRegister;
    private JLabel lblAge;
    private JLabel lblPriority;
    private JTextField textName;
    private JTextField textAge;
    private JComboBox<String> comboPriority;
    private JButton buttonSubmit;
    private JButton buttonBack;

    public Register(PriorityQueue<Patient> patientQueue) {
        lblName = new JLabel("Name:");
        lblAge = new JLabel("Age:");
        lblPriority = new JLabel("Priority:");
        textName = new JTextField(15);
        textAge = new JTextField(15);
        comboPriority = new JComboBox<>(new String[]{
                "(1) Immediate - life-threatening",
                "(2) Very urgent",
                "(3) Urgent",
                "(4) Standard"
        });
        buttonSubmit = new JButton("Submit");
        buttonBack = new JButton("Back");
        panelRegister = new JPanel();

        panelRegister.setLayout(new GridLayout(5, 2, 10, 10));
        panelRegister.add(lblName);
        panelRegister.add(textName);
        panelRegister.add(lblAge);
        panelRegister.add(textAge);
        panelRegister.add(lblPriority);
        panelRegister.add(comboPriority);
        panelRegister.add(buttonSubmit);
        panelRegister.add(buttonBack);

        setTitle("Register Patient");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panelRegister);
        setVisible(true);

        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                int age = Integer.parseInt(textAge.getText());
                int priority = Integer.parseInt(comboPriority.getSelectedItem().toString().substring(1, 2));

                Patient newPatient = new Patient(name, age, priority);
                patientQueue.add(newPatient);

                JOptionPane.showMessageDialog(null, "Patient added to queue successfully!");
                dispose();
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
