package pragproggroovy.types_and_typing;

public class Car implements Cloneable {

    Engine engine;

    public Object clone() {
        try {
            Car cloned = (Car) super.clone();
            cloned.engine = (Engine) engine.clone();
            return cloned;
        } catch (CloneNotSupportedException cnse) {
            return null;
        }
    }

}

class Engine implements Cloneable {
    public Object clone() {
        return null;
    }
}
