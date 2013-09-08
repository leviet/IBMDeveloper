package com.vnexit.fingerprint.form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vnexit.fingerprint.gaborfilter.GaborFilter;

public class Fom extends JFrame {
	private final JPanel contentPane;
	private final JFileChooser chooserImage = new JFileChooser();
	FingerImage panel = new FingerImage();
	GaborFilter panel_1 = new GaborFilter();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fom frame = new Fom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(10, 11, 248, 338);
		contentPane.add(panel);

		panel_1.setBounds(268, 11, 248, 338);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 360, 550, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnGrayChange = new JButton("Gray Change");
		btnGrayChange.setBounds(12, 75, 145, 33);
		panel_2.add(btnGrayChange);

		JButton btnNewButton = new JButton("Select Image");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String fileName = "";
				int r = chooserImage.showOpenDialog(new JFrame());
				if (r == JFileChooser.APPROVE_OPTION) {
					fileName = chooserImage.getSelectedFile().getName();
				}
				System.out.print(fileName);
				panel.rePaintLink(fileName);
				panel_1.rePaintLink(fileName);
			}
		});
		btnNewButton.setBounds(12, 12, 145, 33);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Convolution");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.Convolution();
			}
		});
		btnNewButton_1.setBounds(169, 12, 125, 33);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Increase");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.IncreaseFinger();
			}
		});
		btnNewButton_2.setBounds(169, 75, 125, 33);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Gabor Fillter");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.Gabor();
			}
		});
		btnNewButton_3.setBounds(308, 12, 133, 33);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Split Threshold");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.threshold();
			}
		});
		btnNewButton_4.setBounds(306, 75, 135, 33);
		panel_2.add(btnNewButton_4);

		JButton btnThinning = new JButton("Thinning");
		btnThinning.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_1.thinning();
			}
		});
		btnThinning.setBounds(453, 12, 117, 33);
		panel_2.add(btnThinning);
		btnGrayChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				grayChangeActionPerformed(evt);
			}
		});
	}

	protected void grayChangeActionPerformed(ActionEvent evt) {
		panel_1.tests();
	}
}
