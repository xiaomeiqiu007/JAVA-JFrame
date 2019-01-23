package pdsu.hrms;

import pdsu.hrms.dao.DeptDao;
import pdsu.hrms.dao.PersonDao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class panel13 extends JPanel implements ActionListener {

    //�����������
    //�������
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //�����в����������
    private JLabel lbDeptid;
    private JLabel lbTitle;
    private JLabel lbDeptid1;
    private JLabel lbDeptid2;
    //����ײ��������
    private JButton btnDelete;
    private JTextField tfPersonid;
    private JTextField tfDeptid1;
    private JTextField tfDeptid2;
    private String[][] colValue ;
    private String[] colTitle;

    public panel13() {
        //����Ϊ�߽粼��

        lbTitle =new JLabel("ɾ����Ա��Ϣ");

        setLayout(new BorderLayout());
        add(lbTitle);
        initTop();
        initCenter();
        initBottom();

        //�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�
        btnDelete.addActionListener(this);
        tfPersonid.setEditable(false);  //����id���ɱ༭
        btnDelete.setEnabled(false);
        tfDeptid1.setEditable(false);
        tfDeptid2.setEditable(false);
    }

    //��ʼ���ϲ�
    public void initTop() {
        colTitle = new String[] {"���","����","��������","����","��ַ","����"};
        colValue = PersonDao.getAllperson();
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
                btnDelete.setEnabled(true);
                int row = table.getSelectedRow();
                tfPersonid.setText(colValue[row][0]);
                tfDeptid1.setText(colValue[row][1]);
                tfDeptid2.setText(colValue[row][5]);
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
        tfPersonid = new JTextField(12);


        lbDeptid1 = new JLabel("����");
        tfDeptid1 = new JTextField(12);

        lbDeptid2 = new JLabel("����");
        tfDeptid2 = new JTextField(12);
        pCenter.add(lbDeptid);
        pCenter.add(tfPersonid);
        pCenter.add(lbDeptid1);
        pCenter.add(tfDeptid1);
        pCenter.add(lbDeptid2);
        pCenter.add(tfDeptid2);

        add(pCenter,BorderLayout.CENTER);
    }
    public void initBottom() {
        pBottom = new JPanel();
        btnDelete = new JButton("ɾ������");
        pBottom.add(btnDelete);
        add(pBottom, BorderLayout.SOUTH);
    }
    public void updateTable(){
        colValue =PersonDao.getAllperson();
        DefaultTableModel tableModel = new DefaultTableModel(colValue,colTitle);
        table.setModel(tableModel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getSource()==btnDelete){
            PersonDao.deletePerson(tfPersonid.getText());
            updateTable();
        }

    }
}
