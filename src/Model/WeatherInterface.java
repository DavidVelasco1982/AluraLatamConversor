package Model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Functions.WeatherConversor;
import Functions.Start;

public class WeatherInterface extends JFrame implements ActionListener, ItemListener, KeyListener{
	
	private JComboBox<String> cmbBoxWeather1, cmbBoxWeather2;
	private JPanel contentPane;
	private JLabel lblResult, lblTitle, lblConection;
	private JTextField txtConvertValue;
	private JButton btnConvert, btnBack;

	public WeatherInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartPanel();
        setTitle("Conversor Alura Latam - ONE");
        setResizable(false);
        setLocationRelativeTo(null);
	}
	
	private void StartPanel() {
        setBounds(270, 200, 550, 590);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        Color color = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        InsertImage[] btnInsertImage = new InsertImage[3];
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        cmbBoxWeather1 = new JComboBox<String>();
        cmbBoxWeather1.setFont(new Font("Tahoma ", Font.BOLD, 17));
        cmbBoxWeather1.setBounds(160,120,200,30);
        cmbBoxWeather1.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Celsius","Fahrenheit", "Kelvin" }));
        getContentPane().add(cmbBoxWeather1);
        cmbBoxWeather1.addItemListener(this);

        cmbBoxWeather2 = new JComboBox<String>();
        cmbBoxWeather2.setFont(new Font("Tahoma",Font.BOLD, 17));
        cmbBoxWeather2.setModel(new DefaultComboBoxModel<>(new String[]{"Fahrenheit", "Kelvin", "Celsius"}));
        cmbBoxWeather2.setBounds(160,190,200,30);
        getContentPane().add(cmbBoxWeather2);
        cmbBoxWeather2.addItemListener(this);
        
        lblTitle = new JLabel("Weather Conversor");
        lblTitle.setBounds(100, 25, 300, 30);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitle);

        lblConection = new JLabel("To");
        lblConection.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConection.setHorizontalAlignment(SwingConstants.CENTER);
        lblConection.setBounds(230, 160, 30, 20);
        getContentPane().add(lblConection);

        lblResult = new JLabel("Result");
        lblResult.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBounds(140, 330, 260, 30);
        getContentPane().add(lblResult);
        
        btnConvert = new JButton();
        btnConvert.setBorderPainted(true);
        btnConvert.setBounds(220, 230, 80, 80);
        btnConvert.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnConvert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvert.setOpaque(true);
        //btnConvert.setBorder(null);
        btnConvert.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnConvert.addActionListener(this);
        getContentPane().add(btnConvert);
        btnInsertImage[0] = new InsertImage();
        btnInsertImage[0].createImage(btnConvert, "/images/btnConvert2.png");

        btnBack = new JButton("Back");
//      btnBack.setAlignmentY(0.0f);
	    btnBack.setAlignmentX(CENTER_ALIGNMENT);
	    btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnBack.setBorderPainted(false);
	    btnBack.setOpaque(true);
	    btnBack.setBorder(null);
	    btnBack.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
	    btnBack.setBounds(40,350,90,90);
	    btnInsertImage[1] = new InsertImage();
	    btnInsertImage[1].createImage(btnBack, "/images/btnBack.png");
	    btnBack.addActionListener(this);
        contentPane.add(btnBack);
        
        txtConvertValue = new JTextField();
        txtConvertValue.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtConvertValue.setHorizontalAlignment(SwingConstants.CENTER);
        txtConvertValue.setBounds(160, 75, 200, 30);
        getContentPane().add(txtConvertValue);
        txtConvertValue.setColumns(10);
        txtConvertValue.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        WeatherConversor conversion = new WeatherConversor();
        boolean isEmpty = txtConvertValue.getText().isEmpty();
        String result = "Invalid Conversion";

        if (e.getSource() == btnConvert && !isEmpty) {
            try {
                Double valor = Double.parseDouble(txtConvertValue.getText());
                String Weather1 = (String) cmbBoxWeather1.getSelectedItem();
                String Weather2 = (String) cmbBoxWeather2.getSelectedItem();

                switch (Weather1) {
                    case "Celsius":
                        switch (Weather2) {
                            case "Fahrenheit":
                                result = conversion.CelsiuAFahrenheit(valor);
                                break;
                            case "Kelvin":
                                result = conversion.CelsiusAKevin(valor);
                                break;
                        }
                        break;
                    case "Fahrenheit":
                        switch (Weather2) {
                            case "Celsius":
                                result = conversion.FahrenheitACelsius(valor);
                                break;
                            case "Kelvin":
                                result = conversion.FahrenheitAKelvin(valor);
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (Weather2) {
                            case "Celsius":
                                result = conversion.KelvinACelsius(valor);
                                break;
                            case "Fahrenheit":
                                result = conversion.KelvinAFahrenheit(valor);
                                break;
                        }
                        break;
                }
                lblResult.setText(result);
            } catch (NumberFormatException ex) {
                lblResult.setText("Invalid Value");
            }
        } else if (e.getSource() == btnConvert && isEmpty) {
            lblResult.setText("Enter a Value!!");
        } else if (btnBack == e.getSource()) {
            Start start = new Start();
            this.dispose();

        }
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
