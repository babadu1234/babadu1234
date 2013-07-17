package com.babadu1234.TextEditor.GUI;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Form extends JFrame {

	String currentFileDirectory = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setTitle("Annointed's Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								632, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE));

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setMargin(new Insets(2, 2, 2, 2));
		contentPane.setLayout(gl_contentPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileTab = new JMenu("File");
		fileTab.setFocusable(false);
		menuBar.add(fileTab);

		JMenuItem newFile = new JMenuItem("New File");
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		fileTab.add(newFile);

		JMenuItem openFile = new JMenuItem("Open File");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		fileTab.add(openFile);

		JMenuItem saveFile = new JMenuItem("Save File");
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		fileTab.add(saveFile);

		JMenuItem saveAs = new JMenuItem("Save As");
		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
		saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		fileTab.add(saveAs);

		JMenuItem exitButton = new JMenuItem("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitProgram();
			}
		});
		fileTab.add(exitButton);
	}

	private void newFile() {
		textArea.setText("");
		currentFileDirectory = "";
	}

	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(
				"Text File", "txt");
		fileChooser.setFileFilter(extensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		File toBeOpenedFile = fileChooser.getSelectedFile();
		try {
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				BufferedReader br = new BufferedReader(new FileReader(
						toBeOpenedFile));
				currentFileDirectory = "";
				textArea.setText("");
				currentFileDirectory = toBeOpenedFile.getAbsolutePath();
				String data;
				while ((data = br.readLine()) != null) {
					textArea.append(data + "\n");
					br.close();
				}
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
	}

	private void saveFile() {
		if ("".equals(currentFileDirectory)) {
			JFileChooser saveFileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(
					"Text File", "txt");
			saveFileChooser.setFileFilter(extensionFilter);
			int returnValue = saveFileChooser.showSaveDialog(null);
			try {
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File fileDirectory = saveFileChooser.getCurrentDirectory();
					String path = fileDirectory.getAbsolutePath();
					String fileName = saveFileChooser.getSelectedFile()
							.getName();
					if (!fileName.contains(".txt")) {
						fileName = fileName + ".txt";
					}
					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream(path
									+ "\\" + fileName), "UTF-8"));
					currentFileDirectory = path + "\\" + fileName;
					bw.write(textArea.getText());
					bw.close();
					JOptionPane.showMessageDialog(null, fileName
							+ " has been saved");
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "ERROR!");
			}
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(currentFileDirectory), "UTF-8"));
				bw.write(textArea.getText());
				bw.close();
			} catch (IOException e) {

			}
		}
	}

	private void saveAs() {
		JFileChooser saveFileChooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(
				"Text File", "txt");
		saveFileChooser.setFileFilter(extensionFilter);
		int returnValue = saveFileChooser.showSaveDialog(null);
		try {
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File fileDirectory = saveFileChooser.getCurrentDirectory();
				String path = fileDirectory.getAbsolutePath();
				String fileName = saveFileChooser.getSelectedFile().getName();
				if (!fileName.contains(".txt")) {
					fileName = fileName + ".txt";
				}
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(path + "\\" + fileName), "UTF-8"));
				currentFileDirectory = path + "\\" + fileName;
				bw.write(textArea.getText());
				bw.close();
				JOptionPane.showMessageDialog(null, fileName
						+ " has been saved");
			}
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(null, "ERROR!");
		}
	}

	private void exitProgram() {
		System.exit(0);
	}

}
