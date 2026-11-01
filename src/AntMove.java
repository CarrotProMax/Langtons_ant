import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class AntMove extends Coordinates{
    int antPoint;//1是指向上，2是指向右，3是指向下，4是指向左
    public AntMove(){
        antPoint=1;
        super();
    }
    public AntMove(int antPoint){//设置蚂蚁初始朝向
        this.antPoint = antPoint;
        super();
    }
    public void MoveAction(){//向指向角度运动一格
        switch(antPoint){
            case 1:setX(getX()+1);break;
            case 2:setY(getY()+1);break;
            case 3:setX(getX()-1);break;
            case 4:setY(getY()-1);break;
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
