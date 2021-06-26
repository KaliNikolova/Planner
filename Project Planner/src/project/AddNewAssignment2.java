package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


import com.github.lgooddatepicker.components.DatePicker;

public class AddNewAssignment2 extends JDialog { //с класа AddNewAssignment създаваме диалогов прозорец

	private static final long serialVersionUID = 2466213780045701241L; //уникалният номер на класа
	Planner planner; //член-променлива от тип Planner

	public AddNewAssignment2(Planner planner) { //този конструктор приема параметър от тип Planner
		super(planner, "Add new assignment", true); 
		this.planner = planner; //planner на обекта от тип AddNewAssignment приема стойността на подадения planner
		this.setSize(815, 375); //задаваме размери на диалоговия прозореца
		this.setLocationRelativeTo(planner); //задаваме позицията на прозореца спрямо компонента

		JPanel panel = new JPanel(); //създаваме панел
		panel.setBackground(Color.WHITE); //задаваме цвят за панела
		panel.setLayout(null); //добавяме нулев layout към панела
		add(panel); //добавяме панела към диалоговия прозорец
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK); //създаваме черен Border

		JButton btnCancel = new JButton("Cancel"); //създаваме бутон Cancel
		btnCancel.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //задаваме шрифта и размера на шрифта на текста в бутона
		btnCancel.setBackground(Color.RED); //задаваме червен цвят на бутона
		btnCancel.setBorder(blackline); //ограждаме бутона Cancel с Border
		btnCancel.setBounds(400, 250, 125, 50); //задаваме координати на бутона 
		btnCancel.addActionListener(new ActionListener() { //добавяме функционалност на бутона

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewAssignment2.this.dispose(); //при натискане на бутона диалоговият прозорец се затваря
			}
		});
		panel.add(btnCancel); //добавяме бутона Cancel към панела

		JLabel lblNameOfAssignment = new JLabel("Assignment", SwingConstants.CENTER); //създаваме JLabel с центриран надпис "Assignment"
		lblNameOfAssignment.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblNameOfAssignment.setBorder(blackline); //ограждаме лейбъла с Border
		lblNameOfAssignment.setBounds(30, 50, 160, 50); //задаваме координати на лейбъла
		panel.add(lblNameOfAssignment); //добавяме лейбъла към панела

		JLabel lblPerson = new JLabel("Person in Charge", SwingConstants.CENTER); //създаваме JLabel с центритан надпис "Person in Charge"
		lblPerson.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblPerson.setBorder(blackline); //ограждаме лейбъла с Border
		lblPerson.setBounds(190, 50, 140, 50); //задаваме координати на лейбъла
		panel.add(lblPerson); //добавяме лейбъла към панела

		JLabel lblInitialDate = new JLabel("Initial Date", SwingConstants.CENTER); //създаваме JLabel с центриран надпис "Initial Date"
		lblInitialDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblInitialDate.setBorder(blackline); //ограждаме лейбъла с Border
		lblInitialDate.setBounds(330, 50, 110, 50); //задаваме координати на лейбъла
		panel.add(lblInitialDate); //добавяме лейбъла към панела

		JLabel lblDueDate = new JLabel("Due Date", SwingConstants.CENTER); //създаваме JLabel с центриран надпис "Due Date"
		lblDueDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblDueDate.setBorder(blackline); //ограждаме лейбъла с Border
		lblDueDate.setBounds(440, 50, 150, 50); //задаваме координати на лейбъла
		panel.add(lblDueDate); //добавяме лейбъла към панела

		JLabel lblStatus = new JLabel("Status of Assignment", SwingConstants.CENTER); //създаваме JLabel с центриран надпис "Status of Assignment"
		lblStatus.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblStatus.setBorder(blackline); //ограждаме лейбъла с Border
		lblStatus.setBounds(590, 50, 175, 50); //задаваме координати на лейбъла
		panel.add(lblStatus); //добавяме лейбъла към панела

		JTextArea txtAssignment = new JTextArea(); //създаваме JTextArea за въвеждане името на заданието
		txtAssignment.setLineWrap(true); //ако името на заданието е твърде дълго, то се разделя на няколко реда
		txtAssignment.setToolTipText("Enter description of the assignment"); //при задържане на курсора върху полето за текст се появява надписът "Enter description of the assignment"
		txtAssignment.setFont(panel.getFont().deriveFont(Font.ITALIC, 14.0f)); //задаваме шрифта и размера на шрифта на текста в полето за текст
		txtAssignment.setBorder(blackline); //обграждаме полето за текст с Border
		txtAssignment.setBounds(30, 100, 160, 100); //задаваме координати на полето за текст
		panel.add(txtAssignment); //добавяме полето за текст към панела

		JComboBox comboNames = new JComboBox(Team.returnTeam().toArray()); //създаваме падащо меню с имената на членовете на екипа
		((JLabel) comboNames.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //центрираме имената в падащото меню
		comboNames.setBackground(Color.WHITE); //задаваме фон на падащото меню
		comboNames.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //задаваме шрифта и размера на шрифта на текста в падащото меню
		comboNames.setBorder(blackline); //обграждаме падащото меню с Border
		comboNames.setBounds(190, 100, 140, 100); //задаваме координати на падащото меню
		panel.add(comboNames); //добавяме падащото меню към панела

		LocalDate initialDate = LocalDate.now(); //променлива от тип Date с днешната дата
		JLabel lblInitialDateValue = new JLabel(
				initialDate.getDayOfMonth() + " " + initialDate.getMonth() + " " + initialDate.getYear(),
				SwingConstants.CENTER); //създаваме JLabel, който да показва днешната дата
		lblInitialDateValue.setFont(panel.getFont().deriveFont(Font.ITALIC, 15.0f)); //задаваме шрифта и размера на шрифта на текста в лейбъла
		lblInitialDateValue.setBorder(blackline); //ограждаме лейбъла с Border
		lblInitialDateValue.setBounds(330, 100, 110, 100); //ограждаме лейбъла с Border
		panel.add(lblInitialDateValue); //добавяме лейбъла към панела
		
//		DatePicker datePicker1 = new DatePicker();
//		datePicker1.setDate(LocalDate.now());
//		datePicker1.setBounds(330, 100, 110, 100);
//		panel.add(datePicker1);

		DatePicker datePicker2 = new DatePicker();
		datePicker2.setBounds(440, 100, 150, 100);
		panel.add(datePicker2);
		
		String[] status = { "Uncompleted", "Completed" }; //масив с възможните статуси на заданието
		JComboBox comboStatus = new JComboBox(status); //падащо меню за състоянието на заданието
		((JLabel) comboStatus.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //центрираме текста в падащото меню
		comboStatus.setBackground(Color.WHITE); //задаваме цвят на падащото меню
		comboStatus.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //задаваме шрифта и размера на шрифта на текста в падащото меню
		comboStatus.setBorder(blackline); //обграждаме падащото меню с Border
		comboStatus.setBounds(590, 100, 175, 100); //задаваме координати на падащото меню
		panel.add(comboStatus); //добавяме падащото меню към панела

		JButton btnSubmit = new JButton("Submit"); //създаваме бутон Submit 
		btnSubmit.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //задаваме шрифта и размера на шрифта на текста в бутона
		btnSubmit.setBackground(Color.GREEN); //задаваме зелен цвят на бутона
		btnSubmit.setBorder(blackline); //ограждаме бутона Cancel с Border
		btnSubmit.setBounds(550, 250, 125, 50); //задаваме координати на бутона 
		btnSubmit.addActionListener(new ActionListener() { //добавяме функционалност на бутона
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (datePicker2.getDate() == null) {
					JOptionPane.showMessageDialog(AddNewAssignment2.this, "Due date must not be null!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (initialDate.isAfter(datePicker2.getDate())) {
					JOptionPane.showMessageDialog(AddNewAssignment2.this, "Due date must be after Initial date!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (txtAssignment.getText()==null || txtAssignment.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(AddNewAssignment2.this, "Please define the assignment!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// TODO Auto-generated method stub
				boolean status = comboStatus.getSelectedItem().equals("Completed") ? true : false; //създаваме променлива от тип boolean на база избора на потребителя за статус на заданието
				Assignment newAssignment = new Assignment((""+txtAssignment.getText()).replace("\n", " "),
						(String) comboNames.getSelectedItem(), initialDate, datePicker2.getDate(), status); //създаваме обект от тип Assignment с параметри на база избора на потребителя
				AddNewAssignment2.this.dispose(); //затваря диалоговия прозорец
				planner.addToTable(newAssignment); //добавя създадения Assignment към таблицата със задания
			}
		});
		panel.add(btnSubmit); //добавяме бутона към панела

		this.setVisible(true); //позволява на диалоговия прозорец да се отвори
	}
}