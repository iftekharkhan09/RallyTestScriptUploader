package com.autodesk.rallyuploader.services;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.autodesk.rallyuploader.utils.Constants;


public class TestJFilePicker extends JFrame {
 
    public TestJFilePicker() {
        super("Test using JFilePicker");
         
        setLayout(new FlowLayout());
 
        // set up a file picker component
        JFilePicker filePicker = new JFilePicker(Constants.test_script_path, "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".xls", "Xls Files");
        filePicker.addFileTypeFilter(".xlsx", "Xlsx Files");
         
        // access JFileChooser class directly
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));
         
        // add the component to the frame
        add(filePicker);
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 100);
        setLocationRelativeTo(null);    // center on screen
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestJFilePicker().setVisible(true);
            }
        });
    }
 
}