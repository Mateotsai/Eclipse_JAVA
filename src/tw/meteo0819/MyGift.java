package tw.meteo0819;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import tw.API.gift.GiftTable;

public class MyGift extends JFrame{
	private GiftTable giftTable;
	private JButton del;
	private JButton addButton;
//	private JButton update;
//	private JButton find;
	
	public MyGift() {
		super("伴手禮");
		
		setLayout(new BorderLayout());
		
		del = new JButton("DEL");
		JPanel top = new JPanel(new FlowLayout());
		top.add(del);
		add(top, BorderLayout.NORTH);
		
		addButton = new JButton("Add");
		top.add(addButton);
		
//		
//		update = new JButton("UPDATE");
//		top.add(update);
//
//		find = new JButton("QUERY");
//		top.add(find);
		
		
		//增加頁面滾軸
		giftTable = new GiftTable();
		JScrollPane jsp = new JScrollPane(giftTable);
		add(jsp,BorderLayout.CENTER);
	
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				giftTable.delRow();
				
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showAddDialog();
				
			}
		});
	}

	private void showAddDialog() {
		JDialog dialog = new JDialog(this, "Add New Gift",true);
		dialog.setLayout(new GridLayout(0, 2));

        JTextField[] fields = new JTextField[giftTable.getColumnCount() - 1]; // 假設第一列是自動生成的ID

        for (int i = 1; i < giftTable.getColumnCount(); i++) {
            dialog.add(new JLabel(giftTable.getColumnName(i) + ":"));
            fields[i-1] = new JTextField(20);
            dialog.add(fields[i-1]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String[] data = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                data[i] = fields[i].getText();
            }
            addNewGift(data);
            dialog.dispose();
        });

        dialog.add(submitButton);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void addNewGift(String[] data) {
        try {
            giftTable.addNewGift(data);
            giftTable.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding new gift: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	


	public static void main(String[] args) {
		new MyGift();
	}

}
