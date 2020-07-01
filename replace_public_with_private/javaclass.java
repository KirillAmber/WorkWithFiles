private class someClass {
    private String name;
    private int id;
    private someClass(){
        name = null;
        id = -1;
    }
    private someClass(String name, int id){
        this.name = name;
        this.id = id;
    }
    private String toString(){
        return id + " " + name;
    }
}
