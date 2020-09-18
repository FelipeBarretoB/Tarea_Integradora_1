import java.util.Scanner; 

public class T1{
	
	public static Scanner sc= new Scanner(System.in); 
	
	public static final int INFRASTRUCTURE=1300000;
	public static final int WHITEFINISH=2600000;
	public static final int PAINT =980000;
	
	
	
	/**
	*The method gets han int throught the console and returns it <br>
	*<b>pre:</b> the definition of a scanner named sc
	*<b>post: </b>
	*@return int the length that will be used for all the arrays 
	*/
	public static int length(){
		System.out.println("¿Cuantos materiales vas a solocitar?");
		return sc.nextInt();
		
	}
	
	
	/**
	*Fills 3 arrays with there specific values. <br>
	*<b>pre:</b>  the definition of a scanner named sc <br>
	*<b>post: </b> it changes the values of 3 diferent arrays
	*@param n[], array of strings that will hold the names of the products
	*@param c[], array of double that will hold the countity of each product
	*@param us[], array of the enum use that will hold the use of each product
	*/
	
	public static void fillArrays(String[] n, double[] c,use[] us){
		int inter=0;
		for(int i=0; i<n.length; i++){
			System.out.println("\n¿Cual es el nombre del producto?");
			n[i]=sc.next();
			
			
			
			System.out.println("¿Cantidad del producto "+ n[i] +" que desea?");
			c[i]=sc.nextDouble(); 
			
			
			
			
			System.out.println("¿utilización del producto "+ n[i]+" ? 1 para obra negra, 2 para obra blanca y 3 para pintura ");
			inter=sc.nextInt();
			
			if(inter==1){
				us[i]=use.BLACK;
			}else if(inter==2){
				us[i]=use.WHITE;
				
			}else{
				us[i]=use.PAINT; 
			}
			
		}
		System.out.println("\n");
	}
	
	/**
	*Fills 3 arrays with the prices of each store. <br>
	*<b>pre:</b>  the definition of a scanner named sc <br>
	*<b>post: </b> it changes the values of 3 diferent arrays
	*@param pH[], array of double that will hold the prices for HomeCenter
	*@param pB[], array of double that will hold the prices for ferreteria del Barrio
	*@param pC[],  array of double that will hold the prices for ferreteria del centro
	*@param n[], array of strings that holds the names of the products
	*/
	
	public static void prices(double[] pH, double[] pB, double[] pC, String [] n){
			
		for(int c =0; c<pH.length; c++){
			System.out.println("¿Cual es el precio del producto "+ n[c]+" En HomeCenter");
			pH[c]= sc.nextDouble();
			System.out.println("¿Cual es el precio del producto "+ n[c]+" en la Ferrreteria del barrio");
			pB[c]= sc.nextDouble();
			System.out.println("¿Cual es el precio del producto "+ n[c]+" en la Ferreteria del centro");
			pC[c]= sc.nextDouble();
			System.out.println("\n");
		}	
	}
	
	/**
	*asks the user for the ubicaction of the proyect. <br>
	*<b>pre:</b>  the definition of a scanner named sc <br>
	*<b>post: </b>
	*@return returns the ubicaction that the user typed in the console 
	*/
	
	public static ubic setUbic(){
		int inter=0;
		ubic u=ubic.NORTH;
		System.out.println("¿Cual es la ubicacion inmueble?, 1 para norte, 2 para sur, y 3 para centro");
		inter = sc.nextInt();
		
		if(inter==1){
				u=ubic.NORTH;
			}else if(inter==2){
				u=ubic.SOUTH;
				
			}else{
				u=ubic.CENTER; 
			}
		return u; 
		
	}
	
