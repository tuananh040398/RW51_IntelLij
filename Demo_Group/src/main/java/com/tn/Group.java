package com.tn;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`group`")
public class Group {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;
    @Column(name = "groupName", length = 5, nullable = false , unique = true)
    private String groupName;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
