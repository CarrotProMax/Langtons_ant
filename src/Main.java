public class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        BlockStates test = new BlockStates();
        System.out.println(test.isLight());
        test.block_states_alter();
        System.out.println(test.isLight());
    }
}