	/**
	*prints the total price for all the products for each store. <br>
	*<b>pre:</b>  
	*<b>post: </b> 
	*@param pFH, total price of HomeCenter
	*@param pFC, total price of Ferreteria del Centro
	*@param pFB, total price of Ferreteria del Barrio
	*@param quantityOfProduct, the quantity of each product
	*@param pH[], array of double that holds the price of each products in HomeCenter
	*@param pB[], array of double that holds the price of each products in Ferreteria del Barrio
	*@param pC[], array of double that holds the price of each products in Ferreteria del Centro
	*@param us[], array of use that holds the use for each products
	*@param ub, ubicaction of the property
	*/
	
	public static void pricesForEachStore(double pFH,double pFC,double pFB, double[] quantityOfProduct, double[] pH, double[] pB, double[] pC, use[] us,ubic ub){
	    boolean white=false;
		boolean black=false; 
		boolean paint=false;
		for(int c=0;c<us.length;c++){
			if(us[c]==use.WHITE){
				white=true;
			}else if(us[c]== use.BLACK){
				black=true;
			}else if(us[c]== use.PAINT){
				paint=true;
			}
			
		
		}	
			
		for(int c=0; c<quantityOfProduct.length; c++){
			pFH+=quantityOfProduct[c]*pH[c];
			pFC+=quantityOfProduct[c]*pC[c];
			pFB+=quantityOfProduct[c]*pB[c];	
			
			
		
		System.out.println("El precio final de HomeCenter es "+ pFH+" pesos");
		System.out.println("El precio final de la Ferreteria del centro es "+ pFC+" pesos");
		System.out.println("El precio final de la Ferreteria del Barrio es "+ pFB+" pesos");
		System.out.println("\n");
		
		
		
		pFH+=delivery (pFH, ub);
		pFC+=delivery (pFC, ub);
		pFB+=delivery (pFB, ub);
		
		
		System.out.println("El precio final de HomeCenter con domicilio es "+ pFH+" pesos");
		System.out.println("El precio final de la Ferreteria del centro con domicilio es "+ pFC+" pesos");
		System.out.println("El precio final de la Ferreteria del Barrio con domicilio es "+ pFB+" pesos");
		System.out.println("\n");
			
		}
		if(white){
			pFH+=WHITEFINISH;
			pFC+=WHITEFINISH;
			pFB+=WHITEFINISH;
		}
		if(black){
			pFH+=INFRASTRUCTURE;
			pFC+=INFRASTRUCTURE;
			pFB+=INFRASTRUCTURE;
		}
		if(paint){
			pFH+=PAINT;
			pFC+=PAINT;
			pFB+=PAINT;
		}
		
		System.out.println("El precio final de HomeCenter con mano de obra  es "+ pFH+" pesos");
		System.out.println("El precio final de la Ferreteria del centro con mano de obra es "+ pFC+" pesos");
		System.out.println("El precio final de la Ferreteria del Barrio con mano de obra es "+ pFB+" pesos");
		System.out.println("\n");
	}
		
		
		
    /**
	*returns the cost of the delivery. <br>
	*<b>pre:</b>  
	*<b>post: </b>
	*@param priceFi, double that holds the cost that will define the cost of the delivery
	*@param ub, enum of ubic class that holds ubication of the property 
	*@return returns the cost of the delivery
	*/
	
	
	public static int delivery (double priceFi,ubic ub){


		if(priceFi>300000){
			//System.out.println("No hay costo de domicilio para compras en mayores a 300000 pesos para ninguna ubicacion del inmueble");
			return 0; 
		}else if(priceFi<300000&&priceFi>80000){
			if(ub==ubic.NORTH){
			
				//System.out.println("El costo de domicilio para el norte es de 28,000 pesos); 
				return 28000; 
			}else if(ub==ubic.SOUTH){
				
				//System.out.println("El costo de domicilio para el sur es de 55,000 pesos"); 
				return 55000;
			}else if(ub==ubic.CENTER){
				//System.out.println("El domicilio no tiene costo en el centro");
				return 0; 
			}
		}else if(priceFi<80000){
			if(ub==ubic.NORTH){
				
				//System.out.println("El costo de domicilio para el norte es de 120,000 pesos");
				return 120000;
			}else if(ub==ubic.SOUTH){
				//System.out.println("El costo de domicilio para el sur es de 50,000 pesos"); 
				return 50000;
			}else if(ub==ubic.CENTER){
				//System.out.println("El costo de domicilio para el centro es de 120,000 pesos");
				return 120000;
				 
			}
		}

	return 0; 

	}		
		
		
	/**
	*prints the total price for all the products for each store. <br>
	*<b>pre:</b>  
	*<b>post: </b> 
	*@param n[], array of Strings that holds the name of the products
	*@param quantity[], array of double that holds the quantity of each product
	*@param pH[], array of double that holds the price of each products in HomeCenter
	*@param pB[], array of double that holds the price of each products in Ferreteria del Barrio
	*@param pC[], array of double that holds the price of each products in Ferreteria del Centro
	*@param us[], array of use that holds the use for each products
	*@param ub, ubicaction of the property
	*/
		
