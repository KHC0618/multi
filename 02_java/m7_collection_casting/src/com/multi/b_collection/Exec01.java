package com.multi.b_collection;

import java.util.*;

public class Exec01 {
    public static void main(String[] args) {
        // ArrayList는 List중에서도 가장 많이 쓰이는  List이다. 그래서 이번 시간에 다뤄볼 것

        // Vector는 동기화를 제공해준다. --> 두개의 스레드가 동시에 접근한다고 했을 때 한번에 한 스레드가 접근하도록 하니깐 데이터의 안정성을 놓고 봤을 때 좋다.
        //							   하지만 이런 경우는 복수의 사용자가 존재 할 때 좋은 거지
        //							   애초에 한명의 사용자가 사용할 경우 동기화가 필요 없는데도 이를 고려해서 처리하게 되기 때문에 성능의 저하를 가져온다.
        // 이를 보완해서 나온게 ArrayList이다.
        // 근데 왜 아직도 Vector라는 개념이 없어지지 않고 존재하냐라고 한다면 이를 바탕으로 만들어진 프로그램들이 아직 존재하기 때문에 호환성을 위해 남겨놓은 것이다.

        // LinkedList는 데이터와 데이터를 체인처럼 관리하는 것이다.
        // 그래서 특정 인덱스에서 객체를 삭제하거나 추가 할 때 굉장히 편한데
        // 왜냐하면 내가 작업하고자 하는 인덱스의 인스턴스 앞뒤를 자동으로 인지해주고 있어서
        // 내가 해당 인스턴스를 삭제했을 경우 앞뒤의 링크만 연결해주는 작업을 내부적으로 해주기 때문에...
        // 그래서 만약 삭제나 삽입이 좀 자주 일어난다 하는 경우 LinkedList 사용


//        ArrayList a1 = new ArrayList();
//        Vector v1 = new Vector();
//        LinkedList l1 = new LinkedList();

        List a1 = new ArrayList();
        // ArrayList : 데이터 타입 다르고, 크기도 유동적, 순서가 중요
        a1.add("asdf");
        a1.add("asdf");
        a1.add("asdf");
        a1.add(100);
        a1.add(11.1);
        a1.add(true);
        a1.add('s');
        System.out.println(a1);
        System.out.println(a1.size());
        System.out.println(a1.get(3));
        for (int i = 0; i < a1.size(); i++) {
            System.out.println("인덱스 " + i + "번째 a1의 값 : " + a1.get(i));
        }

        a1.remove(1);
        a1.remove(5);

        for (int i = 0; i < a1.size(); i++) {
            System.out.println("인덱스 " + i + "번째 a1의 값 : " + a1.get(i));
        }

        a1.add(2, 200);

        for (int i = 0; i < a1.size(); i++) {
            System.out.println("인덱스 " + i + "번째 a1의 값 : " + a1.get(i));
        }

        System.out.println(a1.indexOf(100));
        System.out.println(a1.indexOf("100"));

        System.out.println(a1.contains("100"));

        for (Object obj : a1) {
            if (obj instanceof String) {
                System.out.println("instanceof String : " + obj);
            }
        }

//        a1.clear();
//        System.out.println(a1);

        /*
         * 1. Hash (hash알고리즘 도입) :
         * 		데이터의 검색 성능 향상을 위해서 사용
         * 		(hashCode와 equals를 모두 오버라이딩 해야한다.)
         *
         * 2. Set
         * 		- 순서유지 안됨, 중복 저장이 되지 않는다.(수학에서의 집합 개념)
         * 		- 종류로는 HashSet, LinkedHashSet, TreeSet이 있다.
         *
         * 3. HashSet
         * 		- 순서가 존재하지 않는다.
         * 		- hashCode()와 equals()가 오버라이딩 되어 있어야 한다.
         *
         * 4. LinkedHashSet
         * 		- 넣는 순서가 유지 된다.
         * 		(hashCode와 equals를 모두 오버라이딩 해야한다.)
         *
         * 5. TreeSet
         * 		- 정렬기준대로 순서가 정해짐(기본 오름차순)
         * 		- hashCode()와 equals()를 오버라이딩 할 필요 없이 알아서 중복저장 되지 않는다.
         * 		- 세팅은 해 주어야 됨(Comparable이나 Comparator 구현 클래스)
         *
         *
         */

        // 중복을 제외하고 싶은 경우 set형 데이터 ==> HashSet

        HashSet s1 = new HashSet();

        for (int i = 0; i < a1.size(); i++) {
            s1.add(a1.get(i));
        }

        System.out.println(s1);
        System.out.println(s1.size());

        Iterator it = s1.iterator();    // Iterrator = 반복자, s1.iterator() 반복자에 담는 과정

        while (it.hasNext()) {   // .hasNext() : 다음이 있는지 물어보는 메소드. 있다면 true, 없다면 false를 반환.
            System.out.println(it.next());  // .next() : 현재 요소를 꺼내온다.
        }

        // map - 매핑시킨다. 연결시킨다.
        // 키 : 밸류의 쌍으로 매핑(연결)시켜서 저장
        /*
         * Map :
         * 데이터를 저장할때 각각의 자료를 구분지을수 있는 고유의 값을 정하여 해당값으로 접근할수 있는 실제 객체를 묶어 함꼐 관리하는 자료 구조 클래스.
         * 해당객체를 저장할때 key(고유의값 ) 은 set 의 특성으로 value(실제객체)는 List 의 특성으로 관리한다.
         * 종류는 크게 HashMap, HashTable(예전버전 -HashMap과 동일 스레드세이프가있다 ), TreeMap, Properties 등이 있다.
         *
         * - map은 key와 value로 구분되어 있고 이걸 로그인 할 때 ID와 PWD처럼 생각하면 편하다.
         *   (ID는 중복 불가능, 즉 Set과 관련이 있음을 알 수 있다.)
         *
         * - key와 value를 묶어서 Entry라고 한다. */

        HashMap map = new HashMap();
        map.put("apple", "사과");
        map.put("melon", "메론");
        map.put("ice", "아이스크림");
        System.out.println(map);
        System.out.println(map.get("apple"));
        map.remove("apple");
        System.out.println(map);

        map.replace("ice", "아이스크림", "초코아이스크림");
        System.out.println(map);
        Set entry = map.entrySet(); // key와 value를 Set 형태로 반환
        System.out.println(entry);

        Iterator it2 = entry.iterator();

        while (it2.hasNext()) {   // .hasNext() : 다음이 있는지 물어보는 메소드. 있다면 true, 없다면 false를 반환.
            System.out.println(it2.next());  // .next() : 현재 요소를 꺼내온다.
        }

        Set key = map.keySet();     // key를 set 형태로 반환
        Iterator<String> it3 = key.iterator();
        while (it3.hasNext()) {
            // System.out.println(it3.next());
            String key1 = it3.next();
            System.out.println(map.get(key1));
        }

        Collection vals = map.values();
        System.out.println(vals);

        Iterator it4 = entry.iterator();
        while (it4.hasNext()) {   // .hasNext() : 다음이 있는지 물어보는 메소드. 있다면 true, 없다면 false를 반환.
            System.out.println(it4.next());  // .next() : 현재 요소를 꺼내온다.
        }

        LinkedList test = new LinkedList();
        test.add("국어");
        test.add("수학");
        test.add("영어");
        test.add("컴퓨터");
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        System.out.println();
        test.remove();
        System.out.println(test);
    }
}
