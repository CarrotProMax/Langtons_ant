import java.util.HashMap;

public class Main{
    static HashMap<Coordinates, BlockStates> map;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        map = new HashMap<>();
        AntMove antMove =new AntMove();
        map.put(new Coordinates(antMove.coordinates.getX(),antMove.coordinates.getY()),new BlockStates());//在(0.0)处建立方块状态
        for(int i=0;i<50000;i++){
            antMove.MoveAction();
            if(map.containsKey(antMove.coordinates)){
                if(map.get(antMove.coordinates).isLight()){//判断当前格子是否是白色
                    antMove.TurnRight();  //白的右转
                }else{
                    antMove.TurnLeft();   //黑的左转
                }
                map.get(antMove.coordinates).blockStatesAlter();//反转格子的颜色
            }else {
                map.put(antMove.coordinates, new BlockStates());//创建新的格子
                antMove.TurnLeft();//默认是黑色的所以直接左转
            }
            Thread.sleep(50);
        }
        //要打印的白色格子：    █·
    }
    public static void nowPrint(AntMove antMove){
        System.out.print("\033[H\033[2J");
        int X = antMove.coordinates.getX()-24;
        int Y = antMove.coordinates.getY()-24;
        boolean isTrue=true;
        for(int i=0;i<50;i++){
            for(int j=0;j<50;j++){
                if(map.get(new Coordinates(X+i,Y+j))==null){
                    isTrue=false;
                } else {
                    isTrue=map.get(new Coordinates(X+i,Y+j)).isLight();
                }
                if(isTrue){
                    System.out.print("· ");
                }else{
                    System.out.print("█ ");
                }
            }
            System.out.println();
        }
    }
}