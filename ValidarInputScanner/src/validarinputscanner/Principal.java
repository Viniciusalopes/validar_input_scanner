/*
 * A licença MIT
 *
 * Copyright 2019 Viniciusalopes Tecnologia <suporte@viniciusalopes.com.br>.
 *
 * É concedida permissão, gratuitamente, a qualquer pessoa que obtenha uma cópia
 * deste software e dos arquivos de documentação associados (o "Software"), para
 * negociar o Software sem restrições, incluindo, sem limitação, os direitos de uso,
 * cópia, modificação e fusão, publicar, distribuir, sublicenciar e/ou vender cópias
 * do Software, e permitir que as pessoas a quem o Software é fornecido o façam,
 * sujeitas às seguintes condições:
 *
 * O aviso de copyright acima e este aviso de permissão devem ser incluídos em
 * todas as cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "NO ESTADO EM QUE SE ENCONTRA", SEM NENHUM TIPO DE GARANTIA,
 * EXPRESSA OU IMPLÍCITA, INCLUINDO, MAS NÃO SE LIMITANDO ÀS GARANTIAS DE COMERCIALIZAÇÃO,
 * ADEQUAÇÃO A UM FIM ESPECÍFICO E NÃO VIOLAÇÃO. EM NENHUMA CIRCUNSTÂNCIA, OS AUTORES
 * OU PROPRIETÁRIOS DE DIREITOS DE AUTOR PODERÃO SER RESPONSABILIZADOS POR QUAISQUER
 * REIVINDICAÇÕES, DANOS OU OUTRAS RESPONSABILIDADES, QUER EM AÇÃO DE CONTRATO,
 * DELITO OU DE OUTRA FORMA, DECORRENTES DE, OU EM CONEXÃO COM O SOFTWARE OU O USO
 * OU OUTRAS NEGOCIAÇÕES NO PROGRAMAS.
 * ------------------------------------------------------------------------------------------
 * Projeto   : ValidaInput
 * Criado em : 01/11/2019
 * Autor     : Viniciusalopes (Vovolinux) <suporte@viniciusalopes.com.br>
 * Finalidade: Validar inputs utilizando a classe Scanner para os tipos de variáveis mais
               comuns, validar menus de opções em um vetor e validar entradas numéricas 
               em um determinado intervalo.
 * ------------------------------------------------------------------------------------------
 */
package validarinputscanner;

import java.util.Scanner;

// Importa os métodos da classe ValidaInput 
import static util.ValidaInput.*;

// Importa os métodos da classe Textos
import static util.Textos.*;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc;
        String texto;

        sc = new Scanner(System.in);
        //--------------------------------------------------------------------------------
        System.out.println("Exemplo com o método 'string_vazia()'");
        do {
            System.out.println();
            System.out.print("Digite um texto qualquer: ");
            texto = sc.nextLine();

            if (string_vazia(texto)) {
                System.out.println("Texto inválido!");
            } else {
                System.out.println("Texto válido!");
            }
        } while (string_vazia(texto));

        System.out.println(repete("-", 90));

        //--------------------------------------------------------------------------------
        System.out.println("Exemplo com o método 'string_valida()'");
        do {
            System.out.println();
            System.out.print("Digite um texto com mais de 3 caracteres e menos de 5 caracteres: ");
            texto = sc.nextLine();

            if (string_valida(texto, 3, 5)) {
                System.out.println("Texto válido!");
            } else {
                System.out.println("Texto inválido!");
            }
        } while (!string_valida(texto, 3, 5));

        System.out.println(repete("-", 90));

        //--------------------------------------------------------------------------------
        System.out.println("Exemplo com o método 'string_opcao_valida()'");

        // Vetor com as opções válidas
        String[] opcoes = {"SIM", "NAO", "SAIR"};

        // Texto para o prompt
        String prompt = "Digite uma opção: ";

        System.out.println();
        System.out.print("MENU:\n"
                + "  SIM  epara confirmar\n"
                + "  NAO  para negar\n"
                + "  SAIR para sair\n");
        do {
            System.out.println();
            System.out.print(prompt);
            texto = sc.nextLine();

            /*
                Para não validar maiusculas e minúsuculas, basta passar 'false' para o 
                parâmetro case_sensitive.
                Exemplo: 
                    string_opcao_valida(texto, 3, 4, opcoes, false)
             */
            if (string_opcao_valida(texto, 3, 4, opcoes, true)) {
                System.out.printf("'%s' é uma opção válida!\n", texto);
            } else {
                System.out.printf("'%s' Não é uma opção!\n", texto);
                prompt = "Digite SIM, NAO ou SAIR: ";
            }

        } while (!string_opcao_valida(texto, 3, 4, opcoes, true) || !texto.equals("SAIR"));

        System.out.println(repete("-", 90));

        System.out.println();
        System.out.print("Char: ");
        System.out.println((char_valido(sc.nextLine())) ? "CHAR válido!" : "CHAR inválido!");
        System.out.println(repete("-", 90));

        System.out.println();
        System.out.print("Int: ");
        System.out.println((int_valido(sc.nextLine())) ? "INT válido!" : "INT inválido!");
        System.out.println(repete("-", 90));

        System.out.println();
        System.out.print("Double: ");
        System.out.println((double_valido(sc.nextLine())) ? "DOUBLE válido!" : "DOUBLE inválido!");
        System.out.println(repete("-", 90));

        System.out.println();
        System.out.print("Float: ");
        System.out.println((float_valido(sc.nextLine())) ? "FLOAT válido!" : "FLOAT inválido!");
        System.out.println(repete("-", 90));

    }

}
