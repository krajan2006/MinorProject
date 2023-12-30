package ClickCount;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends Frame implements ActionListener
{
    int count = 0;
    Label l;
    Button b;

    public MyFrame()
    {
        super("Button Demo");

        setLayout(new FlowLayout());

        l= new Label("   "+count);
        b=new Button("Click");

        add(l);
        add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        count++;
        l.setText("   "+count);
    }

}

public class ClickCount 
{
    public static void main(String[] args) 
    {
        MyFrame f = new MyFrame();
        f.setVisible(true);
        f.setSize(400,400);
    }
}

