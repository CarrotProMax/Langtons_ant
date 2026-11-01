public class BlockStates{
    private boolean light;//当前格子的状态
    public BlockStates(){//构造方法默认格子是黑色的
         light = false;
    }
    public BlockStates(boolean light){
        this.light = true;
    }
    public void blockStatesAlter(){//将当前格子的状态反转
        light = !light;
    }
    public boolean isLight() {
        return light;
    }
}
