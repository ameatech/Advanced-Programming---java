
package section2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Test extends JFrame{
    public Test(){
        setTitle("amare");
        setLayout(null);
        setBounds(100,200,500,200);
        JLabel l1 = new JLabel("name");
        JTextField tf1 = new JTextField();
        JButton b1 =new JButton("submit");
        b1.setBounds(15,45,100,30);
        tf1.setBounds(90,10,70,30);
        //l1.setText("name");
        l1.setBounds(10,10,70,30);
        l1.setFont(new Font("Arial",Font.ITALIC,28));
        l1.setForeground(java.awt.Color.red);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int x=15;
                if(x>10){
                    JOptionPane.showMessageDialog(null, tf1.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "the value is less than 5");
                }
                
            }
        });
        add(l1);
        add(tf1);
        add(b1);
        //setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
}
public class Section2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t = new Test();
        t.setVisible(true);
    }
    
}
