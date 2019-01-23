package pdsu.assess;

import pdsu.assess.Dao.AccessDao;
import pdsu.salary.Dao.PersonSalary;

import javax.swing.*;
import java.awt.*;

public class panel19 extends JPanel{
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
    private JTextField tfPersonid;
    private JTextField tfDeptid1;
    private JTextField tfDeptid2;
    private String[][] colValue ;
    private String[] colTitle;

    public panel19() {
        //����Ϊ�߽粼��
        setLayout(new BorderLayout());
        initTop();

        //�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�

    }

    //��ʼ���ϲ�
    public void initTop() {
        colTitle = new String[] {"��ˮ��","��Ա����","ԭ����","�ֿ���","�������","�������"};
        colValue = AccessDao.getAllHistory();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //�����ձ��
        //���ñ���Ĭ�ϴ�С

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));

        js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(450, 300));
        pTop.add(js);
        add(pTop,BorderLayout.NORTH);
    }

    //�����ϲ����
}
