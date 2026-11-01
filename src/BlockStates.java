public class BlockStates{
    private boolean light;//当前格子的状态
    public BlockStates(){
         light = false;
    }
    public void blockStatesAlter(){//将当前格子的状态反转
        light = !light;
    }
    public boolean isLight() {
        return light;
    }
}
