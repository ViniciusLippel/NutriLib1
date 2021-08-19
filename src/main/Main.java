package main;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		Mineral sodio = new Mineral("Sódio");
		Mineral calcio = new Mineral("Cálcio");
		Mineral ferro = new Mineral("Ferro");
		Mineral zinco = new Mineral("Zinco");
		
		Vitamin vA = new Vitamin("A");
		Vitamin vB1 = new Vitamin("B1");
		Vitamin vB2 = new Vitamin("B2");
		Vitamin vC = new Vitamin("C");
		Vitamin vD = new Vitamin("D");
		
		NutriValue vnFeijao = new NutriValue(45, 155).carbs(27).fat(new Fat(0.59, 0, 0)).protein(11);
		vnFeijao.addMineral(sodio, 0.0054);
		vnFeijao.addMineral(calcio, 0.037);
		vnFeijao.addMineral(ferro, 0.003);
		Ingredient feijao = new Ingredient("Feijão", vnFeijao);
		
		
		NutriValue vnArroz = new NutriValue(100, 32).carbs(7.03).fat(new Fat(0.5, 0.5, 0)).protein(0.63);
		vnArroz.addMineral(sodio, 0.00025);
		Ingredient arroz = new Ingredient("Arroz", vnArroz);
		
		Food arrozFeijao = new Food("Arroz e Feijão").nutriValue(vnArroz);
		arrozFeijao.getNutriValue().sum(vnFeijao);
		arrozFeijao.addIngredient(arroz, 50);
		arrozFeijao.addIngredient(feijao, 100);
		arrozFeijao.addIngredient(arroz, 50);
		
		
		NutriValue vnTomate = new NutriValue(100, 21).carbs(5.1).fat(new Fat(0.3, 0, 0)).protein(0.8);
		vnTomate.addVitamin(vA, 0.0012);
		vnTomate.addMineral(sodio, 0.005);
		vnTomate.addMineral(calcio, 0.00732);
		vnTomate.addMineral(ferro, 0.00049);
		Ingredient tomate = new Ingredient("Tomate", vnTomate);
		
		Meal almoco = new Meal("\nAlmoço");
		almoco.addFood(arrozFeijao, 200);
		almoco.addIngredient(tomate, 25);
		almoco.addIngredient(tomate, 25);
		
		//System.out.println(almoco.toString());
		
		System.out.println(almoco.getName()+": ");
		for(int i=0; i<almoco.getFoodList().getFoodList().size(); i++) {
			System.out.println(almoco.getFoodList().getFoodList().get(i).getObject().getName()
					+" "+almoco.getFoodList().getFoodList().get(i).getAmount()+"g");
		}
		for(int i=0; i<almoco.getIngredientList().getIngredientList().size(); i++) {
			System.out.println(almoco.getIngredientList().getIngredientList().get(i).getObject().getName()
					+" "+almoco.getIngredientList().getIngredientList().get(i).getAmount()+"g");
		}
		System.out.println("\n");
		
		double porcao = 100;
		NutriValue nv = almoco.nutriValue(100);
		DecimalFormat f = new DecimalFormat("#0.00");
		System.out.println("Valor Nutricional para "+porcao+"g: ");
		System.out.println("Calorias: "+f.format(nv.getCalories())+"g");
		System.out.println("Carboidratos: "+f.format(nv.getCarbs())+"g");
		
		if(nv.getFat() != null) {
			System.out.println("Gorduras totais: "+f.format(nv.getFat().getTotal())+"g");
			System.out.println("Gorduras saturadas: "+f.format(nv.getFat().getSaturated())+"g");
			System.out.println("Gorduras trans: "+f.format(nv.getFat().getTrans())+"g");
		}
		
		System.out.println("Proteínas: "+f.format(nv.getProtein())+"g");
		
		for(int i=0; i<nv.getMineralList().getMineralList().size(); i++)
			System.out.println(nv.getMineralList().getMineralList().get(i).getObject().getName()
					+": " +f.format(nv.getMineralList().getMineralList().get(i).getAmount()*1000)+" mg");
		
		for(int i=0; i<nv.getVitaminList().getVitaminList().size(); i++)
			System.out.println("Vitamina "+nv.getVitaminList().getVitaminList().get(i).getObject().getName()
					+": " +f.format(nv.getVitaminList().getVitaminList().get(i).getAmount()*1000)+" mg");
		
	}

}
