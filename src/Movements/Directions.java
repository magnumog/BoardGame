package Movements;

public enum Directions {
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);

    int verticalVal;
    int horizentalVal;

    Directions(int verticalVal,int horizentalVal) {
        this.verticalVal=verticalVal;
        this.horizentalVal=horizentalVal;
    }

    public int getHorizentalVal() {
        return horizentalVal;
    }

    public int getVerticalVal() {
        return verticalVal;
    }
}
