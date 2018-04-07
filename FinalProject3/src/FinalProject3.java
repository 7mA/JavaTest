/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 11375
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class FinalProject3 extends Application{
    private TextField tfStudentId = new TextField();
    private TextField tfStudentName = new TextField();
    private TextField tfStudentDep = new TextField();
    private Button btRegister = new Button("学生登录");
    private Label lbLogo = new Label("欢迎来到选课系统！");
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane borderPane = new BorderPane();
        
        GridPane gridPane = new GridPane();
        
        gridPane.setStyle("-fx-border-color: lightgrey;-fx-background-color:lightgrey");
        btRegister.setStyle("-fx-border-color:black; -fx-background-color:lightblue");
        lbLogo.setFont(Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,35));
        lbLogo.setStyle("-fx-border-color:black; -fx-background-color:lightblue");
        borderPane.setStyle("-fx-background-color:lightgrey");
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("学号："),0,0);
        gridPane.add(tfStudentId,1,0);
        gridPane.add(new Label("姓名："),0,1);
        gridPane.add(tfStudentName,1,1);
        gridPane.add(new Label("院系："),0,2);
        gridPane.add(tfStudentDep,1,2);
        gridPane.add(btRegister, 1, 5);
        
        gridPane.setAlignment(Pos.CENTER);
        tfStudentId.setAlignment(Pos.BOTTOM_LEFT);
        tfStudentName.setAlignment(Pos.BOTTOM_LEFT);
        tfStudentDep.setAlignment(Pos.BOTTOM_LEFT);  
        GridPane.setHalignment(btRegister, HPos.RIGHT);
        
        borderPane.setTop(lbLogo);
        borderPane.setCenter(gridPane);
        borderPane.setAlignment(lbLogo,Pos.CENTER);
        borderPane.setAlignment(gridPane,Pos.CENTER);//登录页面的设定
        
        btRegister.setOnAction(e -> { //点击登录按钮进入选课界面
            try {
                getStudent(primaryStage,borderPane);
            } catch (Exception ex) {
                Logger.getLogger(FinalProject3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } ) ;
        
        Scene scene = new Scene(borderPane,400,250);
        primaryStage.setTitle("学生选课系统");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
       private void getStudent(Stage primaryStage,BorderPane borderPane) throws Exception{
           String studentId = tfStudentId.getText();
           String studentName = tfStudentName.getText();
           String studentDep = tfStudentDep.getText();
           
           if(studentId == null || studentName == null || studentDep == null){
               borderPane.setBottom(new Label("请先完善个人信息!"));
               System.exit(1);
           }
           
           
           else{
               
           Student student = new Student(studentId,studentName,studentDep);
           BorderPane borderPane1 = new BorderPane();
           Scene scene1 = new Scene(borderPane1,400,250);
           primaryStage.setTitle("学生选课系统");
           primaryStage.setScene(scene1);
           primaryStage.show();
           
           
           
           GridPane gridPane1 = printInformation(student);//打印学生个人信息
           GridPane gridPane4 = CreateChosenCourses(student);//在右侧显示已选列表
           GridPane gridPane2 = PrintCourses(student,gridPane4) ;//从文件中导入可供选择的课程列表
           GridPane gridPane5 = PrintTitle();//打印查找栏
           
           
           borderPane1.setLeft(gridPane1);
           borderPane1.setCenter(gridPane2);
           borderPane1.setRight(gridPane4);
           borderPane1.setTop(gridPane5);
           borderPane1.setAlignment(gridPane1,Pos.CENTER);
           borderPane1.setAlignment(gridPane2,Pos.CENTER);
           borderPane1.setAlignment(gridPane5,Pos.CENTER);
           scene1 = new Scene(borderPane1,400,250);
           primaryStage.setTitle("学生选课系统");
           primaryStage.setScene(scene1);
           primaryStage.show();
           }
}
       
       
       public static GridPane printInformation(Student student){ //在左侧打印已知的学生信息
           GridPane gridPane = new GridPane();
           gridPane.setStyle("-fx-border-color: lightgrey;-fx-background-color:lightgrey");
           gridPane.setHgap(5);
           gridPane.setVgap(5);
           gridPane.setAlignment(Pos.CENTER);
           
           Button btCorrect = new Button("修改(剩余1次)");
           Label label1 = new Label(student.getStudentId());
           Label label2 = new Label(student.getStudentName());
           Label label3 = new Label(student.getStudentDep());
           gridPane.add(new Label("学号："),0,0);
           gridPane.add(label1,1,0);
           gridPane.add(new Label("姓名："),0,1);
           gridPane.add(label2,1,1);
           gridPane.add(new Label("院系："),0,2);
           gridPane.add(label3,1,2);
           gridPane.add(btCorrect,1,5);
           Button btSave = new Button("保存");
           btSave.setStyle("-fx-border-color:black; -fx-background-color:lightblue");
           GridPane.setHalignment(btCorrect, HPos.RIGHT);
           btCorrect.setStyle("-fx-border-color:black; -fx-background-color:lightblue");
           
           btCorrect.setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent e){
                   
                   gridPane.getChildren().removeAll(label1,label2,label3,btCorrect);
                  
                   TextField tfStudentId = new TextField();
                   TextField tfStudentName = new TextField();    
                   TextField tfStudentDep = new TextField();    
                   Button btSave = new Button("保存");
                   btSave.setStyle("-fx-border-color:black; -fx-background-color:lightblue");
                   
                   gridPane.add(tfStudentId,1,0);
                   gridPane.add(tfStudentName,1,1);
                   gridPane.add(tfStudentDep,1,2);
                   gridPane.add(btSave,1,5);
                   GridPane.setHalignment(btSave, HPos.RIGHT);
                   
                   
                   btSave.setOnAction(new EventHandler<ActionEvent>(){
                       @Override
                       public void handle(ActionEvent e){
                           gridPane.getChildren().removeAll(tfStudentId,tfStudentName,tfStudentDep,btCorrect);
                           gridPane.getChildren().removeAll(label1,label2,label3,btSave);
                           String studentId = tfStudentId.getText();
                           String studentName = tfStudentName.getText();
                           String studentDep = tfStudentDep.getText();
                           student.SetStudentId(studentId);
                           student.SetStudentName(studentName);
                           student.SetStudentDep(studentDep);
                           
                           Label label4 = new Label(student.getStudentId());
                           Label label5 = new Label(student.getStudentName());
                           Label label6 = new Label(student.getStudentDep());
                           Button btCorrect1 = new Button("修改(剩余0次)");
                           
                           gridPane.add(label4,1,0);
                           gridPane.add(label5,1,1);
                           gridPane.add(label6,1,2);
                           gridPane.add(btCorrect1,1,5);
                           GridPane.setHalignment(btCorrect1, HPos.RIGHT);
                           
                       }
                       
                   });
               }
           });
           
           return gridPane;
           
       }
       
    
    
    public static GridPane PrintCourses(Student student,GridPane gridPane) throws Exception{ //在中间打印可选课程列表
        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = CreateChosenCourses(student);
        gridPane2.setAlignment(Pos.CENTER);
        Course[] courses2 = GetCourses();
        int count = courses2.length;
        Button[] buttons = new Button[count];
        Button[] buttons1 = new Button[count];
        Button[] btClick = new Button[count];
        Button[] btClick1 = new Button[count];
        
        Button btDelete = new Button("删除");
        btDelete.setStyle("-fx-border-color:black; -fx-background-color:lightgrey");
        
        int index2 = 1;
        
        gridPane2.setStyle("-fx-border-color: black;-fx-background-color:white");
        gridPane2.setHgap(5);
        gridPane2.setVgap(5);
            
        Label lbCourseId = new Label("课头号：");
        TextField tfCourseId = new TextField();
        Label lbCourseName = new Label("课程名称：");
        TextField tfCourseName = new TextField();
        Label lbCourseDep = new Label("所属院系：");
        TextField tfCourseDep = new TextField();
        Label lbCourseCredit = new Label("学分：");
        TextField tfCourseCredit = new TextField();
        Button[] btSearch = new Button[4];
        
        for(int i = 0; i < 4; i ++){
        btSearch[i] = new Button("查找");
        btSearch[i].setStyle("-fx-border-color:black; -fx-background-color:lightblue");
        gridPane2.add(btSearch[i], 20, i);
        GridPane.setHalignment(btSearch[i], HPos.LEFT);
        }
        
        for(int i = 0; i < count; i++,index2 ++){
            int index1 = i;
    
            buttons[i] = new Button("选课");
            buttons1[i] = new Button("选课");
            buttons[i].setStyle("-fx-border-color:black; -fx-background-color:lightblue");
            buttons1[i].setStyle("-fx-border-color:black; -fx-background-color:lightgrey");
         
            int j = i;
            Button button1 = buttons[i];
            Button button2 = buttons1[i];
            
            btClick[i] = new Button("提交");
            btClick1[i] = new Button("提交"); 
            btClick[i].setStyle("-fx-border-color:black; -fx-background-color:lightblue");
            btClick1[i].setStyle("-fx-border-color:black; -fx-background-color:lightgrey");
            
            Button button3 = btClick[j];
            Button button4 = btClick1[j];
            
            buttons[i].setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent e){
                    
                    ArrayList<Course> courses1 = new ArrayList<>(Arrays.asList(courses2));
                    Button[] buttons = new Button[courses1.size()];
                    Label[] labels = new Label[courses1.size()];
                    
                    labels[j] = new Label(courses1.get(j).GetCourseName());
                    gridPane2.getChildren().remove(button1);
                    gridPane2.add(button2,80,j + 9);
                     
                    buttons[j] = new Button("删除");
                    buttons[j].setStyle("-fx-border-color:black; -fx-background-color:lightblue");
                    gridPane.add(labels[j],0,count - j + 1);
                    gridPane.add(buttons[j],1,count - j + 1);
                    gridPane.add(button3, 1, 10);
                    buttons[j].setOnAction(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e){
                            gridPane.getChildren().removeAll(labels[j],buttons[j]);
                            gridPane2.getChildren().remove(button2);
                            gridPane2.add(button1,80,j + 9);
                            
                    button3.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e){
                            java.io.PrintWriter output = null;
                            try {
                                gridPane.getChildren().removeAll(buttons[j]/*,btClick*/);
                                gridPane.add(btDelete,1,count - j + 1);
                                gridPane.add(button4,1,10);
                                java.io.File file = new java.io.File("C:\\Users\\11375\\Desktop\\finalProject2.txt");
                                if(file.exists()){
                                    System.out.println("File already exists");
                                    System.exit(1);
                                }
                                
                                output = new java.io.PrintWriter(file);
                                output.println("学号：" + student.getStudentId());
                                output.println("姓名：" + student.getStudentName());
                                output.println("院系：" + student.getStudentDep());
                                output.print("\n选课情况：" + courses1.get(j).GetCourseId() + " ");
                                output.print(courses1.get(j).GetCourseName() + " ");
                                output.print(courses1.get(j).GetCourseDep() + " ");
                                output.print(courses1.get(j).GetCourseCredit() + " ");
                                
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(FinalProject3.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                output.close();
                            }
                            
                        }
                        
                        
                        
                    });
            
                    
                        }
                    });
                    
                }
            });
            
        }
         
           gridPane2.add(lbCourseId,0,0);
           gridPane2.add(tfCourseId,1,0);
           gridPane2.add(lbCourseName,0,1);
           gridPane2.add(tfCourseName,1,1);
           gridPane2.add(lbCourseDep,0,2);
           gridPane2.add(tfCourseDep, 1, 2);
           gridPane2.add(lbCourseCredit,0,3);
           gridPane2.add(tfCourseCredit, 1, 3);
           
           gridPane2.add(new Label("课头号"),0,8);
           gridPane2.add(new Label("课程名称"),20,8);
           gridPane2.add(new Label("所属院系"),40,8);
           gridPane2.add(new Label("学分"),60,8);
           gridPane2.add(new Label("操作"),80,8);
           Label[] labels1 = new Label[count];
           Label[] labels2 = new Label[count];
           Label[] labels3 = new Label[count];
           Label[] labels4 = new Label[count];
           for(int i = 0; i < count; i++){
               labels1[i] = new Label(courses2[i].GetCourseId() + "");
               labels2[i] = new Label(courses2[i].GetCourseName());
               labels3[i] = new Label(courses2[i].GetCourseDep() + "");
               labels4[i] = new Label(courses2[i].GetCourseCredit() + "");
               gridPane2.add(labels1[i],0,i + 9);
               gridPane2.add(labels2[i],20,i + 9);
               gridPane2.add(labels3[i],40,i + 9);
               gridPane2.add(labels4[i],60,i + 9);
               gridPane2.add(buttons[i],80,i + 9);
         }
           
           tfCourseId.setAlignment(Pos.BOTTOM_LEFT);
           tfCourseName.setAlignment(Pos.BOTTOM_LEFT);
           tfCourseDep.setAlignment(Pos.BOTTOM_LEFT); 
           tfCourseCredit.setAlignment(Pos.BOTTOM_LEFT); 
           
           
           btSearch[0].setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent e){
                   String stCourseId = tfCourseId.getText();
                   ArrayList<Course> courses3 = new ArrayList<>();
                   ArrayList<Integer> CourseIdIndex = new ArrayList<>();
                   GridPane gridPane3 = new GridPane();
                   
                   gridPane2.getChildren().remove(tfCourseId);
                   gridPane2.add(tfCourseId,1,0);
                   
                   for(int i = 0; i < count; i ++){
                       gridPane2.getChildren().removeAll(labels1[i],labels2[i],labels3[i],labels4[i],buttons[i]);
                       
                       if((courses2[i].GetCourseId() + "").contains(stCourseId)){
                           Integer integer = new Integer(i);
                           CourseIdIndex.add(integer);
                           courses3.add(courses2[i]);
                       }  
                   }
                   
                   for(int i = 0; i < courses3.size(); i ++){
                       gridPane2.add(new Label(courses3.get(i).GetCourseId() + ""), 0, i + 9);
                       gridPane2.add(new Label(courses3.get(i).GetCourseName()), 20, i + 9);
                       gridPane2.add(new Label(courses3.get(i).GetCourseDep()), 40, i + 9);
                       gridPane2.add(new Label(courses3.get(i).GetCourseCredit() + ""), 60, i + 9);
                       gridPane2.add(buttons[CourseIdIndex.get(i)],80,i + 9);
                   }
                        
               }
           });
           
           
           btSearch[1].setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent e){
                   String stCourseName = tfCourseName.getText();
                   ArrayList<Course> courses4 = new ArrayList<>();
                   ArrayList<Integer> CourseIdIndex1 = new ArrayList<>();
                   gridPane2.getChildren().remove(tfCourseName);
                   gridPane2.add(tfCourseName,1,1);
                   
                   for(int i = 0; i < count; i ++){
                       gridPane2.getChildren().removeAll(labels1[i],labels2[i],labels3[i],labels4[i],buttons[i]);
                       
                       if((courses2[i].GetCourseName() + "").contains(stCourseName)){
                           Integer integer = new Integer(i);
                           CourseIdIndex1.add(integer);
                           courses4.add(courses2[i]);
                       }  
                   }
                   
                   for(int i = 0; i < courses4.size(); i ++){
                       gridPane2.add(new Label(courses4.get(i).GetCourseId() + ""), 0, i + 9);
                       gridPane2.add(new Label(courses4.get(i).GetCourseName()), 20, i + 9);
                       gridPane2.add(new Label(courses4.get(i).GetCourseDep()), 40, i + 9);
                       gridPane2.add(new Label(courses4.get(i).GetCourseCredit() + ""), 60, i + 9);
                       gridPane2.add(buttons[CourseIdIndex1.get(i)],80,i + 9);
                   }
                        
               }
           });
           
           btSearch[2].setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent e){
                   String stCourseDep = tfCourseDep.getText();
                   ArrayList<Course> courses5 = new ArrayList<>();
                   ArrayList<Integer> CourseIdIndex2 = new ArrayList<>();
                   gridPane2.getChildren().remove(tfCourseDep);
                   gridPane2.add(tfCourseDep,1,2);
                   
                   for(int i = 0; i < count; i ++){
                       gridPane2.getChildren().removeAll(labels1[i],labels2[i],labels3[i],labels4[i],buttons[i]);
                       
                       if((courses2[i].GetCourseDep() + "").contains(stCourseDep)){
                           Integer integer = new Integer(i);
                           CourseIdIndex2.add(integer);
                           courses5.add(courses2[i]);
                       }  
                   }
                   
                   for(int i = 0; i < courses5.size(); i ++){
                       gridPane2.add(new Label(courses5.get(i).GetCourseId() + ""), 0, i + 9);
                       gridPane2.add(new Label(courses5.get(i).GetCourseName()), 20, i + 9);
                       gridPane2.add(new Label(courses5.get(i).GetCourseDep()), 40, i + 9);
                       gridPane2.add(new Label(courses5.get(i).GetCourseCredit() + ""), 60, i + 9);
                       gridPane2.add(buttons[CourseIdIndex2.get(i)],80,i + 9);
                   }
                        
               }
           });
           
           btSearch[3].setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent e){
                   String stCourseCredit = tfCourseCredit.getText();
                   ArrayList<Course> courses6 = new ArrayList<>();
                   ArrayList<Integer> CourseIdIndex3 = new ArrayList<>();
                   gridPane2.getChildren().remove(tfCourseCredit);
                   gridPane2.add(tfCourseCredit,1,3);
                   
                   for(int i = 0; i < count; i ++){
                       gridPane2.getChildren().removeAll(labels1[i],labels2[i],labels3[i],labels4[i],buttons[i]);
                       
                       if(((courses2[i].GetCourseCredit() + "")).contains(stCourseCredit)){
                           Integer integer = new Integer(i);
                           CourseIdIndex3.add(integer);
                           courses6.add(courses2[i]);
                       }  
                   }
                   
                   for(int i = 0; i < courses6.size(); i ++){
                       gridPane2.add(new Label(courses6.get(i).GetCourseId() + ""), 0, i + 9);
                       gridPane2.add(new Label(courses6.get(i).GetCourseName()), 20, i + 9);
                       gridPane2.add(new Label(courses6.get(i).GetCourseDep()), 40, i + 9);
                       gridPane2.add(new Label(courses6.get(i).GetCourseCredit() + ""), 60, i + 9);
                       gridPane2.add(buttons[CourseIdIndex3.get(i)],80,i + 9);
                   }
                        
               }
           });
           
          
           return gridPane2;
           
    }
       
    
    
       public static Course[] GetCourses() throws Exception  {
        Course[] courses1 = new Course[200];
       
        int count = 0;
        
        java.io.File file = new java.io.File("C:\\Users\\11375\\Desktop\\finalProject.txt");
        Scanner input = new Scanner(file);
        
        while(input.hasNext()){
            long courseId = input.nextLong();
            String courseName = input.next();
            String courseDep = input.next();
            double courseCredit = input.nextDouble();
            courses1[count] = new Course(courseId,courseName,courseDep,courseCredit);
            ++ count;
        }
        
        Course[] courses2 = new Course[count];
        
        for(int i = 0; i < count; i++){
            courses2[i] = courses1[i];
        }
        
        return courses2;
    }
       
       
       
       public static GridPane CreateChosenCourses(Student student){
            GridPane gridPane3 = new GridPane();
            gridPane3.setStyle("-fx-border-color: lightgrey;-fx-background-color:lightgrey");
            gridPane3.setHgap(5);
            gridPane3.setVgap(5);
            gridPane3.add(new Label("选课列表"),0,0);
            
            
            gridPane3.setAlignment(Pos.CENTER);
                
            
           
            return gridPane3;
       }
       
       
        public static GridPane PrintTitle(){
            
            
            GridPane gridPane4 = new GridPane();
            gridPane4.setStyle("-fx-border-color:lightgrey;-fx-background-color:lightgrey");
            gridPane4.setHgap(5);
            gridPane4.setVgap(5);
            gridPane4.setAlignment(Pos.CENTER);
            
            Label lbTitle = new Label("选课系统");
            lbTitle.setFont(Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.REGULAR,35));
            lbTitle.setStyle("-fx-border-color:white; -fx-background-color:white");
            Label lbTitle1 = new Label("注意：1. 只有一次修改个人信息机会.");
            Label lbTitle2 = new Label("         2. 只能最终选定一门课.");
            lbTitle1.setStyle("-fx-border-color:black; -fx-background-color:white");
            lbTitle2.setStyle("-fx-border-color:black; -fx-background-color:white");
            
            gridPane4.add(lbTitle,0,0);
            gridPane4.add(lbTitle1,0,1);
            gridPane4.add(lbTitle2,0,2);
            
            
            return gridPane4;
        }
       
       
     
       public static void main(String[] args){
           Application.launch(args);
       }

}

      
    
