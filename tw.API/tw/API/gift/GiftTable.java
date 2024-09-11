package tw.API.gift;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable{
	private GiftDB db;
	
	
	public GiftTable() {
		
		try {
			db = new GiftDB();
			db.query();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		GiftModel model = new GiftModel();
		model.setColumnIdentifiers(db.getfieldNames()); //取得首列
		setModel(model);
	}
	
	public void delRow() {
		
		try {
			db.delData(getSelectedRow());
			repaint();
		} catch (SQLException e) {
			System.out.println("刪除失敗");
		}
		
	}
	

    public void addNewGift(String[] data) throws SQLException {
        db.addNewGift(data);
        ((GiftModel)getModel()).fireTableDataChanged();
    }
	
	//內部類別
	private class GiftModel extends DefaultTableModel{
		
		@Override
		public int getRowCount() {
			return db.getRows();
		}
		
		@Override
		public int getColumnCount() {
			return db.getCols();
						
		}

		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}
		
		@Override
		public void setValueAt(Object aValue, int row, int column) {
		db.updateData((String)aValue, row, column);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return column != 0;  //第一欄id不能改，做一下限制
		}

		
	}
	
}


