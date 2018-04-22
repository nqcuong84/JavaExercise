package sict;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Bai3 extends JFrame {

	JFileChooser chooser;
	JTextArea txtNhap;
	JButton btnOpen;
	JButton btnSave;
	FileInputStream fis;
	FileOutputStream fos;
	OutputStreamWriter osw;
	InputStreamReader isr;
	BufferedReader br;
	BufferedWriter bw;
	final JFrame frame=new JFrame();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai3 frame = new Bai3();
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
	public Bai3() {
		setTitle("Chương trình đọc file");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtNhap = new JTextArea();
		txtNhap.setBounds(10, 11, 629, 322);
		contentPane.add(txtNhap);
		
		JButton btnOpen = new JButton("Open Files");
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));//Lấy thư mục hiện hành
				chooser.setDialogTitle("Open File");
				try {
					int result = chooser.showOpenDialog(frame);
					if(result==JFileChooser.APPROVE_OPTION)//Lựa chọn
					{
						String filename=chooser.getSelectedFile().getAbsolutePath();
						txtNhap.setText("");
						fis = new FileInputStream(filename);
						isr = new InputStreamReader(fis,"UTF-8");
						br = new BufferedReader(isr);
						txtNhap.read(br, null);
//						while(br.readLine()!=null)
//						{
//							txtNhap.append(br.readLine()+"\n");
//						}
						br.close();
						isr.close();
						fis.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnOpen.setBounds(10, 360, 111, 23);
		contentPane.add(btnOpen);
		
		JButton btnSave = new JButton("Save As");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));//Lấy thư mục hiện hành
				chooser.setDialogTitle("Save File");
				try {
					int result = chooser.showSaveDialog(frame);
					if(result==JFileChooser.APPROVE_OPTION)//Lựa chọn
					{
						//Lấy tên tệp
						String filename=chooser.getSelectedFile().getAbsolutePath();
						//Xuất file với đường dẫn đã lấy ở trên
						fos = new FileOutputStream(filename);
						osw = new OutputStreamWriter(fos, "UTF-8");
						bw = new BufferedWriter(osw);
						bw.write(txtNhap.getText());
						bw.close();
						osw.close();
						fos.close();
					}
				} catch (Exception e) {
				}
			}
		});
		btnSave.setBounds(534, 360, 105, 23);
		contentPane.add(btnSave);
	}
}
