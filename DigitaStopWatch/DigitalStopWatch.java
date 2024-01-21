package DigitaStopWatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DigitalStopWatch extends JFrame implements ActionListener 
{
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int elapsedTime;

    public DigitalStopWatch() 
    {
        timeLabel = new JLabel("00:00:00", JLabel.CENTER);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.green);

        timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        timeLabel.setForeground(Color.black);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.white);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        stopButton.setBackground(Color.blue);
        stopButton.setForeground(Color.white);
        

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setBackground(Color.red);
        resetButton.setForeground(Color.white);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(timeLabel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the timer
        timer = new Timer(1000, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                elapsedTime += 1000;
                updateTimeLabel();
            }
        });
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == startButton) 
        {
            timer.start();
        } 
        else if (e.getSource() == stopButton) 
        {
            timer.stop();
        } 
        else if (e.getSource() == resetButton) 
        {
            timer.stop();
            elapsedTime = 0;
            updateTimeLabel();
        }
    }

    private void updateTimeLabel() 
    {
        int hours = elapsedTime / 3600000;
        int minutes = (elapsedTime % 3600000) / 60000;
        int seconds = (elapsedTime % 60000) / 1000;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }

    public static void main(String[] args) 
    {
        DigitalStopWatch frame = new DigitalStopWatch();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
