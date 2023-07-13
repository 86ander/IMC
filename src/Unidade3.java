import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	//método main, implementando a interface action listener

	public class Unidade3 extends JFrame implements ActionListener{
	
	//objetos declarados necessários para o software	
		
	private JLabel lblPeso,lblAltura,lblResultado; 						//labels
	private JTextField txtPeso,txtAltura;								//caixa de texto						
	private JButton btnCalculo;											//botão para cálculo
	private GridBagConstraints restricoes = new GridBagConstraints();	//restrições criadas para gerenciador de layout
	private JPanel pnlDados,pnlBotao,pnlResultado,pnlUnidade;			//painéis
	
	
	//construtor
	
	public Unidade3()
	{
		this.setTitle("Cálculo IMC");									//informações tela
		this.setLocation(500,900);
		this.setSize(600,300);
		this.setResizable(false);
		
		Font f = new Font("SansSerif", Font.PLAIN,20);					//fonte usada
		
		lblPeso=new JLabel("Peso: ",JLabel.RIGHT);						//fonte alinhada a direita
		lblPeso.setFont(f);
		txtPeso=new JTextField(20);										//tamanho caixa de texto
		txtPeso.setFont(f);
		txtPeso.setToolTipText("Informe seu peso");						//dica
		
		lblAltura=new JLabel("Altura: ",JLabel.RIGHT);
		lblAltura.setFont(f);
		txtAltura=new JTextField(20);
		txtAltura.setFont(f);
		txtAltura.setToolTipText("Informe sua altura");
		
		btnCalculo=new JButton("Cálculo IMC");							//botão
		btnCalculo.setFont(f);
		btnCalculo.setToolTipText("Clique aqui para calcular o seu IMC");//dica
		btnCalculo.setMnemonic('C');									//atalho teclado
		btnCalculo.addActionListener(this);								//pbjeto de escuta de click
		
				
		lblResultado=new JLabel("Resultado Índice de Massa Corporal:",JLabel.RIGHT);
		lblResultado.setFont(f);
		
		restricoes.fill=GridBagConstraints.BOTH;						//preenchimento dos campos
		restricoes.insets=new Insets(8,8,8,8);							//margem componentes
		
		//posicionamento dos dados
		
		pnlDados = new JPanel(new GridBagLayout());
		addGridBag(0,0,lblPeso,pnlDados);			//colunas e linhas
		addGridBag(1,0,txtPeso,pnlDados);
		addGridBag(0,1,lblAltura,pnlDados);
		addGridBag(1,1,txtAltura,pnlDados);
		
		pnlBotao = new JPanel(new GridBagLayout());
		addGridBag(0,0,btnCalculo,pnlBotao);
				
		pnlResultado = new JPanel(new GridBagLayout());
		addGridBag(0,0,lblResultado,pnlResultado);
		
		pnlUnidade = new JPanel(new GridBagLayout());
		addGridBag(0,0,pnlDados,pnlUnidade);
		addGridBag(0,1,pnlBotao,pnlUnidade);
		addGridBag(0,2,pnlResultado,pnlUnidade);
		
		Container P=getContentPane();								//adicionar o painel na tela
		P.add(pnlUnidade);
		
	}
	
			//posicionamento dos componentes (coluna, linha, componente inserido, painel a ser inserido)
	
	public void addGridBag(final int x,final int y,final Component obj,final JPanel pnl)
	{
		restricoes.gridx=x;								//coluna
		restricoes.gridy=y;								//linha
		pnl.add(obj, restricoes);						//painel com restrições
	
	}
	
	// ação de evento de clique
		
	public void actionPerformed(ActionEvent evento)
	{
		Object origem=evento.getSource();
		if (origem == btnCalculo)
		{
			float peso, altura, resultado;							//declaração de váriaveis
			peso = Float.parseFloat(txtPeso.getText());				//atribuição
			altura = Float.parseFloat(txtAltura.getText());			//atribuição
			resultado = peso / (altura * altura);					//fórmula
			
			//condicionamento if else
			
			
			if (resultado <= 18.5) {
				lblResultado.setText("Seu IMC é de " + resultado + " ,você esta abaixo do peso");
										
			}else if (resultado >=18.6 && resultado<=24.9) {
				lblResultado.setText("Seu IMC é de " + resultado + " ,seu peso está ótimo");
										
			}else if (resultado >25 && resultado <=29.9) {
				lblResultado.setText("Seu IMC é de " + resultado + " ,você tem sobrepeso");
								
			}else if (resultado >=30 && resultado <=34.9) {
				lblResultado.setText("Seu IMC é de " + resultado + " ,grau de obesidade 1");
				
			}else if (resultado >=35 && resultado <=39.9) {
				lblResultado.setText("Seu IMC é de " + resultado + " ,grau de obesidade 2");
							
			}else {
				lblResultado.setText("Seu IMC é de " + resultado + " ,grau de obesidade 3");
				
			}	
		}
			
	}
		
	//método main e deixar visível com setVisible
	
	public static void main(String[] args) {
		Unidade3 unidade = new Unidade3();
		unidade.setVisible(true);
	}
}