package hello.cores.member;

public class Member {
    private Long id;
    private String name;
    private Gradle grade;

    //생성자
    public Member(Long id, String name, Gradle grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Get Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gradle getGrade() {
        return grade;
    }

    public void setGrade(Gradle grade) {
        this.grade = grade;
    }
}