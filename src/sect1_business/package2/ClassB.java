package sect1_business.package2;

public class ClassB {

    // Em qualquer canto que possua uma instancia da ClassB:
    public void publicMethod() {
        System.out.println("This is a public method of ClassB");
        privateMethod();
        protectedMethod();
        packageProtected();
    }

    // Apenas na classe que possue o method:
    private void privateMethod() {
        System.out.println("This is a private method of ClassB");
    }

    // Pode ser acessado dentro da propria classe ou em classes no mesmo package:
    protected void protectedMethod() {
        System.out.println("This is a protected method of ClassB");
    }

    void packageProtected() {
        System.out.println("This is a package protected method of ClassB");
    }
}
