/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagementapplication;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 *
 * @author hloni
 */
public class MyFrame extends JFrame implements ActionListener{

    final int WIDTH = 500;
    final int HEIGHT = 500;
    
    Font headlineFont = new Font ("Monospaced",Font.BOLD,12);
    Font headlineFont2 = new Font("Monospaced",Font.ITALIC,12);
        
        //creating an object(e.g label,edit,button)
        JLabel lblTMA = new JLabel("Task Management Application");
        JLabel lblTasks = new JLabel("Tasks");
        JLabel lblTaskIndex = new JLabel("Task Index");
        JButton btnAdd = new JButton("Add");
        JButton btnReset = new JButton("Reset");
        JButton btnDelete = new JButton("Delete");
        JButton btnExit = new JButton("Exit");
        JTextField txtTask = new JTextField();
        JTextField txtIndex = new JTextField();
        JTextArea txtArea = new JTextArea();
        
        
        
        ArrayList <String> TaskList = new ArrayList<>();
        
    public MyFrame() {
      
     super("TaskManagementApplication");
     setSize(WIDTH,HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        //Postion of objects
        lblTMA.setBounds(150,0,200,20);
        lblTasks.setBounds(0,50,40,20);
        lblTaskIndex.setBounds(0,100,100,20);
        btnAdd.setBounds(280,50,60,20);
        btnReset.setBounds(390,50,70,20);
        btnDelete.setBounds(150,100,80,20);
        btnExit.setBounds(300,100,70,20);
        txtTask.setBounds(50,50,200,20);
        txtIndex.setBounds(75,100,50,20);
        txtArea.setBounds(90,150,300,300);
        
        // setting button border (styling)
        btnAdd.setBorder(BorderFactory.createCompoundBorder());
        btnDelete.setBorder(BorderFactory.createCompoundBorder());
        btnExit.setBorder(BorderFactory.createCompoundBorder());
        btnReset.setBorder(BorderFactory.createCompoundBorder());
        
        
        //setting label and button font (styling)
        lblTMA.setFont(headlineFont);
        lblTasks.setFont(headlineFont);
        lblTaskIndex.setFont(headlineFont);
         btnAdd.setFont(headlineFont2);
         btnReset.setFont(headlineFont2);
         btnDelete.setFont(headlineFont2);
         btnExit.setFont(headlineFont2);
         
         //wrap long lines
         txtArea.setLineWrap(true);
         txtArea.setWrapStyleWord(true);
         
                
        //adding object to JFrame
        add(lblTMA);
        add(lblTasks);
        add(lblTaskIndex);
        add(btnAdd);
        add(btnReset);
        add(btnDelete);
        add(btnExit);
        add(txtTask);
        add(txtIndex);
        add(txtArea);
        
        
        //Listen for button clicks
        btnAdd.addActionListener(this);
        btnReset.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String task;
        String taskIndex;
        
       // Initialising inputs from the textfield 
        task = txtTask.getText();
        taskIndex = txtIndex.getText();
        
        //When button Add is clicked
        // Task inserion
        if(e.getSource()==btnAdd) {
        if(!task.isEmpty()){ //Ensuring the input is not empty
            TaskList.add(task);
            txtTask.setText("");
            
            txtArea.setText("");
                    for (int i = 0; i < TaskList.size(); i++) {
                    // Display the tasks with 1 2 3 numbering
                    txtArea.append((i + 1) + ". " + TaskList.get(i) + "\n");
                    }
           
            
        }else{
            JOptionPane.showMessageDialog(null,"Please enter a Task before pressing Add");
        }
        }
        
        //When button View is clicked
        // Task viewing
        if (e.getSource() == btnReset) {
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all tasks?", "Confirm Reset", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        TaskList.clear();  // Clears all tasks
        txtArea.setText("");  // Clears the text area
        JOptionPane.showMessageDialog(null, "All tasks have been deleted.");
    }
}
        
        //When button Delete is clicked
        //Task removal
        if (e.getSource()==btnDelete){
          
            try {
                int index = Integer.parseInt(taskIndex);
                if (index > 0 && index <= TaskList.size()) { //Ensuring the input is correct
                    String removedTask = TaskList.remove(index-1);
                    JOptionPane.showMessageDialog(null,"Task \"" + removedTask + "\" removed successfully!");
                    txtArea.setText("");
                    
                    for (int i = 0; i < TaskList.size(); i++) {
                    // Display the tasks with 1 2 3 numbering
                    txtArea.append((i + 1) + ". " + TaskList.get(i) + "\n");
                    }
                    
                    txtIndex.setText("");  // Clear the index field after deleting
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid index. Please try again");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Please enter a valid numeric index");
        }
        
        }
        
        //When button Exit is clicked
        if (e.getSource()==btnExit){
            System.exit(0);
        }
        
    }
    
    
    
}
