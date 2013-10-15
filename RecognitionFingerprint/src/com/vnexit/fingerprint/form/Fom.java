package com.vnexit.fingerprint.form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vnexit.fingerprint.gaborfilter.GaborFilter;
import com.vnexit.fingerprint.svm.svm_predict;

public class Fom extends JFrame {
	private final JPanel contentPane;
	private final JFileChooser chooserImage = new JFileChooser();
	FingerImage panel = new FingerImage();
	GaborFilter panel_1 = new GaborFilter();
	String[] dataDuyAnh = new String[20];
	String[] dataHuy = new String[20];
	String[] dataQuang = new String[20];
	String[] dataDuong = new String[20];
	String[] dataViet = new String[20];
	String name;

	public void genData() {
		for (int i = 0; i < 10; i++) {
			String anhl = "anh_l_1" + i;
			dataDuyAnh[i] = anhl;
			String anhr = "anh_r_1" + i;
			dataDuyAnh[i + 10] = anhr;
			String huy1 = "huy_r_1" + i;
			dataHuy[i] = huy1;
			String huy2 = "huy_r_2" + i;
			dataHuy[i + 10] = huy2;
			String duong1 = "duong_l_1" + i;
			dataDuong[i] = duong1;
			String duong2 = "duong_l_2" + i;
			dataDuong[i + 10] = duong2;
			String quang1 = "quang_r_1" + i;
			dataQuang[i] = quang1;
			String quang2 = "quang_r_2" + i;
			dataQuang[i + 10] = quang2;
			String vietl = "viet_l_1" + i;
			dataViet[i] = vietl;
			String vietr = "viet_r_1" + i;
			dataViet[i + 10] = vietr;
		}
	}

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
		setBounds(100, 100, 992, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(10, 11, 329, 356);
		contentPane.add(panel);

		panel_1.setBounds(349, 11, 328, 356);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 469, 936, 120);
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
				try {
					panel_1.thinning();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnThinning.setBounds(453, 12, 117, 33);
		panel_2.add(btnThinning);

		JButton btnNewButton_5 = new JButton("Extract Featrured");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					panel_1.extractFeatured();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(451, 75, 119, 33);
		panel_2.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Canny");
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.CannyEdge();
			}
		});
		btnNewButton_6.setBounds(580, 12, 131, 33);
		panel_2.add(btnNewButton_6);

		JButton btnRunData = new JButton("Run Data");
		btnRunData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					runData();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRunData.setBounds(582, 71, 129, 33);
		panel_2.add(btnRunData);

		JButton btnNewButton_7 = new JButton("Create File");
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					exportDataArff();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setBounds(732, 12, 145, 39);
		panel_2.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("Match");
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if ("no".equals(Match())) {
						JOptionPane.showMessageDialog(null, "Khong tim thay doi tuong trong he thong");
					} else {
						JOptionPane.showMessageDialog(null, "Tim thay doi tuong: " + Match());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_8.setBounds(723, 63, 154, 45);
		panel_2.add(btnNewButton_8);
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

	public void runData() throws FileNotFoundException {
		genData();
		List<String[]> listData = new LinkedList<String[]>();
		listData.add(dataDuong);
		listData.add(dataDuyAnh);
		listData.add(dataHuy);
		listData.add(dataQuang);
		// listData.add(dataViet);
		for (String[] item : listData) {
			for (int i = 0; i < 20; i++) {
				panel.rePaintLink(item[i] + ".jpg");
				panel_1.rePaintLink(item[i] + ".jpg");
				runFuntion();
			}
		}
	}

	public void runFuntion() throws FileNotFoundException {
		panel_1.tests();
		panel_1.Gabor();
		panel_1.threshold();
		panel_1.thinning();
		panel_1.extractFeatured();
	}

	public void exportDataArff() throws IOException {
		genData();
		List<String[]> listData = new LinkedList<String[]>();
		listData.add(dataDuong);
		listData.add(dataDuyAnh);
		listData.add(dataHuy);
		listData.add(dataQuang);
		listData.add(dataViet);
		for (String[] item : listData) {
			FileOutputStream outFile = new FileOutputStream(new File("./newdata/tonghop/" + item[0]));
			PrintStream out = new PrintStream(outFile);
			for (int i = 0; i < 20; i++) {
				BufferedReader reader = new BufferedReader(new FileReader("./newdata/" + item[i] + ".jpg.train"));
				out.println(reader.readLine());
				reader.close();
			}
			out.close();
		}
	}

	public String Match() throws IOException {
		String[] dataBase = { "VietTrain.arff.model", "AnhTrain.arff.model", "DuongTrain.arff.model", "HuyTrain.arff.model", "QuangTrain.arff.model" };
		String res = "no";
		int k = 0;
		while ("no".equals(res) && k < 5) {
			String[] options = { "./newdata/" + panel_1.name + ".train", dataBase[k], "testN.out" };
			svm_predict t = new svm_predict();
			t.main(options);
			BufferedReader reader = new BufferedReader(new FileReader("testN.out"));
			String resStr = reader.readLine();
			if (Double.parseDouble(resStr) > 0) {
				res = dataBase[k];
			}
			k++;
			reader.close();
		}
		return res;
	}
}
