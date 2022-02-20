public class Songs {
    private String TypeList;
    private String Name;
    private String Time;


    public Songs(String TypeList,String Name,String Time){
        this.TypeList=TypeList;
        this.Name=Name;
        this.Time=Time;
    }

    public String getTypeList() {
        return this.TypeList;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}
