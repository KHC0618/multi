package com.multi.algo.a_collection;
//객체 생성시 타입을 정할 수 있음. 형변환 불필요

public class Truck<T1, T2> {
	T1 weight;
	T2 distance;
	
	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", distance=" + distance + "]";
	}
}
