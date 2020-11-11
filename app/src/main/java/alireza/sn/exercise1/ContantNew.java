package alireza.sn.exercise1;

class ContantNew {
    private String date;
    private int id, idImage;

    public ContantNew(String date, int id, int idImage) {
        this.date = date;
        this.id = id;
        this.idImage = idImage;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getIdImage() {
        return idImage;
    }
}
