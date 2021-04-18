package mbti_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame implements ActionListener{
	JPanel panel = new JPanel(new GridLayout(2,1));
	
	ArrayList<JRadioButton> mbti_list = new ArrayList<JRadioButton>();
	String mbti = new String();
    
    JRadioButton first[] = new JRadioButton[2];
    JRadioButton second[] = new JRadioButton[2];
    
    String first_type[] = {"E","I"}; 
    String second_type[] = {"S","N"};
    String  third_type[] = {"F","T"};
    String fourth_type[] = {"J","P"};
    
    
    public JRadioButtonTest(){
        ButtonGroup groupyes = new ButtonGroup();
        ButtonGroup groupno = new ButtonGroup();
        
        for(int i=0; i<first.length; i++){
    		first[i] = new JRadioButton(first_type[i]);
    		groupyes.add(first[i]);
    		panel.add(first[i]);
    		mbti_list.add(first[i]);
    		
    		
    		for(int j=0; j<first.length; j++) {
        		second[j] = new JRadioButton(second_type[j]);
        		groupyes.add(second[j]);
        		panel.add(second[j]);
        		mbti_list.add(second[j]);
    		
    		
    		}
        }
        
//    		yes[i].addActionListener(this);
//        }
//        for(int j=0;j<no.length;j++) {
//        	no[j] = new JRadioButton(no_type[j]);
//        	groupno.add(no[j]);
//        	panel.add(no[j]);
//        	no[j].addActionListener(this);
        
//        for(int i=0; i<yes.length; i++) {
//        	for(int j=0;j<no.length;j++) {
//        		if()
        		
        		
//        	}
//        }
        
        
        this.add(panel);
        this.setTitle("RadioButton Example");
        this.setVisible(true);
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        
        if(s.equals(yes[0].getText()) || s.equals(no[0].getText())){
            JOptionPane.showMessageDialog(null,"당신의 MBTI는 "+yes[0].getText()+no[0].getText()+" 입니다.");
        }
        else if(s.equals(yes[1].getText())){
            JOptionPane.showMessageDialog(null,"당신의 MBTI는 : "+yes[1].getText());
        }
        else if(s.equals(yes[2].getText())){
            JOptionPane.showMessageDialog(null,"당신의 MBTI는 : "+yes[2].getText());
        }
        else if(s.equals(yes[3].getText())){
            JOptionPane.showMessageDialog(null,"당신의 MBTI는 : "+yes[3].getText());
        }
        
    }
    
    public static void main(String[] args) {
		new JRadioButtonTest();

	}

}