	public static void priceForCheapestStore(String[] n, double[] quantity, double[] pH,double[] pC,double[] pB, use[] us,ubic ub){
		double priceFi=0; 
		double priceH=0;
		double priceC=0;
		double priceB=0;
		boolean white=false;
		boolean black=false; 
		boolean paint=false;
		for(int c=0; c<quantity.length; c++){
			priceH=quantity[c]*pH[c];
			priceC=quantity[c]*pC[c];
			priceB=quantity[c]*pB[c];
			
			if(priceH == priceC && priceB == priceC){
				System.out.println("El material "+n[c]+ " tiene el mismo precio en las 3 tiendas, con un precio de "+priceH+" pesos");
				priceFi+=priceH;
			}else if(priceH<=priceC && priceH<=priceB){
				System.out.println("El material "+n[c]+ " es más economico en HomeCenter con un precio total de "+priceH+" pesos");
				priceFi+=priceH;
			}else if(priceH>=priceC && priceC<=priceB){
				System.out.println("El material "+n[c]+ " es más economico en la Ferreteria del centro con un precio total de "+priceC+" pesos");
				priceFi+=priceC;
			}else{
				System.out.println("El material "+n[c]+ " es más economico en la Ferreteria del barrio con un precio total de "+priceH+" pesos");
				priceFi+=priceB;
			}
		}
		System.out.println("\nEl precio escogiendo siempre la tienda más economica es de "+priceFi+" pesos"); 
		if(priceFi>300000){
			System.out.println("No hay costo de domicilio para compras en mayores a 300000 pesos para ninguna ubicacion del inmueble, el precio final sigue siendo "+priceFi+" pesos");
		}else if(priceFi<300000&&priceFi>80000){
			if(ub==ubic.NORTH){
				priceFi+=28000;
				System.out.println("El costo de domicilio para el norte es de 28,000 pesos, el precio final con domicilio es "+priceFi+" pesos"); 
			}else if(ub==ubic.SOUTH){
				priceFi+=55000;
				System.out.println("El costo de domicilio para el sur es de 55,000 pesos, el precio final con domicilio es "+priceFi+" pesos"); 
			}else if(ub==ubic.CENTER){
				System.out.println("El domicilio no tiene costo en el centro, el precio final con domicilio es "+priceFi+" pesos");
			}
		}else if(priceFi<80000){
			if(ub==ubic.NORTH){
				priceFi+=120000;
				System.out.println("El costo de domicilio para el norte es de 120,000 pesos, el precio final con domicilio es "+priceFi+" pesos");
			}else if(ub==ubic.SOUTH){
				priceFi+=50000;
				System.out.println("El costo de domicilio para el sur es de 50,000 pesos, el precio final con domicilio es "+priceFi+" pesos"); 
			}else if(ub==ubic.CENTER){
				priceFi+=120000;
				System.out.println("El costo de domicilio para el centro es de 120,000 pesos, el precio final con domicilio es "+priceFi+" pesos"); 
			}
		}
		for(int c=0;c<us.length;c++){
			if(us[c]==use.WHITE){
				white=true;
			}else if(us[c]== use.BLACK){
				black=true;
			}else if(us[c]== use.PAINT){
				paint=true;
			}
		}
		if(white){
			priceFi+=WHITEFINISH;	
		}
		
		if(black){
			priceFi+=INFRASTRUCTURE;	
		}
		
		if(paint){
			priceFi+=PAINT;	
		}
		System.out.println("\nEl precio escogiendo siempre la tienda más economica, incluyendo mano de obra y domicilio, es de "+priceFi+" pesos"); 	
	}	
	


