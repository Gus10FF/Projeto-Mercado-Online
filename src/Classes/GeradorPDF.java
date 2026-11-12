/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

/**
 *
 * @author Gutof
 */
public class GeradorPDF implements Printable {
    private String nomeVendedor;
    private String nomeProduto;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private String comprador;

    public GeradorPDF(String nomeVendedor, String nomeProduto, int quantidade, double valorUnitario, double valorTotal, String comprador) {
        this.nomeVendedor = nomeVendedor;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.comprador = comprador;
    }

    public void gerarComprovantePDF() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);

        if (job.printDialog()) {
            try {
                job.print();
                JOptionPane.showMessageDialog(null, "Comprovante gerado em PDF com sucesso!");
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage());
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int y = 50; 

        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("COMPROVANTE DE VENDA - MERCADO FREE", 50, y);

        y += 20;
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.drawString("--------------------------------------------------------------------------------------------------", 50, y);

        y += 30;
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Vendedor / Loja: ", 50, y);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString(nomeVendedor, 160, y);

        y += 25;
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Comprador: ", 50, y);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString(comprador, 160, y);

        y += 30;
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.drawString("--------------------------------------------------------------------------------------------------", 50, y);

        y += 30;
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("DETALHES DO PEDIDO:", 50, y);

        y += 25;
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("Produto: " + nomeProduto, 50, y);

        y += 20;
        g2d.drawString("Quantidade: " + quantidade, 50, y);

        y += 20;
        g2d.drawString(String.format("Preço Unitário: R$ %.2f", valorUnitario), 50, y);

        y += 30;
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString(String.format("VALOR TOTAL: R$ %.2f", valorTotal), 50, y);

        y += 40;
        g2d.setFont(new Font("Arial", Font.ITALIC, 10));
        g2d.drawString("Obrigado por utilizar a nossa plataforma!", 50, y);

        return PAGE_EXISTS;
    }
}
