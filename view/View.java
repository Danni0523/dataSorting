package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class View extends JFrame {
    // Label variables
    private JLabel titleLabel;
    private JLabel fileLabel;
    private JLabel pathLabel;
    private JLabel nameLabel;
    // Variable fields
    private JTextField nameField;
    private JTextField pathField;
    // Variable buttons
    private JButton exitButton;
    private JButton saveButton;
    private JButton resetButton;
    private JButton orderButton;
    private JButton attachButton;
    // Radio Variable Buttons
    private JRadioButton ascendingRB;
    private JRadioButton descendingRB;
    private JRadioButton heapRB;
    private JRadioButton mergeRB;
    private JRadioButton quickRB;
    // Variable button groups
    private ButtonGroup typeBG;
    private ButtonGroup algorithmBG;
    // Main panel
    private JPanel dataPanel;
    private JPanel orderPanel;
    private JPanel algorithmPanel;
    // Text field area
    private JTextArea dataText;

    // Class constructor
    public View(String titleApp) {

        // Form title
        super(titleApp);

        // Width and height
        setSize(770, 420);

        // Design type
        setLayout(null);

        ImageIcon img = new ImageIcon("img/logo.png");
        //define el icon a tu JFrame
        setIconImage(img.getImage());
        // Panel center title
        titleLabel = new JLabel(titleApp);

        // Bounding rectangle of a component(x, y, width, height)
        titleLabel.setBounds(95, 10, 200, 30);

        // Label File
        fileLabel = new JLabel("Attach file");
        fileLabel.setBounds(30, 50, 60, 30);

        // File type selection button
        attachButton = new JButton("Select file");
        attachButton.setBounds(95, 50, 250, 25);

        // Label Name
        nameLabel = new JLabel("File name");
        nameLabel.setBounds(30, 85, 60, 30);

        // Field Name
        nameField = new JTextField();
        nameField.setBounds(95, 85, 250, 30);

        // If the parameter is false, then the user cannot type into the field.
        nameField.setEditable(false);

        // Label Path
        pathLabel = new JLabel("Path");
        pathLabel.setBounds(30, 120, 60, 30);

        // Field Path
        pathField = new JTextField();
        pathField.setBounds(95, 120, 250, 30);
        pathField.setEditable(false);

        // Defining Panel Data
        Border arrangement = BorderFactory.createTitledBorder("Type of arrangement");
        orderPanel = new JPanel();
        orderPanel.setLayout(new GridLayout());
        orderPanel.setBounds(28, 155, 317, 50);
        add(orderPanel);
        orderPanel.setBorder(arrangement);

        // Order Radio Buttons
        ascendingRB = new JRadioButton("Ascending");
        ascendingRB.setBounds(80, 155, 100, 30);
        descendingRB = new JRadioButton("Descending");
        descendingRB.setBounds(190, 155, 100, 30);

        // Button Group
        typeBG = new ButtonGroup();
        typeBG.add(ascendingRB);
        typeBG.add(descendingRB);

        orderPanel.add(ascendingRB);
        orderPanel.add(descendingRB);
        // Disable button group elements
        Enumeration<AbstractButton> enumeration = typeBG.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(false);
        }

        Border algorithm = BorderFactory.createTitledBorder("Sorting algorithm");
        algorithmPanel = new JPanel();
        algorithmPanel.setLayout(new GridLayout());
        algorithmPanel.setBounds(28, 210, 317, 50);
        add(algorithmPanel);
        algorithmPanel.setBorder(algorithm);

        // Defining Order Buttons
        heapRB = new JRadioButton("Heap sort");
        heapRB.setBounds(130, 190, 70, 30);
        mergeRB = new JRadioButton("Merge sort");
        mergeRB.setBounds(200, 190, 70, 30);
        quickRB = new JRadioButton("Quick sort");
        quickRB.setBounds(270, 190, 80, 30);

        // Button Group
        algorithmBG = new ButtonGroup();
        algorithmBG.add(heapRB);
        algorithmBG.add(mergeRB);
        algorithmBG.add(quickRB);

        algorithmPanel.add(heapRB);
        algorithmPanel.add(mergeRB);
        algorithmPanel.add(quickRB);

        // Disable button group elements
        Enumeration<AbstractButton> enumerationTwo = algorithmBG.getElements();
        while (enumerationTwo.hasMoreElements()) {
            enumerationTwo.nextElement().setEnabled(false);
        }

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(30, 285, 155, 25);

        // setEnabled(false) disables the button and bttn. setEnabled(true) enables the
        // button
        resetButton.setEnabled(false);

        // Defining Save Button
        saveButton = new JButton("Save File");
        saveButton.setBounds(188, 285, 157, 25);
        saveButton.setEnabled(false);

        // Defining Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(30, 320, 315, 25);

        // Add components to the panel
        add(titleLabel);
        add(fileLabel);
        add(attachButton);
        add(nameLabel);
        add(nameField);
        add(pathLabel);
        add(pathField);
        add(exitButton);
        add(resetButton);
        add(saveButton);

        // Defining Panel Data
        dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout());
        dataPanel.setBounds(360, 20, 385, 325);
        add(dataPanel);

        // Defining Order Button
        orderButton = new JButton("Organize Archive");
        orderButton.setBounds(595, 355, 150, 20);
        orderButton.setEnabled(false);
        add(orderButton);

        // Defining Model for JTextArea
        dataText = new JTextArea();
        dataText.setBounds(250, 20, 480, 330);
        dataText.setEditable(false);
        dataPanel.add(dataText);

        // Provides a scrollable view of a lightweight component. A JScrollPane manages
        // a viewport, optional vertical and horizontal scroll bars, and optional row
        // and column heading viewports.
        JScrollPane scroll = new JScrollPane(dataText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        dataPanel.add(scroll);

        // Displaying Frame in Center of the Screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Exit program option
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // If the parameter is false then the user cannot re-size the frame.
        setResizable(false);
        // setVisible(true) is a blocking operation and blocks until dialog is closed.
        setVisible(true);
    }

    /**
     * @return JLabel return the titleLabel
     */
    public JLabel getTitleLabel() {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    /**
     * @return JLabel return the fileLabel
     */
    public JLabel getFileLabel() {
        return fileLabel;
    }

    /**
     * @param fileLabel the fileLabel to set
     */
    public void setFileLabel(JLabel fileLabel) {
        this.fileLabel = fileLabel;
    }

    /**
     * @return JLabel return the pathLabel
     */
    public JLabel getPathLabel() {
        return pathLabel;
    }

    /**
     * @param pathLabel the pathLabel to set
     */
    public void setPathLabel(JLabel pathLabel) {
        this.pathLabel = pathLabel;
    }

    /**
     * @return JLabel return the nameLabel
     */
    public JLabel getNameLabel() {
        return nameLabel;
    }

    /**
     * @param nameLabel the nameLabel to set
     */
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    /**
     * @return JTextField return the nameField
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * @param nameField the nameField to set
     */
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * @return JTextField return the pathField
     */
    public JTextField getPathField() {
        return pathField;
    }

    /**
     * @param pathField the pathField to set
     */
    public void setPathField(JTextField pathField) {
        this.pathField = pathField;
    }

    /**
     * @return JButton return the exitButton
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * @param exitButton the exitButton to set
     */
    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    /**
     * @return JButton return the saveButton
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * @param saveButton the saveButton to set
     */
    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    /**
     * @return JButton return the resetButton
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * @param resetButton the resetButton to set
     */
    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    /**
     * @return JButton return the orderButton
     */
    public JButton getOrderButton() {
        return orderButton;
    }

    /**
     * @param orderButton the orderButton to set
     */
    public void setOrderButton(JButton orderButton) {
        this.orderButton = orderButton;
    }

    /**
     * @return JButton return the attachButton
     */
    public JButton getAttachButton() {
        return attachButton;
    }

    /**
     * @param attachButton the attachButton to set
     */
    public void setAttachButton(JButton attachButton) {
        this.attachButton = attachButton;
    }

    /**
     * @return JRadioButton return the ascendingRB
     */
    public JRadioButton getAscendingRB() {
        return ascendingRB;
    }

    /**
     * @param ascendingRB the ascendingRB to set
     */
    public void setAscendingRB(JRadioButton ascendingRB) {
        this.ascendingRB = ascendingRB;
    }

    /**
     * @return JRadioButton return the descendingRB
     */
    public JRadioButton getDescendingRB() {
        return descendingRB;
    }

    /**
     * @param descendingRB the descendingRB to set
     */
    public void setDescendingRB(JRadioButton descendingRB) {
        this.descendingRB = descendingRB;
    }

    /**
     * @return JRadioButton return the mergeRB
     */
    public JRadioButton getMergeRB() {
        return mergeRB;
    }

    /**
     * @param mergeRB the mergeRB to set
     */
    public void setMergeRB(JRadioButton mergeRB) {
        this.mergeRB = mergeRB;
    }

    /**
     * @return JRadioButton return the bucketRB
     */
    public JRadioButton getHeapRB() {
        return heapRB;
    }

    /**
     * @param bucketRB the bucketRB to set
     */
    public void setBucketRB(JRadioButton heapRB) {
        this.heapRB = heapRB;
    }

    /**
     * @return JRadioButton return the countingRB
     */
    public JRadioButton getQuickRB() {
        return quickRB;
    }

    /**
     * @param countingRB the countingRB to set
     */
    public void setCountingRB(JRadioButton quickRB) {
        this.quickRB = quickRB;
    }

    /**
     * @return ButtonGroup return the typeBG
     */
    public ButtonGroup getTypeBG() {
        return typeBG;
    }

    /**
     * @param typeBG the typeBG to set
     */
    public void setTypeBG(ButtonGroup typeBG) {
        this.typeBG = typeBG;
    }

    /**
     * @return ButtonGroup return the algorithmBG
     */
    public ButtonGroup getAlgorithmBG() {
        return algorithmBG;
    }

    /**
     * @param algorithmBG the algorithmBG to set
     */
    public void setAlgorithmBG(ButtonGroup algorithmBG) {
        this.algorithmBG = algorithmBG;
    }

    /**
     * @return JPanel return the dataPanel
     */
    public JPanel getDataPanel() {
        return dataPanel;
    }

    /**
     * @param dataPanel the dataPanel to set
     */
    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel = dataPanel;
    }

        /**
     * @return JPanel return the orderPanel
     */
    public JPanel getOrderPanel() {
        return orderPanel;
    }

    /**
     * @param orderPanel the orderPanel to set
     */
    public void setOrderPanel(JPanel orderPanel) {
        this.orderPanel = orderPanel;
    }

    /**
     * @return JPanel return the algorithmPanel
     */
    public JPanel getAlgorithmPanel() {
        return algorithmPanel;
    }

    /**
     * @param algorithmPanel the algorithmPanel to set
     */
    public void setAlgorithmPanel(JPanel algorithmPanel) {
        this.algorithmPanel = algorithmPanel;
    }
    /**
     * @return JTextArea return the dataText
     */
    public JTextArea getDataText() {
        return dataText;
    }

    /**
     * @param dataText the dataText to set
     */
    public void setDataText(JTextArea dataText) {
        this.dataText = dataText;
    }
}