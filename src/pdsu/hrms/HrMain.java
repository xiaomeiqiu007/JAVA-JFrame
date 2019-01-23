package pdsu.hrms;

import pdsu.assess.panel18;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class HrMain extends JFrame implements TreeSelectionListener{
	//定义分隔面板
	public static JSplitPane splitPane; 
	//树菜单
	private JTree tree;
	private DefaultMutableTreeNode root;
	JPanel pWelcome;
	public  HrMain(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时退出
		setSize(700,450);//大小
		setLocationRelativeTo(null);//居中
		setResizable(false);//不可调大小
		setTitle("人事管理");
		//窗口图标
		//1，找到文件位置
		URL url =getClass().getClassLoader().getResource("1.PNG");
		//2，加载图片到内容
		Image image=Toolkit.getDefaultToolkit().getImage(url);
		//3，图片设置为窗口图标
		setIconImage(image);
		init();//调用初始化方法
		
		
		setVisible(true);
	}
	public void init() {
		//初始化面板
		splitPane =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(150);//分割条位置左侧150
		splitPane.setContinuousLayout(true);//分割条连续变动
		splitPane.setDividerSize(2);//分割面板宽度
		//添加测试用的组件
		splitPane.setLeftComponent(new Button("left"));
		splitPane.setRightComponent(new Button("欢迎来到人事管理系统"));
		
		//初始化树菜单DefaultMutableTreeNode
		root =new DefaultMutableTreeNode("人事管理系统");
		DefaultMutableTreeNode node1=
				new DefaultMutableTreeNode("基本信息管理");
		DefaultMutableTreeNode node2=
				new DefaultMutableTreeNode("人员调动管理");
		DefaultMutableTreeNode node3=
				new DefaultMutableTreeNode("人员考核管理");
		DefaultMutableTreeNode node4=
				new DefaultMutableTreeNode("劳资管理");
		
		DefaultMutableTreeNode leafNode= null;
		//添加基本信息
		//DefaultMutableTreeNode leafNode= null;
		node1.add(new DefaultMutableTreeNode("添加人员信息"));
		node1.add(new DefaultMutableTreeNode("删除人员信息"));
		node1.add(new DefaultMutableTreeNode("修改人员信息"));
		node1.add(new DefaultMutableTreeNode("查询人员信息"));
		node1.add(new DefaultMutableTreeNode("部门管理"));
		
		node2.add(new DefaultMutableTreeNode("人员调动"));
		node2.add(new DefaultMutableTreeNode("调动历史查询"));
		
		node3.add(new DefaultMutableTreeNode("人员考核"));
		node3.add(new DefaultMutableTreeNode("考核历史查询"));
		
		node4.add(new DefaultMutableTreeNode("劳资分配管理"));
		node4.add(new DefaultMutableTreeNode("劳资历史查询"));
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		
		//把树菜单添加到窗口中
		tree =new JTree(root);
		tree.addTreeSelectionListener(this);
		//splitPane.setLeftComponent(new JScrollPane(tree));
		//创建普通面板，再添加滚动面板
		JPanel pLeft =new JPanel();
		JScrollPane js= new JScrollPane(tree);
		js.setPreferredSize(new Dimension(140,410));
		pLeft.add(js);
		
		splitPane.setLeftComponent(pLeft);
		//分入到界面中
		//右侧欢迎界面
		pWelcome= new JPanel();
		JLabel lbWecome=new JLabel("欢迎使用人事管理系统");
		lbWecome.setFont(new Font("宋体", Font.PLAIN,16));
	
		
		add(splitPane);
		
	}
	public static void main(String[] args) {
		//修改程序外观
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new HrMain();
	}
	//对树菜单进行事件处理
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getPath());
		//System.out.println(e.getPath().getLastPathComponent());
		String menuStr=e.getPath().getLastPathComponent().toString();
		//System.out.println(menuStr);
		switch(menuStr) {
		//点击根节点
		case"人事管理系统": break;
		case"人员调动管理":break;
		case"人员考核管理":break;
		case"添加人员信息": splitPane.setRightComponent(new panel11());break;
		case "修改人员信息":splitPane.setRightComponent(new panel12());break;
		case "删除人员信息": splitPane.setRightComponent(new panel13());break;
		case "查询人员信息": splitPane.setRightComponent(new pdsu.hrms.panel14());break;
		case"部门管理": splitPane.setRightComponent(new pdsu.hrms.panel15());break;
		case "劳资分配管理": splitPane.setRightComponent(new pdsu.salary.panel20());break;
		case"劳资历史查询": splitPane.setRightComponent(new pdsu.salary.panel21());break;
		case "人员考核": splitPane.setRightComponent(new pdsu.assess.panel18());break;
		case "考核历史查询":splitPane.setRightComponent(new pdsu.assess.panel19());break;
		case "人员调动":splitPane.setRightComponent(new pdsu.personchange.panl16());break;
		case "调动历史查询":splitPane.setRightComponent(new pdsu.personchange.panl17());break;
		}
	
	}

}
