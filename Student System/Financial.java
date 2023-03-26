import javax.swing.*;

public class Financial extends JFrame {
    private JPanel financialPanel;
    private JButton feeStructureButton;
    private JButton balanceButton;
    private JButton hostelsButton;

    public Financial(){
        setTitle("Financials");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        financialPanel = new JPanel();
        financialPanel.setLayout(new BoxLayout(financialPanel, BoxLayout.Y_AXIS));

        feeStructureButton = new JButton("Fee Structure");
        //flex code
        financialPanel.add(feeStructureButton);
//        feeStructureButton.addActionListener(e -> {
//            FeeStructure feeStructurewindow = new FeeStructure();
//            feeStructurewindow.setVisible(true);
//        });

        balanceButton = new JButton("Fee Balance");
        financialPanel.add(balanceButton);
        balanceButton.addActionListener(e -> {
        });

        hostelsButton = new JButton("Hostels");
        financialPanel.add(hostelsButton);
        hostelsButton.addActionListener(e -> {

        });

        add(financialPanel);
        pack();
        setVisible(true);
    }

}
