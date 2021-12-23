package com.atk.infoipl.data;

public class TeamInput {
    private Long external_id;
    private String codeName;
    private String fullName;
    private String status;
    private String intro_year;
    private String last_played_year;

    public TeamInput(Long external_id, String codeName, String fullName, String status, String intro_year,
            String last_played_year) {
        this.external_id = external_id;
        this.codeName = codeName;
        this.fullName = fullName;
        this.status = status;
        this.intro_year = intro_year;
        this.last_played_year = last_played_year;
    }

    public Long getExternal_id() {
        return external_id;
    }

    public void setExternal_id(Long external_id) {
        this.external_id = external_id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntro_year() {
        return intro_year;
    }

    public void setIntro_year(String intro_year) {
        this.intro_year = intro_year;
    }

    public String getLast_played_year() {
        return last_played_year;
    }

    public void setLast_played_year(String last_played_year) {
        this.last_played_year = last_played_year;
    }

    
    

}
