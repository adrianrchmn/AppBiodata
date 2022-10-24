import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class BiodataApp extends JFrame {

    public BiodataApp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15,40,350,10);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JLabel labelInput2 = new JLabel("Nomor HP");
        labelInput2.setBounds(15,80,350,10);
      
        JTextField textField2 = new JTextField();
        textField2.setBounds(15,100,350,30);

        JLabel labelInput3 = new JLabel("Alamat");
        labelInput3.setBounds(15,120,350,10);

        JTextField textField3 = new JTextField();
        textField3.setBounds(15,140,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15,200,350,10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15,215,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15,245,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JButton button = new JButton("Simpan");
        button.setBounds(15,305,100,40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrolllableTable = new JScrollPane(table);
        scrolllableTable.setBounds(15,350,350,200);

        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jenisKelamin = "";
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

                String nama = textField.getText();
                tableModel.add(new ArrayList<>(Arrays.asList(nama, jenisKelamin)));
            }
        });

        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(textField3);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput);
        this.add(labelInput2);
        this.add(labelInput3);
        this.add(scrolllableTable);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataApp b = new BiodataApp();
                b.setVisible(true);
            }
        });
    }
}