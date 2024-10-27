import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

public class ViewQueue extends JFrame {
    private JTextArea textAreaQueue;
    private JPanel panelQueue;
    private JButton buttonBack;

    public ViewQueue(PriorityQueue<Patient> patientQueue) {
        textAreaQueue = new JTextArea();
        buttonBack = new JButton("Back");
        panelQueue = new JPanel();

        setTitle("View Queue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        textAreaQueue.setEditable(false);
        textAreaQueue.setLineWrap(true);
        textAreaQueue.setWrapStyleWord(true);


        StringBuilder queueText = new StringBuilder();
        for (Patient patient : patientQueue) {
            queueText.append(patient.toString()).append("\n");
        }
        textAreaQueue.setText(queueText.toString());


        panelQueue.setLayout(new BorderLayout());
        panelQueue.add(new JScrollPane(textAreaQueue), BorderLayout.CENTER);
        panelQueue.add(buttonBack, BorderLayout.SOUTH);

        add(panelQueue);
        setVisible(true);


        buttonBack.addActionListener(e -> dispose());
    }
}
