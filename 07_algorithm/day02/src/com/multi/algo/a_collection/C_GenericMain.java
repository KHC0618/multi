package com.multi.algo.a_collection;

public class C_GenericMain {//제너릭프로그램

	public static void main(String[] args) {
			Truck<String, Integer> truck1 = new Truck<String, Integer>();
			
			truck1.distance = 100;
			truck1.weight = "중량무게";
			System.out.println(truck1);
			
			Truck<Double, Double> truck2 = new Truck<Double, Double>();
			truck2.distance = 33.22;
			truck2.weight = 123.56;
			System.out.println(truck2);
	}

}
