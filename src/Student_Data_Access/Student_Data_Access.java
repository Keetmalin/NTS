/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_Data_Access;

import Connection.DBConnector;
import Student_Domain.Student;
import Subject_Domain.Subject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Pasindu Tennage
 */
public class Student_Data_Access {

    private DBConnector connector;
    
    public LinkedList<String> getStudentList() throws ClassNotFoundException, SQLException {
        LinkedList<String> list= new LinkedList<String>();
        String sql2 = "SELECT * FROM student";
        ResultSet rs2 = connector.getQuerry(sql2);
        
        while(rs2.next()){
            list.add(rs2.getString("name"));            
        }
        
        
        return list;
    }
    
    public Student_Data_Access(DBConnector connector) {
        this.connector = connector;
    }

    public void createNewStudent(int ID, String Name, Date DOB, int Batch, String Address, String NIC, int Phone, Date date, String Guadian1Name, int Guadian1Telephone, String Guadian1Address, String Guadian2Name, int Guadian2Telephone, String Guadian2Address, boolean hostel, int level, String Picture) throws ClassNotFoundException, SQLException {
        String sql;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sql = "INSERT INTO student VALUES ('" + ID + "', '" + Name + "', '" + sdf.format(DOB) + "','"
                + Batch + "', '" + Address + "', '" + NIC + "','" + Phone + "', '" + sdf.format(date) + "', '"
                + Guadian1Name + "','" + Guadian1Telephone + "', '" + Guadian1Address + "', '"
                + Guadian2Name + "','" + Guadian2Telephone + "', '" + Guadian2Address + "', '"
                + ((hostel) ? 1 : 0) + "' , '" + level + "','" + Picture + "')";

        connector.updateTable(sql);
    }

    public Student getProfile(String name, int batch, int level) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql;
        sql = "SELECT * FROM student WHERE name LIKE '%" + name + "%' AND batch LIKE '%" + batch + "%' AND level LIKE '%" + level + "%'";

        //result set to get selected row of the database
        ResultSet rs = connector.getQuerry(sql);

