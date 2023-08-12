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

import Functions.ConversionSys;
import Functions.Start;

public class MoneyExInterface extends JFrame implements ActionListener, ItemListener, KeyListener  {
	
	private JPanel contentPane;
	private JComboBox<String> comboBoxMoney;
	private JTextField txtValueConvert;
	private JButton btnConvert,btnBack;
	private JLabel lblResult,lblTitle, lblDescript;
	private ConversionSys conversion;

	
    public void asignConversion(ConversionSys conversion){
        this.conversion = conversion;
    }
    
    public MoneyExInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversor Alura Latam - ONE");
        StartPanel();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void StartPanel( ) {
        setBounds(270, 200, 550, 590);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        Color color = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        InsertImage[] btnInsertImage = new InsertImage[3];
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBoxMoney = new JComboBox<String>();
        comboBoxMoney.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxMoney.setBounds(270,150,210,35);
        comboBoxMoney.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Pesos MXN to Dolares", "Pesos MXN to Euros", "Pesos MXN to Libras", "Pesos MXN to Yen", "Pesos MXN to Won-Coreano",
                "Dolares to Pesos MXN", "Euros to Pesos MXN", "Libras to Pesos MXN", "Yen Japones to Pesos MXN", "Won Sul-Coreano to Pesos MXN"
        }));
        comboBoxMoney.setToolTipText("");
        comboBoxMoney.addItemListener(this);
        
        lblTitle = new JLabel("Money Exchange");
        lblTitle.setBounds(100,25,300,30);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblResult = new JLabel("Result");
        lblResult.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblResult.setBounds(150,310,200,30);
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);

        lblDescript = new JLabel("Amount: ");
        lblDescript.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDescript.setBounds(80,120,280,30);
        
        btnConvert = new JButton("Convertir");
        btnConvert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvert.setBorderPainted(false);
        btnConvert.setOpaque(true);
        btnConvert.setBorder(null);
        btnConvert.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnConvert.setBounds(210,200,90,90);
//        btnConvert.setBackground(new Color(255, 199,95));
//        btnInsertImage[0] = new InsertImage();
//        btnInsertImage[0].createImage(btnConvert, "/images/btnConvert2.png");
        btnConvert.addActionListener(this);

        btnBack = new JButton("Back");
//        btnBack.setAlignmentY(0.0f);
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
        
        txtValueConvert = new JTextField();
        txtValueConvert.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtValueConvert.setBounds(50,150,200,35);
        txtValueConvert.addKeyListener(this);
        txtValueConvert.setColumns(10);
        

        contentPane.setLayout(null);
        contentPane.add(lblTitle);
        contentPane.add(comboBoxMoney);
        contentPane.add(txtValueConvert);
        contentPane.add(btnConvert);
        contentPane.add(lblResult);
        contentPane.add(lblDescript);
        contentPane.add(btnBack);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        String divisa = (String) comboBoxMoney.getSelectedItem();
        boolean isEmpty = txtValueConvert.getText().isEmpty();
        if (btnConvert == e.getSource() && !isEmpty) {
            try {
                double amount = Double.parseDouble(txtValueConvert.getText());
                String result = conversion.MoneyExConversor(divisa, amount);
                lblResult.setText(result);
            } catch (Exception ex) {
                lblResult.setText("Error - Invalid Parameter");
            }
        } else if (btnBack == e.getSource()) {
            Start start = new Start();
            this.dispose();
        } else if (isEmpty) {
            lblResult.setText("Enter a Valid Value");

        }
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        boolean numbers = key >= 48 && key <= 59;
        boolean point = key == 46;

        if (!(numbers || point)) {
            e.consume();
        }
		
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
