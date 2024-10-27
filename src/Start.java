import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

public class Start {
    private JPanel panelStart;
    private JLabel lblHospital;
    private JButton buttonAddPatients;
    private JButton buttonNextPatient;
    private JButton buttonViewQueue;

    private PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

    public Start() {
        panelStart = new JPanel();
        lblHospital = new JLabel("Patient Management System", SwingConstants.CENTER);
        lblHospital.setFont(new Font("Arial", Font.BOLD, 24));
        buttonAddPatients = new JButton("Add Patients");
        buttonNextPatient = new JButton("Next Patient");
        buttonViewQueue = new JButton("View Queue");

        panelStart.setLayout(new GridLayout(4, 1, 10, 10));
        panelStart.add(lblHospital);
        panelStart.add(buttonAddPatients);
        panelStart.add(buttonNextPatient);
        panelStart.add(buttonViewQueue);

        buttonAddPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register(patientQueue);
            }
        });

        buttonNextPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!patientQueue.isEmpty()) {
                    Patient nextPatient = patientQueue.poll();
                    JOptionPane.showMessageDialog(null, "Next patient: " + nextPatient.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No patients in the queue.");
                }
            }
        });

        buttonViewQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewQueue(patientQueue);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Patient Management System");
        Start startForm = new Start();
        frame.setContentPane(startForm.panelStart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
