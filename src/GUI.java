import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI {
	private JFrame frame;
	private JTable table;
	private JTextField name;
	private JTextField address;
	private JTextField age;
	private JButton submit;
	private int rowIndex = -1;
	private JButton remove;
	GUI(){
		frame = new JFrame();
		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		tm.addColumn("Name");
		tm.addColumn("Address");
		tm.addColumn("Age");
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10,10,364,300);
		
		name = new JTextField("Name");
		name.setBounds(384,10,190,25);
		address = new JTextField("Address");
		address.setBounds(384,45,190,25);
		age = new JTextField("Age");
		age.setBounds(384,80,190,25);
		
		submit = new JButton("Add Row");
		submit.setBounds(384,115,190,25);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> rowData = new ArrayList<>();
				
				
				
				// TODO Auto-generated method stub
				if (name.getText().isEmpty() || address.getText().isEmpty() || age.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill up form", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				}else {
					rowData.add(name.getText());
					rowData.add(address.getText());
					rowData.add(age.getText());
					Object[] arr = rowData.toArray();
					tm.insertRow(tm.getRowCount(), arr);
				
					rowData.clear();
				}
				
			}
			
		});
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table.rowAtPoint(e.getPoint());
				int column = table.columnAtPoint(e.getPoint());
				
				if (row >= 0 && column >= 0) {
					rowIndex = row;
				}
				System.out.println(rowIndex);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		remove = new JButton("Remove");
		remove.setBounds(384,145,190,25);
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rowIndex >= 0 && tm.getRowCount() > 0) {
					tm.removeRow(rowIndex);
					rowIndex = -1;
				}
				
			}
			
		});
		
		frame.add(submit);
		frame.add(name);
		frame.add(address);
		frame.add(age);
		
		frame.add(sp);
		frame.add(remove);
		frame.setLayout(null);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JTable");
	}

}
