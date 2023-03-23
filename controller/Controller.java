package controller;

import model.Model;
import view.View;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Controller {
    private Model model;
    private View view;
    private String path;
    private String filename;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        initView();
    }

    public void initView() {
        view.getNameField().setText(model.getNameFile());
        view.getPathField().setText(model.getPathFile());
        view.getDataText().setText(model.getDataFile());
    }

    public void initController() {
        view.getAttachButton().addActionListener(e -> {
            try {
                selectFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        view.getSaveButton().addActionListener(e -> {
            try {
                save();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        view.getOrderButton().addActionListener(e -> {
            try {
                Algorithm();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        view.getResetButton().addActionListener(e -> {
            repaint();
        });
    }

    public void selectFile() throws IOException {
        // Creation of file selection window
        // Opening in the desktop folder
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // Allowed file filtering
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Excel Documents", "csv", "xlsx"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        // Condition if the file is opened
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            // Path of the selected file
            path = fileChooser.getSelectedFile().getAbsolutePath();

            // Function to display the content
            displayInfo(path);

            // File name
            filename = fileChooser.getSelectedFile().getName();

            // Put file name in the field
            view.getNameField().setText(filename);

            // Put file path in the field
            view.getPathField().setText(path);

            // Enable the order
            view.getOrderButton().setEnabled(true);

            // Enable the restart button
            view.getResetButton().setEnabled(true);

            // Enable button groups
            Enumeration<AbstractButton> enumeration = view.getTypeBG().getElements();
            while (enumeration.hasMoreElements()) {
                enumeration.nextElement().setEnabled(true);
            }
            Enumeration<AbstractButton> enumerationTwo = view.getAlgorithmBG().getElements();
            while (enumerationTwo.hasMoreElements()) {
                enumerationTwo.nextElement().setEnabled(true);
            }

        } else {
            // Condition in case of cancellation of the transaction
            JOptionPane.showMessageDialog(null, "Operation canceled by the user", "Warning",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Recursive control function
    public void Algorithm() throws IOException {
        // Filling arrangement by means of the reading method
        int arr[] = read(this.path);

        if (view.getHeapRB().isSelected()) {
            if (view.getAscendingRB().isSelected()) {
                HeapSortAs Heapas = new HeapSortAs();
                Heapas.sort(arr);
            } else {
                if (view.getDescendingRB().isSelected()) {
                    HeapSortDes Heapdes = new HeapSortDes();
                    Heapdes.sort(arr);
                }
            }
        } else {
            if (view.getMergeRB().isSelected()) {
                if (view.getAscendingRB().isSelected()) {
                    MergeSortAs Mergeas = new MergeSortAs();
                    Mergeas.sort(arr, 0, arr.length - 1);
                } else {
                    if (view.getDescendingRB().isSelected()) {
                        MergeSortDes Mergedes = new MergeSortDes();
                        Mergedes.sort(arr, 0, arr.length - 1);
                    }
                }
            } else {
                if (view.getQuickRB().isSelected()) {
                    if (view.getAscendingRB().isSelected()) {
                        QuickSortAs Quickas = new QuickSortAs();
                        Quickas.sort(arr, 0, arr.length - 1);
                    } else {
                        if (view.getDescendingRB().isSelected()) {
                            QuickSortDes Quickdes = new QuickSortDes();
                            Quickdes.sort(arr, 0, arr.length - 1);
                        }
                    }
                }
            }
        }

        // Clear the text area
        view.getDataText().setText("");

        // Fill the area with each element of the arrangement.
        for (int i = 0; i < arr.length; ++i) {
            view.getDataText().setText(view.getDataText().getText() + arr[i] + "\n");
        }
        view.getSaveButton().setEnabled(true);
    }

    // Display basic arrangement information
    public void displayInfo(String path) {
        // Error control
        try {
            FileReader reader = new FileReader(path);
            try (BufferedReader br = new BufferedReader(reader)) {
                String line = br.readLine();
                // Text area writing
                view.getDataText().setText("");
                while (line != null) {
                    view.getDataText().append(line + "\n");
                    line = br.readLine();
                }
            }
            view.getDataText().requestFocus();
        } catch (IOException e) {
            // Show sample errors
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Reading data by means of an array list
    public static int[] read(String path) throws IOException {
        // Arrangement list creation
        ArrayList<Integer> lines = new ArrayList<>();

        // Error control
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;

            // Line-by-line reading for insertion
            while ((line = br.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }

            // Pass data from the array list to the array
            int[] arrTemp = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                arrTemp[i] = lines.get(i);
            }

            // Return temporary arrangement
            return arrTemp;
        }
    }

    // File save function
    public void save() throws IOException {
        // Desktop window
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int retval = fileChooser.showSaveDialog(null);

        String extension = "";

        // Iteration process to obtain the sub string of the file by file extension
        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        }

        // revision conditions according to the file
        if (retval == JFileChooser.APPROVE_OPTION) {
            // Selected file
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith("." + extension)) {
                // Save file with name and extension
                file = new File(file.getParentFile(), file.getName() + "." + extension);
            }
            try {
                // Write the content
                BufferedWriter bf = new BufferedWriter(new FileWriter(file));
                bf.write(view.getDataText().getText());
                bf.flush();
                bf.close();
                // view.getDataText().write(new OutputStreamWriter(new FileOutputStream(file),
                // "utf-8"));

                // Open file
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                // Possible file errors
                e.getStackTrace();
            }
        }
    }

    public void repaint(){
        view.getNameField().setText("You have not selected a file");
        view.getPathField().setText("You have not selected a file");

        view.getTypeBG().clearSelection();
        view.getAlgorithmBG().clearSelection();
        view.getDataText().setText("Please select a file to view its contents and organize it.");
        view.getSaveButton().setEnabled(false);
        view.getOrderButton().setEnabled(false);
    }
}