import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
public class Frame1 {

	private JFrame frmIt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static int pushUps;
	private static int plankMins;
	private static int curls;
	private static int weight;
	private static String email = "";
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmIt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIt = new JFrame();
		frmIt.setTitle("IT391 Work Out Logger");
		frmIt.setBounds(100, 100, 1038, 590);
		frmIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIt.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 11, 139, 146);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setToolTipText("");
		frmIt.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(29, 69, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPushUps = new JLabel("Push Ups");
		lblPushUps.setHorizontalAlignment(SwingConstants.CENTER);
		lblPushUps.setBounds(29, 23, 86, 14);
		panel.add(lblPushUps);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(47, 266, 139, 146);
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmIt.getContentPane().add(panel_1);
		
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(29, 69, 86, 20);
		panel_1.add(textField_1);
		
		JLabel lblPlank = new JLabel("Plank");
		lblPlank.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlank.setBounds(29, 23, 86, 14);
		panel_1.add(lblPlank);
		
		JLabel totalPlanks = new JLabel("");
		totalPlanks.setHorizontalAlignment(SwingConstants.CENTER);
		totalPlanks.setBounds(29, 48, 86, 14);
		panel_1.add(totalPlanks);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(196, 266, 139, 146);
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmIt.getContentPane().add(panel_2);
		
		
		
		JLabel lblRestDay = new JLabel("Rest Day");
		lblRestDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestDay.setBounds(29, 23, 86, 14);
		panel_2.add(lblRestDay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(196, 11, 139, 146);
		panel_3.setLayout(null);
		panel_3.setToolTipText("");
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmIt.getContentPane().add(panel_3);
		
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(29, 69, 86, 20);
		panel_3.add(textField_2);
		
		JLabel lblCurls = new JLabel("Curls");
		lblCurls.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurls.setBounds(29, 23, 86, 14);
		panel_3.add(lblCurls);
		
		JLabel totalCurls = new JLabel("");
		totalCurls.setHorizontalAlignment(SwingConstants.CENTER);
		totalCurls.setBounds(29, 44, 86, 14);
		panel_3.add(totalCurls);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(398, 11, 592, 401);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmIt.getContentPane().add(scrollPane);
		
		JLabel totalPushUps = new JLabel("");
		totalPushUps.setHorizontalAlignment(SwingConstants.CENTER);
		totalPushUps.setBounds(29, 48, 86, 14);
		panel.add(totalPushUps);
		
		
		JTextArea txtrTest = new JTextArea();
		scrollPane.setViewportView(txtrTest);
		txtrTest.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrTest.setEditable(false);
		txtrTest.setText("Work Outs");
		fulfill(txtrTest);
		
		JButton PUBtn = new JButton("Log");
		PUBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")) {
					System.out.println("Enter a number");
				}
				else {
					if(isNumeric(textField.getText())) {
						String workOut = java.time.LocalDate.now().toString() + ": " + textField.getText() + " Push Ups.";
						addition( workOut, txtrTest);
						int pups = Integer.valueOf(textField.getText());
						pushUps += pups;
						totalPushUps.setText(String.valueOf(pushUps));
						setStats();
						textField.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter a whole number","Invalid Input",1);
					}
				}
			}
		});
		PUBtn.setBounds(29, 100, 86, 23);
		panel.add(PUBtn);
		
		JButton CBtn = new JButton("Log");
		CBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2.getText().equals("")) {
					System.out.println("Enter a number");
				}
				else {
					if(isNumeric(textField_2.getText())) {
						String workOut = java.time.LocalDate.now().toString() + ": " + textField_2.getText() + " Curls.";
						addition( workOut, txtrTest);
						int cus = Integer.valueOf(textField_2.getText());
						curls += cus;
						totalCurls.setText(String.valueOf(curls));
						setStats();
						textField_2.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter a whole number","Invalid Input",1);
					}
				}
			}
		});
		CBtn.setBounds(29, 100, 86, 23);
		panel_3.add(CBtn);
		
		JButton RBtn = new JButton("Log");
		RBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String workOut = java.time.LocalDate.now().toString() + ": Rest Day.";
				addition( workOut, txtrTest);
			}
		});
		RBtn.setBounds(29, 100, 86, 23);
		panel_2.add(RBtn);
		
		
		JButton PBtn = new JButton("Log");
		PBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals("")) {
					System.out.println("Enter a number");
				}
				else {
					if(isNumeric(textField_1.getText())) {
						String workOut = java.time.LocalDate.now().toString() + ": " + textField_1.getText() + " Plank Minutes.";
						addition( workOut, txtrTest);
						int pms = Integer.valueOf(textField_1.getText());
						plankMins += pms;
						totalPlanks.setText(String.valueOf(plankMins));
						setStats();
						textField_1.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter a whole number","Invalid Input",1);
					}
				}
			}
		});
		PBtn.setBounds(29, 100, 86, 23);
		panel_1.add(PBtn);
		
	
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(47, 168, 288, 83);
		frmIt.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(55, 50, 86, 20);
		textField_3.setColumns(10);
		panel_4.add(textField_3);
		
	
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(102, 11, 86, 14);
		panel_4.add(lblWeight);
		
		JLabel currentWeight = new JLabel("");
		currentWeight.setHorizontalAlignment(SwingConstants.CENTER);
		currentWeight.setBounds(102, 25, 86, 14);
		panel_4.add(currentWeight);
		JButton button = new JButton("Log");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_3.getText().equals("")) {
					System.out.println("Enter a number");
				}
				else {
					
					if(isNumeric(textField_3.getText())){
						String workOut = java.time.LocalDate.now().toString() + ": " + textField_3.getText() + " Pounds.";
						addition( workOut, txtrTest);
						currentWeight.setText(textField_3.getText());
						weight = Integer.valueOf(textField_3.getText());
						setStats();
						textField_3.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null,"Please enter a whole number","Invalid Input",1);
					}
				}
			}
		});
		button.setBounds(151, 49, 86, 23);
		panel_4.add(button);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setToolTipText("");
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(47, 423, 288, 99);
		frmIt.getContentPane().add(panel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(29, 36, 233, 20);
		panel_5.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(98, 11, 86, 14);
		panel_5.add(lblEmail);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(29, 48, 86, 14);
		panel_5.add(label_1);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inp = textField_4.getText();
				if(inp.equals("")) {
					System.out.println("Please enter an email");
				}
				else {
					String check = isEmail(inp);
					if(check.equals("a")) {
						email = inp;
						addition("Email set as: " + inp, txtrTest);
						setStats();
					}
					else {
						JOptionPane.showMessageDialog(null,"Email does not contain: " + check,"Invalid Email",1);
					}
					
				}
			}
		});
		btnSet.setBounds(98, 67, 86, 23);
		panel_5.add(btnSet);
		
		
		
		init();
		getStats(totalPushUps, totalCurls, totalPlanks, currentWeight, textField_4 );
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(398, 423, 592, 99);
		frmIt.getContentPane().add(tabbedPane);
		
		textField_5 = new JTextField();
		tabbedPane.addTab("Last Goal", null, textField_5, null);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		tabbedPane.addTab("Future Goal", null, textField_6, null);
		textField_6.setColumns(10);
	}
	
	
	//initializes the two text files
	public static void init() {
		try {
		      File myObj = new File("filename.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
		      File myObj = new File("stats.txt");
		      if (myObj.createNewFile()) {
		    	  setStats();
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  
    }
	
	
	//takes lines from the stats file and assigns them to private variables
	public static void getStats(JLabel totalPushUps, JLabel totalCurls, JLabel totalPlanks, JLabel currentWeight, JTextField textField_4) {
		try {
            FileReader reader = new FileReader("stats.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            int x= 0;
 
            while ((line = bufferedReader.readLine()) != null) {
            	if(x == 0) {
            		pushUps = Integer.valueOf(line);
            		totalPushUps.setText(String.valueOf(pushUps));
            	}
            	if(x == 1) {
            		plankMins = Integer.valueOf(line);
            		totalPlanks.setText(String.valueOf(plankMins));
            		
            	}
            	if(x == 2) {
            		curls = Integer.valueOf(line);
            		totalCurls.setText(String.valueOf(curls));
            	}
            	if(x==3) {
            		weight = Integer.valueOf(line);
            		currentWeight.setText(String.valueOf(weight));
            	}
            	if(x == 4) {
            		email = line;
            		textField_4.setText(line);
            	}
            	x++;
            	
            }
            System.out.println(pushUps);
            System.out.println(plankMins);
            System.out.println(curls);
            System.out.println(weight);
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	//takes lines from the text file and puts them in the JTextArea
	public static void fulfill(JTextArea txtrTest) {
		try {
            FileReader reader = new FileReader("filename.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
            txtrTest.setText("");
 
            while ((line = bufferedReader.readLine()) != null) {
            	txtrTest.setText(txtrTest.getText() + "\n" + line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	//Adds a new entry to the file that logs WOs
	public static void addition(String WO, JTextArea txtrTest) {
		try {
            FileWriter writer = new FileWriter("filename.txt", true);
            writer.write("\n" + WO);
            writer.close();
            fulfill(txtrTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//resets the stat file
	public static void setStats() {
		addStat(String.valueOf(pushUps), true);
		addStat(String.valueOf(plankMins), false);
		addStat(String.valueOf(curls), false);
		addStat(String.valueOf(weight), false);
		addStat(email, false);
	}
	
	//Adds an entry to the stats file
	public static void addStat(String WO, boolean setting) {
		try {
            if(setting) {
            	File myObj = new File("stats.txt");
            	myObj.delete();
            	myObj.createNewFile();
            }
            
           FileWriter writer = new FileWriter("stats.txt", true); 
           writer.write(WO + "\n" );
           writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static boolean isNumeric(String strNum) {
		if(strNum == null) {
			return false;
		}
		try {
			int x = Integer.parseInt(strNum);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	public static String isEmail(String str) {
		if(!str.contains("@")) {
			return "@";
		}
		if (!str.contains(".")) {
			return ".";
		}
		return "a";
	}
}
