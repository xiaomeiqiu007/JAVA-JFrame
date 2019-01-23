package pdsu.hrms;

import pdsu.hrms.dao.PersonDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class panel12 extends JPanel implements ActionListener {
    //JPanel pTitle;  //�����������
    JPanel pTop;  //�����Ա��Ϣ�����������
    JPanel pCenter;
    JPanel pBottom;
    JPanel pContent;

    JScrollPane js;   //�����Ա��Ϣ���ڵĹ������

    JTextField tfPersonId;  //��Ա���
    JTextField tfName;  //����
    JTextField tfSex;   //�Ա�
    JTextField tfBirth;  //��������
    JTextField tfNat;    //����
    JTextField tfAddress; //��ַ
    JTextField tfOther;   //����˵��

    private JComboBox<String> comboPname;  //��Ա��Ϣ

    JButton btnUpdate;  //����
    JButton btnClear; //���
    private int nextPersonId;
    private String personInfo[] =PersonDao.getAllPersonName();

    public panel12() {
        //ptop����Ϊ���������
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints cons = null;
        setLayout(gridBag);

        //��ӱ���
        JLabel lbTitle = new JLabel("�޸���Ա��Ϣ");
        lbTitle.setFont(new Font("����",0,15));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        gridBag.setConstraints(lbTitle, cons);
        add(lbTitle);

        //�����������
        initContent();  //��ʼ�������Ա��Ϣ����
        js = new JScrollPane(pTop);
        js.setPreferredSize(new Dimension(510, 390));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        gridBag.setConstraints(js, cons);
        add(js);
        //��Ӽ���
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        comboPname.addActionListener(this);
        //������Ա��Ϣ
        nextPersonId=PersonDao.getNextId();
        tfPersonId.setText(String.valueOf(nextPersonId));
        //����Ĭ����ʾģʽ
        intitView();
    }
    public void  intitView(){
        btnUpdate.setEnabled(false);
        tfPersonId.setText("���ѯ��Ա���");
        tfPersonId.setEditable(false);
        tfName.setEditable(false);
        tfSex.setEditable(false);
        tfBirth.setEditable(false);
        tfNat.setEditable(false);
        tfAddress.setEditable(false);
        tfOther.setEditable(false);
    }
    public void initContent() {
        //����������岢���ò��ַ�ʽ
        pTop = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        pTop.setLayout(layout);

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
        pTop.add(lbPersonId);
        //��Ա����ı���
        tfPersonId = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(10,1,10,15);
        layout.setConstraints(tfPersonId, cons);
        pTop.add(tfPersonId);
        //��Ա������ǩ
        JLabel lbName = new JLabel("��Ա����");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbName, cons);
        pTop.add(lbName);
        //��Ա�����ı���
        tfName = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 0;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfName, cons);
        pTop.add(tfName);

        //��ӵ�2��������Ա��ǩ���Ա��ı��򡢳������±�ǩ�����������ı���
        //�Ա��ǩ
        JLabel lbSex = new JLabel("��  ��");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.insets = new Insets(10,10,10,1);
        layout.setConstraints(lbSex, cons);
        pTop.add(lbSex);
        //�Ա��ı���
        tfSex = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.insets = new Insets(10,1,10,15);
        cons.gridwidth  = 3;
        cons.anchor = GridBagConstraints.WEST;
        layout.setConstraints(tfSex, cons);
        pTop.add(tfSex);
        //�������±�ǩ
        JLabel lbBirth = new JLabel("��������");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 1;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbBirth, cons);
        pTop.add(lbBirth);
        //���������ı���
        tfBirth = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 1;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfBirth, cons);
        pTop.add(tfBirth);

        //��ӵ�3������������ǩ�������ı��򡢵�ַ��ǩ����ַ�ı���
        //�����ǩ
        JLabel lbNat = new JLabel("��  ��");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.insets = new Insets(10,10,10,1);
        layout.setConstraints(lbNat, cons);
        pTop.add(lbNat);
        //�����ı���
        tfNat = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.insets = new Insets(10,1,10,15);
        layout.setConstraints(tfNat, cons);
        pTop.add(tfNat);
        //��ַ��ǩ
        JLabel lbAddress = new JLabel("��  ַ");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 2;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbAddress, cons);
        pTop.add(lbAddress);
        //��ַ�ı���
        tfAddress = new JTextField(15);
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 2;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfAddress, cons);
        pTop.add(tfAddress);

        //��ӵ�4�������������ǩ�������ı���

        //������ǩ
        JLabel lbOther = new JLabel("��  ��");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbOther, cons);
        pTop.add(lbOther);
        //�����ı���
        tfOther = new JTextField(30);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.insets = new Insets(10,1,10,10);
        layout.setConstraints(tfOther, cons);
        pTop.add(tfOther);

        //��ӵ�5�������ѡ����Ա��Ϣ��ѡ����Ա������ť�����Ӱ�ť����հ�ť��
        //ѡ����Ա��Ϣ
        JLabel lbSelect = new JLabel("ѡ����Ա��Ϣ");
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.insets = new Insets(10,15,10,1);
        layout.setConstraints(lbSelect, cons);
        pTop.add(lbSelect);
        //ѡ����Ա��Ϣcombox
        comboPname = new JComboBox<String>(personInfo);
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth=2;
        cons.insets = new Insets(10,1,10,100);
        layout.setConstraints(comboPname, cons);
        pTop.add(comboPname);
        //�޸İ�ť
        btnUpdate = new JButton("�޸�");
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.insets = new Insets(10,10,10,10);
        layout.setConstraints(btnUpdate, cons);
        pTop.add(btnUpdate);
        //���
        btnClear = new JButton("���");
        cons = new GridBagConstraints();
        cons.gridx = 3;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.insets = new Insets(10,10,10,10);
        layout.setConstraints(btnClear, cons);
        pTop.add(btnClear);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnUpdate){
            PersonDao.updatePerson(tfPersonId.getText(),tfName.getText(),tfSex.getText(),tfBirth.getText(),tfNat.getText(),tfAddress.getText(),tfOther.getText());
        }else if (e.getSource()==btnClear){
            tfAddress.setText("");
            tfBirth.setText("");
            tfName.setText("");
            tfNat.setText("");
            tfOther.setText("");
            tfSex.setText("");
        }else if(e.getSource()==comboPname){
            //���õ��ʱ��ȡ����������
            String[] str = new  String[110];
            str=PersonDao.getAllPerson(comboPname.getSelectedItem().toString().substring(0,1));
            tfName.setText(str[0]);
            tfSex.setText(str[1]);
            tfBirth.setText(str[2]);
            tfNat.setText(str[3]);
            tfAddress.setText(str[4]);
            tfOther.setText(str[5]);
            //����Ĭ�ϰ�ť��ʾ
            tfPersonId.setText(comboPname.getSelectedItem().toString().substring(0,1));
            tfName.setEditable(true);
            tfSex.setEditable(true);
            tfBirth.setEditable(true);
            tfNat.setEditable(true);
            tfAddress.setEditable(true);
            tfOther.setEditable(true);
            btnUpdate.setEnabled(true);
        }else if(e.getSource()==btnClear){
            intitView();
        }
    }
}
