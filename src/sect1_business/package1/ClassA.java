package sect1_business.package1;

import sect1_business.package2.ClassB;

public class ClassA {

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethod();
        // classB.privateMethod();
        // classB.protectedMethod();
        // classB.packageProtected();
    }
}
