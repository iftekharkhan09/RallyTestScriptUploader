package com.autodesk.rallyuploader.services;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/*public class TestLayout17 {

	public static void main(String[] args) {
		new TestLayout17();
	}

	public TestLayout17() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}*/

	public class TestPane extends JPanel {

		public TestPane() {
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.insets = new Insets(2, 2, 2, 2);

			add(new JLabel("Display Color"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Expedite"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Ready"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			
			
			gbc.gridx++;
			add(new JLabel("Last Result"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			
			gbc.gridx = 0;
			gbc.gridy++;
			add(new JLabel("Notes"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Owner"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("User Story"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);

			gbc.gridx = 0;
			gbc.gridy++;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy++;
			add(new JLabel("Type"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Method"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Priority"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Risk"), gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Package"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Pre Conditions"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Post Conditions"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Last Verdict"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Last Build"), gbc);
			gbc.gridx++;
			add(new JTextField(20), gbc);
			gbc.gridx++;
			add(new JLabel("Last Run"), gbc);

			gbc.gridx = 0;
			gbc.gridy++;
			gbc.fill = GridBagConstraints.NONE;
			gbc.gridwidth = 2;
			add(new JButton("Click"), gbc);

		}

	}
