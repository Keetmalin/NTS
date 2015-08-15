/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attendance_Data_Access;

import Connection.DBConnector;
import Subject_Domain.Subject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pasindu Tennage
 */
public class Subject_Attendance_Data_Access extends Attendace_Data_Access {

    public Subject_Attendance_Data_Access(DBConnector connector) {
        super(connector);
    }

    public void saveToDatabase(int[][] table, Date date, int batch, int level, int LectureNumber, Subject subject) throws ClassNotFoundException, SQLException {
        //to make the table name according to given parameters
        String tableName = "level" + level + "_batch" + batch + "_" + subject.getCode() + "_subject_attendance";
        //this will create final sql statement for execution
        String sql;
        Format formatter = new SimpleDateFormat("yyyy_MM_dd");
        String s = formatter.format(date);
        sql = "CREATE TABLE " + tableName + " (student_id int NOT NULL, L" + LectureNumber + "_" + s + " int NOT NULL, PRIMARY KEY (student_id));";

        this.connector.createNewTable(sql);
        for (int i = 0; i < table.length; i++) {
            sql = "INSERT INTO " + tableName + " VALUES (" + table[i][0] + " , " + table[i][1] + ")";
            connector.updateTable(sql);
        }
    }

    public int[][] getSubjectAttendance(Date date, int batch, int level, int LectureNumber, Subject subject) throws ClassNotFoundException, SQLException {
        //table name that we require
        String tableName = "level" + level + "_batch" + batch + "_" + subject.getCode() + "_subject_attendance";
        //create sql statememt
        String sql;
        sql = "SELECT * FROM " + tableName;
        ResultSet rs = connector.getQuerry(sql);
        //this iwll be used to store the datbase as an array
        int[][] list = null;
        int row = 0;
        //this iwll get the row count
        while (rs.next()) {
            row++;
        }
        //set the cursor of the result set to the beginning
        rs.beforeFirst();
        list = new int[row][2];
        //assign the table values to a 2D Array
        int i = 0;
        Format formatter = new SimpleDateFormat("yyyy_MM_dd");
        String s = formatter.format(date);
        while (rs.next()) {
            list[i][0] = rs.getInt("student_id");
            list[i][1] = rs.getInt("L" + LectureNumber + "_" + s);
            i++;
        }
        return list;
    }

    public void updateSubjectAttendance(int[][] table, Date date, int batch, int level, int LectureNumber, Subject subject) throws ClassNotFoundException, SQLException {
        //make table name
        String tableName = "level" + level + "_batch" + batch + "_" + subject.getCode() + "_subject_attendance";
        String sql;

        Format formatter = new SimpleDateFormat("yyyy_MM_dd");
        String s = formatter.format(date);

        //String sql2 = "IF COL_LENGTH( "+tableName+" , L" + LectureNumber + "_" + s+ " ) IS NULL BEGIN ALTER TABLE "+tableName+" ADD [L" + LectureNumber + "_" + s+"] INT END";
        try {
            for (int i = 0; i < table.length; i++) {
                //connector.updateTable(sql2);
                sql = "UPDATE " + tableName + " SET student_id=" + table[i][0] + ",L" + LectureNumber + "_" + s + "=" + table[i][1] + " WHERE student_id=" + table[i][0];
                connector.updateTable(sql);
            }
            //will catch if there is no such column and we need to create a new column in our table
        } catch (MySQLSyntaxErrorException m) {
            sql = "ALTER TABLE " + tableName + " ADD " + "L" + LectureNumber + "_" + s + " int not null";
            connector.updateTable(sql);
            for (int i = 0; i < table.length; i++) {
                //connector.updateTable(sql2);
                sql = "UPDATE " + tableName + " SET student_id=" + table[i][0] + ",L" + LectureNumber + "_" + s + "=" + table[i][1] + " WHERE student_id=" + table[i][0];
                connector.updateTable(sql);
            }
        }

    }

    //public int[][] getSubjectWarnings(Subject subject){return null;}

    public Object[][] getSubjectAttendanceReports(int batch, int level, Subject subject) throws SQLException, ClassNotFoundException {
        DBConnector db = new DBConnector();
        //Student_Data_Access sda = new Student_Data_Access(db);
        String tableName = "level" + level + "_batch" + batch + "_" + subject.getCode() + "_subject_attendance";

        String sql = "SELECT * FROM information_schema.columns WHERE TABLE_NAME = '" + tableName + "'";
        ResultSet rs = connector.getQuerry(sql);

        int row = 0;
        //this iwll get the row count
        while (rs.next()) {
            row++;
        }
        //set the cursor of the result set to the beginning
        rs.beforeFirst();

        String sql2 = "SELECT * FROM " + tableName;
        ResultSet rs2 = connector.getQuerry(sql2);
        ResultSetMetaData rsmd = rs2.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        Object[][] o = new Object[row + 1][columnsNumber];
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
