package com.vnexit.fingerprint.form;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainForm extends JFrame{
	private JButton selectImage=new JButton();
    private JFileChooser chooserImage = new JFileChooser();
    private FingerImage oldFinger = new FingerImage("/home/phoenix/Downloads/tim.jpg");
    private FingerImage newFinger = new FingerImage("/home/phoenix/Downloads/tim.jpg");
    private JPanel pFunction=new JPanel();
    
    public MainForm(String title){
    	
    	super(title);
    	selectImage.setText("Select Finger");
    	selectImage.setSize(100, 20);
    	selectImage.setBounds(240, 50, 100, 25);
    	selectImage.setBorderPainted(false);
    	selectImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	selectImageActionPerformed(evt);
            }
        });
    	pFunction.add(selectImage,BorderLayout.EAST);
    	add(pFunction,BorderLayout.PAGE_START);
    	add(oldFinger,BorderLayout.CENTER);
    }
    protected void selectImageActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	String fileName="";
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
    	chooserImage.setFileFilter(filter);
    	int r = chooserImage.showOpenDialog(new JFrame());
    	if (r == JFileChooser.APPROVE_OPTION) {
    		fileName = chooserImage.getSelectedFile().getPath();
    	}
    	System.out.print(fileName);
    	oldFinger=new FingerImage(fileName);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MainForm mF=new MainForm("Hệ thống nhận dạng vân tay V1.1-Lê Văn Việt");
    	mF.setSize(500,500);
    	mF.show();
	}
}