	/**
	*prints the total price for all the products for each store. <br>
	*<b>pre:</b>  
	*<b>post: </b> 
	*@param n[], array of Strings that holds the name of the products
	*@param quantity[], array of double that holds the quantity of each product
	*@param us[], array of use that holds the use for each products
	*/
	public static void mostrarUtil(use[] us, String [] n, double[] quantity){
		

		System.out.println("\nMateriales usados en mano de obra negra");
		for(int c=0; c<us.length;c++){
			if(us[c]==use.BLACK){
				System.out.println(n[c]+", con una cantidad de "+quantity[c]);
			}
			
		}
		

		System.out.println("Materiales usados en  mano de obra blanca");
		for(int c=0; c<us.length;c++){
			if(us[c]==use.WHITE){
				System.out.println(n[c]+", con una cantidad de "+quantity[c]);
			}
			
		}
		
		System.out.println("Materiales usados en pintura");
		for(int c=0; c<us.length;c++){
			if(us[c]==use.PAINT){
				System.out.println(n[c]+", con una cantidad de "+quantity[c]);
			}
			
		}
		
		
	}

	
	
	
	public static void main(String [] args){
		
		
		//inputs del problema
		int quantityOfProduct= length(); //la cantidad de materiales que el usuario va a ingresar 
		String [ ] nameOfProduct = new String[quantityOfProduct]; //Lista de los nombres de los materiales que el usuario va a ingresar
		double [ ] quantityAskedFor = new double[quantityOfProduct]; //Lista de la cantidad de cada material que quiere el usuario 
		double[ ] priceHome = new double[quantityOfProduct]; //Lista de precios de cada producto en homeCenter 
		double[ ] priceCentro = new double[quantityOfProduct]; //Lista de precios de cada producto en la ferreteria del centro
		double[ ] priceBarrio = new double[quantityOfProduct]; //Lista de precios de cada producto en la ferreteria del barrio
		use[] us= new use[quantityOfProduct]; //La utilidad de cada material, es decir mano de obra negra, pintura o mano de obra blanca 
		ubic ub= ubic.NORTH; //La ubicacion de la inmueble, esta en NORTE solo como valor inicial
		
		fillArrays(nameOfProduct,quantityAskedFor,us);//metodo que llena los arrglos 
		prices(priceHome,priceBarrio,priceCentro,nameOfProduct); //metodo que llena las listas de precios para cada establesamiento 
		ub= setUbic(); //metodo que consigue la ubicacicion de la inmueble
	
		
		double pH= 0.0;//precio final de homecenteer
		double pC = 0.0;//precio final de la ferreteria del centro
		double pB = 0.0; //precio final de la ferreteria del barrio
		
		//Outputs
		pricesForEachStore(pH,pC,pB,quantityAskedFor,priceHome,priceBarrio,priceCentro,us,ub); //metodo que imprime el precio final por establesamiento
		priceForCheapestStore(nameOfProduct,quantityAskedFor,priceHome,priceCentro,priceBarrio,us,ub);//metodo que imprime el precio final por producto en lugar mas economico
		mostrarUtil(us,nameOfProduct,quantityAskedFor); // metodo que imprime cada material por utilización
	
	
	
	}
}
