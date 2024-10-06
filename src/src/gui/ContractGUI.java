package gui;

import program.Contract;
import program.Customer;
import program.Manager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractGUI extends JFrame {
    private JTextField contractIdField;
    private JTextField managerNameField;
    private JTextField customerNameField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTable contractTable;
    private DefaultTableModel tableModel;
    private List<Contract> contracts;

    public ContractGUI() {
        contracts = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Contract Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel contractIdLabel = new JLabel("Contract ID:");
        contractIdField = new JTextField();
        JLabel managerNameLabel = new JLabel("Manager Name:");
        managerNameField = new JTextField();
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField();
        JLabel startDateLabel = new JLabel("Start Date:");
        startDateField = new JTextField();
        JLabel endDateLabel = new JLabel("End Date:");
        endDateField = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveContract());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteContract());

        inputPanel.add(contractIdLabel);
        inputPanel.add(contractIdField);
        inputPanel.add(managerNameLabel);
        inputPanel.add(managerNameField);
        inputPanel.add(customerNameLabel);
        inputPanel.add(customerNameField);
        inputPanel.add(startDateLabel);
        inputPanel.add(startDateField);
        inputPanel.add(endDateLabel);
        inputPanel.add(endDateField);

        tableModel = new DefaultTableModel(new Object[]{"Contract ID", "Manager Name", "Customer Name", "Start Date", "End Date"}, 0);
        contractTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contractTable);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void saveContract() {
        int contractId = Integer.parseInt(contractIdField.getText());
        String managerName = managerNameField.getText();
        String customerName = customerNameField.getText();
        String startDateString = startDateField.getText();
        String endDateString = endDateField.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);
            Manager manager = new Manager(managerName, "");
            Customer customer = new Customer(customerName, "", "");
            Contract contract = new Contract(contractId, manager, customer, startDate, endDate);
            contracts.add(contract);
            updateContractTable();
            JOptionPane.showMessageDialog(this, "Contract saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving contract: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    private void deleteContract() {
        int selectedRow = contractTable.getSelectedRow();
        if (selectedRow >= 0) {
            contracts.remove(selectedRow);
            updateContractTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a contract to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateContractTable() {
        tableModel.setRowCount(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Contract contract : contracts) {
            Object[] rowData = {contract.getContractId(), contract.getManager().getName(),
                    contract.getCustomer().getName(), dateFormat.format(contract.getStartDate()),
                    dateFormat.format(contract.getEndDate())};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContractGUI contractGUI = new ContractGUI();
            contractGUI.setVisible(true);
        });
    }
}