import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.String.*;

public class JDBC_insert {
    public static void main(String[]args){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            PreparedStatement pst = con.prepareStatement("insert into users values (?,?)");
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in ));
            while(true){
                System.out.println("Enter username");
                String username = br.readLine();
                System.out.println("Enter password");
                String password = br.readLine() ;
                pst.setString(1,username );
                pst.setString(2,password);
                int count=pst.executeUpdate();
                if(count>0) {
                    System.out.println(count + "record inserted");
                }
                    else{
                        System.out.println("Do not want to more Records...");
                        String ch=br.readLine();
                        if(ch.equalsIgnoreCase(" ") ) {
                            break;
                        }

                    }

            }


        }catch (Exception e) {
            System.out.println(e);
        }


        }
    }

