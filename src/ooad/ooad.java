/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ooad;

import java.sql.DriverManager;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.regex.*;
/**
 *
 * @author 2mk
 */
public class ooad {
    int k=0,countt=0,cc=0;
            String tt="",qq=""; 
            String boardCity="";
            String destCity="";
            String nbname="";
            String val="";
            String mov="";
            String dat="";
            String cinema="";
            String time="";
            String hotel="";
            String item="";
            String cost="";
            String qq1="";
            int quantity;
            int type;
           // String time="";
            int scount=0;
            
            int tsum=0,tfid=0;
        void login(String username,String password) throws SQLException{
        try{
            Scanner s=new Scanner(System.in);
            int cc=0;
        String query="select * from users;";
       // String query="select * from users;";
        Connection con=DB.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        while (rs.next()) {
        if(username.equals(rs.getString("uname")))
                { 
                    if(password.equals(rs.getString("pass"))){
                    System.out.println("WELCOME "+rs.getString("name"));
                    while(true){
                        System.out.println("Enter 1 for new booking , 2 to cancel booking");
                        int cho=s.nextInt();
                    switch(cho){
                        case 1:
                    category(username);
                    break;
                        case 2:
                    cancel(username);
                    break;
                    
                    }
                    }
                    
                }       
                }
        }
        if(cc==0){
                    System.out.println("Check your username or password!!!");
                     System.out.println("Enter username\n");
            String uname=s.next();
            System.out.println("Enter Password\n");
            String pass=s.next();
            login(uname,pass);
        }
        }
        catch(Exception e){}
        }
        void cancel(String uname){
               while(true){
               System.out.println("Enter 1 for bus cancellation, 2 for movie cancellation ,3 for food cancellation and 4 to exit\n ");
               Scanner s=new Scanner(System.in);
               int cho=s.nextInt();
               switch(cho){
                   case 1:
                        String query="select * from busHistory where uname='"+uname+"';";
                       
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                      
                     while (rs.next()) {
                     //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                     //{
                                 System.out.println(rs.getString("bookid")+" "+rs.getString("uname")+" "+rs.getString("bname")+" "+rs.getString("board")+" "+rs.getString("dest")+" "+rs.getString("time")+" "+rs.getString("amountPaid")+" "+rs.getString("seatNo"));
                     //}       
                   }
                     System.out.println("Select the booking id to cancel");
                     int bod=s.nextInt();
                     String qq="delete from busHistory where bookid='"+bod+"';";
                     stmt.executeUpdate(qq);
                     System.out.println("Cancellation successful");
                     
                    }
                    catch(Exception e){}
                       break;
                   case 2:
                        query="select * from movieHistory where uname='"+uname+"';";
                       
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                      
                     while (rs.next()) {
                     //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                     //{
                                 System.out.println(rs.getString("bookid")+" "+rs.getString("uname")+" "+rs.getString("cinema")+" "+rs.getString("mov")+" "+rs.getString("dat")+" "+rs.getString("time")+" "+rs.getString("amountPaid")+" "+rs.getString("seatNo"));
                     //}       
                   }
                     System.out.println("Select the booking id to cancel");
                     int bod=s.nextInt();
                     String qq="delete from movieHistory where bookid='"+bod+"';";
                     stmt.executeUpdate(qq);
                     System.out.println("Cancellation successful");
                     
                    }
                    catch(Exception e){}
                       break;
                   case 3:
                       
                        query="select * from foodHistory where uname='"+uname+"';";
                    //   System.out.println("**");
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                      
                     while (rs.next()) {
                     //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                     //{
                                 System.out.println(rs.getString("bookid")+" "+rs.getString("uname")+" "+rs.getString("hotel")+" "+rs.getString("item")+" "+rs.getString("amountPaid"));
                     //}       
                   }
                     System.out.println("Select the booking id to cancel");
                     int bod=s.nextInt();
                     String qq="delete from foodHistory where bookid='"+bod+"';";
                     stmt.executeUpdate(qq);
                     System.out.println("Cancellation successful");
                     
                    }
                    catch(Exception e){}
                       
