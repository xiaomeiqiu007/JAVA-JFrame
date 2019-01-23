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
	
	//�����������
	//�������
	private JPanel pTop;
	private JPanel pCenter;
	private JPanel pBottom;
	private JTable table;
	private JScrollPane js;
	//�����в����������
	private JLabel lbDeptid;
	private JLabel lbDept1Name;
	private JLabel lbDept2Name;
	private JLabel lbDeptid1;
	private JLabel lbDeptid2;
	//����ײ��������
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
		//����Ϊ�߽粼��
		setLayout(new BorderLayout());
		initTop();
		initCenter();
		initBottom();
		//�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�

		tfDeptid.setEditable(false);  //����id���ɱ༭
		btnAdd.setEnabled(false);      //���ð�ť���ɱ༭
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		tfDeptid1.setEditable(false);
		tfDeptid2.setEditable(false);
	}

	//��ʼ���ϲ�
	public void initTop() {
		colTitle = new String[] {"���ű��","һ������","��������"};
		colValue = DeptDao.getAllDept();
		table = new JTable(colValue,colTitle);
		pTop =new JPanel();
		//�����ձ��
		//���ñ���Ĭ�ϴ�С
	
		table.setPreferredScrollableViewportSize(new Dimension(430, 300));
		table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//��ȡѡ����
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
	
	//�����ϲ����
	public void initCenter() {
		pCenter = new JPanel();
		lbDeptid = new JLabel("���");
		tfDeptid = new JTextField(12);

		
		lbDeptid1 = new JLabel("һ������");
		tfDeptid1 = new JTextField(12);
		
		lbDeptid2 = new JLabel("��������");
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
		btnNextid = new JButton("��ȡ�±��");
		btnAdd = new JButton("��Ӳ���");
		btnUpdate = new JButton("���²���");
		btnDelete = new JButton("ɾ������");
		btnClear = new JButton("���");
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
