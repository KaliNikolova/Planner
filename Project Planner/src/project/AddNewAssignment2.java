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

public class AddNewAssignment2 extends JDialog { //� ����� AddNewAssignment ��������� �������� ��������

	private static final long serialVersionUID = 2466213780045701241L; //���������� ����� �� �����
	Planner planner; //����-���������� �� ��� Planner

	public AddNewAssignment2(Planner planner) { //���� ����������� ������ ��������� �� ��� Planner
		super(planner, "Add new assignment", true); 
		this.planner = planner; //planner �� ������ �� ��� AddNewAssignment ������ ���������� �� ��������� planner
		this.setSize(815, 375); //�������� ������� �� ���������� ���������
		this.setLocationRelativeTo(planner); //�������� ��������� �� ��������� ������ ����������

		JPanel panel = new JPanel(); //��������� �����
		panel.setBackground(Color.WHITE); //�������� ���� �� ������
		panel.setLayout(null); //�������� ����� layout ��� ������
		add(panel); //�������� ������ ��� ���������� ��������
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK); //��������� ����� Border

		JButton btnCancel = new JButton("Cancel"); //��������� ����� Cancel
		btnCancel.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � ������
		btnCancel.setBackground(Color.RED); //�������� ������ ���� �� ������
		btnCancel.setBorder(blackline); //��������� ������ Cancel � Border
		btnCancel.setBounds(400, 250, 125, 50); //�������� ���������� �� ������ 
		btnCancel.addActionListener(new ActionListener() { //�������� �������������� �� ������

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewAssignment2.this.dispose(); //��� ��������� �� ������ ����������� �������� �� �������
			}
		});
		panel.add(btnCancel); //�������� ������ Cancel ��� ������

		JLabel lblNameOfAssignment = new JLabel("Assignment", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Assignment"
		lblNameOfAssignment.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblNameOfAssignment.setBorder(blackline); //��������� ������� � Border
		lblNameOfAssignment.setBounds(30, 50, 160, 50); //�������� ���������� �� �������
		panel.add(lblNameOfAssignment); //�������� ������� ��� ������

		JLabel lblPerson = new JLabel("Person in Charge", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Person in Charge"
		lblPerson.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblPerson.setBorder(blackline); //��������� ������� � Border
		lblPerson.setBounds(190, 50, 140, 50); //�������� ���������� �� �������
		panel.add(lblPerson); //�������� ������� ��� ������

		JLabel lblInitialDate = new JLabel("Initial Date", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Initial Date"
		lblInitialDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblInitialDate.setBorder(blackline); //��������� ������� � Border
		lblInitialDate.setBounds(330, 50, 110, 50); //�������� ���������� �� �������
		panel.add(lblInitialDate); //�������� ������� ��� ������

		JLabel lblDueDate = new JLabel("Due Date", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Due Date"
		lblDueDate.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblDueDate.setBorder(blackline); //��������� ������� � Border
		lblDueDate.setBounds(440, 50, 150, 50); //�������� ���������� �� �������
		panel.add(lblDueDate); //�������� ������� ��� ������

		JLabel lblStatus = new JLabel("Status of Assignment", SwingConstants.CENTER); //��������� JLabel � ��������� ������ "Status of Assignment"
		lblStatus.setFont(panel.getFont().deriveFont(Font.BOLD, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblStatus.setBorder(blackline); //��������� ������� � Border
		lblStatus.setBounds(590, 50, 175, 50); //�������� ���������� �� �������
		panel.add(lblStatus); //�������� ������� ��� ������

		JTextArea txtAssignment = new JTextArea(); //��������� JTextArea �� ��������� ����� �� ���������
		txtAssignment.setLineWrap(true); //��� ����� �� ��������� � ������ �����, �� �� ������� �� ������� ����
		txtAssignment.setToolTipText("Enter description of the assignment"); //��� ��������� �� ������� ����� ������ �� ����� �� ������� �������� "Enter description of the assignment"
		txtAssignment.setFont(panel.getFont().deriveFont(Font.ITALIC, 14.0f)); //�������� ������ � ������� �� ������ �� ������ � ������ �� �����
		txtAssignment.setBorder(blackline); //���������� ������ �� ����� � Border
		txtAssignment.setBounds(30, 100, 160, 100); //�������� ���������� �� ������ �� �����
		panel.add(txtAssignment); //�������� ������ �� ����� ��� ������

		JComboBox comboNames = new JComboBox(Team.returnTeam().toArray()); //��������� ������ ���� � ������� �� ��������� �� �����
		((JLabel) comboNames.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� ������� � �������� ����
		comboNames.setBackground(Color.WHITE); //�������� ��� �� �������� ����
		comboNames.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboNames.setBorder(blackline); //���������� �������� ���� � Border
		comboNames.setBounds(190, 100, 140, 100); //�������� ���������� �� �������� ����
		panel.add(comboNames); //�������� �������� ���� ��� ������

		LocalDate initialDate = LocalDate.now(); //���������� �� ��� Date � �������� ����
		JLabel lblInitialDateValue = new JLabel(
				initialDate.getDayOfMonth() + " " + initialDate.getMonth() + " " + initialDate.getYear(),
				SwingConstants.CENTER); //��������� JLabel, ����� �� ������� �������� ����
		lblInitialDateValue.setFont(panel.getFont().deriveFont(Font.ITALIC, 15.0f)); //�������� ������ � ������� �� ������ �� ������ � �������
		lblInitialDateValue.setBorder(blackline); //��������� ������� � Border
		lblInitialDateValue.setBounds(330, 100, 110, 100); //��������� ������� � Border
		panel.add(lblInitialDateValue); //�������� ������� ��� ������
		
//		DatePicker datePicker1 = new DatePicker();
//		datePicker1.setDate(LocalDate.now());
//		datePicker1.setBounds(330, 100, 110, 100);
//		panel.add(datePicker1);

		DatePicker datePicker2 = new DatePicker();
		datePicker2.setBounds(440, 100, 150, 100);
		panel.add(datePicker2);
		
		String[] status = { "Uncompleted", "Completed" }; //����� � ���������� ������� �� ���������
		JComboBox comboStatus = new JComboBox(status); //������ ���� �� ����������� �� ���������
		((JLabel) comboStatus.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER); //���������� ������ � �������� ����
		comboStatus.setBackground(Color.WHITE); //�������� ���� �� �������� ����
		comboStatus.setFont(panel.getFont().deriveFont(Font.ITALIC, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � �������� ����
		comboStatus.setBorder(blackline); //���������� �������� ���� � Border
		comboStatus.setBounds(590, 100, 175, 100); //�������� ���������� �� �������� ����
		panel.add(comboStatus); //�������� �������� ���� ��� ������

		JButton btnSubmit = new JButton("Submit"); //��������� ����� Submit 
		btnSubmit.setFont(panel.getFont().deriveFont(Font.BOLD, 16.0f)); //�������� ������ � ������� �� ������ �� ������ � ������
		btnSubmit.setBackground(Color.GREEN); //�������� ����� ���� �� ������
		btnSubmit.setBorder(blackline); //��������� ������ Cancel � Border
		btnSubmit.setBounds(550, 250, 125, 50); //�������� ���������� �� ������ 
		btnSubmit.addActionListener(new ActionListener() { //�������� �������������� �� ������
		
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
				boolean status = comboStatus.getSelectedItem().equals("Completed") ? true : false; //��������� ���������� �� ��� boolean �� ���� ������ �� ����������� �� ������ �� ���������
				Assignment newAssignment = new Assignment((""+txtAssignment.getText()).replace("\n", " "),
						(String) comboNames.getSelectedItem(), initialDate, datePicker2.getDate(), status); //��������� ����� �� ��� Assignment � ��������� �� ���� ������ �� �����������
				AddNewAssignment2.this.dispose(); //������� ���������� ��������
				planner.addToTable(newAssignment); //������ ���������� Assignment ��� ��������� ��� �������
			}
		});
		panel.add(btnSubmit); //�������� ������ ��� ������

		this.setVisible(true); //��������� �� ���������� �������� �� �� ������
	}
}