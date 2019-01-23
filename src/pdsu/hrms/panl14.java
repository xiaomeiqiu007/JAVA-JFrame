package pdsu.hrms;

import pdsu.hrms.dao.DeptDao;
import pdsu.hrms.dao.PersonDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

class panel14 extends JPanel {

    //�����������
    //�������
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    private JLabel lbTitle;
    private JScrollPane js2;
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
    private JTextField tfPersonid;
    private JTextField tfDeptid1;
    private JTextField tfDeptid2;
    private String[][] colValue ;
    private String[] colTitle;

    public panel14() {
        //����Ϊ�߽粼��
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints cons = null;
        setLayout(gridBag);
        lbTitle=new JLabel("��ѯ��Ա��Ϣ",JLabel.CENTER);
        add(lbTitle);
        lbTitle.setFont(new Font("����",0,16));
        initTop();
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        gridBag.setConstraints(lbTitle, cons);

        js2 = new JScrollPane(pTop);
        js2.setPreferredSize(new Dimension(500, 380));
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        gridBag.setConstraints(js2, cons);
        add(js2);
        //�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�

    }

    //��ʼ���ϲ�
    public void initTop() {
        colTitle = new String[] {"���","����","��������","����","��ַ","����"};
        colValue = PersonDao.getAllperson();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //�����ձ��
        //���ñ���Ĭ�ϴ�С

        table.setPreferredScrollableViewportSize(new Dimension(450, 300));
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

    }

    //�����ϲ����

}
