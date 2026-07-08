package mx.uam.cua.registry_service.model;

public class FragmentInfo {

    private String nodo;
    private String video;
    private int fragmento;

    public FragmentInfo() {
    }

    public FragmentInfo(String nodo, String video, int fragmento) {
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