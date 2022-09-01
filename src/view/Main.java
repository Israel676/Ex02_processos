package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController killcon = new KillController();
		int op = 0;
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog(" 1- saber o nome do sistema \n 2 - ver lista de processos \n 3 - matar processo por pid \n 4 - matar processo por nome \n 9 - finalizar navegação"));
			switch(op) {
				case 1: String os = killcon.os();
						System.out.println("O sistema atual é o "+ os);
					break;
				case 2: String processo = "TASKLIST /FO TABLE";
						killcon.listaProcessos(processo);
					break;
				case 3: String parame = JOptionPane.showInputDialog("Informe o pid do processo: ");
						killcon.mataPid(parame);
					break;
				case 4: String param = JOptionPane.showInputDialog("Informe o nome do processo: ");
						killcon.mataNome(param);
					break;
				case 9:JOptionPane.showMessageDialog(null,"FINALIZADO ");
					break;
			}
		}
	}

}
