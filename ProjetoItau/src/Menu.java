import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Cliente> cliente_x = new ArrayList<Cliente>();
		
		
		boolean menu_list = true;
		
		while (menu_list) {
			System.out.println("Digite a opçao desejada: ");		
			System.out.println(" 1 - Cadastrar Cliente");
			System.out.println(" 2 - Listar Clientes");
			System.out.println(" 3 - Gravar em arquivo");
			System.out.println(" 4 - Consultar arquivo");
			System.out.println(" 5 - Sair");
			
			String opcao = sc.nextLine();
			
			switch(opcao) {
			case "1": {
				System.out.println(" Cadastrar Cliente  ");
				
				System.out.print("Entre com a Agencia: ");
				String agencia = sc.nextLine();
				System.out.println("Entre com a Conta: ");
				String conta = sc.nextLine();
				System.out.println("Entre com o Nome: ");
				String nome = sc.nextLine();
				System.out.println("Entre com o Email: ");
				String email = sc.nextLine();
				System.out.println("Entre com o Telefone: ");
				String telefone = sc.nextLine();
				System.out.println("Entre com o Saldo: ");
				String saldo = sc.nextLine();
				
				Cliente entrada = new Cliente();
				entrada.setAgencia(agencia);
				entrada.setConta(conta);
				entrada.setNome(nome);
				entrada.setEmail(email);
				entrada.setTelefone(telefone);
				entrada.setSaldo(saldo);
				
				cliente_x.add(entrada);
				break;
				
			}
			case "2": {
				System.out.println(" Listar Clientes ");
				for (int i = 0; i < cliente_x.size(); i++) {
					Cliente unico = cliente_x.get(i);
					System.out.println("Cliente: " + i);
					System.out.println("\tAgencia: " + cliente_x.get(i).getAgencia());
					System.out.println("\tConta: " + cliente_x.get(i).getConta());
					System.out.println("\tNome: " + cliente_x.get(i).getNome());
					System.out.println("\tEmail: " + cliente_x.get(i).getEmail());
					System.out.println("\tTelefone: " + cliente_x.get(i).getTelefone());
					System.out.println("\tSaldo: " + cliente_x.get(i).getSaldo());
				}
				break;
			}
			case "3": {
				FileWriter arquivo = new FileWriter("C:\\users\\estev\\Projeto06.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				for (int i = 0; i < cliente_x.size(); i++) {
					Cliente unico = cliente_x.get(i);
					
					for(int registros=0; registros<5; ) {
						gravarArquivo.printf("Clientes Cadastrados %n%n");
						gravarArquivo.printf("Agencia: " + unico.getAgencia());
						gravarArquivo.printf("\tConta: " + unico.getConta());
						gravarArquivo.printf("\tNome: " + unico.getNome());
						gravarArquivo.printf("\tEmail: " + unico.getEmail());
						gravarArquivo.printf("\tTelefone: " + unico.getTelefone());
						gravarArquivo.printf("\tSaldo: " + unico.getSaldo());
						break;
					} 
				}
				arquivo.close();
				System.out.println("Arquivo gravado");
				System.out.println("Arquivo salvo em : C:\\users\\estev\\Projeto06.txt");
				break;
			}
			case "4": {  
			    String mostra="";
			    String nomeArq = "C:\\users\\estev\\Projeto06.txt"; 
			    String linha = "";
			    File arq = new File(nomeArq);
			 
			    if (arq.exists()){ 
			      mostra="Arquivo - '"+nomeArq+"', aberto com sucesso!\n";
			      mostra+="Tamanho do arquivo "+Long.toString(arq.length())+"\n";
			      try{
			        FileReader reader = new FileReader(nomeArq);
			        BufferedReader ler = new BufferedReader(reader);
			        while(true){
			          linha=ler.readLine();
			          if(linha==null)
			            break;
			          mostra+=linha +"\n";
			          System.out.println(linha);
	 
			        }
			      }
			      catch(Exception erro) {}
			      JOptionPane.showMessageDialog(null,mostra,"Arquivo...",1);
			    }
			    else
			      JOptionPane.showMessageDialog(null,"Arquivo não encontrado!","Erro",0);
				break;
		}
			case "5": {
				System.out.print("Sair");
				menu_list = false;
				break;
			}
			default:
				System.out.println("Opção inválida!");
		}

	}

		}
	
}
	