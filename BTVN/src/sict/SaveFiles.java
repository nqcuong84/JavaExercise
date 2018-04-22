package sict;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;

public class SaveFiles extends JFrame {
	
	JFileChooser chooser;
	FileWriter fw;
	JTextArea txtNhap;
	FileOutputStream fos;
	OutputStreamWriter osw;
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
					SaveFiles frame = new SaveFiles();
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
	public SaveFiles() {
		setTitle("Save Files");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtNhap = new JTextArea();
		txtNhap.setBounds(10, 26, 414, 130);
		contentPane.add(txtNhap);
		
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
						String filename=chooser.getSelectedFile().getAbsolutePath()+".txt";
						//Xuất file với đường dẫn đã lấy ở trên
						fos = new FileOutputStream(filename);
						osw = new OutputStreamWriter(fos, "UTF-8");//Gõ được Tiếng Việt
						bw = new BufferedWriter(osw);//Ghi file
						bw.write(txtNhap.getText());//Write với text get được trong ô textfield
						bw.newLine();//Xuống dòng
						bw.close();
						osw.close();
						fos.close();
					}
				} catch (Exception e) {
				}
			}
		});
		btnSave.setBounds(175, 177, 89, 23);
		contentPane.add(btnSave);
		
	}
}
