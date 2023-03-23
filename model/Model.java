package model;

public class Model {
    private String nameFile;
    private String pathFile;
    private String dataFile;

    public Model(String nameFile, String pathFile, String dataFile){
        this.nameFile = nameFile;
        this.pathFile = pathFile;
        this.dataFile = dataFile;
    }

    /**
     * @return String return the nameFile
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * @param nameFile the nameFile to set
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * @return String return the pathFile
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * @param pathFile the pathFile to set
     */
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * @return String return the dataFile
     */
    public String getDataFile() {
        return dataFile;
    }

    /**
     * @param dataFile the dataFile to set
     */
    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

}