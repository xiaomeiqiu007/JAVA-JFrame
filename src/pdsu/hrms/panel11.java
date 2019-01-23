package pdsu.hrms;

import pdsu.hrms.dao.PersonDao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class panel11 extends JPanel implements ActionListener {
	//JPanel pTitle;  //�����������
	JPanel pContent;  //�����Ա��Ϣ�����������
	JScrollPane js;   //�����Ա��Ϣ���ڵĹ������
	
	JTextField tfPersonId;  //��Ա���
	JTextField tfName;  //����
	JTextField tfSex;   //�Ա�
	JTextField tfBirth;  //��������
	JTextField tfNat;    //����
	JTextField tfAddress; //��ַ
	JTextField tfOther;   //����˵��
	
	JComboBox<String> comboDept;  //������Ϣ
	
	JButton btnAdd;  //����
	JButton btnClear; //���
	private int nextPersonId;
	private String deptInfo[] =PersonDao.getAllDeptInfo();
	
	public panel11() {
		//����Ϊ���������
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints cons = null;
		setLayout(gridBag);
		
		//��ӱ���
		JLabel lbTitle = new JLabel("�����Ա��Ϣ");
		lbTitle.setFont(new Font("����",0,16));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		gridBag.setConstraints(lbTitle, cons);
		add(lbTitle);
		
		//�����������
		initContent();  //��ʼ�������Ա��Ϣ����
		js = new JScrollPane(pContent);
		js.setPreferredSize(new Dimension(510, 390));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		gridBag.setConstraints(js, cons);
		add(js);
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		nextPersonId=PersonDao.getNextId();
		tfPersonId.setEditable(false);
		tfPersonId.setText(String.valueOf(nextPersonId));
	}
	public void initContent() {
		//����������岢���ò��ַ�ʽ
		pContent = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		pContent.setLayout(layout);
		
		GridBagConstraints cons = null;
		
		//��ӵ�1���������Ա��ű�ǩ����Ա����ı�����Ա������ǩ����Ա�����ı���
		//��Ա��ű�ǩ
		JLabel lbPersonId = new JLabel("��Ա���");
		//lbPersonId.setFont(new Font("����",0,12));
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		cons.insets = new Insets(10,10,10,1);//�������Ҽ��
		layout.setConstraints(lbPersonId, cons);
		pContent.add(lbPersonId);
		//��Ա����ı���
		tfPersonId = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 0;
		cons.insets = new Insets(10,1,10,15);
		layout.setConstraints(tfPersonId, cons);
		pContent.add(tfPersonId);
		//��Ա������ǩ
		JLabel lbName = new JLabel("��Ա����");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 0;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbName, cons);
		pContent.add(lbName);
		//��Ա�����ı���
		tfName = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 0;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfName, cons);
		pContent.add(tfName);
		
		//��ӵ�2��������Ա��ǩ���Ա��ı��򡢳������±�ǩ�����������ı���
		//�Ա��ǩ
		JLabel lbSex = new JLabel("��  ��");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		cons.insets = new Insets(10,10,10,1);
		layout.setConstraints(lbSex, cons);
		pContent.add(lbSex);
		//�Ա��ı���
		tfSex = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 1;
		cons.insets = new Insets(10,1,10,15);
		cons.gridwidth  = 3;
		cons.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfSex, cons);
		pContent.add(tfSex);
		//�������±�ǩ
		JLabel lbBirth = new JLabel("��������");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 1;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbBirth, cons);
		pContent.add(lbBirth);
		//���������ı���
		tfBirth = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 1;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfBirth, cons);
		pContent.add(tfBirth);
		
		//��ӵ�3������������ǩ�������ı��򡢵�ַ��ǩ����ַ�ı���
		//�����ǩ
		JLabel lbNat = new JLabel("��  ��");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 2;
		cons.insets = new Insets(10,10,10,1);
		layout.setConstraints(lbNat, cons);
		pContent.add(lbNat);
		//�����ı���
		tfNat = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 2;
		cons.insets = new Insets(10,1,10,15);
		layout.setConstraints(tfNat, cons);
		pContent.add(tfNat);
		//��ַ��ǩ
		JLabel lbAddress = new JLabel("��  ַ");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 2;
		cons.insets = new Insets(10,15,10,1);
		layout.setConstraints(lbAddress, cons);
		pContent.add(lbAddress);
		//��ַ�ı���
		tfAddress = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 2;
		cons.insets = new Insets(10,1,10,10);
		layout.setConstraints(tfAddress, cons);
		pContent.add(tfAddress);
		
		//��ӵ�4����������ű�ǩ�����������б�������ǩ�������ı���
		//���ű�ǩ
		JLabel lbDept = new JLabel("��  ��");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 3;
		cons.insets = new Insets(10,10,10,1);
		layout.setConstraints(lbDept, cons);
		pContent.add(lbDept);
		//���������б�
		comboDept = new JComboBox<String>(deptInfo);
		cons = new GridBagConstraints();
		cons.gridx = 1;
		cons.gridy = 3;
		cons.gridwidth=2;
		cons.insets = new Insets(10,1,10,100);
		layout.setConstraints(comboDept, cons);
		pContent.add(comboDept);
		//������ǩ
		JLabel lbOther = new JLabel("��  ��");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 3;
		cons.insets = new Insets(10,25,10,5);
		layout.setConstraints(lbOther, cons);
		pContent.add(lbOther);
		//�����ı���
		tfOther = new JTextField(15);
		cons = new GridBagConstraints();
		cons.gridx = 3;
		cons.gridy = 3;
		cons.insets = new Insets(10,1,10,1);
		layout.setConstraints(tfOther, cons);
		pContent.add(tfOther);
		
		//��ӵ�5����������Ӱ�ť����հ�ť��
		//����
		btnAdd = new JButton("����");
		cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridwidth = 2;
		cons.insets = new Insets(10,10,10,10);
		layout.setConstraints(btnAdd, cons);
		pContent.add(btnAdd);
		//���
		btnClear = new JButton("���");
		cons = new GridBagConstraints();
		cons.gridx = 2;
		cons.gridy = 4;
		cons.gridwidth = 2;
		cons.insets = new Insets(10,10,10,10);
		layout.setConstraints(btnClear, cons);
		pContent.add(btnClear);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAdd){
			PersonDao.addPerson(tfPersonId.getText(),tfName.getText(),tfSex.getText(),tfNat.getText(),tfAddress.getText(),tfBirth.getText(),comboDept.getSelectedItem().toString(),tfOther.getText());
		}else if (e.getSource()==btnClear){
			tfAddress.setText("");
			tfBirth.setText("");
			tfName.setText("");
			tfNat.setText("");
			tfOther.setText("");
			tfSex.setText("");
		}
	}
}
