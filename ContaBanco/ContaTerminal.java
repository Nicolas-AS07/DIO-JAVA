import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args) throws Exception{
        Scanner resposta = new Scanner(System.in);

        System.out.println("Digete o número: ");
        int numero = resposta.nextInt();
        resposta.nextLine(); 

        System.out.println("Digite sua agência: ");
        String agencia = resposta.nextLine();

        System.out.println("Digite seu saldo: ");
        float saldo = resposta.nextFloat();
        resposta.nextLine(); 

        System.out.println("Digite seu Nome: ");
        String nome = resposta.nextLine();

        System.out.println("Olá senhor "+nome+", obrigado por criar uma conta em nosso banco, sua agência é "+agencia+", conta "+numero+
        " e seu saldo "+saldo+" ja está disponivel para saque");

        

        resposta.close();
    }
}
