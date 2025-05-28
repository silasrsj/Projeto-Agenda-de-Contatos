package org.example.principal;

import org.example.model.Contato;
import org.example.model.Endereco;
import org.example.model.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class CodigoPrincipal {
    public static void main(String[] args) {
        ArrayList<Contato> listaDeContatos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);


        System.out.println("----- Agenda de Contatos -----");

        boolean sair = false;
        while (!sair) {

            int opcao;
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Adicionar Contato.");
            System.out.println("2 - Listar Contatos.");
            System.out.println("3 - Atualizar Contato.");
            System.out.println("4 - Remover Contato.");
            System.out.println("5 - Sair");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1: {
                    criarContato(teclado, listaDeContatos);
                    break;
                }
                case 2: {
                    listarContatos(listaDeContatos);
                    break;
                }
                case 3: {
                    atualizarContato(teclado, listaDeContatos);
                    break;
                }
                case 4: {
                    removerContato(teclado, listaDeContatos);
                    break;
                }
                case 5: {
                    sair = true;
                    break;
                }
                default: {
                    System.out.println("Opcão inválida, tente novamente.");
                }
            }
        }
    }

    public static Contato lerDados(Scanner teclado) {
        System.out.println("Informe seu nome: ");
        String nome = teclado.nextLine();
        System.out.println("Informe sua idade: ");
        int idade = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Sexo: ");
        String sexo = teclado.nextLine();
        System.out.println("Informe sua data de nascimento (dd/MM/yyyy): ");
        String dataInput = teclado.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataNascimento = formato.parse(dataInput);
            System.out.println("Data de nascimento registrada: " + dataNascimento);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }

        System.out.println("Informe seu telefone: ");
        String telefone = teclado.nextLine();
        System.out.println("Informe seu email: ");
        String email = teclado.nextLine();

        System.out.println("Informe seu bairro: ");
        String bairro = teclado.nextLine();
        System.out.println("Informe a rua: ");
        String rua = teclado.nextLine();
        System.out.println("Informe o número da casa: ");
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Complemento: ");
        String complemento = teclado.nextLine();
        System.out.println("Informe a Cidade: ");
        String cidade = teclado.nextLine();
        System.out.println("Informe o Estado: ");
        String estado = teclado.nextLine();
        Endereco endereco = new Endereco(bairro, rua, numero, cidade, estado, complemento);
        Pessoa pessoa = new Pessoa(nome, idade, sexo, dataInput, endereco);

        return new Contato(telefone, email, pessoa);
    }

    public static void criarContato(Scanner teclado, ArrayList<Contato> listaDeContatos) {
        Contato contato = lerDados(teclado);
        listaDeContatos.add(contato);
        System.out.println("--- Contato adicionado com sucesso! ---");
    }

    public static void listarContatos(ArrayList<Contato> listaDeContatos) {
        if (listaDeContatos.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            listaDeContatos.sort(Comparator.comparing(contato -> contato.getPessoa().getNome()));
            for (Contato contato : listaDeContatos) {
                System.out.println(contato.toString());
            }
        }
    }

    public static void atualizarContato(Scanner teclado, ArrayList<Contato> listaDeContatos) {
        if (listaDeContatos.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            boolean encontrouNome = false;
            while (!encontrouNome) {
                boolean x = false;
                System.out.println("Qual o nome do contato que deseja atualizar? ");
                System.out.println("Escreva (sair) para voltar ao menu principal.");
                String nome = teclado.nextLine();
                if (nome.equalsIgnoreCase("sair")) {
                    break;
                } else {
                    for (int i = 0; i < listaDeContatos.size(); i++) {
                        if (nome.equalsIgnoreCase(listaDeContatos.get(i).getPessoa().getNome())) {
                            Contato contatoAtualizado = lerDados(teclado);
                            listaDeContatos.set(i, contatoAtualizado);
                            System.out.println("--- Contato atualizado com sucesso! ---");
                            encontrouNome = true;
                            break;
                        }
                    }
                    if (!encontrouNome) {
                        System.out.println("--- O contato não existe, tente novamente. ---");
                    }
                }
            }
        }
    }

    public static void removerContato(Scanner teclado, ArrayList<Contato> listaDeContatos) {
        if (listaDeContatos.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            boolean encontrouNome = false;
            while (!encontrouNome) {
                System.out.println("Informe o nome do contato que deseja remover: ");
                System.out.println("Escreva (sair) para voltar ao menu principal.");
                String nome = teclado.nextLine();
                if (nome.equalsIgnoreCase("sair")) {
                    break;
                } else {
                    for (Contato contato : listaDeContatos) {
                        if (nome.equalsIgnoreCase(contato.getPessoa().getNome())) {
                            listaDeContatos.remove(contato);
                            System.out.println("--- Contato removido com sucesso! ---");
                            encontrouNome = true;
                            break;
                        }
                    }
                    if (!encontrouNome) {
                        System.out.println("--- O contato não existe, tente novamente. ---");
                    }
                }
            }
        }
    }
}
