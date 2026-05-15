package GetSetAndSerializationAndDeserialization;

import Base.TestBase;

import java.util.List;

public class GetAndSetMethods extends TestBase {

    public String userName;
    public String userJob;
    List<String> courses;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserJob()
    {
        return userJob;
    }

    public void setUserJob(String userJob)
    {
        this.userJob = userJob;
    }

    public List<String> getCourses()
    {
        return courses;
    }

    public void setCourses(List<String> courses)
    {
        this.courses = courses;
    }

    public String getUserRecord()
    {
        return (this.userName + " " + this.userJob + " " + this.courses);
    }
}
