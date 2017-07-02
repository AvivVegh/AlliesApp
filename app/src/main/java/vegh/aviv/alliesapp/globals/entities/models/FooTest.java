package vegh.aviv.alliesapp.globals.entities.models;

/**
 * Created by aviv on 20/06/2017.
 */

public class FooTest {
    private String test;
    private int position;

    public FooTest(String test, int position) {
        Foo foo = new Foo("t",3);
        foo.getPosition();
        this.test = test;
        this.position = position;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
