package Model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import Functions.MoneyExConversor;
import Functions.WeatherConversor;
/**
 * @author DigitalITSolutions82
 * @version 1.0
 * Alura Latam ONE G5 - Challenge2: Conversor de Moneda, Temperatura
 */
public class StartApps extends JFrame implements ActionListener {
	private JPanel contentPane;
    private JLabel lblMoney;
    private JLabel lblWeather;
    JButton btnMoneyEx, btnWeather;

	public StartApps() {
		setSize(600, 400);
		setTitle("Conversor Alura Latam - ONE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		StartPanel();
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
        
        JLabel lblTitle = new JLabel("Select an Option");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitle.setBounds(70,30,400,30);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle);
        
        lblMoney = new JLabel("Money Exchange");
        lblMoney.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMoney.setBounds(60,140,200,30);
        lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblMoney);
        
        lblWeather = new JLabel("Weather Conversor");
        lblWeather.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblWeather.setBounds(60,310,220,30);
        lblWeather.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblWeather);
        
        btnMoneyEx = new JButton("");
        btnMoneyEx.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMoneyEx.setBorderPainted(false);
        btnMoneyEx.setOpaque(true);
        btnMoneyEx.setBorder(null);
        btnMoneyEx.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnMoneyEx.setBounds(310,90,150,150);
        btnInsertImage[0] = new InsertImage();
        btnInsertImage[0].createImage(btnMoneyEx, "/images/MoneyEx.png");
        contentPane.add(btnMoneyEx);
        btnMoneyEx.addActionListener(this);
        
        btnWeather = new JButton("");
        btnWeather.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnWeather.setBorderPainted(false);
        btnWeather.setOpaque(true);
        btnWeather.setBorder(null);
        btnWeather.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnWeather.setBounds(310,260,150,150);
        btnInsertImage[1] = new InsertImage();
        btnInsertImage[1].createImage(btnWeather, "/images/Weather2.png");
        contentPane.add(btnWeather);
        btnWeather.addActionListener(this);
        
	}
	public static void main(String[] args) {
		StartApps window = new StartApps();
		window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMoneyEx) {
        	MoneyExConversor moneyconversor = new MoneyExConversor();
         } else if 
           (e.getSource() == btnWeather) {
    	   WeatherConversor weatherconversor = new WeatherConversor();
    	   WeatherInterface weatherinterface = new WeatherInterface();
    	   weatherinterface.setVisible(true);
         }
         this.dispose();
    }
}

