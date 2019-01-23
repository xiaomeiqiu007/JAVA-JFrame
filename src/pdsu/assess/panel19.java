package pdsu.assess;

import pdsu.assess.Dao.AccessDao;
import pdsu.salary.Dao.PersonSalary;

import javax.swing.*;
import java.awt.*;

public class panel19 extends JPanel{
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
    private JTextField tfPersonid;
    private JTextField tfDeptid1;
    private JTextField tfDeptid2;
    private String[][] colValue ;
    private String[] colTitle;

    public panel19() {
        //设置为边界布局
        setLayout(new BorderLayout());
        initTop();

        //事件处理利用的是对应的借口，必须重写其中的抽象方法

    }

    //初始化上部
    public void initTop() {
        colTitle = new String[] {"流水号","人员姓名","原考核","现考核","变更次数","变更日期"};
        colValue = AccessDao.getAllHistory();
        table = new JTable(colValue,colTitle);
        pTop =new JPanel();
        //创建空表格
        //设置表格的默认大小

        table.setPreferredScrollableViewportSize(new Dimension(430, 300));

        js = new JScrollPane(table);
        js.setPreferredSize(new Dimension(450, 300));
        pTop.add(js);
        add(pTop,BorderLayout.NORTH);
    }

    //定义上部面板
}
