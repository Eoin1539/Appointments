/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments;

import static java.nio.file.Files.list;
import static java.util.Collections.list;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eoinkirwan
 */
public final class DoublyLinkedGUI extends javax.swing.JFrame {

    int ID = 0;
    static DNode root;
    static DNode temp;
    static DNode tail;
    static DNode current;
    private JFrame frame;

    public void populateTable() {
        try {
            //Loops through the list and while current is not null, append the variables to the text area
            current = root;
            boolean arrow = true;
            outputTA.setText("");

            do {

                outputTA.append(Integer.toString(current.ID) + "                          ");
                outputTA.append(current.name + "                          ");
                outputTA.append(current.dob + "                          ");
                outputTA.append(current.email + "                          ");
                outputTA.append(current.priority + "                          " + "\n");

                arrow = false;

                current = current.nextNode;

            } while (current != null);

        } catch (NullPointerException np2) {
        }

    }

    //Inserts node at particular index
    public void insertNode(int ID, String name, String email, String priority, String dob, int after) {

        DNode dNode = new DNode(ID, name, email, priority, dob);

        int ithNode = 1;

        current = root;

        while (ithNode != after) {

            current = current.nextNode;

            ithNode++;

        }

        temp = current.nextNode;

        current.nextNode = dNode;
        dNode.nextNode = temp;
        temp.previousNode = dNode;
        dNode.previousNode = current;

    }

    //Method for inserting a high record into the list
    public void insertHigh(int ID, String name, String email, String priority, String dob) {
        DoublyLinkedGUI list = new DoublyLinkedGUI();
        DNode dNode = new DNode(ID, name, email, priority, dob);

        try {

            int i = 1;
            boolean flag = false;
            //Node current will point to head  
            DNode current = root;
            String priority1 = "High";
            //While priority is not equal to high, current goes to the next node, it stops while priortiy is not equal to high, then inserts at that position
            while (current != null) {
                //Compare value to be searched with each node in the list  
                if (!priority1.equals(current.priority)) {
                    System.out.println(current.priority);
                    flag = true;
                    break;
                }
                current = current.nextNode;
                i++;
            }
            if (flag) {
                boolean arrow = true;
                if(i==1){
                    //If there are no other records with the priority of high, then put the node at the top of the list.
                    list.addTop(ID, name, email, priority, dob);
                   
                    System.out.println("No high found, adding to top of list");
                }
                else{
                   i=i-1;
                   //if there is a high in the list, it will place the node below the last high node
                    list.insertNode(ID, name, email, priority, dob, i);
                    System.out.println("High found, adding to "+i+" position");
                }
                

            } 

        } catch (NullPointerException np2) {
        }

    }
//Add node to the end of the list
    public void addNodes(int ID, String name, String email, String priority, String dob) {

        DNode dNode = new DNode(ID, name, email, priority, dob);

        if (root == null) {

            root = dNode;
            root.previousNode = null;
            root.nextNode = null;

        } else {

            current = root;

            while (current.nextNode != null) {

                current = current.nextNode;

            }

            current.nextNode = dNode;
            dNode.previousNode = current;
            dNode.nextNode = null;

        }

    }
//Add node to the top of the list, creating a new head or root node
    public void addTop(int ID, String name, String email, String priority, String dob) {
        DNode dNode = new DNode(ID, name, email, priority, dob);
       if(root==null){
           root=dNode;
           tail=dNode;
           
           dNode.nextNode=null;
           dNode.previousNode=null;
           
       }
       else{
           dNode.nextNode=root;
          root.previousNode=dNode;
          root=dNode;
           
       }
       
    }
   
//Deletes a node based on the node index given
    public void deleteNode(int ID) {

        int ithNode = 1;

        current = root;

        if (ID == 1) {

            root = current.nextNode;
            current.nextNode = null;
            current.previousNode = null;

        } else {

            while (ithNode != ID) {

                current = current.nextNode;

                ithNode++;

            }

            if (current.nextNode == null) {

                current.previousNode.nextNode = null;
                current.previousNode = null;

            } else {

                current.previousNode.nextNode = current.nextNode;
                current.nextNode.previousNode = current.previousNode;

            }

        }

    }
/*
    public void print() {

        current = root;
        boolean arrow = true;

        do {

            System.out.println("Name: " + current.name);
            System.out.println("DOB: " + current.dob);
            System.out.println("Email: " + current.email);
            System.out.println("Priority: " + current.priority);
            arrow = false;

            current = current.nextNode;

        } while (current != null);

    }
*/
    /**
     * Creates new form AppointmentGUI
     */
    public DoublyLinkedGUI() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        dobTF = new javax.swing.JTextField();
        nameLbl = new javax.swing.JLabel();
        dobLbl = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        priorityLbl = new javax.swing.JLabel();
        priorityCB = new javax.swing.JComboBox<>();
        idLbl = new javax.swing.JLabel();
        idTF = new javax.swing.JTextField();
        removeBtn = new javax.swing.JButton();
        searchLbl = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchTA = new javax.swing.JTextArea();
        deleteBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        deleteTF = new javax.swing.JTextField();
        nLbl = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Appointments");

