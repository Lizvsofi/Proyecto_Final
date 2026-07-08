package mx.uam.cua.nodo_c.model;

import java.io.Serializable;

public class FragmentMessage implements Serializable {

    private String nodo;
    private String video;
    private int fragmento;

    public FragmentMessage() {
    }

    public FragmentMessage(String nodo, String video, int fragmento) {
        this.nodo = nodo;
        this.video = video;
        this.fragmento = fragmento;
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getFragmento() {
        return fragmento;
    }

    public void setFragmento(int fragmento) {
        this.fragmento = fragmento;
    }
}