                       break;
                   case 4:
                       System.exit(1);
               }
               }   
               
        }
        void category(String uname){
        while(true){
        System.out.println("Enter 1 for bus booking, 2 for movie booking ,3 for food order and 4 to exit\n ");
        Scanner s=new Scanner(System.in);
        int cho=s.nextInt();
        switch(cho){
            case 1:
                busBooking(uname);
                break;
            case 2:
                movieBooking(uname);
                break;
            case 3:
                orderFood(uname);
                break;
            case 4:
                System.exit(1);
        }
        }
        }
        void busBooking(String uname){
            type=1;
            int k=0,countt=0,cc=0,tot=0;
            int[] val1=new int[40];
            Scanner s=new Scanner(System.in);
            System.out.println("/*** BUS BOOKING ***/");
            System.out.println("Enter the boarding city");
            System.out.println("Enter 1 for madurai 2 for trichy 3 for chennai 4 for coimbatore");
            int board=s.nextInt();
            System.out.println("Enter the destination city");
            switch(board){
                case 1:
                    System.out.println("Enter 1 for trichy 2 for chennai 3 for coimbatore");
                    int dest=s.nextInt();
                    if(dest==1){
                        destCity="trichy";
                    }
                    else if(dest==2){
                        destCity="chennai";
                    }
                    else if(dest==3){
                        destCity="coimbatore";
                    }
                    break;
                case 2:
                    System.out.println("Enter 1 for madurai 2 for chennai 3 for coimbatore");
                    dest=s.nextInt();
                    if(dest==1){
                        destCity="madurai";
                    }
                    else if(dest==2){
                        destCity="chennai";
                    }
                    else if(dest==3){
                        destCity="coimbatore";
                    }
                    break;
                case 3:
                    System.out.println("Enter 1 for madurai 2 for trichy 3 for coimbatore");
                    dest=s.nextInt();
                    if(dest==1){
                        destCity="madurai";
                    }
                    else if(dest==2){
                        destCity="trichy";
                    }
                    else if(dest==3){
                        destCity="coimbatore";
                    }
                    break;
                case 4:
                    System.out.println("Enter 1 for madurai 2 for trichy 3 for chennai");
                    dest=s.nextInt();
                    if(dest==1){
                        destCity="madurai";
                    }
                    else if(dest==2){
                        destCity="trichy";
                    }
                    else if(dest==3){
                        destCity="chennai";
                    }
                    break;
            }       
            if(board==1){
                boardCity="madurai";
            }
            else if(board==2){
                boardCity="trichy";
            }
            else if(board==3){
                boardCity="chennai";
            }
            else if(board==4){
                boardCity="coimbatore";
            }
            
                    String query="select * from buses where boarding='"+boardCity+"' and destination='"+destCity+"' ;";
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     while (rs.next()) {
                     //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                     //{
                                 System.out.println(rs.getString("bname")+"\n"+rs.getString("time"));
                     //}       
                   }
                     String qqo="select max(bookid) from busHistory;";
                     rs=stmt.executeQuery(qqo);
                     while(rs.next()){
                     tt=rs.getString(1);
                     }
                     int tbid=Integer.parseInt(tt);
                    // System.out.println("THe value is"+tbid);
                     System.out.println("Enter the bus of your choice");
                     nbname=s.next();
                     switch(nbname){
                                 case "parveen":
                                     String query1="select * from buses where bname='"+nbname+"' and boarding='"+boardCity+"' and destination='"+destCity+"';";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                    // val=rs.getString("seatCount");
                                     cost=rs.getString("cost");
                                     time=rs.getString("time");
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    cc=Integer.parseInt(cost);
                                    
                                    query1="select * from busHistory;";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     val=rs.getString("seatNo");
                                     val1[k]=Integer.parseInt(val);
                                     k++;
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    tot=40;
                     //scount=Integer.parseInt(val);
                                    System.out.println("\n");
                                    for(int i=1;i<=40;i++)
                                    {
                                        for(int j=1;j<=k;j++){
                                            if(i!=val1[j]){
                                            countt++;
                                            }
                                        }
                                        if(countt==k){
                                            if(i<10){
                                            System.out.print(i+"   ");
                                            }
                                            else
                                                System.out.print(i+"  ");
                                        }
                                        else{
                                        System.out.print("x   ");
                                        tot--;
                                        }
                                        countt=0;
                                        if(i%2==0){
                                            System.out.print("\t");
                                        }
                                        if(i%2==0&&i%4==0){
                                            System.out.print("\n");
                                        }
                                    }
                                    System.out.print("\n");
                                    tbid++;
                                    System.out.println("Cost of tickets is "+cost);
                                    System.out.println("Enter no of seats to book");
                                    int qua=s.nextInt();
                                    tsum=cc*qua;
                                    int[] scountt=new int[20];
                                    if(qua<tot){
                                        
                                        for(int i=0;i<qua;i++){
                                    System.out.println("Enter seat no to book");
                                     scountt[i]=s.nextInt();
                                    //int scount=0;
                                     
                                     //System.out.println( "Seats already booked is"+scount);
                                    // System.out.println("inside kpn");
                                 
                                         
                                         
                                         String qq1="insert into busHistory values('"+tbid+"','"+uname+"','"+nbname+"','"+boardCity+"','"+destCity+"','"+time+"','"+cost+"','"+scountt[i]+"');";
                                         try{
                                         stmt.executeUpdate(qq1);
                                         //scount+=1;
                                         }catch(Exception e){}
                                         
                                        }
                                    }
                                         System.out.println("Seats available\n Procced to payment");
                                      
                                         payment(type,uname,tbid,scount,tsum);
                                         System.exit(1);
                                         
                                     break;
                                 case "kpn":
                                     
                     //System.out.println("inside kpn");
                                     
                                     query1="select * from buses where bname='"+nbname+"' and boarding='"+boardCity+"' and destination='"+destCity+"';";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     //val=rs.getString("seatCount");
                                     cost=rs.getString("cost");
                                     
                                     time=rs.getString("time");
                                     }
                                    }
                                    catch(Exception e){
                                    }           cc=Integer.parseInt(cost);
                                    
                                    query1="select * from busHistory;";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     val=rs.getString("seatNo");
                                     val1[k]=Integer.parseInt(val);
                                     k++;
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    tot=40;
                     //scount=Integer.parseInt(val);
                                    System.out.println("\n");
                                    for(int i=1;i<=40;i++)
                                    {
                                        for(int j=1;j<=k;j++){
                                            if(i!=val1[j]){
                                            countt++;
                                            }
                                        }
                                        if(countt==k){
                                            if(i<10){
                                            System.out.print(i+"   ");
                                            }
                                            else
                                                System.out.print(i+"  ");
                                        }
                                        else{
                                        System.out.print("x   ");
                                        tot--;
                                        }
                                        countt=0;
                                        if(i%2==0){
                                            System.out.print("\t");
                                        }
                                        if(i%2==0&&i%4==0){
                                            System.out.print("\n");
                                        }
                                    }
                                    System.out.print("\n");
                                    tbid++;
                                    System.out.println("Cost of tickets is "+cost);
                                    System.out.println("Enter no of seats to book");
                                    qua=s.nextInt();
                                    tsum=cc*qua;
                                    int[] scountt1=new int[20];
                                    if(qua<tot){
                                        
                                        for(int i=0;i<qua;i++){
                                    System.out.println("Enter seat no to book");
                                     scountt1[i]=s.nextInt();
                                    //int scount=0;
                                     
                                     //System.out.println( "Seats already booked is"+scount);
                                    // System.out.println("inside kpn");
                                 
                                         
                                         
                                         String qq1="insert into busHistory values('"+tbid+"','"+uname+"','"+nbname+"','"+boardCity+"','"+destCity+"','"+time+"','"+cost+"','"+scountt1[i]+"');";
                                         try{
                                         stmt.executeUpdate(qq1);
                                         //scount+=1;
                                         }catch(Exception e){}
                                         
                                        }
                                    }
                                         System.out.println("Seats available\n Procced to payment");
                                      
                                         payment(type,uname,tbid,scount,tsum);
                                         System.exit(1);
                                         
                                     break;
                          case "radha":
                                     
                                     query1="select * from buses where bname='"+nbname+"' and boarding='"+boardCity+"' and destination='"+destCity+"';";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     //val=rs.getString("seatCount");
                                     cost=rs.getString("cost");
                                     
                                     time=rs.getString("time");
                                     }
                                    }
                                    catch(Exception e){
                                    }           cc=Integer.parseInt(cost);
                                    
                                    query1="select * from busHistory;";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     val=rs.getString("seatNo");
                                     val1[k]=Integer.parseInt(val);
                                     k++;
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    tot=40;
                     //scount=Integer.parseInt(val);
                                    System.out.println("\n");
                                    for(int i=1;i<=40;i++)
                                    {
                                        for(int j=1;j<=k;j++){
                                            if(i!=val1[j]){
                                            countt++;
                                            }
                                        }
                                        if(countt==k){
                                            if(i<10){
                                            System.out.print(i+"   ");
                                            }
                                            else
                                                System.out.print(i+"  ");
                                        }
                                        else{
                                        System.out.print("x   ");
                                        tot--;
                                        }
                                        countt=0;
                                        if(i%2==0){
                                            System.out.print("\t");
                                        }
                                        if(i%2==0&&i%4==0){
                                            System.out.print("\n");
                                        }
                                    }
                                    System.out.print("\n");
                                    tbid++;
                                    System.out.println("Cost of tickets is "+cost);
                                    System.out.println("Enter no of seats to book");
                                    qua=s.nextInt();
                                    tsum=cc*qua;
                                    int[] scountt2=new int[20];
                                    if(qua<tot){
                                        
                                        for(int i=0;i<qua;i++){
                                    System.out.println("Enter seat no to book");
                                     scountt2[i]=s.nextInt();
                                    //int scount=0;
                                     
                                     //System.out.println( "Seats already booked is"+scount);
                                    // System.out.println("inside kpn");
                                 
                                         
                                         
                                         String qq1="insert into busHistory values('"+tbid+"','"+uname+"','"+nbname+"','"+boardCity+"','"+destCity+"','"+time+"','"+cost+"','"+scountt2[i]+"');";
                                         try{
                                         stmt.executeUpdate(qq1);
                                         //scount+=1;
                                         }catch(Exception e){}
                                         
                                        }
                                    }
                                         System.out.println("Seats available\n Procced to payment");
                                      
                                         payment(type,uname,tbid,scount,tsum);
                                         System.exit(1);
                                         
                                     break;
                          
                             
                     case "orange":
                                     
                                     query1="select * from buses where bname='"+nbname+"' and boarding='"+boardCity+"' and destination='"+destCity+"';";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                   //  val=rs.getString("seatCount");
                                     cost=rs.getString("cost");
                                     
                                     time=rs.getString("time");
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                               cc=Integer.parseInt(cost);
                                    
                                    query1="select * from busHistory;";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     val=rs.getString("seatNo");
                                     val1[k]=Integer.parseInt(val);
                                     k++;
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    tot=40;
                     //scount=Integer.parseInt(val);
                                    System.out.println("\n");
                                    for(int i=1;i<=40;i++)
                                    {
                                        for(int j=1;j<=k;j++){
                                            if(i!=val1[j]){
                                            countt++;
                                            }
                                        }
                                        if(countt==k){
                                            if(i<10){
                                            System.out.print(i+"   ");
                                            }
                                            else
                                                System.out.print(i+"  ");
                                        }
                                        else{
                                        System.out.print("x   ");
                                        tot--;
                                        }
                                        countt=0;
                                        if(i%2==0){
                                            System.out.print("\t");
                                        }
                                        if(i%2==0&&i%4==0){
                                            System.out.print("\n");
                                        }
                                    }
                                    System.out.print("\n");
                                    tbid++;
                                    System.out.println("Cost of tickets is "+cost);
                                    System.out.println("Enter no of seats to book");
                                    qua=s.nextInt();
                                    tsum=cc*qua;
                                    int[] scountt3=new int[20];
                                    if(qua<tot){
                                        
                                        for(int i=0;i<qua;i++){
                                    System.out.println("Enter seat no to book");
                                     scountt3[i]=s.nextInt();
                                    //int scount=0;
                                     
                                     //System.out.println( "Seats already booked is"+scount);
                                    // System.out.println("inside kpn");
                                 
                                         
                                         
                                         String qq1="insert into busHistory values('"+tbid+"','"+uname+"','"+nbname+"','"+boardCity+"','"+destCity+"','"+time+"','"+cost+"','"+scountt3[i]+"');";
                                         try{
                                         stmt.executeUpdate(qq1);
                                         //scount+=1;
                                         }catch(Exception e){}
                                         
                                        }
                                    }
                                         System.out.println("Seats available\n Procced to payment");
                                      
                                         payment(type,uname,tbid,scount,tsum);
                                         System.exit(1);
                                         
                                     break;
                          
                             
                             }
                    }
                    catch(Exception e){
                    }
             }
                   

          
                     
        void movieBooking(String uname){
            type=2;
            int[] val1=new int[50];
            Scanner s=new Scanner(System.in);
            
            System.out.println("/*** MOVIE BOOKING ***/");
            System.out.println("Enter the movie to book");
            System.out.println("Viswasam\t Petta\t\t sarkar\n");
            mov=s.next();
            System.out.println("Enter the date");
            System.out.println("25-MAR-19\t 26-MAR-19\t 27-MAR-19\n");
            dat=s.next();
            String query="select distinct cinema from movies where movie='"+mov+"' and date='"+dat+"';";
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     
                    // System.out.println("inside trys");
                     while(rs.next()){
                     System.out.println(rs.getString("cinema"));
                     }
                     String qqo="select max(bookid) from movieHistory;";
                     rs=stmt.executeQuery(qqo);
                     while(rs.next()){
                     tt=rs.getString(1);
                     }
                     int tmid=Integer.parseInt(tt);
                     //System.out.println("THe value is"+tmid);
                     tmid++;
                     System.out.println("\nEnter the theatre of your choice");
                     cinema=s.next();
                     String query1="select * from movies where movie='"+mov+"' and date='"+dat+"' and cinema='"+cinema+"';";
                     //String query1="select time from view1 where cinema='"+cinema+"';";
                     
                     System.out.println("The available show timings are");
                     rs=stmt.executeQuery(query1);
                     
                     //System.out.println("inside trys");
                     while(rs.next()){
                     System.out.println(rs.getString("time"));
                     cost=rs.getString("cost");
                     }
                     System.out.println("Enter the show timing");
                     time=s.next();
                     int cc=Integer.parseInt(cost);
                     
                     query1="select * from movieHistory;";
                                    try{                 
                                     rs=stmt.executeQuery(query1);
                                     while(rs.next()){
                                     val=rs.getString("seatNo");
                                     val1[k]=Integer.parseInt(val);
                                     k++;
                                     }
                                    }
                                    catch(Exception e){
                                    }
                                    int tot=60;
                     //scount=Integer.parseInt(val);
                                    System.out.println("\n");
                                    for(int i=1;i<=60;i++)
                                    {
                                        for(int j=1;j<=k;j++){
                                            if(i!=val1[j]){
                                            countt++;
                                            }
                                        }
                                        if(countt==k){
                                            if(i<10){
                                            System.out.print(i+"   ");
                                            }
                                            else
                                                System.out.print(i+"  ");
                                        }
                                        else{
                                        System.out.print("x   ");
                                        tot--;
                                        }
                                        countt=0;
                                        if(i%6==0){
                                            System.out.print("\n");
                                        }
                                    }
                                    System.out.print("\n");
                                     //int scount=0;
                                     //System.out.println("Enter the number of seats to book");
                                     //int no=s.nextInt();
                                     //if(no<tot){
                                     int[] scountt=new int[10];
                                     System.out.println("Cost of ticket is: "+cost);
                                     System.out.println("Enter No of seats to book");
                                     int nos=s.nextInt();
                                     if(nos<=tot){
                                         
                                     tsum=cc*6;
                                     for(int i=0;i<nos;i++){
                                        System.out.println( "Enter seats of your choice");
                                     
                                       // for(int i=0;i<no;i++){
                                       // System.out.println("inside kpn");
                                       scountt[i]=s.nextInt();
                                       
                                         try{
                                         
                                         String qq1="insert into movieHistory values('"+tmid+"','"+uname+"','"+cinema+"','"+mov+"','"+dat+"','"+time+"','"+cost+"','"+scountt[i]+"');";
                                         stmt.executeUpdate(qq1);
                                         }
                                         catch(Exception e){}
                                     }    
                                         System.out.println("Seats available\n Procced to payment");
                                         String qq="update movies set seatCount='"+scount+"' where movie='"+mov+"' and date='"+dat+"' and time='"+time+"' and cinema='"+cinema+"';";
                                         try{
                                         stmt.executeUpdate(qq);
                                         }
                                         catch(Exception e){}
                                         payment(type,uname,tmid,scount,tsum);
                                         System.exit(1);
                                     }
                                 tmid++;
                                     
                    
                                     
                    //}
                    }
                    catch(Exception e){
                        
                    }
        }
        void orderFood(String uname){
            int ssum=0;
            type=3;
            Scanner s=new Scanner(System.in);
            System.out.println("/*** ORDER FOOD ***/");
            System.out.println("Enter hotel to order the food");
            System.out.println("SreeSabarees\tMurugan\t\tA2B");
            hotel=s.next();
             String query="select * from food where hotel='"+hotel+"';";
                    try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     
                    // System.out.println("inside trys");
                     while(rs.next()){
                     System.out.println(rs.getString("item"));
                     }
                     String qqo="select max(bookid) from foodHistory;";
                     rs=stmt.executeQuery(qqo);
                     while(rs.next()){
                     tt=rs.getString(1);
                     }
                     tfid=Integer.parseInt(tt);
                     tfid++;
                    String[] item1=new String[20];
                    System.out.println("Enter no of items to order");
                    int qua=s.nextInt();
                    for(int i=0;i<qua;i++){
                    System.out.println("Enter the items");
                    item1[i]=s.next();
                    System.out.println("Enter quantity");
                     int quan=s.nextInt();
                    String query1="select * from food where hotel='"+hotel+"' and item='"+item1[i]+"';";
                    rs=stmt.executeQuery(query1);
                    while(rs.next()){
                        cost=rs.getString("cost");
                        System.out.println("cost of item is"+cost);
                     }
                    //System.out.println("****");
                    ssum=Integer.parseInt(cost);
                    
                    tsum=tsum+ssum*quan;
                    ssum=ssum*quan;
                    //System.out.println(tsum);
                     //System.out.println("THe value is"+tfid);
                    
                     
                     scount=0;
                   // System.out.println("Amount to pay is "+cost+"\n");
                     qq1="insert into foodHistory values('"+tfid+"','"+uname+"','"+hotel+"','"+item1[i]+"','"+ssum+"');";
                     
                     stmt.executeUpdate(qq1);
                     System.out.println("****");
                     }
                    //tfid++;
                    System.out.println("Total Bill is: "+tsum);
                     payment(type,uname,tfid,scount,tsum);
                    }
                    catch(Exception e){
                        
                    }
        }
                    
        void payment(int type,String uname,int tid,int scount,int tsum){
            Scanner s=new Scanner(System.in);
            this.type=type;
            System.out.println("/*** PAYMENT ***/\n");
            System.out.println("Enter card holder Name, Number, cvv\n");
            String cname=s.next();
            String cno=s.next();
            String cvv=s.next();
            
            if(cno.length()==(16)&& cvv.length()==3){
            
            System.out.println("PAYMENT SUCCESSFULL\n");
            System.out.println("Generating ticket\n");
            ticket(type,uname,tid,scount,tsum);
            }
            else{
            System.out.println("Invalid card no");
            payment(type,uname,tid,scount,tsum);
            }
        }
        void ticket(int type,String uname,int tid,int scount,int tsum){
            
            switch(type){
                 
            case 1:
            System.out.println("***********************************************");
            System.out.println("User: "+uname+"\n");
            System.out.println("Booking Id: "+tid+"\n");
            System.out.println("Seat No:"+(scount)+"\n");
            System.out.println("Boarding point: "+boardCity+"\n");
            System.out.println("Destination point: "+destCity+"\n");
            //System.out.println(nbname);
             //String query="select * from buses where boarding='"+boardCity+"' and destination='"+destCity+"' and bname='"+nbname+"' ;";
             String query="select * from busHistory where bookid='"+tid+"';";       
             try{           
                     Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     while (rs.next()) {
                     //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                     //{
                     //System.out.println(rs.getString("time"));
                     time=rs.getString("time");
                     System.out.println("Seat No: "+ rs.getString("seatNo"));
                     //}       
                   }
             
            System.out.println("Time: "+time+"\n");
            System.out.println("***********************************************");
            
            System.exit(0);
            }
        catch(Exception e)
        { 
        }  
            case 2:
            System.out.println("***********************************************");
            System.out.println("Booking Id: "+tid+"\n");
            System.out.println("Cinema: "+cinema+"\n");
            System.out.println("Movie: "+mov+"\n");
            System.out.println("Date: "+dat+"\n");
            System.out.println("Time: "+time+"\n");
            try{
               query="select * from movieHistory where bookid='"+tid+"';";
                Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     while(rs.next()){
                     System.out.println("Seat No: "+ rs.getString("seatNo"));
                     }
                

            }
            catch(Exception e){}
            System.out.println("Total Amount: "+tsum);
            System.out.println("***********************************************");
            System.exit(0);
            
            case 3:
            System.out.println("***********************************************");
            
            System.out.println("Order No:"+tid+"\n");
            System.out.println("Hotel: "+hotel+"\n");
            try{
                query="select * from foodHistory where bookid='"+tid+"';";
                Connection con=DB.getConnection();
                     Statement stmt=con.createStatement();
                     ResultSet rs=stmt.executeQuery(query);
                     while(rs.next()){
                     System.out.println("Item: "+ rs.getString("item"));
                     System.out.println("Cost: "+ rs.getString("amountPaid"));
                     }
                
            }
            catch(Exception e){}
            //System.out.println("Item: "+item+"\n");
            //System.out.println("Cost: "+cost+"\n");
            System.out.println("Total Bill:"+tsum);
            System.out.println("***********************************************");
            System.exit(0);

                
        }
        }
        public int success(int finish){
        return finish;
        }
        
        void update()
        {
            Scanner s=new Scanner(System.in);
            while(true){
            System.out.println("Enter the category to modify");
            System.out.println("Enter 1 for Bus, 2 for Movie, 3 for Food, 4 to exit");
            int ch=s.nextInt();
            switch(ch)
                    {
                        case 1:
                                System.out.println("Enter the bus name");
                                System.out.println("parveen\tkpn\tradha\torange\n");
                                String nbname=s.next();
                                String query="select * from buses where bname='"+nbname+"' ;";
                                try{           
                                Connection con=DB.getConnection();
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(query);

                                System.out.println("*****BUS LIST*****");
                                while (rs.next()) {
                                //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                                //{
                                            System.out.println("Boarding: "+rs.getString("boarding")+"\n"+"Destination: "+rs.getString("destination")+"\n"+"Time: "+rs.getString("time")+"\n"+"Cost: "+rs.getString("cost"));
                                //}       
                                System.out.println("*****");
                               }
                                System.out.println("******************");
                               System.out.println("Enter the bus to modify");
                               System.out.println("Enter the Boarding Point");
                               String board=s.next();
                               System.out.println("Enter the Destination Point");
                               String dest=s.next();
                               System.out.println("Enter the new Cost");
                               String cost=s.next();
                               String query1="update buses set cost='"+cost+"' where boarding='"+board+"' and bname='"+nbname+"' and destination='"+dest+"';";
                               stmt.executeUpdate(query1);
                                 System.out.println("Update Successful!!\n\n");
                               }
                                catch(Exception e){
                                }
                                break;
                        case 2:
                                System.out.println("Enter the theate name");
                                System.out.println("Inox\tGuruCinemas\tMathiCinemas\tShanmugaCinemas\tVetriCinemas\tManiImpala\n");
                                String cinema=s.next();
                                query="select distinct movie from movies where cinema='"+cinema+"' ;";
                                try{           
                                Connection con=DB.getConnection();
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(query);

                                System.out.println("*****MOVIE LIST*****");
                                while (rs.next()) {
                                //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                                //{
                                            System.out.println("Movie: "+rs.getString("movie")+"\n");
                                //}       
                                
                                //System.out.println("*****");
                               }
                                System.out.println("********************");
                                System.out.println("Enter the movie to update");
                                String movie=s.next();
                                query="select * from movies where cinema='"+cinema+"' and movie='"+movie+"';";
                                rs=stmt.executeQuery(query);

                                System.out.println("*****MOVIE LIST*****");
                                while (rs.next()) {
                                
                                System.out.println("Date: "+rs.getString("date")+"\n"+"Time: "+rs.getString("time")+"\n"+"Cost: "+rs.getString("cost"));
                                System.out.println("*****");
                                }
                                System.out.println("********************");
                                System.out.println("Enter the show to update");
                                System.out.println("Enter the show date");
                                String date=s.next();
                                System.out.println("Enter the show timing");
                                String time=s.next();
                                System.out.println("Enter the new ticket price");
                                String cost=s.next();
                                String query1="update movies set cost='"+cost+"' where movie='"+movie+"' and cinema='"+cinema+"' and date='"+date+"' and time='"+time+"';";
                                stmt.executeUpdate(query1);
                                 System.out.println("Update Successful!!\n\n");
                               
                                
                                }
                                catch(Exception e){
                                }
                                break;
                        case 3:
                            System.out.println("Enter the hotel name");

                            System.out.println("SreeSabarees\tMurugan\t\tA2B");
                            hotel=s.next();
                            query="select * from food where hotel='"+hotel+"' ;";
                            try{           
                                Connection con=DB.getConnection();
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(query);

                                System.out.println("*****MENU CARD*****");
                                while (rs.next()) {
                                //if((boardCity.equals(rs.getString("boarding")))&&(destCity.equals(rs.getString("destination"))))
                                //{
                                            System.out.println("Item: "+rs.getString("item")+"\n"+"Price: "+rs.getString("cost"));
                                //}       
                                
                                //System.out.println("*****");
                               }
                                System.out.println("********************");
                                System.out.println("Enter the item to update");
                                String item=s.next();
                                System.out.println("Enter the new price");
                                String cost=s.next();
                                String query1="update food set cost='"+cost+"' where item='"+item+"' and hotel='"+hotel+"';";
                                 stmt.executeUpdate(query1);
                                 System.out.println("Update Successful!!\n\n");
                            }
                                
                            
            
                            catch(Exception e){
                                
                            }
                            break;
                        case 4:
                            System.exit(1);
        }
            }
        }  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String cpass="",addr="",uname="",pass="",name="",mob="",email="";
        try{}
        catch(Exception e)
        { 
            System.out.println(e);
        }   
          ooad obj=new ooad();
          
            Scanner s=new Scanner(System.in);
            int ret;
            int finish=1;
            ret=obj.success(finish);
            
            while(true){
            System.out.println("Enter 1 for admin 2 for user 3 to exit");
            int cho=s.nextInt();
            
            switch(cho){
                case 1:
                    System.out.println("Enter username\n");
                    uname=s.next();
                    System.out.println("Enter Password\n");
                    pass=s.next();
                    if(uname.equals("admin") && pass.equals("admin")){
                    System.out.println("Login Successful");
                    obj.update();
                    }
                    else
                    System.out.println("Check your username or password!!!");
                        
                    break;
                case 2:
                    while(true){
                    System.out.println("Enter 1 to Signup and 2 to Login");
                    int cho1=s.nextInt();
                    switch(cho1){
                        case 1:
                        
                        System.out.println("Enter Name\n");
                        name=s.next();
                        System.out.println("Enter username\n");
                        uname=s.next();
                        
                        System.out.println("Enter Mobile No\n");
                        mob=s.next();
                        if(mob.length()!=10){
                            System.out.println("Invalid mobile number... Please Signup Again");
                            
                            cho1=1;
                            break;
                            
                        }
                        
                        System.out.println("Enter Email Id\n");
                        email=s.next();
                        
                        System.out.println("Enter Address\n");
                        addr=s.next();
                        System.out.println("Enter Password\n");
                        pass=s.next();
                        System.out.println("Confirm Password\n");
                        cpass=s.next();
                        String qur="insert into users values('"+uname+"','"+pass+"','"+name+"','"+mob+"','"+email+"','"+addr+"');";
                        
                        if(pass.equals(cpass)){
                            try{           
                                Connection con=DB.getConnection();
                                Statement stmt=con.createStatement();
                                stmt.executeUpdate(qur);
                                System.out.println("Account created successfully");
                                
                            }
                            catch(Exception e){
                               e.printStackTrace();
                            }
                            
                        }
                        else{
                            System.out.println("Passwords do not match");
                            cho1=1;
                    }
                        break;
                        case 2:
                            
                        System.out.println("Enter username\n");
                        uname=s.next();
                        System.out.println("Enter Password\n");
                        pass=s.next();
                        obj.login(uname,pass);
                        break;
                    }
                    }
                
                    case 3:
                        System.exit(1);
          }
}
}
}

    

