package com.vnexit.fingerprint.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.vnexit.fingerprint.gaborfilter.GaborFilter;

public class Fom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

		JPanel panel = new GaborFilter();
		panel.setBounds(10, 11, 248, 338);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(268, 11, 248, 338);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 360, 506, 120);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnGrayChange = new JButton("Gray Change");
		btnGrayChange.setBounds(10, 11, 95, 23);
		panel_2.add(btnGrayChange);
		btnGrayChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				grayChangeActionPerformed(evt);
			}
		});
	}

	protected void grayChangeActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	}
}
