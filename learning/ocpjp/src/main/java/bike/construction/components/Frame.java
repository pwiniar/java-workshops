package bike.construction.components;

/**
 * Created by Winiar on 21.06.2017.
 */
public class Frame {

    private String frameMaterial;

    public Frame(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "frameMaterial='" + frameMaterial + '\'' +
                '}';
    }
}