        addBtn.setText("Add Appointment");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        dobTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobTFActionPerformed(evt);
            }
        });

        nameLbl.setText("Name:");

        dobLbl.setText("Date of Birth:");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });

        emailLbl.setText("Email:");

        priorityLbl.setText("Priority:");

        priorityCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));
        priorityCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priorityCBActionPerformed(evt);
            }
        });

        idLbl.setText("ID:");

        idTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTFActionPerformed(evt);
            }
        });

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        searchLbl.setText("Search");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        outputTA.setColumns(20);
        outputTA.setRows(5);
        jScrollPane1.setViewportView(outputTA);

        searchTA.setColumns(20);
        searchTA.setRows(5);
        jScrollPane2.setViewportView(searchTA);

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Delete n people from end of queue");

        nLbl.setText("N number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(nameLbl)
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(priorityLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dobLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addBtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dobTF)
                                            .addComponent(emailTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(priorityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nLbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(deleteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deleteBtn))
                                        .addGap(40, 40, 40))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(searchLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn)
                                .addGap(258, 258, 258)
                                .addComponent(exitBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(idLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeBtn)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLbl)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priorityLbl)
                    .addComponent(priorityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLbl)
                    .addComponent(removeBtn))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLbl)
                    .addComponent(searchBtn)
                    .addComponent(exitBtn)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        //Adds a person to the queue
        try {
            DoublyLinkedGUI list = new DoublyLinkedGUI();
            String name = nameTF.getText();
            String dob = dobTF.getText();
            String email = emailTF.getText();
            String priority = (String) priorityCB.getSelectedItem();
                    //If the priority is high, then insert using the insertHigh method
            if (priority.equals("High")) {
                ID = ID + 1; //Incements ID when a record is placed in the queue
                list.insertHigh(ID, name, email, priority, dob);
              
                populateTable();
            }
            //If the priority is low, then insert using the insertMedium method which places the node just below the high node if one exists
            //If there is another medium in the list it will place the node behind the medium in the queue
            //If there are no High or medium records in the queue, then it will place it at the head of the list
            if (priority.equals("Medium")) {
                ID = ID + 1;
                list.insertMedium(ID, name, email, priority, dob);
              
                populateTable();
            }
//If the priority is low, then insert using the addNodes method which places the node at the end of the list
            if (priority.equals("Low")) {
                ID = ID + 1;
                
                list.addNodes(ID, name, email, priority, dob);
                populateTable();
            }
        } catch (NullPointerException np2) {
        }

        /*try{
       DoublyLinkedGUI list = new DoublyLinkedGUI();
		 String name= nameTF.getText();
                String dob= dobTF.getText();
                String email= emailTF.getText();
                String priority =(String) priorityCB.getSelectedItem();
                
                ID=ID+1;
               
		list.addNodes(ID, name, dob, email, priority);
                populateTable();
        }
        catch(NullPointerException np2){}
         */

    }//GEN-LAST:event_addBtnActionPerformed

    private void dobTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobTFActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void priorityCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priorityCBActionPerformed

    private void idTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTFActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        frame = new JFrame("Exit"); // Creates object
        if (JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Appointments",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_exitBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        try {
            int ID1 = Integer.parseInt(searchTF.getText());
            int i = 1;
            boolean flag = false;
            //Node current will point to head  
            DNode current = root;

            //Checks whether the list is empty  
            if (root == null) {
                searchTA.append("ID is not present in the list");
                return;
            }
            while (current != null) {
                //Compare value to be searched with each node in the list  
                if (current.ID == ID1) {
                    flag = true;
                    break;
                }
                current = current.nextNode;
                i++;
            }
            if (flag) {
                boolean arrow = true;
                searchTA.setText("");

                searchTA.append(Integer.toString(current.ID) + "                          ");
                searchTA.append(current.name + "                          ");
                searchTA.append(current.dob + "                          ");
                searchTA.append(current.priority + "                          ");
                searchTA.append(current.email + "                          " + "\n");
                searchTA.append("That person is at position: "+i+" in the queue");

                arrow = false;
            } else {
                searchTA.append("ID is not present in the list");
            }

        } catch (NullPointerException np2) {
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        //Removes a person with the ID entered
        try {
            //gets the ID from text field
            int ID2 = Integer.parseInt(idTF.getText());

            int i = 1;
            boolean flag = false;
            //Node current will point to head  
            DNode current = root;

            //Checks whether the list is empty  
            if (root == null) {
                System.out.println("List is empty");
                return;
            }
            while (current != null) {
                //Compare value to be searched with each node in the list  
                if (current.ID == ID2) {
                    flag = true;
                    break;
                }
                current = current.nextNode;
                i++;
            }
            if (flag) {
                //deletes the node at the position i
                deleteNode(i);
            } else {
                System.out.println("Node is not present in the list");
            }
            populateTable();
        } catch (NullPointerException np2) {
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int ID12 = Integer.parseInt(deleteTF.getText());
        int i;
        System.out.println(DNode.noOfLinkedList);
        
        for(i=0;i<=ID12;i++){
          
    
            //Updates text area
            populateTable();
            
        }
        
        
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoublyLinkedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoublyLinkedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoublyLinkedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoublyLinkedGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoublyLinkedGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField deleteTF;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JTextField dobTF;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel idLbl;
    private javax.swing.JTextField idTF;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextArea outputTA;
    private javax.swing.JComboBox<String> priorityCB;
    private javax.swing.JLabel priorityLbl;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JTextArea searchTA;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables

}
