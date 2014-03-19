/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ian.tool.formatter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ian
 */
public class Formatter {
    
    static final JTextArea t1 = new JTextArea(25,30);
    static final JTextArea t2 = new JTextArea(25,30);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        JFrame f = new JFrame();
        f.setSize(800, 500);
        JPanel jp = new JPanel(new BorderLayout());
        f.setContentPane(jp);
        
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.add(new JLabel("格式化工具"));
        jp.add(top,BorderLayout.NORTH);
        
        JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
        main.add(new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        main.add(new JScrollPane(t2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        t1.setLineWrap(true);
        t2.setLineWrap(true);
        jp.add(main,BorderLayout.CENTER);
        
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btn1 = new JButton("格式化");
        JButton btn2 = new JButton("清除");
        JButton btn3 = new JButton("复制");
        bottom.add(btn1);
        bottom.add(btn2);
        bottom.add(btn3);
        jp.add(bottom,BorderLayout.SOUTH);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String[] s1 = t1.getText().split("[^0-9]+");
                String end = "";
                for(String code:s1){
                    end = end.concat(code + " ");
                }
                t2.setText(end);
            }
        });
        
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t1.setText("");
                t2.setText("");
            }
        });
        
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                StringSelection stsel = new StringSelection(t2.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
