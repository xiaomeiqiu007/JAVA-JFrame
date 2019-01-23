package pdsu.salary.Dao;

import pdsu.hrms.dao.JDBCUtil;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonSalary {
    public static String[][] getAllperson(){
        String[][] str = new String[100][100];
        String[] deptid = new String[100];
        int flag=0;
        try{
            String sql="select * from person";

            Statement st = JDBCUtil.getConnection();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[flag][0]=String.valueOf(rs.getInt("personId"));
                str[flag][1]=rs.getString("pName");
                str[flag][2]=rs.getString("sex");
                str[flag][4]=rs.getString("salary");
                str[flag][5]=rs.getString("assess");
                deptid[flag]=String.valueOf(rs.getInt("deptId"));
                flag=flag+1;
            }
            for(int i=0;i<deptid.length;i++){
                String sql1="select dept1Name,dept2Name from dept where deptId=";
                sql1=sql1+deptid[i];
                ResultSet rd =st.executeQuery(sql1);
                while (rd.next()){
                    str[i][3]=rd.getString("dept1Name")+"-"+rd.getString("dept2Name");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
    public static String[] getHistId(String histype,int personId){
        String[] str=new String[10];
        str[0]="0";
        str[1]="0";
        try{
            String sql="select max(chgNum) as chgNum from history where histType='"+histype+"' and personId="+personId;
            String sql1="select max(histId) from history";
            Statement st =JDBCUtil.getConnection();
            System.out.print(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                str[0]=rs.getString("chgNum");
            }
            ResultSet rd = st.executeQuery(sql1);
            while (rd.next()){
                str[1]=String.valueOf(rd.getInt("max(histId)")+1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if(str[0]==null){
            str[0]="1";
        }else {
            str[0]=String.valueOf(Integer.valueOf(str[0])+1);
        }
        return str;
    }
    public static int changeSalary(String changeType,String personid,String poldsalary,String pnewsalary){
        int flag=0;
        try{

            String[] str =new String[100];
            int personId =Integer.valueOf(personid);
            str=PersonSalary.getHistId(changeType,personId);
            System.out.println(str[0]);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String sql ="update  person set salary='"+pnewsalary+"' where personId="+personId;
            String sql2="insert into history values("+str[1]+",'"+changeType+"','"+poldsalary+"','"+pnewsalary+"','"+df.format(new Date())+"','"+str[0]+"',"+personId+")";
            Statement st = JDBCUtil.getConnection();
            System.out.print(sql);
            flag=st.executeUpdate(sql);
                try {
                    System.out.print(sql2);
                    st.executeUpdate(sql2);
                }catch (Exception e){
                    e.printStackTrace();
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static String[][] getAllHistory(){
        String[][] str =new String[100][100];
        int flag=0;
        String[] str1 = new String[10];
        try{
            String sql ="select * from history where histType='ÀÍ×Ê·ÖÅä'";
            Statement st =JDBCUtil.getConnection();
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()){
                str[flag][0]=String.valueOf(rs.getInt("histid"));
                str1[flag]=rs.getString("personId");
                str[flag][2]=String.valueOf(rs.getString("oldInfo"));
                str[flag][3]=String.valueOf(rs.getString("newInfo"));
                str[flag][4]=rs.getString("chgNum");
                str[flag][5]=String.valueOf(rs.getString("chgDate"));
                flag=flag+1;
            }
            for(int i=0;i<str1.length;i++){
                String sql2 = "select pName from person where personid=";
                sql2=sql2+str1[i];
                ResultSet rd =st.executeQuery(sql2);
                while (rd.next()){
                    str[i][1]=rd.getString("pName");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
