package com.kenny.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        // .class 문법을 이용하여 Class 타입의 인스턴스를 생성
        Class class1 = Account.class;   // Class 타입을 반환시키는 문법. Class 타입은 해당 클래스의 정보를 가지고 있음.
        System.out.println("class1 : " + class1);   // Class 타입의 인스턴스는 해당 클래스의 메타 정보를 가짐

        // Object 클래스의 getClass() 메소드를 이용해서도 Class 타입의 인스턴스 생성 가능
        // Account가 Object의 후손이므로 getClass 사용 가능
        Class class2 = new Account().getClass();    // getClass()는 Object의 메소드
        System.out.println("class2 : " + class2);

        try {
            Class class3 = Class.forName("com.kenny.section02.reflection.Account");
            Class class4 = Class.forName("[D"); // [D : Double 타입의 배열
            Class class5 = double[].class;

            System.out.println("class3 : " + class3);
            System.out.println("class4 : " + class4);
            System.out.println("class5 : " + class5);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 원시 자료형의 경우
//        double d = 1.0;
//        Class class6 = d.getClass();
        // 이렇게는 안 되므로 wrapper 클래스를 사용해야 한다.

        // 원시형 클래스는 TYPE 필드로 반환
        Class class6 = Double.TYPE;
        System.out.println("class6 : " + class6);

        /* 클래스 메타 정보를 이용하여 여러 정보를 반환 받는 메소드가 제공된다. */

        Class superClass = class1.getSuperclass();  // class1 은 Account. Account의 superClass는 Object
        System.out.println("superClass : " + superClass);

        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("modifiers : " + Modifier.toString(field.getModifiers()));
            System.out.println("type : " + field.getType());
            System.out.println("name : " + field.getName());
        }

        Constructor[] constructors = class1.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("name : " + constructor.getName());

            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType : " + param.getTypeName());
            }
        }

        try {
            Account acc = (Account) constructors[0].newInstance("20", "110-234-567890", "1234", 10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 클래스 메타 정보를 이용해 메소드 정보에 접근해보자.
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null; // Method 타입 변수 선언
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            System.out.print(method.getReturnType().getSimpleName() + " ");
            System.out.print(method.getName());

            if("getBalanceMethod".equals(method.getName())) getBalanceMethod = method;
            // 특정 Method 참조
        }

        try {
            System.out.println(getBalanceMethod.invoke(constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}

// 자바에는 reflection 이라는 기능이 있다.
// reflection은 클래스의 객체 정보를 까서, private이든 말든 접근할 수 있고, constructor가 뭔지 등등을 다 알 수 있다.
// 클래스 메타 정보를 가져와서, 그와 관련된 field 값, 생성자 값, 메소드 값에 접근할 수 있다.
// 수 많은 프레임워크, 라이브러리, 테스트 코드에서 이런 기능을 쓴다.
// 스프링 역시 이런 기능을 이용해 우리가 맡긴 bean 객체를 생성, 수행, 호출하고 있다.