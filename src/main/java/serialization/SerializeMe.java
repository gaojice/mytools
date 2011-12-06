package serialization;

import java.io.Serializable;

class SerializeMe implements Serializable {
    private static final long serialVersionUID = 11L;

    private int data;

    public SerializeMe (int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

}
