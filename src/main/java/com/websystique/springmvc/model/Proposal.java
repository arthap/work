package com.websystique.springmvc.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sevak on 8/20/17.
 */
@Entity
@Table(name = "proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Worker workerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "proposal_date")
    private Date proposalDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }


    public Date getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Date proposalDate) {
        this.proposalDate = proposalDate;
    }
}
