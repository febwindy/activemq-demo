package me.activemq.demo.domain.model.email;

import java.io.Serializable;

/**
 * Created by _liwenhe on 2015/2/28.
 */
public class EmailObject implements Serializable {
    private String queueName;
    private String callback;
    private Object data;
    private String processName;
    private String ext;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
