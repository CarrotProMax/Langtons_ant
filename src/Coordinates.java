public class Coordinates {
    private int X;
    private int Y;//设置坐标，下面是get set方法;
    public Coordinates(){
        X=0;
        Y=0;
    }
    public Coordinates(int X,int Y){
        this.X=X;
        this.Y=Y;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setX(int X){
        this.X=X;
    }
    public void setY(int Y){
        this.Y=Y;
    }
}
