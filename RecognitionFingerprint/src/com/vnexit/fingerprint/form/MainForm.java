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

import com.vnexit.fingerprint.gaborfilter.GaborFilter;

public class MainForm extends JFrame{
	private JButton selectImage=new JButton();
    private JFileChooser chooserImage = new JFileChooser();
    private FingerImage oldFinger = new FingerImage();
    private GaborFilter newFinger = new GaborFilter();
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
//    	add(newFinger,BorderLayout.CENTER);
    }
    protected void selectImageActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
    	String fileName="";
    	int r = chooserImage.showOpenDialog(new JFrame());
    	if (r == JFileChooser.APPROVE_OPTION) {
    		fileName = chooserImage.getSelectedFile().getName();
    	}
    	System.out.print(fileName);
    	oldFinger.rePaintLink(fileName);
//    	newFinger.rePaintLink(fileName);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MainForm mF=new MainForm("Hệ thống nhận dạng vân tay V1.1-Lê Văn Việt");
    	mF.setSize(500,500);
    	mF.show();
	}
}
