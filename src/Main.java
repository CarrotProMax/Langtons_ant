import java.util.HashMap;
//花了十几分钟写了注释，不然以后代码连自己都看不懂了
/*
 *             \  |  /
 *              \ | /
 *            .--\|/--.
 *           (         )
 *           |  =====  |
 *           |  =====  |
 *           |  =====  |
 *            \       /
 *             \     /
 *              \   /
 *               \ /
 *                V
* */
public class Main{
    static HashMap<Coordinates, BlockStates> map;
    public static void main(String[] args) throws Exception {
        map = new HashMap<>();
        AntMove antMove =new AntMove();
        map.put(new Coordinates(antMove.coordinates.getX(),antMove.coordinates.getY()),new BlockStates());//在(0.0)处建立方块状态
        for(int i=0;i<50000;i++){//蚂蚁前进次数可以自行更改测试（O_o
            antMove.MoveAction();
            if(map.containsKey(antMove.coordinates)){//判断当前格子有没有在map中被记录
                if(map.get(antMove.coordinates).isLight()){//记录了就判断当前格子是否是白色
                    antMove.TurnRight();  //白的右转
                }else{
                    antMove.TurnLeft();   //黑的左转
                }
                map.get(antMove.coordinates).blockStatesAlter();//反转格子的颜色
            }else {
                map.put(new Coordinates(antMove.coordinates.getX(),antMove.coordinates.getY()), new BlockStates(true));//没记录创建新的格子
                antMove.TurnLeft();//默认是黑色的所以直接左转
            }
            nowPrint(antMove);
            Thread.sleep(1);//更改蚂蚁跑的速度，sleep是这样的
        }
        System.out.println();
        //要打印的白色格子：    █·
    }
    public static void nowPrint(AntMove antMove){//打印以当前坐标为中心50*50的格子
        System.out.print("\u001B[2J\u001B[H");
        int X = antMove.coordinates.getX()-24;//获取开始打印坐标
        int Y = antMove.coordinates.getY()-24;
        boolean isTrue=true;
        for(int i=0;i<50;i++){//遍历打印
            for(int j=0;j<50;j++){
                if(map.get(new Coordinates(X+i,Y+j))==null){//判断当前格子在不在哈希表中被记录
                    isTrue=false;//没被记录格子就是默认状态黑色
                } else {
                    isTrue=map.get(new Coordinates(X+i,Y+j)).isLight();//写入当前格子状态
                }
                if(isTrue){//因为有些坐标可能没被哈希表记录（map返回值为null），null会引发报错所以单独搞了个boolean变量
                    System.out.print("█ ");
                }else{
                    System.out.print("· ");
                }
            }
            System.out.println();//换行
        }
    }
}