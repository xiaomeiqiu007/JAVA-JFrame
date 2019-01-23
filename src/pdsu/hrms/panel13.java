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

    //定义各种属性
    //定义面板
    private JPanel pTop;
    private JPanel pCenter;
    private JPanel pBottom;
    private JTable table;
    private JScrollPane js;
    //定义中部所需组件；
    private JLabel lbDeptid;
    private JLabel lbTitle;
    private JLabel lbDeptid1;
    private JLabel lbDeptid2;
    //定义底部所需组件
    private JButton btnDelete;
    private JTextField tfPersonid;
    private JTextField tfDeptid1;
    private JTextField tfDeptid2;
    private String[][] colValue ;
    private String[] colTitle;

    public panel13() {
        //设置为边界布局

        lbTitle =new JLabel("删除人员信息");

        setLayout(new BorderLayout());
        add(lbTitle);
        initTop();
        initCenter();
        initBottom();

        //事件处理利用的是对应的借口，必须重写其中的抽象方法
        btnDelete.addActionListener(this);
        tfPersonid.setEditable(false);  //设置id不可编辑
        btnDelete.setEnabled(false);
        tfDeptid1.setEditable(false);
        tfDeptid2.setEditable(false);
    }

    //初始化上部
    public void initTop() {
        colTitle = new String[] {"编号","姓名","出生日期","民族","地址","部门"};
        colValue = PersonDao.getAllperson();
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

    //定义上部面板
    public void initCenter() {
        pCenter = new JPanel();
        lbDeptid = new JLabel("编号");
        tfPersonid = new JTextField(12);


        lbDeptid1 = new JLabel("姓名");
        tfDeptid1 = new JTextField(12);

        lbDeptid2 = new JLabel("部门");
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
        btnDelete = new JButton("删除部门");
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
