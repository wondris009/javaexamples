package cz.speedygonzales.designpatterns.decorator;

public abstract class ShapeDecorator implements Shape {
    Shape decoratedShape;

    ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