        //create vector to add each field in the student table
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getInt("student_id"));
            v.add(rs.getString("name"));
            v.add(rs.getDate("date_of_birth"));
            v.add(rs.getInt("batch"));
            v.add(rs.getString("address"));
            v.add(rs.getString("nic"));
            v.add(rs.getInt("phone_number"));
            v.add(rs.getDate("registration_date"));
            v.add(rs.getString("guardian_one_name"));
            v.add(rs.getInt("guardian_one_telephone"));
            v.add(rs.getString("guardian_one_address"));
            v.add(rs.getString("guardian_two_name"));
            v.add(rs.getInt("guardian_two_telephone"));
            v.add(rs.getString("guardian_two_address"));
            v.add(rs.getBoolean("hostel_student"));
            v.add(rs.getInt("level"));
            v.add(rs.getString("picture"));
        }
        //create new student object
        //this throwa an exception when all three fields are not matching
        Student student = new Student((int) v.get(0), (String) v.get(1), (Date) v.get(2), (int) v.get(3),
                (String) v.get(4), (String) v.get(5), (int) v.get(6), (Date) v.get(7), (String) v.get(8), (int) v.get(9), (String) v.get(10),
                (String) v.get(11), (int) v.get(12), (String) v.get(13), (Boolean) v.get(14), (int) v.get(15), (String) v.get(16));

        return student;
    }

    public Student getProfile(int id) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql;
        sql = "SELECT * FROM student WHERE student_id LIKE '%" + id + "%'";

        //result set to get selected row of the database
        ResultSet rs = connector.getQuerry(sql);

        //create vector to add each field in the student table
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getInt("student_id"));
            v.add(rs.getString("name"));
            v.add(rs.getDate("date_of_birth"));
            v.add(rs.getInt("batch"));
            v.add(rs.getString("address"));
            v.add(rs.getString("nic"));
            v.add(rs.getInt("phone_number"));
            v.add(rs.getDate("registration_date"));
            v.add(rs.getString("guardian_one_name"));
            v.add(rs.getInt("guardian_one_telephone"));
            v.add(rs.getString("guardian_one_address"));
            v.add(rs.getString("guardian_two_name"));
            v.add(rs.getInt("guardian_two_telephone"));
            v.add(rs.getString("guardian_two_address"));
            v.add(rs.getBoolean("hostel_student"));
            v.add(rs.getInt("level"));
            v.add(rs.getString("picture"));
        }
        //create new student object
        Student student = new Student((int) v.get(0), (String) v.get(1), (Date) v.get(2), (int) v.get(3),
                (String) v.get(4), (String) v.get(5), (int) v.get(6), (Date) v.get(7), (String) v.get(8), (int) v.get(9), (String) v.get(10),
                (String) v.get(11), (int) v.get(12), (String) v.get(13), (Boolean) v.get(14), (int) v.get(15), (String) v.get(16));

        return student;
    }

    public void updateStudent(int id, String name, Date dob, int batch, String address, String nic, int phone, Date date, String guadian1Name, int guadian1Telephone, String guadian1Address, String guadian2Name, int guadian2Telephone, String guadian2Address, boolean hostel, int level, String picture) throws ClassNotFoundException, SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String sql;
        int intHostel = 0;
        if (hostel) {
            intHostel = 1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sql = "UPDATE student SET student_id='" + id + "',name='" + name
                + "',date_of_birth='" + sdf.format(dob) + "',batch='" + batch + "',address='"
                + address + "',nic='" + nic + "',phone_number='"
                + phone + "',registration_date='" + sdf.format(date) + "',guardian_one_name='"
                + guadian1Name + "',guardian_one_telephone='" + guadian1Telephone + "',guardian_one_address='"
                + guadian1Address + "',guardian_two_name='" + guadian2Name + "',guardian_two_telephone='"
                + guadian2Telephone + "',guardian_two_address='" + guadian2Address + "',hostel_student='"
                + intHostel + "',level='" + level + "',picture='" + picture
                + "' WHERE student_id='" + id + "'";

        connector.updateTable(sql);
    }

    public Object[][] getDailyAttendance(int id) throws ClassNotFoundException, SQLException {
        DBConnector db = new DBConnector();
        Student_Data_Access sda = new Student_Data_Access(db);
        String table_Name = "level" + sda.getProfile(id).getLevel() + "_batch" + sda.getProfile(id).getBatch() + "_daily_attendance";

        String sql = "SELECT * FROM information_schema.columns WHERE TABLE_NAME = '" + table_Name + "'";
        ResultSet rs = connector.getQuerry(sql);

        int row = 0;
        //this iwll get the row count
        while (rs.next()) {
            row++;
        }
        //set the cursor of the result set to the beginning
        rs.beforeFirst();

        Object[][] o = new Object[2][row - 1];
        int i = 0;
        rs.next();
        while (rs.next()) {
            o[0][i] = rs.getString("COLUMN_NAME");
            i++;
        }
        sql = "SELECT * FROM " + table_Name + " WHERE student_id LIKE '%" + id + "%'";
        rs = connector.getQuerry(sql);
        i = 0;
        while (rs.next()) {
            o[1][i] = rs.getInt(i + 2);
            i++;
        }

        return o;
    }

    

    public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
        String sql;

        sql = "DELETE FROM student WHERE student_id = " + id;
        connector.updateTable(sql);
    }

    public Student getNextStudent(int index) throws ClassNotFoundException, SQLException {
        String sql ="select * from student where student_id = (select min(student_id) from student where student_id > "+index+")";
        
        //result set to get selected row of the database
        ResultSet rs = connector.getQuerry(sql);

        //create vector to add each field in the student table
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getInt("student_id"));
            v.add(rs.getString("name"));
            v.add(rs.getDate("date_of_birth"));
            v.add(rs.getInt("batch"));
            v.add(rs.getString("address"));
            v.add(rs.getString("nic"));
            v.add(rs.getInt("phone_number"));
            v.add(rs.getDate("registration_date"));
            v.add(rs.getString("guardian_one_name"));
            v.add(rs.getInt("guardian_one_telephone"));
            v.add(rs.getString("guardian_one_address"));
            v.add(rs.getString("guardian_two_name"));
            v.add(rs.getInt("guardian_two_telephone"));
            v.add(rs.getString("guardian_two_address"));
            v.add(rs.getBoolean("hostel_student"));
            v.add(rs.getInt("level"));
            v.add(rs.getString("picture"));
        }
        //create new student object
        Student student = new Student((int) v.get(0), (String) v.get(1), (Date) v.get(2), (int) v.get(3),
                (String) v.get(4), (String) v.get(5), (int) v.get(6), (Date) v.get(7), (String) v.get(8), (int) v.get(9), (String) v.get(10),
                (String) v.get(11), (int) v.get(12), (String) v.get(13), (Boolean) v.get(14), (int) v.get(15), (String) v.get(16));

        return student;
    }
    
    public Student getPreviousStudent(int index) throws ClassNotFoundException, SQLException {
        String sql ="select * from student where student_id = (select max(student_id) from student where student_id < "+index+")";
        
        //result set to get selected row of the database
        ResultSet rs = connector.getQuerry(sql);

        //create vector to add each field in the student table
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getInt("student_id"));
            v.add(rs.getString("name"));
            v.add(rs.getDate("date_of_birth"));
            v.add(rs.getInt("batch"));
            v.add(rs.getString("address"));
            v.add(rs.getString("nic"));
            v.add(rs.getInt("phone_number"));
            v.add(rs.getDate("registration_date"));
            v.add(rs.getString("guardian_one_name"));
            v.add(rs.getInt("guardian_one_telephone"));
            v.add(rs.getString("guardian_one_address"));
            v.add(rs.getString("guardian_two_name"));
            v.add(rs.getInt("guardian_two_telephone"));
            v.add(rs.getString("guardian_two_address"));
            v.add(rs.getBoolean("hostel_student"));
            v.add(rs.getInt("level"));
            v.add(rs.getString("picture"));
        }
        //create new student object
        Student student = new Student((int) v.get(0), (String) v.get(1), (Date) v.get(2), (int) v.get(3),
                (String) v.get(4), (String) v.get(5), (int) v.get(6), (Date) v.get(7), (String) v.get(8), (int) v.get(9), (String) v.get(10),
                (String) v.get(11), (int) v.get(12), (String) v.get(13), (Boolean) v.get(14), (int) v.get(15), (String) v.get(16));

        return student;
    }
    public String getCurrentSemesterStartingDate(int batch) throws SQLException, ClassNotFoundException{
         String sql;
        sql = "SELECT * FROM semester_startdate WHERE batch LIKE '%" + batch + "%'";
        ResultSet rs = connector.getQuerry(sql);
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("semester_one");
        list.add("semester_two");
        list.add("semester_three");
        list.add("semester_four");
        list.add("semester_five");
        list.add("semester_six");
        list.add("semester_seven");
        list.add("semester_eight");
        list.add("semester_nine");
         
        if (rs.next()){
            int i=0;
            while (rs.getString(list.get(i))!=null){
               i++;     
            }
            return rs.getString(i+1);
            
            
        }
        
        return null;
    }
    public String getCurrentSemesterNumber(int batch) throws SQLException, ClassNotFoundException{
        String sql;
        sql = "SELECT * FROM semester_startdate WHERE batch LIKE '%" + batch + "%'";
        ResultSet rs = connector.getQuerry(sql);
        
        LinkedList<String> list = new LinkedList<String>();
        list.add("semester_one");
        list.add("semester_two");
        list.add("semester_three");
        list.add("semester_four");
        list.add("semester_five");
        list.add("semester_six");
        list.add("semester_seven");
        list.add("semester_eight");
        list.add("semester_nine");

        if(rs.next()){
            int i =0;
            while (rs.getString(list.get(i))!=null){
                i++;
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            return rsmd.getColumnName(i+1);
        }
         
        return null;
    }
    
    public Object[][] getAllResults(int index, int level) {
        return null;
    }

    public Object[][] getSubjectAttendance(int index, Subject subject) throws ClassNotFoundException, SQLException {
        DBConnector db = new DBConnector();
        Student_Data_Access sda = new Student_Data_Access(db);
        //String table_Name = "level" + subject.getLevel() + "_batch" + sda.getProfile(index).getBatch() + "_daily_attendance";

        
        String table_Name = "level" +  subject.getLevel() + "_batch" + sda.getProfile(index).getBatch() + "_" + subject.getCode() + "_subject_attendance";
        String sql = "SELECT * FROM information_schema.columns WHERE TABLE_NAME = '" + table_Name + "'";
        ResultSet rs = connector.getQuerry(sql);

        int row = 0;
        //this iwll get the row count
        while (rs.next()) {
            row++;
        }
        //set the cursor of the result set to the beginning
        rs.beforeFirst();

        String sql2 = "SELECT * FROM "+table_Name +" WHERE student_id LIKE '%" + index+ "%'";
        ResultSet rs2 = connector.getQuerry(sql2);
        ResultSetMetaData rsmd = rs2.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Object[][] o = new Object[2][columnsNumber];
        int i = 0;
        rs.next();
        while (rs.next()) {
            o[0][i + 1] = rs.getString("COLUMN_NAME");
            i++;
        }

        i = 1;
        while (rs2.next()) {
            for (int j = 0; j < columnsNumber; j++) {
                o[i][j] = rs2.getInt(j + 1);
            }
            i++;
        }

        return o;
    }
}
