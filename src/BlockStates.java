public class BlockStates extends Coordinates {
    private boolean light;//当前格子的状态
    public BlockStates(){
         light = false;
    }
    public void block_states_alter(){//将当前格子的状态反转
        light = !light;
    }
    public boolean isLight() {
        return light;
    }
}
