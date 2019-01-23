package pdsu.hrms;

import pdsu.hrms.dao.DeptDao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class panel15 extends JPanel implements ActionListener {
	
	//定义各种属性
	//定义面板
	private JPanel pTop;
	private JPanel pCenter;
	private JPanel pBottom;
	private JTable table;
	private JScrollPane js;
	//定义中部所需组件；
	private JLabel lbDeptid;
	private JLabel lbDept1Name;
	private JLabel lbDept2Name;
	private JLabel lbDeptid1;
	private JLabel lbDeptid2;
	//定义底部所需组件
	private JButton btnNextid;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JTextField tfDeptid;
	private JTextField tfDeptid1;
	private JTextField tfDeptid2;
	private String[][] colValue ;
	private String[] colTitle;
	
	public panel15() {
		//设置为边界布局
		setLayout(new BorderLayout());
		initTop();
		initCenter();
		initBottom();
		//事件处理利用的是对应的借口，必须重写其中的抽象方法

		tfDeptid.setEditable(false);  //设置id不可编辑
		btnAdd.setEnabled(false);      //设置按钮不可编辑
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		tfDeptid1.setEditable(false);
		tfDeptid2.setEditable(false);
	}

	//初始化上部
	public void initTop() {
		colTitle = new String[] {"部门编号","一级部门","二级部门"};
		colValue = DeptDao.getAllDept();
		table = new JTable(colValue,colTitle);
		pTop =new JPanel();
		//创建空表格
		//设置表格的默认大小
	
		table.setPreferredScrollableViewportSize(new Dimension(430, 300));
		table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//获取选中行
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int row = table.getSelectedRow();
				tfDeptid.setText(colValue[row][0]);
				tfDeptid1.setText(colValue[row][1]);
				tfDeptid2.setText(colValue[row][2]);
			}
		});
		js = new JScrollPane(table);
		js.setPreferredSize(new Dimension(450, 300));
		pTop.add(js);
		add(pTop,BorderLayout.NORTH);
	}
	
	//定义上部面板
	public void initCenter() {
		pCenter = new JPanel();
		lbDeptid = new JLabel("编号");
		tfDeptid = new JTextField(12);

		
		lbDeptid1 = new JLabel("一级部门");
		tfDeptid1 = new JTextField(12);
		
		lbDeptid2 = new JLabel("二级部门");
		tfDeptid2 = new JTextField(12);
		pCenter.add(lbDeptid);
		pCenter.add(tfDeptid);
		pCenter.add(lbDeptid1);
		pCenter.add(tfDeptid1);
		pCenter.add(lbDeptid2);
		pCenter.add(tfDeptid2);
		
		add(pCenter,BorderLayout.CENTER);
	}
	public void initBottom() {
		pBottom = new JPanel();
		btnNextid = new JButton("获取新编号");
		btnAdd = new JButton("添加部门");
		btnUpdate = new JButton("更新部门");
		btnDelete = new JButton("删除部门");
		btnClear = new JButton("清空");
		pBottom.add(btnNextid);
		pBottom.add(btnAdd);
		pBottom.add(btnDelete);
		pBottom.add(btnUpdate);
		pBottom.add(btnClear);
		add(pBottom, BorderLayout.SOUTH);
	}
	public void updateTable(){
		colValue = DeptDao.getAllDept();
		DefaultTableModel tableModel = new DefaultTableModel(colValue,colTitle);
		table.setModel(tableModel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAdd){
			DeptDao.addDept(tfDeptid.getText(),tfDeptid1.getText(),tfDeptid2.getText());
			updateTable();
		}
		else if(e.getSource()==btnDelete){
			DeptDao.deleteDept(tfDeptid.getText());
			updateTable();
		}
		else if(e.getSource()==btnUpdate){
			DeptDao.updateDept(tfDeptid.getText(),tfDeptid1.getText(),tfDeptid2.getText());
			updateTable();
		}
		else if(e.getSource()==btnNextid){
			tfDeptid.setText(String.valueOf(DeptDao.nextId()+1));
			tfDeptid1.setEditable(true);
			tfDeptid2.setEditable(true);
			tfDeptid1.setText("");
			tfDeptid2.setText("");
			btnAdd.setEnabled(true);
		}else if(e.getSource()==btnClear){
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			tfDeptid1.setEditable(false);
			tfDeptid2.setEditable(false);
			tfDeptid.setText("");
			tfDeptid2.setText("");
			tfDeptid1.setText("");
		}
	}
}
