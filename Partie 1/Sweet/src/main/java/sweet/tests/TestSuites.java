package sweet.tests;



import sweet.suites.*;

public class TestSuites {

	public static void testEtape2() {
		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites explicites (Etape 2)                  *");                        
		Fonction fonction=null;
		try {
			fonction=new Fonction("n+(3*n*n)");
		}catch (Exception e) {};
		Suite suite=new SuiteExplicite("u[n]=n+(3*n*n)",fonction);
		suite.calculeEtAffiche(9);
		try {
			fonction=new Fonction("10*cos(n)+n");
		}catch (Exception e) {};
		suite=new SuiteExplicite("u[n]=10*cos(n)+n",fonction);
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");
	}

	public static void testEtape7() {
		SuiteRecurrente suite=null;

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites arithmétiques (Etape 7)               *");
		suite=new SuiteArithmetique("u[0]=10;u[n+1]=u[n]+5",10,5);
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites géométriques (Etape 7)                *");
		suite=new SuiteGeometrique("u[0]=20;u[n+1]=1.5*u[n]",20,1.5);
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites arithmético-géométriques (Etape 7)    *");
		suite=new SuiteArithmeticoGeometrique("u[0]=20;u[n+1]=1.5*u[n]+10",20,1.5,10);
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites linéaires (Etape 7)                   *");
		suite=new SuiteLineaire("u[0]=10;u[1]=2;u[2]=3;u[n+3]=0.75*u[n]+1*u[n+1]-0.83*u[n+2]",new double[] {10,2,3},new double[] {0.75,1,-0.83});
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur la suite de Fibonnaci (Etape 7)                   *");
		suite=new SuiteFibonacci();
		suite.calculeEtAffiche(9);
		System.out.println("***************************************************************");

		System.out.println("***************************************************************");
		System.out.println("=> Tests sur les suites logistiques (Etape 7)                   *");
		try {
			suite=new SuiteLogistique("u[0]=0.8;u[n+1]=0.4*u[n]*(1-u[n])",0.8,0.4);
			suite.calculeEtAffiche(9);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			suite=new SuiteLogistique("u[0]=2;u[n+1]=0.4*u[n]*(1-u[n])",2,0.4);
			suite.calculeEtAffiche(9);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			suite=new SuiteLogistique("u[0]=0.8;u[n+1]=28*u[n]*(1-u[n])",0.8,28);
			suite.calculeEtAffiche(9);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("***************************************************************");
	}

	public static void main(String[] args) {
		System.out.println("Quelques tests sur la création et le calcul de suites ...");
		testEtape2();
		testEtape7();
	}

}
