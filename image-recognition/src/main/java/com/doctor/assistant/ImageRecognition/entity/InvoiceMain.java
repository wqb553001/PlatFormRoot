package com.doctor.assistant.ImageRecognition.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_invoice_main")
@Data
public class InvoiceMain implements Serializable {
    @Id
    private String id;
    @Column(name = "log_id")
    private String logId;
    @Column(name = "words_result_num")
    private String wordsResultNum;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Invoice wordsResult;
    private int checked;// 是否校验过:0 未校验（初始值）；1 已校验

    public InvoiceMain() {
        this.wordsResult = new Invoice();
    }
}
