import java.util.Scanner;
class pacman{	

	private static int posicionX, posicionY;
	private static int posicionNPCX, posicionNPCY;


	public static void main(String[] args){

		int[][] unMapa = {
					    {1, 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
                        {1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1,	1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	2,  1,	1,	1,	1,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	2,	1},
                        {1,	4,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	4,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	2,	1,	1,	1,	1,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	2,	1,	1,	1,	1,	2,	1},
                        {1,	2,	2,	2,	2,	2,	2,	1,	2,	2,	2,	2,	2,	1,	1,	2,	2,	2,	2,	2,	1,	2,	2,	2,	2,	2,	2,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	0,	1,	1,	0,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {0,	0,	0,	0,	0,	0,	2,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	2,	0,	0,	0,	0,	0,	0},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	0,	0,	0,	0,	6,	6,	0,	0,	0,	0,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	1,	1,	1,	1,	1,	2,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	2,	1,	1,	1,	1,	1,	1},
                        {1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1,	1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	2,	1,	1,	1,	1,	2,	1},
                        {1,	2,	1,	1,	1,	1,	2,	2,	2,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	2,	2,	2,	1,	1,	1,	1,	2,	1},
                        {1,	4,	2,	2,	1,	1,	2,	1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1,	2,	1,	1,	2,	2,	4,	1},
                        {1,	1,	1,	2,	1,	1,	2,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	2,	1,	1,	2,	1,	1,	1},
                        {1,	1,	1,	2,	1,	1,	2,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	2,	1,	1,	2,	1,	1,	1},
                        {1,	2,	2,	2,	2,	2,	2,	1,	2,	2,	2,	2,	2,	1,	1,	2,	2,	2,	2,	2,	1,	2,	2,	2,	2,	2,	2,	1},
                        {1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1},
                        {1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1,	1,	2,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	2,	1},
                        {1,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	2,	1},
                        {1, 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1}
		};

		posicionX=2; 
		posicionY=2;
		posicionNPCX = 7;
		posicionNPCY = 5;

		do {
			imprimeMapa(unMapa);
		} while (procesaMovimiento(unMapa));
	}

	private static boolean procesaMovimiento(int[][] elMapa){

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;

		inputUsuario = entrada.nextLine();

		elMapa[posicionY][posicionX]=2;
		mueveNPCs(elMapa);


		if (inputUsuario.equals("a") && elMapa[posicionY][posicionX-1]%2==0) {posicionX=posicionX-1;} else 
		if (inputUsuario.equals("d") && elMapa[posicionY][posicionX+1]%2==0) {posicionX=posicionX+1;} else 
		if (inputUsuario.equals("w") && elMapa[posicionY-1][posicionX]%2==0) {posicionY=posicionY-1;} else 
		if (inputUsuario.equals("s") && elMapa[posicionY+1][posicionX]%2==0) {posicionY=posicionY+1;} else 
		if (inputUsuario.equals("f")) { return false;}

		return true;
	}

	private static void mueveNPCs(int[][] elMapa) {
		double movimiento = Math.random();

		if (movimiento<=0.25 && elMapa[posicionNPCY][posicionNPCX-1]%2==0) {posicionNPCX=posicionNPCX-1;} else 
		if (movimiento<=0.5 && elMapa[posicionNPCY][posicionNPCX+1]%2==0) {posicionNPCX=posicionNPCX+1;} else 
		if (movimiento<=0.75 && elMapa[posicionNPCY-1][posicionNPCX]%2==0) {posicionNPCY=posicionNPCY-1;} else 
		if (movimiento<=1 && elMapa[posicionNPCY+1][posicionNPCX]%2==0) {posicionNPCY=posicionNPCY+1;}

	}

	private static void imprimePersonaje(){
		System.out.print(" :v");
	}

	private static void imprimeBordeHorizontal(int laLongitud){

		System.out.print("+");
		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println("+");		
	}

	private static void imprimeBordeVertical(boolean bordeDerecho){
		System.out.print("|");
		if (bordeDerecho) {System.out.println();}
	}

	private static void imprimeMapa(int[][] mapaPorImprimir){

		imprimeBordeHorizontal(mapaPorImprimir[0].length);

		for (int i=0; i<mapaPorImprimir.length; i=i+1){
			imprimeBordeVertical(false);
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
					if (i==posicionY && j==posicionX) {
						imprimePersonaje();
					} else if (i==posicionNPCY && j==posicionNPCX) {
						imprimeNPC();
					} else {
						imprimeElemento(mapaPorImprimir[i][j]);
					}

			}
			imprimeBordeVertical(true);
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);

		System.out.println("Personaje en X:["+posicionX+"] Y:["+posicionY+"]");
	}

	private static void imprimeNPC() {

		System.out.print("^V^");

	}


	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {" . ","[#]","---","333"," * ","555"," @ ","777","   "};

		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

}