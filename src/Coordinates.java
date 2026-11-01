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
    @Override
    public int hashCode(){//重写哈希值计算方法，因为原来的方法是随机赋值
        int result = 1;
        result = 31 * result + X;
        result = 31 * result + Y;
        return result;//这里网上搜的说没有默认的hash写法，不过大家都这么写，我也这么写了O_o
    }
    @Override
    public boolean equals(Object obj) {//重写比较方法
        if (this == obj) {//判断传入类是不是自己
            return true;
        }
        if (obj == null) {//判断传入值是否为null
            return false;
        }
        if (getClass() != obj.getClass()) {//判断类型是不是相同
            return false;
        }
        Coordinates other = (Coordinates) obj;
        return this.X == other.X && this.Y == other.Y;  //只对 X、Y进行比较
    }
}
