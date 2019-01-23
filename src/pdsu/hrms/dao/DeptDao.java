package pdsu.hrms.dao;

import pdsu.hrms.HrMain;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptDao {
    public static String[][] getAllDept(){
        String sql="select * from Dept";
        String[][] str=new String[100][100];
        int flag=0;
        try{
            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                str[flag][0]=String.valueOf(rs.getInt("deptId"));
                str[flag][1]=rs.getString("dept1Name");
                str[flag][2]=rs.getString("dept2name");
                flag=flag+1;
            }
        }catch (Exception e){
            System.out.print("sql执行语句失败");
        }
        return str;
    }
    public  static int addDept(String deptid,String dept1Name,String dept2Nname){
        int flag=0;
        try {
            int deptId=Integer.valueOf(deptid);
            String sql ="insert into dept values("+deptId+",'"+dept1Name+"','"+dept2Nname+"')";
            Statement st = JDBCUtil.getConnection();
            flag= st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据添加成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据添加失败", "请检查你的输入", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    public static int deleteDept(String deptid){
        int flag=0;
        try {
            int deptId=Integer.valueOf(deptid);
            String sql= "delete from dept where deptId="+deptId;
            Statement st = JDBCUtil.getConnection();
            flag= st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据删除成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据删除失败", "请检查你的输入", JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }
    public static int updateDept(String deptid,String dept1Name,String dept2Nname){
        int flag=0;
        try {
            int deptId=Integer.valueOf(deptid);
            String sql ="update  dept set dept1Name='"+dept1Name+"',dept2Name='"+dept2Nname+"' where deptId="+deptId;
            Statement st = JDBCUtil.getConnection();
            flag= st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "数据修改成功", "数据删除成功", JOptionPane.WARNING_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据更新失败", "请检查你的输入", JOptionPane.ERROR_MESSAGE);
        }
        return flag;

    }
    public static int nextId(){
        int flag=0;
        try{
            String sql="select max(deptid) from dept";
            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                flag=rs.getInt("max(deptid)");
            }
        }catch (Exception e){

        }
        return flag;
    }
}
