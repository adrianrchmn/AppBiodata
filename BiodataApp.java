import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BiodataApp extends JFrame{

    public BiodataApp(){

        // Exit
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah ingin keluar?", "EXIT",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
        JLabel labelInput = new JLabel("Nama :");
        labelInput.setBounds(15,20,350,30);

        JTextField textField = new JTextField();
        textField.setBounds(15,50,350,30);

        JLabel labelInput2 = new JLabel("Nomor HP :");
        labelInput2.setBounds(15,80,350,30);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15,110,350,30);

        JLabel labelInput3 = new JLabel("Alamat :");
        labelInput3.setBounds(15,140,350,30);

        JTextField textField3 = new JTextField();
        textField3.setBounds(15,170,350,30);

        // Radio button
        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15,200,350,30);
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki");
        radioButton1.setBounds(15,225,350,30);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,250,350,30);

        ButtonGroup bg  = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        
        // Membuat JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // Membuat table model dan set Column 
        Object[] columns = {"Nama","Nomor HP","Alamat","Jenis kelamin"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        table.setModel(model);
            
        // tombol button
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        btnAdd.setBounds(15, 310, 100, 25);
        btnUpdate.setBounds(140, 310, 100, 25);
        btnDelete.setBounds(260, 310, 100, 25);
        
        // Untuk membuat JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(15, 350, 500, 200);
        frame.setLayout(null);
        frame.add(pane);
        
        // memasukan JTextFields ke jframe
        frame.add(textField);
        frame.add(textField2);
        frame.add(textField3);
    
        // memasukan Jbutton ke jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        
        // membuat array dengan 4 row
        Object[] row = new Object[4];

        // button add
        btnAdd.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = " ";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                String nama = textField.getText();
                String nomortlp = textField2.getText();
                String alamat = textField3.getText();
                if (nama.trim().isEmpty() || nomortlp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(BiodataApp.this, "Form tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else{
                    int confirmation = JOptionPane.showConfirmDialog(BiodataApp.this,
                            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        row[0] = textField.getText();
                        row[1] = textField2.getText();
                        row[2] = textField3.getText();
                        row[3] = jenisKelamin; 
                        model.addRow(row);
                        textField.setText(null);
                        textField2.setText(null);
                        textField3.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(BiodataApp.this, "Anda tidak memasukan data");
                    }
                }                    
            }  
        });
        
        // button delete
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            textField.setText(null);
            textField2.setText(null);
            textField3.setText(null);
            }
        });
        
        // Fungsi selected row data 
        table.addMouseListener(new MouseAdapter(){
        
            @Override
            public void mouseClicked(MouseEvent e){
                
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                textField.setText(model.getValueAt(i, 0).toString());
                textField2.setText(model.getValueAt(i, 1).toString());
                textField3.setText(model.getValueAt(i, 2).toString());
            }
        });
        
        // button Update
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textField.getText(), i, 0);
                   model.setValueAt(textField2.getText(), i, 1);
                   model.setValueAt(textField3.getText(), i, 2);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        
    
        this.add(textField);
        this.add(textField2);
        this.add(textField3);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(labelInput3);
        this.add(btnAdd);
        this.add(btnDelete);
        this.add(btnUpdate);
        this.add(pane);

        this.setSize(600,700);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                BiodataApp b = new BiodataApp();
                b.setVisible(true);
            }
        });
    }
}
