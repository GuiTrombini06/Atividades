package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Classe responsável por criar uma aplicação gráfica de calculadora simples,
 * permitindo operações de soma, subtração, multiplicação e divisão.
 *
 * @author Lucas
 * @version 1.0
 */
public class CalculadoraApp {

    /** Instância da classe Calculadora que contém as operações matemáticas. */
    private Calculadora calc = new Calculadora();

    /** Campo de texto para o primeiro número. */
    private JTextField num1;

    /** Campo de texto para o segundo número. */
    private JTextField num2;

    /** Campo de texto para exibir o resultado. */
    private JTextField resultado;

    /**
     * Construtor responsável por inicializar a interface gráfica,
     * criar os componentes, definir ações dos botões e exibir a janela.
     */
    public CalculadoraApp() {
        // Criar janela
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 5, 5));

        // Criar campos de texto
        num1 = new JTextField();
        num2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);

        // Criar botões
        JButton btnSomar = new JButton("+");
        JButton btnSubtrair = new JButton("-");
        JButton btnMultiplicar = new JButton("*");
        JButton btnDividir = new JButton("/");

        /**
         * Listener que trata as ações dos botões e executa a operação matemática
         * correspondente.
         */
        ActionListener acao = e -> {
            try {
                double n1 = Double.parseDouble(num1.getText());
                double n2 = Double.parseDouble(num2.getText());
                double res = 0;

                if (e.getSource() == btnSomar) res = calc.somar(n1, n2);
                else if (e.getSource() == btnSubtrair) res = calc.subtrair(n1, n2);
                else if (e.getSource() == btnMultiplicar) res = calc.multiplicar(n1, n2);
                else if (e.getSource() == btnDividir) res = calc.dividir(n1, n2);

                resultado.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Digite números válidos!");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        };

        // Adicionar eventos aos botões
        btnSomar.addActionListener(acao);
        btnSubtrair.addActionListener(acao);
        btnMultiplicar.addActionListener(acao);
        btnDividir.addActionListener(acao);

        // Adicionar componentes à janela
        frame.add(new JLabel("Número 1:"));
        frame.add(num1);
        frame.add(new JLabel("Número 2:"));
        frame.add(num2);
        frame.add(new JLabel("Resultado:"));
        frame.add(resultado);

        frame.add(btnSomar);
        frame.add(btnSubtrair);
        frame.add(btnMultiplicar);
        frame.add(btnDividir);

        // Ajustar tamanho e exibir
        frame.setLayout(new GridLayout(5, 2, 5, 5));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Método main que inicia a calculadora.
     *
     */
    public static void main(String[] args) {
        new CalculadoraApp();
    }
}
