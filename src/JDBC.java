import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.* ;

public class JDBC {
    public static void main(String[] args){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            Statement smt=con.createStatement();
            smt.executeUpdate("create  table users(username VARCHAR2(50),password VARCHAR2(20))");
            System.out.println("successfully create");
            smt.executeUpdate("create table book(Book_Id INTEGER ,Book_Name VARCHAR2(50),Price DECIMAL,Publisher VARCHAR2(50)  )");
            System .out.println("Successfully create book table") ;
            smt.executeUpdate("CREATE  TABLE BOOK_ISSUE(BOOK_ID NUMBER ,STUDENT_ID NUMBER ,BOOK_NAME VARCHAR2(50),AUTHOR VARCHAR2(50),ISSUE_DATE DATE,DUE_DATE DATE )");
            System.out.println("Successfully create  book_Issue table") ;
            smt.executeUpdate("CREATE TABLE BOOK_RETURN(BOOK_ID INTEGER ,STUDENT_ID INTEGER ,BOOK_NAME VARCHAR2(100),ISSUE_DATE DATE ,RETURN_DATE DATE,DUE_DATE DATE,FINE DECIMAL )");
            System.out.println("Successfully create  book_RETURN table") ;
            smt.executeUpdate("CREATE TABLE STUDENT_REGISTERATION(Student_ID INTEGER , Student_Name VARCHAR2(50), Course_Name VARCHAR2(50),SEMESTER INTEGER , Branch_Name VARCHAR2(50), Email VARCHAR2(50), Mobile_Number VARCHAR(10))") ;
            System.out.println("Successfully create  STUDENT_REGISTERATION table") ;

            con.close();

        }catch (Exception e){
            System .out.println(e);

        }
    }
}
