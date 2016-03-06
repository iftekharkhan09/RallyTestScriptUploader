package com.autodesk.rallyuploader.services;

import java.awt.*;

import javax.swing.*;

import com.autodesk.rallyuploader.utils.Constants;

public class SplashScreen extends JWindow {
  private int duration;
  public SplashScreen(int d) {
  	
  	JPanel panel = new JPanel();
  	getContentPane().add(panel, BorderLayout.CENTER);
  	panel.setLayout(new BorderLayout(0, 0));
    duration = d;
  }
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    // Set the window's bounds, centering the window
    int width = 394;
    int height =320;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);
    GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	content.setLayout(gridBagLayout);
	
	JLabel lblNewLabel = new JLabel(Constants.splash_message);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 0;
	content.add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel(Constants.developer_identity+Constants.author_name);
	GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
	gbc_lblNewLabel_1.gridx = 0;
	gbc_lblNewLabel_1.gridy = 5;
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	content.add(lblNewLabel_1, gbc_lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel(Constants.version);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	gbc_lblNewLabel_2.insets = new Insets(0, 0, 1, 0);
	gbc_lblNewLabel_2.gridx = 0;
	gbc_lblNewLabel_2.gridy = 1;
	content.add(lblNewLabel_2, gbc_lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel(Constants.application_loading);
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
	gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
	gbc_lblNewLabel_3.gridx = 0;
	gbc_lblNewLabel_3.gridy = 3;
	content.add(lblNewLabel_3, gbc_lblNewLabel_3);
	
	JLabel loading_image = new JLabel(new ImageIcon("src/main/resources/loading.gif"));
	GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
	gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel_4.gridx = 0;
	gbc_lblNewLabel_4.gridy = 4;
	content.add(loading_image, gbc_lblNewLabel_4);
   
    Color oraRed = new Color(200, 200, 200,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }

  public void showSplashScreen() {
    showSplash();
  }
}