class Course{
    private long courseId;
    private String courseName;
    private String courseDep;
    private double courseCredit;
    
    public Course(){
        
    }
    
    public Course(long courseId,String courseName,String courseDep,double courseCredit){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDep = courseDep;
        this.courseCredit = courseCredit;
    }
    
    
    public void SetCourseId(long courseId){
        this.courseId = courseId;
    }
    
    public long GetCourseId(){
        return courseId;
    }
    
    public void SetCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public String GetCourseName(){
        return courseName;
    }
    
    public void SetCourseDep(String courseDep){
        this.courseDep = courseDep;
    }
    
    public String GetCourseDep(){
        return courseDep;
    }
    
    public void SetCourseCredit(double courseCredit){
        this.courseCredit = courseCredit;
    }
    
    public double GetCourseCredit(){
        return courseCredit;
    }

}


class Student{
    private String studentId;
    private String studentName;
    private String studentDep;
    private ArrayList <Course> courses = new ArrayList<>();
    
    public Student(){
    
    }
    
    public Student(String studentId,String studentName,String studentDep){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDep = studentDep;
    }
    
   public void SetStudentId(String studentId){
       this.studentId = studentId;
   }
   
   public void SetStudentName(String studentName){
       this.studentName = studentName;
   }
   
   public void SetStudentDep(String studentDep){
       this.studentDep = studentDep;
   }
    
    public void addCourse(Course course){
        this.courses.add(course);
        
    }
    
    public ArrayList <Course> getCourses(){
        return courses;
    }
    
    
    public int getNumberOfCourses(){
        return courses.size();
    }
    
    
    public String getStudentName(){
        return studentName;
    }
    
    
    public String getStudentId(){
        return studentId;
    }
    
    public String getStudentDep(){
        return studentDep;
    }
    
    
    
    public void dropCourse(Course course){
        int index = courses.indexOf(course);
        courses.remove(index);   
        }
    
    public void clear(ArrayList <Course> courses){
        courses.clear();    
    }
    
}