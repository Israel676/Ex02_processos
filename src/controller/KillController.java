package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return "O sistema atual é o "+ os;
	}
	
	public void listaProcessos(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid(String parame) {
		String cmdPid = "TASKKILL /PID";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		pid = Integer.parseInt(parame);
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);
	}
	
	public void mataNome(String param) {
		String cmdNome = "TASKLIST /IM";
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(cmdNome);
		buffer.append(" ");
		buffer.append(param);
	}
	
	
}
