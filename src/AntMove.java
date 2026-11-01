import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class AntMove{
    int antPoint;//1是指向上，2是指向右，3是指向下，4是指向左
    Coordinates coordinates = new Coordinates();
    public AntMove(){
        antPoint=1;
    }
    public AntMove(int antPoint){//设置蚂蚁初始朝向
        this.antPoint = antPoint;
    }
    public void MoveAction(){//向指向角度运动一格
        switch(antPoint){
            case 1:coordinates.setY(coordinates.getY()+1);break;//上移一格
            case 2:coordinates.setX(coordinates.getX()+1);break;//右移一格
            case 3:coordinates.setY(coordinates.getY()-1);break;//下移一格
            case 4:coordinates.setX(coordinates.getX()-1);break;//左移一格
            default: System.out.print("方向范围越界");break;
        }
    }
    public void TurnRight(){
        if(antPoint==4){antPoint=1;}
        else{antPoint=antPoint+1;}
    }
    public void TurnLeft(){
        if(antPoint==1){antPoint=4;}
        else{antPoint=antPoint-1;}
    }
}
