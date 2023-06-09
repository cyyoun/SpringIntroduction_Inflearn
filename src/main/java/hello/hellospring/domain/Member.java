package hello.hellospring.domain;

import javax.persistence.*;

@Entity //JPA가 관리하는 엔티티 표시
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY : DB에서 자동으로 인덱스값(시퀀스) 를 생성해줌
    private Long id;
    private String name;

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
}
