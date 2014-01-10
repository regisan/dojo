package com.tr.dojo003;

import java.util.List;

public class CampoMinado {
	public int[][] resolverCampoMinado(int m, int n,
			List<Coordenada> coordenadas) {

		int[][] campoMinado = new int[m][n];

		for (Coordenada c : coordenadas) {
			campoMinado[c.x][c.y] = -1;
		}

		for (Coordenada coord : coordenadas) {
			Coordenada a = new Coordenada(coord.x - 1, coord.y - 1);
			Coordenada b = new Coordenada(coord.x - 1, coord.y);
			Coordenada c = new Coordenada(coord.x - 1, coord.y + 1);
			Coordenada d = new Coordenada(coord.x, coord.y - 1);
			Coordenada e = new Coordenada(coord.x, coord.y + 1);
			Coordenada f = new Coordenada(coord.x + 1, coord.y - 1);
			Coordenada g = new Coordenada(coord.x + 1, coord.y);
			Coordenada h = new Coordenada(coord.x + 1, coord.y + 1);

			if (!a.isForaDoRange(m, n) && campoMinado[a.x][a.y] != -1) {
				campoMinado[a.x][a.y] = campoMinado[a.x][a.y] + 1;
			}
			if (!b.isForaDoRange(m, n) && campoMinado[b.x][b.y] != -1) {
				campoMinado[b.x][b.y] = campoMinado[b.x][b.y] + 1;
			}
			if (!c.isForaDoRange(m, n) && campoMinado[c.x][c.y] != -1) {
				campoMinado[c.x][c.y] = campoMinado[c.x][c.y] + 1;
			}
			if (!d.isForaDoRange(m, n) && campoMinado[d.x][d.y] != -1) {
				campoMinado[d.x][d.y] = campoMinado[d.x][d.y] + 1;
			}
			if (!e.isForaDoRange(m, n) && campoMinado[e.x][e.y] != -1) {
				campoMinado[e.x][e.y] = campoMinado[e.x][e.y] + 1;
			}
			if (!f.isForaDoRange(m, n) && campoMinado[f.x][f.y] != -1) {
				campoMinado[f.x][f.y] = campoMinado[f.x][f.y] + 1;
			}
			if (!g.isForaDoRange(m, n) && campoMinado[g.x][g.y] != -1) {
				campoMinado[g.x][g.y] = campoMinado[g.x][g.y] + 1;
			}
			if (!h.isForaDoRange(m, n) && campoMinado[h.x][h.y] != -1) {
				campoMinado[h.x][h.y] = campoMinado[h.x][h.y] + 1;
			}
		}

		return campoMinado;
	}
	
	public String imprimeMatriz(int[][] matriz, int m, int n){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				sb.append(matriz[i][j] == -1 ? "*" : matriz[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

class Coordenada {
	int x;
	int y;

	public Coordenada(int a, int b) {
		x = a;
		y = b;
	}

	public boolean isForaDoRange(int m, int n) {
		return x < 0 || y < 0 || x >= m || y >= n;
	}
}
