public class SingletonPrinter {
    private static SingletonPrinter printer =new SingletonPrinter();//Early, instance will be created at load time

    private SingletonPrinter(){}

    public static SingletonPrinter getPrinter(){
        return printer;
    }

    public static void main(String args[]){
        getPrinter().hashCode();
    }
}
