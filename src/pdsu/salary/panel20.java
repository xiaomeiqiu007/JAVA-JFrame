package pdsu.salary;

import pdsu.hrms.dao.DeptDao;
import pdsu.salary.Dao.PersonSalary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class panel20 extends JPanel implements ActionListener {

    //�����������
    //�������
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //�����в����������
    private JLabel lbPersonName;
    private JLabel lbBeforSalary;
    private JLabel lbAfterSalary;
    private JLabel lbpersonId;
    //����ײ��������

    private JButton btnTure;
    private JButton btnClear;
    private JTextField tfPersonName;
    private JTextField tfBeforSalary;
    private JTextField tfAfterSalary;
    private String[][] colValue ;
    private String[] colTitle;

    public panel20() {
        //����Ϊ�߽粼��
        setLayout(new BorderLayout());
        initTop();
        initCenter();
        initBottom();
        //�¼��������õ��Ƕ�Ӧ�Ľ�ڣ�������д���еĳ��󷽷�

        btnTure.addActionListener(this);
        btnClear.addActionListener(this);
        tfPersonName.setEditable(false);  //����id���ɱ༭
      //���ð�ť���ɱ༭
        btnTure.setEnabled(false);
        tfBeforSalary.setEditable(false);
        tfAfterSalary.setEditable(true);
        lbpersonId=new JLabel();

    }

    //��ʼ���ϲ�
    public void initTop() {
        colTitle = new String[] {"����","�Ա�","����","����","н��","������Ϣ"};
        colValue = PersonSalary.getAllperson();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //�����ձ���
        //���ñ����Ĭ�ϴ�С

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));
        table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //��ȡѡ����
                btnTure.setEnabled(true);
                int row = table.getSelectedRow();
                lbpersonId.setText(colValue[row][0]);
                System.out.println(lbpersonId.getText());
                tfPersonName.setText(colValue[row][1]);
                tfBeforSalary.setText(colValue[row][4]);

            }
        });
        js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(480, 300));
        pTop.add(js);
        add(pTop,BorderLayout.NORTH);
    }

    //�����ϲ����
    public void initCenter() {
        pCenter = new JPanel();
        lbPersonName = new JLabel("����");
        tfPersonName = new JTextField(10);


        lbBeforSalary = new JLabel("����ǰ�Ĺ���");
        tfBeforSalary = new JTextField(10);

        lbAfterSalary = new JLabel("������Ĺ���");
        tfAfterSalary = new JTextField(10);
        pCenter.add(lbPersonName);
        pCenter.add(tfPersonName);
        pCenter.add(lbBeforSalary);
        pCenter.add(tfBeforSalary);
        pCenter.add(lbAfterSalary);
        pCenter.add(tfAfterSalary);

        add(pCenter,BorderLayout.CENTER);
    }
    public void initBottom() {
        pBottom = new JPanel();
        btnTure = new JButton("ȷ��");
        btnClear = new JButton("���");
        pBottom.add(btnTure);
        pBottom.add(btnClear);
        add(pBottom, BorderLayout.SOUTH);
    }
    public void updateTable(){
        colValue = PersonSalary.getAllperson();
        DefaultTableModel tableModel = new DefaultTableModel(colValue,colTitle);
        table.setModel(tableModel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnTure){
            PersonSalary.changeSalary("���ʷ���",lbpersonId.getText(),tfBeforSalary.getText(),tfAfterSalary.getText());
            updateTable();
        }else if(e.getSource()==btnClear)
        tfAfterSalary.setText("");

    }
}