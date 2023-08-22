package Mostrar;

import javax.swing.*;
import java.awt.*;

public class MostrarGrafico extends JFrame {
    private int[][] matrizAdy;
    private String[] vertices;

    public MostrarGrafico(int[][] matrizAdy, String[] vertices) {
        this.matrizAdy = matrizAdy;
        this.vertices = vertices;

        setTitle("Gráfico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };

        getContentPane().add(panel);
    }

    private void drawGraph(Graphics g) {
        int vertexCount = vertices.length;
        int radius = 150;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Dibujar los vértices como círculos
        double angle = 2 * Math.PI / vertexCount;
        for (int i = 0; i < vertexCount; i++) {
            int x = (int) (centerX + radius * Math.cos(i * angle));
            int y = (int) (centerY + radius * Math.sin(i * angle));
            g.setColor(Color.BLUE);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(vertices[i], x - 5, y + 5);
        }

        // Dibujar las aristas
        g.setColor(Color.BLACK);
        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (matrizAdy[i][j] == 1) {
                    int x1 = (int) (centerX + radius * Math.cos(i * angle));
                    int y1 = (int) (centerY + radius * Math.sin(i * angle));
                    int x2 = (int) (centerX + radius * Math.cos(j * angle));
                    int y2 = (int) (centerY + radius * Math.sin(j * angle));
                    g.drawLine(x1, y1, x2, y2);
                } else if (matrizAdy[i][j] > 1) {
                    int x1 = (int) (centerX + radius * Math.cos(i * angle));
                    int y1 = (int) (centerY + radius * Math.sin(i * angle));
                    int x2 = (int) (centerX + radius * Math.cos(j * angle));
                    int y2 = (int) (centerY + radius * Math.sin(j * angle));
                    int weight = matrizAdy[i][j];
                    drawWeightedEdge(g, x1, y1, x2, y2, weight);
                }
            }
        }
    }

    private void drawWeightedEdge(Graphics g, int x1, int y1, int x2, int y2, int weight) {
        // Dibujar una arista con peso
        g.drawLine(x1, y1, x2, y2);
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;
        g.setColor(Color.RED);
        g.drawString(Integer.toString(weight), centerX, centerY);
    }

    public void mostrar() {
        setVisible(true);
    }
}