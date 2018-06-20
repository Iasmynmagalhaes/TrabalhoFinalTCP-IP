package Adedonha;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Iasmyn Magalhaes e Denys Maciel
 */

public class Cliente {
    
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        Socket client = new Socket("localhost", 60000);
        
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        DataOutputStream dataOutput = new DataOutputStream(client.getOutputStream());
        
        System.out.print("Por favor, digite seu nome: ");
        String nomeCliente = sc.nextLine();
        String nomeEnviado = nomeCliente + "\n";
        dataOutput.writeBytes(nomeEnviado);
        dataOutput.flush();
        
        String letra = input.readLine();
        System.out.println("Letra sorteada: "+letra);
        
        String[] respostas = new String[3];
        
        String nome, lugar, objeto;
        System.out.print("Digite um nome com a letra "+letra+": ");
        nome = sc.nextLine();
        System.out.print("Digite um lugar com a letra "+letra+": ");
        lugar = sc.nextLine();
        System.out.print("Digite um objeto com a letra "+letra+": ");
        objeto = sc.nextLine();
        
        respostas[0] = nome;
        respostas[1] = lugar;
        respostas[2] = objeto;
        
        output.writeObject(respostas);
        output.flush();
        
        sc.close();
        client.close();
    }
    
    
}
