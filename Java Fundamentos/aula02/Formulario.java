import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Formulario {
    
    public static void main(String[] args) {
        
        JFrame obj = new JFrame();
        obj.setSize(600, 300);
        obj.setTitle("Meu formulário");
        obj.setLayout(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton botao = new JButton("Clique aqui");
        botao.setBounds(400, 10, 200, 70);

        JTextField campo = new JTextField();
        campo.setBounds(10, 10, 350, 70);

        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "aa");
            }
         });
        
        obj.add(botao);
        obj.add(campo);
        
        obj.setVisible(true);

    }

}
